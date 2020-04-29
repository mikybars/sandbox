package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ACTIVO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_CONCEPTO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TAREA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_INCLUSION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_PORCENTAJE_CERO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoComisionEnum;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionHistorico;

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
    private static final String SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA_AND_ID_TIPO_CALCULO = "SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA_AND_ID_TIPO_CALCULO";
    private static final String SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA_AND_ORIGEN_IN_AMBITO_LOCALIZACION = "SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA_AND_ORIGEN_IN_AMBITO_LOCALIZACION";
    private static final String SQL_FIND_ID_LOCALIZACION_LOCAL_BY_ID_TAREA_AND_ORIGEN_IN_AMBITO_LOCALIZACION = "SQL_FIND_ID_LOCALIZACION_LOCAL_BY_ID_TAREA_AND_ORIGEN_IN_AMBITO_LOCALIZACION";
    private static final String SQL_FIND_ID_LOCALIZACION_PRESUPUESTOS_BY_ID_TAREA = "SQL_FIND_ID_LOCALIZACION_PRESUPUESTOS_BY_ID_TAREA";
    private static final String SQL_FIND_ID_LOCALIZACION_GRUPO_FECHAS_BY_ID_TAREA = "SQL_FIND_ID_LOCALIZACION_GRUPO_FECHAS_BY_ID_TAREA";

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
            "sqlFindIdLocalizacionByIdTareaAndCclIdPersonInAmbito", SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA_AND_ID_TIPO_CALCULO, true);
        FieldUtils.writeField(tareaLocalizacionHistoricoRepositoryCustom,
                "sqlFindIdLocalizacionDtoByIdTareaAndIdOrigenInAmbitoLocalizacion", SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA_AND_ORIGEN_IN_AMBITO_LOCALIZACION, true);
        FieldUtils.writeField(tareaLocalizacionHistoricoRepositoryCustom,
                "sqlFindIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbitoLocalizacion", SQL_FIND_ID_LOCALIZACION_LOCAL_BY_ID_TAREA_AND_ORIGEN_IN_AMBITO_LOCALIZACION, true);
        FieldUtils.writeField(tareaLocalizacionHistoricoRepositoryCustom,
                "sqlFindIdLocalizacionPresupuestosByIdTarea", SQL_FIND_ID_LOCALIZACION_PRESUPUESTOS_BY_ID_TAREA, true);
        FieldUtils.writeField(tareaLocalizacionHistoricoRepositoryCustom,
                "sqlFindIdLocalizacionGrupoFechasByIdTarea", SQL_FIND_ID_LOCALIZACION_GRUPO_FECHAS_BY_ID_TAREA, true);
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

    @Test
    public void findIdLocalizacionLocalDtoByIdTareaAndCclIdsPersonaInAmbitoLocalizacion() {
        Long idTarea = 23L;
        String idTipoCalculo1 = "ID TIPO CALCULO";
        String idTipoCalculo2 = "ID TIPO CALCULO 2";
        String idOrigen = "ID ORIGEN";

        tareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoCalculoInAmbitoLocalizacion(idTarea, idOrigen,
            Arrays.asList(idTipoCalculo1, idTipoCalculo2));
        verify(namedParameterJdbcTemplate, times(1))
            .query(sql.capture(), params.capture(), any(RowMapper.class));
        assertEquals(SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA_AND_ID_TIPO_CALCULO, sql.getValue());
        // parametros de la consulta: idTarea, cclIdOrigen, idTipoCalculo, activo
        assertEquals(4, params.getValue().getValues().size());
        // idTarea
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(idTarea, params.getValue().getValue(SQL_PARAM_ID_TAREA));
        // cclIdOrigen
        assertTrue(params.getValue().hasValue(SQL_PARAM_CCL_ID_ORIGEN));
        assertEquals(idOrigen, params.getValue().getValue(SQL_PARAM_CCL_ID_ORIGEN));
        // idTipoCalculo
        assertTrue(params.getValue().hasValue(SQL_PARAM_IDS_TIPOS_CALCULO));
        assertEquals(Arrays.asList(idTipoCalculo1, idTipoCalculo2), params.getValue().getValue(SQL_PARAM_IDS_TIPOS_CALCULO));
        // cclIdOrigen
        assertTrue(params.getValue().hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue().getValue(SQL_PARAM_ACTIVO));
    }
    
    @Test
    public void findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbitoLocalizacionTest() {
        Long idTarea = 23L;
        String idOrigen = "ID ORIGEN";
        tareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbitoLocalizacion(idTarea, idOrigen);
        verify(namedParameterJdbcTemplate, times(1)).query(sql.capture(), params.capture(), any(RowMapper.class));
        assertEquals(SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA_AND_ORIGEN_IN_AMBITO_LOCALIZACION, sql.getValue());
        // parametros de la consulta: idTarea, cclIdOrigen, idTipoCalculo, activo
        assertEquals(2, params.getValue().getValues().size());
        // idTarea
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(idTarea, params.getValue().getValue(SQL_PARAM_ID_TAREA));
        // cclIdOrigen
        assertTrue(params.getValue().hasValue(SQL_PARAM_CCL_ID_ORIGEN));
        assertEquals(idOrigen, params.getValue().getValue(SQL_PARAM_CCL_ID_ORIGEN));
    }
    
    @Test
    public void findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbitoLocalizacionTest() {
        Long idTarea = 23L;
        String idOrigen = "ID ORIGEN";
        tareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbitoLocalizacion(idTarea, idOrigen);
        verify(namedParameterJdbcTemplate, times(1)).query(sql.capture(), params.capture(), any(RowMapper.class));
        assertEquals(SQL_FIND_ID_LOCALIZACION_LOCAL_BY_ID_TAREA_AND_ORIGEN_IN_AMBITO_LOCALIZACION, sql.getValue());
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
    public void findIdLocalizacionLocalDtoPresupuestosByIdTareaTest() {
        Long idTarea = 23L;
        Integer activo = SQL_VALUE_BOOLEAN_TRUE;
        tareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionLocalDtoPresupuestosByIdTarea(idTarea);
        verify(namedParameterJdbcTemplate, times(1)).query(sql.capture(), params.capture(), any(RowMapper.class));
        assertEquals(SQL_FIND_ID_LOCALIZACION_PRESUPUESTOS_BY_ID_TAREA, sql.getValue());
        // parametros de la consulta: idTarea
        assertEquals(3, params.getValue().getValues().size());
        // idTarea
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(idTarea, params.getValue().getValue(SQL_PARAM_ID_TAREA));
        // activo
        assertTrue(params.getValue().hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue().getValue(SQL_PARAM_ACTIVO));
        // tiposComision
        assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION));
        assertEquals(Arrays.asList(TipoComisionEnum.CHALLENGE_PRINCIPAL.getId(), TipoComisionEnum.CHALLENGE_SECUNDARIO.getId()), params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION));
    }
    
    @Test
    public void findTiendasGrupoFechasByIdTareaTest() {
        Long idTarea = 23L;
        Integer activo = SQL_VALUE_BOOLEAN_TRUE;
        tareaLocalizacionHistoricoRepositoryCustom.findTiendasGrupoFechasByIdTarea(idTarea);
        verify(namedParameterJdbcTemplate, times(1)).query(sql.capture(), params.capture(), any(RowMapper.class));
        assertEquals(SQL_FIND_ID_LOCALIZACION_GRUPO_FECHAS_BY_ID_TAREA, sql.getValue());
        // parametros de la consulta: idTarea
        assertEquals(2, params.getValue().getValues().size());
        // idTarea
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(idTarea, params.getValue().getValue(SQL_PARAM_ID_TAREA));
        // activo
        assertTrue(params.getValue().hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue().getValue(SQL_PARAM_ACTIVO));
    }
    
}
