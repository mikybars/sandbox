package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarSlrhorcomsService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionFestivoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaEstructuraService;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto.ResponseDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto.SlrhorcomsPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.service.SlrHorarioComercialAsyncService;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.service.SlrHorarioComercialService;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.util.HorarioComercialPropertiesConstants;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaAmbitoRecolectarSlrhorcomsServiceImpl implements RunTareaAmbitoRecolectarSlrhorcomsService {

  private static final Logger LOG = LoggerFactory.getLogger(RunTareaAmbitoRecolectarSlrhorcomsServiceImpl.class);

  private final TareaMapper tareaMapper;

  private final SlrHorarioComercialService slrHorarioComercialService;

  private final SlrHorarioComercialAsyncService slrHorarioComercialAsyncService;

  private final TareaLocalizacionFestivoAsyncService tareaLocalizacionFestivoAsyncService;

  private final TareaLocalizacionHistoricoService tareaLocalizacionHistoricoService;

  private final TareaAmbitoGlobalEmpresaService tareaAmbitoGlobalEmpresaService;

  private final TareaPersonaEstructuraService tareaPersonaEstructuraService;

  private final Map<String, SlrhorcomsPropertiesDto> slrhorcomsProperties;

  @Override
  public void horarioComercialFestivoByRunTareaAndTareaAmbito(
      @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito) {
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
            .collect(Collectors.toList());
        for (final List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
            this.tareaLocalizacionHistoricoService
                .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(tarea.getId(),
                    tareaAmbito.getCclIdOrigen(), empresasAmbito),
            this.slrhorcomsProperties.get(HorarioComercialPropertiesConstants.HORARIO_COMERCIAL_FESTIVO)
                .getMaxFilterSize())) {
          boolean hasNext;
          int start = 0;
          do {
            final HorarioComercialFestivosRequestDto request = this.tareaMapper
                .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoDtoToHorarioComercialFestivosRequestDto(trabajo,
                    tarea, tareaAmbito);
            request.setRows(
                this.slrhorcomsProperties
                    .get(HorarioComercialPropertiesConstants.HORARIO_COMERCIAL_FESTIVO)
                    .getRows());
            request
                .setIdTienda(iter.stream().map(IdLocalizacionLocalDto::getId).collect(Collectors.toList()));
            request.setStart(start);
            RunTareaAmbitoRecolectarSlrhorcomsServiceImpl.LOG.info("Peticion de festivos: {}", request);
            final CompletableFuture<ResponseDto<HorarioComercialFestivoDocDto>> cfHorarioComercialFestivos =
                this.slrHorarioComercialAsyncService
                    .horarioComercialFestivos(request);
            AsyncUtils.exceptionally(cfHorarioComercialFestivos, cf);
            final ResponseDto<HorarioComercialFestivoDocDto> data = AsyncUtils
                .get(cfHorarioComercialFestivos);
            if (CollectionUtils.isNotEmpty(data.getDocs())) {
              final CompletableFuture<Void> cfSave = this.tareaLocalizacionFestivoAsyncService
                  .save(data.getDocs(), tarea);
              AsyncUtils.exceptionally(cfSave, cf, cfPersist);
            }
            hasNext = data.isHasNext();
            start = data.getNext();
          } while (hasNext);
        }
      }
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

}
