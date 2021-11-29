/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.ajuste.personas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.ajuste.personas.CalculoAjusteVacacionesService;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTablePoliticasRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteVacacionesRepositoryCustom;

/**
 * @author javierev
 */
@Service
public class CalculoAjusteVacacionesServiceImpl extends AbstractCalculoAjusteBaseService implements
        CalculoAjusteVacacionesService {

    @Autowired
    private PrimaryTemporaryTablePoliticasRepositoryCustom primaryTemporaryTablePoliticasRepositoryCustom;

    @Autowired
    private TareaCalculoAjusteVacacionesRepositoryCustom tareaCalculoAjusteVacacionesRepositoryCustom;

    @Override
    protected void precondiciones(final TareaDto tarea,
            final List<IdPersonaLocalDto> personas) {
        this.primaryTemporaryTablePoliticasRepositoryCustom.createTempPersonas();
        this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasVacaciones();
        this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAcumuladasVacaciones();
        this.primaryTemporaryTablePoliticasRepositoryCustom.createTempCalculoTotalizadoVacaciones();
        this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempPersonas();
        this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempFechasVacaciones();
        this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempFechasAcumuladasVacaciones();
        this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempCalculoTotalizadoVacaciones();
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempPersonas(tarea, personas,
                TipoPoliticaEnum.VACACIONES);
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasVacaciones();
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasVacaciones();
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoTotalizadoVacaciones();
    }

    @Override
    protected void ajustar(final AlgoritmoAjusteDto algoritmoAjuste) {
        this.tareaCalculoAjusteVacacionesRepositoryCustom.ajustar(algoritmoAjuste);
    }

    @Override
    protected void postcondiciones() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempPersonas();
        this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasVacaciones();
        this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAcumuladasVacaciones();
        this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempCalculoTotalizadoVacaciones();
    }

}
