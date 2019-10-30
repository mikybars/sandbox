package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVenta;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVentaPk;
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

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionVentaRepositoryCustomImplTest {

    private final static String SQL_UPDATE_ACTIVO_TRASLADAR = "SQL UPDATE ACTIVO TRASLADAR";

    private final static String SQL_SAVE = "SQL SAVE";

    private final static String SQL_UPDATE_ACTIVO = "SQL UPDATE ACTIVO";

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Mock
    private JdbcTemplate template;

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
            "batchSize", 100, true);
    }

    @Test
    public void setParametersTest() throws SQLException {
        PreparedStatement pstmt = mock(PreparedStatement.class);
        TareaLocalizacionVenta entity = mock(TareaLocalizacionVenta.class);
        TareaLocalizacionVentaPk pk = mock(TareaLocalizacionVentaPk.class);
        TipoDato td = mock(TipoDato.class);
        when(td.getId()).thenReturn(911);
        when(pk.getFecha()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 1, 1)));
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
        verify(pstmt, times(1)).setObject(1, pk.getFecha());
        verify(pstmt, times(1)).setString(2, entity.getCclIdCadena());
        verify(pstmt, times(1)).setString(3, entity.getCclIdCodOrigen());
        verify(pstmt, times(1)).setString(4, entity.getCclIdSeccion());
        verify(pstmt, times(1)).setDouble(5, entity.getImporteSinImpuestos());
        verify(pstmt, times(1)).setDouble(6, entity.getImporteConImpuestos());
        verify(pstmt, times(1)).setDouble(7, td.getId());
        verify(pstmt, times(1)).setObject(8, entity.getActivo());
        verify(pstmt, times(1)).setLong(9, tarea.getId());
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
        assertEquals(TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_TRASLADADA.getId(), params.getValue("idTipoDatoVentaIpodLocalizacionTrasladada"));
        // idTipoDatoVentaIpodLocalizacionSeccionTrasladada
        assertTrue(params.hasValue("idTipoDatoVentaIpodLocalizacionSeccionTrasladada"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION_TRASLADADA.getId(), params.getValue("idTipoDatoVentaIpodLocalizacionSeccionTrasladada"));
        // idTipoDatoVentaSINTLocalizacionTrasladada
        assertTrue(params.hasValue("idTipoDatoVentaSINTLocalizacionTrasladada"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_TRASLADADA.getId(), params.getValue("idTipoDatoVentaSINTLocalizacionTrasladada"));
        // idTipoDatoVentaSINTLocalizacionSeccionTrasladada
        assertTrue(params.hasValue("idTipoDatoVentaSINTLocalizacionSeccionTrasladada"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION_TRASLADADA.getId(), params.getValue("idTipoDatoVentaSINTLocalizacionSeccionTrasladada"));
        // idTipoDatoVentaEntregaTiendaLocalizacionTrasladada
        assertTrue(params.hasValue("idTipoDatoVentaEntregaTiendaLocalizacionTrasladada"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_TRASLADADA.getId(), params.getValue("idTipoDatoVentaEntregaTiendaLocalizacionTrasladada"));
        // idTipoDatoVentaEntregaTiendaLocalizacionSeccionTrasladada
        assertTrue(params.hasValue("idTipoDatoVentaEntregaTiendaLocalizacionSeccionTrasladada"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION_TRASLADADA.getId(), params.getValue("idTipoDatoVentaEntregaTiendaLocalizacionSeccionTrasladada"));
        // idTipoDatoVentaEntregaDomicilioLocalizacionTrasladada
        assertTrue(params.hasValue("idTipoDatoVentaEntregaDomicilioLocalizacionTrasladada"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_TRASLADADA.getId(), params.getValue("idTipoDatoVentaEntregaDomicilioLocalizacionTrasladada"));
        // idTipoDatoVentaEntregaDomicilioLocalizacionSeccionTrasladada
        assertTrue(params.hasValue("idTipoDatoVentaEntregaDomicilioLocalizacionSeccionTrasladada"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION_TRASLADADA.getId(), params.getValue("idTipoDatoVentaEntregaDomicilioLocalizacionSeccionTrasladada"));
        // idTarea
        assertTrue(params.hasValue("idTarea"));
        assertEquals(tarea.getId(), params.getValue("idTarea"));
        // nuevoActivo
        assertTrue(params.hasValue("nuevoActivo"));
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE, params.getValue("nuevoActivo"));

    }

}
