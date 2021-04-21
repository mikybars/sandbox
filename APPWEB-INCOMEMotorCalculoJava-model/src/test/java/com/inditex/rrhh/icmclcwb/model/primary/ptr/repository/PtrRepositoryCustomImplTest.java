/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.primary.ptr.repository;

import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.ptr.repository.PtrRepositoryCustomImpl;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PtrRepositoryCustomImplTest {

    private final static String SQL_FIND_PRESENCIAS_ORIGEN_AND_FECHA = "SQL FIND PRESENCIAS ORIGEN AND FECHA";

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @InjectMocks
    private PtrRepositoryCustomImpl ptrRepositoryCustom;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(this.ptrRepositoryCustom,
                "sqlfindPresenciasOrigenAndFechaQuery",
                SQL_FIND_PRESENCIAS_ORIGEN_AND_FECHA, true);

    }

    @Test
    public void findPresenciasOrigenAndFecha() {
        final TareaDto tarea = new TareaDto();
        final TareaAmbitoDto ambito = new TareaAmbitoDto();
        tarea.setFechaInicioPeriodo(LocalDate.now());
        tarea.setFechaFinPeriodo(LocalDate.now());
        this.ptrRepositoryCustom.findPresenciasOrigenAndFecha(tarea, ambito);
        verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(this.sqlCaptor.capture(),
                this.paramsCaptor.capture(),
                ArgumentMatchers.<RowMapper<PresenciaOrigenDto>>any());
        assertEquals(SQL_FIND_PRESENCIAS_ORIGEN_AND_FECHA,
                this.sqlCaptor.getValue());
        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        // Parámetros de la consulta: fechainicio, fechafin
        assertEquals(3, params.getValues().size());
        // fechainicio
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO));
        // fechafin
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_FECHA_FIN));
    }

}
