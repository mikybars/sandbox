package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
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

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ABIERTO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ACTIVO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_CERRADO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_CALCULO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_SECCION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TAREA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_MINUTOS;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_IMPORTE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_NUEVO_ABIERTO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_IMPORTE_CERO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionAbiertaRepositoryCustomImplTest {

    private static final String SQL_SAVE_ABIERTO = "SQL SAVE ABIERTO TEST";

    private static final String SQL_SAVE_CERRADO = "SQL SAVE CERRADO TEST";

    private static final String SQL_TRASLADAR = "SQL TRALADAR TEST";

    private static final String SQL_COMPENSARL = "SQL COMPENSAR TEST";

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @InjectMocks
    private TareaLocalizacionAbiertaRepositoryCustomImpl tareaLocalizacionAbiertaRepositoryCustom;


    @Captor
    private ArgumentCaptor<String> sql;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> params;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaLocalizacionAbiertaRepositoryCustom, "sqlSaveAbierto", SQL_SAVE_ABIERTO, true);
        FieldUtils.writeField(tareaLocalizacionAbiertaRepositoryCustom, "sqlSaveCerrado", SQL_SAVE_CERRADO, true);
        FieldUtils.writeField(tareaLocalizacionAbiertaRepositoryCustom, "sqlCompensar", SQL_COMPENSARL, true);
        FieldUtils.writeField(tareaLocalizacionAbiertaRepositoryCustom, "sqlTrasladar", SQL_TRASLADAR, true);
    }

    @Test
    public void saveAbiertoTest() {
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(900L);
        TrabajoDto trabajo = mock(TrabajoDto.class);

        tareaLocalizacionAbiertaRepositoryCustom.saveAbierto(tarea, trabajo);
        verify(namedParameterJdbcTemplate, times(1)).update(sql.capture(), params.capture());
        assertEquals(SQL_SAVE_ABIERTO, sql.getValue());
        // Parametros de la consulta:
        // idTipoImporteVenta, idTipoPresencia, idTarea, importe, excluidoCalculo, activo, nuevoAbierto,
        // idSeccion
        assertEquals(8, params.getValue().getValues().size());
        // idTipoImporteVenta
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TIPO_IMPORTE_VENTA));
        assertEquals(TipoDatoEnum.VENTA_FISICA_LOCALIZACION_SECCION.getId(),
                params.getValue().getValue(SQL_PARAM_ID_TIPO_IMPORTE_VENTA));
        // idTipoPresencia
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TIPO_MINUTOS));
        assertEquals(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
                params.getValue().getValue(SQL_PARAM_ID_TIPO_MINUTOS));
        // nuevoAbierto
        assertTrue(params.getValue().hasValue(SQL_PARAM_NUEVO_ABIERTO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue().getValue(SQL_PARAM_NUEVO_ABIERTO));
        // idTarea
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue().getValue(SQL_PARAM_ID_TAREA));
        // importe
        assertTrue(params.getValue().hasValue(SQL_PARAM_IMPORTE));
        assertEquals(SQL_VALUE_IMPORTE_CERO, params.getValue().getValue(SQL_PARAM_IMPORTE));
        // idSeccion
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_SECCION));
        assertEquals(AppConstants.SECCION_4, params.getValue().getValue(SQL_PARAM_ID_SECCION));
        // excluidoCalculo
        assertTrue(params.getValue().hasValue(SQL_PARAM_EXCLUIDO_CALCULO));
        assertEquals(SQL_VALUE_BOOLEAN_FALSE, params.getValue().getValue(SQL_PARAM_EXCLUIDO_CALCULO));
        // activo
        assertTrue(params.getValue().hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue().getValue(SQL_PARAM_ACTIVO));
    }

    @Test
    public void trasladarTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(900L);
        List<Integer> idTipoImporteVentas = Arrays.asList(2001, 2002);

        tareaLocalizacionAbiertaRepositoryCustom.trasladar(tarea, idTipoImporteVentas);
        verify(namedParameterJdbcTemplate, times(1)).update(sql.capture(), params.capture());
        assertEquals(SQL_TRASLADAR, sql.getValue());
        // parametros de la consulta: tiposDato, idTarea, cerrado, abierto, nuevoActivo, activo
        // idTipoDatoVentaIpodLocalizacion, idTipoDatoVentaIpodLocalizacionTrasladada
        // idTipoDatoVentaIpodLocalizacionSeccion, idTipoDatoVentaIpodLocalizacionSeccionTrasladada
        // idTipoDatoVentaSINTLocalizacion, idTipoDatoVentaSINTLocalizacionTrasladada
        // idTipoDatoVentaSINTLocalizacionSeccion, idTipoDatoVentaSINTLocalizacionSeccionTrasladada
        // idTipoDatoVentaEntregaTiendaLocalizacion, idTipoDatoVentaEntregaTiendaLocalizacionTrasladada
        // idTipoDatoVentaEntregaTiendaLocalizacionSeccion,
        // idTipoDatoVentaEntregaTiendaLocalizacionSeccionTrasladada
        // idTipoDatoVentaEntregaDomicilioLocalizacion,
        // idTipoDatoVentaEntregaDomicilioLocalizacionTrasladada
        // idTipoDatoVentaEntregaDomicilioLocalizacionSeccion,
        // idTipoDatoVentaEntregaDomicilioLocalizacionSeccionTrasladada
        assertEquals(22, params.getValue().getValues().size());
        // tiposDato
        assertTrue(params.getValue().hasValue(SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(idTipoImporteVentas, params.getValue().getValue(SQL_PARAM_IDS_TIPOS_DATO));
        // idTarea
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue().getValue(SQL_PARAM_ID_TAREA));
        // cerrado
        assertTrue(params.getValue().hasValue(SQL_PARAM_CERRADO));
        assertEquals(SQL_VALUE_BOOLEAN_FALSE, params.getValue().getValue(SQL_PARAM_CERRADO));
        // abierto
        assertTrue(params.getValue().hasValue(SQL_PARAM_ABIERTO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue().getValue(SQL_PARAM_ABIERTO));
        // nuevoActivo
        assertTrue(params.getValue().hasValue(SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue().getValue(SQL_PARAM_NUEVO_ACTIVO));
        // activo
        assertTrue(params.getValue().hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue().getValue(SQL_PARAM_ACTIVO));
        // idTipoDatoVentaIpodLocalizacion
        assertTrue(params.getValue().hasValue("idTipoDatoVentaIpodLocalizacion"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION.getId(),
                params.getValue().getValue("idTipoDatoVentaIpodLocalizacion"));
        // idTipoDatoVentaIpodLocalizacionSeccion
        assertTrue(params.getValue().hasValue("idTipoDatoVentaIpodLocalizacionSeccion"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId(),
                params.getValue().getValue("idTipoDatoVentaIpodLocalizacionSeccion"));
        // idTipoDatoVentaSINTLocalizacion
        assertTrue(params.getValue().hasValue("idTipoDatoVentaSINTLocalizacion"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION.getId(),
                params.getValue().getValue("idTipoDatoVentaSINTLocalizacion"));
        // idTipoDatoVentaSINTLocalizacionSeccion
        assertTrue(params.getValue().hasValue("idTipoDatoVentaSINTLocalizacionSeccion"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION.getId(),
                params.getValue().getValue("idTipoDatoVentaSINTLocalizacionSeccion"));
        // idTipoDatoVentaEntregaTiendaLocalizacion
        assertTrue(params.getValue().hasValue("idTipoDatoVentaEntregaTiendaLocalizacion"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION.getId(),
                params.getValue().getValue("idTipoDatoVentaEntregaTiendaLocalizacion"));
        // idTipoDatoVentaEntregaTiendaLocalizacionSeccion
        assertTrue(params.getValue().hasValue("idTipoDatoVentaEntregaTiendaLocalizacionSeccion"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION.getId(),
                params.getValue().getValue("idTipoDatoVentaEntregaTiendaLocalizacionSeccion"));
        // idTipoDatoVentaEntregaDomicilioLocalizacion
        assertTrue(params.getValue().hasValue("idTipoDatoVentaEntregaDomicilioLocalizacion"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION.getId(),
                params.getValue().getValue("idTipoDatoVentaEntregaDomicilioLocalizacion"));
        // idTipoDatoVentaEntregaDomicilioLocalizacionSeccion
        assertTrue(params.getValue().hasValue("idTipoDatoVentaEntregaDomicilioLocalizacionSeccion"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION.getId(),
                params.getValue().getValue("idTipoDatoVentaEntregaDomicilioLocalizacionSeccion"));
        // idTipoDatoVentaIpodLocalizacionTrasladada
        assertTrue(params.getValue().hasValue("idTipoDatoVentaIpodLocalizacionTrasladada"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_TRASLADADA_DIA.getId(),
                params.getValue().getValue("idTipoDatoVentaIpodLocalizacionTrasladada"));
        // idTipoDatoVentaIpodLocalizacionSeccionTrasladada
        assertTrue(params.getValue().hasValue("idTipoDatoVentaIpodLocalizacionSeccionTrasladada"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(),
                params.getValue().getValue("idTipoDatoVentaIpodLocalizacionSeccionTrasladada"));
        // idTipoDatoVentaSINTLocalizacionTrasladada
        assertTrue(params.getValue().hasValue("idTipoDatoVentaSINTLocalizacionTrasladada"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_TRASLADADA_DIA.getId(),
                params.getValue().getValue("idTipoDatoVentaSINTLocalizacionTrasladada"));
        // idTipoDatoVentaSINTLocalizacionSeccionTrasladada
        assertTrue(params.getValue().hasValue("idTipoDatoVentaSINTLocalizacionSeccionTrasladada"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(),
                params.getValue().getValue("idTipoDatoVentaSINTLocalizacionSeccionTrasladada"));
        // idTipoDatoVentaEntregaTiendaLocalizacionTrasladada
        assertTrue(params.getValue().hasValue("idTipoDatoVentaEntregaTiendaLocalizacionTrasladada"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_TRASLADADA_DIA.getId(),
                params.getValue().getValue("idTipoDatoVentaEntregaTiendaLocalizacionTrasladada"));
        // idTipoDatoVentaEntregaTiendaLocalizacionSeccionTrasladada
        assertTrue(params.getValue().hasValue("idTipoDatoVentaEntregaTiendaLocalizacionSeccionTrasladada"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(),
                params.getValue().getValue("idTipoDatoVentaEntregaTiendaLocalizacionSeccionTrasladada"));
        // idTipoDatoVentaEntregaDomicilioLocalizacionTrasladada
        assertTrue(params.getValue().hasValue("idTipoDatoVentaEntregaDomicilioLocalizacionTrasladada"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_TRASLADADA_DIA.getId(),
                params.getValue().getValue("idTipoDatoVentaEntregaDomicilioLocalizacionTrasladada"));
        // idTipoDatoVentaEntregaDomicilioLocalizacionSeccionTrasladada
        assertTrue(params.getValue().hasValue("idTipoDatoVentaEntregaDomicilioLocalizacionSeccionTrasladada"));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(),
                params.getValue().getValue("idTipoDatoVentaEntregaDomicilioLocalizacionSeccionTrasladada"));
    }

    @Test
    public void compensarTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(900L);
        List<Integer> idTipoImporteVentas = Arrays.asList(2001, 2002);

        tareaLocalizacionAbiertaRepositoryCustom.compensar(tarea, idTipoImporteVentas);
        verify(namedParameterJdbcTemplate, times(1)).update(sql.capture(), params.capture());
        assertEquals(SQL_COMPENSARL, sql.getValue());
        // parametros de la consulta: tiposDato, idTarea, cerrado, nuevoActivo
        assertEquals(4, params.getValue().getValues().size());
        // tiposDato
        assertTrue(params.getValue().hasValue(SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(idTipoImporteVentas, params.getValue().getValue(SQL_PARAM_IDS_TIPOS_DATO));
        // idTarea
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue().getValue(SQL_PARAM_ID_TAREA));
        // cerrado
        assertTrue(params.getValue().hasValue(SQL_PARAM_CERRADO));
        assertEquals(SQL_VALUE_BOOLEAN_FALSE, params.getValue().getValue(SQL_PARAM_CERRADO));
        // nuevoActivo
        assertTrue(params.getValue().hasValue(SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_FALSE, params.getValue().getValue(SQL_PARAM_NUEVO_ACTIVO));
    }

    @Test
    public void saveCerradoTest() {
        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(6789L);
        TrabajoDto trabajo = mock(TrabajoDto.class);
        List<Integer> idTipoImporteVenta = Arrays.asList(TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION.getId(),
                TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION.getId(),
                TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION.getId(),
                TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION.getId());
        tareaLocalizacionAbiertaRepositoryCustom.saveCerrado(tarea, trabajo, idTipoImporteVenta);
        verify(namedParameterJdbcTemplate, times(1)).update(sql.capture(), params.capture());
        assertEquals(SQL_SAVE_CERRADO, sql.getValue());
        // parametros de la consulta: tiposDato, idTarea, nuevoAbierto, idSeccion, activo, abierto
        assertEquals(6, params.getValue().getValues().size());
        // tiposDato
        assertTrue(params.getValue().hasValue(SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(idTipoImporteVenta, params.getValue().getValue(SQL_PARAM_IDS_TIPOS_DATO));
        // idTarea
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue().getValue(SQL_PARAM_ID_TAREA));
        // nuevoAbierto
        assertTrue(params.getValue().hasValue(SQL_PARAM_NUEVO_ABIERTO));
        assertEquals(SQL_VALUE_BOOLEAN_FALSE, params.getValue().getValue(SQL_PARAM_NUEVO_ABIERTO));
        // idSeccion
        assertTrue(params.getValue().hasValue(SQL_PARAM_ID_SECCION));
        assertEquals(AppConstants.SECCION_4, params.getValue().getValue(SQL_PARAM_ID_SECCION));
        // activo
        assertTrue(params.getValue().hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue().getValue(SQL_PARAM_ACTIVO));
        // abierto
        assertTrue(params.getValue().hasValue(SQL_PARAM_ABIERTO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue().getValue(SQL_PARAM_ABIERTO));
    }

}
