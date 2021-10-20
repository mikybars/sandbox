/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.run.tarea.normalizar.service;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteComisionRepositoryCustom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author javierev
 */
@ExtendWith(SpringExtension.class)
class RunTareaNormalizarAjusteComisionServiceImplTest {

    @Mock
    private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

    @Mock
    private TareaCalculoAjusteComisionRepositoryCustom tareaCalculoAjusteComisionRepositoryCustom;

    @InjectMocks
    private RunTareaNormalizarAjusteComisionServiceImpl runTareaNormalizarAjusteComisionService;

    @Test
    void normalizarAjusteComisionInsertTareaCalculoAjusteComisionTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(9039L);

        this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(tarea);
        verify(this.tareaCalculoAjusteComisionRepositoryCustom, times(1)).normalizarAjusteComision(tarea);

    }

    @Test
    void normalizarAjusteComisionCreaTablaTemporalCalculoPorComisionTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(9039L);

        this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(tarea);
        verify(this.primaryTemporaryTableRepositoryCustom, times(1)).createTempCalculoPorComision();

    }

    @Test
    void normalizarAjusteComisionMergeCalculoTemporalPorComisionTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(9039L);

        this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(tarea);
        verify(this.primaryTemporaryTableRepositoryCustom, times(1)).mergeCalculoTempCalculoPorComision(tarea);

    }

    @Test
    void normalizarAjusteComisionMergeCalculoTemporalSinComisionTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(9039L);

        this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(tarea);
        verify(this.primaryTemporaryTableRepositoryCustom, times(1)).mergeCalculoTempCalculoSinComision(tarea);

    }

    @Test
    void normalizarAjusteComisionEliminaTablaTemporalCalculoPorComisionTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(9039L);

        this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(tarea);
        verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoPorComision();

    }

    @Test
    void normalizarAjusteComisionInsertTareaCalculoAjusteComisionExcepcionEliminaTablasTemporalesTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(9039L);
        doThrow(new RuntimeException("e")).when(this.tareaCalculoAjusteComisionRepositoryCustom)
            .normalizarAjusteComision(any(TareaDto.class));

        assertThrows(RuntimeException.class,
                () -> this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(tarea));

        verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoPorComision();
        verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoAjusteTotalizado();

    }

    @Test
    void normalizarAjusteComisionCrearTablaTemporalCalculoPorComisionExcepcionEliminaTablasTemporalesTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(9039L);
        doThrow(new RuntimeException("e")).when(this.primaryTemporaryTableRepositoryCustom)
            .createTempCalculoPorComision();

        assertThrows(RuntimeException.class, () -> {
            this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(tarea);
        });

        verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoPorComision();
        verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoAjusteTotalizado();

    }

    @Test
    void normalizarAjusteComisionMergeCalculoPorComisionExcepcionEliminaTablasTemporalesTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(9039L);
        doThrow(new RuntimeException("e")).when(this.primaryTemporaryTableRepositoryCustom)
            .mergeCalculoTempCalculoPorComision(any(TareaDto.class));

        assertThrows(RuntimeException.class, () -> {
            this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(tarea);
        });

        verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoPorComision();
        verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoAjusteTotalizado();

    }

    @Test
    void normalizarAjusteComisionMergeCalculoSinComisionExcepcionEliminaTablasTemporalesTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(9039L);
        doThrow(new RuntimeException("e")).when(this.primaryTemporaryTableRepositoryCustom)
            .mergeCalculoTempCalculoSinComision(any(TareaDto.class));

        assertThrows(RuntimeException.class, () -> {
            this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(tarea);
        });

        verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoPorComision();
        verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoAjusteTotalizado();

    }

    @Test
    void normalizarAjusteComisionCreaTablaTemporalCalculoAjusteTotalizadoTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(9039L);

        this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(tarea);
        verify(this.primaryTemporaryTableRepositoryCustom, times(1)).createTempCalculoAjusteTotalizado();

    }

    @Test
    void normalizarAjusteComisionMergeCalculoAjusteTotalizadoTemporalTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(9039L);

        this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(tarea);
        verify(this.primaryTemporaryTableRepositoryCustom, times(1)).mergeCalculoTempCalculoAjusteTotalizado(tarea);

    }

    @Test
    void normalizarAjusteComisionEliminaTablaTemporalCalculoAjusteTotalizadoTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(9039L);

        this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(tarea);
        verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoAjusteTotalizado();

    }

    @Test
    void normalizarAjusteComisionCrearTablaTemporalAjusteTotalizadoExcepcionEliminaTablasTemporalesTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(9039L);
        doThrow(new RuntimeException("e")).when(this.primaryTemporaryTableRepositoryCustom)
            .createTempCalculoAjusteTotalizado();

        assertThrows(RuntimeException.class, () -> {
            this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(tarea);
        });

        verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoPorComision();
        verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoAjusteTotalizado();

    }

    @Test
    void normalizarAjusteComisionMergeCalculoAjusteTotalizadoExcepcionEliminaTablasTemporalesTest() {

        final TareaDto tarea = new TareaDto();
        tarea.setId(9039L);
        doThrow(new RuntimeException("e")).when(this.primaryTemporaryTableRepositoryCustom)
            .mergeCalculoTempCalculoAjusteTotalizado(any(TareaDto.class));

        assertThrows(RuntimeException.class, () -> {
            this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(tarea);
        });

        verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoPorComision();
        verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoAjusteTotalizado();

    }

}
