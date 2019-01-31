package com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface TrabajoPivotAsyncService {

    CompletableFuture<Void> pivot(@Valid TrabajoDto trabajoDto) throws Exception;

}
