package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosBloqueDto;

public interface TrabajoDatosPtrPresenciaAsyncService {

    CompletableFuture<Void> tiposHoras(final TrabajoDto trabajo) throws Exception;

    CompletableFuture<Void> presenciaDetalleEmpleado(final TrabajoDto trabajo,
            final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception;

    CompletableFuture<Void> presenciaTotalizadaTienda(final TrabajoDto trabajo,
            final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception;

}