package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
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
public class TrabajoRepositoryCustomImplTest {

    private final static String SQL_UPDATE_ESTADO = "SQL UPDATE ESTADO";

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @InjectMocks
    private TrabajoRepositoryCustomImpl trabajoRepositoryCustom;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> parametersCaptor;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(trabajoRepositoryCustom, "sqlUpdateFechaInicioAndEstado", SQL_UPDATE_ESTADO, true);
    }

    @Test
    public void updateEstadoTest() {

        TrabajoDto trabajo = mock(TrabajoDto.class);
        when(trabajo.getId()).thenReturn(100L);
        EstadoTrabajoDto estado = mock(EstadoTrabajoDto.class);
        when(estado.getId()).thenReturn(78);

        trabajoRepositoryCustom.updateEstado(trabajo, estado);
        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), parametersCaptor.capture());
        assertEquals(SQL_UPDATE_ESTADO, sqlCaptor.getValue());
        MapSqlParameterSource params = parametersCaptor.getValue();

        // Parámetros de la consulta: idTrabajo, nuevoIdEstado
        assertEquals(3, params.getValues().size());
        // idTrabajo
        assertTrue(params.hasValue("idTrabajo"));
        assertEquals(trabajo.getId(), params.getValue("idTrabajo"));
        // nuevoIdEstado
        assertTrue(params.hasValue("nuevoIdEstado"));
        assertEquals(estado.getId(), params.getValue("nuevoIdEstado"));

    }
}
