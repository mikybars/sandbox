package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResultItemDto;

public interface TareaTiendaEmpleadoPresenciaSeccionAsyncService {

    CompletableFuture<Void> save(List<PtrPresenciaDetalleComisionableResultItemDto> dtos, TareaDto tareaDto);

}
