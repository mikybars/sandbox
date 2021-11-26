/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.SistemaDestinoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoAusenciaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoUnidadTiempoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

/**
 * @author javierev
 */
@Repository
public class PrimaryTemporaryTablePoliticasRepositoryCustomImpl
        implements PrimaryTemporaryTablePoliticasRepositoryCustom {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // Comun

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempPersonas']}")
    private String sqlCreateTempPersonas;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempPersonas']}")
    private String sqlDeleteTempPersonas;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempPersonas']}")
    private String sqlInsertTempPersonas;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempPersonas']}")
    private String sqlIndexTempPersonas;

    // Baja it

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

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempCalculoTotalizadoBajaIt']}")
    private String sqlCreateTempCalculoTotalizadoBajaIt;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempCalculoTotalizadoBajaIt']}")
    private String sqlDeleteTempCalculoTotalizadoBajaIt;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoTotalizadoBajaIt']}")
    private String sqlInsertTempCalculoTotalizadoBajaIt;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempCalculoTotalizadoBajaIt']}")
    private String sqlIndexTempCalculoTotalizadoBajaIt;

    // Antiguedad

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAntiguedad']}")
    private String sqlCreateTempFechasAntiguedad;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAntiguedad']}")
    private String sqlDeleteTempFechasAntiguedad;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAntiguedad']}")
    private String sqlInsertTempFechasAntiguedad;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempFechasAntiguedad']}")
    private String sqlIndexTempFechasAntiguedad;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAcumuladasAntiguedad']}")
    private String sqlCreateTempFechasAcumuladasAntiguedad;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAcumuladasAntiguedad']}")
    private String sqlDeleteTempFechasAcumuladasAntiguedad;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasAntiguedad']}")
    private String sqlInsertTempFechasAcumuladasAntiguedad;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempFechasAcumuladasAntiguedad']}")
    private String sqlIndexTempFechasAcumuladasAntiguedad;

    // Vacaciones

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempFechasVacaciones']}")
    private String sqlCreateTempFechasVacaciones;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasVacaciones']}")
    private String sqlDeleteTempFechasVacaciones;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasVacaciones']}")
    private String sqlInsertTempFechasVacaciones;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempFechasVacaciones']}")
    private String sqlIndexTempFechasVacaciones;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAcumuladasVacaciones']}")
    private String sqlCreateTempFechasAcumuladasVacaciones;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAcumuladasVacaciones']}")
    private String sqlDeleteTempFechasAcumuladasVacaciones;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasVacaciones']}")
    private String sqlInsertTempFechasAcumuladasVacaciones;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempFechasAcumuladasVacaciones']}")
    private String sqlIndexTempFechasAcumuladasVacaciones;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempCalculoTotalizadoVacaciones']}")
    private String sqlCreateTempCalculoTotalizadoVacaciones;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempCalculoTotalizadoVacaciones']}")
    private String sqlDeleteTempCalculoTotalizadoVacaciones;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoTotalizadoVacaciones']}")
    private String sqlInsertTempCalculoTotalizadoVacaciones;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempCalculoTotalizadoVacaciones']}")
    private String sqlIndexTempCalculoTotalizadoVacaciones;

    // Máximo garantizado

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempAusenciasDateMaximoGarantizado']}")
    private String sqlCreateTempAusenciasDateMaximoGarantizado;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempAusenciasDateMaximoGarantizado']}")
    private String sqlDeleteTempAusenciasDateMaximoGarantizado;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempAusenciasDateMaximoGarantizado']}")
    private String sqlInsertTempAusenciasDateMaximoGarantizado;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempAusenciasDateMaximoGarantizado']}")
    private String sqlIndexTempAusenciasDateMaximoGarantizado;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempCalculoConAjusteMaximoGarantizado']}")
    private String sqlCreateTempCalculoConAjusteMaximoGarantizado;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempCalculoConAjusteMaximoGarantizado']}")
    private String sqlDeleteTempCalculoConAjusteMaximoGarantizado;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoConAjusteMaximoGarantizado']}")
    private String sqlInsertTempCalculoConAjusteMaximoGarantizado;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempCalculoConAjusteMaximoGarantizado']}")
    private String sqlIndexTempCalculoConAjusteMaximoGarantizado;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempDatosMaximoGarantizado']}")
    private String sqlCreateTempDatosMaximoGarantizado;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempDatosMaximoGarantizado']}")
    private String sqlDeleteTempDatosMaximoGarantizado;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempDatosMaximoGarantizado']}")
    private String sqlInsertTempDatosMaximoGarantizado;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempDatosMaximoGarantizado']}")
    private String sqlIndexTempDatosMaximoGarantizado;

    // Mínimo garantizado

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempAusenciasDateMinimoGarantizado']}")
    private String sqlCreateTempAusenciasDateMinimoGarantizado;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempAusenciasDateMinimoGarantizado']}")
    private String sqlDeleteTempAusenciasDateMinimoGarantizado;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempAusenciasDateMinimoGarantizado']}")
    private String sqlInsertTempAusenciasDateMinimoGarantizado;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempAusenciasDateMinimoGarantizado']}")
    private String sqlIndexTempAusenciasDateMinimoGarantizado;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempCalculoConAjusteMinimoGarantizado']}")
    private String sqlCreateTempCalculoConAjusteMinimoGarantizado;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempCalculoConAjusteMinimoGarantizado']}")
    private String sqlDeleteTempCalculoConAjusteMinimoGarantizado;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoConAjusteMinimoGarantizado']}")
    private String sqlInsertTempCalculoConAjusteMinimoGarantizado;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempCalculoConAjusteMinimoGarantizado']}")
    private String sqlIndexTempCalculoConAjusteMinimoGarantizado;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempDatosMinimoGarantizado']}")
    private String sqlCreateTempDatosMinimoGarantizado;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempDatosMinimoGarantizado']}")
    private String sqlDeleteTempDatosMinimoGarantizado;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempDatosMinimoGarantizado']}")
    private String sqlInsertTempDatosMinimoGarantizado;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempDatosMinimoGarantizado']}")
    private String sqlIndexTempDatosMinimoGarantizado;

    // Carencia

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempFechasCarencia']}")
    private String sqlCreateTempFechasCarencia;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasCarencia']}")
    private String sqlDeleteTempFechasCarencia;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasCarencia']}")
    private String sqlInsertTempFechasCarencia;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempFechasCarencia']}")
    private String sqlIndexTempFechasCarencia;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAcumuladasCarencia']}")
    private String sqlCreateTempFechasAcumuladasCarencia;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAcumuladasCarencia']}")
    private String sqlDeleteTempFechasAcumuladasCarencia;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasCarencia']}")
    private String sqlInsertTempFechasAcumuladasCarencia;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempFechasAcumuladasCarencia']}")
    private String sqlIndexTempFechasAcumuladasCarencia;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempCalculoTotalizadoCarencia']}")
    private String sqlCreateTempCalculoTotalizadoCarencia;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempCalculoTotalizadoCarencia']}")
    private String sqlDeleteTempCalculoTotalizadoCarencia;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoTotalizadoCarencia']}")
    private String sqlInsertTempCalculoTotalizadoCarencia;

    @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempCalculoTotalizadoCarencia']}")
    private String sqlIndexTempCalculoTotalizadoCarencia;

    @Override
    public int createTempPersonas() {
        return this.jdbcTemplate.update(this.sqlCreateTempPersonas);
    }

    @Override
    public int deleteTempPersonas() {
        return this.jdbcTemplate.update(this.sqlDeleteTempPersonas);
    }

    @Override
    public void insertTempPersonas(final TareaDto tarea,
            final List<IdPersonaLocalDto> personas,
            final TipoPoliticaEnum tipoPolitica) {
        final List<MapSqlParameterSource> batchArgs = new ArrayList<>();
        personas.forEach(persona -> {
            final MapSqlParameterSource arg = new MapSqlParameterSource();
            arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
            arg.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON, persona.getIdPersonaLocal());
            arg.addValue(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD, persona.getStdOrHrPeriod());
            arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA, tipoPolitica.getId());
            batchArgs.add(arg);
        });
        this.namedParameterJdbcTemplate.batchUpdate(this.sqlInsertTempPersonas,
                batchArgs.toArray(new MapSqlParameterSource[0]));
    }

    @Override
    public int createIndexTempPersonas() {
        return this.jdbcTemplate.update(this.sqlIndexTempPersonas);
    }

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
    public void insertTempFechasBajaIt(final TareaDto tarea, final String sistemaDestino) {
        final MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS, TipoUnidadTiempoEnum.ANOS.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES, TipoUnidadTiempoEnum.MESES.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS, TipoUnidadTiempoEnum.SEMANAS.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS, TipoUnidadTiempoEnum.DIAS.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_AUSENCIA, TipoAusenciaEnum.BAJA_IT.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SISTEMA_DESTINO, sistemaDestino);
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
    public void insertTempFechasAcumuladasBajaIt() {
        final MapSqlParameterSource map = new MapSqlParameterSource();
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

    @Override
    public int createTempCalculoTotalizadoBajaIt() {
        return this.jdbcTemplate.update(this.sqlCreateTempCalculoTotalizadoBajaIt);
    }

    @Override
    public int deleteTempCalculoTotalizadoBajaIt() {
        return this.jdbcTemplate.update(this.sqlDeleteTempCalculoTotalizadoBajaIt);
    }

    @Override
    public void insertTempCalculoTotalizadoBajaIt(final TareaDto tarea) {
        final MapSqlParameterSource params = new MapSqlParameterSource();
        if (tarea != null) {
            params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        }
        params.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE,
                Arrays.asList(TipoPoliticaEnum.ANTIGUEDAD.getIdMeta4()));
        this.namedParameterJdbcTemplate.update(this.sqlInsertTempCalculoTotalizadoBajaIt, params);
    }

    @Override
    public int createIndexTempCalculoTotalizadoBajaIt() {
        return this.jdbcTemplate.update(this.sqlIndexTempCalculoTotalizadoBajaIt);
    }

    @Override
    public int createTempFechasAntiguedad() {
        return this.jdbcTemplate.update(this.sqlCreateTempFechasAntiguedad);
    }

    @Override
    public int deleteTempFechasAntiguedad() {
        return this.jdbcTemplate.update(this.sqlDeleteTempFechasAntiguedad);
    }

    @Override
    public void insertTempFechasAntiguedad() {
        final MapSqlParameterSource map = new MapSqlParameterSource();

        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS, TipoUnidadTiempoEnum.ANOS.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES, TipoUnidadTiempoEnum.MESES.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS, TipoUnidadTiempoEnum.SEMANAS.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS, TipoUnidadTiempoEnum.DIAS.getId());

        this.namedParameterJdbcTemplate.update(this.sqlInsertTempFechasAntiguedad, map);
    }

    @Override
    public int createIndexTempFechasAntiguedad() {
        return this.jdbcTemplate.update(this.sqlIndexTempFechasAntiguedad);
    }

    @Override
    public int createTempFechasAcumuladasAntiguedad() {
        return this.jdbcTemplate.update(this.sqlCreateTempFechasAcumuladasAntiguedad);
    }

    @Override
    public int deleteTempFechasAcumuladasAntiguedad() {
        return this.jdbcTemplate.update(this.sqlDeleteTempFechasAcumuladasAntiguedad);
    }

    @Override
    public void insertTempFechasAcumuladasAntiguedad() {
        final MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS, TipoUnidadTiempoEnum.ANOS.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES, TipoUnidadTiempoEnum.MESES.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS, TipoUnidadTiempoEnum.SEMANAS.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS, TipoUnidadTiempoEnum.DIAS.getId());

        this.namedParameterJdbcTemplate.update(this.sqlInsertTempFechasAcumuladasAntiguedad, map);
    }

    @Override
    public int createIndexTempFechasAcumuladasAntiguedad() {
        return this.jdbcTemplate.update(this.sqlIndexTempFechasAcumuladasAntiguedad);
    }

    @Override
    public int createTempFechasVacaciones() {
        return this.jdbcTemplate.update(this.sqlCreateTempFechasVacaciones);
    }

    @Override
    public int deleteTempFechasVacaciones() {
        return this.jdbcTemplate.update(this.sqlDeleteTempFechasVacaciones);
    }

    @Override
    public void insertTempFechasVacaciones() {
        final MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS, TipoUnidadTiempoEnum.ANOS.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES, TipoUnidadTiempoEnum.MESES.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS, TipoUnidadTiempoEnum.SEMANAS.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS, TipoUnidadTiempoEnum.DIAS.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_AUSENCIA, TipoAusenciaEnum.VACACIONES.getId());

        this.namedParameterJdbcTemplate.update(this.sqlInsertTempFechasVacaciones, map);
    }

    @Override
    public int createIndexTempFechasVacaciones() {
        return this.jdbcTemplate.update(this.sqlIndexTempFechasVacaciones);
    }

    @Override
    public int createTempFechasAcumuladasVacaciones() {
        return this.jdbcTemplate.update(this.sqlCreateTempFechasAcumuladasVacaciones);
    }

    @Override
    public int deleteTempFechasAcumuladasVacaciones() {
        return this.jdbcTemplate.update(this.sqlDeleteTempFechasAcumuladasVacaciones);
    }

    @Override
    public void insertTempFechasAcumuladasVacaciones() {
        final MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS, TipoUnidadTiempoEnum.ANOS.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES, TipoUnidadTiempoEnum.MESES.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS, TipoUnidadTiempoEnum.SEMANAS.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS, TipoUnidadTiempoEnum.DIAS.getId());

        this.namedParameterJdbcTemplate.update(this.sqlInsertTempFechasAcumuladasVacaciones, map);
    }

    @Override
    public int createIndexTempFechasAcumuladasVacaciones() {
        return this.jdbcTemplate.update(this.sqlIndexTempFechasAcumuladasVacaciones);
    }

    @Override
    public int createTempCalculoTotalizadoVacaciones() {
        return this.jdbcTemplate.update(this.sqlCreateTempCalculoTotalizadoVacaciones);
    }

    @Override
    public int deleteTempCalculoTotalizadoVacaciones() {
        return this.jdbcTemplate.update(this.sqlDeleteTempCalculoTotalizadoVacaciones);
    }

    @Override
    public void insertTempCalculoTotalizadoVacaciones(final TareaDto tarea) {
        final MapSqlParameterSource params = new MapSqlParameterSource();
        if (tarea != null) {
            params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        }
        params.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE,
                Arrays.asList(TipoPoliticaEnum.VACACIONES.getIdMeta4()));
        this.namedParameterJdbcTemplate.update(this.sqlInsertTempCalculoTotalizadoVacaciones, params);
    }

    @Override
    public int createIndexTempCalculoTotalizadoVacaciones() {
        return this.jdbcTemplate.update(this.sqlIndexTempCalculoTotalizadoVacaciones);
    }

    @Override
    public int createTempAusenciasDateMaximoGarantizado() {
        return this.jdbcTemplate.update(this.sqlCreateTempAusenciasDateMaximoGarantizado);
    }

    @Override
    public int deleteTempAusenciasDateMaximoGarantizado() {
        return this.jdbcTemplate.update(this.sqlDeleteTempAusenciasDateMaximoGarantizado);
    }

    @Override
    public int createIndexTempAusenciasDateMaximoGarantizado() {
        return this.jdbcTemplate.update(this.sqlIndexTempAusenciasDateMaximoGarantizado);
    }

    @Override
    public void insertTempAusenciasDateMaximoGarantizado(final TareaDto tarea) {
        final MapSqlParameterSource map = new MapSqlParameterSource();
        if (tarea != null) {
            map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        }
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA,
                TipoPoliticaEnum.MAXIMO_GARANTIZADO.getId());
        this.namedParameterJdbcTemplate.update(this.sqlInsertTempAusenciasDateMaximoGarantizado, map);
    }

    @Override
    public int createTempCalculoConAjusteMaximoGarantizado() {
        return this.jdbcTemplate.update(this.sqlCreateTempCalculoConAjusteMaximoGarantizado);
    }

    @Override
    public int deleteTempCalculoConAjusteMaximoGarantizado() {
        return this.jdbcTemplate.update(this.sqlDeleteTempCalculoConAjusteMaximoGarantizado);
    }

    @Override
    public int createIndexTempCalculoConAjusteMaximoGarantizado() {
        return this.jdbcTemplate.update(this.sqlIndexTempCalculoConAjusteMaximoGarantizado);
    }

    @Override
    public void insertTempCalculoConAjusteMaximoGarantizado(
            final TareaDto tarea) {
        final MapSqlParameterSource map = new MapSqlParameterSource();
        if (tarea != null) {
            map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        }
        map.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE,
                Arrays.asList(TipoPoliticaEnum.ANTIGUEDAD.getId(),
                        TipoPoliticaEnum.VACACIONES.getId(),
                        TipoPoliticaEnum.BAJA_IT.getId()));
        this.namedParameterJdbcTemplate.update(this.sqlInsertTempCalculoConAjusteMaximoGarantizado, map);
    }

    @Override
    public int createTempDatosMaximoGarantizado() {
        return this.jdbcTemplate.update(this.sqlCreateTempDatosMaximoGarantizado);
    }

    @Override
    public int deleteTempDatosMaximoGarantizado() {
        return this.jdbcTemplate.update(this.sqlDeleteTempDatosMaximoGarantizado);
    }

    @Override
    public int createIndexTempDatosMaximoGarantizado() {
        return this.jdbcTemplate.update(this.sqlIndexTempDatosMaximoGarantizado);
    }

    @Override
    public void insertTempDatosMaximoGarantizado(final TareaDto tarea) {
        final MapSqlParameterSource map = new MapSqlParameterSource();
        if (tarea != null) {
            map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        }
        map.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA, TipoPoliticaEnum.MAXIMO_GARANTIZADO.getId());
        this.namedParameterJdbcTemplate.update(this.sqlInsertTempDatosMaximoGarantizado, map);
    }

    @Override
    public int createTempAusenciasDateMinimoGarantizado() {
        return this.jdbcTemplate.update(this.sqlCreateTempAusenciasDateMinimoGarantizado);
    }

    @Override
    public int deleteTempAusenciasDateMinimoGarantizado() {
        return this.jdbcTemplate.update(this.sqlDeleteTempAusenciasDateMinimoGarantizado);
    }

    @Override
    public int createIndexTempAusenciasDateMinimoGarantizado() {
        return this.jdbcTemplate.update(this.sqlIndexTempAusenciasDateMinimoGarantizado);
    }

    @Override
    public void insertTempAusenciasDateMinimoGarantizado(final TareaDto tarea) {
        final MapSqlParameterSource map = new MapSqlParameterSource();
        if (tarea != null) {
            map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        }
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA,
                TipoPoliticaEnum.MINIMO_GARANTIZADO.getId());
        this.namedParameterJdbcTemplate.update(this.sqlInsertTempAusenciasDateMinimoGarantizado, map);
    }

    @Override
    public int createTempCalculoConAjusteMinimoGarantizado() {
        return this.jdbcTemplate.update(this.sqlCreateTempCalculoConAjusteMinimoGarantizado);
    }

    @Override
    public int deleteTempCalculoConAjusteMinimoGarantizado() {
        return this.jdbcTemplate.update(this.sqlDeleteTempCalculoConAjusteMinimoGarantizado);
    }

    @Override
    public int createIndexTempCalculoConAjusteMinimoGarantizado() {
        return this.jdbcTemplate.update(this.sqlIndexTempCalculoConAjusteMinimoGarantizado);
    }

    @Override
    public void insertTempCalculoConAjusteMinimoGarantizado(
            final TareaDto tarea) {
        final MapSqlParameterSource map = new MapSqlParameterSource();
        if (tarea != null) {
            map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        }
        map.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE,
                Arrays.asList(TipoPoliticaEnum.ANTIGUEDAD.getId(),
                        TipoPoliticaEnum.VACACIONES.getId(),
                        TipoPoliticaEnum.BAJA_IT.getId()));
        this.namedParameterJdbcTemplate.update(this.sqlInsertTempCalculoConAjusteMinimoGarantizado, map);
    }

    @Override
    public int createTempDatosMinimoGarantizado() {
        return this.jdbcTemplate.update(this.sqlCreateTempDatosMinimoGarantizado);
    }

    @Override
    public int deleteTempDatosMinimoGarantizado() {
        return this.jdbcTemplate.update(this.sqlDeleteTempDatosMinimoGarantizado);
    }

    @Override
    public int createIndexTempDatosMinimoGarantizado() {
        return this.jdbcTemplate.update(this.sqlIndexTempDatosMinimoGarantizado);
    }

    @Override
    public void insertTempDatosMininimoGarantizado(final TareaDto tarea) {
        final MapSqlParameterSource map = new MapSqlParameterSource();
        if (tarea != null) {
            map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        }
        map.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA, TipoPoliticaEnum.MINIMO_GARANTIZADO.getId());
        this.namedParameterJdbcTemplate.update(this.sqlInsertTempDatosMinimoGarantizado, map);
    }

    @Override
    public int createTempFechasCarencia() {
        return this.jdbcTemplate.update(this.sqlCreateTempFechasCarencia);
    }

    @Override
    public int deleteTempFechasCarencia() {
        return this.jdbcTemplate.update(this.sqlDeleteTempFechasCarencia);
    }

    @Override
    public void insertTempFechasCarencia() {
        final MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS, TipoUnidadTiempoEnum.ANOS.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES, TipoUnidadTiempoEnum.MESES.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS, TipoUnidadTiempoEnum.SEMANAS.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS, TipoUnidadTiempoEnum.DIAS.getId());
        this.namedParameterJdbcTemplate.update(this.sqlInsertTempFechasCarencia, map);
    }

    @Override
    public int createIndexTempFechasCarencia() {
        return this.jdbcTemplate.update(this.sqlIndexTempFechasCarencia);
    }

    @Override
    public int createTempFechasAcumuladasCarencia() {
        return this.jdbcTemplate.update(this.sqlCreateTempFechasAcumuladasCarencia);
    }

    @Override
    public int deleteTempFechasAcumuladasCarencia() {
        return this.jdbcTemplate.update(this.sqlDeleteTempFechasAcumuladasCarencia);
    }

    @Override
    public void insertTempFechasAcumuladasCarencia() {
        final MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS, TipoUnidadTiempoEnum.ANOS.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES, TipoUnidadTiempoEnum.MESES.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS, TipoUnidadTiempoEnum.SEMANAS.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS, TipoUnidadTiempoEnum.DIAS.getId());
        this.namedParameterJdbcTemplate.update(this.sqlInsertTempFechasAcumuladasCarencia, map);
    }

    @Override
    public int createIndexTempFechasAcumuladasCarencia() {
        return this.jdbcTemplate.update(this.sqlIndexTempFechasAcumuladasCarencia);
    }

    @Override
    public int createTempCalculoTotalizadoCarencia() {
        return this.jdbcTemplate.update(this.sqlCreateTempCalculoTotalizadoCarencia);
    }

    @Override
    public int deleteTempCalculoTotalizadoCarencia() {
        return this.jdbcTemplate.update(this.sqlDeleteTempCalculoTotalizadoCarencia);
    }

    @Override
    public void insertTempCalculoTotalizadoCarencia(final TareaDto tarea) {
        final MapSqlParameterSource map = new MapSqlParameterSource();
        if (tarea != null) {
            map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        }
        map.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        this.namedParameterJdbcTemplate.update(this.sqlInsertTempCalculoTotalizadoCarencia, map);
    }

    @Override
    public int createIndexTempCalculoTotalizadoCarencia() {
        return this.jdbcTemplate.update(this.sqlIndexTempCalculoTotalizadoCarencia);
    }

}
