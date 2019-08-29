package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPersonaDto;
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

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.*;

@RunWith(MockitoJUnitRunner.class)
public class TareaCalculoPersonaRepositoryCustomImplTest {

    private final static String SQL_FIND_BY_ALGORITMO = "FIND BY ALGORITMO TEST";
    private final static String SQL_UPDATE_WITH_ESTADO_AND_ID_PERSONA = "UPDATE WITH ESTADO AND ID PERSONA TEST";
    private final static String SQL_UPDATE_WITH_ESTADO = "UPDATE WITH ESTADO TEST";
    private final static String SQL_MERGE_BY_AMBITO = "MERGE BY AMBITO TEST";
    private final static String SQL_MERGE_BY_AMBITO_LOCALIZACION = "MERGE BY AMBITO LOCALIZACION TEST";
    private final static String SQL_MERGE_BY_AMBITO_PERSONA = "MERGE BY AMGITO PERSONA TEST";


    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @InjectMocks
    private TareaCalculoPersonaRepositoryCustomImpl tareaCalculoPersonaRepositoryCustom;

    @Captor
    private ArgumentCaptor<String> sql;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> params;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaCalculoPersonaRepositoryCustom, "sqlMergePersonaCalculoByAmbito", SQL_MERGE_BY_AMBITO, true);
        FieldUtils.writeField(tareaCalculoPersonaRepositoryCustom, "sqlMergePersonaCalculoByAmbitoLocalizacion", SQL_MERGE_BY_AMBITO_LOCALIZACION, true);
        FieldUtils.writeField(tareaCalculoPersonaRepositoryCustom, "sqlMergePersonaCalculoByAmbitoPersona", SQL_MERGE_BY_AMBITO_PERSONA, true);
        FieldUtils.writeField(tareaCalculoPersonaRepositoryCustom, "sqlUpdateWithEstado", SQL_UPDATE_WITH_ESTADO_AND_ID_PERSONA, true);
        FieldUtils.writeField(tareaCalculoPersonaRepositoryCustom, "sqlFindByAlgoritmo", SQL_FIND_BY_ALGORITMO, true);
        FieldUtils.writeField(tareaCalculoPersonaRepositoryCustom, "sqlUpdateEstadoActualWithEstadoNuevo", SQL_UPDATE_WITH_ESTADO, true);
    }

    @Test
    public void findByAlgoritmoTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(12L);
        AlgoritmoDto algoritmo = mock(AlgoritmoDto.class);
        when(algoritmo.getId()).thenReturn(90);

        tareaCalculoPersonaRepositoryCustom.findByAlgoritmo(tarea, algoritmo);
        verify(namedParameterJdbcTemplate, times(1)).query(sql.capture(), params.capture(), any(RowMapper.class));
        assertEquals(SQL_FIND_BY_ALGORITMO, sql.getValue());
        // parametros de la consulta SQL: idAlgoritmo, idTarea
        assertEquals(2, params.getValue().getValues().size());
        // idAlgoritmo
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_ALGORITMO));
        assertEquals(algoritmo.getId(), params.getValue().getValue(SQL_PARAM_ID_ALGORITMO));
        // idTarea
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue().getValue(SQL_PARAM_ID_TAREA));
    }

    @Test
    public void updateWithEstadoAndIdPersonaTest() {

        RunTareaDto runTarea = mock(RunTareaDto.class);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(123L);
        when(runTarea.getTarea()).thenReturn(tarea);
        List<String> idPerson = Arrays.asList("SK22321","AT2733","CZ92090");
        EstadoTareaPersonaDto estado = mock(EstadoTareaPersonaDto.class);
        when(estado.getId()).thenReturn(1);

        tareaCalculoPersonaRepositoryCustom.updateWithEstadoAndidPersona(idPerson, runTarea, estado);
        verify(namedParameterJdbcTemplate, times(1)).update(sql.capture(), params.capture());
        assertEquals(SQL_UPDATE_WITH_ESTADO_AND_ID_PERSONA, sql.getValue());
        // parametros de la consulta: idEstado, cclIdPerson, idTarea
        assertEquals(3, params.getValue().getValues().size());
        // idEstado
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_ESTADO));
        assertEquals(estado.getId(), params.getValue().getValue(SQL_PARAM_ID_ESTADO));
        // cclIdPerson
        assertTrue(params.getValue().hasValue(SQL_PARAM_CCL_ID_PERSON));
        assertEquals(idPerson, params.getValue().getValue(SQL_PARAM_CCL_ID_PERSON));
        // idTarea
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue().getValue(SQL_PARAM_ID_TAREA));
    }

    @Test
    public void updateWithEstadoTest() {

        RunTareaDto runTarea = mock(RunTareaDto.class);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(123L);
        when(runTarea.getTarea()).thenReturn(tarea);
        EstadoTareaPersonaDto estadoActual = mock(EstadoTareaPersonaDto.class);
        when(estadoActual.getId()).thenReturn(1);
        EstadoTareaPersonaDto estadoNuevo = mock(EstadoTareaPersonaDto.class);
        when(estadoNuevo.getId()).thenReturn(2);

        tareaCalculoPersonaRepositoryCustom.updateWithEstado(runTarea, estadoActual, estadoNuevo);
        verify(namedParameterJdbcTemplate, times(1)).update(sql.capture(), params.capture());
        assertEquals(SQL_UPDATE_WITH_ESTADO, sql.getValue());
        // parametros de la consulta: idEstadoNuevo, idTarea, idEstadoActual
        assertEquals(3, params.getValue().getValues().size());
        // idEstadoNuevo
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_ESTADO_NUEVO));
        assertEquals(estadoNuevo.getId(), params.getValue().getValue(SQL_PARAM_ID_ESTADO_NUEVO));
        // idTarea
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue().getValue(SQL_PARAM_ID_TAREA));
        // idEstadoActual
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_ESTADO_ACTUAL));
        assertEquals(estadoActual.getId(), params.getValue().getValue(SQL_PARAM_ID_ESTADO_ACTUAL));
    }

    @Test
    public void mergePersonaCalculoByAmbitoTest() {

        RunTareaDto runTarea = mock(RunTareaDto.class);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(123L);
        when(runTarea.getTarea()).thenReturn(tarea);

        tareaCalculoPersonaRepositoryCustom.mergePersonaCalculoByAmbito(runTarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sql.capture(), params.capture());
        assertEquals(SQL_MERGE_BY_AMBITO, sql.getValue());
        // parametros de la consulta: idEstadoTareaPersona, idTarea
        assertEquals(2, params.getValue().getValues().size());
        // idEstadoTareaPersona
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_ESTADO_TAREA_PERSONA));
        assertEquals(EstadoTareaCalculoPersonaEnum.PENDIENTE.getId(), params.getValue().getValue(SQL_PARAM_ID_ESTADO_TAREA_PERSONA));
        // idTarea
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue().getValue(SQL_PARAM_ID_TAREA));
    }

    @Test
    public void mergePersonaCalculoByAmbitoLocalizacionTest() {

        RunTareaDto runTarea = mock(RunTareaDto.class);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(123L);
        when(runTarea.getTarea()).thenReturn(tarea);

        tareaCalculoPersonaRepositoryCustom.mergePersonaCalculoByAmbitoLocalizacion(runTarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sql.capture(), params.capture());
        assertEquals(SQL_MERGE_BY_AMBITO_LOCALIZACION, sql.getValue());
        // parametros de la consulta: idEstadoTareaPersona, idTarea
        assertEquals(2, params.getValue().getValues().size());
        // idEstadoTareaPersona
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_ESTADO_TAREA_PERSONA));
        assertEquals(EstadoTareaCalculoPersonaEnum.PENDIENTE.getId(), params.getValue().getValue(SQL_PARAM_ID_ESTADO_TAREA_PERSONA));
        // idTarea
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue().getValue(SQL_PARAM_ID_TAREA));

    }

    @Test
    public void mergePersonaCalculoByAmbitoPersonaTest() {

        RunTareaDto runTarea = mock(RunTareaDto.class);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(123L);
        when(runTarea.getTarea()).thenReturn(tarea);

        tareaCalculoPersonaRepositoryCustom.mergePersonaCalculoByAmbitoPersona(runTarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sql.capture(), params.capture());
        assertEquals(SQL_MERGE_BY_AMBITO_PERSONA, sql.getValue());
        // parametros de la consulta: idEstadoTareaPersona, idTarea
        assertEquals(2, params.getValue().getValues().size());
        // idEstadoTareaPersona
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_ESTADO_TAREA_PERSONA));
        assertEquals(EstadoTareaCalculoPersonaEnum.PENDIENTE.getId(), params.getValue().getValue(SQL_PARAM_ID_ESTADO_TAREA_PERSONA));
        // idTarea
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue().getValue(SQL_PARAM_ID_TAREA));

    }
}
