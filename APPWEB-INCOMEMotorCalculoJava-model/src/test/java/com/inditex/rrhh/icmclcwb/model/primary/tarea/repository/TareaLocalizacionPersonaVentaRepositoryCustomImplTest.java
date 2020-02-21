package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
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
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaVenta;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaVentaPk;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionPersonaVentaRepositoryCustomImplTest {

    private final static String SQL_SAVE = "SAVE";

    private final static String SQL_TOTALIZAR_VENTA_PERSONA_SECCION = "SQL_TOTALIZAR_VENTA_PERSONA_SECCION";

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Mock
    private TipoDatoService tipoDatoService;

    @InjectMocks
    private TareaLocalizacionPersonaVentaRepositoryCustomImpl tareaLocalizacionPersonaVentaRepositoryCustom;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @Captor
    private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(tareaLocalizacionPersonaVentaRepositoryCustom, "sqlTotalizarVentaPersonaSeccion", SQL_TOTALIZAR_VENTA_PERSONA_SECCION, true);
        FieldUtils.writeField(tareaLocalizacionPersonaVentaRepositoryCustom, "sqlSave", SQL_SAVE, true);
        FieldUtils.writeField(tareaLocalizacionPersonaVentaRepositoryCustom, "batchSize", 100, true);
    }

    @Test
    public void setParametersTest() throws SQLException {

        PreparedStatement pstmt = mock(PreparedStatement.class);
        TipoDato td = mock(TipoDato.class);
        when(td.getId()).thenReturn(89);
        Tarea tarea = mock(Tarea.class);
        TareaLocalizacionPersonaVentaPk pk = mock(TareaLocalizacionPersonaVentaPk.class);
         when(pk.getFechaInicioPeriodo()).thenReturn(TimeUtils.toDate(LocalDate.of(2015, 1, 1)));
        TareaLocalizacionPersonaVenta entity = mock(TareaLocalizacionPersonaVenta.class);
        when(entity.getTarea()).thenReturn(tarea);
        when(entity.getPk()).thenReturn(pk);
        when(entity.getTipoDato()).thenReturn(td);
        when(entity.getCclIdCodOrigen()).thenReturn("Id localización");
        when(entity.getCclIdPerson()).thenReturn("Id persona");
        when(entity.getImporteConImpuestos()).thenReturn(BigDecimal.valueOf(6789L));
        when(entity.getImporteSinImpuestos()).thenReturn(BigDecimal.valueOf(6711L));
        when(entity.getActivo()).thenReturn(Boolean.FALSE);
        when(entity.getCclIdCadena()).thenReturn("ZAR");
        when(entity.getCclIdSeccion()).thenReturn("CAB");

        tareaLocalizacionPersonaVentaRepositoryCustom.setParameters(pstmt, entity);

        // Parámetros de la consulta: fecha, cclIdCodOrigen, cclidPerson,
        // importeSinImpuestos, importeConImpuestos,
        // idTipoDato, idTarea

        verify(pstmt, times(1)).setObject(1, entity.getFecha());
        verify(pstmt, times(1)).setString(2, entity.getCclIdCodOrigen());
        verify(pstmt, times(1)).setString(3, entity.getCclIdPerson());
        verify(pstmt, times(1)).setBigDecimal(4, entity.getImporteSinImpuestos());
        verify(pstmt, times(1)).setBigDecimal(5, entity.getImporteConImpuestos());
        verify(pstmt, times(1)).setDouble(6, td.getId());
        verify(pstmt, times(1)).setLong(7, tarea.getId());
        verify(pstmt, times(1)).setObject(8, pk.getFechaInicioPeriodo());
        verify(pstmt, times(1)).setString(9, entity.getCclIdSeccion());
        verify(pstmt, times(1)).setString(10, entity.getCclIdCadena());
        verify(pstmt, times(1)).setBoolean(11, entity.getActivo());
    }

    @Test
    public void saveTest() {
        List<TareaLocalizacionPersonaVenta> items = Collections.singletonList(mock(TareaLocalizacionPersonaVenta.class));
        tareaLocalizacionPersonaVentaRepositoryCustom.save(items);
        verify(jdbcTemplate).batchUpdate(sqlCaptor.capture(), any(BatchPreparedStatementSetter.class));
        assertEquals(SQL_SAVE, sqlCaptor.getValue());
    }

    @Test
    public void totalizarVentaPersonaSeccionTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(9392L);
        when(tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class))).thenReturn(
            Arrays.asList(
                IdTipoDatoDto.builder().id(1001).build(),
                IdTipoDatoDto.builder().id(1002).build()));

        tareaLocalizacionPersonaVentaRepositoryCustom.totalizarVentaPersonaSeccion(tarea);

        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        verify(tipoDatoService, times(1)).findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.OPERACIONES_VENTA_INDIVIDUAL_LOCALIZACION_SECCION.getId());

        assertEquals(SQL_TOTALIZAR_VENTA_PERSONA_SECCION, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();
        // Parámetros de la consulta: nuevoIdTipoDato, nuevoActivo, idTarea, tiposDato, activo
        assertEquals(5, params.getValues().size());
        // nuevoIdTipoDato
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.VENTA_INDIVIDUAL_LOCALIZACION_SECCION.getId(), params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // nuevoActivo
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // tiposDato
        assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(Arrays.asList(1001,1002), params.getValue(SQL_PARAM_IDS_TIPOS_DATO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    }

    @Test
    public void totalizarDevolucionPersonaSeccionTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(9392L);
        when(tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class))).thenReturn(
            Arrays.asList(
                IdTipoDatoDto.builder().id(1001).build(),
                IdTipoDatoDto.builder().id(1002).build()));

        tareaLocalizacionPersonaVentaRepositoryCustom.totalizarDevolucionPersonaSeccion(tarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        verify(tipoDatoService, times(1)).findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.DEVOLUCION_LOCALIZACION_TOTALIZADA.getId());

        assertEquals(SQL_TOTALIZAR_VENTA_PERSONA_SECCION, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();
        // Parámetros de la consulta: nuevoIdTipoDato, nuevoActivo, idTarea, tiposDato, activo
        assertEquals(5, params.getValues().size());
        // nuevoIdTipoDato
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION.getId(), params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // nuevoActivo
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // tiposDato
        assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(Arrays.asList(1001,1002), params.getValue(SQL_PARAM_IDS_TIPOS_DATO));
        // activo
        assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    }


    @Test
    public void totalizarVentaSinDevolucionPersonaSeccionTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(9392L);
        when(tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class))).thenReturn(
            Arrays.asList(
                IdTipoDatoDto.builder().id(1001).build(),
                IdTipoDatoDto.builder().id(1002).build()));

        tareaLocalizacionPersonaVentaRepositoryCustom.totalizarVentaSinDevolucionPersonaSeccion(tarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        verify(tipoDatoService, times(1)).findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION_TOTALIZADA.getId());

        assertEquals(SQL_TOTALIZAR_VENTA_PERSONA_SECCION, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();
        // Parámetros de la consulta: nuevoIdTipoDato, nuevoActivo, idTarea, tiposDato, activo
        assertEquals(5, params.getValues().size());
        // nuevoIdTipoDato
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.VENTA_SIN_DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION.getId(), params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // nuevoActivo
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // tiposDato
        assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(Arrays.asList(1001,1002), params.getValue(SQL_PARAM_IDS_TIPOS_DATO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    }

    @Test
    public void totalizarVentaIpodSinDevolucionPersonaSeccionTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(9392L);

        tareaLocalizacionPersonaVentaRepositoryCustom.totalizarVentaOnlineIpodSinDevolucionPersonaSeccion(tarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        verify(tipoDatoService, never()).findTipoDatoByTipoGrupoDato(any(Integer.class));

        assertEquals(SQL_TOTALIZAR_VENTA_PERSONA_SECCION, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();
        // Parámetros de la consulta: nuevoIdTipoDato, nuevoActivo, idTarea, tiposDato, activo
        assertEquals(5, params.getValues().size());
        // nuevoIdTipoDato
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_IPOD_SIN_DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION.getId(), params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // nuevoActivo
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // tiposDato
        assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(Collections.singletonList(TipoDatoEnum.OPERACION_VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId()), params.getValue(SQL_PARAM_IDS_TIPOS_DATO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    }

    @Test
    public void totalizarVentaFisicaSinDevolucionPersonaSeccionTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(9392L);

        tareaLocalizacionPersonaVentaRepositoryCustom.totalizarVentaFisicaSinDevolucionPersonaSeccion(tarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        verify(tipoDatoService, never()).findTipoDatoByTipoGrupoDato(any(Integer.class));

        assertEquals(SQL_TOTALIZAR_VENTA_PERSONA_SECCION, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();
        // Parámetros de la consulta: nuevoIdTipoDato, nuevoActivo, idTarea, tiposDato, activo
        assertEquals(5, params.getValues().size());
        // nuevoIdTipoDato
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.VENTA_FISICA_SIN_DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION.getId(), params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // nuevoActivo
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // tiposDato
        assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(Collections.singletonList(TipoDatoEnum.OPERACION_VENTA_FISICA_LOCALIZACION_SECCION.getId()), params.getValue(SQL_PARAM_IDS_TIPOS_DATO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    }

    @Test
    public void totalizarDevolucionFisicaPersonaSeccionTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(9392L);

        tareaLocalizacionPersonaVentaRepositoryCustom.totalizarDevolucionFisicaPersonaSeccion(tarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        verify(tipoDatoService, never()).findTipoDatoByTipoGrupoDato(any(Integer.class));

        assertEquals(SQL_TOTALIZAR_VENTA_PERSONA_SECCION, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();
        // Parámetros de la consulta: nuevoIdTipoDato, nuevoActivo, idTarea, tiposDato, activo
        assertEquals(5, params.getValues().size());
        // nuevoIdTipoDato
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.DEVOLUCION_FISICA_INDIVIDUAL_LOCALIZACION_SECCION.getId(), params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // nuevoActivo
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // tiposDato
        assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(Collections.singletonList(TipoDatoEnum.OPERACION_DEVOLUCION_FISICA_LOCALIZACION_SECCION.getId()), params.getValue(SQL_PARAM_IDS_TIPOS_DATO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    }

    @Test
    public void totalizarDevolucionIpodPersonaSeccionTest() {

        TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(9392L);

        tareaLocalizacionPersonaVentaRepositoryCustom.totalizarDevolucionOnlineIpodPersonaSeccion(tarea);
        verify(namedParameterJdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());
        verify(tipoDatoService, never()).findTipoDatoByTipoGrupoDato(any(Integer.class));

        assertEquals(SQL_TOTALIZAR_VENTA_PERSONA_SECCION, sqlCaptor.getValue());
        MapSqlParameterSource params = paramsCaptor.getValue();
        // Parámetros de la consulta: nuevoIdTipoDato, nuevoActivo, idTarea, tiposDato, activo
        assertEquals(5, params.getValues().size());
        // nuevoIdTipoDato
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.DEVOLUCION_ONLINE_IPOD_INDIVIDUAL_LOCALIZACION_SECCION.getId(), params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // nuevoActivo
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // tiposDato
        assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(Collections.singletonList(TipoDatoEnum.OPERACION_DEVOLUCION_ONLINE_IPOD_LOCALIZACION_SECCION.getId()), params.getValue(SQL_PARAM_IDS_TIPOS_DATO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    }

}
