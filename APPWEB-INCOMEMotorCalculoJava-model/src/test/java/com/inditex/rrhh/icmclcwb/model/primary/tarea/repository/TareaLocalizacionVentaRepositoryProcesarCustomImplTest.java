package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ABIERTO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ACTIVO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_FECHA_FIN;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_CONCEPTO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_SECCION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TAREA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_FISICA_LOCALIZACION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_AGRUPACION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_FISICA_AGRUPACION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_PRESENCIA_AGRUPACIONONLINE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_PRESENCIA_LOCALIZACION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_SECCION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_INCLUSION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_PORCENTAJE_CERO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaLocalizacionVentaRepositoryProcesarCustomImplTest {

  private final static String SQL_PROCESAR_REPARTO_ENTREGA_DOMICILIO_AGRUPACIONES = "PROCESAR REPARTO ENTREGA DOMICILIO AGRUPACIONES";

  private final static String SQL_PROCESAR_REPARTO_ETNREGA_DOMICILIO_POR_PRESENCIA_AGRUPACIONES =
      "PROCESAR REPARTO ENTREGA DOMICILIO POR PRESENCIA AGRUPACIONES";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private TareaLocalizacionVentaRepositoryProcesarCustomImpl tareaLocalizacionVentaRepositoryProcesarCustom;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaLocalizacionVentaRepositoryProcesarCustom,
        "sqlProcesarEntregaDomicilioPorVentasAgrupaciones", SQL_PROCESAR_REPARTO_ENTREGA_DOMICILIO_AGRUPACIONES,
        true);
    FieldUtils.writeField(this.tareaLocalizacionVentaRepositoryProcesarCustom,
        "sqlProcesarEntregaDomicilioPresenciaAgrupaciones",
        SQL_PROCESAR_REPARTO_ETNREGA_DOMICILIO_POR_PRESENCIA_AGRUPACIONES, true);
  }

  @Test
  public void procesarRepartoEntregaDomicilioPorVentasAgrupacionesTest() {

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(7474L);
    when(tarea.getFechaFinPeriodo()).thenReturn(LocalDate.of(2020, 8, 31));

    this.tareaLocalizacionVentaRepositoryProcesarCustom.procesarRepartoEntregaDomicilioPorVentasAgrupaciones(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_PROCESAR_REPARTO_ENTREGA_DOMICILIO_AGRUPACIONES, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: nuevoIdTipoDato, nuevoActivo, idTipoImporteVentaFisicaAgrupacion,
    // idTipoImporteVentaEntregaDomicilioAgrupacion, idTarea, idTipoImporteVentaFisicaLocalizacion,
    // idSeccion, fechaFin, abierto, activo, idConcepto, porcentajeInclusion
    assertEquals(12, params.getValues().size());
    // nuevoIdTipoDato,
    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION.getId(),
        params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
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
    assertEquals(TipoDatoEnum.VENTA_FISICA_LOCALIZACION.getId(),
        params.getValue(SQL_PARAM_ID_TIPO_DATO_VENTA_FISICA_LOCALIZACION));
    // idSeccion
    assertTrue(params.hasValue(SQL_PARAM_ID_SECCION));
    assertEquals(AppConstants.SECCION_4, params.getValue(SQL_PARAM_ID_SECCION));
    // idConcepto
    assertTrue(params.hasValue(SQL_PARAM_ID_CONCEPTO));
    assertEquals(TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_VENTA.getId(), params.getValue(SQL_PARAM_ID_CONCEPTO));
    // porcentajeInclusion
    assertTrue(params.hasValue(SQL_PARAM_PORCENTAJE_INCLUSION));
    assertEquals(SQL_VALUE_PORCENTAJE_CERO, params.getValue(SQL_PARAM_PORCENTAJE_INCLUSION));
    // fechaFin
    assertTrue(params.hasValue(SQL_PARAM_FECHA_FIN));
    assertEquals(TimeUtils.toDate(tarea.getFechaFinPeriodo()), params.getValue(SQL_PARAM_FECHA_FIN));
    // abierto
    assertTrue(params.hasValue(SQL_PARAM_ABIERTO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ABIERTO));
    // activo
    assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
  }

  @Test
  public void procesarRepartoEntregaDomicilioPorPresenciaAgrupacionesTest() {

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(7474L);
    when(tarea.getFechaFinPeriodo()).thenReturn(LocalDate.of(2020, 8, 31));

    this.tareaLocalizacionVentaRepositoryProcesarCustom
        .procesarRepartoEntregaDomicilioPorPresenciaAgrupaciones(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_PROCESAR_REPARTO_ETNREGA_DOMICILIO_POR_PRESENCIA_AGRUPACIONES, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: nuevoIdTipoDato, nuevoActivo, idTipoPresenciaLocalizacion, activo,
    // idTipoPresenciaAgrupacion, idTipoImporteVentaEntregaDomicilioAgrupacion, idTarea,
    // idTipoImporteVentaFisicaLocalizacion, idSeccion, abierto, fechaFin
    // idConcepto, porcentajeInclusion, nuevoIdSeccion
    assertEquals(14, params.getValues().size());
    // nuevoIdTipoDato,
    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION.getId(),
        params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
    // nuevoActivo
    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));
    // idTipoPresenciaLocalizacion
    assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_PRESENCIA_LOCALIZACION));
    assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDOECOMMERCE.getId(),
        params.getValue(SQL_PARAM_ID_TIPO_PRESENCIA_LOCALIZACION));
    // activo
    assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    // idTipoPresenciaAgrupacion
    assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_PRESENCIA_AGRUPACIONONLINE));
    assertEquals(TipoDatoEnum.PRESENCIA_AGRUPACIONONLINE_INCLUIDOECOMMERCE.getId(),
        params.getValue(SQL_PARAM_ID_TIPO_PRESENCIA_AGRUPACIONONLINE));
    // idTipoImporteVentaEntregaDomicilioAgrupacion
    assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_AGRUPACION));
    assertEquals(TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_AGRUPACIONONLINE.getId(),
        params.getValue(SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_AGRUPACION));
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
    // idTipoImporteVentaFisicaLocalizacion
    assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_DATO_VENTA_FISICA_LOCALIZACION));
    assertEquals(TipoDatoEnum.VENTA_FISICA_LOCALIZACION.getId(),
        params.getValue(SQL_PARAM_ID_TIPO_DATO_VENTA_FISICA_LOCALIZACION));
    // idSeccion
    assertTrue(params.hasValue(SQL_PARAM_ID_SECCION));
    assertEquals(AppConstants.SECCION_4, params.getValue(SQL_PARAM_ID_SECCION));
    // idConcepto
    assertTrue(params.hasValue(SQL_PARAM_ID_CONCEPTO));
    assertEquals(TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS.getId(),
        params.getValue(SQL_PARAM_ID_CONCEPTO));
    // porcentajeInclusion
    assertTrue(params.hasValue(SQL_PARAM_PORCENTAJE_INCLUSION));
    assertEquals(SQL_VALUE_PORCENTAJE_CERO, params.getValue(SQL_PARAM_PORCENTAJE_INCLUSION));
    // nuevoIdSeccion
    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_SECCION));
    assertEquals(AppConstants.SECCION_4, params.getValue(SQL_PARAM_NUEVO_ID_SECCION));
    // fechaFin
    assertTrue(params.hasValue(SQL_PARAM_FECHA_FIN));
    assertEquals(TimeUtils.toDate(tarea.getFechaFinPeriodo()), params.getValue(SQL_PARAM_FECHA_FIN));
    // abierto
    assertTrue(params.hasValue(SQL_PARAM_ABIERTO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ABIERTO));
  }

}
