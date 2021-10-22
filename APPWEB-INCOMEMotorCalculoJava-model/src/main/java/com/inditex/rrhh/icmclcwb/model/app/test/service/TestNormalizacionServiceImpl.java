/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.normalizar.service.RunTareaNormalizarAjusteComisionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.api.app.test.service.TestNormalizacionService;
import com.inditex.rrhh.icmclcwb.dto.IdTareaDTO;

/**
 * Nota: esta clase se deberá borrar cuando se haya hecho la normalización de tareas consolidadas
 *
 * @author javierev
 */
@Service
public class TestNormalizacionServiceImpl implements TestNormalizacionService {

    @Autowired
    private RunTareaNormalizarAjusteComisionService runTareaNormalizarAjusteComisionService;

    @Autowired
    private TareaService tareaService;

    @Override
    public void normalizarAjusteComision(final List<IdTareaDTO> tareas) {

        for (final IdTareaDTO idTarea : tareas) {
            final TareaDto tarea = this.tareaService.find(idTarea.getId());
            this.runTareaNormalizarAjusteComisionService
                .normalizarAjusteComision(tarea);
        }

    }

}
