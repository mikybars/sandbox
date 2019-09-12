package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionVentaRepositoryCustomImplTest {
    //TODO [JESTEVEZ] Crear los tests sobre save, setParameters y updateActivo

    private final static String SQL_UPDATE_ACTIVO_TRASLADAR = "SQL UPDATE ACTIVO TRASLADAR";

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @InjectMocks
    private TareaLocalizacionVentaRepositoryCustomImpl tareaLocalizacionVentaRepositoryCustom;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

    @Before
    public void setup() throws IllegalAccessException {
//        FieldUtils.writeField(tareaLocalizacionVentaRepositoryCustom,
//            "sqlSave", SQL_SAVE, true);
//        FieldUtils.writeField(tareaLocalizacionVentaRepositoryCustom,
//            "sqlUpdateActivo", SQL_UPDATE_ACTIVO, true);
        FieldUtils.writeField(tareaLocalizacionVentaRepositoryCustom,
            "sqlUpdateActivoTrasladadas", SQL_UPDATE_ACTIVO_TRASLADAR, true);
//        FieldUtils.writeField(tareaLocalizacionVentaRepositoryCustom,
//            "batchSize", 100, true);
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
        assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue("nuevoActivo"));

    }

}
