package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionHistorico;
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
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.*;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionHistoricoRepositoryCustomImplTest {

    private static final String SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA_ID_ORIGEN_IN_AMBITO =
        "SQL FIND ID LOCALIZACION BY ID TAREA ID ORIGEN IN AMBITO TEST";
    private static final String SQL_SAVE = "SAVE TEST";
    private static final String SQL_FIND_ID_LOCALIZACION_LOCAL_BY_ID_TAREA_ID_ORIGEN_IN_AMBITO =
        "SQL FIND ID LOCALIZACION LOCAL BY ID TAREA ID ORIGEN IN AMBITO TEST";
    private static final String SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA_ID_ORIGEN_TIPO_DATO_IN_AMBITO =
        "SQL FIND ID LOCALIZACION BY ID TAREA ID ORIGEN TIPO DATO IN AMBITO TEST";
    private static final String SQL_FIND_ID_LOCALIZACION_LOCAL_ID_TAREA_ID_ORIGEN_TIPO_DATO_IN_AMBITO =
        "SQL FIND ID LOCALIZACION LOCAL BY ID TAREA ID ORIGEN TIPO DATO IN AMBITO TEST";
    private static final String SQL_CADENAS_FILTRO_TIPO_DATO = "SQL CADENAS FILTRO TIPO DATO TEST";
    private static final String SQL_CADENAS = "CADENAS TEST";

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private TareaLocalizacionHistoricoRepositoryCustomImpl tareaLocalizacionHistoricoRepositoryCustom;

    @Captor
    private ArgumentCaptor<String> sql;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> params;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaLocalizacionHistoricoRepositoryCustom,
            "sqlSave", SQL_SAVE, true);
        FieldUtils.writeField(tareaLocalizacionHistoricoRepositoryCustom,
            "sqlFindIdLocalizacionDtoByIdTareaAndIdOrigenInAmbito",
            SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA_ID_ORIGEN_IN_AMBITO, true);
        FieldUtils.writeField(tareaLocalizacionHistoricoRepositoryCustom,
            "sqlFindIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbito",
            SQL_FIND_ID_LOCALIZACION_LOCAL_BY_ID_TAREA_ID_ORIGEN_IN_AMBITO, true);
        FieldUtils.writeField(tareaLocalizacionHistoricoRepositoryCustom,
            "sqlFindIdLocalizacionDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito",
            SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA_ID_ORIGEN_TIPO_DATO_IN_AMBITO, true);
        FieldUtils.writeField(tareaLocalizacionHistoricoRepositoryCustom,
            "sqlFindIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito",
            SQL_FIND_ID_LOCALIZACION_LOCAL_ID_TAREA_ID_ORIGEN_TIPO_DATO_IN_AMBITO, true);
        FieldUtils.writeField(tareaLocalizacionHistoricoRepositoryCustom,
            "sqlCadenasFiltroTipoDato", SQL_CADENAS_FILTRO_TIPO_DATO, true);
        FieldUtils.writeField(tareaLocalizacionHistoricoRepositoryCustom,
            "sqlCadenas", SQL_CADENAS, true);
        FieldUtils.writeField(tareaLocalizacionHistoricoRepositoryCustom,
            "batchSize", 100, true);
    }

    @Test
    public void setParametersTest() throws SQLException {
        PreparedStatement pstmt = mock(PreparedStatement.class);
        Tarea tarea = mock(Tarea.class);
        when(tarea.getId()).thenReturn(900L);
        TareaLocalizacionHistorico entity = mock(TareaLocalizacionHistorico.class);
        when(entity.getTarea()).thenReturn(tarea);
        when(entity.getStdIdWorkLocat()).thenReturn("T90101");
        when(entity.getCclIdCodOrigen()).thenReturn("90101");
        when(entity.getCclIdCadena()).thenReturn("12");
        when(entity.getFechaInicio()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 1, 1)));
        when(entity.getFechaFin()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 12, 1)));
        when(entity.getCclIdOrigen()).thenReturn("38");
        when(entity.getStdIdCountry()).thenReturn("21");
        when(entity.getStdIdLegEnt()).thenReturn("E95");

        tareaLocalizacionHistoricoRepositoryCustom.setParameters(pstmt, entity);

        verify(pstmt, times(1)).setObject(1, entity.getFechaFin());
        verify(pstmt, times(1)).setObject(2, entity.getFechaInicio());
        verify(pstmt, times(1)).setString(3, entity.getCclIdCadena());
        verify(pstmt, times(1)).setString(4, entity.getStdIdLegEnt());
        verify(pstmt, times(1)).setString(5, entity.getStdIdCountry());
        verify(pstmt, times(1)).setString(6, entity.getCclIdOrigen());
        verify(pstmt, times(1)).setString(7, entity.getCclIdCodOrigen());
        verify(pstmt, times(1)).setString(8, entity.getStdIdWorkLocat());
        verify(pstmt, times(1)).setLong(9, tarea.getId());
    }

    @Test
    public void saveTest() {
        List<TareaLocalizacionHistorico> items = Arrays.asList(mock(TareaLocalizacionHistorico.class));
        tareaLocalizacionHistoricoRepositoryCustom.save(items);
        verify(jdbcTemplate, times(1)).batchUpdate(sql.capture(), any(BatchPreparedStatementSetter.class));
        assertEquals(SQL_SAVE, sql.getValue());
    }

    @Test
    public void findIdLocalizacionDtoByIdTareaAndCclIdOrigenAndTipoDatoInAmbitoTest() {

        Long idTarea = 89L;
        String idOrigen = "O38";
        List<Integer> tiposDato = Arrays.asList(12, 39, 933);

        tareaLocalizacionHistoricoRepositoryCustom
            .findIdLocalizacionDtoByIdTareaAndCclIdOrigenAndTipoDatoInAmbito(idTarea, idOrigen, tiposDato);
        verify(namedParameterJdbcTemplate, times(1))
            .query(sql.capture(), params.capture(), any(RowMapper.class));
        assertEquals(SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA_ID_ORIGEN_TIPO_DATO_IN_AMBITO, sql.getValue());
        // parametros de la consulta: idTarea, cclIdOrigen, tiposDato
        assertEquals(3, params.getValue().getValues().size());
        // idTarea
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(idTarea, params.getValue().getValue(SQL_PARAM_ID_TAREA));
        // cclIdOrigen
        assertTrue(params.getValue().hasValue(SQL_PARAM_CCL_ID_ORIGEN));
        assertEquals(idOrigen, params.getValue().getValue(SQL_PARAM_CCL_ID_ORIGEN));
        // tiposDato
        assertTrue(params.getValue().hasValue(SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(tiposDato, params.getValue().getValue(SQL_PARAM_IDS_TIPOS_DATO));

    }

    @Test
    public void findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbitoTest() {

        Long idTarea = 89L;
        String idOrigen = "O38";

        tareaLocalizacionHistoricoRepositoryCustom
            .findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(idTarea, idOrigen);
        verify(namedParameterJdbcTemplate, times(1))
            .query(sql.capture(), params.capture(), any(RowMapper.class));
        assertEquals(SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA_ID_ORIGEN_IN_AMBITO, sql.getValue());
        // parametros de la consulta: idTarea, cclIdOrigen
        assertEquals(2, params.getValue().getValues().size());
        // idTarea
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(idTarea, params.getValue().getValue(SQL_PARAM_ID_TAREA));
        // cclIdOrigen
        assertTrue(params.getValue().hasValue(SQL_PARAM_CCL_ID_ORIGEN));
        assertEquals(idOrigen, params.getValue().getValue(SQL_PARAM_CCL_ID_ORIGEN));

    }

    @Test
    public void findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbitoTest() {

        Long idTarea = 89L;
        String idOrigen = "O38";

        tareaLocalizacionHistoricoRepositoryCustom
            .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbito(idTarea, idOrigen);
        verify(namedParameterJdbcTemplate, times(1))
            .query(sql.capture(), params.capture(), any(RowMapper.class));
        assertEquals(SQL_FIND_ID_LOCALIZACION_LOCAL_BY_ID_TAREA_ID_ORIGEN_IN_AMBITO, sql.getValue());
        // parametros de la consulta: idTarea, cclIdOrigen
        assertEquals(2, params.getValue().getValues().size());
        // idTarea
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(idTarea, params.getValue().getValue(SQL_PARAM_ID_TAREA));
        // cclIdOrigen
        assertTrue(params.getValue().hasValue(SQL_PARAM_CCL_ID_ORIGEN));
        assertEquals(idOrigen, params.getValue().getValue(SQL_PARAM_CCL_ID_ORIGEN));

    }

    @Test
    public void findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoDatoInAmbitoTest() {

        Long idTarea = 89L;
        String idOrigen = "O38";
        List<Integer> tiposDato = Arrays.asList(12, 39, 933);

        tareaLocalizacionHistoricoRepositoryCustom
            .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoDatoInAmbito(idTarea, idOrigen, tiposDato);
        verify(namedParameterJdbcTemplate, times(1))
            .query(sql.capture(), params.capture(), any(RowMapper.class));
        assertEquals(SQL_FIND_ID_LOCALIZACION_LOCAL_ID_TAREA_ID_ORIGEN_TIPO_DATO_IN_AMBITO, sql.getValue());
        // parametros de la consulta: idTarea, cclIdOrigen, tiposDato
        assertEquals(3, params.getValue().getValues().size());
        // idTarea
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(idTarea, params.getValue().getValue(SQL_PARAM_ID_TAREA));
        // cclIdOrigen
        assertTrue(params.getValue().hasValue(SQL_PARAM_CCL_ID_ORIGEN));
        assertEquals(idOrigen, params.getValue().getValue(SQL_PARAM_CCL_ID_ORIGEN));
        // tiposDato
        assertTrue(params.getValue().hasValue(SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(tiposDato, params.getValue().getValue(SQL_PARAM_IDS_TIPOS_DATO));

    }

    @Test
    public void getCadenasByTareaAndOrigenVentaConceptoTest() {

        Long idTarea = 89L;
        String idOrigen = "O38";
        Long idVentaConcepto = 222L;

        tareaLocalizacionHistoricoRepositoryCustom
            .getCadenasByTareaAndOrigen(idTarea, idOrigen, idVentaConcepto);
        verify(namedParameterJdbcTemplate, times(1))
            .query(sql.capture(), params.capture(), any(RowMapper.class));
        assertEquals(SQL_CADENAS_FILTRO_TIPO_DATO, sql.getValue());
        // parametros de la consulta: idTarea, cclIdOrigen, porcentajeInclusion, idConcepto
        assertEquals(4, params.getValue().getValues().size());
        // idTarea
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(idTarea, params.getValue().getValue(SQL_PARAM_ID_TAREA));
        // cclIdOrigen
        assertTrue(params.getValue().hasValue(SQL_PARAM_CCL_ID_ORIGEN));
        assertEquals(idOrigen, params.getValue().getValue(SQL_PARAM_CCL_ID_ORIGEN));
        // porcentajeInclusion
        assertTrue(params.getValue().hasValue(SQL_PARAM_PORCENTAJE_INCLUSION));
        assertEquals(SQL_VALUE_PORCENTAJE_CERO, params.getValue().getValue(SQL_PARAM_PORCENTAJE_INCLUSION));
        // idConcepto
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_CONCEPTO));
        assertEquals(idVentaConcepto, params.getValue().getValue(SQL_PARAM_ID_CONCEPTO));

    }

    @Test
    public void getCadenasByTareaAndOrigenTest() {

        Long idTarea = 89L;
        String idOrigen = "O38";

        tareaLocalizacionHistoricoRepositoryCustom
            .getCadenasByTareaAndOrigen(idTarea, idOrigen);
        verify(namedParameterJdbcTemplate, times(1))
            .query(sql.capture(), params.capture(), any(RowMapper.class));
        assertEquals(SQL_CADENAS, sql.getValue());
        // parametros de la consulta: idTarea, cclIdOrigen, tiposDato
        assertEquals(2, params.getValue().getValues().size());
        // idTarea
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(idTarea, params.getValue().getValue(SQL_PARAM_ID_TAREA));
        // cclIdOrigen
        assertTrue(params.getValue().hasValue(SQL_PARAM_CCL_ID_ORIGEN));
        assertEquals(idOrigen, params.getValue().getValue(SQL_PARAM_CCL_ID_ORIGEN));

    }
}
