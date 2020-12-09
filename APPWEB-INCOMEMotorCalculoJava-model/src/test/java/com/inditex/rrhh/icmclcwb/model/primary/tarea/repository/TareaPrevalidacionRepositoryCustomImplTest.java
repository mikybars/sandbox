/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.inditex.rrhh.icmclcwb.api.app.dto.AccionValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoValidacionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPrevalidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPrevalidacion;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ACTIVO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_ESTADO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TAREA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TAREA_PREVALIDACION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TareaPrevalidacionRepositoryCustomImplTest {

    private final static String SQL_SAVE = "SAVE";

    private final static String SQL_UPDATE_FECHA = "UPDATE FECHA";

    private final static String SQL_UPDATE_ESTADO = "UPDATE ESTADO";

    private final static String SQL_FIND_ACCION_VALIDACION = "FIND";

    private final static String SQL_FIND_BY_TAREA_ULTIMO_INTENTO = "FIND BY TAREA ULTIMO INTENTO";

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Captor
    ArgumentCaptor<String> sqlCaptor;

    @Captor
    ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

    @InjectMocks
    private TareaPrevalidacionRepositoryCustomImpl tareaPrevalidacionRepositoryCustomImpl;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(this.tareaPrevalidacionRepositoryCustomImpl, "sqlSave", SQL_SAVE, true);
        FieldUtils.writeField(this.tareaPrevalidacionRepositoryCustomImpl, "sqlUpdateFecha",
                SQL_UPDATE_FECHA,
                true);
        FieldUtils.writeField(this.tareaPrevalidacionRepositoryCustomImpl, "sqlUpdateEstado",
                SQL_UPDATE_ESTADO,
                true);
        FieldUtils.writeField(this.tareaPrevalidacionRepositoryCustomImpl,
                "sqlFindAccionValidacion",
                SQL_FIND_ACCION_VALIDACION,
                true);
        FieldUtils.writeField(this.tareaPrevalidacionRepositoryCustomImpl,
                "sqlFindByTareaUltimoIntento",
                SQL_FIND_BY_TAREA_ULTIMO_INTENTO,
                true);
        FieldUtils.writeField(this.tareaPrevalidacionRepositoryCustomImpl, "batchSize", 100, true);
    }

    @Test
    public void saveTest() {
        final List<TareaPrevalidacion> items = Arrays
            .asList(mock(TareaPrevalidacion.class));
        this.tareaPrevalidacionRepositoryCustomImpl.save(items);
        verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(), any(SqlParameterSource[].class));
        assertEquals(SQL_SAVE, this.sqlCaptor.getValue());
    }

    @Test
    public void updateFechaTest() {
        final TareaPrevalidacionDto tareaPrevalidacion = mock(TareaPrevalidacionDto.class);
        when(tareaPrevalidacion.getIdTarea()).thenReturn(1L);

        this.tareaPrevalidacionRepositoryCustomImpl.updateFechaFin(tareaPrevalidacion);
        verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
        assertEquals(SQL_UPDATE_FECHA, this.sqlCaptor.getValue());
        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        // Parámetros de la consulta: idTarea, idTareaPrevalidacion, fecha
        assertEquals(3, params.getValues().size());
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tareaPrevalidacion.getIdTarea(), params.getValue(SQL_PARAM_ID_TAREA));
        // idTareaPrevalidacion
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA_PREVALIDACION));
        assertEquals(0, params.getValue(SQL_PARAM_ID_TAREA_PREVALIDACION));
        // nueva fecha
        assertTrue(params.hasValue(SQL_PARAM_NUEVA_FECHA));
    }

    @Test
    public void updateEstadoTest() {
        final TareaPrevalidacionDto tareaPrevalidacion = mock(TareaPrevalidacionDto.class);
        final EstadoTareaPrevalidacionDto estadoTareaPrevalidacionDto = mock(EstadoTareaPrevalidacionDto.class);
        when(tareaPrevalidacion.getIdTarea()).thenReturn(1L);
        when(estadoTareaPrevalidacionDto.getId()).thenReturn(1);

        this.tareaPrevalidacionRepositoryCustomImpl.updateEstado(tareaPrevalidacion, estadoTareaPrevalidacionDto);
        verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
        assertEquals(SQL_UPDATE_ESTADO, this.sqlCaptor.getValue());
        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        // Parámetros de la consulta: idTarea, idTareaPrevalidacion, fecha
        assertEquals(3, params.getValues().size());
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tareaPrevalidacion.getIdTarea(), params.getValue(SQL_PARAM_ID_TAREA));
        // idTareaPrevalidacion
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA_PREVALIDACION));
        assertEquals(0, params.getValue(SQL_PARAM_ID_TAREA_PREVALIDACION));
        // nueva id estado
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_ESTADO));
        assertEquals(1, params.getValue(SQL_PARAM_NUEVO_ID_ESTADO));
    }

    @Test
    public void findAccionValidacionTest() {
        final List<AccionValidacionDto> accionValidacion = new ArrayList<>();
        accionValidacion.add(new AccionValidacionDto());
        when(this.namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
                ArgumentMatchers.<RowMapper<AccionValidacionDto>>any())).thenReturn(accionValidacion);
        final AccionValidacionDto result = this.tareaPrevalidacionRepositoryCustomImpl
            .findAccionValidacion(1L, 1);
        verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(),
                this.paramsCaptor.capture(),
                ArgumentMatchers.<RowMapper<List<AccionValidacionDto>>>any());

        assertEquals(accionValidacion.get(0), result);
        assertEquals(SQL_FIND_ACCION_VALIDACION, this.sqlCaptor.getValue());
        final MapSqlParameterSource params = this.paramsCaptor.getValue();

        // Parámetros de la consulta: idTarea, idTareaPrevalidacion, activo, estado
        assertEquals(4, params.getValues().size());
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(1L, params.getValue(SQL_PARAM_ID_TAREA));
        // idTareaPrevalidacion
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA_PREVALIDACION));
        assertEquals(1, params.getValue(SQL_PARAM_ID_TAREA_PREVALIDACION));
        // activo
        assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
        assertEquals(Boolean.TRUE, params.getValue(SQL_PARAM_ACTIVO));
        // estado
        assertTrue(params.hasValue(SQL_PARAM_ID_ESTADO));
        assertEquals(EstadoValidacionEnum.OK.getId(), params.getValue(SQL_PARAM_ID_ESTADO));
    }

    @Test
    public void findMaxReintentoTest() {
        final TareaPrevalidacionDto tareaPrevalidacion = new TareaPrevalidacionDto();
        when(this.namedParameterJdbcTemplate.queryForObject(any(String.class), any(MapSqlParameterSource.class),
                ArgumentMatchers.<RowMapper<TareaPrevalidacionDto>>any())).thenReturn(tareaPrevalidacion);
        final TareaPrevalidacionDto result = this.tareaPrevalidacionRepositoryCustomImpl
            .findMaxReintento(1L);
        verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(this.sqlCaptor.capture(),
                this.paramsCaptor.capture(),
                ArgumentMatchers.<RowMapper<TareaPrevalidacionDto>>any());

        assertEquals(tareaPrevalidacion, result);
        assertEquals(SQL_FIND_BY_TAREA_ULTIMO_INTENTO, this.sqlCaptor.getValue());
        final MapSqlParameterSource params = this.paramsCaptor.getValue();

        // Parámetros de la consulta: idTarea, idTareaPrevalidacion, activo, estado
        assertEquals(1, params.getValues().size());
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(1L, params.getValue(SQL_PARAM_ID_TAREA));

    }

}
