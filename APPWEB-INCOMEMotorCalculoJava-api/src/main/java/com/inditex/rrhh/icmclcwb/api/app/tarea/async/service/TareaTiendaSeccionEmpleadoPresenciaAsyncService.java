package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;

import java.util.concurrent.CompletableFuture;



import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaSeccionEmpleadoPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResultItemDto;

@Deprecated
@Async("repositoryPrimaryExecutor")
public interface TareaTiendaSeccionEmpleadoPresenciaAsyncService {

    CompletableFuture<Void> save(TareaTiendaSeccionEmpleadoPresenciaDto dto);

    CompletableFuture<Void> save(List<PtrPresenciaDetalleComisionableResultItemDto> dtos, TareaDto tareaDto);

}
