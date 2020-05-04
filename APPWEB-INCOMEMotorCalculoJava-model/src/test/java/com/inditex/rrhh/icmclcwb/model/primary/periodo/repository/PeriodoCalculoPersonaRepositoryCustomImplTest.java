package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import com.inditex.rrhh.icmclcwb.api.app.periodo.dto.EstadoPeriodoCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.time.DateUtils;
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

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PeriodoCalculoPersonaRepositoryCustomImplTest {

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String SQL_MERGE = "MERGE BLA BLA BLA";

    @Captor
    ArgumentCaptor<MapSqlParameterSource> params;

    @InjectMocks
    private PeriodoCalculoPersonaRepositoryCustomImpl periodoCalculoPersonaRepositoryCustom;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(periodoCalculoPersonaRepositoryCustom, "sqlMergePeriodoCalculoPersona", SQL_MERGE, true);
    }

    @Test
    public void mergePeriodoCalculoPersonaParamsTest() {

        Long idTarea = 555l;
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(idTarea);
        RunTareaDto runTarea = mock(RunTareaDto.class);
        when(runTarea.getTarea()).thenReturn(tarea);

        periodoCalculoPersonaRepositoryCustom.mergePeriodoCalculoPersona(runTarea);

        verify(namedParameterJdbcTemplate, times(1)).update(any(String.class), params.capture());

        // Parametros del SQL: idTarea, bloqueado, desbloqueado, idEstadoTareaPersona,
        // idEstadoTareaPersonaKo, nuevaFecha, idEstadoPeriodoPersona, idEstadoPeriodoPersonaCalculadoError
        assertEquals(8, params.getValue().getValues().size());
        // idTarea
        assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(idTarea, params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        // bloqueado + desbloqueado
        assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_BLOQUEADO));
        assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_DESBLOQUEADO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
                params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_DESBLOQUEADO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
                params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_BLOQUEADO));
        // idEstadoTareaPersona
        assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_TAREA_PERSONA));
        assertEquals(EstadoTareaCalculoPersonaEnum.OK.getId(),
                params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_TAREA_PERSONA));
        // nuevaFecha
        assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA));
        assertEquals(DateUtils.truncate(TimeUtils.nowDate(), Calendar.SECOND),
                DateUtils.truncate(params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA),
                        Calendar.SECOND));
        // idEstadoPeriodoPersona
        assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_PERIODO_PERSONA));
        assertEquals(EstadoPeriodoCalculoPersonaEnum.CALCULADO.getId(),
                params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_PERIODO_PERSONA));
        // idEstadoPeriodoPersonaCalculadoError
        assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_PERIODO_PERSONA_CALCULADO_ERROR));
        assertEquals(EstadoPeriodoCalculoPersonaEnum.CALCULADO_ERROR.getId(),
                params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_PERIODO_PERSONA_CALCULADO_ERROR));

    }

    @Test(expected = NullPointerException.class)
    public void mergePeriodoCalculoPersonaTareaNullTest() {
        periodoCalculoPersonaRepositoryCustom.mergePeriodoCalculoPersona(null);
    }

}
