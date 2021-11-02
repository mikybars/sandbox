/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.SistemaDestinoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoAusenciaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoUnidadTiempoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto.SistemaDestinoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto.SistemaDestinoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author javierev
 */
@Repository
public class PrimaryTemporaryTablePoliticasRepositoryCustomImpl
        implements PrimaryTemporaryTablePoliticasRepositoryCustom {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TareaAmbitoService tareaAmbitoService;

    @Autowired
    private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempFechasBajaIt']}")
    private String sqlCreateTempFechasBajaIt;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasBajaIt']}")
    private String sqlDeleteTempFechasBajaIt;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasBajaIt']}")
    private String sqlInsertTempFechasBajaIt;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempFechasBajaIt']}")
    private String sqlIndexTempFechasBajaIt;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAcumuladasBajaIt']}")
    private String sqlCreateTempFechasAcumuladasBajaIt;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAcumuladasBajaIt']}")
    private String sqlDeleteTempFechasAcumuladasBajaIt;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasBajaIt']}")
    private String sqlInsertTempFechasAcumuladasBajaIt;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempFechasAcumuladasBajaIt']}")
    private String sqlIndexTempFechasAcumuladasBajaIt;

    @Override
    public int createTempFechasBajaIt() {
        return this.jdbcTemplate.update(this.sqlCreateTempFechasBajaIt);
    }

    @Override
    public int deleteTempFechasBajaIt() {
        return this.jdbcTemplate.update(this.sqlDeleteTempFechasBajaIt);
    }

    @Override
    public int createIndexTempFechasBajaIt() {
        return this.jdbcTemplate.update(this.sqlIndexTempFechasBajaIt);
    }

    @Override
    public void insertTempFechasBajaIt(final TareaDto tarea) {
        final MapSqlParameterSource map = new MapSqlParameterSource();
        String cclIdOrigen = null;
        SistemaDestinoResponseDto sistemaDestino = SistemaDestinoResponseDto.builder()
            .idSistemaDestino(
                    SistemaDestinoEnum.NONE.getIdMeta4())
            .build();
        if (tarea != null) {
            map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
            final List<TareaAmbitoDto> byTarea = this.tareaAmbitoService.findByTarea(tarea);
            cclIdOrigen = CollectionUtils.isNotEmpty(byTarea) ? byTarea.get(0).getCclIdOrigen() : null;
        }
        if (StringUtils.isNotBlank(cclIdOrigen)) {
            sistemaDestino = this.meta4IcmWsCalcIncomeService
                .getSistemaDestino(SistemaDestinoRequestDto.builder().cclIdOrigen(cclIdOrigen).build());
        }

        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA, TipoPoliticaEnum.BAJA_IT.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS, TipoUnidadTiempoEnum.ANOS.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES, TipoUnidadTiempoEnum.MESES.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS, TipoUnidadTiempoEnum.SEMANAS.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS, TipoUnidadTiempoEnum.DIAS.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_AUSENCIA, TipoAusenciaEnum.BAJA_IT.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SISTEMA_DESTINO, sistemaDestino.getIdSistemaDestino());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SISTEMA_DESTINO_SOLUCION_GLOBAL,
                SistemaDestinoEnum.SOLUCION_GLOBAL.getIdMeta4());

        this.namedParameterJdbcTemplate.update(this.sqlInsertTempFechasBajaIt, map);
    }

    @Override
    public int createTempFechasAcumuladasBajaIt() {
        return this.jdbcTemplate.update(this.sqlCreateTempFechasAcumuladasBajaIt);
    }

    @Override
    public int deleteTempFechasAcumuladasBajaIt() {
        return this.jdbcTemplate.update(this.sqlDeleteTempFechasAcumuladasBajaIt);
    }

    @Override
    public void insertTempFechasAcumuladasBajaIt(final TareaDto tarea) {
        final MapSqlParameterSource map = new MapSqlParameterSource();
        if (tarea != null) {
            map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        }

        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA, TipoPoliticaEnum.BAJA_IT.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS, TipoUnidadTiempoEnum.ANOS.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES, TipoUnidadTiempoEnum.MESES.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS, TipoUnidadTiempoEnum.SEMANAS.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS, TipoUnidadTiempoEnum.DIAS.getId());

        this.namedParameterJdbcTemplate.update(this.sqlInsertTempFechasAcumuladasBajaIt, map);
    }

    @Override
    public int createIndexTempFechasAcumuladasBajaIt() {
        return this.jdbcTemplate.update(this.sqlIndexTempFechasAcumuladasBajaIt);
    }

}
