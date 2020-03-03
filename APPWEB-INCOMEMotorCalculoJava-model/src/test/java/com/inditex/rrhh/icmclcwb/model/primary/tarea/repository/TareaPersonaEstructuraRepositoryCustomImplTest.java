package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
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
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.time.LocalDate;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TareaPersonaEstructuraRepositoryCustomImplTest {

    private static final String SQL_UPDATE_ACTIVO_TOPES = "SQL UPDATE ACTIVO TOPES";

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @InjectMocks
    private TareaPersonaEstructuraRepositoryCustomImpl tareaPersonaEstructuraRepositoryCustom;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaPersonaEstructuraRepositoryCustom, "sqlUpdateActivoTopes", SQL_UPDATE_ACTIVO_TOPES, true);
    }

    @Test
    public void updateActivoTopesTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(890L);
        when(tarea.getFechaInicioPeriodo()).thenReturn(LocalDate.of(2019, 1, 1));

        tareaPersonaEstructuraRepositoryCustom.updateActivoTopes(tarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_UPDATE_ACTIVO_TOPES, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();
        // Parámetros de la consulta: activo, fechaInicioPeriodo, idTarea, icmOrdTope
        assertEquals(4, params.getValues().size());
        // activo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        // fechaInicioPeriodo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO));
        assertEquals(TimeUtils.toDate(tarea.getFechaInicioPeriodo()), params.getValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO));
        // idTarea
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        // icmOrdTope
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ICM_ORD_TOPE));
        assertEquals(AppConstants.TOPE_DEFAULT, params.getValue(SqlPrimaryConstants.SQL_PARAM_ICM_ORD_TOPE));
    }

}
