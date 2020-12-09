/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionValidacionDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPrevalidacionValidacion;
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

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_FECHA_HORA_ACTUALIZACION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_VALIDACION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TAREA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TAREA_PREVALIDACION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_VALIDACION;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TareaPrevalidacionValidacionRepositoryCustomImplTest {

    private final static String SQL_SAVE = "SAVE";

    private final static String SQL_UPDATE = "UPDATE";

    private final static String SQL_FIND_BY_ID_TAREA_AND_ID_TAREA_PREVALIDACION_AND_TIPO_VALIDACION = "FIND";


    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Captor
    ArgumentCaptor<String> sqlCaptor;

    @Captor
    ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

    @InjectMocks
    private TareaPrevalidacionValidacionRepositoryCustomImpl tareaPrevalidacionValidacionRepositoryCustomImpl;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(this.tareaPrevalidacionValidacionRepositoryCustomImpl, "sqlSave", SQL_SAVE, true);
        FieldUtils.writeField(this.tareaPrevalidacionValidacionRepositoryCustomImpl, "sqlUpdate",
                SQL_UPDATE,
                true);
        FieldUtils.writeField(this.tareaPrevalidacionValidacionRepositoryCustomImpl,
                "sqlFindByIdTareaAndIdTareaPrevalidacionAndTipoValidacion",
                SQL_FIND_BY_ID_TAREA_AND_ID_TAREA_PREVALIDACION_AND_TIPO_VALIDACION,
                true);
        FieldUtils.writeField(this.tareaPrevalidacionValidacionRepositoryCustomImpl, "batchSize", 100, true);
    }

    @Test
    public void saveTest() {
        final List<TareaPrevalidacionValidacion> items = Arrays
            .asList(mock(TareaPrevalidacionValidacion.class));
        this.tareaPrevalidacionValidacionRepositoryCustomImpl.save(items);
        verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(), any(SqlParameterSource[].class));
        assertEquals(SQL_SAVE, this.sqlCaptor.getValue());
    }

    @Test
    public void updateTest() {

        final TareaDto tarea = mock(TareaDto.class);

        when(tarea.getId()).thenReturn(199L);

        this.tareaPrevalidacionValidacionRepositoryCustomImpl.update(1, 1,
                1, tarea.getId());
        verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
        assertEquals(SQL_UPDATE, this.sqlCaptor.getValue());
        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        // Parámetros de la consulta: idTarea, activo, minutos
        assertEquals(5, params.getValues().size());
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // idEstadoValidacion
        assertTrue(params.hasValue(SQL_PARAM_ID_ESTADO_VALIDACION));
        assertEquals(1, params.getValue(SQL_PARAM_ID_ESTADO_VALIDACION));
        // idTareaPrevalidacion
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA_PREVALIDACION));
        assertEquals(1, params.getValue(SQL_PARAM_ID_TAREA_PREVALIDACION));
        // idTipoValidacion
        assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_VALIDACION));
        assertEquals(1, params.getValue(SQL_PARAM_ID_TIPO_VALIDACION));
        // fechaHoraActualizacion
        assertTrue(params.hasValue(SQL_PARAM_FECHA_HORA_ACTUALIZACION));

    }

    @Test
    public void findByIdTareaAndIdTareaPrevalidacionAndTipoValidacionTest() {

        final TareaPrevalidacionValidacionDto tareaPrevalidacion = new TareaPrevalidacionValidacionDto();
        when(this.namedParameterJdbcTemplate.queryForObject(any(String.class), any(MapSqlParameterSource.class),
                ArgumentMatchers.<RowMapper<TareaPrevalidacionValidacionDto>>any())).thenReturn(tareaPrevalidacion);
        final TareaPrevalidacionValidacionDto result = this.tareaPrevalidacionValidacionRepositoryCustomImpl
            .findByIdTareaAndIdTareaPrevalidacionAndTipoValidacion(1L, 1, 1);
        verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(this.sqlCaptor.capture(),
                this.paramsCaptor.capture(),
                ArgumentMatchers.<RowMapper<TareaPrevalidacionValidacionDto>>any());

        assertEquals(tareaPrevalidacion, result);
        assertEquals(SQL_FIND_BY_ID_TAREA_AND_ID_TAREA_PREVALIDACION_AND_TIPO_VALIDACION, this.sqlCaptor.getValue());
        final MapSqlParameterSource params = this.paramsCaptor.getValue();

        // Parámetros de la consulta: idEstado
        assertEquals(3, params.getValues().size());
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(1L, params.getValue(SQL_PARAM_ID_TAREA));
        // idTareaPrevalidacion
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA_PREVALIDACION));
        assertEquals(1, params.getValue(SQL_PARAM_ID_TAREA_PREVALIDACION));
        // idTipoValidacion
        assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_VALIDACION));
        assertEquals(1, params.getValue(SQL_PARAM_ID_TIPO_VALIDACION));
    }

}
