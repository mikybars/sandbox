package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ABIERTO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ACTIVO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_SECCION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TAREA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_DEVOLUCION_LOCALIZACION_SECCION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_SECCION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_NUEVO_IMPORTE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_IMPORTE_CERO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaVenta;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class TareaLocalizacionPersonaVentaRepositoryCustomImplTest {

  private final static String SQL_SAVE = "SAVE";

  private final static String SQL_TOTALIZAR_VENTA_PERSONA_LOCALIZACION = "SQL_TOTALIZAR_VENTA_PERSONA_LOCALIZACION";

  private final static String SQL_DEVOLUCION_IMPORTE_0 = "SQL DEVOLUCION IMPORTE 0";

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

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaLocalizacionPersonaVentaRepositoryCustom, "sqlTotalizarVentaPersonaLocalizacion",
        SQL_TOTALIZAR_VENTA_PERSONA_LOCALIZACION, true);
    FieldUtils.writeField(this.tareaLocalizacionPersonaVentaRepositoryCustom, "sqlDevolucionImporte0",
        SQL_DEVOLUCION_IMPORTE_0, true);
    FieldUtils.writeField(this.tareaLocalizacionPersonaVentaRepositoryCustom, "sqlTotalizarVentaPersonaSeccion",
        SQL_TOTALIZAR_VENTA_PERSONA_SECCION, true);
    FieldUtils.writeField(this.tareaLocalizacionPersonaVentaRepositoryCustom, "sqlSave", SQL_SAVE, true);
    FieldUtils.writeField(this.tareaLocalizacionPersonaVentaRepositoryCustom, "batchSize", 100, true);
  }

  @Test
  void saveTest() {
    final List<TareaLocalizacionPersonaVenta> items = Collections
        .singletonList(mock(TareaLocalizacionPersonaVenta.class));
    this.tareaLocalizacionPersonaVentaRepositoryCustom.save(items);
    verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(), any(SqlParameterSource[].class));
    assertEquals(SQL_SAVE, this.sqlCaptor.getValue());
  }

  @ParameterizedTest
  @InstancioSource
  void totalizarDevolucionPersonaSeccionTest( final TareaDto tarea,
       final List<IdTipoDatoDto> tiposDato) {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class))).thenReturn(tiposDato);

    this.tareaLocalizacionPersonaVentaRepositoryCustom.totalizarDevolucionPersonaLocalizacion(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_TOTALIZAR_VENTA_PERSONA_LOCALIZACION), this.paramsCaptor.capture());
    verify(this.tipoDatoService, times(1)).findTipoDatoByTipoGrupoDato(
        TipoGrupoDatoEnum.DEVOLUCION_LOCALIZACION_TOTALIZADA.getId());

    final Map<String, Object> params = this.paramsCaptor.getValue().getValues();

    final Map<String, Object> expected = new HashMap<>();
    expected.put(SQL_PARAM_ID_TAREA, tarea.getId());
    expected.put(SQL_PARAM_NUEVO_ID_TIPO_DATO, TipoDatoEnum.DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION.getId());
    expected.put(SQL_PARAM_IDS_TIPOS_DATO, tiposDato.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
    expected.put(SQL_PARAM_ACTIVO, SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SQL_PARAM_NUEVO_ACTIVO, SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SQL_PARAM_NUEVO_ID_SECCION, AppConstants.SECCION_4);

    assertEquals(expected, params);

  }

  @ParameterizedTest
    @InstancioSource
  void totalizarVentaSinDevolucionPersonaSeccionTest(final TareaDto tarea,
      final List<IdTipoDatoDto> tiposDato) {

    when(this.tipoDatoService.findTipoDatoByTipoGrupoDato(any(Integer.class))).thenReturn(tiposDato);

    this.tareaLocalizacionPersonaVentaRepositoryCustom.totalizarVentaSinDevolucionPersonaLocalizacion(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_TOTALIZAR_VENTA_PERSONA_LOCALIZACION), this.paramsCaptor.capture());
    verify(this.tipoDatoService, times(1)).findTipoDatoByTipoGrupoDato(
        TipoGrupoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION_TOTALIZADA.getId());

    final Map<String, Object> params = this.paramsCaptor.getValue().getValues();

    final Map<String, Object> expected = new HashMap<>();
    expected.put(SQL_PARAM_ID_TAREA, tarea.getId());
    expected.put(SQL_PARAM_NUEVO_ID_TIPO_DATO, TipoDatoEnum.VENTA_SIN_DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION.getId());
    expected.put(SQL_PARAM_IDS_TIPOS_DATO, tiposDato.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
    expected.put(SQL_PARAM_ACTIVO, SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SQL_PARAM_NUEVO_ACTIVO, SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SQL_PARAM_NUEVO_ID_SECCION, AppConstants.SECCION_4);

    assertEquals(expected, params);
  }

  @ParameterizedTest
  @InstancioSource
  void devolucionImporte0Test(final TareaDto tarea) {

    this.tareaLocalizacionPersonaVentaRepositoryCustom.devolucionImporte0(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_DEVOLUCION_IMPORTE_0), this.paramsCaptor.capture());

    final Map<String, Object> expected = new HashMap<>();
    expected.put(SQL_PARAM_ID_TAREA, tarea.getId());
    expected.put(SQL_PARAM_ID_TIPO_DATO_DEVOLUCION_LOCALIZACION_SECCION, TipoDatoEnum.DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION.getId());
    expected.put(SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
    expected.put(SQL_PARAM_ABIERTO, SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SQL_PARAM_NUEVO_IMPORTE, SQL_VALUE_IMPORTE_CERO);
    expected.put(SQL_PARAM_NUEVO_ID_TIPO_DATO, TipoDatoEnum.DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION.getId());
    expected.put(SQL_PARAM_NUEVO_ACTIVO, SQL_VALUE_BOOLEAN_TRUE);

    assertEquals(expected, this.paramsCaptor.getValue().getValues());

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
