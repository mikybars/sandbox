package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarSlrhorcomsService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionFestivoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto.SlrhorcomsPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.service.SlrHorarioComercialAsyncService;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.service.SlrHorarioComercialService;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.util.HorarioComercialPropertiesConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;

@Service
@Validated
public class RunTareaAmbitoRecolectarSlrhorcomsServiceImpl implements RunTareaAmbitoRecolectarSlrhorcomsService {

    @Autowired
    private TareaMapper tareaMapper;

    @Autowired
    private SlrHorarioComercialService slrHorarioComercialService;

    @Autowired
    private SlrHorarioComercialAsyncService slrHorarioComercialAsyncService;

    @Autowired
    private TareaLocalizacionFestivoAsyncService tareaLocalizacionFestivoAsyncService;

    @Autowired
    @Qualifier("slrhorcomsProperties")
    private Map<String, SlrhorcomsPropertiesDto> slrhorcomsProperties;

    @Override
    public void horarioComercialFestivoByRunTareaAndTareaAmbito(
            @Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        final List<CompletableFuture<?>> cf = new ArrayList<>();
        final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            final HorarioComercialFestivosRequestDto request = this.tareaMapper
                .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoDtoToHorarioComercialFestivosRequestDto(trabajo,
                        tarea, tareaAmbito);
            request.setRows(
                    this.slrhorcomsProperties.get(HorarioComercialPropertiesConstants.HORARIO_COMERCIAL_FESTIVO)
                        .getRows());
            boolean hasNext;
            do {
                final CompletableFuture<List<HorarioComercialFestivoDocDto>> cfHorarioComercialFestivos = this.slrHorarioComercialAsyncService
                    .horarioComercialFestivos(request);
                AsyncUtils.exceptionally(cfHorarioComercialFestivos, cf);
                final List<HorarioComercialFestivoDocDto> data = AsyncUtils
                    .get(cfHorarioComercialFestivos);
                if (CollectionUtils.isNotEmpty(data)) {
                    final CompletableFuture<Void> cfSave = this.tareaLocalizacionFestivoAsyncService
                        .saveHorarioComercialFestivo(data, tarea);
                    AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                }
                hasNext = request.isHasNext();
            } while (hasNext);
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (final Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

}
