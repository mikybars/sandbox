package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresupuestoVenta;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaLocalizacionPresupuestoVentaRepositoryCustomImplTest {

  private final static String SQL_SAVE = "SQL SAVE";

  private final static String SQL_UPDATE_ACTIVO_EXCEPCIONADA = "SQL_UPDATE_ACTIVO_EXCEPCIONADA";

  private final static String SQL_UPDATE_ACTIVO_CONGELADA = "SQL_UPDATE_ACTIVO_CONGELADA";

  private final static String SQL_TOTALIZAR = "SQL_TOTALIZAR";

  @Mock
  private JdbcTemplate template;

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private TareaLocalizacionPresupuestoVentaRepositoryCustomImpl tareaLocalizacionPresupuestoVentaRepositoryCustom;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaLocalizacionPresupuestoVentaRepositoryCustom, "sqlSave", SQL_SAVE, true);
    FieldUtils.writeField(this.tareaLocalizacionPresupuestoVentaRepositoryCustom, "sqlUpdateActivoExcepcionada",
        SQL_UPDATE_ACTIVO_EXCEPCIONADA, true);
    FieldUtils.writeField(this.tareaLocalizacionPresupuestoVentaRepositoryCustom, "sqlUpdateActivoCongelada",
        SQL_UPDATE_ACTIVO_CONGELADA, true);
    FieldUtils.writeField(this.tareaLocalizacionPresupuestoVentaRepositoryCustom, "sqlTotalizar", SQL_TOTALIZAR,
        true);
    FieldUtils.writeField(this.tareaLocalizacionPresupuestoVentaRepositoryCustom, "batchSize", 100, true);
  }

  @Test
  public void save() {
    final List<TareaLocalizacionPresupuestoVenta> items = Collections
        .singletonList(mock(TareaLocalizacionPresupuestoVenta.class));
    this.tareaLocalizacionPresupuestoVentaRepositoryCustom.save(items);
    verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(), any(SqlParameterSource[].class));
    assertEquals(SQL_SAVE, this.sqlCaptor.getValue());
  }

  @Test
  public void updateActivoExcepcionada() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setId(1L);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaLocalizacionPresupuestoVentaRepositoryCustom.updateActivoExcepcionada(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_UPDATE_ACTIVO_EXCEPCIONADA, this.sqlCaptor.getValue());
    // Parametros de la consulta: idTarea, activo, inactivo
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(3, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    // activo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    // inactivo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
        params.getValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
  }

  @Test
  public void updateActivoCongelada() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setId(1L);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaLocalizacionPresupuestoVentaRepositoryCustom.updateActivoCongelada(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_UPDATE_ACTIVO_CONGELADA, this.sqlCaptor.getValue());
    // Parametros de la consulta: idTarea, activo, inactivo
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(5, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    // activo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    // inactivo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
        params.getValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
    // id tipo dato grupo dato venta congelada
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_CONGELADA));
    assertEquals(Arrays.asList(TipoDatoEnum.VENTA_RANGO_CONGELADA_LOCALIZACION.getId(),
        TipoDatoEnum.VENTA_RANGO_CONGELADA_LOCALIZACION_SECCION.getId()),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_CONGELADA));
    // id tipo grupo dato venta real
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_REAL));
    assertEquals(Arrays.asList(TipoDatoEnum.VENTA_RANGO_LOCALIZACION.getId(),
        TipoDatoEnum.VENTA_RANGO_LOCALIZACION_SECCION.getId()),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_REAL));
  }

  @Test
  public void totalizar() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setId(1L);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaLocalizacionPresupuestoVentaRepositoryCustom.totalizar(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_TOTALIZAR, this.sqlCaptor.getValue());
    // Parametros de la consulta: idTarea, activo, inactivo
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(9, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    // activo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    // id tipo dato grupo dato venta congelada
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO_VENTA_CONGELADA));
    assertEquals(TipoGrupoDatoEnum.VENTA_RANGO_CONGELADA.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO_VENTA_CONGELADA));
    // id tipo grupo dato venta real
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO_VENTA_REAL));
    assertEquals(TipoGrupoDatoEnum.VENTA_RANGO.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO_VENTA_REAL));
    // id seccion
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION));
    assertEquals(AppConstants.SECCION_4, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION));
    // id tipo dato venta rango congelada localizacion
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_RANGO_CONGELADA_LOCALIZACION));
    assertEquals(TipoDatoEnum.VENTA_RANGO_CONGELADA_LOCALIZACION.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_RANGO_CONGELADA_LOCALIZACION));
    // id tipo dato venta rango congelada localizacion seccion
    assertTrue(
        params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_RANGO_CONGELADA_LOCALIZACION_SECCION));
    assertEquals(TipoDatoEnum.VENTA_RANGO_CONGELADA_LOCALIZACION_SECCION.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_RANGO_CONGELADA_LOCALIZACION_SECCION));
    // id tipo dato venta rango localizacion
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_RANGO_LOCALIZACION));
    assertEquals(TipoDatoEnum.VENTA_RANGO_LOCALIZACION.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_RANGO_LOCALIZACION));
    // id tipo dato venta rango localizacion seccion
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_RANGO_LOCALIZACION_SECCION));
    assertEquals(TipoDatoEnum.VENTA_RANGO_LOCALIZACION_SECCION.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_RANGO_LOCALIZACION_SECCION));
  }

}
