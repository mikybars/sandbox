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
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
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

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TAREA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
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

    // comun

    private static final String SQL_CREATE_TEMP_PERSONAS = "SQL CREATE TEMP PERSONAS";

    private static final String SQL_DELETE_TEMP_PERSONAS = "SQL DELETE TEMP PERSONAS";

    private static final String SQL_INSERT_TEMP_PERSONAS = "SQL INSERT TEMP PERSONAS";

    private static final String SQL_INDEX_TEMP_PERSONAS = "SQL INDEX TEMP PERSONAS";

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

    // Máximo garantizado (común)

    private static final String SQL_CREATE_TEMP_AUSENCIAS_DATE_MAXIMO_GARANTIZADO = "SQL CREATE TEMP AUSENCIAS DATE MAXIMO GARANTIZADO";

    private static final String SQL_DELETE_TEMP_AUSENCIAS_DATE_MAXIMO_GARANTIZADO = "SQL DELETE TEMP AUSENCIAS DATE MAXIMO GARANTIZADO";

    private static final String SQL_INSERT_TEMP_AUSENCIAS_DATE_MAXIMO_GARANTIZADO = "SQL INSERT TEMP AUSENCIAS DATE MAXIMO GARANTIZADO";

    private static final String SQL_INDEX_TEMP_AUSENCIAS_DATE_MAXIMO_GARANTIZADO = "SQL INDEX TEMP AUSENCIAS DATE MAXIMO  GARANTIZADO";

    private static final String SQL_CREATE_TEMP_CALCULO_CON_AJUSTE_MAXIMO_GARANTIZADO = "SQL CREATE TEMP CALCULO CON AJUSTE MAXIMO GARANTIZADO";

    private static final String SQL_DELETE_TEMP_CALCULO_CON_AJUSTE_MAXIMO_GARANTIZADO = "SQL DELETE TEMP CALCULO CON AJUSTE MAXIMO GARANTIZADO";

    private static final String SQL_INSERT_TEMP_CALCULO_CON_AJUSTE_MAXIMO_GARANTIZADO = "SQL INSERT TEMP CALCULO CON AJUSTE MAXIMO GARANTIZADO";

    private static final String SQL_INDEX_TEMP_CALCULO_CON_AJUSTE_MAXIMO_GARANTIZADO = "SQL INDEX TEMP CALCULO CON AJUSTE MAXIMO GARANTIZADO";

    private static final String SQL_CREATE_TEMP_DATOS_MAXIMO_GARANTIZADO = "SQL CREATE TEMP DATOS MAXIMO GARANTIZADO";

    private static final String SQL_DELETE_TEMP_DATOS_MAXIMO_GARANTIZADO = "SQL DELETE TEMP DATOS MAXIMO GARANTIZADO";

    private static final String SQL_INDEX_TEMP_DATOS_MAXIMO_GARANTIZADO = "SQL INDEX TEMP DATOS MAXIMO GARANTIZADO";

    private static final String SQL_INSERT_TEMP_DATOS_MAXIMO_GARANTIZADO = "SQL INSERT TEMP DATOS MAXIMO GARANTIZADO";

    // Mínimo garantizado (común)

    private static final String SQL_CREATE_TEMP_AUSENCIAS_DATE_MINIMO_GARANTIZADO = "SQL CREATE TEMP AUSENCIAS DATE MINIMO GARANTIZADO";

    private static final String SQL_DELETE_TEMP_AUSENCIAS_DATE_MINIMO_GARANTIZADO = "SQL DELETE TEMP AUSENCIAS DATE MINIMO GARANTIZADO";

    private static final String SQL_INSERT_TEMP_AUSENCIAS_DATE_MINIMO_GARANTIZADO = "SQL INSERT TEMP AUSENCIAS DATE MINIMO GARANTIZADO";

    private static final String SQL_INDEX_TEMP_AUSENCIAS_DATE_MINIMO_GARANTIZADO = "SQL INDEX TEMP AUSENCIAS DATE MINIMO  GARANTIZADO";

    private static final String SQL_CREATE_TEMP_CALCULO_CON_AJUSTE_MINIMO_GARANTIZADO = "SQL CREATE TEMP CALCULO CON AJUSTE MINIMO GARANTIZADO";

    private static final String SQL_DELETE_TEMP_CALCULO_CON_AJUSTE_MINIMO_GARANTIZADO = "SQL DELETE TEMP CALCULO CON AJUSTE MINIMO GARANTIZADO";

    private static final String SQL_INSERT_TEMP_CALCULO_CON_AJUSTE_MINIMO_GARANTIZADO = "SQL INSERT TEMP CALCULO CON AJUSTE MINIMO GARANTIZADO";

    private static final String SQL_INDEX_TEMP_CALCULO_CON_AJUSTE_MINIMO_GARANTIZADO = "SQL INDEX TEMP CALCULO CON AJUSTE MINIMO GARANTIZADO";

    private static final String SQL_CREATE_TEMP_DATOS_MINIMO_GARANTIZADO = "SQL CREATE TEMP DATOS MINIMO GARANTIZADO";

    private static final String SQL_DELETE_TEMP_DATOS_MINIMO_GARANTIZADO = "SQL DELETE TEMP DATOS MINIMO GARANTIZADO";

    private static final String SQL_INDEX_TEMP_DATOS_MINIMO_GARANTIZADO = "SQL INDEX TEMP DATOS MINIMO GARANTIZADO";

    private static final String SQL_INSERT_TEMP_DATOS_MINIMO_GARANTIZADO = "SQL INSERT TEMP DATOS MINIMO GARANTIZADO";

    // carencia

    private static final String SQL_CREATE_TEMP_FECHAS_CARENCIA = "SQL CREATE TEMP FECHAS CARENCIA";

    private static final String SQL_DELETE_TEMP_FECHAS_CARENCIA = "SQL DELETE TEMP FECHAS CARENCIA";

    private static final String SQL_INSERT_TEMP_FECHAS_CARENCIA = "SQL INSERT TEMP FECHAS CARENCIA";

    private static final String SQL_INDEX_TEMP_FECHAS_CARENCIA = "SQL INDEX TEMP FECHAS CARENCIA";

    private static final String SQL_CREATE_TEMP_FECHAS_ACUMULADAS_CARENCIA = "SQL CREATE TEMP FECHAS ACUMULADAS CARENCIA";

    private static final String SQL_DELETE_TEMP_FECHAS_ACUMULADAS_CARENCIA = "SQL DELETE TEMP FECHAS ACUMULADAS CARENCIA";

    private static final String SQL_INSERT_TEMP_FECHAS_ACUMULADAS_CARENCIA = "SQL INSERT TEMP FECHAS ACUMULADAS CARENCIA";

    private static final String SQL_INDEX_TEMP_FECHAS_ACUMULADAS_CARENCIA = "SQL INDEX TEMP FECHAS ACUMULADAS CARENCIA";

    private static final String SQL_CREATE_TEMP_CALULO_TOTALIZADO_CARENCIA = "SQL CREATE TEMP CALCULO TOTALIZADO CARENCIA";

    private static final String SQL_DELETE_TEMP_CALCULO_TOTALIZADO_CARENCIA = "SQL DELETE TEMP CALCULO TOTALIZADO CARENCIA";

    private static final String SQL_INSERT_TEMP_CALCULO_TOTALIZADO_CARENCIA = "SQL INSERT TEMP CALCULO TOTALIZADO CARENCIA";

    private static final String SQL_INDEX_TEMP_CALCULO_TOTALIZADO_CARENCIA = "SQL INDEX TEMP CALCULO TOTALIZADO CARENCIA";


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
    private ArgumentCaptor<MapSqlParameterSource[]> batchParamsCaptor;

    @InjectMocks
    private PrimaryTemporaryTablePoliticasRepositoryCustomImpl primaryTemporaryTablePoliticasRepositoryCustom;

    @BeforeEach
    public void setup() throws IllegalAccessException {
        when(this.jdbcTemplate.update(any(String.class))).thenReturn(UPDATE_RESULT);
        // comun
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlCreateTempPersonas", SQL_CREATE_TEMP_PERSONAS, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlDeleteTempPersonas", SQL_DELETE_TEMP_PERSONAS, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlInsertTempPersonas", SQL_INSERT_TEMP_PERSONAS, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlIndexTempPersonas", SQL_INDEX_TEMP_PERSONAS, true);
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
        // Máximo garantizado
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlCreateTempAusenciasDateMaximoGarantizado", SQL_CREATE_TEMP_AUSENCIAS_DATE_MAXIMO_GARANTIZADO,
                true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlDeleteTempAusenciasDateMaximoGarantizado", SQL_DELETE_TEMP_AUSENCIAS_DATE_MAXIMO_GARANTIZADO,
                true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlInsertTempAusenciasDateMaximoGarantizado", SQL_INSERT_TEMP_AUSENCIAS_DATE_MAXIMO_GARANTIZADO,
                true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlIndexTempAusenciasDateMinimoGarantizado", SQL_INDEX_TEMP_AUSENCIAS_DATE_MINIMO_GARANTIZADO, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlIndexTempAusenciasDateMaximoGarantizado", SQL_INDEX_TEMP_AUSENCIAS_DATE_MAXIMO_GARANTIZADO, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlCreateTempCalculoConAjusteMaximoGarantizado",
                SQL_CREATE_TEMP_CALCULO_CON_AJUSTE_MAXIMO_GARANTIZADO,
                true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlDeleteTempCalculoConAjusteMaximoGarantizado",
                SQL_DELETE_TEMP_CALCULO_CON_AJUSTE_MAXIMO_GARANTIZADO,
                true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlInsertTempCalculoConAjusteMaximoGarantizado",
                SQL_INSERT_TEMP_CALCULO_CON_AJUSTE_MAXIMO_GARANTIZADO,
                true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlIndexTempCalculoConAjusteMaximoGarantizado", SQL_INDEX_TEMP_CALCULO_CON_AJUSTE_MAXIMO_GARANTIZADO,
                true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlCreateTempDatosMaximoGarantizado", SQL_CREATE_TEMP_DATOS_MAXIMO_GARANTIZADO, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlDeleteTempDatosMaximoGarantizado", SQL_DELETE_TEMP_DATOS_MAXIMO_GARANTIZADO, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlInsertTempDatosMinimoGarantizado", SQL_INSERT_TEMP_DATOS_MINIMO_GARANTIZADO, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlInsertTempDatosMaximoGarantizado", SQL_INSERT_TEMP_DATOS_MAXIMO_GARANTIZADO, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlIndexTempDatosMaximoGarantizado", SQL_INDEX_TEMP_DATOS_MAXIMO_GARANTIZADO, true);
        // Mínimo garantizado
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlCreateTempAusenciasDateMinimoGarantizado", SQL_CREATE_TEMP_AUSENCIAS_DATE_MINIMO_GARANTIZADO,
                true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlDeleteTempAusenciasDateMinimoGarantizado", SQL_DELETE_TEMP_AUSENCIAS_DATE_MINIMO_GARANTIZADO,
                true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlInsertTempAusenciasDateMinimoGarantizado", SQL_INSERT_TEMP_AUSENCIAS_DATE_MINIMO_GARANTIZADO,
                true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlIndexTempAusenciasDateMinimoGarantizado", SQL_INDEX_TEMP_AUSENCIAS_DATE_MINIMO_GARANTIZADO, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlCreateTempCalculoConAjusteMinimoGarantizado",
                SQL_CREATE_TEMP_CALCULO_CON_AJUSTE_MINIMO_GARANTIZADO,
                true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlDeleteTempCalculoConAjusteMinimoGarantizado",
                SQL_DELETE_TEMP_CALCULO_CON_AJUSTE_MINIMO_GARANTIZADO,
                true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlInsertTempCalculoConAjusteMinimoGarantizado",
                SQL_INSERT_TEMP_CALCULO_CON_AJUSTE_MINIMO_GARANTIZADO,
                true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlIndexTempCalculoConAjusteMinimoGarantizado", SQL_INDEX_TEMP_CALCULO_CON_AJUSTE_MINIMO_GARANTIZADO,
                true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlCreateTempDatosMinimoGarantizado", SQL_CREATE_TEMP_DATOS_MINIMO_GARANTIZADO, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlDeleteTempDatosMinimoGarantizado", SQL_DELETE_TEMP_DATOS_MINIMO_GARANTIZADO, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlInsertTempDatosMinimoGarantizado", SQL_INSERT_TEMP_DATOS_MINIMO_GARANTIZADO, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlInsertTempDatosMinimoGarantizado", SQL_INSERT_TEMP_DATOS_MINIMO_GARANTIZADO, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlIndexTempDatosMinimoGarantizado", SQL_INDEX_TEMP_DATOS_MINIMO_GARANTIZADO, true);
        // Carencia
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlCreateTempFechasCarencia", SQL_CREATE_TEMP_FECHAS_CARENCIA, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlDeleteTempFechasCarencia", SQL_DELETE_TEMP_FECHAS_CARENCIA, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlInsertTempFechasCarencia", SQL_INSERT_TEMP_FECHAS_CARENCIA, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlIndexTempFechasCarencia", SQL_INDEX_TEMP_FECHAS_CARENCIA, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlCreateTempFechasAcumuladasCarencia", SQL_CREATE_TEMP_FECHAS_ACUMULADAS_CARENCIA, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlDeleteTempFechasAcumuladasCarencia", SQL_DELETE_TEMP_FECHAS_ACUMULADAS_CARENCIA, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlInsertTempFechasAcumuladasCarencia", SQL_INSERT_TEMP_FECHAS_ACUMULADAS_CARENCIA, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlIndexTempFechasAcumuladasCarencia", SQL_INDEX_TEMP_FECHAS_ACUMULADAS_CARENCIA, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlCreateTempCalculoTotalizadoCarencia", SQL_CREATE_TEMP_CALULO_TOTALIZADO_CARENCIA, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlDeleteTempCalculoTotalizadoCarencia", SQL_DELETE_TEMP_CALCULO_TOTALIZADO_CARENCIA, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlInsertTempCalculoTotalizadoCarencia", SQL_INSERT_TEMP_CALCULO_TOTALIZADO_CARENCIA, true);
        FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
                "sqlIndexTempCalculoTotalizadoCarencia", SQL_INDEX_TEMP_CALCULO_TOTALIZADO_CARENCIA, true);
    }

    private TareaDto createTarea() {
        final TareaDto tarea = new TareaDto();
        tarea.setId(ID_TAREA);
        return tarea;
    }

    // Inicio tests baja it

    @Test
    void createTempPersonasTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.createTempPersonas();
        verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_PERSONAS);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void deleteTempPersonasTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempPersonas();
        verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_PERSONAS);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void createIndexTempPersonasTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createIndexTempPersonas();
        verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_PERSONAS);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void insertTempPersonasTest() {
        final IdPersonaLocalDto persona1 = mock(IdPersonaLocalDto.class);
        when(persona1.getIdPersonaLocal()).thenReturn("AT1001");
        when(persona1.getStdOrHrPeriod()).thenReturn("01");
        final IdPersonaLocalDto persona2 = mock(IdPersonaLocalDto.class);
        when(persona2.getIdPersonaLocal()).thenReturn("AT1002");
        when(persona2.getStdOrHrPeriod()).thenReturn("02");
        final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempPersonas(this.createTarea(), personas,
                TipoPoliticaEnum.MAXIMO_GARANTIZADO);

        verify(this.namedParameterJdbcTemplate).batchUpdate(eq(SQL_INSERT_TEMP_PERSONAS),
                this.batchParamsCaptor.capture());

        // parametros de la consulta: idTarea, cclIdPerson, stdOrHrPeriod, idTipoPolitica
        final MapSqlParameterSource[] values = this.batchParamsCaptor.getValue();
        assertEquals(2, values.length);
        for (int i = 0; i < values.length; i++) {
            final MapSqlParameterSource value = values[i];
            // idTarea
            assertTrue(value.hasValue(SQL_PARAM_ID_TAREA));
            assertEquals(ID_TAREA, value.getValue(SQL_PARAM_ID_TAREA));
            // idTipoPolitica
            assertTrue(value.hasValue(SQL_PARAM_ID_TIPO_POLITICA));
            assertEquals(TipoPoliticaEnum.MAXIMO_GARANTIZADO.getId(), value.getValue(SQL_PARAM_ID_TIPO_POLITICA));
            // cclIdPerson, stdOrHrPeriod - existencia del parámetro
            assertTrue(value.hasValue(SQL_PARAM_CCL_ID_PERSON));
            assertTrue(value.hasValue(SQL_PARAM_STD_OR_HR_PERIOD));
        }

        // cclIdPerson, stdOrHrPeriod - valores del parámetro
        assertEquals(1,
                Arrays.stream(values)
                    .filter(value -> persona1.getIdPersonaLocal().equals(value.getValue(SQL_PARAM_CCL_ID_PERSON))
                            && persona1.getStdOrHrPeriod().equals(value.getValue(SQL_PARAM_STD_OR_HR_PERIOD)))
                    .toArray().length);
        assertEquals(1,
                Arrays.stream(values)
                    .filter(value -> persona2.getIdPersonaLocal().equals(value.getValue(SQL_PARAM_CCL_ID_PERSON))
                            && persona2.getStdOrHrPeriod().equals(value.getValue(SQL_PARAM_STD_OR_HR_PERIOD)))

                    .toArray().length);
    }

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
    void insertTempFechasAntiguedadNumArgumentosTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAntiguedad();
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ANTIGUEDAD),
                this.paramsCaptor.capture());
        assertEquals(4, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempFechasAntiguedadUnidadTiempoAnosTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAntiguedad();
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ANTIGUEDAD),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));
        assertEquals(TipoUnidadTiempoEnum.ANOS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));

    }

    @Test
    void insertTempFechasAntiguedadUnidadTiempoMesesTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAntiguedad();
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ANTIGUEDAD),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));
        assertEquals(TipoUnidadTiempoEnum.MESES.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));

    }

    @Test
    void insertTempFechasAntiguedadUnidadTiempoSemanasTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAntiguedad();
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ANTIGUEDAD),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));
        assertEquals(TipoUnidadTiempoEnum.SEMANAS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));

    }

    @Test
    void insertTempFechasAntiguedadUnidadTiempoDiasTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAntiguedad();
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ANTIGUEDAD),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));
        assertEquals(TipoUnidadTiempoEnum.DIAS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));

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
    void insertTempFechasAcumuladasAntiguedadNumArgumentosTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasAntiguedad();
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD),
                this.paramsCaptor.capture());
        assertEquals(4, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempFechasAcumuladasAntiguedadUnidadTiempoAnosTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasAntiguedad();
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));
        assertEquals(TipoUnidadTiempoEnum.ANOS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));

    }

    @Test
    void insertTempFechasAcumuladasAntiguedadUnidadTiempoMesesTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasAntiguedad();
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));
        assertEquals(TipoUnidadTiempoEnum.MESES.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));

    }

    @Test
    void insertTempFechasAcumuladasAntiguedadUnidadTiempoSemanasTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasAntiguedad();
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));
        assertEquals(TipoUnidadTiempoEnum.SEMANAS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));

    }

    @Test
    void insertTempFechasAcumuladasAntiguedadUnidadTiempoDiasTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasAntiguedad();
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));
        assertEquals(TipoUnidadTiempoEnum.DIAS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));

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

    // Inicio tests máximo garantizado (común)

    @Test
    void createTempAusenciasDateMaximoGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createTempAusenciasDateMaximoGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_AUSENCIAS_DATE_MAXIMO_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void deleteTempAusenciasDateMaximoGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .deleteTempAusenciasDateMaximoGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_AUSENCIAS_DATE_MAXIMO_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void createIndexTempAusenciasDateMaximoGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createIndexTempAusenciasDateMaximoGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_AUSENCIAS_DATE_MAXIMO_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void insertTempAusenciasDateMaximoGarantizadoNumArgumentosTareaNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempAusenciasDateMaximoGarantizado(null);
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_AUSENCIAS_DATE_MAXIMO_GARANTIZADO),
                this.paramsCaptor.capture());
        assertEquals(1, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempAusenciasDateMaximoGarantizadoNumArgumentosTareaNotNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempAusenciasDateMaximoGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_AUSENCIAS_DATE_MAXIMO_GARANTIZADO),
                this.paramsCaptor.capture());
        assertEquals(2, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempAusenciasDateMaximoGarantizadoIdTipoPoliticaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempAusenciasDateMaximoGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_AUSENCIAS_DATE_MAXIMO_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));
        assertEquals(TipoPoliticaEnum.MAXIMO_GARANTIZADO.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));

    }

    @Test
    void insertTempAusenciasDateMaximoGarantizadoIdTareaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempAusenciasDateMaximoGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_AUSENCIAS_DATE_MAXIMO_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(ID_TAREA, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

    }

    @Test
    void createTempCalculoConAjusteMaximoGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createTempCalculoConAjusteMaximoGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_CALCULO_CON_AJUSTE_MAXIMO_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void deleteTempCalculoConAjusteMaximoGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .deleteTempCalculoConAjusteMaximoGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_CALCULO_CON_AJUSTE_MAXIMO_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void createIndexTempCalculoConAjusteMaximoGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createIndexTempCalculoConAjusteMaximoGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_CALCULO_CON_AJUSTE_MAXIMO_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void insertTempCalculoConAjusteMaximoGarantizadoNumArgumentosTareaNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoConAjusteMaximoGarantizado(null);
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_CALCULO_CON_AJUSTE_MAXIMO_GARANTIZADO),
                this.paramsCaptor.capture());
        assertEquals(2, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempCalculoConAjusteMaximoGarantizadoNumArgumentosTareaNotNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempCalculoConAjusteMaximoGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_CALCULO_CON_AJUSTE_MAXIMO_GARANTIZADO),
                this.paramsCaptor.capture());
        assertEquals(3, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempCalculoConAjusteMaximoGarantizadoInactivoTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempCalculoConAjusteMaximoGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_CALCULO_CON_AJUSTE_MAXIMO_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
                params.getValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));

    }

    @Test
    void insertTempCalculoConAjusteMaximoGarantizadoIdTipoPoliticaAjusteTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempCalculoConAjusteMaximoGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_CALCULO_CON_AJUSTE_MAXIMO_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE));
        assertEquals(
                Arrays.asList(TipoPoliticaEnum.ANTIGUEDAD.getId(), TipoPoliticaEnum.VACACIONES.getId(),
                        TipoPoliticaEnum.BAJA_IT.getId()),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE));

    }

    @Test
    void insertTempCalculoConAjusteMaximoGarantizadoIdTareaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempCalculoConAjusteMaximoGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_CALCULO_CON_AJUSTE_MAXIMO_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(ID_TAREA, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

    }

    @Test
    void createTempDatosMaximoGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.createTempDatosMaximoGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_DATOS_MAXIMO_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void deleteTempDatosMaximoGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempDatosMaximoGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_DATOS_MAXIMO_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void createIndexTempDatosMaximoGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createIndexTempDatosMaximoGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_DATOS_MAXIMO_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void insertTempDatosMaximoGarantizadoNumArgumentosTareaNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempDatosMaximoGarantizado(null);
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_DATOS_MAXIMO_GARANTIZADO),
                this.paramsCaptor.capture());
        assertEquals(3, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempDatosMaximoGarantizadoNumArgumentosTareaNotNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempDatosMaximoGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_DATOS_MAXIMO_GARANTIZADO),
                this.paramsCaptor.capture());
        assertEquals(4, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempDatosMaximoGarantizadoInactivoTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempDatosMaximoGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_DATOS_MAXIMO_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
                params.getValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));

    }

    @Test
    void insertTempDatosMaximoGarantizadoActivoTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempDatosMaximoGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_DATOS_MAXIMO_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));

    }

    @Test
    void insertTempDatosMaximoGarantizadoIdTipoPoliticaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempDatosMaximoGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_DATOS_MAXIMO_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));
        assertEquals(TipoPoliticaEnum.MAXIMO_GARANTIZADO.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));

    }

    @Test
    void insertTempDatosMaximoGarantizadoIdTareaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempDatosMaximoGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_DATOS_MAXIMO_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(ID_TAREA, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

    }

    // Fin tests máximo garantizado

    // Inicio tests mínimo garantizado

    @Test
    void createTempAusenciasDateMinimoGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createTempAusenciasDateMinimoGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_AUSENCIAS_DATE_MINIMO_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void deleteTempAusenciasDateMinimoGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .deleteTempAusenciasDateMinimoGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_AUSENCIAS_DATE_MINIMO_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void createIndexTempAusenciasDateMinimoGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createIndexTempAusenciasDateMinimoGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_AUSENCIAS_DATE_MINIMO_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void insertTempAusenciasDateMinimoGarantizadoNumArgumentosTareaNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempAusenciasDateMinimoGarantizado(null);
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_AUSENCIAS_DATE_MINIMO_GARANTIZADO),
                this.paramsCaptor.capture());
        assertEquals(1, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempAusenciasDateMinimoGarantizadoNumArgumentosTareaNotNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempAusenciasDateMinimoGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_AUSENCIAS_DATE_MINIMO_GARANTIZADO),
                this.paramsCaptor.capture());
        assertEquals(2, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempAusenciasDateMinimoGarantizadoIdTipoPoliticaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempAusenciasDateMinimoGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_AUSENCIAS_DATE_MINIMO_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));
        assertEquals(TipoPoliticaEnum.MINIMO_GARANTIZADO.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));

    }

    @Test
    void insertTempAusenciasDateMinimoGarantizadoIdTareaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempAusenciasDateMinimoGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_AUSENCIAS_DATE_MINIMO_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(ID_TAREA, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

    }

    @Test
    void createTempCalculoConAjusteMinimoGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createTempCalculoConAjusteMinimoGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_CALCULO_CON_AJUSTE_MINIMO_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void deleteTempCalculoConAjusteMinimoGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .deleteTempCalculoConAjusteMinimoGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_CALCULO_CON_AJUSTE_MINIMO_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void createIndexTempCalculoConAjusteMinimoGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createIndexTempCalculoConAjusteMinimoGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_CALCULO_CON_AJUSTE_MINIMO_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void insertTempCalculoConAjusteMinimoGarantizadoNumArgumentosTareaNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoConAjusteMinimoGarantizado(null);
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_CALCULO_CON_AJUSTE_MINIMO_GARANTIZADO),
                this.paramsCaptor.capture());
        assertEquals(2, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempCalculoConAjusteMinimoGarantizadoNumArgumentosTareaNotNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempCalculoConAjusteMinimoGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_CALCULO_CON_AJUSTE_MINIMO_GARANTIZADO),
                this.paramsCaptor.capture());
        assertEquals(3, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempCalculoConAjusteMinimoGarantizadoInactivoTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempCalculoConAjusteMinimoGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_CALCULO_CON_AJUSTE_MINIMO_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
                params.getValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));

    }

    @Test
    void insertTempCalculoConAjusteMinimoGarantizadoIdTipoPoliticaAjusteTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempCalculoConAjusteMinimoGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_CALCULO_CON_AJUSTE_MINIMO_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE));
        assertEquals(
                Arrays.asList(TipoPoliticaEnum.ANTIGUEDAD.getId(), TipoPoliticaEnum.VACACIONES.getId(),
                        TipoPoliticaEnum.BAJA_IT.getId()),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE));

    }

    @Test
    void insertTempCalculoConAjusteMinimoGarantizadoIdTareaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempCalculoConAjusteMinimoGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_CALCULO_CON_AJUSTE_MINIMO_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(ID_TAREA, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

    }

    @Test
    void createTempDatosMinimoGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.createTempDatosMinimoGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_DATOS_MINIMO_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void deleteTempDatosMinimoGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempDatosMinimoGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_DATOS_MINIMO_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void createIndexTempDatosMinimoGarantizadoTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createIndexTempDatosMinimoGarantizado();
        verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_DATOS_MINIMO_GARANTIZADO);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void insertTempDatosMinimoGarantizadoNumArgumentosTareaNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempDatosMininimoGarantizado(null);
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_DATOS_MINIMO_GARANTIZADO),
                this.paramsCaptor.capture());
        assertEquals(3, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempDatosMinimoGarantizadoNumArgumentosTareaNotNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempDatosMininimoGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_DATOS_MINIMO_GARANTIZADO),
                this.paramsCaptor.capture());
        assertEquals(4, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempDatosMinimoGarantizadoInactivoTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempDatosMininimoGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_DATOS_MINIMO_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
                params.getValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));

    }

    @Test
    void insertTempDatosMinimoGarantizadoActivoTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempDatosMininimoGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_DATOS_MINIMO_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));

    }

    @Test
    void insertTempDatosMinimoGarantizadoIdTipoPoliticaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempDatosMininimoGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_DATOS_MINIMO_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));
        assertEquals(TipoPoliticaEnum.MINIMO_GARANTIZADO.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));

    }

    @Test
    void insertTempDatosMinimoGarantizadoIdTareaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom
            .insertTempDatosMininimoGarantizado(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(
                eq(SQL_INSERT_TEMP_DATOS_MINIMO_GARANTIZADO),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(ID_TAREA, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

    }

    // Fin tests mínimo garantizado

    // Inicio tests baja it

    @Test
    void createTempFechasCarenciaTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasCarencia();
        verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_FECHAS_CARENCIA);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void deleteTempFechasCarenciaTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasCarencia();
        verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_FECHAS_CARENCIA);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void createIndexTempFechasCarenciaTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createIndexTempFechasCarencia();
        verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_FECHAS_CARENCIA);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void insertTempFechasCarenciaNumArgumentosTareaNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasCarencia(null);
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_CARENCIA),
                this.paramsCaptor.capture());
        assertEquals(5, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempFechasCarenciaNumArgumentosTareaNotNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasCarencia(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_CARENCIA),
                this.paramsCaptor.capture());
        assertEquals(6, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempFechasCarenciaUnidadTiempoAnosTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasCarencia(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_CARENCIA),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));
        assertEquals(TipoUnidadTiempoEnum.ANOS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));

    }

    @Test
    void insertTempFechasCarenciaUnidadTiempoMesesTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasCarencia(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_CARENCIA),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));
        assertEquals(TipoUnidadTiempoEnum.MESES.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));

    }

    @Test
    void insertTempFechasCarenciaUnidadTiempoSemanasTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasCarencia(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_CARENCIA),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));
        assertEquals(TipoUnidadTiempoEnum.SEMANAS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));

    }

    @Test
    void insertTempFechasCarenciaUnidadTiempoDiasTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasCarencia(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_CARENCIA),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));
        assertEquals(TipoUnidadTiempoEnum.DIAS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));

    }

    @Test
    void insertTempFechasCarenciaIdTipoPoliticaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasCarencia(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_CARENCIA),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));
        assertEquals(TipoPoliticaEnum.CARENCIA.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));

    }

    @Test
    void insertTempFechasCarenciaIdTareaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasCarencia(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_CARENCIA),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(ID_TAREA, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

    }

    @Test
    void createTempFechasAcumuladasCarenciaTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAcumuladasCarencia();
        verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_FECHAS_ACUMULADAS_CARENCIA);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void deleteTempFechasAcumuladasCarenciaTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAcumuladasCarencia();
        verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_FECHAS_ACUMULADAS_CARENCIA);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void createIndexTempFechasAcumuladasCarenciaTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createIndexTempFechasAcumuladasCarencia();
        verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_FECHAS_ACUMULADAS_CARENCIA);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void insertTempFechasAcumuladasCarenciaNumArgumentosTareaNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasCarencia(null);
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_CARENCIA),
                this.paramsCaptor.capture());
        assertEquals(5, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempFechasAcumuladasCarenciaNumArgumentosTareaNotNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasCarencia(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_CARENCIA),
                this.paramsCaptor.capture());
        assertEquals(6, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempFechasAcumuladasCarenciaUnidadTiempoAnosTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasCarencia(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_CARENCIA),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));
        assertEquals(TipoUnidadTiempoEnum.ANOS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));

    }

    @Test
    void insertTempFechasAcumuladasCarenciaUnidadTiempoMesesTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasCarencia(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_CARENCIA),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));
        assertEquals(TipoUnidadTiempoEnum.MESES.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));

    }

    @Test
    void insertTempFechasAcumuladasCarenciaUnidadTiempoSemanasTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasCarencia(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_CARENCIA),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));
        assertEquals(TipoUnidadTiempoEnum.SEMANAS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));

    }

    @Test
    void insertTempFechasAcumuladasCarenciaUnidadTiempoDiasTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasCarencia(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_CARENCIA),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));
        assertEquals(TipoUnidadTiempoEnum.DIAS.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));

    }

    @Test
    void insertTempFechasAcumuladasCarenciaIdTipoPoliticaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasCarencia(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_CARENCIA),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));
        assertEquals(TipoPoliticaEnum.CARENCIA.getId(),
                params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));

    }

    @Test
    void insertTempFechasAcumuladasCarenciaIdTareaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasCarencia(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_CARENCIA),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(ID_TAREA, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

    }

    @Test
    void createTempCalculoTotalizadoCarenciaTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.createTempCalculoTotalizadoCarencia();
        verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_CALULO_TOTALIZADO_CARENCIA);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void deleteTempCalculoTotalizadoCarenciaTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempCalculoTotalizadoCarencia();
        verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_CALCULO_TOTALIZADO_CARENCIA);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void createIndexTempCalculoTotalizadoCarenciaTest() {
        final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
            .createIndexTempCalculoTotalizadoCarencia();
        verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_CALCULO_TOTALIZADO_CARENCIA);
        assertEquals(UPDATE_RESULT, result);
    }

    @Test
    void insertTempCalculoTotalizadoCarenciaNumArgumentosTareaNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoTotalizadoCarencia(null);
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_CALCULO_TOTALIZADO_CARENCIA),
                this.paramsCaptor.capture());
        assertEquals(1, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempCalculoTotalizadoCarenciaNumArgumentosTareaNotNullTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoTotalizadoCarencia(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_CALCULO_TOTALIZADO_CARENCIA),
                this.paramsCaptor.capture());
        assertEquals(2, this.paramsCaptor.getValue().getValues().size());
    }

    @Test
    void insertTempCalculoTotalizadoCarenciaIdTareaTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoTotalizadoCarencia(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_CALCULO_TOTALIZADO_CARENCIA),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(ID_TAREA, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

    }

    @Test
    void insertTempCalculoTotalizadoCarenciaInactivoTest() {
        this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoTotalizadoCarencia(this.createTarea());
        verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_CALCULO_TOTALIZADO_CARENCIA),
                this.paramsCaptor.capture());

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
                params.getValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));

    }

    // Fin tests carencia

}
