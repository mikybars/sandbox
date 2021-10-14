/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.run.tarea.normalizar.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.normalizar.service.RunTareaNormalizarAjusteComisionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteComisionRepositoryCustom;

/**
 * @author javierev
 */
@Service
@Validated
public class RunTareaNormalizarAjusteComisionServiceImpl implements RunTareaNormalizarAjusteComisionService {

    @Autowired
    private TareaCalculoAjusteComisionRepositoryCustom tareaCalculoAjusteComisionRepositoryCustom;

    @Override
    public void normalizarAjusteComision(@Valid final TareaDto tarea) {
        this.tareaCalculoAjusteComisionRepositoryCustom.normalizarAjusteComision(tarea);
    }

}
