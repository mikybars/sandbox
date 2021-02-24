/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.primary.comis.repository;

import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalFechaIncidenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlComisConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.comis.repository.ComisRepositoryCustomImpl;
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
public class ComisRepositoryCustomImplTest {

    private final static String SQL_FIND_PRESENCIAS_ORIGEN_AND_FECHA = "SQL FIND PRESENCIAS ORIGEN AND FECHA";

    private final static String SQL_FIND_MOTIVOS_DESPLAZAMIENTO = "SQL FIND MOTIVOS DESPLAZAMIENTO";

    private final static String SQL_FIND_FECHAS_INCIDENCIAS = "SQL FIND FECHAS INCIDENCIAS";

    private final static String SQL_FIND_FECHAS_DESPLAZAMIENTO = "SQL FIND FECHAS DESPLAZAMIENTO";

    private final static String SQL_FIND_CONDICIONES_HISTORICO = "SQL FIND CONDICIONES HISTORICO";

    private final static String SQL_FIND_CONDICIONES_DESPLAZAMIENTO = "SQL FIND CONDICIONES DESPLAZAMIENTO";

    private final static String SQL_FIND_CONDICIONES_RESALTA = "SQL FIND CONDICIONES RESALTA";

    private final static String SQL_FIND_BAJAS_IT = "SQL FIND BAJAS IT";

