/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.api.app.programacion.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.dto.ProgramacionDTO;

/**
 * @author javierev<
 */
@Async("repositoryPrimaryExecutor")
public interface ProgramacionAsyncService {

    CompletableFuture<Void> updateFechaSiguienteEjecucion(
            @NotNull @NotEmpty final List<ProgramacionDTO> idProgramacion);

}
