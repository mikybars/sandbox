package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ABIERTO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ACTIVO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_FECHA_FIN;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_CONCEPTO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_SECCION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TAREA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_MINUTOS;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_INCLUSION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_PORCENTAJE_CERO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.Arrays;

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
class TareaAgrupacionPresenciaRepositoryCustomImplTest {

  private final static String SQL_TOTALIZAR = "SQL TOTALIZAR";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private TareaAgrupacionPresenciaRepositoryCustomImpl tareaAgrupacionPresenciaRepositoryCustom;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaAgrupacionPresenciaRepositoryCustom, "sqlTotalizar", SQL_TOTALIZAR, true);
  }

  @Test
  void calcularPresenciasTotalesAgrupacionTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(890L);
    tarea.setFechaFinPeriodo(LocalDate.of(2020, 8, 31));
    this.tareaAgrupacionPresenciaRepositoryCustom.calcularPresenciasTotalesAgrupacion(tarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_TOTALIZAR, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: nuevoActivo, nuevoIdTipoDato, idConcepto, porcentajeInclusion,
    // idTarea, activo, idSeccion, idTipoPresencia, abierto, fechaFin
    assertEquals(10, params.getValues().size());
    // nuevoActivo
    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));
    // nuevoIdTipoDato
    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
    assertEquals(TipoDatoEnum.PRESENCIA_AGRUPACIONONLINE_INCLUIDOECOMMERCE.getId(),
        params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
    // idConcepto
    assertTrue(params.hasValue(SQL_PARAM_ID_CONCEPTO));
    assertEquals(Arrays.asList(TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS.getId()),
        params.getValue(SQL_PARAM_ID_CONCEPTO));
    // porcentajeInclusion
    assertTrue(params.hasValue(SQL_PARAM_PORCENTAJE_INCLUSION));
    assertEquals(SQL_VALUE_PORCENTAJE_CERO, params.getValue(SQL_PARAM_PORCENTAJE_INCLUSION));
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
    // activo
    assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    // idSeccion
    assertTrue(params.hasValue(SQL_PARAM_ID_SECCION));
    assertEquals(AppConstants.SECCION_4, params.getValue(SQL_PARAM_ID_SECCION));
    // idTipoPresencia
    assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_MINUTOS));
    assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDOECOMMERCE.getId(),
        params.getValue(SQL_PARAM_ID_TIPO_MINUTOS));
    // abierto
    assertTrue(params.hasValue(SQL_PARAM_ABIERTO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ABIERTO));
    // fechaFin
    assertTrue(params.hasValue(SQL_PARAM_FECHA_FIN));
    assertEquals(TimeUtils.toDate(LocalDate.of(2020, 8, 31)), params.getValue(SQL_PARAM_FECHA_FIN));
  }

}
