package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.constraints.NotNull;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;

@Async("repositoryPrimaryExecutor")
public interface TareaLocalizacionFestivoAsyncService {

    CompletableFuture<Void> save(@NotNull List<GenericTiendaResultItemDto> src, @NotNull TareaDto tareaDto);

    CompletableFuture<Void> saveHorarioComercialFestivo(@NotNull List<HorarioComercialFestivoDocDto> src,
            @NotNull TareaDto tarea);

}
