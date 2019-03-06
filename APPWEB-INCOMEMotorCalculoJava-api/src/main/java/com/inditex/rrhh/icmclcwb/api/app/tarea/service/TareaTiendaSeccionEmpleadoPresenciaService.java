package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaSeccionEmpleadoPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResultItemDto;

public interface TareaTiendaSeccionEmpleadoPresenciaService {

	CompletableFuture<Void> save(@Valid final TareaTiendaSeccionEmpleadoPresenciaDto item);

    CompletableFuture<Void> save(final List<PtrPresenciaDetalleComisionableResultItemDto> item, final TareaDto tarea);

}
