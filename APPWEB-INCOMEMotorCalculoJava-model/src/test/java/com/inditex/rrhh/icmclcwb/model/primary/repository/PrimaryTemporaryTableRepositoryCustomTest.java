/*
 * Copyright (c) 2021. Inditex
 */
package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author javierev
 */
@RunWith(MockitoJUnitRunner.class)
public class PrimaryTemporaryTableRepositoryCustomTest {

    private final static String ID_TAREA_PARAM = "idTarea";

    private final static String FECHA_INICIO_PERIODO_PARAM = "fechaInicioPeriodo";

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private PrimaryTemporaryTableRepositoryCustomImpl primaryTemporaryTableRepositoryCustom;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

    // baja it

    private final static String SQL_CREATE_TEMP_COMIS_BAJA_IT = "SQL CREATE TEMP COMIS BAJA IT";

    private final static String SQL_INSERT_TEMP_COMIS_BAJA_IT = "SQL INSERT TEMP COMIS BAJA IT";

    private final static String SQL_VALIDATE_TEMP_COMIS_BAJA_IT = "SQL VALDIATE TEMP COMIS BAJA IT";

    private final static String SQL_DELETE_TEMP_COMIS_BAJA_IT = "SQL DELETE TEMP COMIS BAJA IT";

    // carencia

    private final static String SQL_CREATE_TEMP_COMIS_CARENCIA = "SQL CREATE TEMP COMIS CARENCIA";

    private final static String SQL_INSERT_TEMP_COMIS_CARENCIA = "SQL INSERT TEMP COMIS CARENCIA";

    private final static String SQL_VALIDATE_TEMP_COMIS_CARENCIA = "SQL VALDIATE TEMP COMIS CARENCIA";

    private final static String SQL_DELETE_TEMP_COMIS_CARENCIA = "SQL DELETE TEMP COMIS CARENCIA";

    // desplazamientos

    private final static String SQL_CREATE_TEMP_COMIS_DESPLAZAMIENTOS = "SQL CREATE TEMP COMIS DESPLAZAMIENTOS";

    private final static String SQL_INSERT_TEMP_COMIS_DESPLAZAMIENTOS = "SQL INSERT TEMP COMIS DESPLAZAMIENTOS";

    private final static String SQL_VALIDATE_TEMP_COMIS_DESPLAZAMIENTOS = "SQL VALDIATE TEMP COMIS DESPLAZAMIENTOS";

    private final static String SQL_DELETE_TEMP_COMIS_DESPLAZAMIENTOS = "SQL DELETE TEMP COMIS DESPLAZAMIENTOS";

    // historico

    private final static String SQL_CREATE_TEMP_COMIS_HISTORICO = "SQL CREATE TEMP COMIS HISTORICO";

    private final static String SQL_INSERT_TEMP_COMIS_HISTORICO = "SQL INSERT TEMP COMIS HISTORICO";

    private final static String SQL_VALIDATE_TEMP_COMIS_HISTORICO = "SQL VALDIATE TEMP COMIS HISTORICO";

    private final static String SQL_DELETE_TEMP_COMIS_HISTORICO = "SQL DELETE TEMP COMIS HISTORICO";

    // resalta

    private final static String SQL_CREATE_TEMP_COMIS_RESALTA = "SQL CREATE TEMP COMIS RESALTA";

    private final static String SQL_INSERT_TEMP_COMIS_RESALTA = "SQL INSERT TEMP COMIS RESALTA";

    private final static String SQL_VALIDATE_TEMP_COMIS_RESALTA = "SQL VALDIATE TEMP COMIS RESALTA";

