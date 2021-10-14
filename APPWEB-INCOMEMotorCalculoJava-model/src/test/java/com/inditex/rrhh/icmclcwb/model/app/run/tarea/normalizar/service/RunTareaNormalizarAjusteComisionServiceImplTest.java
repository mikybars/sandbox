/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.run.tarea.normalizar.service;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteComisionRepositoryCustom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author javierev
 */
@ExtendWith(SpringExtension.class)
class RunTareaNormalizarAjusteComisionServiceImplTest {

    @Mock
    private TareaCalculoAjusteComisionRepositoryCustom tareaCalculoAjusteComisionRepositoryCustom;

    @InjectMocks
    private RunTareaNormalizarAjusteComisionServiceImpl runTareaNormalizarAjusteComisionService;

    @Test
    void normalizarAjusteComisionTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(9039L);

        this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(tarea);
        verify(this.tareaCalculoAjusteComisionRepositoryCustom, times(1)).normalizarAjusteComision(tarea);

    }

}
