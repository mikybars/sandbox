/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.ajuste.personas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.ajuste.personas.CalculoAjusteBajaItService;
import com.inditex.rrhh.icmclcwb.api.app.calcular.SistemaDestinoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto.SistemaDestinoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto.SistemaDestinoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTablePoliticasRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteBajaItRepositoryCustom;
import org.apache.commons.lang3.StringUtils;

/**
 * @author javierev
 */
@Service
public class CalculoAjusteBajaItServiceImpl extends AbstractCalculoAjusteBaseService implements
        CalculoAjusteBajaItService {

    @Autowired
    private PrimaryTemporaryTablePoliticasRepositoryCustom primaryTemporaryTablePoliticasRepositoryCustom;

    @Autowired
    private TareaCalculoAjusteBajaItRepositoryCustom tareaCalculoAjusteBajaItRepositoryCustom;

    @Autowired
    private TareaAmbitoService tareaAmbitoService;

    @Autowired
    private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

    @Override
    protected void precondiciones(final TareaDto tarea,
            final List<IdPersonaLocalDto> personas) {

        String cclIdOrigen = null;
        SistemaDestinoResponseDto sistemaDestino = SistemaDestinoResponseDto.builder()
            .idSistemaDestino(
                    SistemaDestinoEnum.NONE.getIdMeta4())
            .build();
        if (tarea != null) {
            final List<TareaAmbitoDto> byTarea = this.tareaAmbitoService.findByTarea(tarea);
            cclIdOrigen = CollectionUtils.isNotEmpty(byTarea) ? byTarea.get(0).getCclIdOrigen() : null;
        }
        if (StringUtils.isNotBlank(cclIdOrigen)) {
            sistemaDestino = this.meta4IcmWsCalcIncomeService
                .getSistemaDestino(SistemaDestinoRequestDto.builder().cclIdOrigen(cclIdOrigen).build());
        }

        this.primaryTemporaryTablePoliticasRepositoryCustom.createTempPersonas();
        this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempPersonas();
        this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasBajaIt();
        this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempFechasBajaIt();
        this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAcumuladasBajaIt();
        this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempFechasAcumuladasBajaIt();
        this.primaryTemporaryTablePoliticasRepositoryCustom.createTempCalculoTotalizadoBajaIt();
        this.primaryTemporaryTablePoliticasRepositoryCustom.createIndexTempCalculoTotalizadoBajaIt();
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempPersonas(tarea, personas,
                TipoPoliticaEnum.BAJA_IT);
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasBajaIt(tarea,
                sistemaDestino.getIdSistemaDestino());
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasBajaIt();
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoTotalizadoBajaIt();
    }

    @Override
    protected void ajustar(final AlgoritmoAjusteDto algoritmoAjuste) {
        this.tareaCalculoAjusteBajaItRepositoryCustom.ajustar(algoritmoAjuste);
    }

    @Override
    protected void postcondiciones() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempPersonas();
        this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasBajaIt();
        this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAcumuladasBajaIt();
        this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempCalculoTotalizadoBajaIt();
    }

}