    private final static String SQL_DELETE_TEMP_COMIS_RESALTA = "SQL DELETE TEMP COMIS RESALTA";


    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom, "batchSize", 3, true);

        // baja it
        FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
                "sqlCreateTempComisBajaIt", SQL_CREATE_TEMP_COMIS_BAJA_IT, true);
        FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
                "sqlInsertTempComisBajaIt", SQL_INSERT_TEMP_COMIS_BAJA_IT, true);
        FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
                "sqlValidateTempComisBajaIt", SQL_VALIDATE_TEMP_COMIS_BAJA_IT, true);
        FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
                "sqlDeleteTempComisBajaIt", SQL_DELETE_TEMP_COMIS_BAJA_IT, true);

        // carencia
        FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
                "sqlCreateTempComisCarencia", SQL_CREATE_TEMP_COMIS_CARENCIA, true);
        FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
                "sqlInsertTempComisCarencia", SQL_INSERT_TEMP_COMIS_CARENCIA, true);
        FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
                "sqlValidateTempComisCarencia", SQL_VALIDATE_TEMP_COMIS_CARENCIA, true);
        FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
                "sqlDeleteTempComisCarencia", SQL_DELETE_TEMP_COMIS_CARENCIA, true);

        // desplazamientos
        FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
                "sqlCreateTempComisDesplazamiento", SQL_CREATE_TEMP_COMIS_DESPLAZAMIENTOS, true);
        FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
                "sqlInsertTempComisDesplazamiento", SQL_INSERT_TEMP_COMIS_DESPLAZAMIENTOS, true);
        FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
                "sqlValidateTempComisDesplazamiento", SQL_VALIDATE_TEMP_COMIS_DESPLAZAMIENTOS, true);
        FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
                "sqlDeleteTempComisDesplazamiento", SQL_DELETE_TEMP_COMIS_DESPLAZAMIENTOS, true);

        // historico
        FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
                "sqlCreateTempComisHistorico", SQL_CREATE_TEMP_COMIS_HISTORICO, true);
        FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
                "sqlInsertTempComisHistorico", SQL_INSERT_TEMP_COMIS_HISTORICO, true);
        FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
                "sqlValidateTempComisHistorico", SQL_VALIDATE_TEMP_COMIS_HISTORICO, true);
        FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
                "sqlDeleteTempComisHistorico", SQL_DELETE_TEMP_COMIS_HISTORICO, true);

        // historico
        FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
                "sqlCreateTempComisResalta", SQL_CREATE_TEMP_COMIS_RESALTA, true);
        FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
                "sqlInsertTempComisResalta", SQL_INSERT_TEMP_COMIS_RESALTA, true);
        FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
                "sqlValidateTempComisResalta", SQL_VALIDATE_TEMP_COMIS_RESALTA, true);
        FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
                "sqlDeleteTempComisResalta", SQL_DELETE_TEMP_COMIS_RESALTA, true);
    }

    // Inicio tests baja it

    @Test
    public void createTempComisBajaItTest() {
        this.primaryTemporaryTableRepositoryCustom.createTempComisBajaIt();
        verify(this.jdbcTemplate).update(SQL_CREATE_TEMP_COMIS_BAJA_IT);
    }

    @Test
    public void insertTempComisBajaItTest() {

        final List<IdPersonaLocalCondicionesDto> condiciones = new ArrayList<>();
        final IdPersonaLocalCondicionesDto persona = mock(IdPersonaLocalCondicionesDto.class);
        condiciones.add(persona);

        this.primaryTemporaryTableRepositoryCustom.insertTempComisBajaIt(condiciones);
        verify(this.jdbcTemplate).batchUpdate(eq(SQL_INSERT_TEMP_COMIS_BAJA_IT),
                any(BatchPreparedStatementSetter.class));

    }

    @Test
    public void validateTempComisBajaItTest() {

        final TareaDto tarea = mock(TareaDto.class);
        final LocalDate fechaInicio = LocalDate.of(2020, 01, 01);
        final long idTarea = 1234L;
        when(tarea.getFechaInicioPeriodo()).thenReturn(fechaInicio);
        when(tarea.getId()).thenReturn(idTarea);

        this.primaryTemporaryTableRepositoryCustom.validateTempComisBajaIt(tarea);
        verify(this.namedParameterJdbcTemplate).query(eq(SQL_VALIDATE_TEMP_COMIS_BAJA_IT), this.paramsCaptor.capture(),
                any(RowMapper.class));

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertEquals(2, params.getValues().size());
        assertTrue(params.hasValue(ID_TAREA_PARAM));
        assertEquals(idTarea, params.getValue(ID_TAREA_PARAM));
        assertTrue(params.hasValue(FECHA_INICIO_PERIODO_PARAM));
        assertEquals(TimeUtils.toDate(fechaInicio), params.getValue(FECHA_INICIO_PERIODO_PARAM));

    }

    @Test
    public void deleteTempComisBajaItTest() {
        this.primaryTemporaryTableRepositoryCustom.deleteTempComisBajaIt();
        verify(this.jdbcTemplate).update(SQL_DELETE_TEMP_COMIS_BAJA_IT);
    }

    // Fin tests baja it

    // Inicio tests carencias

    @Test
    public void createTempComisCarenciaTest() {
        this.primaryTemporaryTableRepositoryCustom.createTempComisCarencia();
        verify(this.jdbcTemplate).update(SQL_CREATE_TEMP_COMIS_CARENCIA);
    }

    @Test
    public void insertTempComisCarenciaTest() {

        final List<IdPersonaLocalCarenciaDto> condiciones = new ArrayList<>();
        final IdPersonaLocalCarenciaDto persona = mock(IdPersonaLocalCarenciaDto.class);
        condiciones.add(persona);

        this.primaryTemporaryTableRepositoryCustom.insertTempComisCarencia(condiciones);
        verify(this.jdbcTemplate).batchUpdate(eq(SQL_INSERT_TEMP_COMIS_CARENCIA),
                any(BatchPreparedStatementSetter.class));

    }

    @Test
    public void validateTempComisCarenciaTest() {

        final TareaDto tarea = mock(TareaDto.class);
        final LocalDate fechaInicio = LocalDate.of(2020, 01, 01);
        final long idTarea = 1234L;
        when(tarea.getFechaInicioPeriodo()).thenReturn(fechaInicio);
        when(tarea.getId()).thenReturn(idTarea);

        this.primaryTemporaryTableRepositoryCustom.validateTempComisCarencia(tarea);
        verify(this.namedParameterJdbcTemplate).query(eq(SQL_VALIDATE_TEMP_COMIS_CARENCIA), this.paramsCaptor.capture(),
                any(RowMapper.class));

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertEquals(2, params.getValues().size());
        assertTrue(params.hasValue(ID_TAREA_PARAM));
        assertEquals(idTarea, params.getValue(ID_TAREA_PARAM));
        assertTrue(params.hasValue(FECHA_INICIO_PERIODO_PARAM));
        assertEquals(TimeUtils.toDate(fechaInicio), params.getValue(FECHA_INICIO_PERIODO_PARAM));

    }

    @Test
    public void deleteTempComisCarenciaTest() {
        this.primaryTemporaryTableRepositoryCustom.deleteTempComisCarencia();
        verify(this.jdbcTemplate).update(SQL_DELETE_TEMP_COMIS_CARENCIA);
    }

    // Fin tests carencias

    // Inicio tests desplazamientos

    @Test
    public void createTempComisDesplazamientoTest() {
        this.primaryTemporaryTableRepositoryCustom.createTempComisDesplazamiento();
        verify(this.jdbcTemplate).update(SQL_CREATE_TEMP_COMIS_DESPLAZAMIENTOS);
    }

    @Test
    public void insertTempComisDesplazamientoTest() {

        final List<IdPersonaLocalCondicionesDto> condiciones = new ArrayList<>();
        final IdPersonaLocalCondicionesDto persona = mock(IdPersonaLocalCondicionesDto.class);
        condiciones.add(persona);

        this.primaryTemporaryTableRepositoryCustom.insertTempComisDesplazamiento(condiciones);
        verify(this.jdbcTemplate).batchUpdate(eq(SQL_INSERT_TEMP_COMIS_DESPLAZAMIENTOS),
                any(BatchPreparedStatementSetter.class));

    }

    @Test
    public void validateTempComisDesplazamientoTest() {

        final TareaDto tarea = mock(TareaDto.class);
        final LocalDate fechaInicio = LocalDate.of(2020, 01, 01);
        final long idTarea = 1234L;
        when(tarea.getId()).thenReturn(idTarea);

        this.primaryTemporaryTableRepositoryCustom.validateTempComisDesplazamiento(tarea);
        verify(this.namedParameterJdbcTemplate).query(eq(SQL_VALIDATE_TEMP_COMIS_DESPLAZAMIENTOS),
                this.paramsCaptor.capture(),
                any(RowMapper.class));

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertEquals(1, params.getValues().size());
        assertTrue(params.hasValue(ID_TAREA_PARAM));
        assertEquals(idTarea, params.getValue(ID_TAREA_PARAM));

    }

    @Test
    public void deleteTempComisDesplazamientoTest() {
        this.primaryTemporaryTableRepositoryCustom.deleteTempComisDesplazamiento();
        verify(this.jdbcTemplate).update(SQL_DELETE_TEMP_COMIS_DESPLAZAMIENTOS);
    }

    // Fin tests desplazamientos

    // Inicio tests historico

    @Test
    public void createTempComisHistoricoTest() {
        this.primaryTemporaryTableRepositoryCustom.createTempComisHistorico();
        verify(this.jdbcTemplate).update(SQL_CREATE_TEMP_COMIS_HISTORICO);
    }

    @Test
    public void insertTempComisHistoricoTest() {

        final List<IdPersonaLocalCondicionesDto> condiciones = new ArrayList<>();
        final IdPersonaLocalCondicionesDto persona = mock(IdPersonaLocalCondicionesDto.class);
        condiciones.add(persona);

        this.primaryTemporaryTableRepositoryCustom.insertTempComisHistorico(condiciones);
        verify(this.jdbcTemplate).batchUpdate(eq(SQL_INSERT_TEMP_COMIS_HISTORICO),
                any(BatchPreparedStatementSetter.class));

    }

    @Test
    public void validateTempComisHistoricoTest() {

        final TareaDto tarea = mock(TareaDto.class);
        final LocalDate fechaInicio = LocalDate.of(2020, 01, 01);
        final long idTarea = 1234L;
        when(tarea.getFechaInicioPeriodo()).thenReturn(fechaInicio);
        when(tarea.getId()).thenReturn(idTarea);

        this.primaryTemporaryTableRepositoryCustom.validateTempComisHistorico(tarea);
        verify(this.namedParameterJdbcTemplate).query(eq(SQL_VALIDATE_TEMP_COMIS_HISTORICO),
                this.paramsCaptor.capture(),
                any(RowMapper.class));

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertEquals(2, params.getValues().size());
        assertTrue(params.hasValue(ID_TAREA_PARAM));
        assertEquals(idTarea, params.getValue(ID_TAREA_PARAM));
        assertTrue(params.hasValue(FECHA_INICIO_PERIODO_PARAM));
        assertEquals(TimeUtils.toDate(fechaInicio), params.getValue(FECHA_INICIO_PERIODO_PARAM));

    }

    @Test
    public void deleteTempComisHistoricoTest() {
        this.primaryTemporaryTableRepositoryCustom.deleteTempComisHistorico();
        verify(this.jdbcTemplate).update(SQL_DELETE_TEMP_COMIS_HISTORICO);
    }

    // Fin tests historico

    // Inicio tests resalta

    @Test
    public void createTempComisResaltaTest() {
        this.primaryTemporaryTableRepositoryCustom.createTempComisResalta();
        verify(this.jdbcTemplate).update(SQL_CREATE_TEMP_COMIS_RESALTA);
    }

    @Test
    public void insertTempComisResaltaTest() {

        final List<IdPersonaLocalCondicionesDto> condiciones = new ArrayList<>();
        final IdPersonaLocalCondicionesDto persona = mock(IdPersonaLocalCondicionesDto.class);
        condiciones.add(persona);

        this.primaryTemporaryTableRepositoryCustom.insertTempComisResalta(condiciones);
        verify(this.jdbcTemplate).batchUpdate(eq(SQL_INSERT_TEMP_COMIS_RESALTA),
                any(BatchPreparedStatementSetter.class));

    }

    @Test
    public void validateTempComisResaltaTest() {

        final TareaDto tarea = mock(TareaDto.class);
        final LocalDate fechaInicio = LocalDate.of(2020, 01, 01);
        final long idTarea = 1234L;
        when(tarea.getFechaInicioPeriodo()).thenReturn(fechaInicio);
        when(tarea.getId()).thenReturn(idTarea);

        this.primaryTemporaryTableRepositoryCustom.validateTempComisResalta(tarea);
        verify(this.namedParameterJdbcTemplate).query(eq(SQL_VALIDATE_TEMP_COMIS_RESALTA),
                this.paramsCaptor.capture(),
                any(RowMapper.class));

        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        assertEquals(2, params.getValues().size());
        assertTrue(params.hasValue(ID_TAREA_PARAM));
        assertEquals(idTarea, params.getValue(ID_TAREA_PARAM));
        assertTrue(params.hasValue(FECHA_INICIO_PERIODO_PARAM));
        assertEquals(TimeUtils.toDate(fechaInicio), params.getValue(FECHA_INICIO_PERIODO_PARAM));

    }

    @Test
    public void deleteTempComisResaltaTest() {
        this.primaryTemporaryTableRepositoryCustom.deleteTempComisResalta();
        verify(this.jdbcTemplate).update(SQL_DELETE_TEMP_COMIS_RESALTA);
    }

    // Fin tests resalta

}
