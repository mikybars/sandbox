/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.ajuste.personas;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.ajuste.personas.CalculoAjusteMaximoGarantizadoService;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTablePoliticasRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteMaximoGarantizadoRepositoryCustom;

/**
 * @author javierev
 */
@Service
public class CalculoAjusteMaximoGarantizadoServiceImpl extends AbstractCalculoAjusteBaseService implements
        CalculoAjusteMaximoGarantizadoService {

    @Autowired
    private PrimaryTemporaryTablePoliticasRepositoryCustom primaryTemporaryTablePoliticasRepositoryCustom;

    @Autowired
    private TareaCalculoAjusteMaximoGarantizadoRepositoryCustom tareaCalculoAjusteMaximoGarantizadoRepositoryCustom;

    @Override
    protected void precondiciones(final TareaDto tarea,
            final List<IdPersonaLocalDto> personas) {
        this.primaryTemporaryTablePoliticasRepositoryCustom.createTempPersonas();
        this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempPersonas();
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempPersonas(tarea, personas,
                TipoPoliticaEnum.MAXIMO_GARANTIZADO);
        this.primaryTemporaryTablePoliticasRepositoryCustom.createTempAusenciasDateMaximoGarantizado();
        this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempAusenciasDateMaximoGarantizado();
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempAusenciasDateMaximoGarantizado();
        this.primaryTemporaryTablePoliticasRepositoryCustom.createTempCalculoConAjuste();
        this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempCalculoConAjuste();
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoConAjuste(
                Arrays.asList(TipoPoliticaEnum.ANTIGUEDAD, TipoPoliticaEnum.VACACIONES, TipoPoliticaEnum.BAJA_IT));
        this.primaryTemporaryTablePoliticasRepositoryCustom.createTempDatosMaximoGarantizado();
        this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempDatosMaximoGarantizado();
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempDatosMaximoGarantizado();
    }

    @Override
    protected void ajustar(final AlgoritmoAjusteDto algoritmoAjuste) {
        this.tareaCalculoAjusteMaximoGarantizadoRepositoryCustom.ajustar(algoritmoAjuste);
    }

    @Override
    protected void postcondiciones() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempPersonas();
        this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempAusenciasDateMaximoGarantizado();
        this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempCalculoConAjuste();
        this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempDatosMaximoGarantizado();
    }

}
