package com.inditex.rrhh.icmclcwb.model.primary.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class PrimaryTemporaryTablePorVentaRepositoryCustomTest {

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Mock
  private JdbcTemplate jdbcTemplate;

  @InjectMocks
  private PrimaryTemporaryTablePorVentaRepositoryCustomImpl primaryTemporaryTablePorVentaRepositoryCustom;

  // Venta fisica localizacion seccion
  private final static String SQL_CREATE_TEMP_VENTA_FISICA_LOCALIZACION_SECCION = "SQL CREATE TEMP VENTA FISICA LOCALIZACION SECCION";

  private final static String SQL_CREATE_INDEX_TEMP_VENTA_FISICA_LOCALIZACION_SECCION =
      "SQL CREATE INDEX TEMP VENTA FISICA LOCALIZACION SECCION";

  private final static String SQL_INSERT_TEMP_VENTA_FISICA_LOCALIZACION_SECCION = "SQL INSERT TEMP VENTA FISICA LOCALIZACION SECCION";

  private final static String SQL_DELETE_TEMP_VENTA_FISICA_LOCALIZACION_SECCION = "SQL DELETE TEMP VENTA FISICA LOCALIZACION SECCION";

  // Venta física localización
  private final static String SQL_INSERT_TEMP_VENTA_FISICA_LOCALIZACION = "SQL INSERT TEMP VENTA FISICA LOCALIZACION";

  // fechas estructuras por venta
  private final static String SQL_CREATE_TEMP_DATES_ESTRUCTURAS_POR_VENTA = "SQL CREATE TEMP DATES_ESTRUCTURAS_POR_VENTA";

  private final static String SQL_INDEX_TEMP_DATES_ESTRUCTURAS_POR_VENTA = "SQL INDEX TEMP DATES_ESTRUCTURAS_POR_VENTA";

  private final static String SQL_DELETE_TEMP_DATES_ESTRUCTURAS_POR_VENTA = "SQL DELETE TEMP DATES_ESTRUCTURAS_POR_VENTA";

  private final static String SQL_INSERT_TEMP_DATES_ESTRUCTURAS_POR_VENTA = "SQL INSERT TEMP DATES_ESTRUCTURAS_POR_VENTA";

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.primaryTemporaryTablePorVentaRepositoryCustom, "batchSize", 3, true);

    // venta fisica localizacion seccion
    FieldUtils.writeField(this.primaryTemporaryTablePorVentaRepositoryCustom,
        "sqlCreateTempVentaFisicaLocalizacionSeccion", SQL_CREATE_TEMP_VENTA_FISICA_LOCALIZACION_SECCION, true);
    FieldUtils.writeField(this.primaryTemporaryTablePorVentaRepositoryCustom,
        "sqlCreateIndexTempVentaFisicaLocalizacionSeccion", SQL_CREATE_INDEX_TEMP_VENTA_FISICA_LOCALIZACION_SECCION, true);
    FieldUtils.writeField(this.primaryTemporaryTablePorVentaRepositoryCustom,
        "sqlInsertTempVentaFisicaLocalizacionSeccion", SQL_INSERT_TEMP_VENTA_FISICA_LOCALIZACION_SECCION, true);
    FieldUtils.writeField(this.primaryTemporaryTablePorVentaRepositoryCustom,
        "sqlDeleteTempVentaFisicaLocalizacionSeccion", SQL_DELETE_TEMP_VENTA_FISICA_LOCALIZACION_SECCION, true);
    // Venta física localización
    FieldUtils.writeField(this.primaryTemporaryTablePorVentaRepositoryCustom,
        "sqlInsertTempVentaFisicaLocalizacion", SQL_INSERT_TEMP_VENTA_FISICA_LOCALIZACION, true);
    // Fechas estructuras por venta
    FieldUtils.writeField(this.primaryTemporaryTablePorVentaRepositoryCustom,
        "sqlCreateTempDatesEstructurasPorVenta", SQL_CREATE_TEMP_DATES_ESTRUCTURAS_POR_VENTA,
        true);
    FieldUtils.writeField(this.primaryTemporaryTablePorVentaRepositoryCustom,
        "sqlIndexTempDatesEstructurasPorVenta", SQL_INDEX_TEMP_DATES_ESTRUCTURAS_POR_VENTA,
        true);
    FieldUtils.writeField(this.primaryTemporaryTablePorVentaRepositoryCustom,
        "sqlDeleteTempDatesEstructurasPorVenta", SQL_DELETE_TEMP_DATES_ESTRUCTURAS_POR_VENTA,
        true);
    FieldUtils.writeField(this.primaryTemporaryTablePorVentaRepositoryCustom,
        "sqlInsertTempDatesEstructurasPorVenta", SQL_INSERT_TEMP_DATES_ESTRUCTURAS_POR_VENTA,
        true);
  }

  @Test
  void createTempVentaFisicaLocalizacionSeccionTest() {
    this.primaryTemporaryTablePorVentaRepositoryCustom.createTempVentaFisicaLocalizacionSeccion();
    verify(this.jdbcTemplate).update(SQL_CREATE_TEMP_VENTA_FISICA_LOCALIZACION_SECCION);
  }

  @Test
  void createIndexTempVentaFisicaLocalizacionSeccionTest() {
    this.primaryTemporaryTablePorVentaRepositoryCustom.createIndexTempVentaFisicaLocalizacionSeccion();
    verify(this.jdbcTemplate).update(SQL_CREATE_INDEX_TEMP_VENTA_FISICA_LOCALIZACION_SECCION);
  }

  @ParameterizedTest
  @InstancioSource
  void insertTempVentaFisicaLocalizacionSeccionTest(final TareaDto tarea) {
    this.primaryTemporaryTablePorVentaRepositoryCustom.insertTempVentaFisicaLocalizacionSeccion(tarea);
    final ArgumentCaptor<MapSqlParameterSource> paramsCaptor = ArgumentCaptor.forClass(MapSqlParameterSource.class);
    verify(this.namedParameterJdbcTemplate).update(eq(SQL_INSERT_TEMP_VENTA_FISICA_LOCALIZACION_SECCION), paramsCaptor.capture());

    final Map<String, Object> expected = new HashMap<>();
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.VENTA_FISICA_IPOD_LOCALIZACION_SECCION.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

    assertEquals(expected, paramsCaptor.getValue().getValues());
  }

  @Test
  void deleteTempVentaFisicaLocalizacionSeccionTest() {
    this.primaryTemporaryTablePorVentaRepositoryCustom.deleteTempVentaFisicaLocalizacionSeccion();
    verify(this.jdbcTemplate).update(SQL_DELETE_TEMP_VENTA_FISICA_LOCALIZACION_SECCION);
  }

  @ParameterizedTest
  @InstancioSource
  void insertTempVentaFisicaLocalizacionTest(final TareaDto tarea) {
    this.primaryTemporaryTablePorVentaRepositoryCustom.insertTempVentaFisicaLocalizacion(tarea);
    final ArgumentCaptor<MapSqlParameterSource> paramsCaptor = ArgumentCaptor.forClass(MapSqlParameterSource.class);
    verify(this.namedParameterJdbcTemplate).update(eq(SQL_INSERT_TEMP_VENTA_FISICA_LOCALIZACION), paramsCaptor.capture());

    final Map<String, Object> expected = new HashMap<>();
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_SECCION, AppConstants.SECCION_4);
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.VENTA_FISICA_IPOD_LOCALIZACION_SECCION.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

    assertEquals(expected, paramsCaptor.getValue().getValues());
  }

  @Test
  void deleteTempDatesEstructurasPorVentaTest() {
    this.primaryTemporaryTablePorVentaRepositoryCustom.deleteTempDatesEstructurasPorVenta();
    verify(this.jdbcTemplate).update(SQL_DELETE_TEMP_DATES_ESTRUCTURAS_POR_VENTA);
  }

  @Test
  void createTempDatesEstructurasPorVentaTest() {
    this.primaryTemporaryTablePorVentaRepositoryCustom.createTempDatesEstructurasPorVenta();
    verify(this.jdbcTemplate).update(SQL_CREATE_TEMP_DATES_ESTRUCTURAS_POR_VENTA);
  }

  @Test
  void indexTempDatesEstructurasPorVentaTest() {
    this.primaryTemporaryTablePorVentaRepositoryCustom.indexTempDatesEstructurasPorVenta();
    verify(this.jdbcTemplate).update(SQL_INDEX_TEMP_DATES_ESTRUCTURAS_POR_VENTA);
  }

  @ParameterizedTest
  @InstancioSource
  void insertTempDatesEstructurasPorVentaTest(final TareaDto tareaDto) {
    this.primaryTemporaryTablePorVentaRepositoryCustom.insertTempDatesEstructurasPorVenta(tareaDto);
    final ArgumentCaptor<MapSqlParameterSource> paramsCaptor = ArgumentCaptor.forClass(MapSqlParameterSource.class);
    verify(this.namedParameterJdbcTemplate).update(eq(SQL_INSERT_TEMP_DATES_ESTRUCTURAS_POR_VENTA), paramsCaptor.capture());

    final Map<String, Object> expected = new HashMap<>();
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_CALCULO, TipoCalculoEnum.POR_VENTA.getId());

    assertEquals(expected, paramsCaptor.getValue().getValues());
  }
}
