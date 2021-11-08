/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author javierev
 */
@ExtendWith(SpringExtension.class)
class PrimaryTemporaryTablePoliticasRepositoryCustomTest {

    private static final Integer UPDATE_RESULT = 100;

    private static final long ID_TAREA = 123L;

    // baja it

    private static final String SQL_CREATE_TEMP_FECHAS_BAJA_IT = "SQL CREATE TEMP FECHAS BAJA IT";

    private static final String SQL_DELETE_TEMP_FECHAS_BAJA_IT = "SQL DELETE TEMP FECHAS BAJA IT";

    private static final String SQL_INSERT_TEMP_FECHAS_BAJA_IT = "SQL INSERT TEMP FECHAS BAJA IT";

    private static final String SQL_INDEX_TEMP_FECHAS_BAJA_IT = "SQL INDEX TEMP FECHAS BAJA IT";

    private static final String SQL_CREATE_TEMP_FECHAS_ACUMULADAS_BAJA_IT = "SQL CREATE TEMP FECHAS ACUMULADAS BAJA IT";

    private static final String SQL_DELETE_TEMP_FECHAS_ACUMULADAS_BAJA_IT = "SQL DELETE TEMP FECHAS ACUMULADAS BAJA IT";

    private static final String SQL_INSERT_TEMP_FECHAS_ACUMULADAS_BAJA_IT = "SQL INSERT TEMP FECHAS ACUMULADAS BAJA IT";

    private static final String SQL_INDEX_TEMP_FECHAS_ACUMULADAS_BAJA_IT = "SQL INDEX TEMP FECHAS ACUMULADAS BAJA IT";

    private static final String SQL_CREATE_TEMP_CALULO_TOTALIZADO_BAJA_IT = "SQL CREATE TEMP CALCULO TOTALIZADO BAJA IT";

    private static final String SQL_DELETE_TEMP_CALCULO_TOTALIZADO_BAJA_IT = "SQL DELETE TEMP CALCULO TOTALIZADO BAJA IT";

    private static final String SQL_INSERT_TEMP_CALCULO_TOTALIZADO_BAJA_IT = "SQL INSERT TEMP CALCULO TOTALIZADO BAJA IT";

    private static final String SQL_INDEX_TEMP_CALCULO_TOTALIZADO_BAJA_IT = "SQL INDEX TEMP CALCULO TOTALIZADO BAJA IT";

    // Antiguedad

    private static final String SQL_CREATE_TEMP_FECHAS_ANTIGUEDAD = "SQL CREATE TEMP FECHAS ANTIGUEDAD";

    private static final String SQL_DELETE_TEMP_FECHAS_ANTIGUEDAD = "SQL DELETE TEMP FECHAS ANTIGUEDAD";

    private static final String SQL_INSERT_TEMP_FECHAS_ANTIGUEDAD = "SQL INSERT TEMP FECHAS ANTIGUEDAD";

    private static final String SQL_INDEX_TEMP_FECHAS_ANTIGUEDAD = "SQL INDEX TEMP FECHAS ANTIGUEDAD";

    private static final String SQL_CREATE_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD = "SQL CREATE TEMP FECHAS ACUMULADAS ANTIGUEDAD";

    private static final String SQL_DELETE_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD = "SQL DELETE TEMP FECHAS ACUMULADAS ANTIGUEDAD";

    private static final String SQL_INSERT_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD = "SQL INSERT TEMP FECHAS ACUMULADAS ANTIGUEDAD";

    private static final String SQL_INDEX_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD = "SQL INDEX TEMP FECHAS ACUMULADAS ANTIGUEDAD";

    // Vacaciones

    private static final String SQL_CREATE_TEMP_FECHAS_VACACIONES = "SQL CREATE TEMP FECHAS VACACIONES";

    private static final String SQL_DELETE_TEMP_FECHAS_VACACIONES = "SQL DELETE TEMP FECHAS VACACIONES";

    private static final String SQL_INSERT_TEMP_FECHAS_VACACIONES = "SQL INSERT TEMP FECHAS VACACIONES";

    private static final String SQL_INDEX_TEMP_FECHAS_VACACIONES = "SQL INDEX TEMP FECHAS VACACIONES";

    private static final String SQL_CREATE_TEMP_FECHAS_ACUMULADAS_VACACIONES = "SQL CREATE TEMP FECHAS ACUMULADAS VACACIONES";

    private static final String SQL_DELETE_TEMP_FECHAS_ACUMULADAS_VACACIONES = "SQL DELETE TEMP FECHAS ACUMULADAS VACACIONES";

    private static final String SQL_INSERT_TEMP_FECHAS_ACUMULADAS_VACACIONES = "SQL INSERT TEMP FECHAS ACUMULADAS VACACIONES";

    private static final String SQL_INDEX_TEMP_FECHAS_ACUMULADAS_VACACIONES = "SQL INDEX TEMP FECHAS ACUMULADAS VACACIONES";

    private static final String SQL_CREATE_TEMP_CALULO_TOTALIZADO_VACACIONES = "SQL CREATE TEMP CALCULO TOTALIZADO VACACIONES";

