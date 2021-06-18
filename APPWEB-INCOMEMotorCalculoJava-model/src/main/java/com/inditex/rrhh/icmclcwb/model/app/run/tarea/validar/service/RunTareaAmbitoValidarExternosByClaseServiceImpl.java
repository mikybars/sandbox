/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.async.service.ComisAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalExternaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarExternosByClaseService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

@Service
@Validated
public class RunTareaAmbitoValidarExternosByClaseServiceImpl
        extends AbstractRunTareaAmbitoValidarExternos
        implements
        RunTareaAmbitoValidarExternosByClaseService {

    @Autowired
    private ComisAsyncService comisAsyncService;

    @Override
    protected CompletableFuture<List<IdPersonaLocalExternaDto>> findExternos(
            final RunTareaDto runTarea, final TareaAmbitoDto tareaAmbito) {
        return this.comisAsyncService
            .findExternosByClase(runTarea, tareaAmbito);
    }

}
