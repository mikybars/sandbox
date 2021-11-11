/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.run.tarea.normalizar.service;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.normalizar.service.RunTareaNormalizarAjusteComisionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteComisionRepositoryCustom;

/**
 * @author javierev
 */
@Service
@Validated
public class RunTareaNormalizarAjusteComisionServiceImpl implements RunTareaNormalizarAjusteComisionService {

    @Autowired
    private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

    @Autowired
    private TareaCalculoAjusteComisionRepositoryCustom tareaCalculoAjusteComisionRepositoryCustom;

    @Override
    @Transactional
    public void normalizarAjusteComision(@Valid final TareaDto tarea) {
        try {
            this.primaryTemporaryTableRepositoryCustom.createTempCalculoPorComision();
            this.primaryTemporaryTableRepositoryCustom.createTempCalculoAjusteTotalizado();
            this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoSinComision(tarea);
            this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoPorComision(tarea);
            this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoAjusteTotalizado(tarea);
            this.tareaCalculoAjusteComisionRepositoryCustom.normalizarAjusteComision(tarea);
        } finally {
            this.primaryTemporaryTableRepositoryCustom.deleteTempCalculoPorComision();
            this.primaryTemporaryTableRepositoryCustom.deleteTempCalculoAjusteTotalizado();
        }
    }

}
