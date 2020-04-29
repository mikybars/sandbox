package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoPresupuesto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresupuesto;
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
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionPresupuestoRepositoryCustomImplTest {

    private final static String SQL_SAVE = "SQL SAVE";

    private final static String SQL_UPDATE_ACTIVO_BANDA_EXCEPCION = "SQL UPDATE ACTIVO BANDA EXCEPCION";

    private final static String SQL_UPDATE_ACTIVO_BANDAS_SIN_EXCEPCION = "SQL UPDATE ACTIVO BANDAS SIN EXCEPCION";

    private final static String SQL_FIND_PRESUPUESTOS = "SQL FIND PRESUPUESTOS";

    private final static String SQL_FIND_RANGO_FECHAS_PRESUPUESTOS = "SQL FIND RANGO FECHA PRESUPUESTOS";

    @Mock
    private JdbcTemplate template;

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @InjectMocks
    private TareaLocalizacionPresupuestoRepositoryCustomImpl tareaPresupuestoRepositoryCustom;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaPresupuestoRepositoryCustom, "sqlSave", SQL_SAVE, true);
        FieldUtils.writeField(tareaPresupuestoRepositoryCustom, "sqlUpdateActivoBandaExcepcion", SQL_UPDATE_ACTIVO_BANDA_EXCEPCION, true);
        FieldUtils.writeField(tareaPresupuestoRepositoryCustom, "sqlUpdateActivoBandasSinExcepcion", SQL_UPDATE_ACTIVO_BANDAS_SIN_EXCEPCION, true);
        FieldUtils.writeField(tareaPresupuestoRepositoryCustom, "sqlFindPresupuestos", SQL_FIND_PRESUPUESTOS, true);
        FieldUtils.writeField(tareaPresupuestoRepositoryCustom, "sqlFindPeriodoPresupuestoYTrabajo", SQL_FIND_RANGO_FECHAS_PRESUPUESTOS, true);
        FieldUtils.writeField(tareaPresupuestoRepositoryCustom, "batchSize", 100, true);
    }

    @Test
    public void saveTest() {

        List<TareaLocalizacionPresupuesto> items = Collections.singletonList(mock(TareaLocalizacionPresupuesto.class));

        tareaPresupuestoRepositoryCustom.save(items);
        verify(template).batchUpdate(sqlCaptor.capture(), any(BatchPreparedStatementSetter.class));

        assertEquals(SQL_SAVE, sqlCaptor.getValue());

    }

    @Test
    public void setParametersTest() throws SQLException {

        Tarea tarea = mock(Tarea.class);
        when(tarea.getId()).thenReturn(809L);
        TipoPresupuesto tipoPresupuesto = mock(TipoPresupuesto.class);
        tipoPresupuesto.setId(1);
        TareaLocalizacionPresupuesto presupuesto = mock(TareaLocalizacionPresupuesto.class);
        when(presupuesto.getTarea()).thenReturn(tarea);
        when(presupuesto.getCclIdOrigen()).thenReturn("ORIGEN");
        when(presupuesto.getStdIdLegEnt()).thenReturn("STD_LEG_ENT");
        when(presupuesto.getStdIdWorkLocat()).thenReturn("STD_ID_WORK_LOCAT");
        when(presupuesto.getCclIdCodOrigen()).thenReturn("CCL_ID_COD_ORIGEN");
        when(presupuesto.getCclIdSeccion()).thenReturn("SECCION");
        when(presupuesto.getFechaInicio()).thenReturn(TimeUtils.nowDate());
        when(presupuesto.getFechaFin()).thenReturn(TimeUtils.nowDate());
        when(presupuesto.getImporteConImpuestos()).thenReturn(1234.1);
        when(presupuesto.getImporteSinImpuestos()).thenReturn(1222.1);
        when(presupuesto.getBanda()).thenReturn(11);
        when(presupuesto.getOrdinal()).thenReturn(43);
        when(presupuesto.getExcepcion()).thenReturn(Boolean.FALSE);
        when(presupuesto.getTipoPresupuesto()).thenReturn(tipoPresupuesto);
        when(presupuesto.getActivo()).thenReturn(Boolean.FALSE);
        PreparedStatement pstmt = mock(PreparedStatement.class);

        tareaPresupuestoRepositoryCustom.setParameters(pstmt, presupuesto);
        verify(pstmt, times(1)).setLong(1, tarea.getId());
        verify(pstmt, times(1)).setString(2, presupuesto.getCclIdOrigen());
        verify(pstmt, times(1)).setString(3, presupuesto.getStdIdLegEnt());
        verify(pstmt, times(1)).setString(4, presupuesto.getCclIdCodOrigen());
        verify(pstmt, times(1)).setString(5, presupuesto.getStdIdWorkLocat());
        verify(pstmt, times(1)).setString(6, presupuesto.getCclIdSeccion());
        verify(pstmt, times(1)).setObject(7, presupuesto.getFechaInicio());
        verify(pstmt, times(1)).setObject(8, presupuesto.getFechaFin());
        verify(pstmt, times(1)).setDouble(9, presupuesto.getImporteSinImpuestos());
        verify(pstmt, times(1)).setDouble(10, presupuesto.getImporteConImpuestos());
        verify(pstmt, times(1)).setInt(11, presupuesto.getBanda());
        verify(pstmt, times(1)).setInt(12, presupuesto.getOrdinal());
        verify(pstmt, times(1)).setBoolean(13, presupuesto.getExcepcion());
        verify(pstmt, times(1)).setInt(14, tipoPresupuesto.getId());
        verify(pstmt, times(1)).setBoolean(15, presupuesto.getExcepcion());

    }

    @Test
    public void findPresupuestosTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(809L);

        tareaPresupuestoRepositoryCustom.findPresupuestos(tarea);
        verify(namedParameterJdbcTemplate, times(1)).query(sqlCaptor.capture(), paramsCaptor.capture(), any(RowMapper.class));

        assertEquals(SQL_FIND_PRESUPUESTOS, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();
        assertEquals(1, params.getValues().size());
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

    }

    @Test
    public void findPeriodoPresupuestoYTrabajo() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(8989L);

        tareaPresupuestoRepositoryCustom.findPeriodoPresupuestoYTrabajo(tarea.getId());
        verify(namedParameterJdbcTemplate, times(1)).queryForObject(sqlCaptor.capture(), paramsCaptor.capture(), any(RowMapper.class));

        assertEquals(SQL_FIND_RANGO_FECHAS_PRESUPUESTOS, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();
        assertEquals(1, params.getValues().size());
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

    }

    @Test
    public void updateActivoBandaExcepcionTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(48L);

        tareaPresupuestoRepositoryCustom.updateActivoBandaExcepcion(tarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_UPDATE_ACTIVO_BANDA_EXCEPCION, sqlCaptor.getValue());
        // Parametros de la consulta: idTarea, icmCkExcepcion, nuevoActivo
        MapSqlParameterSource params = paramsCaptor.getValue();
        assertEquals(3, params.getValues().size());
        // idTarea
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        // icmCkExcepcion
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ICM_CK_EXCEPCION));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_ICM_CK_EXCEPCION));
        // nuevoActivo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
    }

    @Test
    public void udpateActivoBandasSinExcepcion() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(2019426L);

        tareaPresupuestoRepositoryCustom.updateActivoBandasSinExcepcion(tarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_UPDATE_ACTIVO_BANDAS_SIN_EXCEPCION, sqlCaptor.getValue());

        // Parámetros de la consulta: idTipoGrupoDato, idTarea, icmCkExcepcion, activo, nuevoActivo
        MapSqlParameterSource params = paramsCaptor.getValue();
        assertEquals(5, params.getValues().size());
        // idTipoGrupoDato
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO));
        assertEquals(TipoGrupoDatoEnum.VENTA_RANGO_REAL_Y_CONGELADA.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO));
        // idTarea
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        // icmCkException
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ICM_CK_EXCEPCION));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_ICM_CK_EXCEPCION));
        // activo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        // nuevoActivo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));

    }
}
