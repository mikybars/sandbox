/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.normalizar.async.service.RunTareaNormalizarAjusteComisionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.api.app.test.service.TestNormalizacionService;
import com.inditex.rrhh.icmclcwb.dto.IdTareaDTO;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

/**
 * Nota: esta clase se deberá borrar cuando se haya hecho la normalización de tareas consolidadas
 *
 * @author javierev
 */
@Service
public class TestNormalizacionServiceImpl implements TestNormalizacionService {

    private static final int TAREAS_SIMULTANEAS = 5;

    @Autowired
    private RunTareaNormalizarAjusteComisionAsyncService runTareaNormalizarAjusteComisionAsyncService;

    @Autowired
    private TareaService tareaService;

    @Override
    public void normalizarAjusteComision(final List<IdTareaDTO> tareas) {

        final List<CompletableFuture<?>> cf = new ArrayList<>();
        for (final List<IdTareaDTO> idTareas : StreamUtils.partition(tareas, TAREAS_SIMULTANEAS)) {
            for (final IdTareaDTO idTarea : idTareas) {
                final TareaDto tarea = this.tareaService.find(idTarea.getId());
                final CompletableFuture<Void> cfNormalizar = this.runTareaNormalizarAjusteComisionAsyncService
                    .normalizarAjusteComision(tarea);
                AsyncUtils.exceptionally(cfNormalizar, cf);
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        }

    }

}
