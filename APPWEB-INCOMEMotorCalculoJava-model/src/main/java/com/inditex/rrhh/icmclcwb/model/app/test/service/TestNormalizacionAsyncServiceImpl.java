/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.test.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.test.service.TestNormalizacionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.test.service.TestNormalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.dto.IdTareaDTO;

/**
 * Nota: esta clase se deberá borrar cuando se haya hecho la normalización de tareas consolidadas
 *
 * @author javierev
 */
@Service
public class TestNormalizacionAsyncServiceImpl implements TestNormalizacionAsyncService {

    @Autowired
    private TestNormalizacionService testNormalizacionService;

    @Override
    public CompletableFuture<Void> normalizarAjusteComision(
            final List<IdTareaDTO> tareas) {
        this.testNormalizacionService.normalizarAjusteComision(tareas);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
