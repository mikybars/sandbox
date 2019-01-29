package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosDto;

public interface TrabajoTiendaEstadoAsyncService {

    CompletableFuture<Void> save(TrabajoRunDatosDto trabajoRunDatos, TrabajoDto trabajo) throws Exception;

}
