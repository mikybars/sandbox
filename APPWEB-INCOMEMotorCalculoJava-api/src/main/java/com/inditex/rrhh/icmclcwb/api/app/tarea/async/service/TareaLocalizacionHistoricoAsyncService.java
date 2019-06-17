package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;

import javax.validation.constraints.NotNull;

@Async("repositoryPrimaryExecutor")
public interface TareaLocalizacionHistoricoAsyncService {

	CompletableFuture<Void> save(final List<TareaLocalizacionHistoricoDto> tareaLocalizacionHistorico, final TareaDto tarea);
    
    CompletableFuture<Void> saveGenericTiendaResultItemDto(final List<GenericTiendaResultItemDto> genericTiendaResultItemDto, final TareaDto tarea);

}
