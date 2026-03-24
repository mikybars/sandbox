package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarIopcomercialcalendarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionFestivoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaEstructuraService;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.dto.IopcomercialcalendarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.dto.ResponseDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.horariocomercialfestivo.dto.HorarioComercialFestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.service.IOPComercialCalendarAsyncService;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.util.HorarioComercialPropertiesConstants;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaAmbitoRecolectarIopcomercialcalendarServiceImpl implements RunTareaAmbitoRecolectarIopcomercialcalendarService {

  private static final Logger LOG = LoggerFactory.getLogger(RunTareaAmbitoRecolectarIopcomercialcalendarServiceImpl.class);

  private final TareaMapper tareaMapper;

  private final IOPComercialCalendarAsyncService iopComercialCalendarAsyncService;

  private final TareaLocalizacionFestivoAsyncService tareaLocalizacionFestivoAsyncService;

  private final TareaLocalizacionHistoricoService tareaLocalizacionHistoricoService;

  private final TareaAmbitoGlobalEmpresaService tareaAmbitoGlobalEmpresaService;

  private final TareaPersonaEstructuraService tareaPersonaEstructuraService;

  private final Map<String, IopcomercialcalendarPropertiesDto> iopcomercialcalendarProperties;

  @Override
  public void horarioComercialFestivoByRunTareaAndTareaAmbito(
      @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TrabajoDTO trabajo = runTarea.getTrabajo();
      final TareaDto tarea = runTarea.getTarea();
      if (Boolean.TRUE.equals(this.tareaPersonaEstructuraService.calcularFestivos(tarea))) {
        final List<String> empresasAmbito = this.tareaAmbitoGlobalEmpresaService
            .findIdEmpresaByIdTarea(tarea.getId())
            .stream()
            .map(IdEmpresaDto::getStdIdLegEnt)
            .toList();
        for (final List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
            this.tareaLocalizacionHistoricoService
                .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(tarea.getId(),
                    tareaAmbito.getCclIdOrigen(), empresasAmbito),
            this.iopcomercialcalendarProperties.get(HorarioComercialPropertiesConstants.HORARIO_COMERCIAL_FESTIVO)
                .getMaxFilterSize())) {

          final HorarioComercialFestivosRequestDto request = this.tareaMapper
              .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoDtoToHorarioComercialFestivosRequestDto(trabajo,
                  tarea, tareaAmbito);
          request
              .setIdTienda(iter.stream().map(IdLocalizacionLocalDto::getId).toList());
          RunTareaAmbitoRecolectarIopcomercialcalendarServiceImpl.LOG.info("Peticion de festivos: {}", request);
          final CompletableFuture<ResponseDto<HorarioComercialFestivoDocDto>> cfHorarioComercialFestivos =
              this.iopComercialCalendarAsyncService
                  .horarioComercialFestivos(request);
          AsyncUtils.exceptionally(cfHorarioComercialFestivos, cf);
          final ResponseDto<HorarioComercialFestivoDocDto> data = AsyncUtils
              .get(cfHorarioComercialFestivos);
          final List<HorarioComercialFestivoDocDto> festivos = data.getData();

          if (CollectionUtils.isNotEmpty(festivos)) {
            final CompletableFuture<Void> cfSave = this.tareaLocalizacionFestivoAsyncService
                .save(data.getData(), tarea);
            AsyncUtils.exceptionally(cfSave, cf, cfPersist);
          }

        }
      }
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

}
