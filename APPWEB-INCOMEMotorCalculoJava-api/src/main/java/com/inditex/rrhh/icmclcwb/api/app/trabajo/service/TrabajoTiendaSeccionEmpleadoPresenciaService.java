package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaSeccionEmpleadoPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResultItemDto;

public interface TrabajoTiendaSeccionEmpleadoPresenciaService {

	CompletableFuture<Void> save(@Valid final TrabajoTiendaSeccionEmpleadoPresenciaDto dto);

    CompletableFuture<Void> save(List<PtrPresenciaDetalleComisionableResultItemDto> dtos, TrabajoDto trabajoDto);

}
