package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

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

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructura;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraPk;

@RunWith(MockitoJUnitRunner.class)
public class TareaPersonaEstructuraRepositoryCustomImplTest {

    private static final String SQL_UPDATE_ACTIVO_TOPES = "SQL UPDATE ACTIVO TOPES";
    private static final String SQL_FIND_PERSONAS_CHALLENGE = "SQL FIND PERSONAS CHALLENGE";
    private static final String SQL_SAVE = "SQL_SAVE";

    @Mock
    private JdbcTemplate jdbcTemplate;
    
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
        FieldUtils.writeField(tareaPersonaEstructuraRepositoryCustom, "sqlFindPersonasChallenge", SQL_FIND_PERSONAS_CHALLENGE, true);
        FieldUtils.writeField(tareaPersonaEstructuraRepositoryCustom, "sqlSave", SQL_SAVE, true);
        FieldUtils.writeField(tareaPersonaEstructuraRepositoryCustom, "batchSize", 100, true);
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

    @Test
    public void findPersonasChallengeTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(8209L);
        when(tarea.getFechaInicioPeriodo()).thenReturn(LocalDate.of(2019, 12, 1));

        tareaPersonaEstructuraRepositoryCustom.findPersonasChallenge(tarea);
        verify(namedParameterJdbcTemplate, times(1)).query(sqlCaptor.capture(), paramsCaptor.capture(), any(RowMapper.class));
        assertEquals(SQL_FIND_PERSONAS_CHALLENGE, sqlCaptor.getValue());
        MapSqlParameterSource map = paramsCaptor.getValue();
        // Parámetros de la consulta: fechaInicioPeriodo, idTarea, tiposCalculo
        assertEquals(3, map.getValues().size());
        // fechaInicio
        assertTrue(map.hasValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO));
        assertEquals(TimeUtils.toDate(tarea.getFechaInicioPeriodo()), map.getValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO));
        // idTarea
        assertTrue(map.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), map.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        // fechaInicio
        assertTrue(map.hasValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));
        assertEquals(Arrays.asList(TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId(), TipoCalculoEnum.CHALLENGE_PRECIO_HORA_SECCION.getId(),
            TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId(), TipoCalculoEnum.CHALLENGE_IMPORTE_SECCION.getId()), map.getValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));

    }

    @Test
    public void getMapValuesTest() throws SQLException {
        PreparedStatement pstmt = mock(PreparedStatement.class);
        Tarea tarea = mock(Tarea.class);
        when(tarea.getId()).thenReturn(900L);
        TareaPersonaEstructura entity = mock(TareaPersonaEstructura.class);
        TareaPersonaEstructuraPk pk = mock(TareaPersonaEstructuraPk.class);
        when(pk.getFechaInicioPeriodo()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 1, 1)));

        when(entity.getPk()).thenReturn(pk);
        when(entity.getFechaInicio()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 1, 1)));
        when(entity.getFechaFin()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 12, 1)));
        when(entity.getCclIdSeccionEfectiva()).thenReturn("1");
        when(entity.getCclIdSeccionEstructura()).thenReturn("1");
        when(entity.getStdIdHr()).thenReturn("STD_ID_HR");
        when(entity.getCclIdPerson()).thenReturn("CCL_ID_PERSON");
        when(entity.getIcmIdEstrComision()).thenReturn("1");
        when(entity.getIcmIdEstrComisionBase()).thenReturn("1");
        when(entity.getIcmIdTpCalculo()).thenReturn("1");
        when(entity.getIcmIdTpComision()).thenReturn("1");
        when(entity.getStdOrHrPeriod()).thenReturn("STD_OR_HR_PERIOD");
        when(entity.getValor()).thenReturn(new BigDecimal(1));
        when(entity.getTarea()).thenReturn(tarea);
        when(entity.getActivo()).thenReturn(Boolean.TRUE);
        when(entity.getCclIdOrigen()).thenReturn("CCL_ID_ORIGEN");
        when(entity.getDesplazamiento()).thenReturn(Boolean.TRUE);
        when(entity.getDesplazamientoBase()).thenReturn(Boolean.TRUE);
        when(entity.getOrdinalEstructura()).thenReturn(1);
        when(entity.getTope()).thenReturn(1);
        when(entity.getDiaD()).thenReturn(Boolean.TRUE);
        when(entity.getDiaJ()).thenReturn(Boolean.TRUE);
        when(entity.getDiaL()).thenReturn(Boolean.TRUE);
        when(entity.getDiaM()).thenReturn(Boolean.TRUE);
        when(entity.getDiaS()).thenReturn(Boolean.TRUE);
        when(entity.getDiaV()).thenReturn(Boolean.TRUE);
        when(entity.getDiaX()).thenReturn(Boolean.TRUE);
        when(entity.getIcmIdTpEstructura()).thenReturn("1");
        when(entity.getIcmIdEstrComisionPadre()).thenReturn("1");

        tareaPersonaEstructuraRepositoryCustom.setParameters(pstmt, entity);
        
        verify(pstmt, times(1)).setObject(1, entity.getFechaFin());
        verify(pstmt, times(1)).setObject(2, entity.getFechaInicio());
        verify(pstmt, times(1)).setString(3, entity.getCclIdSeccionEfectiva());
        verify(pstmt, times(1)).setString(4, entity.getCclIdSeccionEstructura());
        verify(pstmt, times(1)).setString(5, entity.getStdIdHr());
        verify(pstmt, times(1)).setString(6, entity.getCclIdPerson());
        verify(pstmt, times(1)).setString(7, entity.getIcmIdEstrComision());
        verify(pstmt, times(1)).setString(8, entity.getIcmIdEstrComisionBase());
        verify(pstmt, times(1)).setString(9, entity.getIcmIdTpCalculo());
        verify(pstmt, times(1)).setString(10, entity.getIcmIdTpComision());
        verify(pstmt, times(1)).setString(11, entity.getStdOrHrPeriod());
        verify(pstmt, times(1)).setBigDecimal(12, entity.getValor());
        verify(pstmt, times(1)).setLong(13, tarea.getId());
        verify(pstmt, times(1)).setBoolean(14, entity.getActivo());
        verify(pstmt, times(1)).setString(15, entity.getCclIdOrigen());
        verify(pstmt, times(1)).setBoolean(16, entity.getDesplazamiento());
        verify(pstmt, times(1)).setBoolean(17, entity.getDesplazamientoBase());
        verify(pstmt, times(1)).setInt(18, entity.getOrdinalEstructura());
        verify(pstmt, times(1)).setInt(19, entity.getTope());
        verify(pstmt, times(1)).setBoolean(20, entity.getDiaD());
        verify(pstmt, times(1)).setBoolean(21, entity.getDiaJ());
        verify(pstmt, times(1)).setBoolean(22, entity.getDiaL());
        verify(pstmt, times(1)).setBoolean(23, entity.getDiaM());
        verify(pstmt, times(1)).setBoolean(24, entity.getDiaS());
        verify(pstmt, times(1)).setBoolean(25, entity.getDiaV());
        verify(pstmt, times(1)).setBoolean(26, entity.getDiaX());
        verify(pstmt, times(1)).setString(27, entity.getIcmIdTpEstructura());
        verify(pstmt, times(1)).setString(28, entity.getIcmIdEstrComisionPadre());
        verify(pstmt, times(1)).setObject(29, pk.getFechaInicioPeriodo());
    }
    
    @Test
    public void saveTest() {
        List<TareaPersonaEstructura> items = Arrays.asList(mock(TareaPersonaEstructura.class));
        tareaPersonaEstructuraRepositoryCustom.save(items);
        verify(jdbcTemplate).batchUpdate(sqlCaptor.capture(), any(BatchPreparedStatementSetter.class));
        assertEquals(SQL_SAVE, sqlCaptor.getValue());
    }
}
