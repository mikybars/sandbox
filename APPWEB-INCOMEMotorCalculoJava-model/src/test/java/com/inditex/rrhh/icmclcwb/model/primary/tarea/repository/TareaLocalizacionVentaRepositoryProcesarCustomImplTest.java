package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionVentaRepositoryProcesarCustomImplTest {

    private final static String SQL_PROCESAR_REPARTO_ENTREGA_DOMICILIO_AGRUPACIONES = "PROCESAR REPARTO ENTREGA DOMICILIO AGRUPACIONES";

    private final static String SQL_PROCESAR_REPARTO_ETNREGA_DOMICILIO_POR_PRESENCIA_AGRUPACIONES = "PROCESAR REPARTO ENTREGA DOMICILIO POR PRESENCIA AGRUPACIONES";

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @InjectMocks
    private TareaLocalizacionVentaRepositoryProcesarCustomImpl tareaLocalizacionVentaRepositoryProcesarCustom;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaLocalizacionVentaRepositoryProcesarCustom,
            "sqlProcesarEntregaDomicilioAgrupaciones", SQL_PROCESAR_REPARTO_ENTREGA_DOMICILIO_AGRUPACIONES, true);
        FieldUtils.writeField(tareaLocalizacionVentaRepositoryProcesarCustom,
            "sqlProcesarEntregaDomicilioPresenciaAgrupaciones", SQL_PROCESAR_REPARTO_ETNREGA_DOMICILIO_POR_PRESENCIA_AGRUPACIONES, true);
    }

    @Test
    public void procesarRepartoEntregaDomicilioAgrupacionesTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(7474L);

        tareaLocalizacionVentaRepositoryProcesarCustom.procesarRepartoEntregaDomicilioAgrupaciones(tarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_PROCESAR_REPARTO_ENTREGA_DOMICILIO_AGRUPACIONES, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();
        // Parámetros de la consulta: nuevoIdTipoDato, nuevoActivo, idTipoImporteVentaFisicaAgrupacion,
        // idTipoImporteVentaEntregaDomicilioAgrupacion,  idTarea, idTipoImporteVentaFisicaLocalizacion, idSeccion,
        // idConcepto, porcentajeInclusion
        assertEquals(9, params.getValues().size());
        // nuevoIdTipoDato,
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION.getId(), params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // nuevoActivo
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));
        // idTipoImporteVentaFisicaAgrupacion
        assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_IMPORTE_VENTA_FISICA_AGRUPACION));
        assertEquals(TipoDatoEnum.VENTA_FISICA_AGRUPACIONONLINE.getId(),
            params.getValue(SQL_PARAM_ID_TIPO_IMPORTE_VENTA_FISICA_AGRUPACION));
        // idTipoImporteVentaEntregaDomicilioAgrupacion
        assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_AGRUPACION));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_AGRUPACIONONLINE.getId(),
            params.getValue(SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_AGRUPACION));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // idTipoImporteVentaFisicaLocalizacion
        assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_DATO_VENTA_FISICA_LOCALIZACION));
        assertEquals(TipoDatoEnum.VENTA_FISICA_LOCALIZACION.getId(), params.getValue(SQL_PARAM_ID_TIPO_DATO_VENTA_FISICA_LOCALIZACION));
        // idSeccion
        assertTrue(params.hasValue(SQL_PARAM_ID_SECCION));
        assertEquals(AppConstants.SECCION_4, params.getValue(SQL_PARAM_ID_SECCION));
        // idConcepto
        assertTrue(params.hasValue(SQL_PARAM_ID_CONCEPTO));
        assertEquals(TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_VENTA.getId(), params.getValue(SQL_PARAM_ID_CONCEPTO));
        // porcentajeInclusion
        assertTrue(params.hasValue(SQL_PARAM_PORCENTAJE_INCLUSION));
        assertEquals(SQL_VALUE_PORCENTAJE_CERO, params.getValue(SQL_PARAM_PORCENTAJE_INCLUSION));
    }

    @Test
    public void procesarRepartoEntregaDomicilioPorPresenciaAgrupacionesTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(7474L);

        tareaLocalizacionVentaRepositoryProcesarCustom.procesarRepartoEntregaDomicilioPorPresenciaAgrupaciones(tarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        assertEquals(SQL_PROCESAR_REPARTO_ETNREGA_DOMICILIO_POR_PRESENCIA_AGRUPACIONES, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();
        // Parámetros de la consulta: nuevoIdTipoDato, nuevoActivo, idTipoPresenciaLocalizacion, activo,
        // idTipoPresenciaAgrupacion, idTipoImporteVentaEntregaDomicilioAgrupacion, idTarea, idTipoImporteVentaFisicaLocalizacion, idSeccion,
        // idConcepto, porcentajeInclusion, nuevoIdSeccion
        assertEquals(12, params.getValues().size());
        // nuevoIdTipoDato,
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION.getId(), params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // nuevoActivo
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));
        // idTipoPresenciaLocalizacion
        assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_PRESENCIA_LOCALIZACION));
        assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDOECOMMERCE.getId(),
            params.getValue(SQL_PARAM_ID_TIPO_PRESENCIA_LOCALIZACION));
        // activo
        assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
        // idTipoPresenciaAgrupacion
        assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_PRESENCIA_AGRUPACIONONLINE));
        assertEquals(TipoDatoEnum.PRESENCIA_AGRUPACIONONLINE_INCLUIDOECOMMERCE.getId(), params.getValue(SQL_PARAM_ID_TIPO_PRESENCIA_AGRUPACIONONLINE));
        // idTipoImporteVentaEntregaDomicilioAgrupacion
        assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_AGRUPACION));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_AGRUPACIONONLINE.getId(),
            params.getValue(SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_AGRUPACION));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // idTipoImporteVentaFisicaLocalizacion
        assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_DATO_VENTA_FISICA_LOCALIZACION));
        assertEquals(TipoDatoEnum.VENTA_FISICA_LOCALIZACION.getId(), params.getValue(SQL_PARAM_ID_TIPO_DATO_VENTA_FISICA_LOCALIZACION));
        // idSeccion
        assertTrue(params.hasValue(SQL_PARAM_ID_SECCION));
        assertEquals(AppConstants.SECCION_4, params.getValue(SQL_PARAM_ID_SECCION));
        // idConcepto
        assertTrue(params.hasValue(SQL_PARAM_ID_CONCEPTO));
        assertEquals(TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS.getId(), params.getValue(SQL_PARAM_ID_CONCEPTO));
        // porcentajeInclusion
        assertTrue(params.hasValue(SQL_PARAM_PORCENTAJE_INCLUSION));
        assertEquals(SQL_VALUE_PORCENTAJE_CERO, params.getValue(SQL_PARAM_PORCENTAJE_INCLUSION));
        // nuevoIdSeccion
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_SECCION));
        assertEquals(AppConstants.SECCION_4, params.getValue(SQL_PARAM_NUEVO_ID_SECCION));
    }

}
