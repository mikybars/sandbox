package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TareaAmbitoGlobalLocalizacionRepositoryCustomImplTest {

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> params;

    @InjectMocks
    private TareaAmbitoGlobalLocalizacionRepositoryCustomImpl tareaAmbitoGlobalLocalizacionRepositoryCustom;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaAmbitoGlobalLocalizacionRepositoryCustom, "sqlMergeLocalizacion", "", true);
    }

    @Test
    public void mergeLocalizacionTest() {

        RunTareaDto runTarea = mock(RunTareaDto.class);
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(901L);
        when(runTarea.getTarea()).thenReturn(tarea);

        tareaAmbitoGlobalLocalizacionRepositoryCustom.mergeLocalizacion(runTarea);
        verify(namedParameterJdbcTemplate, times(1)).update(any(String.class), params.capture());
        // parametros de la consulta: id tarea
        assertEquals(1, params.getValue().getValues().size());
        assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    }

}
