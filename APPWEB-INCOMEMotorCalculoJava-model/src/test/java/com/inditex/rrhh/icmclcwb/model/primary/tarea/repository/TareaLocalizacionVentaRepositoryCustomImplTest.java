package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVenta;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVentaPk;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionVentaRepositoryCustomImplTest {

    private final static String SQL_UPDATE_ACTIVO_TRASLADAR = "SQL UPDATE ACTIVO TRASLADAR";

    private final static String SQL_SAVE = "SQL SAVE";

    private final static String SQL_UPDATE_ACTIVO = "SQL UPDATE ACTIVO";

    private final static String SQL_TOTALIZAR_OPERACIONES = "SQL TOTALIZAR OPERACIONES";

    private final static String SQL_TOTALIZAR_PERSONAS_POR_VENTA = "SQL TOTALIZAR PERSONAS POR VENTA";

    private final static String SQL_CALCULAR_IMPORTE_COMISION_VENDEDORES = "SQL CALCULAR IMPORTE COMISION VENDEDORES";

    private final static String SQL_CALCULAR_IMPORTE_COMISION_VENTA_DEVOLUCION = "SQL CALCULAR IMORTE COMISION VENTA O DEVOLUCION";

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Mock
    private JdbcTemplate template;

    @Mock
    private Logger log;

    @InjectMocks
    private TareaLocalizacionVentaRepositoryCustomImpl tareaLocalizacionVentaRepositoryCustom;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaLocalizacionVentaRepositoryCustom,
            "sqlSave", SQL_SAVE, true);
        FieldUtils.writeField(tareaLocalizacionVentaRepositoryCustom,
            "sqlUpdateActivo", SQL_UPDATE_ACTIVO, true);
        FieldUtils.writeField(tareaLocalizacionVentaRepositoryCustom,
            "sqlUpdateActivoTrasladadas", SQL_UPDATE_ACTIVO_TRASLADAR, true);
        FieldUtils.writeField(tareaLocalizacionVentaRepositoryCustom,
            "sqlTotalizarOperacionesLocalizacionSeccion", SQL_TOTALIZAR_OPERACIONES, true);
        FieldUtils.writeField(tareaLocalizacionVentaRepositoryCustom,
            "sqlTotalizarVentaPersonasPorVenta", SQL_TOTALIZAR_PERSONAS_POR_VENTA, true);
        FieldUtils.writeField(tareaLocalizacionVentaRepositoryCustom,
            "sqlCalcularImporteComisionVendedores", SQL_CALCULAR_IMPORTE_COMISION_VENDEDORES, true);
        FieldUtils.writeField(tareaLocalizacionVentaRepositoryCustom, "sqlCalcularImporteComisionVentaODevolucion",
            SQL_CALCULAR_IMPORTE_COMISION_VENTA_DEVOLUCION, true);
        FieldUtils.writeField(tareaLocalizacionVentaRepositoryCustom,
            "batchSize", 100, true);
    }

    @Test
    public void setParametersTest() throws SQLException {
        PreparedStatement pstmt = mock(PreparedStatement.class);
        TareaLocalizacionVenta entity = mock(TareaLocalizacionVenta.class);
        TareaLocalizacionVentaPk pk = mock(TareaLocalizacionVentaPk.class);
        TipoDato td = mock(TipoDato.class);
        when(td.getId()).thenReturn(911);
        when(pk.getFechaInicioPeriodo()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 1, 1)));
        when(entity.getPk()).thenReturn(pk);
        when(entity.getCclIdCadena()).thenReturn("ID CADENA");
        when(entity.getCclIdCodOrigen()).thenReturn("ID LOCALIZACIÓN");
        when(entity.getCclIdSeccion()).thenReturn("ID SECCIÓN");
        when(entity.getImporteConImpuestos()).thenReturn(8989.2);
        when(entity.getImporteSinImpuestos()).thenReturn(87878.12);
        when(entity.getTipoDato()).thenReturn(td);
        when(entity.getActivo()).thenReturn(Boolean.TRUE);
        Tarea tarea = mock(Tarea.class);
        when(tarea.getId()).thenReturn(888L);
        when(entity.getTarea()).thenReturn(tarea);

        tareaLocalizacionVentaRepositoryCustom.setParameters(pstmt, entity);
        // Parámetros de la consulta: fecha, cclIdCadena, cclIdCodOrigen, cclIdSeccion, importeSinImpuestos, importeConImpuestos,
        // idTipoDato, activo, idTarea
        verify(pstmt, times(1)).setObject(1, entity.getFecha());
        verify(pstmt, times(1)).setString(2, entity.getCclIdCadena());
        verify(pstmt, times(1)).setString(3, entity.getCclIdCodOrigen());
        verify(pstmt, times(1)).setString(4, entity.getCclIdSeccion());
        verify(pstmt, times(1)).setDouble(5, entity.getImporteSinImpuestos());
        verify(pstmt, times(1)).setDouble(6, entity.getImporteConImpuestos());
        verify(pstmt, times(1)).setDouble(7, td.getId());
        verify(pstmt, times(1)).setBoolean(8, entity.getActivo());
        verify(pstmt, times(1)).setLong(9, tarea.getId());
        verify(pstmt, times(1)).setObject(10, pk.getFechaInicioPeriodo());
    }

    @Test
    public void saveTest() {
        List<TareaLocalizacionVenta> items = Collections.singletonList(mock(TareaLocalizacionVenta.class));
        tareaLocalizacionVentaRepositoryCustom.save(items);
        verify(template).batchUpdate(sqlCaptor.capture(), any(BatchPreparedStatementSetter.class));
        assertEquals(SQL_SAVE, sqlCaptor.getValue());
    }

    @Test
    public void updateActivoTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(3933L);
        List<Integer> idsTipoDato = Arrays.asList(21,39,29,22);

        tareaLocalizacionVentaRepositoryCustom.updateActivo(tarea, TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_VENTA,
            idsTipoDato);
        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_UPDATE_ACTIVO, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();

        // Parámetros de la consulta: tiposDato, idConcepto, idTarea, porcentajeInclusion, nuevoActivo
        assertEquals(5, params.getValues().size());
        // tiposDato
        assertTrue(params.hasValue("tiposDato"));
        assertEquals(idsTipoDato, params.getValue("tiposDato"));
        // idConcepto
        assertTrue(params.hasValue("idConcepto"));
        assertEquals(TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_VENTA.getId(), params.getValue("idConcepto"));
        // idTarea
        assertTrue(params.hasValue("idTarea"));
        assertEquals(tarea.getId(), params.getValue("idTarea"));
        // porcentajeInclusion
        assertTrue(params.hasValue("porcentajeInclusion"));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_PORCENTAJE_CERO, params.getValue("porcentajeInclusion"));
        // nuevoActivo
        assertTrue(params.hasValue("nuevoActivo"));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE, params.getValue("nuevoActivo"));

    }

    @Test
    public void updateActivoTrasladadasTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(9090L);
        tareaLocalizacionVentaRepositoryCustom.updateActivoTrasladadas(tarea);

        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_UPDATE_ACTIVO_TRASLADAR, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();

        // Parámetros de la consulta: idTipoDatoVentaIpodLocalizacion, idTipoDatoVentaIpodLocalizacionSeccion,
        // idTipoDatoVentaSINTLocalizacion, idTipoDatoVentaSINTLocalizacionSeccion, idTipoDatoVentaEntregaTiendaLocalizacion,
        // idTipoDatoVentaEntregaTiendaLocalizacionSeccion, idTipoDatoVentaEntregaDomicilioLocalizacion,
        // idTipoDatoVentaEntregaDomicilioLocalizacionSeccion, idTipoDatoVentaIpodLocalizacionTrasladada,
        // idTipoDatoVentaIpodLocalizacionSeccionTrasladada, idTipoDatoVentaSINTLocalizacionTrasladada,
        // idTipoDatoVentaSINTLocalizacionSeccionTrasladada, idTipoDatoVentaEntregaTiendaLocalizacionTrasladada,
        // idTipoDatoVentaEntregaTiendaLocalizacionSeccionTrasladada, idTipoDatoVentaEntregaDomicilioLocalizacionTrasladada,
        // idTipoDatoVentaEntregaDomicilioLocalizacionSeccionTrasladada, idTarea, nuevoActivo
        assertEquals(18, params.getValues().size());
        // idTipoDatoVentaIpodLocalizacion
        assertTrue(params.hasValue("idTipoDatoVentaIpodLocalizacion"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION.getId(), params.getValue("idTipoDatoVentaIpodLocalizacion"));
        // idTipoDatoVentaIpodLocalizacionSeccion
        assertTrue(params.hasValue("idTipoDatoVentaIpodLocalizacionSeccion"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId(), params.getValue("idTipoDatoVentaIpodLocalizacionSeccion"));
        // idTipoDatoVentaSINTLocalizacion
        assertTrue(params.hasValue("idTipoDatoVentaSINTLocalizacion"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION.getId(), params.getValue("idTipoDatoVentaSINTLocalizacion"));
        // idTipoDatoVentaSINTLocalizacionSeccion
        assertTrue(params.hasValue("idTipoDatoVentaSINTLocalizacionSeccion"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION.getId(), params.getValue("idTipoDatoVentaSINTLocalizacionSeccion"));
        // idTipoDatoVentaEntregaTiendaLocalizacion
        assertTrue(params.hasValue("idTipoDatoVentaEntregaTiendaLocalizacion"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION.getId(), params.getValue("idTipoDatoVentaEntregaTiendaLocalizacion"));
        // idTipoDatoVentaEntregaTiendaLocalizacionSeccion
        assertTrue(params.hasValue("idTipoDatoVentaEntregaTiendaLocalizacionSeccion"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION.getId(), params.getValue("idTipoDatoVentaEntregaTiendaLocalizacionSeccion"));
        // idTipoDatoVentaEntregaDomicilioLocalizacion
        assertTrue(params.hasValue("idTipoDatoVentaEntregaDomicilioLocalizacion"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION.getId(), params.getValue("idTipoDatoVentaEntregaDomicilioLocalizacion"));
        // idTipoDatoVentaEntregaDomicilioLocalizacionSeccion
        assertTrue(params.hasValue("idTipoDatoVentaEntregaDomicilioLocalizacionSeccion"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION.getId(), params.getValue("idTipoDatoVentaEntregaDomicilioLocalizacionSeccion"));
        // idTipoDatoVentaIpodLocalizacionTrasladada
        assertTrue(params.hasValue("idTipoDatoVentaIpodLocalizacionTrasladada"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_TRASLADADA_DIA.getId(), params.getValue("idTipoDatoVentaIpodLocalizacionTrasladada"));
        // idTipoDatoVentaIpodLocalizacionSeccionTrasladada
        assertTrue(params.hasValue("idTipoDatoVentaIpodLocalizacionSeccionTrasladada"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(), params.getValue("idTipoDatoVentaIpodLocalizacionSeccionTrasladada"));
        // idTipoDatoVentaSINTLocalizacionTrasladada
        assertTrue(params.hasValue("idTipoDatoVentaSINTLocalizacionTrasladada"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_TRASLADADA_DIA.getId(), params.getValue("idTipoDatoVentaSINTLocalizacionTrasladada"));
        // idTipoDatoVentaSINTLocalizacionSeccionTrasladada
        assertTrue(params.hasValue("idTipoDatoVentaSINTLocalizacionSeccionTrasladada"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(), params.getValue("idTipoDatoVentaSINTLocalizacionSeccionTrasladada"));
        // idTipoDatoVentaEntregaTiendaLocalizacionTrasladada
        assertTrue(params.hasValue("idTipoDatoVentaEntregaTiendaLocalizacionTrasladada"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_TRASLADADA_DIA.getId(), params.getValue("idTipoDatoVentaEntregaTiendaLocalizacionTrasladada"));
        // idTipoDatoVentaEntregaTiendaLocalizacionSeccionTrasladada
        assertTrue(params.hasValue("idTipoDatoVentaEntregaTiendaLocalizacionSeccionTrasladada"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(), params.getValue("idTipoDatoVentaEntregaTiendaLocalizacionSeccionTrasladada"));
        // idTipoDatoVentaEntregaDomicilioLocalizacionTrasladada
        assertTrue(params.hasValue("idTipoDatoVentaEntregaDomicilioLocalizacionTrasladada"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_TRASLADADA_DIA.getId(), params.getValue("idTipoDatoVentaEntregaDomicilioLocalizacionTrasladada"));
        // idTipoDatoVentaEntregaDomicilioLocalizacionSeccionTrasladada
        assertTrue(params.hasValue("idTipoDatoVentaEntregaDomicilioLocalizacionSeccionTrasladada"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(), params.getValue("idTipoDatoVentaEntregaDomicilioLocalizacionSeccionTrasladada"));
        // idTarea
        assertTrue(params.hasValue("idTarea"));
        assertEquals(tarea.getId(), params.getValue("idTarea"));
        // nuevoActivo
        assertTrue(params.hasValue("nuevoActivo"));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE, params.getValue("nuevoActivo"));

    }

    @Test
    public void totalizarDevolucionLocalizacionTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(9090L);
        tareaLocalizacionVentaRepositoryCustom.totalizarDevolucionLocalizacionSeccion(tarea);

        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_TOTALIZAR_OPERACIONES, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();

        // Parámetros de la consulta: nuevoIdSeccion, nuevoIdTipoDato, nuevoActivo, idTarea, idTipoGrupoDato, activo
        assertEquals(5, params.getValues().size());
        // idTarea
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        // nuevoActivo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
        // nuevoIdTipoDato
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.DEVOLUCION_LOCALIZACION_SECCION.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // idTipoGrupoDato
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO));
        assertEquals(TipoGrupoDatoEnum.DEVOLUCION_LOCALIZACION_TOTALIZADA.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO));
        // activo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));

    }

    @Test
    public void totalizarVentaSinDevolucionLocalizacionTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(9090L);
        tareaLocalizacionVentaRepositoryCustom.totalizarVentasSinDevolucionLocalizacionSeccion(tarea);

        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_TOTALIZAR_OPERACIONES, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();

        // Parámetros de la consulta: nuevoIdSeccion, nuevoIdTipoDato, nuevoActivo, idTarea, idTipoGrupoDato, activo
        assertEquals(5, params.getValues().size());
        // idTarea
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        // nuevoActivo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
        // nuevoIdTipoDato
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // idTipoGrupoDato
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO));
        assertEquals(TipoGrupoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION_TOTALIZADA.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO));
        // activo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));

    }

    @Test
    public void totalizarVentaPersonasPorVentaSimplificada() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(123L);
        tareaLocalizacionVentaRepositoryCustom.totalizarVentaPersonasPorVentaSimplificada(tarea);

        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_TOTALIZAR_PERSONAS_POR_VENTA, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();

        // Parámetros de la consulta: idTarea, activo, idTipoDatoIndicadorPresencia, idTipoGrupoDato, nuevoIdTipoDato, nuevoActivo
        assertEquals(6, params.getValues().size());
        // idTarea
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        // activo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        // idTipoDatoIndicadorPresencia
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA));
        assertEquals(TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA_SIMPLIFICADA.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA));
        // idTipoGrupoDato
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO));
        assertEquals(TipoGrupoDatoEnum.OPERACIONES_VENTA_INDIVIDUAL_LOCALIZACION_SECCION.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO));
        // nuevoIdTipoDato
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.VENTA_LOCALIZACION_EMPLEADOS_POR_VENTA_SIMPLIFICADO.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // nuevoActivo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));

    }

    @Test
    public void totalizarVentaSinDevolucionPersonasPorVenta() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(123L);
        tareaLocalizacionVentaRepositoryCustom.totalizarVentaSinDevolucionPersonasPorVenta(tarea);

        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_TOTALIZAR_PERSONAS_POR_VENTA, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();

        // Parámetros de la consulta: idTarea, activo, idTipoDatoIndicadorPresencia, idTipoGrupoDato, nuevoIdTipoDato, nuevoActivo
        assertEquals(6, params.getValues().size());
        // idTarea
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        // activo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        // idTipoDatoIndicadorPresencia
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA));
        assertEquals(TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA));
        // idTipoGrupoDato
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO));
        assertEquals(TipoGrupoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION_TOTALIZADA.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO));
        // nuevoIdTipoDato
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_EMPLEADOS_POR_VENTA.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // nuevoActivo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));

    }

    @Test
    public void calcularImporteComisionVendedoresTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(123L);

        tareaLocalizacionVentaRepositoryCustom.calcularImporteComisionVendedores(tarea);

        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_CALCULAR_IMPORTE_COMISION_VENDEDORES, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();

        // Parámetros de la consulta: idTarea, activo, idTipoDatoPresenciaLocalizacionPersonasPorVenta, idTipoGrupo,
        // idTipoPresenciaLocalizacion, porcentajeComision,
        // nuevoIdTipoDato, nuevoActivo
        assertEquals(8, params.getValues().size());
        // idTarea
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        // activo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        // idTipoPresenciaLocalizacion
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_PRESENCIA_LOCALIZACION_PERSONAS_POR_VENTA));
        assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_EMPLEADOS_POR_VENTA.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_PRESENCIA_LOCALIZACION_PERSONAS_POR_VENTA));
        // idTipoGrupo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO));
        assertEquals(TipoGrupoDatoEnum.VENTA_FISICA_IPOD_LOCALIZACION_SECCION.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO));
        // idTipoPresenciaLocalizacion
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_PRESENCIA_LOCALIZACION));
        assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDODENOMINADOR.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_PRESENCIA_LOCALIZACION));
        // porcentajeComision
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_COMISION));
        assertEquals(AppConstants.PORCENTAJE_COMISION, params.getValue(SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_COMISION));
        // nuevoIdTipoDato
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.IMPORTE_COMISION_VENDEDORES_POR_VENTA.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // nuevoActivo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
    }

    @Test
    public void calcularImporteComisionVentaODevolucionTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(123L);

        tareaLocalizacionVentaRepositoryCustom.calcularImporteComisionVentaODevolucion(tarea);

        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_CALCULAR_IMPORTE_COMISION_VENTA_DEVOLUCION, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();

        // Parámetros de la consulta: idTarea, activo, idTipoDatoDevolucionLocalizacionSeccion, idTipoGrupo,
        // idTipoDatoVentaSinDevolucionLocalizacionSeccion, idTipoDatoImporteComisionVenta, idTipoDatoImporteComisionDevolucion,
        // tiposDato, nuevoActivo, idTipoDatoImporteComisionVendedores
        assertEquals(10, params.getValues().size());
        // idTarea
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
        // activo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
        // idTipoDatoDevolucionLocalizacionSeccion
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_DEVOLUCION_LOCALIZACION_SECCION));
        assertEquals(TipoDatoEnum.DEVOLUCION_LOCALIZACION_SECCION.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_DEVOLUCION_LOCALIZACION_SECCION));
        // idTipoDatoImporteComisionDevolucion
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_IMPORTE_COMISION_DEVOLUCION));
        assertEquals(TipoDatoEnum.IMPORTE_COMISION_DEVOLUCIONES_LOCALIZACION_POR_VENTA.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_IMPORTE_COMISION_DEVOLUCION));
        // idTipoGrupo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO));
        assertEquals(TipoGrupoDatoEnum.VENTA_FISICA_IPOD_LOCALIZACION_SECCION.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO));
        // idTipoDatoVentaSinDevolucionLocalizacionSeccion
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION));
        assertEquals(TipoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION));
        // idTipoDatoImporteComisionVenta
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_IMPORTE_COMISION_VENTA));
        assertEquals(TipoDatoEnum.IMPORTE_COMISION_VENTA_LOCALIZACION_POR_VENTA.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_IMPORTE_COMISION_VENTA));
        // tiposDato
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(Arrays.asList(TipoDatoEnum.DEVOLUCION_LOCALIZACION_SECCION.getId(), TipoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION.getId()), params.getValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO));
        // nuevoActivo
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
        // idTipoDatoImporteComisionVendedores
        assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_IMPORTE_COMISION_VENDEDORES));
        assertEquals(TipoDatoEnum.IMPORTE_COMISION_VENDEDORES_POR_VENTA.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_IMPORTE_COMISION_VENDEDORES));
    }

}
