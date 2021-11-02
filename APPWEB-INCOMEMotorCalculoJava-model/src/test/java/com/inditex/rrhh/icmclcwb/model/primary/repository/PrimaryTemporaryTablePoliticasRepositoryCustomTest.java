/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.ArrayList;
import java.util.Collections;

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

    // Fin tests baja it

}
