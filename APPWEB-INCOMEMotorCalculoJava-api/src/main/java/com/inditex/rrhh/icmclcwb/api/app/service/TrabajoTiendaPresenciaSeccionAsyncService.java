package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

public interface TrabajoTiendaPresenciaSeccionAsyncService {

    CompletableFuture<Void> pivot(@Valid final TrabajoDto trabajoDto) throws Exception;

}
