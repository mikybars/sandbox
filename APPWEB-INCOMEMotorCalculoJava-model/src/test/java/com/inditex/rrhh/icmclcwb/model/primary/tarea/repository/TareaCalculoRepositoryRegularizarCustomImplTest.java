package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.time.LocalDate;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TareaCalculoRepositoryRegularizarCustomImplTest {

    private static final String SQL_REGULARIZAR_MEJOR_OPCION = "REGULARIZAR MEJOR OPCION TEST";

    private static final String SQL_REGULARIZAR_MEJOR_OPCION_SIN_FECHAS = "REGULARIZAR MEJOR OPCION SIN FECHAS TEST";

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
        FieldUtils.writeField(this.tareaCalculoRepositoryCustom, "sqlRegularizarMejorOpcion",
                SQL_REGULARIZAR_MEJOR_OPCION,
                true);
        FieldUtils.writeField(this.tareaCalculoRepositoryCustom, "sqlRegularizarMejorOpcionSinFechas",
                SQL_REGULARIZAR_MEJOR_OPCION_SIN_FECHAS,
                true);
        FieldUtils.writeField(this.tareaCalculoRepositoryCustom, "sqlRegularizarChallenge", SQL_REGULARIZAR_CHALLENGE,
                true);
    }

    @Test
    public void regularizarMejorOpcionTest() {
        final TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(12L);
        when(tarea.getFechaInicioPeriodo()).thenReturn(LocalDate.now());

        this.tareaCalculoRepositoryCustom.regularizarMejorOpcion(tarea);
        verify(this.namedParameterJdbcTemplate, times(1)).update(this.sql.capture(), this.params.capture());
        assertEquals(SQL_REGULARIZAR_MEJOR_OPCION, this.sql.getValue());
        // parametros de la consulta: idTarea
        assertEquals(3, this.params.getValue().getValues().size());
        assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), this.params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    }

    @Test
    public void regularizarMejorOpcionSinFechasTest() {
        final TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(12L);
        when(tarea.getFechaInicioPeriodo()).thenReturn(LocalDate.now());

        this.tareaCalculoRepositoryCustom.regularizarMejorOpcionSinFechas(tarea);
        verify(this.namedParameterJdbcTemplate, times(1)).update(this.sql.capture(), this.params.capture());
        assertEquals(SQL_REGULARIZAR_MEJOR_OPCION_SIN_FECHAS, this.sql.getValue());
        // parametros de la consulta: idTarea
        assertEquals(3, this.params.getValue().getValues().size());
        assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), this.params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    }

    @Test
    public void regularizarChallengeTest() {
        final TareaDto tarea = mock(TareaDto.class);
        final IdPersonaLocalChallengeDto idPersonaLocalChallengeDto = mock(IdPersonaLocalChallengeDto.class);
        when(tarea.getId()).thenReturn(12L);

        this.tareaCalculoRepositoryCustom.regularizarChallenge(tarea, idPersonaLocalChallengeDto);
        verify(this.namedParameterJdbcTemplate, times(1)).update(this.sql.capture(), this.params.capture());
        assertEquals(SQL_REGULARIZAR_CHALLENGE, this.sql.getValue());
        // parametros de la consulta: idTarea
        assertEquals(7, this.params.getValue().getValues().size());
        assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON));
        assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD));
        assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));
        assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION));
        assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO));
        assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO_BASE));
        assertEquals(tarea.getId(), this.params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    }

}
