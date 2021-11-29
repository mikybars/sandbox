/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.ajuste.personas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTablePoliticasRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteMinimoGarantizadoRepositoryCustom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * javierev
 */
@ExtendWith(SpringExtension.class)
class CalculoAjusteMinimoGarantizadoServiceImplTest {

    @Mock
    private PrimaryTemporaryTablePoliticasRepositoryCustom primaryTemporaryTablePoliticasRepositoryCustom;

    @Mock
    private TareaCalculoAjusteMinimoGarantizadoRepositoryCustom tareaCalculoAjusteMinimoGarantizadoRepositoryCustom;

    @InjectMocks
    private CalculoAjusteMinimoGarantizadoServiceImpl calculoAjusteMinimoGarantizadoService;

    @Test
    void precondicionesTest() {

        final List<IdPersonaLocalDto> personas = this.createPersonas();
        final TareaDto tarea = this.createTarea();
        this.calculoAjusteMinimoGarantizadoService.precondiciones(tarea, personas);
        verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createTempPersonas();
        verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createIndexTempPersonas();
        verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1))
            .createTempAusenciasDateMinimoGarantizado();
        verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1))
            .createIndexTempAusenciasDateMinimoGarantizado();
        verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1))
            .createTempCalculoConAjuste();
        verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1))
            .createIndexTempCalculoConAjuste();
        verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createTempDatosMinimoGarantizado();
        verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).createIndexTempDatosMinimoGarantizado();

        verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).insertTempPersonas(tarea, personas,
                TipoPoliticaEnum.MINIMO_GARANTIZADO);
        verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1))
            .insertTempAusenciasDateMinimoGarantizado();
        verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1))
            .insertTempCalculoConAjuste(
                    Arrays.asList(TipoPoliticaEnum.ANTIGUEDAD, TipoPoliticaEnum.VACACIONES, TipoPoliticaEnum.BAJA_IT));
        verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).insertTempDatosMininimoGarantizado();

    }

    @Test
    void ajustarTest() {
        final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
        this.calculoAjusteMinimoGarantizadoService.ajustar(algoritmoAjuste);
        verify(this.tareaCalculoAjusteMinimoGarantizadoRepositoryCustom, times(1)).ajustar(algoritmoAjuste);
    }

    @Test
    void postcondicionesTest() {
        this.calculoAjusteMinimoGarantizadoService.postcondiciones();
        verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempPersonas();
        verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1))
            .deleteTempAusenciasDateMinimoGarantizado();
        verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1))
            .deleteTempCalculoConAjuste();
        verify(this.primaryTemporaryTablePoliticasRepositoryCustom, times(1)).deleteTempDatosMinimoGarantizado();
    }

    private AlgoritmoAjusteDto createAlgoritmoAjuste() {
        final AlgoritmoAjusteDto algoritmoAjuste = new AlgoritmoAjusteDto();
        algoritmoAjuste.setId(1929);
        return algoritmoAjuste;
    }

    private List<IdPersonaLocalDto> createPersonas() {
        return Collections.singletonList(IdPersonaLocalDto
            .builder()
            .idPersonaLocal("ID PERSONA")
            .stdOrHrPeriod("OR PERSONA")
            .build());
    }

    private TareaDto createTarea() {
        final TareaDto tarea = new TareaDto();
        tarea.setId(123L);
        return tarea;
    }

}
