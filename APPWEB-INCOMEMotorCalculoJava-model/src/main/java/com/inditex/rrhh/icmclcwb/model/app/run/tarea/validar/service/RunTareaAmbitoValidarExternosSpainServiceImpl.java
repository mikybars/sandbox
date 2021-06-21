/*
 * Copyright (c) 2021. Inditex
 */
package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.async.service.ComisAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalExternaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarExternosBosniaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;

public class RunTareaAmbitoValidarExternosSpainServiceImpl extends AbstractRunTareaAmbitoValidarExternos
        implements RunTareaAmbitoValidarExternosBosniaService {

    @Autowired
    private ComisAsyncService comisAsyncService;

    @Override
    protected CompletableFuture<List<IdPersonaLocalExternaDto>> findExternos(
            final RunTareaDto runTarea,
            final TareaAmbitoDto tareaAmbito) {
        return this.comisAsyncService.findExternosByMinIdPersona(runTarea, tareaAmbito,
                AppConstants.MIN_ID_PERSONA_EXTERNO);
    }

}
