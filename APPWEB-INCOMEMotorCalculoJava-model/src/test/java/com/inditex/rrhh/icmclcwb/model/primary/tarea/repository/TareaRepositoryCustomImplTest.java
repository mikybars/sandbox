package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TareaRepositoryCustomImplTest {

    private final static String SQL_UPDATE_FECHA_FIN = "SQL UPDATE FECHA FIN";

    private final static String SQL_UPDATE_FECHA_INICIO_AND_ESTADO = "SQL UPDATE FECHA INICIO AND ESTADO";

    private final static String SQL_UPDATE_ESTADO = "SQL UPDATE ESTADO";

    private final static String SQL_UPDATE_ESTADO_FINAL = "SQL UPDATE ESTADO FINAL";

    private final static String SQL_FIND_LIMPIEZA = "SQL FIND LIMPIEZA";

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @InjectMocks
    private TareaRepositoryCustomImpl tareaRepositoryCustom;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaRepositoryCustom,
                "sqlUpdateFechaFin", SQL_UPDATE_FECHA_FIN, true);
        FieldUtils.writeField(tareaRepositoryCustom,
                "sqlUpdateFechaInicioAndEstado", SQL_UPDATE_FECHA_INICIO_AND_ESTADO, true);
        FieldUtils.writeField(tareaRepositoryCustom,
                "sqlUpdateEstado", SQL_UPDATE_ESTADO, true);
        FieldUtils.writeField(tareaRepositoryCustom,
                "sqlUpdateEstadoFinal", SQL_UPDATE_ESTADO_FINAL, true);
        FieldUtils.writeField(tareaRepositoryCustom,
                "sqlFindLimpieza", SQL_FIND_LIMPIEZA, true);
    }

    @Test
    public void updateFechaFinTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(9090L);
        tareaRepositoryCustom.updateFechaFin(tarea);

        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_UPDATE_FECHA_FIN, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();
        // Parámetros de la consulta: nuevaFecha, idTarea
        assertEquals(2, params.getValues().size());
        // nuevaFecha
        assertTrue(params.hasValue("nuevaFecha"));
        // idTarea
        assertTrue(params.hasValue("idTarea"));
        assertEquals(tarea.getId(), params.getValue("idTarea"));

    }

    @Test
    public void updateFechaInicioAndEstadoTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(9090L);
        EstadoTareaDto estado = mock(EstadoTareaDto.class);
        when(estado.getId()).thenReturn(909);
        tareaRepositoryCustom.updateFechaInicioAndEstado(tarea, estado);

        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_UPDATE_FECHA_INICIO_AND_ESTADO, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();
        // Parámetros de la consulta: nuevaFecha, nuevoIdEstado, idTarea
        assertEquals(3, params.getValues().size());
        // nuevaFecha
        assertTrue(params.hasValue("nuevaFecha"));
        // nuevoIdEstado
        assertTrue(params.hasValue("nuevoIdEstado"));
        assertEquals(estado.getId(), params.getValue("nuevoIdEstado"));
        // idTarea
        assertTrue(params.hasValue("idTarea"));
        assertEquals(tarea.getId(), params.getValue("idTarea"));

    }

    @Test
    public void updateEstadoTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(9090L);
        EstadoTareaDto estado = mock(EstadoTareaDto.class);
        when(estado.getId()).thenReturn(909);
        tareaRepositoryCustom.updateEstado(tarea, estado);

        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_UPDATE_ESTADO, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();
        // Parámetros de la consulta: nuevoIdEstado, idTarea
        assertEquals(2, params.getValues().size());
        // nuevoIdEstado
        assertTrue(params.hasValue("nuevoIdEstado"));
        assertEquals(estado.getId(), params.getValue("nuevoIdEstado"));
        // idTarea
        assertTrue(params.hasValue("idTarea"));
        assertEquals(tarea.getId(), params.getValue("idTarea"));

    }

    @Test
    public void updateEstadoFinalTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(9090L);
        tareaRepositoryCustom.updateEstadoFinal(tarea);

        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_UPDATE_ESTADO_FINAL, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();
        // Parámetros de la consulta: idEstado, idTarea, idEstadoSinErrores, idEstadoConErrores
        assertEquals(4, params.getValues().size());
        // idEstado
        assertTrue(params.hasValue("idEstado"));
        assertEquals(EstadoTareaEnum.EN_CURSO.getId(), params.getValue("idEstado"));
        // idTarea
        assertTrue(params.hasValue("idTarea"));
        assertEquals(tarea.getId(), params.getValue("idTarea"));
        // idEstadoSinErrores
        assertTrue(params.hasValue("idEstadoSinErrores"));
        assertEquals(EstadoTareaEnum.FINALIZADO_SIN_ERRORES.getId(), params.getValue("idEstadoSinErrores"));
        // idEstadoConErrores
        assertTrue(params.hasValue("idEstadoConErrores"));
        assertEquals(EstadoTareaEnum.FINALIZADO_CON_ERRORES.getId(), params.getValue("idEstadoConErrores"));

    }

    @Test
    public void findLimpiezaTest() {

        List<IdTareaDto> idTareas = Arrays.asList(new IdTareaDto(22L), new IdTareaDto(789L), new IdTareaDto(377L));
        when(namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
                any(RowMapper.class))).thenReturn(idTareas);
        List<IdTareaDto> result = tareaRepositoryCustom.findLimpieza();
        verify(namedParameterJdbcTemplate, times(1)).query(sqlCaptor.capture(), paramsCaptor.capture(),
                any(RowMapper.class));

        assertEquals(idTareas, result);
        assertEquals(SQL_FIND_LIMPIEZA, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();

        // Parámetros de la consulta: idEstado
        assertEquals(1, params.getValues().size());
        assertTrue(params.hasValue("idEstado"));
        assertEquals(
                Arrays.asList(EstadoTareaEnum.PENDIENTE.getId(), EstadoTareaEnum.EN_CURSO.getId()),
                params.getValue("idEstado"));
    }

}
