package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVenta;

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
import org.slf4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class TareaLocalizacionVentaRepositoryCustomImplTest {

  private final static String SQL_UPDATE_ACTIVO_TRASLADAR = "SQL UPDATE ACTIVO TRASLADAR";

  private final static String SQL_SAVE = "SQL SAVE";

  private final static String SQL_UPDATE_ACTIVO = "SQL UPDATE ACTIVO";

  private final static String SQL_TOTALIZAR_OPERACIONES_SECCION = "SQL TOTALIZAR OPERACIONES SECCION";

  private final static String SQL_TOTALIZAR_OPERACIONES_LOCALIZACION = "SQL TOTALIZAR OPERACIONES LOCALIZACION";

  private final static String SQL_TOTALIZAR_PERSONAS_POR_VENTA = "SQL TOTALIZAR PERSONAS POR VENTA";

  private final static String SQL_CALCULAR_IMPORTE_COMISION_VENDEDORES = "SQL CALCULAR IMPORTE COMISION VENDEDORES";

  private final static String SQL_CALCULAR_IMPORTE_COMISION_VENTA_DEVOLUCION = "SQL CALCULAR IMORTE COMISION VENTA O DEVOLUCION";

  private final static String SQL_TOTALIZAR_DEVOLUCIONES_VENDEDOR_0 = "SQL TOTALIZAR DEVOLUCIONES VENDEDOR 0";

  private final static String SQL_REPARTO_DEVOLUCION_VENDEDOR_0 = "SQL REPARTO DEVOLUCION VENDEDOR 0";

  private final static String SQL_UPDATE_ACTIVO_MANUAL = "SQL UPDATE ACTIVO MANUAL";

  private final static String SQL_UPDATE_ACTIVO_MANUAL_NEGATIVO_TOTALIZADO = "SQL UPDATE ACTIVO MANUAL NEGATIVO TOTALIZADO";

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

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaLocalizacionVentaRepositoryCustom,
        "sqlSave", SQL_SAVE, true);
    FieldUtils.writeField(this.tareaLocalizacionVentaRepositoryCustom,
        "sqlUpdateActivo", SQL_UPDATE_ACTIVO, true);
    FieldUtils.writeField(this.tareaLocalizacionVentaRepositoryCustom,
        "sqlUpdateActivoTrasladadas", SQL_UPDATE_ACTIVO_TRASLADAR, true);
    FieldUtils.writeField(this.tareaLocalizacionVentaRepositoryCustom,
        "sqlTotalizarOperacionesLocalizacionSeccion", SQL_TOTALIZAR_OPERACIONES_SECCION, true);
    FieldUtils.writeField(this.tareaLocalizacionVentaRepositoryCustom,
        "sqlTotalizarOperacionesLocalizacion", SQL_TOTALIZAR_OPERACIONES_LOCALIZACION, true);
    FieldUtils.writeField(this.tareaLocalizacionVentaRepositoryCustom,
        "sqlTotalizarVentaPersonasPorVenta", SQL_TOTALIZAR_PERSONAS_POR_VENTA, true);
    FieldUtils.writeField(this.tareaLocalizacionVentaRepositoryCustom,
        "sqlCalcularImporteComisionVendedores", SQL_CALCULAR_IMPORTE_COMISION_VENDEDORES, true);
    FieldUtils.writeField(this.tareaLocalizacionVentaRepositoryCustom, "sqlTotalizarDevolucionesVendedor0",
        SQL_TOTALIZAR_DEVOLUCIONES_VENDEDOR_0, true);
    FieldUtils.writeField(this.tareaLocalizacionVentaRepositoryCustom, "sqlRepartoDevolucionVendedor0",
        SQL_REPARTO_DEVOLUCION_VENDEDOR_0, true);
    FieldUtils.writeField(this.tareaLocalizacionVentaRepositoryCustom, "sqlCalcularImporteComisionVentaODevolucion",
        SQL_CALCULAR_IMPORTE_COMISION_VENTA_DEVOLUCION, true);
    FieldUtils.writeField(this.tareaLocalizacionVentaRepositoryCustom, "sqlRepartoDevolucionVendedor0",
        SQL_REPARTO_DEVOLUCION_VENDEDOR_0, true);
    FieldUtils.writeField(this.tareaLocalizacionVentaRepositoryCustom, "sqlUpdateActivoManual",
        SQL_UPDATE_ACTIVO_MANUAL, true);
    FieldUtils.writeField(this.tareaLocalizacionVentaRepositoryCustom, "sqlUpdateActivoNegativoTotalizado",
        SQL_UPDATE_ACTIVO_MANUAL_NEGATIVO_TOTALIZADO, true);

    FieldUtils.writeField(this.tareaLocalizacionVentaRepositoryCustom,
        "batchSize", 100, true);
    FieldUtils.writeField(this.tareaLocalizacionVentaRepositoryCustom, "sqlUpdateActivoNegativoTotalizado",
        SQL_UPDATE_ACTIVO_MANUAL_NEGATIVO_TOTALIZADO, true);
  }

  @Test
  void saveTest() {
    final List<TareaLocalizacionVenta> items = Collections.singletonList(mock(TareaLocalizacionVenta.class));
    this.tareaLocalizacionVentaRepositoryCustom.save(items);
    verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(), any(SqlParameterSource[].class));
    assertEquals(SQL_SAVE, this.sqlCaptor.getValue());
  }

  @Test
  void updateActivoTest() {

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(3933L);
    final List<Integer> idsTipoDato = Arrays.asList(21, 39, 29, 22);

    this.tareaLocalizacionVentaRepositoryCustom.updateActivo(tarea,
        TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_VENTA,
        idsTipoDato);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_UPDATE_ACTIVO, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();

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
  void updateActivoTrasladadasTest() {

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(9090L);
    this.tareaLocalizacionVentaRepositoryCustom.updateActivoTrasladadas(tarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_UPDATE_ACTIVO_TRASLADAR, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();

    // Parámetros de la consulta: idTipoDatoVentaIpodLocalizacion,
    // idTipoDatoVentaIpodLocalizacionSeccion,
    // idTipoDatoVentaSINTLocalizacion, idTipoDatoVentaSINTLocalizacionSeccion,
    // idTipoDatoVentaEntregaTiendaLocalizacion,
    // idTipoDatoVentaEntregaTiendaLocalizacionSeccion, idTipoDatoVentaEntregaDomicilioLocalizacion,
    // idTipoDatoVentaEntregaDomicilioLocalizacionSeccion, idTipoDatoVentaIpodLocalizacionTrasladada,
    // idTipoDatoVentaIpodLocalizacionSeccionTrasladada, idTipoDatoVentaSINTLocalizacionTrasladada,
    // idTipoDatoVentaSINTLocalizacionSeccionTrasladada,
    // idTipoDatoVentaEntregaTiendaLocalizacionTrasladada,
    // idTipoDatoVentaEntregaTiendaLocalizacionSeccionTrasladada,
    // idTipoDatoVentaEntregaDomicilioLocalizacionTrasladada,
    // idTipoDatoVentaEntregaDomicilioLocalizacionSeccionTrasladada, idTarea, nuevoActivo
    assertEquals(18, params.getValues().size());
    // idTipoDatoVentaIpodLocalizacion
    assertTrue(params.hasValue("idTipoDatoVentaIpodLocalizacion"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION.getId(),
        params.getValue("idTipoDatoVentaIpodLocalizacion"));
    // idTipoDatoVentaIpodLocalizacionSeccion
    assertTrue(params.hasValue("idTipoDatoVentaIpodLocalizacionSeccion"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId(),
        params.getValue("idTipoDatoVentaIpodLocalizacionSeccion"));
    // idTipoDatoVentaSINTLocalizacion
    assertTrue(params.hasValue("idTipoDatoVentaSINTLocalizacion"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION.getId(),
        params.getValue("idTipoDatoVentaSINTLocalizacion"));
    // idTipoDatoVentaSINTLocalizacionSeccion
    assertTrue(params.hasValue("idTipoDatoVentaSINTLocalizacionSeccion"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION.getId(),
        params.getValue("idTipoDatoVentaSINTLocalizacionSeccion"));
    // idTipoDatoVentaEntregaTiendaLocalizacion
    assertTrue(params.hasValue("idTipoDatoVentaEntregaTiendaLocalizacion"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION.getId(),
        params.getValue("idTipoDatoVentaEntregaTiendaLocalizacion"));
    // idTipoDatoVentaEntregaTiendaLocalizacionSeccion
    assertTrue(params.hasValue("idTipoDatoVentaEntregaTiendaLocalizacionSeccion"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION.getId(),
        params.getValue("idTipoDatoVentaEntregaTiendaLocalizacionSeccion"));
    // idTipoDatoVentaEntregaDomicilioLocalizacion
    assertTrue(params.hasValue("idTipoDatoVentaEntregaDomicilioLocalizacion"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION.getId(),
        params.getValue("idTipoDatoVentaEntregaDomicilioLocalizacion"));
    // idTipoDatoVentaEntregaDomicilioLocalizacionSeccion
    assertTrue(params.hasValue("idTipoDatoVentaEntregaDomicilioLocalizacionSeccion"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION.getId(),
        params.getValue("idTipoDatoVentaEntregaDomicilioLocalizacionSeccion"));
    // idTipoDatoVentaIpodLocalizacionTrasladada
    assertTrue(params.hasValue("idTipoDatoVentaIpodLocalizacionTrasladada"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_TRASLADADA_DIA.getId(),
        params.getValue("idTipoDatoVentaIpodLocalizacionTrasladada"));
    // idTipoDatoVentaIpodLocalizacionSeccionTrasladada
    assertTrue(params.hasValue("idTipoDatoVentaIpodLocalizacionSeccionTrasladada"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(),
        params.getValue("idTipoDatoVentaIpodLocalizacionSeccionTrasladada"));
    // idTipoDatoVentaSINTLocalizacionTrasladada
    assertTrue(params.hasValue("idTipoDatoVentaSINTLocalizacionTrasladada"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_TRASLADADA_DIA.getId(),
        params.getValue("idTipoDatoVentaSINTLocalizacionTrasladada"));
    // idTipoDatoVentaSINTLocalizacionSeccionTrasladada
    assertTrue(params.hasValue("idTipoDatoVentaSINTLocalizacionSeccionTrasladada"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(),
        params.getValue("idTipoDatoVentaSINTLocalizacionSeccionTrasladada"));
    // idTipoDatoVentaEntregaTiendaLocalizacionTrasladada
    assertTrue(params.hasValue("idTipoDatoVentaEntregaTiendaLocalizacionTrasladada"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_TRASLADADA_DIA.getId(),
        params.getValue("idTipoDatoVentaEntregaTiendaLocalizacionTrasladada"));
    // idTipoDatoVentaEntregaTiendaLocalizacionSeccionTrasladada
    assertTrue(params.hasValue("idTipoDatoVentaEntregaTiendaLocalizacionSeccionTrasladada"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(),
        params.getValue("idTipoDatoVentaEntregaTiendaLocalizacionSeccionTrasladada"));
    // idTipoDatoVentaEntregaDomicilioLocalizacionTrasladada
    assertTrue(params.hasValue("idTipoDatoVentaEntregaDomicilioLocalizacionTrasladada"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_TRASLADADA_DIA.getId(),
        params.getValue("idTipoDatoVentaEntregaDomicilioLocalizacionTrasladada"));
    // idTipoDatoVentaEntregaDomicilioLocalizacionSeccionTrasladada
    assertTrue(params.hasValue("idTipoDatoVentaEntregaDomicilioLocalizacionSeccionTrasladada"));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION_TRASLADADA_DIA.getId(),
        params.getValue("idTipoDatoVentaEntregaDomicilioLocalizacionSeccionTrasladada"));
    // idTarea
    assertTrue(params.hasValue("idTarea"));
    assertEquals(tarea.getId(), params.getValue("idTarea"));
    // nuevoActivo
    assertTrue(params.hasValue("nuevoActivo"));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE, params.getValue("nuevoActivo"));

  }

  @Test
  void totalizarDevolucionLocalizacionTest() {

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(9090L);
    this.tareaLocalizacionVentaRepositoryCustom.totalizarDevolucionLocalizacion(tarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_TOTALIZAR_OPERACIONES_LOCALIZACION), this.paramsCaptor.capture());

    final Map<String, Object> params = this.paramsCaptor.getValue().getValues();

    final Map<String, Object> expected = new HashMap<>();
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO, TipoDatoEnum.DEVOLUCION_LOCALIZACION.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.DEVOLUCION_LOCALIZACION_TOTALIZADA.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_SECCION, AppConstants.SECCION_4);

    assertEquals(expected, params);

  }

  @Test
  void totalizarDevolucionLocalizacionSeccionTest() {

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(9090L);
    this.tareaLocalizacionVentaRepositoryCustom.totalizarDevolucionLocalizacionSeccion(tarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_TOTALIZAR_OPERACIONES_SECCION), this.paramsCaptor.capture());

    final Map<String, Object> params = this.paramsCaptor.getValue().getValues();

    final Map<String, Object> expected = new HashMap<>();
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO, TipoDatoEnum.DEVOLUCION_LOCALIZACION_SECCION.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.DEVOLUCION_LOCALIZACION_TOTALIZADA.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

    assertEquals(expected, params);

  }

  @ParameterizedTest
  @InstancioSource
  void totalizarVentaSinDevolucionLocalizacionTest(final TareaDto tarea) {

    this.tareaLocalizacionVentaRepositoryCustom.totalizarVentasSinDevolucionLocalizacionSeccion(tarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_TOTALIZAR_OPERACIONES_SECCION), this.paramsCaptor.capture());

    final Map<String, Object> params = this.paramsCaptor.getValue().getValues();

    final Map<String, Object> expected = new HashMap<>();
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO, TipoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION_TOTALIZADA.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

    assertEquals(expected, params);

  }

  @ParameterizedTest
  @InstancioSource
  void totalizarVentaSinDevolucionPersonasPorVenta(final TareaDto tarea) {

    this.tareaLocalizacionVentaRepositoryCustom.totalizarVentaSinDevolucionPersonasPorVenta(tarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_TOTALIZAR_PERSONAS_POR_VENTA), this.paramsCaptor.capture());
    final Map<String, Object> params = this.paramsCaptor.getValue().getValues();

    final Map<String, Object> expected = new HashMap<>();
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA,
        TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION_TOTALIZADA.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_EMPLEADOS_POR_VENTA.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_SECCION, AppConstants.SECCION_4);

    assertEquals(expected, params);

  }

  @Test
  void calcularImporteComisionVendedoresTest() {

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(123L);

    this.tareaLocalizacionVentaRepositoryCustom.calcularImporteComisionVendedores(tarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_CALCULAR_IMPORTE_COMISION_VENDEDORES), this.paramsCaptor.capture());
    final Map<String, Object> params = this.paramsCaptor.getValue().getValues();

    final Map<String, Object> expected = new HashMap<>();
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_PRESENCIA_LOCALIZACION_PERSONAS_POR_VENTA,
        TipoDatoEnum.PRESENCIA_LOCALIZACION_EMPLEADOS_POR_VENTA.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.VENTA_FISICA_IPOD_LOCALIZACION_SECCION.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_PRESENCIA_LOCALIZACION,
        TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_COMISION, AppConstants.PORCENTAJE_COMISION);
    expected.put(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO, TipoDatoEnum.IMPORTE_COMISION_VENDEDORES_POR_VENTA.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

    assertEquals(expected, params);

  }

  @Test
  void calcularImporteComisionVentaODevolucionTest() {

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(123L);

    this.tareaLocalizacionVentaRepositoryCustom.calcularImporteComisionVentaODevolucion(tarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_CALCULAR_IMPORTE_COMISION_VENTA_DEVOLUCION, this.sqlCaptor.getValue());
    final Map<String, Object> params = this.paramsCaptor.getValue().getValues();

    final Map<String, Object> expected = new HashMap<>();
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_DEVOLUCION_LOCALIZACION_SECCION,
        TipoDatoEnum.DEVOLUCION_LOCALIZACION_SECCION.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION,
        TipoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO, Arrays.asList(TipoDatoEnum.DEVOLUCION_LOCALIZACION_SECCION.getId(),
        TipoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION.getId()));
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_IMPORTE_COMISION_VENDEDORES,
        TipoDatoEnum.IMPORTE_COMISION_VENDEDORES_POR_VENTA.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

    assertEquals(expected, params);
  }

  @ParameterizedTest
  @InstancioSource
  void totalizarDevolucionesVendedor0Test(final TareaDto tarea) {

    this.tareaLocalizacionVentaRepositoryCustom.totalizarDevolucionesVendedor0(tarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_TOTALIZAR_DEVOLUCIONES_VENDEDOR_0), this.paramsCaptor.capture());
    final Map<String, Object> params = this.paramsCaptor.getValue().getValues();

    final Map<String, Object> expected = new HashMap<>();
    expected.put(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.DEVOLUCION_LOCALIZACION_TOTALIZADA.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_CALCULO, TipoCalculoEnum.POR_VENTA.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON_VENDEDOR_0, PtrConstants.VENDEDOR_0);
    expected.put(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_SECCION, AppConstants.SECCION_4);
    expected.put(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO, TipoDatoEnum.DEVOLUCION_VENDEDOR_0_LOCALIZACION_SECCION.getId());

    assertEquals(expected, params);
  }

  @ParameterizedTest
  @InstancioSource
  void repartoDevolucionVendedor0Test(final TareaDto tarea) {

    this.tareaLocalizacionVentaRepositoryCustom.repartoDevolucionVendedor0(tarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_REPARTO_DEVOLUCION_VENDEDOR_0), this.paramsCaptor.capture());
    final Map<String, Object> params = this.paramsCaptor.getValue().getValues();

    // Parámetros de la consulta: idTipoDatoIndicadorPresencia, activo, idTarea, nuevoIdTipoDato,
    // nuevoActivo, idTipoImporteVenta, idTipoGrupoDato
    final Map<String, Object> expected = new HashMap<>();
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA,
        TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA, TipoDatoEnum.DEVOLUCION_VENDEDOR_0_LOCALIZACION_SECCION.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO, TipoDatoEnum.REPARTO_DEVOLUCION_VENDEDOR_0_LOCALIZACION_SECCION.getId());

    assertEquals(expected, params);

  }

  @Test
  void updateActivoManualTest() {

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(123L);

    this.tareaLocalizacionVentaRepositoryCustom.updateActivoManual(tarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_UPDATE_ACTIVO_MANUAL, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();

    // Parámetros de la consulta: idTipoDatoIndicadorPresencia, activo, idTarea, nuevoIdTipoDato,
    // nuevoActivo, idTipoImporteVenta
    assertEquals(4, params.getValues().size());
    // idTipoDatoIndicadorPresencia
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO));
    assertEquals(TipoGrupoDatoEnum.VENTA_REAL_LOCALIZACION_SECCION.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO));
    // activo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
        params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
    // idTarea
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    // nuevoIdTipoDato
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_LOCALIZACION_VENTA_MANUAL));
    assertEquals(TipoDatoEnum.VENTA_MANUAL_LOCALIZACION_SECCION.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_LOCALIZACION_VENTA_MANUAL));

  }

  @Test
  void updateActivoNegativoTotalizadoTest() {

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(123L);

    this.tareaLocalizacionVentaRepositoryCustom.updateActivoNegativoTotalizado(tarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_UPDATE_ACTIVO_MANUAL_NEGATIVO_TOTALIZADO, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();

    // Parámetros de la consulta: idTarea, activo, inactivo, idTipoGrupoDato,
    // idsTiposDato
    assertEquals(5, params.getValues().size());

    // idTarea
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    // activo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    // inactivo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
        params.getValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
    // idTipoGrupoDato
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO));
    assertEquals(TipoGrupoDatoEnum.VENTA_REAL_LOCALIZACION_SECCION.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO));
    // idsTiposDato
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO));
    assertEquals(Collections.singletonList(TipoDatoEnum.VENTA_MANUAL_LOCALIZACION_SECCION.getId()),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO));

  }

}