    private static final String SQL_DELETE_TEMP_CALCULO_TOTALIZADO_VACACIONES = "SQL DELETE TEMP CALCULO TOTALIZADO VACACIONES";

    private static final String SQL_INSERT_TEMP_CALCULO_TOTALIZADO_VACACIONES = "SQL INSERT TEMP CALCULO TOTALIZADO VACACIONES";

    private static final String SQL_INDEX_TEMP_CALCULO_TOTALIZADO_VACACIONES = "SQL INDEX TEMP CALCULO TOTALIZADO VACACIONES";

    // Máximo / Mínimo garantizado (común)

    private static final String SQL_CREATE_TEMP_AUSENCIAS_DATE_MAX_MIN_GARANTIZADO = "SQL CREATE TEMP AUSENCIAS DATE MAX MIN GARANTIZADO";

    private static final String SQL_DELETE_TEMP_AUSENCIAS_DATE_MAX_MIN_GARANTIZADO = "SQL DELETE TEMP AUSENCIAS DATE MAX MIN GARANTIZADO";

    private static final String SQL_INSERT_TEMP_AUSENCIAS_DATE_MAX_MIN_GARANTIZADO = "SQL INSERT TEMP AUSENCIAS DATE MAX MIN GARANTIZADO";

    private static final String SQL_INDEX_TEMP_AUSENCIAS_DATE_MAX_GARANTIZADO = "SQL INDEX TEMP AUSENCIAS DATE MAX  GARANTIZADO";

    private static final String SQL_INDEX_TEMP_AUSENCIAS_DATE_MIN_GARANTIZADO = "SQL INDEX TEMP AUSENCIAS DATE  MIN GARANTIZADO";

    private static final String SQL_CREATE_TEMP_CALCULO_CON_AJUSTE_MAX_MIN_GARANTIZADO = "SQL CREATE TEMP CALCULO CON AJUSTE MAX MIN GARANTIZADO";

    private static final String SQL_DELETE_TEMP_CALCULO_CON_AJUSTE_MAX_MIN_GARANTIZADO = "SQL DELETE TEMP CALCULO CON AJUSTE MAX MIN GARANTIZADO";

    private static final String SQL_INSERT_TEMP_CALCULO_CON_AJUSTE_MAX_MIN_GARANTIZADO = "SQL INSERT TEMP CALCULO CON AJUSTE MAX MIN GARANTIZADO";

    private static final String SQL_INDEX_TEMP_CALCULO_CON_AJUSTE_MAX_MIN_GARANTIZADO = "SQL INDEX TEMP CALCULO CON AJUSTE MAX MIN GARANTIZADO";

    private static final String SQL_CREATE_TEMP_DATOS_MAX_MIN_GARANTIZADO = "SQL CREATE TEMP DATOS MAX MIN GARANTIZADO";

    private static final String SQL_DELETE_TEMP_DATOS_MAX_MIN_GARANTIZADO = "SQL DELETE TEMP DATOS MAX MIN GARANTIZADO";

    private static final String SQL_INDEX_TEMP_DATOS_MAX_MIN_GARANTIZADO = "SQL INDEX TEMP DATOS MAX MIN GARANTIZADO";

    private static final String SQL_INSERT_TEMP_DATOS_MAX_GARANTIZADO = "SQL INSERT TEMP DATOS MAX GARANTIZADO";

    private static final String SQL_INSERT_TEMP_DATOS_MIN_GARANTIZADO = "SQL INSERT TEMP DATOS MIN GARANTIZADO";


    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private TareaAmbitoService tareaAmbitoService;

    @Mock
    private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @InjectMocks
    private PrimaryTemporaryTablePoliticasRepositoryCustomImpl primaryTemporaryTablePoliticasRepositoryCustom;

