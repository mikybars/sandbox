package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;

@Async("repositoryPrimaryExecutor")
public interface TareaTiendaComisionHistoricoAsyncService {

    CompletableFuture<Void> save(List<TareaTiendaComisionHistoricoDto> tareaTiendaComisionHistoricoDto,
            @Valid TareaDto tarea);

    CompletableFuture<Void> saveGenericTiendaResultItemDto(List<GenericTiendaResultItemDto> genericTiendaResultItemDto,
            @Valid TareaDto tarea);

}
