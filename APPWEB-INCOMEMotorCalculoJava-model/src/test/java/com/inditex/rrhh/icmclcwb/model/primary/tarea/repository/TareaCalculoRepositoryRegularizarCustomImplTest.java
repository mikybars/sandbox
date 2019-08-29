package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

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
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TareaCalculoRepositoryRegularizarCustomImplTest {

    private static final String SQL_REGULARIZAR_MEJOR_OPCION = "REGULARIZAR MEJOR OPCION TEST";

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
        FieldUtils.writeField(tareaCalculoRepositoryCustom, "sqlRegularizarMejorOpcion", SQL_REGULARIZAR_MEJOR_OPCION, true);
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
}
