package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import java.util.Calendar;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inditex.rrhh.icmclcwb.api.app.periodo.dto.EstadoPeriodoCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Assertions;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class PeriodoCalculoPersonaRepositoryCustomImplTest {

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String SQL_MERGE = "MERGE ";

    private static final String SQL_LIMPIEZA = "LIMPIEZA ";


    @Captor
    ArgumentCaptor<MapSqlParameterSource> params;

    @InjectMocks
    private PeriodoCalculoPersonaRepositoryCustomImpl periodoCalculoPersonaRepositoryCustom;

    @BeforeEach
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(this.periodoCalculoPersonaRepositoryCustom, "sqlMergePeriodoCalculoPersona", SQL_MERGE,
                true);
        FieldUtils.writeField(this.periodoCalculoPersonaRepositoryCustom, "sqlLimpiezaPeriodoCalculoPersona",
                SQL_LIMPIEZA,
                true);
    }

    @Test
    public void mergePeriodoCalculoPersonaParamsTest() {

        final Long idTarea = 555l;
        final TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(idTarea);
        final RunTareaDto runTarea = mock(RunTareaDto.class);
        when(runTarea.getTarea()).thenReturn(tarea);

        this.periodoCalculoPersonaRepositoryCustom.mergePeriodoCalculoPersona(runTarea);

        verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.params.capture());

        // Parametros del SQL: idTarea, bloqueado, desbloqueado, idEstadoTareaPersona,
        // idEstadoTareaPersonaKo, nuevaFecha, idEstadoPeriodoPersona, idEstadoPeriodoPersonaCalculadoError
        assertEquals(8, this.params.getValue().getValues().size());
        // idTarea
        assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(idTarea, this.params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        // bloqueado + desbloqueado
        assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_BLOQUEADO));
        assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_DESBLOQUEADO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
                this.params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_DESBLOQUEADO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
                this.params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_BLOQUEADO));
        // idEstadoTareaPersona
        assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_TAREA_PERSONA));
        assertEquals(EstadoTareaCalculoPersonaEnum.OK.getId(),
                this.params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_TAREA_PERSONA));
        // nuevaFecha
        assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA));
        assertEquals(DateUtils.truncate(TimeUtils.nowDate(), Calendar.SECOND),
                DateUtils.truncate(this.params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA),
                        Calendar.SECOND));
        // idEstadoPeriodoPersona
        assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_PERIODO_PERSONA));
        assertEquals(EstadoPeriodoCalculoPersonaEnum.CALCULADO.getId(),
                this.params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_PERIODO_PERSONA));
        // idEstadoPeriodoPersonaCalculadoError
        assertTrue(this.params.getValue()
            .hasValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_PERIODO_PERSONA_CALCULADO_ERROR));
        assertEquals(EstadoPeriodoCalculoPersonaEnum.CALCULADO_ERROR.getId(),
                this.params.getValue()
                    .getValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_PERIODO_PERSONA_CALCULADO_ERROR));

    }

    @Test
    public void limpiezaPeriodoCalculoPersonaParamsTest() {

        final Long idTarea = 555l;
        final TareaDto tarea = mock(TareaDto.class);
        final TrabajoDTO trabajo = mock(TrabajoDTO.class);

        when(tarea.getId()).thenReturn(idTarea);
        when(tarea.getStdIdLegEnt()).thenReturn("1");
        when(trabajo.getIcmIdPeriodo()).thenReturn(1L);

        final RunTareaDto runTarea = mock(RunTareaDto.class);
        when(runTarea.getTarea()).thenReturn(tarea);
        when(runTarea.getTrabajo()).thenReturn(trabajo);

        final TareaAmbitoDto tareaAmbitoDto = mock(TareaAmbitoDto.class);
        when(tareaAmbitoDto.getCclIdOrigen()).thenReturn("1");

        this.periodoCalculoPersonaRepositoryCustom.limpiezaPeriodoCalculoPersona(runTarea, tareaAmbitoDto);

        verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.params.capture());

        // Parametros del SQL: idTarea, bloqueado, desbloqueado, idEstadoTareaPersona,
        // idEstadoTareaPersonaKo, nuevaFecha, idEstadoPeriodoPersona, idEstadoPeriodoPersonaCalculadoError
        assertEquals(5, this.params.getValue().getValues().size());
        // idTarea
        assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(idTarea, this.params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

        // idEstadoTareaPersona
        assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_DESBLOQUEADO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
                this.params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_DESBLOQUEADO));
        // origen
        assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN));
        assertEquals("1",
                this.params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN));
        // empresa
        assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT));
        assertEquals("1",
                this.params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT));
        // periodo
        assertTrue(this.params.getValue()
            .hasValue(SqlPrimaryConstants.SQL_PARAM_ICM_ID_PERIODO));

    }

    @Test
    public void mergePeriodoCalculoPersonaTareaNullTest() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            this.periodoCalculoPersonaRepositoryCustom.mergePeriodoCalculoPersona(null);
        });
    }

    @Test
    public void limpiezaPeriodoCalculoPersonaNullTest() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            this.periodoCalculoPersonaRepositoryCustom.limpiezaPeriodoCalculoPersona(null, null);
        });
    }

}
