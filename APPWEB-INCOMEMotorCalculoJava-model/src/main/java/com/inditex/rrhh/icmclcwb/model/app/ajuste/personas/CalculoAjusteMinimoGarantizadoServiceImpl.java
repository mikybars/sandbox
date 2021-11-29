/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.ajuste.personas;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.ajuste.personas.CalculoAjusteMinimoGarantizadoService;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTablePoliticasRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteMinimoGarantizadoRepositoryCustom;

/**
 * @author javierev
 */
@Service
public class CalculoAjusteMinimoGarantizadoServiceImpl extends AbstractCalculoAjusteBaseService implements
        CalculoAjusteMinimoGarantizadoService {

    @Autowired
    private PrimaryTemporaryTablePoliticasRepositoryCustom primaryTemporaryTablePoliticasRepositoryCustom;

    @Autowired
    private TareaCalculoAjusteMinimoGarantizadoRepositoryCustom tareaCalculoAjusteMinimoGarantizadoRepositoryCustom;

    @Override
    protected void precondiciones(final TareaDto tarea,
            final List<IdPersonaLocalDto> personas) {
        this.primaryTemporaryTablePoliticasRepositoryCustom.createTempPersonas();
        this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempPersonas();
        this.primaryTemporaryTablePoliticasRepositoryCustom.createTempAusenciasDateMinimoGarantizado();
        this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempAusenciasDateMinimoGarantizado();
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempAusenciasDateMinimoGarantizado();
        this.primaryTemporaryTablePoliticasRepositoryCustom.createTempCalculoConAjuste();
        this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempCalculoConAjuste();
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempPersonas(tarea, personas,
                TipoPoliticaEnum.MINIMO_GARANTIZADO);
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoConAjuste(
                Arrays.asList(TipoPoliticaEnum.ANTIGUEDAD, TipoPoliticaEnum.VACACIONES, TipoPoliticaEnum.BAJA_IT));
        this.primaryTemporaryTablePoliticasRepositoryCustom.createTempDatosMinimoGarantizado();
        this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempDatosMinimoGarantizado();
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempDatosMininimoGarantizado();
    }

    @Override
    protected void ajustar(final AlgoritmoAjusteDto algoritmoAjuste) {
        this.tareaCalculoAjusteMinimoGarantizadoRepositoryCustom.ajustar(algoritmoAjuste);
    }

    @Override
    protected void postcondiciones() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempPersonas();
        this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempAusenciasDateMinimoGarantizado();
        this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempCalculoConAjuste();
        this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempDatosMinimoGarantizado();
    }

}