    @BeforeEach
    public void setup() throws IllegalAccessException {
        when(this.jdbcTemplate.update(any(String.class))).thenReturn(UPDATE_RESULT);
        // baja it
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlCreateTempFechasBajaIt", SQL_CREATE_TEMP_FECHAS_BAJA_IT, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlDeleteTempFechasBajaIt", SQL_DELETE_TEMP_FECHAS_BAJA_IT, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlInsertTempFechasBajaIt", SQL_INSERT_TEMP_FECHAS_BAJA_IT, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlIndexTempFechasBajaIt", SQL_INDEX_TEMP_FECHAS_BAJA_IT, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlCreateTempFechasAcumuladasBajaIt", SQL_CREATE_TEMP_FECHAS_ACUMULADAS_BAJA_IT, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlDeleteTempFechasAcumuladasBajaIt", SQL_DELETE_TEMP_FECHAS_ACUMULADAS_BAJA_IT, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlInsertTempFechasAcumuladasBajaIt", SQL_INSERT_TEMP_FECHAS_ACUMULADAS_BAJA_IT, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlIndexTempFechasAcumuladasBajaIt", SQL_INDEX_TEMP_FECHAS_ACUMULADAS_BAJA_IT, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlCreateTempCalculoTotalizadoBajaIt", SQL_CREATE_TEMP_CALULO_TOTALIZADO_BAJA_IT, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlDeleteTempCalculoTotalizadoBajaIt", SQL_DELETE_TEMP_CALCULO_TOTALIZADO_BAJA_IT, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlInsertTempCalculoTotalizadoBajaIt", SQL_INSERT_TEMP_CALCULO_TOTALIZADO_BAJA_IT, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlIndexTempCalculoTotalizadoBajaIt", SQL_INDEX_TEMP_CALCULO_TOTALIZADO_BAJA_IT, true);
        // Antiguedad
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlCreateTempFechasAntiguedad", SQL_CREATE_TEMP_FECHAS_ANTIGUEDAD, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlDeleteTempFechasAntiguedad", SQL_DELETE_TEMP_FECHAS_ANTIGUEDAD, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlInsertTempFechasAntiguedad", SQL_INSERT_TEMP_FECHAS_ANTIGUEDAD, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlIndexTempFechasAntiguedad", SQL_INDEX_TEMP_FECHAS_ANTIGUEDAD, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlCreateTempFechasAcumuladasAntiguedad", SQL_CREATE_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlDeleteTempFechasAcumuladasAntiguedad", SQL_DELETE_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlInsertTempFechasAcumuladasAntiguedad", SQL_INSERT_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlIndexTempFechasAcumuladasAntiguedad", SQL_INDEX_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD, true);
        // Vacaciones
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlCreateTempFechasVacaciones", SQL_CREATE_TEMP_FECHAS_VACACIONES, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlDeleteTempFechasVacaciones", SQL_DELETE_TEMP_FECHAS_VACACIONES, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlInsertTempFechasVacaciones", SQL_INSERT_TEMP_FECHAS_VACACIONES, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlIndexTempFechasVacaciones", SQL_INDEX_TEMP_FECHAS_VACACIONES, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlCreateTempFechasAcumuladasVacaciones", SQL_CREATE_TEMP_FECHAS_ACUMULADAS_VACACIONES, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlDeleteTempFechasAcumuladasVacaciones", SQL_DELETE_TEMP_FECHAS_ACUMULADAS_VACACIONES, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlInsertTempFechasAcumuladasVacaciones", SQL_INSERT_TEMP_FECHAS_ACUMULADAS_VACACIONES, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlIndexTempFechasAcumuladasVacaciones", SQL_INDEX_TEMP_FECHAS_ACUMULADAS_VACACIONES, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlCreateTempCalculoTotalizadoVacaciones", SQL_CREATE_TEMP_CALULO_TOTALIZADO_VACACIONES, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlDeleteTempCalculoTotalizadoVacaciones", SQL_DELETE_TEMP_CALCULO_TOTALIZADO_VACACIONES, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlInsertTempCalculoTotalizadoVacaciones", SQL_INSERT_TEMP_CALCULO_TOTALIZADO_VACACIONES, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlIndexTempCalculoTotalizadoVacaciones", SQL_INDEX_TEMP_CALCULO_TOTALIZADO_VACACIONES, true);
        // Máximo / Mínimo garantizado
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlCreateTempAusenciasDateMaxMinGarantizado", SQL_CREATE_TEMP_AUSENCIAS_DATE_MAX_MIN_GARANTIZADO,
                true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlDeleteTempAusenciasDateMaxMinGarantizado", SQL_DELETE_TEMP_AUSENCIAS_DATE_MAX_MIN_GARANTIZADO,
                true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlInsertTempAusenciasDateMaxMinGarantizado", SQL_INSERT_TEMP_AUSENCIAS_DATE_MAX_MIN_GARANTIZADO,
                true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlIndexTempAusenciasDateMinGarantizado", SQL_INDEX_TEMP_AUSENCIAS_DATE_MIN_GARANTIZADO, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlIndexTempAusenciasDateMaxGarantizado", SQL_INDEX_TEMP_AUSENCIAS_DATE_MAX_GARANTIZADO, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlCreateTempCalculoConAjusteMaxMinGarantizado",
                SQL_CREATE_TEMP_CALCULO_CON_AJUSTE_MAX_MIN_GARANTIZADO,
                true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlDeleteTempCalculoConAjusteMaxMinGarantizado",
                SQL_DELETE_TEMP_CALCULO_CON_AJUSTE_MAX_MIN_GARANTIZADO,
                true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlInsertTempCalculoConAjusteMaxMinGarantizado",
                SQL_INSERT_TEMP_CALCULO_CON_AJUSTE_MAX_MIN_GARANTIZADO,
                true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlIndexTempCalculoConAjusteMaxMinGarantizado", SQL_INDEX_TEMP_CALCULO_CON_AJUSTE_MAX_MIN_GARANTIZADO,
                true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlCreateTempDatosMaxMinGarantizado", SQL_CREATE_TEMP_DATOS_MAX_MIN_GARANTIZADO, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlDeleteTempDatosMaxMinGarantizado", SQL_DELETE_TEMP_DATOS_MAX_MIN_GARANTIZADO, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlInsertTempDatosMinGarantizado", SQL_INSERT_TEMP_DATOS_MIN_GARANTIZADO, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlInsertTempDatosMaxGarantizado", SQL_INSERT_TEMP_DATOS_MAX_GARANTIZADO, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlIndexTempDatosMaxMinGarantizado", SQL_INDEX_TEMP_DATOS_MAX_MIN_GARANTIZADO, true);
    }

    private TareaDto createTarea() {
        final TareaDto tarea = new TareaDto();
        tarea.setId(ID_TAREA);
        return tarea;
    }

    // Inicio tests baja it

    @Test
    void createTempFechasBajaItTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasBajaIt();
        verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_FECHAS_BAJA_IT);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void deleteTempFechasBajaItTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasBajaIt();
        verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_FECHAS_BAJA_IT);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void createIndexTempFechasBajaItTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createIndexTempFechasBajaIt();
        verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_FECHAS_BAJA_IT);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void insertTempFechasBajaItNumArgumentosTareaNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasBajaIt(null);
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_BAJA_IT),
                this.paramsCaptor.capture());
        assertEquals(8, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempFechasBajaItNumArgumentosTareaNotNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasBajaIt(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_BAJA_IT),
                this.paramsCaptor.capture());
        assertEquals(9, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempFechasBajaItUnidadTiempoAnosTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasBajaIt(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_BAJA_IT),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));
        assertEquals(TipoUnidadTiempoEnum.ANOS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));

    }

    @Test
    void insertTempFechasBajaItUnidadTiempoMesesTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasBajaIt(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_BAJA_IT),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));
        assertEquals(TipoUnidadTiempoEnum.MESES.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));

    }

    @Test
    void insertTempFechasBajaItUnidadTiempoSemanasTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasBajaIt(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_BAJA_IT),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));
        assertEquals(TipoUnidadTiempoEnum.SEMANAS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));

    }

    @Test
    void insertTempFechasBajaItUnidadTiempoDiasTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasBajaIt(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_BAJA_IT),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));
        assertEquals(TipoUnidadTiempoEnum.DIAS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));

    }

    @Test
    void insertTempFechasBajaItIdTipoPoliticaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasBajaIt(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_BAJA_IT),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));
        assertEquals(TipoPoliticaEnum.BAJA_IT.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));

    }

    @Test
    void insertTempFechasBajaItIdTipoAusenciaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasBajaIt(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_BAJA_IT),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_AUSENCIA));
        assertEquals(TipoAusenciaEnum.BAJA_IT.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_AUSENCIA));

    }

    @Test
    void insertTempFechasBajaItIdTareaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasBajaIt(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_BAJA_IT),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(ID_TAREA, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

    }

    @Test
    void insertTempFechasBajaItIdSistemaDestinoSolucionGlobalTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasBajaIt(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_BAJA_IT),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_SISTEMA_DESTINO_SOLUCION_GLOBAL));
        assertEquals(SistemaDestinoEnum.SOLUCION_GLOBAL.getIdMeta4(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_SISTEMA_DESTINO_SOLUCION_GLOBAL));

    }

    @Test
    void insertTempFechasBajaItIdSistemaDestinoTareaNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasBajaIt(null);
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_BAJA_IT),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_SISTEMA_DESTINO));
        assertEquals(SistemaDestinoEnum.NONE.getIdMeta4(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_SISTEMA_DESTINO));

    }

    @Test
    void insertTempFechasBajaItIdSistemaDestinoSinAmbitoTest() {

        when(this.tareaAmbitoService.findByTarea(any(TareaDto.class))).thenReturn(new ArrayList<>());
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasBajaIt(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_BAJA_IT),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_SISTEMA_DESTINO));
        assertEquals(SistemaDestinoEnum.NONE.getIdMeta4(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_SISTEMA_DESTINO));

    }

    @Test
    void insertTempFechasBajaItIdSistemaDestinoConAmbitoTest() {

        final String idOrigen = "idOrigen";
        final String idSistemaDestino = "idSistemaDestino";
        when(this.tareaAmbitoService.findByTarea(any(TareaDto.class))).thenReturn(Collections.singletonList(
                TareaAmbitoDto
                    .builder()
                    .cclIdOrigen(idOrigen)
                    .build()));
        when(this.meta4IcmWsCalcIncomeService.getSistemaDestino(any(SistemaDestinoRequestDto.class))).thenReturn(
                SistemaDestinoResponseDto.builder()
                    .idSistemaDestino(idSistemaDestino)
                    .build());

        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasBajaIt(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_BAJA_IT),
                this.paramsCaptor.capture());
        verify(this.meta4IcmWsCalcIncomeService, times(1))
            .getSistemaDestino(SistemaDestinoRequestDto.builder().cclIdOrigen(idOrigen).build());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_SISTEMA_DESTINO));
        assertEquals(idSistemaDestino,
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_SISTEMA_DESTINO));

    }

    @Test
    void createTempFechasAcumuladasBajaItTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAcumuladasBajaIt();
        verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_FECHAS_ACUMULADAS_BAJA_IT);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void deleteTempFechasAcumuladasBajaItTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAcumuladasBajaIt();
        verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_FECHAS_ACUMULADAS_BAJA_IT);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void createIndexTempFechasAcumuladasBajaItTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createIndexTempFechasAcumuladasBajaIt();
        verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_FECHAS_ACUMULADAS_BAJA_IT);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void insertTempFechasAcumuladasBajaItNumArgumentosTareaNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasBajaIt(null);
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_BAJA_IT),
                this.paramsCaptor.capture());
        assertEquals(5, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempFechasAcumuladasBajaItNumArgumentosTareaNotNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasBajaIt(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_BAJA_IT),
                this.paramsCaptor.capture());
        assertEquals(6, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempFechasAcumuladasBajaItUnidadTiempoAnosTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasBajaIt(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_BAJA_IT),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));
        assertEquals(TipoUnidadTiempoEnum.ANOS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));

    }

    @Test
    void insertTempFechasAcumuladasBajaItUnidadTiempoMesesTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasBajaIt(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_BAJA_IT),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));
        assertEquals(TipoUnidadTiempoEnum.MESES.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));

    }

    @Test
    void insertTempFechasAcumuladasBajaItUnidadTiempoSemanasTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasBajaIt(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_BAJA_IT),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));
        assertEquals(TipoUnidadTiempoEnum.SEMANAS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));

    }

    @Test
    void insertTempFechasAcumuladasBajaItUnidadTiempoDiasTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasBajaIt(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_BAJA_IT),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));
        assertEquals(TipoUnidadTiempoEnum.DIAS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));

    }

    @Test
    void insertTempFechasAcumuladasBajaItIdTipoPoliticaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasBajaIt(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_BAJA_IT),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));
        assertEquals(TipoPoliticaEnum.BAJA_IT.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));

    }

    @Test
    void insertTempFechasAcumuladasBajaItIdTareaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasBajaIt(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_BAJA_IT),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(ID_TAREA, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

    }

    @Test
    void createTempCalculoTotalizadoBajaItTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.createTempCalculoTotalizadoBajaIt();
        verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_CALULO_TOTALIZADO_BAJA_IT);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void deleteTempCalculoTotalizadoBajaItTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempCalculoTotalizadoBajaIt();
        verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_CALCULO_TOTALIZADO_BAJA_IT);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void createIndexTempCalculoTotalizadoBajaItTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createIndexTempCalculoTotalizadoBajaIt();
        verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_CALCULO_TOTALIZADO_BAJA_IT);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void insertTempCalculoTotalizadoBajaItNumArgumentosTareaNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoTotalizadoBajaIt(null);
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_CALCULO_TOTALIZADO_BAJA_IT),
                this.paramsCaptor.capture());
        assertEquals(2, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempCalculoTotalizadoBajaItNumArgumentosTareaNotNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoTotalizadoBajaIt(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_CALCULO_TOTALIZADO_BAJA_IT),
                this.paramsCaptor.capture());
        assertEquals(3, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempCalculoTotalizadoBajaItIdTareaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoTotalizadoBajaIt(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_CALCULO_TOTALIZADO_BAJA_IT),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(ID_TAREA, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

    }

    @Test
    void insertTempCalculoTotalizadoBajaItInactivoTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoTotalizadoBajaIt(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_CALCULO_TOTALIZADO_BAJA_IT),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
                params.getValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));

    }

    @Test
    void insertTempCalculoTotalizadoBajaItIdTipoPoliticaAjusteTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoTotalizadoBajaIt(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_CALCULO_TOTALIZADO_BAJA_IT),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE));
        assertNotNull(params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE));
        assertTrue(params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE) instanceof List);
        final List<?> param = (List<?>) params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE);
        if (param != null) {
            assertEquals(1, param.size());
            assertEquals(TipoPoliticaEnum.ANTIGUEDAD.getIdMeta4(), param.get(0));
        }

    }

    // Fin tests baja it

    // Inicio tests antiguedad

    @Test
    void createTempFechasAntiguedadTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAntiguedad();
        verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_FECHAS_ANTIGUEDAD);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void deleteTempFechasAntiguedadTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAntiguedad();
        verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_FECHAS_ANTIGUEDAD);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void createIndexTempFechasAntiguedadTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createIndexTempFechasAntiguedad();
        verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_FECHAS_ANTIGUEDAD);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void insertTempFechasAntiguedadNumArgumentosTareaNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAntiguedad(null);
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ANTIGUEDAD),
                this.paramsCaptor.capture());
        assertEquals(5, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempFechasAntiguedadNumArgumentosTareaNotNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAntiguedad(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ANTIGUEDAD),
                this.paramsCaptor.capture());
        assertEquals(6, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempFechasAntiguedadUnidadTiempoAnosTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAntiguedad(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ANTIGUEDAD),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));
        assertEquals(TipoUnidadTiempoEnum.ANOS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));

    }

    @Test
    void insertTempFechasAntiguedadUnidadTiempoMesesTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAntiguedad(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ANTIGUEDAD),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));
        assertEquals(TipoUnidadTiempoEnum.MESES.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));

    }

    @Test
    void insertTempFechasAntiguedadUnidadTiempoSemanasTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAntiguedad(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ANTIGUEDAD),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));
        assertEquals(TipoUnidadTiempoEnum.SEMANAS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));

    }

    @Test
    void insertTempFechasAntiguedadUnidadTiempoDiasTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAntiguedad(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ANTIGUEDAD),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));
        assertEquals(TipoUnidadTiempoEnum.DIAS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));

    }

    @Test
    void insertTempFechasAntiguedadIdTipoPoliticaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAntiguedad(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ANTIGUEDAD),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));
        assertEquals(TipoPoliticaEnum.ANTIGUEDAD.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));

    }

    @Test
    void insertTempFechasAntiguedadIdTareaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAntiguedad(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ANTIGUEDAD),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(ID_TAREA, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

    }

    @Test
    void createTempFechasAcumuladasAntiguedadTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAcumuladasAntiguedad();
        verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void deleteTempFechasAcumuladasAntiguedadTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAcumuladasAntiguedad();
        verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void createIndexTempFechasAcumuladasAntiguedadTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createIndexTempFechasAcumuladasAntiguedad();
        verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void insertTempFechasAcumuladasAntiguedadNumArgumentosTareaNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasAntiguedad(null);
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD),
                this.paramsCaptor.capture());
        assertEquals(5, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempFechasAcumuladasAntiguedadNumArgumentosTareaNotNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasAntiguedad(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD),
                this.paramsCaptor.capture());
        assertEquals(6, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempFechasAcumuladasAntiguedadUnidadTiempoAnosTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasAntiguedad(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));
        assertEquals(TipoUnidadTiempoEnum.ANOS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));

    }

    @Test
    void insertTempFechasAcumuladasAntiguedadUnidadTiempoMesesTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasAntiguedad(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));
        assertEquals(TipoUnidadTiempoEnum.MESES.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));

    }

    @Test
    void insertTempFechasAcumuladasAntiguedadUnidadTiempoSemanasTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasAntiguedad(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));
        assertEquals(TipoUnidadTiempoEnum.SEMANAS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));

    }

    @Test
    void insertTempFechasAcumuladasAntiguedadUnidadTiempoDiasTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasAntiguedad(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));
        assertEquals(TipoUnidadTiempoEnum.DIAS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));

    }

    @Test
    void insertTempFechasAcumuladasAntiguedadIdTipoPoliticaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasAntiguedad(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));
        assertEquals(TipoPoliticaEnum.ANTIGUEDAD.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));

    }

    @Test
    void insertTempFechasAcumuladasAntiguedadIdTareaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasAntiguedad(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(ID_TAREA, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

    }

    // Fin tests antiguedad

    // Inicio tests vacaciones

    @Test
    void createTempFechasVacacionesTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasVacaciones();
        verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_FECHAS_VACACIONES);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void deleteTempFechasVacacionesTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasVacaciones();
        verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_FECHAS_VACACIONES);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void createIndexTempFechasVacacionesTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createIndexTempFechasVacaciones();
        verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_FECHAS_VACACIONES);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void insertTempFechasVacacionesNumArgumentosTareaNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasVacaciones(null);
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_VACACIONES),
                this.paramsCaptor.capture());
        assertEquals(6, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempFechasVacacionesNumArgumentosTareaNotNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasVacaciones(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_VACACIONES),
                this.paramsCaptor.capture());
        assertEquals(7, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempFechasVacacionesUnidadTiempoAnosTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasVacaciones(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_VACACIONES),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));
        assertEquals(TipoUnidadTiempoEnum.ANOS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));

    }

    @Test
    void insertTempFechasVacacionesUnidadTiempoMesesTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasVacaciones(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_VACACIONES),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));
        assertEquals(TipoUnidadTiempoEnum.MESES.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));

    }

    @Test
    void insertTempFechasVacacionesUnidadTiempoSemanasTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasVacaciones(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_VACACIONES),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));
        assertEquals(TipoUnidadTiempoEnum.SEMANAS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));

    }

    @Test
    void insertTempFechasVacacionesUnidadTiempoDiasTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasVacaciones(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_VACACIONES),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));
        assertEquals(TipoUnidadTiempoEnum.DIAS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));

    }

    @Test
    void insertTempFechasVacacionesIdTipoPoliticaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasVacaciones(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_VACACIONES),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));
        assertEquals(TipoPoliticaEnum.VACACIONES.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));

    }

    @Test
    void insertTempFechasVacacionesIdTipoAusenciaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasVacaciones(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_VACACIONES),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_AUSENCIA));
        assertEquals(TipoAusenciaEnum.VACACIONES.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_AUSENCIA));

    }

    @Test
    void insertTempFechasVacacionesIdTareaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasVacaciones(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_VACACIONES),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(ID_TAREA, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

    }

    @Test
    void createTempFechasAcumuladasVacacionesTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAcumuladasVacaciones();
        verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_FECHAS_ACUMULADAS_VACACIONES);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void deleteTempFechasAcumuladasVacacionesTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAcumuladasVacaciones();
        verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_FECHAS_ACUMULADAS_VACACIONES);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void createIndexTempFechasAcumuladasVacacionesTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createIndexTempFechasAcumuladasVacaciones();
        verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_FECHAS_ACUMULADAS_VACACIONES);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void insertTempFechasAcumuladasVacacionesNumArgumentosTareaNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasVacaciones(null);
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_VACACIONES),
                this.paramsCaptor.capture());
        assertEquals(5, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempFechasAcumuladasVacacionesNumArgumentosTareaNotNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasVacaciones(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_VACACIONES),
                this.paramsCaptor.capture());
        assertEquals(6, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempFechasAcumuladasVacacionesUnidadTiempoAnosTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasVacaciones(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_VACACIONES),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));
        assertEquals(TipoUnidadTiempoEnum.ANOS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));

    }

    @Test
    void insertTempFechasAcumuladasVacacionesUnidadTiempoMesesTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasVacaciones(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_VACACIONES),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));
        assertEquals(TipoUnidadTiempoEnum.MESES.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));

    }

    @Test
    void insertTempFechasAcumuladasVacacionesUnidadTiempoSemanasTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasVacaciones(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_VACACIONES),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));
        assertEquals(TipoUnidadTiempoEnum.SEMANAS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));

    }

    @Test
    void insertTempFechasAcumuladasVacacionesUnidadTiempoDiasTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasVacaciones(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_VACACIONES),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));
        assertEquals(TipoUnidadTiempoEnum.DIAS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));

    }

    @Test
    void insertTempFechasAcumuladasVacacionesIdTipoPoliticaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasVacaciones(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_VACACIONES),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));
        assertEquals(TipoPoliticaEnum.VACACIONES.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));

    }

    @Test
    void insertTempFechasAcumuladasVacacionesIdTareaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasVacaciones(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_VACACIONES),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(ID_TAREA, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

    }

    @Test
    void createTempCalculoTotalizadoVacacionesTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.createTempCalculoTotalizadoVacaciones();
        verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_CALULO_TOTALIZADO_VACACIONES);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void deleteTempCalculoTotalizadoVacacionesTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempCalculoTotalizadoVacaciones();
        verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_CALCULO_TOTALIZADO_VACACIONES);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void createIndexTempCalculoTotalizadoVacacionesTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createIndexTempCalculoTotalizadoVacaciones();
        verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_CALCULO_TOTALIZADO_VACACIONES);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void insertTempCalculoTotalizadoVacacionesNumArgumentosTareaNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoTotalizadoVacaciones(null);
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_CALCULO_TOTALIZADO_VACACIONES),
                this.paramsCaptor.capture());
        assertEquals(2, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempCalculoTotalizadoVacacionesNumArgumentosTareaNotNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoTotalizadoVacaciones(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_CALCULO_TOTALIZADO_VACACIONES),
                this.paramsCaptor.capture());
        assertEquals(3, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempCalculoTotalizadoVacacionesIdTareaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoTotalizadoVacaciones(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_CALCULO_TOTALIZADO_VACACIONES),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(ID_TAREA, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

    }

    @Test
    void insertTempCalculoTotalizadoVacacionesInactivoTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoTotalizadoVacaciones(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_CALCULO_TOTALIZADO_VACACIONES),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
                params.getValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));

    }

    @Test
    void insertTempCalculoTotalizadoVacacionesIdTipoPoliticaAjusteTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoTotalizadoVacaciones(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_CALCULO_TOTALIZADO_VACACIONES),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE));
        assertNotNull(params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE));
        assertTrue(params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE) instanceof List);
        final List<?> param = (List<?>) params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE);
        if (param != null) {
            assertEquals(1, param.size());
            assertEquals(TipoPoliticaEnum.VACACIONES.getIdMeta4(), param.get(0));
        }

    }

    // Fin tests baja it

    // Inicio tests máximo / mínimo garantizado (común)

    @Test
    void createTempAusenciasDateMaxMinGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createTempAusenciasDateMaxMinGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_AUSENCIAS_DATE_MAX_MIN_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void deleteTempAusenciasDateMaxMinGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .deleteTempAusenciasDateMaxMinGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_AUSENCIAS_DATE_MAX_MIN_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void createIndexTempAusenciasDateMaxGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createIndexTempAusenciasDateMaxGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_AUSENCIAS_DATE_MAX_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void createIndexTempAusenciasDateMinGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createIndexTempAusenciasDateMinGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_AUSENCIAS_DATE_MIN_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void insertTempAusenciasDateMaxMinGarantizadoNumArgumentosTareaNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempAusenciasDateMaxMinGarantizado(null);
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_AUSENCIAS_DATE_MAX_MIN_GARANTIZADO),
                this.paramsCaptor.capture());
        assertEquals(2, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempAusenciasDateMaxMinGarantizadoNumArgumentosTareaNotNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempAusenciasDateMaxMinGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_AUSENCIAS_DATE_MAX_MIN_GARANTIZADO),
                this.paramsCaptor.capture());
        assertEquals(3, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempAusenciasDateMaxMinGarantizadoIdTipoPoliticaMaxGarantizadoTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempAusenciasDateMaxMinGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_AUSENCIAS_DATE_MAX_MIN_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_MAXIMO_GARANTIZADO));
        assertEquals(TipoPoliticaEnum.MAXIMO_GARANTIZADO.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_MAXIMO_GARANTIZADO));

    }

    @Test
    void insertTempAusenciasDateMaxMinGarantizadoIdTipoPoliticaMinGarantizadoTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempAusenciasDateMaxMinGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_AUSENCIAS_DATE_MAX_MIN_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_MINIMO_GARANTIZADO));
        assertEquals(TipoPoliticaEnum.MINIMO_GARANTIZADO.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_MINIMO_GARANTIZADO));

    }

    @Test
    void insertTempAusenciasDateMaxMinGarantizadoIdTareaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempAusenciasDateMaxMinGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_AUSENCIAS_DATE_MAX_MIN_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(ID_TAREA, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

    }

    @Test
    void createTempCalculoConAjusteMaxMinGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createTempCalculoConAjusteMaxMinGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_CALCULO_CON_AJUSTE_MAX_MIN_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void deleteTempCalculoConAjusteMaxMinGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .deleteTempCalculoConAjusteMaxMinGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_CALCULO_CON_AJUSTE_MAX_MIN_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void createIndexTempCalculoConAjusteMaxMinGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createIndexTempCalculoConAjusteMaxMinGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_CALCULO_CON_AJUSTE_MAX_MIN_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void insertTempCalculoConAjusteMaxMinGarantizadoNumArgumentosTareaNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoConAjusteMaxMinGarantizado(null);
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_CALCULO_CON_AJUSTE_MAX_MIN_GARANTIZADO),
                this.paramsCaptor.capture());
        assertEquals(2, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempCalculoConAjusteMaxMinGarantizadoNumArgumentosTareaNotNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempCalculoConAjusteMaxMinGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_CALCULO_CON_AJUSTE_MAX_MIN_GARANTIZADO),
                this.paramsCaptor.capture());
        assertEquals(3, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempCalculoConAjusteMaxMinGarantizadoInactivoTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempCalculoConAjusteMaxMinGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_CALCULO_CON_AJUSTE_MAX_MIN_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
                params.getValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));

    }

    @Test
    void insertTempCalculoConAjusteMaxMinGarantizadoIdTipoPoliticaAjusteTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempCalculoConAjusteMaxMinGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_CALCULO_CON_AJUSTE_MAX_MIN_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE));
        assertEquals(
                Arrays.asList(TipoPoliticaEnum.ANTIGUEDAD.getId(), TipoPoliticaEnum.VACACIONES.getId(),
                        TipoPoliticaEnum.BAJA_IT.getId()),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE));

    }

    @Test
    void insertTempCalculoConAjusteMaxMinGarantizadoIdTareaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempCalculoConAjusteMaxMinGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_CALCULO_CON_AJUSTE_MAX_MIN_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(ID_TAREA, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

    }

    @Test
    void createTempDatosMaxMinGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.createTempDatosMaxMinGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_DATOS_MAX_MIN_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void deleteTempDatosMaxMinGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempDatosMaxMinGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_DATOS_MAX_MIN_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void createIndexTempDatosMaxMinGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createIndexTempDatosMaxMinGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_DATOS_MAX_MIN_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    // Fin tests máximo / mínimo garantizado (común)

    // Inicio tests máximo garantizado

    @Test
    void insertTempDatosMaxGarantizadoNumArgumentosTareaNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempDatosMaxGarantizado(null);
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_DATOS_MAX_GARANTIZADO),
                this.paramsCaptor.capture());
        assertEquals(3, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempDatosMaxGarantizadoNumArgumentosTareaNotNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempDatosMaxGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_DATOS_MAX_GARANTIZADO),
                this.paramsCaptor.capture());
        assertEquals(4, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempDatosMaxGarantizadoInactivoTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempDatosMaxGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_DATOS_MAX_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
                params.getValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));

    }

    @Test
    void insertTempDatosMaxGarantizadoActivoTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempDatosMaxGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_DATOS_MAX_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));

    }

    @Test
    void insertTempDatosMaxGarantizadoIdTipoPoliticaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempDatosMaxGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_DATOS_MAX_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));
        assertEquals(TipoPoliticaEnum.MAXIMO_GARANTIZADO.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));

    }

    @Test
    void insertTempDatosMaxGarantizadoIdTareaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempDatosMaxGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_DATOS_MAX_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(ID_TAREA, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

    }

    // Fin tests máximo garantizado

    // Inicio tests mínimo garantizado

    @Test
    void insertTempDatosMinGarantizadoNumArgumentosTareaNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempDatosMinGarantizado(null);
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_DATOS_MIN_GARANTIZADO),
                this.paramsCaptor.capture());
        assertEquals(3, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempDatosMinGarantizadoNumArgumentosTareaNotNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempDatosMinGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_DATOS_MIN_GARANTIZADO),
                this.paramsCaptor.capture());
        assertEquals(4, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempDatosMinGarantizadoInactivoTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempDatosMinGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_DATOS_MIN_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
                params.getValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));

    }

    @Test
    void insertTempDatosMinGarantizadoActivoTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempDatosMinGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_DATOS_MIN_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));

    }

    @Test
    void insertTempDatosMinGarantizadoIdTipoPoliticaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempDatosMinGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_DATOS_MIN_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));
        assertEquals(TipoPoliticaEnum.MINIMO_GARANTIZADO.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));

    }

    @Test
    void insertTempDatosMinGarantizadoIdTareaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempDatosMinGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_DATOS_MIN_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(ID_TAREA, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

    }

    // Fin tests mínimo garantizado

}
