package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collections;
import java.util.Date;
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
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoPresupuesto;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoVentaConceptoChallenge;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresupuestoVenta;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionPresupuestoVentaRepositoryCustomImplTest {

    private final static String SQL_SAVE = "SQL SAVE";
    private final static String SQL_UPDATE_ACTIVO_EXCEPCIONADA = "SQL_UPDATE_ACTIVO_EXCEPCIONADA";
    private final static String SQL_UPDATE_ACTIVO_CONGELADA = "SQL_UPDATE_ACTIVO_CONGELADA";
    private final static String SQL_TOTALIZAR = "SQL_TOTALIZAR";

    @Mock
    private JdbcTemplate template;

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @InjectMocks
    private TareaLocalizacionPresupuestoVentaRepositoryCustomImpl tareaLocalizacionPresupuestoVentaRepositoryCustom;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;
    
    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaLocalizacionPresupuestoVentaRepositoryCustom, "sqlSave", SQL_SAVE, true);
        FieldUtils.writeField(tareaLocalizacionPresupuestoVentaRepositoryCustom, "sqlUpdateActivoExcepcionada", SQL_UPDATE_ACTIVO_EXCEPCIONADA, true);
        FieldUtils.writeField(tareaLocalizacionPresupuestoVentaRepositoryCustom, "sqlUpdateActivoCongelada", SQL_UPDATE_ACTIVO_CONGELADA, true);
        FieldUtils.writeField(tareaLocalizacionPresupuestoVentaRepositoryCustom, "sqlTotalizar", SQL_TOTALIZAR, true);
        FieldUtils.writeField(tareaLocalizacionPresupuestoVentaRepositoryCustom, "batchSize", 100, true);
    }
    
    @Test
    public void save() {
        List<TareaLocalizacionPresupuestoVenta> items = Collections.singletonList(mock(TareaLocalizacionPresupuestoVenta.class));
        tareaLocalizacionPresupuestoVentaRepositoryCustom.save(items);
        verify(template).batchUpdate(sqlCaptor.capture(), any(BatchPreparedStatementSetter.class));
        assertEquals(SQL_SAVE, sqlCaptor.getValue());
    }
    
    @Test
    public void setParametersTest() throws SQLException {
            
        Tarea tarea = mock(Tarea.class);
        when(tarea.getId()).thenReturn(809L);
        TipoPresupuesto tipoPresupuesto = mock(TipoPresupuesto.class);
        tipoPresupuesto.setId(1);
        TipoDato tipoDato = mock(TipoDato.class);
        tipoDato.setId(1);
        TipoVentaConceptoChallenge tipoVentaConceptoChallenge = mock(TipoVentaConceptoChallenge.class); 
        tipoVentaConceptoChallenge.setId(1L);
        TareaLocalizacionPresupuestoVenta presupuesto = mock(TareaLocalizacionPresupuestoVenta.class);
        when(presupuesto.getTarea()).thenReturn(tarea);
        when(presupuesto.getCclIdCadena()).thenReturn("CCL_ID_CADENA");
        when(presupuesto.getCclIdCodOrigen()).thenReturn("CCL_ID_COD_ORIGEN");
        when(presupuesto.getCclIdSeccion()).thenReturn("CCL_ID_SECCION");
        when(presupuesto.getOrdinal()).thenReturn(1);
        when(presupuesto.getImporteConImpuestos()).thenReturn(1234.1);
        when(presupuesto.getImporteSinImpuestos()).thenReturn(1222.1);
        when(presupuesto.getTipoPresupuesto()).thenReturn(tipoPresupuesto);
        when(presupuesto.getTipoVentaConceptoChallenge()).thenReturn(tipoVentaConceptoChallenge);
        when(presupuesto.getCclIdOrigen()).thenReturn("CCL_ID_ORIGEN");
        when(presupuesto.getActivo()).thenReturn(Boolean.FALSE);
        when(presupuesto.getTipoDato()).thenReturn(tipoDato);
        when(presupuesto.getFechaFin()).thenReturn(new Date());
        when(presupuesto.getFechaInicio()).thenReturn(new Date());
        PreparedStatement pstmt = mock(PreparedStatement.class);

        tareaLocalizacionPresupuestoVentaRepositoryCustom.setParameters(pstmt, presupuesto);
        verify(pstmt, times(1)).setLong(1, tarea.getId());
        verify(pstmt, times(1)).setString(2, presupuesto.getCclIdCadena());
        verify(pstmt, times(1)).setString(3, presupuesto.getCclIdCodOrigen());
        verify(pstmt, times(1)).setString(4, presupuesto.getCclIdSeccion());
        verify(pstmt, times(1)).setInt(5, presupuesto.getOrdinal());
        verify(pstmt, times(1)).setDouble(6, presupuesto.getImporteSinImpuestos());
        verify(pstmt, times(1)).setDouble(7, presupuesto.getImporteConImpuestos());
        verify(pstmt, times(1)).setLong(8, presupuesto.getTipoPresupuesto().getId());
        verify(pstmt, times(1)).setLong(9, presupuesto.getTipoVentaConceptoChallenge().getId());
        verify(pstmt, times(1)).setString(10, presupuesto.getCclIdOrigen());
        verify(pstmt, times(1)).setBoolean(11, presupuesto.getActivo());
        verify(pstmt, times(1)).setInt(12, presupuesto.getTipoDato().getId());
        verify(pstmt, times(1)).setObject(13, presupuesto.getFechaFin());
        verify(pstmt, times(1)).setObject(14, presupuesto.getFechaInicio());
    }
    
    @Test
    public void setParametersTestNullFields() throws SQLException {
            
        Tarea tarea = mock(Tarea.class);
        when(tarea.getId()).thenReturn(809L);
        TipoPresupuesto tipoPresupuesto = mock(TipoPresupuesto.class);
        tipoPresupuesto.setId(1);
        TipoDato tipoDato = mock(TipoDato.class);
        tipoDato.setId(1);
        TipoVentaConceptoChallenge tipoVentaConceptoChallenge = mock(TipoVentaConceptoChallenge.class); 
        tipoVentaConceptoChallenge.setId(1L);
        TareaLocalizacionPresupuestoVenta presupuesto = mock(TareaLocalizacionPresupuestoVenta.class);
        when(presupuesto.getTarea()).thenReturn(tarea);
        when(presupuesto.getCclIdCadena()).thenReturn("CCL_ID_CADENA");
        when(presupuesto.getCclIdCodOrigen()).thenReturn("CCL_ID_COD_ORIGEN");
        when(presupuesto.getCclIdSeccion()).thenReturn("CCL_ID_SECCION");
        when(presupuesto.getOrdinal()).thenReturn(null);
        when(presupuesto.getImporteConImpuestos()).thenReturn(1234.1);
        when(presupuesto.getImporteSinImpuestos()).thenReturn(1222.1);
        when(presupuesto.getTipoPresupuesto()).thenReturn(tipoPresupuesto);
        when(presupuesto.getTipoVentaConceptoChallenge()).thenReturn(tipoVentaConceptoChallenge);
        when(presupuesto.getCclIdOrigen()).thenReturn("CCL_ID_ORIGEN");
        when(presupuesto.getActivo()).thenReturn(Boolean.FALSE);
        when(presupuesto.getTipoDato()).thenReturn(tipoDato);
        when(presupuesto.getFechaFin()).thenReturn(new Date());
        when(presupuesto.getFechaInicio()).thenReturn(new Date());
        PreparedStatement pstmt = mock(PreparedStatement.class);

        tareaLocalizacionPresupuestoVentaRepositoryCustom.setParameters(pstmt, presupuesto);
        verify(pstmt, times(1)).setLong(1, tarea.getId());
        verify(pstmt, times(1)).setString(2, presupuesto.getCclIdCadena());
        verify(pstmt, times(1)).setString(3, presupuesto.getCclIdCodOrigen());
        verify(pstmt, times(1)).setString(4, presupuesto.getCclIdSeccion());
        verify(pstmt, times(1)).setNull(5, Types.INTEGER);
        verify(pstmt, times(1)).setDouble(6, presupuesto.getImporteSinImpuestos());
        verify(pstmt, times(1)).setDouble(7, presupuesto.getImporteConImpuestos());
        verify(pstmt, times(1)).setLong(8, presupuesto.getTipoPresupuesto().getId());
        verify(pstmt, times(1)).setLong(9, presupuesto.getTipoVentaConceptoChallenge().getId());
        verify(pstmt, times(1)).setString(10, presupuesto.getCclIdOrigen());
        verify(pstmt, times(1)).setBoolean(11, presupuesto.getActivo());
        verify(pstmt, times(1)).setInt(12, presupuesto.getTipoDato().getId());
        verify(pstmt, times(1)).setObject(13, presupuesto.getFechaFin());
        verify(pstmt, times(1)).setObject(14, presupuesto.getFechaInicio());
    }

    @Test
    public void updateActivoExcepcionada() {
        RunTareaDto runTarea = mock(RunTareaDto.class);
        TareaDto tarea = mock(TareaDto.class);
        tarea.setId(1L);
        when(runTarea.getTarea()).thenReturn(tarea);

        tareaLocalizacionPresupuestoVentaRepositoryCustom.updateActivoExcepcionada(runTarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_UPDATE_ACTIVO_EXCEPCIONADA, sqlCaptor.getValue());
        // Parametros de la consulta: idTarea, activo, inactivo
        MapSqlParameterSource params = paramsCaptor.getValue();
        assertEquals(3, params.getValues().size());
        // idTarea
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        // activo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        // inactivo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE, params.getValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
    }
    
    @Test
    public void updateActivoCongelada() {
        RunTareaDto runTarea = mock(RunTareaDto.class);
        TareaDto tarea = mock(TareaDto.class);
        tarea.setId(1L);
        when(runTarea.getTarea()).thenReturn(tarea);

        tareaLocalizacionPresupuestoVentaRepositoryCustom.updateActivoCongelada(runTarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_UPDATE_ACTIVO_CONGELADA, sqlCaptor.getValue());
        // Parametros de la consulta: idTarea, activo, inactivo
        MapSqlParameterSource params = paramsCaptor.getValue();
        assertEquals(5, params.getValues().size());
        // idTarea
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        // activo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        // inactivo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE, params.getValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
        // id tipo dato grupo dato venta congelada
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO_VENTA_CONGELADA));
        assertEquals(TipoGrupoDatoEnum.VENTA_RANGO_CONGELADA.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO_VENTA_CONGELADA));
        // id tipo grupo dato venta real
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO_VENTA_REAL));
        assertEquals(TipoGrupoDatoEnum.VENTA_RANGO.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO_VENTA_REAL));
    }
    
    @Test
    public void totalizar() {
        RunTareaDto runTarea = mock(RunTareaDto.class);
        TareaDto tarea = mock(TareaDto.class);
        tarea.setId(1L);
        when(runTarea.getTarea()).thenReturn(tarea);

        tareaLocalizacionPresupuestoVentaRepositoryCustom.totalizar(runTarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_TOTALIZAR, sqlCaptor.getValue());
        // Parametros de la consulta: idTarea, activo, inactivo
        MapSqlParameterSource params = paramsCaptor.getValue();
        assertEquals(9, params.getValues().size());
        // idTarea
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        // activo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        // id tipo dato grupo dato venta congelada
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO_VENTA_CONGELADA));
        assertEquals(TipoGrupoDatoEnum.VENTA_RANGO_CONGELADA.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO_VENTA_CONGELADA));
        // id tipo grupo dato venta real
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO_VENTA_REAL));
        assertEquals(TipoGrupoDatoEnum.VENTA_RANGO.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO_VENTA_REAL));
        // id seccion
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION));
        assertEquals(AppConstants.SECCION_4, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION));
        // id tipo dato venta rango congelada localizacion
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_RANGO_CONGELADA_LOCALIZACION));
        assertEquals(TipoDatoEnum.VENTA_RANGO_CONGELADA_LOCALIZACION.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_RANGO_CONGELADA_LOCALIZACION));
        // id tipo dato venta rango congelada localizacion seccion
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_RANGO_CONGELADA_LOCALIZACION_SECCION));
        assertEquals(TipoDatoEnum.VENTA_RANGO_CONGELADA_LOCALIZACION_SECCION.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_RANGO_CONGELADA_LOCALIZACION_SECCION));
        // id tipo dato venta rango localizacion
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_RANGO_LOCALIZACION));
        assertEquals(TipoDatoEnum.VENTA_RANGO_LOCALIZACION.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_RANGO_LOCALIZACION));
        // id tipo dato venta rango localizacion seccion
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_RANGO_LOCALIZACION_SECCION));
        assertEquals(TipoDatoEnum.VENTA_RANGO_LOCALIZACION_SECCION.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_RANGO_LOCALIZACION_SECCION));
    }
    
}
