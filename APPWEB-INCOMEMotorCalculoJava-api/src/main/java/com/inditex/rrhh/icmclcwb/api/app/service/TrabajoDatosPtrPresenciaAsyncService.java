package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.TipoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

public interface TrabajoDatosPtrPresenciaAsyncService {

    CompletableFuture<Void> tiposHoras(final TrabajoDto trabajo) throws Exception;

    CompletableFuture<Void> presenciaDetalleEmpleado(final TrabajoDto trabajo) throws Exception;

    CompletableFuture<Void> presenciaTotalizadaTienda(final TrabajoDto trabajo,
            List<TipoTrabajoTiendaDto> tipoTrabajoTienda) throws Exception;

}