package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

public interface TrabajoTiendaVentaSeccionAsyncService {

    CompletableFuture<Void> pivot(@Valid TrabajoDto trabajoDto) throws Exception;

}
