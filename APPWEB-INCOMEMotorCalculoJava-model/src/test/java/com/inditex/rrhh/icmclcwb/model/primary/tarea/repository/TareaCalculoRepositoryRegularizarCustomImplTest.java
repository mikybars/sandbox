package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

@RunWith(MockitoJUnitRunner.class)
public class TareaCalculoRepositoryRegularizarCustomImplTest {

    private static final String SQL_REGULARIZAR_MEJOR_OPCION = "REGULARIZAR MEJOR OPCION TEST";

    private static final String SQL_REGULARIZAR_CHALLENGE = "REGULARIZAR CHALLENGE TEST";

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @InjectMocks
    private TareaCalculoRepositoryCustomImpl tareaCalculoRepositoryCustom;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> params;

    @Captor
    private ArgumentCaptor<String> sql;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaCalculoRepositoryCustom, "sqlRegularizarMejorOpcion", SQL_REGULARIZAR_MEJOR_OPCION,
                true);
        FieldUtils.writeField(tareaCalculoRepositoryCustom, "sqlRegularizarChallenge", SQL_REGULARIZAR_CHALLENGE, true);
    }

    @Test
    public void regularizarMejorOpcionTest() {
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(12L);

        tareaCalculoRepositoryCustom.regularizarMejorOpcion(tarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sql.capture(), params.capture());
        assertEquals(SQL_REGULARIZAR_MEJOR_OPCION, sql.getValue());
        // parametros de la consulta: idTarea
        assertEquals(2, params.getValue().getValues().size());
        assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    }

    @Test
    public void regularizarChallengeTest() {
        TareaDto tarea = mock(TareaDto.class);
        IdPersonaLocalChallengeDto idPersonaLocalChallengeDto = mock(IdPersonaLocalChallengeDto.class);
        when(tarea.getId()).thenReturn(12L);

        tareaCalculoRepositoryCustom.regularizarChallenge(tarea, idPersonaLocalChallengeDto);
        verify(namedParameterJdbcTemplate, times(1)).update(sql.capture(), params.capture());
        assertEquals(SQL_REGULARIZAR_CHALLENGE, sql.getValue());
        // parametros de la consulta: idTarea
        assertEquals(7, params.getValue().getValues().size());
        assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON));
        assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD));
        assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));
        assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION));
        assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO));
        assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
        assertEquals(tarea.getId(), params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    }

}
