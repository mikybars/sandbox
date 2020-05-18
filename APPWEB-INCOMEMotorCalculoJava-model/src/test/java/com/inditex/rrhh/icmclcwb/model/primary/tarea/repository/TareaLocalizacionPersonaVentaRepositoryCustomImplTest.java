package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaVenta;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ACTIVO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TAREA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        FieldUtils.writeField(this.tareaLocalizacionPersonaVentaRepositoryCustom, "sqlTotalizarVentaPersonaSeccion",
                SQL_TOTALIZAR_VENTA_PERSONA_SECCION, true);
        FieldUtils.writeField(this.tareaLocalizacionPersonaVentaRepositoryCustom, "sqlSave", SQL_SAVE, true);
        FieldUtils.writeField(this.tareaLocalizacionPersonaVentaRepositoryCustom, "batchSize", 100, true);
    }

    @Test
    public void saveTest() {
        final List<TareaLocalizacionPersonaVenta> items = Collections
            .singletonList(mock(TareaLocalizacionPersonaVenta.class));
        this.tareaLocalizacionPersonaVentaRepositoryCustom.save(items);
        verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(), any(SqlParameterSource[].class));
        assertEquals(SQL_SAVE, this.sqlCaptor.getValue());
    }

    @Test
    public void totalizarVentaPersonaSeccionTest() {

        final TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(9392L);
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class))).thenReturn(
                Arrays.asList(
                        IdTipoDatoDto.builder().id(1001).build(),
                        IdTipoDatoDto.builder().id(1002).build()));

        this.tareaLocalizacionPersonaVentaRepositoryCustom.totalizarVentaPersonaSeccion(tarea);

        verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
        verify(this.tipoDatoService, times(1))
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.OPERACIONES_VENTA_INDIVIDUAL_LOCALIZACION_SECCION.getId());

        assertEquals(SQL_TOTALIZAR_VENTA_PERSONA_SECCION, this.sqlCaptor.getValue());
        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        // Parámetros de la consulta: nuevoIdTipoDato, nuevoActivo, idTarea, tiposDato, activo
        assertEquals(5, params.getValues().size());
        // nuevoIdTipoDato
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.VENTA_INDIVIDUAL_LOCALIZACION_SECCION.getId(),
                params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // nuevoActivo
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // tiposDato
        assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(Arrays.asList(1001, 1002), params.getValue(SQL_PARAM_IDS_TIPOS_DATO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    }

    @Test
    public void totalizarDevolucionPersonaSeccionTest() {

        final TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(9392L);
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class))).thenReturn(
                Arrays.asList(
                        IdTipoDatoDto.builder().id(1001).build(),
                        IdTipoDatoDto.builder().id(1002).build()));

        this.tareaLocalizacionPersonaVentaRepositoryCustom.totalizarDevolucionPersonaSeccion(tarea);
        verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
        verify(this.tipoDatoService, times(1))
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.DEVOLUCION_LOCALIZACION_TOTALIZADA.getId());

        assertEquals(SQL_TOTALIZAR_VENTA_PERSONA_SECCION, this.sqlCaptor.getValue());
        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        // Parámetros de la consulta: nuevoIdTipoDato, nuevoActivo, idTarea, tiposDato, activo
        assertEquals(5, params.getValues().size());
        // nuevoIdTipoDato
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION.getId(),
                params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // nuevoActivo
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // tiposDato
        assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(Arrays.asList(1001, 1002), params.getValue(SQL_PARAM_IDS_TIPOS_DATO));
        // activo
        assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    }


    @Test
    public void totalizarVentaSinDevolucionPersonaSeccionTest() {

        final TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(9392L);
        when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class))).thenReturn(
                Arrays.asList(
                        IdTipoDatoDto.builder().id(1001).build(),
                        IdTipoDatoDto.builder().id(1002).build()));

        this.tareaLocalizacionPersonaVentaRepositoryCustom.totalizarVentaSinDevolucionPersonaSeccion(tarea);
        verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
        verify(this.tipoDatoService, times(1)).findTipoDatoByTipoGrupoDato(
                TipoGrupoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION_TOTALIZADA.getId());

        assertEquals(SQL_TOTALIZAR_VENTA_PERSONA_SECCION, this.sqlCaptor.getValue());
        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        // Parámetros de la consulta: nuevoIdTipoDato, nuevoActivo, idTarea, tiposDato, activo
        assertEquals(5, params.getValues().size());
        // nuevoIdTipoDato
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.VENTA_SIN_DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION.getId(),
                params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // nuevoActivo
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // tiposDato
        assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(Arrays.asList(1001, 1002), params.getValue(SQL_PARAM_IDS_TIPOS_DATO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    }

    @Test
    public void totalizarVentaIpodSinDevolucionPersonaSeccionTest() {

        final TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(9392L);

        this.tareaLocalizacionPersonaVentaRepositoryCustom.totalizarVentaOnlineIpodSinDevolucionPersonaSeccion(tarea);
        verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
        verify(this.tipoDatoService, never()).findTipoDatoByTipoGrupoDato(any(Integer.class));

        assertEquals(SQL_TOTALIZAR_VENTA_PERSONA_SECCION, this.sqlCaptor.getValue());
        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        // Parámetros de la consulta: nuevoIdTipoDato, nuevoActivo, idTarea, tiposDato, activo
        assertEquals(5, params.getValues().size());
        // nuevoIdTipoDato
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.VENTA_ONLINE_IPOD_SIN_DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION.getId(),
                params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // nuevoActivo
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // tiposDato
        assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(Collections.singletonList(TipoDatoEnum.OPERACION_VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId()),
                params.getValue(SQL_PARAM_IDS_TIPOS_DATO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    }

    @Test
    public void totalizarVentaFisicaSinDevolucionPersonaSeccionTest() {

        final TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(9392L);

        this.tareaLocalizacionPersonaVentaRepositoryCustom.totalizarVentaFisicaSinDevolucionPersonaSeccion(tarea);
        verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
        verify(this.tipoDatoService, never()).findTipoDatoByTipoGrupoDato(any(Integer.class));

        assertEquals(SQL_TOTALIZAR_VENTA_PERSONA_SECCION, this.sqlCaptor.getValue());
        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        // Parámetros de la consulta: nuevoIdTipoDato, nuevoActivo, idTarea, tiposDato, activo
        assertEquals(5, params.getValues().size());
        // nuevoIdTipoDato
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.VENTA_FISICA_SIN_DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION.getId(),
                params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // nuevoActivo
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // tiposDato
        assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(Collections.singletonList(TipoDatoEnum.OPERACION_VENTA_FISICA_LOCALIZACION_SECCION.getId()),
                params.getValue(SQL_PARAM_IDS_TIPOS_DATO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    }

    @Test
    public void totalizarDevolucionFisicaPersonaSeccionTest() {

        final TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(9392L);

        this.tareaLocalizacionPersonaVentaRepositoryCustom.totalizarDevolucionFisicaPersonaSeccion(tarea);
        verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
        verify(this.tipoDatoService, never()).findTipoDatoByTipoGrupoDato(any(Integer.class));

        assertEquals(SQL_TOTALIZAR_VENTA_PERSONA_SECCION, this.sqlCaptor.getValue());
        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        // Parámetros de la consulta: nuevoIdTipoDato, nuevoActivo, idTarea, tiposDato, activo
        assertEquals(5, params.getValues().size());
        // nuevoIdTipoDato
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.DEVOLUCION_FISICA_INDIVIDUAL_LOCALIZACION_SECCION.getId(),
                params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // nuevoActivo
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // tiposDato
        assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(Collections.singletonList(TipoDatoEnum.OPERACION_DEVOLUCION_FISICA_LOCALIZACION_SECCION.getId()),
                params.getValue(SQL_PARAM_IDS_TIPOS_DATO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    }

    @Test
    public void totalizarDevolucionIpodPersonaSeccionTest() {

        final TareaDto tarea = mock(TareaDto.class);
        when(tarea.getId()).thenReturn(9392L);

        this.tareaLocalizacionPersonaVentaRepositoryCustom.totalizarDevolucionOnlineIpodPersonaSeccion(tarea);
        verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
        verify(this.tipoDatoService, never()).findTipoDatoByTipoGrupoDato(any(Integer.class));

        assertEquals(SQL_TOTALIZAR_VENTA_PERSONA_SECCION, this.sqlCaptor.getValue());
        final MapSqlParameterSource params = this.paramsCaptor.getValue();
        // Parámetros de la consulta: nuevoIdTipoDato, nuevoActivo, idTarea, tiposDato, activo
        assertEquals(5, params.getValues().size());
        // nuevoIdTipoDato
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        assertEquals(TipoDatoEnum.DEVOLUCION_ONLINE_IPOD_INDIVIDUAL_LOCALIZACION_SECCION.getId(),
                params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
        // nuevoActivo
        assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
        assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
        // tiposDato
        assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_DATO));
        assertEquals(
                Collections.singletonList(TipoDatoEnum.OPERACION_DEVOLUCION_ONLINE_IPOD_LOCALIZACION_SECCION.getId()),
                params.getValue(SQL_PARAM_IDS_TIPOS_DATO));
        // idTarea
        assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
        assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    }

}
