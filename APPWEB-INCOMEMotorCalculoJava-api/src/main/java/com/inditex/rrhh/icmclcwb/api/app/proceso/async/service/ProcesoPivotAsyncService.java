package com.inditex.rrhh.icmclcwb.api.app.proceso.async.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;

public interface ProcesoPivotAsyncService {

    CompletableFuture<Void> pivot(@Valid ProcesoDto proceso);

}
