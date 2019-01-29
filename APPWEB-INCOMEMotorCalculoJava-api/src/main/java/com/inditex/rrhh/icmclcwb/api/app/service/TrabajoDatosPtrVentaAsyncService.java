package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosBloqueDto;

public interface TrabajoDatosPtrVentaAsyncService {

    CompletableFuture<Void> ventaDetalleEmpleado(final TrabajoDto trabajo,
            final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception;

    CompletableFuture<Void> ventaTotalizadaTienda(final TrabajoDto trabajo,
            final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception;

}