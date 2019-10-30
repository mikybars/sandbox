package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaHistorico;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.*;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TareaPersonaHistoricoRepositoryCustomImplTest {

    private final static String SQL_SAVE = "SQL SAVE";

    private final static String SQL_FIND_ID_PERSONA_BY_ID_TAREA_AND_ID_ORIGEN = "SQL FIND ID PERSONA BY ID TAREA AND ID ORIGEN";

    private final static String SQL_FIND_ID_PERSONA_HISTORICO_BY_ID_TAREA_AND_ID_ORIGEN_AND_TIPO_DATO_IN_AMBITO = "SQL FIND ID PERSONA HISTORICO BY ID TAREA AND ID ORIGEN AND TIPO DATO IN AMBITO";

    private final static String SQL_FIND_ID_PERSONA_HISTORICO_BY_ID_TAREA_AND_ID_ORIGEN = "SQL FIND ID PERSONA HISTORICO BY ID TAREA AND ID ORIGEN";

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @InjectMocks
    private TareaPersonaHistoricoRepositoryCustomImpl tareaPersonaHistoricoRepositoryCustom;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaPersonaHistoricoRepositoryCustom,
            "sqlSave", SQL_SAVE, true);
        FieldUtils.writeField(tareaPersonaHistoricoRepositoryCustom,
            "sqlFindIdPersonaByIdTareaAndIdOrigen", SQL_FIND_ID_PERSONA_BY_ID_TAREA_AND_ID_ORIGEN, true);
        FieldUtils.writeField(tareaPersonaHistoricoRepositoryCustom,
            "sqlFindIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito",
            SQL_FIND_ID_PERSONA_HISTORICO_BY_ID_TAREA_AND_ID_ORIGEN_AND_TIPO_DATO_IN_AMBITO, true);
        FieldUtils.writeField(tareaPersonaHistoricoRepositoryCustom,
            "sqlFindIdPersonaHistoricoByIdTareaAndIdOrigen", SQL_FIND_ID_PERSONA_HISTORICO_BY_ID_TAREA_AND_ID_ORIGEN,
            true);
        FieldUtils.writeField(tareaPersonaHistoricoRepositoryCustom,
            "batchSize", 100, true);
    }

    @Test
    public void setParametersTest() throws SQLException {

        PreparedStatement pstmt = mock(PreparedStatement.class);
        Tarea tarea = mock(Tarea.class);
        when(tarea.getId()).thenReturn(900L);
        TareaPersonaHistorico entity = mock(TareaPersonaHistorico.class);
        when(entity.getFechaInicio()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 1, 1)));
        when(entity.getFechaFin()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 12, 1)));
        when(entity.getFechaInicioSeccion()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 1, 2)));
        when(entity.getFechaFinSeccion()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 11, 30)));
        when(entity.getStdIdHr()).thenReturn("STD_ID_HR");
        when(entity.getCclIdPerson()).thenReturn("CCL_ID_PERSON");
        when(entity.getCclIdCodOrigen()).thenReturn("CCL_ID_COD_ORIGEN");
        when(entity.getStdIdWorkLocat()).thenReturn("STD_ID_WORK_LOCAT");
        when(entity.getStdOrHrPeriod()).thenReturn("STD_OR_HR_PERIOD");
        when(entity.getStdIdLegEnt()).thenReturn("STD_ID_LEG_ENT");
        when(entity.getCclIdOrigen()).thenReturn("CCL_ID_ORIGEN");
        when(entity.getCclIdSeccion()).thenReturn("CCL_ID_SECCION");
        when(entity.getTarea()).thenReturn(tarea);

        tareaPersonaHistoricoRepositoryCustom.setParameters(pstmt, entity);
        // Parámetros de la consulta: fechaFin, fechaInicio, fechaFinSeccion, fechaInicioSeccion, stdIdHr, cclIdPerson,
        // cclIdCodOrigen, stdIdWorkLocat, stdOrHrPeriod, stdIdLegEnt, cclIdOrigen, cclIdSeccion, idTarea
        verify(pstmt, times(1)).setObject(1, entity.getFechaFin());
        verify(pstmt, times(1)).setObject(2, entity.getFechaInicio());
        verify(pstmt, times(1)).setObject(3, entity.getFechaFinSeccion());
        verify(pstmt, times(1)).setObject(4, entity.getFechaInicioSeccion());
        verify(pstmt, times(1)).setObject(5, entity.getFechaFinLocalizacion());
        verify(pstmt, times(1)).setObject(6, entity.getFechaInicioLocalizacion());
        verify(pstmt, times(1)).setString(7, entity.getStdIdHr());
        verify(pstmt, times(1)).setString(8, entity.getCclIdPerson());
        verify(pstmt, times(1)).setString(9, entity.getCclIdCodOrigen());
        verify(pstmt, times(1)).setString(10, entity.getStdIdWorkLocat());
        verify(pstmt, times(1)).setString(11, entity.getStdOrHrPeriod());
        verify(pstmt, times(1)).setString(12, entity.getStdIdLegEnt());
        verify(pstmt, times(1)).setString(13, entity.getCclIdOrigen());
        verify(pstmt, times(1)).setString(14, entity.getCclIdSeccion());
        verify(pstmt, times(1)).setLong(15, tarea.getId());
    }

    @Test
    public void saveTest() {
        List<TareaPersonaHistorico> items = Collections.singletonList(mock(TareaPersonaHistorico.class));
        tareaPersonaHistoricoRepositoryCustom.save(items);
        verify(jdbcTemplate, times(1)).batchUpdate(sqlCaptor.capture(), any(BatchPreparedStatementSetter.class));
        assertEquals(SQL_SAVE, sqlCaptor.getValue());
    }

    @Test
    public void findIdPersonaByIdTareaAndIdOrigenInAmbitoTest() {

        String idOrigen = "CCL_ID_ORIGEN";
        long idTarea = 10L;
        tareaPersonaHistoricoRepositoryCustom.findIdPersonaByIdTareaAndIdOrigenInAmbito(idTarea, idOrigen);

        verify(namedParameterJdbcTemplate, times(1)).query(sqlCaptor.capture(), paramsCaptor.capture(), any(RowMapper.class));
        assertEquals(SQL_FIND_ID_PERSONA_BY_ID_TAREA_AND_ID_ORIGEN, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();
        // Parámetros de la consulta: idTarea, cclIdOrigen
        assertEquals(2, params.getValues().size());
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(idTarea, params.getValue(SQL_PARAM_ID_TAREA));
        // cclIdOrigen
        assertTrue(params.hasValue(SQL_PARAM_CCL_ID_ORIGEN));
        assertEquals(idOrigen, params.getValue(SQL_PARAM_CCL_ID_ORIGEN));
    }

    @Test
    public void findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbitoTest() {

        long idTarea = 900L;
        String idOrigen = "CCL_ID_ORIGEN";
        List<Integer> tiposDato = Arrays.asList(12,39,211);
        tareaPersonaHistoricoRepositoryCustom.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(idTarea, idOrigen, tiposDato);

        verify(namedParameterJdbcTemplate, times(1)).query(sqlCaptor.capture(), paramsCaptor.capture(), any(RowMapper.class));
        assertEquals(SQL_FIND_ID_PERSONA_HISTORICO_BY_ID_TAREA_AND_ID_ORIGEN_AND_TIPO_DATO_IN_AMBITO, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();
        // Parámetros de la consulta: idTarea, cclIdOrigen, tiposDato
        assertEquals(3, params.getValues().size());
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(idTarea, params.getValue(SQL_PARAM_ID_TAREA));
        // cclIdOrigen
        assertTrue(params.hasValue(SQL_PARAM_CCL_ID_ORIGEN));
        assertEquals(idOrigen, params.getValue(SQL_PARAM_CCL_ID_ORIGEN));
        // tiposDato
        assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(tiposDato, params.getValue(SQL_PARAM_IDS_TIPOS_DATO));
    }

    @Test
    public void findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbitoTest() {

        String idOrigen = "CCL_ID_ORIGEN";
        long idTarea = 10L;
        tareaPersonaHistoricoRepositoryCustom.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(idTarea, idOrigen);

        verify(namedParameterJdbcTemplate, times(1)).query(sqlCaptor.capture(), paramsCaptor.capture(), any(RowMapper.class));
        assertEquals(SQL_FIND_ID_PERSONA_HISTORICO_BY_ID_TAREA_AND_ID_ORIGEN, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();
        // Parámetros de la consulta: idTarea, cclIdOrigen
        assertEquals(2, params.getValues().size());
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(idTarea, params.getValue(SQL_PARAM_ID_TAREA));
        // cclIdOrigen
        assertTrue(params.hasValue(SQL_PARAM_CCL_ID_ORIGEN));
        assertEquals(idOrigen, params.getValue(SQL_PARAM_CCL_ID_ORIGEN));

    }
}
