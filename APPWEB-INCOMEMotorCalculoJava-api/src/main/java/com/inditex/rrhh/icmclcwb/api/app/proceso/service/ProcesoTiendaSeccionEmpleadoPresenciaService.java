package com.inditex.rrhh.icmclcwb.api.app.proceso.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaSeccionEmpleadoPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResultItemDto;

public interface ProcesoTiendaSeccionEmpleadoPresenciaService {

	CompletableFuture<Void> save(@Valid final ProcesoTiendaSeccionEmpleadoPresenciaDto item);

    CompletableFuture<Void> save(final List<PtrPresenciaDetalleComisionableResultItemDto> item, final ProcesoDto proceso);

}