    private final static String SQL_FIND_CARENCIA = "SQL FIND CARENCIA";

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @InjectMocks
    private ComisRepositoryCustomImpl comisRepositoryCustom;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(this.comisRepositoryCustom,
                "sqlFindPresenciasOrigenAndFechaQuery",
                SQL_FIND_PRESENCIAS_ORIGEN_AND_FECHA, true);
        FieldUtils.writeField(this.comisRepositoryCustom,
                "sqlFindMotivosDesplazamiento",
                SQL_FIND_MOTIVOS_DESPLAZAMIENTO, true);
        FieldUtils.writeField(this.comisRepositoryCustom,
                "sqlFindFechasIncidencias",
                SQL_FIND_FECHAS_INCIDENCIAS,
                true);
        FieldUtils.writeField(this.comisRepositoryCustom,
                "sqlFindFechasDesplazamiento",
                SQL_FIND_FECHAS_DESPLAZAMIENTO,
                true);
        FieldUtils.writeField(this.comisRepositoryCustom,
                "sqlFindCondicionesHistorico", SQL_FIND_CONDICIONES_HISTORICO,
                true);
        FieldUtils.writeField(this.comisRepositoryCustom,
                "sqlFindCondicionesDesplazamiento",
                SQL_FIND_CONDICIONES_DESPLAZAMIENTO,
                true);
        FieldUtils.writeField(this.comisRepositoryCustom,
                "sqlFindCondicionesResalta",
                SQL_FIND_CONDICIONES_RESALTA,
                true);
        FieldUtils.writeField(this.comisRepositoryCustom,
                "sqlFindBajasIt",
                SQL_FIND_BAJAS_IT,
                true);
        FieldUtils.writeField(this.comisRepositoryCustom,
                "sqlFindCarencia",
                SQL_FIND_CARENCIA,
                true);
    }

    @Test
    public void findPresenciasOrigenAndFecha() {
        final TareaDto tarea = new TareaDto();
        tarea.setFechaInicioPeriodo(LocalDate.now());
        tarea.setFechaFinPeriodo(LocalDate.now());
        this.comisRepositoryCustom.findPresenciasOrigenAndFecha(tarea);
        verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(this.sqlCaptor.capture(),
                this.paramsCaptor.capture(),
                ArgumentMatchers.<RowMapper<PresenciaOrigenDto>>any());
        assertEquals(SQL_FIND_PRESENCIAS_ORIGEN_AND_FECHA,
                this.sqlCaptor.getValue());
        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        // Parámetros de la consulta: fechainicio, fechafin
        assertEquals(2, params.getValues().size());
        // fechainicio
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO));
        // fechafin
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_FECHA_FIN));
    }

    @Test
    public void findMotivoDesplazamiento() {
        final TareaDto tarea = new TareaDto();
        tarea.setIdOrganization("1");
        tarea.setFechaInicioPeriodo(LocalDate.now());
        tarea.setFechaFinPeriodo(LocalDate.now());
        this.comisRepositoryCustom.findMotivoDesplazamiento(tarea);
        verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(),
                this.paramsCaptor.capture(),
                ArgumentMatchers.<RowMapper<Object>>any());
        assertEquals(SQL_FIND_MOTIVOS_DESPLAZAMIENTO,
                this.sqlCaptor.getValue());
        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        // Parámetros de la consulta: idOrganization
        assertEquals(1, params.getValues().size());
        // idOrganization
        assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_ID_ORGANIZATION));
        assertEquals(tarea.getIdOrganization(), params.getValue(SqlComisConstants.SQL_PARAM_ID_ORGANIZATION));
    }

    @Test
    public void findFechasIncidencias() {
        final LocalDate date = LocalDate.now();
        this.comisRepositoryCustom.findFechasIncidencias(date);
        verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
                ArgumentMatchers.<RowMapper<IdPersonaLocalFechaIncidenciaDto>>any());
        assertEquals(SQL_FIND_FECHAS_INCIDENCIAS,
                this.sqlCaptor.getValue());
        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        // Parámetros de la consulta: fecha inicio
        assertEquals(1, params.getValues().size());
        // fecha inicio
        assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_INICIO));
    }

    @Test
    public void findFechasDesplazamientos() {
        final LocalDate date = LocalDate.now();
        this.comisRepositoryCustom.findFechasDesplazamientos(date);
        verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
                ArgumentMatchers.<RowMapper<IdPersonaLocalFechaIncidenciaDto>>any());
        assertEquals(SQL_FIND_FECHAS_DESPLAZAMIENTO,
                this.sqlCaptor.getValue());
        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        // Parámetros de la consulta: fecha inicio
        assertEquals(1, params.getValues().size());
        // fecha inicio
        assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_INICIO));
    }

    @Test
    public void findCondicionesHistorico() {
        final TareaDto tarea = new TareaDto();
        tarea.setIdOrganization("1");
        tarea.setFechaInicioPeriodo(LocalDate.now());
        tarea.setFechaFinPeriodo(LocalDate.now());
        this.comisRepositoryCustom.findCondicionesHistorico(tarea);
        verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
                ArgumentMatchers.<RowMapper<IdPersonaLocalCondicionesDto>>any());
        assertEquals(SQL_FIND_CONDICIONES_HISTORICO,
                this.sqlCaptor.getValue());
        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        // Parámetros de la consulta: fecha desde, fecha hasta
        assertEquals(2, params.getValues().size());
        // fecha desde
        assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE));
        // fecha hasta
        assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
    }

    @Test
    public void findCondicionesDesplazamiento() {
        final TareaDto tarea = new TareaDto();
        tarea.setIdOrganization("1");
        tarea.setFechaInicioPeriodo(LocalDate.now());
        tarea.setFechaFinPeriodo(LocalDate.now());
        this.comisRepositoryCustom.findCondicionesDesplazamiento(tarea);
        verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
                ArgumentMatchers.<RowMapper<IdPersonaLocalCondicionesDto>>any());
        assertEquals(SQL_FIND_CONDICIONES_DESPLAZAMIENTO,
                this.sqlCaptor.getValue());
        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        // Parámetros de la consulta: fecha desde, fecha hasta
        assertEquals(2, params.getValues().size());
        // fecha desde
        assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE));
        // fecha hasta
        assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
    }

    @Test
    public void findCondicionesResalta() {
        final TareaDto tarea = new TareaDto();
        tarea.setIdOrganization("1");
        tarea.setFechaInicioPeriodo(LocalDate.now());
        tarea.setFechaFinPeriodo(LocalDate.now());
        this.comisRepositoryCustom.findCondicionesResalta(tarea);
        verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
                ArgumentMatchers.<RowMapper<IdPersonaLocalCondicionesDto>>any());
        assertEquals(SQL_FIND_CONDICIONES_RESALTA,
                this.sqlCaptor.getValue());
        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        // Parámetros de la consulta: fecha desde, fecha hasta
        assertEquals(2, params.getValues().size());
        // fecha desde
        assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE));
        // fecha hasta
        assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
    }

    @Test
    public void findBajasIt() {
        final TareaDto tarea = new TareaDto();
        tarea.setIdOrganization("1");
        tarea.setFechaInicioPeriodo(LocalDate.now());
        tarea.setFechaFinPeriodo(LocalDate.now());
        this.comisRepositoryCustom.findBajasIt(tarea);
        verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
                ArgumentMatchers.<RowMapper<IdPersonaLocalCondicionesDto>>any());
        assertEquals(SQL_FIND_BAJAS_IT,
                this.sqlCaptor.getValue());
        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        // Parámetros de la consulta: fecha desde, fecha hasta
        assertEquals(2, params.getValues().size());
        // fecha desde
        assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE));
        // fecha hasta
        assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
    }

    @Test
    public void findCarencia() {
        final TareaDto tarea = new TareaDto();
        tarea.setIdOrganization("1");
        this.comisRepositoryCustom.findCarencia(tarea);
        verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
                ArgumentMatchers.<RowMapper<IdPersonaLocalCarenciaDto>>any());
        assertEquals(SQL_FIND_CARENCIA,
                this.sqlCaptor.getValue());
        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        // Parámetros de la consulta: fecha desde, fecha hasta
        assertEquals(2, params.getValues().size());
        // fecha desde
        assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE));
        // fecha hasta
        assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
    }

}
