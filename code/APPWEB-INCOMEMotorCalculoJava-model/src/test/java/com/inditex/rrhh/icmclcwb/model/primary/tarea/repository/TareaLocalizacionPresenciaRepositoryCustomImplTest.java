package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ABIERTO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ACTIVO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_DENOMINADOR;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_HORAS_DESTINO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_HORAS_ORIGEN;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_SECCION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TAREA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_CALCULO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_LOCALIZACION_PRESENCIA_MANUAL;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_PRESENCIAS_SINDICALES;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_MINUTOS;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_INCLUIDO_ECOMMERCE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_INCLUIDO_VENTA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_SECCION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_REPARTIDO_PROVINCIA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
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
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class,})
class TareaLocalizacionPresenciaRepositoryCustomImplTest {

  private final static String SQL_SAVE = "SAVE";

  private final static String SQL_COMPENSAR_LOCALIZACION_MANUAL = "COMPENSAR_LOCALIZACION_MANUAL";

  private final static String SQL_TOTALIZAR = "TOTALIZAR";

  private final static String SQL_COMPENSAR = "COMPENSAR";

  private final static String SQL_REPARTIR_PRESENCIAS_SINDICALES_SECCION = "REPARTIR PRESENCIAS SINDICALES SECCION";

  private final static String SQL_REPARTIR_PRESENCIAS_SINDICALES = "REPARTIR PRESENCIAS SINDICALES";

  private final static String SQL_UPDATE_ACTIVO_BY_TIPO_DATO = "UPDATE ACTIVO BY TIPO DATO";

  private final static String SQL_TOTALIZAR_COMMERCE_SECCION = "TOTALIZAR COMMERCE SECCION";

  private final static String SQL_TOTALIZAR_PRESENCIAS_SINDICALES_SECCION = "TOTALIZAR PRESENCIAS SINDICALES SECCION";

  private final static String SQL_TOTALIZAR_PRESENCIAS_EMPLEADOS_POR_VENTA = "TOTALIZAR PRESENCIAS EMPLEADOS POR VENTA";

  private final static String SQL_COMPENSAR_INCLUIDO_CHALLENGE_PORCENTAJE = "COMPENSAR INCLUIDO CHALLENGE PORCENTAJE";

  private final static String SQL_TOTALIZAR_INCLUIDO_CHALLENGE_PORCENTAJE = "TOTALIZAR INCLUIDO CHALLENGE PORCENTAJE";

  private final static String SQL_UPDATE_ACTIVO_VACIO = "UPDATE ACTIVO VACIO";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Mock
  private TipoDatoService tipoDatoService;

  @Mock
  private JdbcTemplate jdbcTemplate;

  @InjectMocks
  private TareaLocalizacionPresenciaRepositoryCustomImpl tareaLocalizacionPresenciaRepositoryCustom;

  @Captor
  ArgumentCaptor<String> sqlCaptor;

  @Captor
  ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaLocalizacionPresenciaRepositoryCustom, "sqlSave", SQL_SAVE, true);
    FieldUtils.writeField(this.tareaLocalizacionPresenciaRepositoryCustom, "sqlCompensarLocalizacionManual",
        SQL_COMPENSAR_LOCALIZACION_MANUAL,
        true);
    FieldUtils.writeField(this.tareaLocalizacionPresenciaRepositoryCustom, "sqlCompensar", SQL_COMPENSAR, true);
    FieldUtils.writeField(this.tareaLocalizacionPresenciaRepositoryCustom, "sqlTotalizar", SQL_TOTALIZAR, true);
    FieldUtils.writeField(this.tareaLocalizacionPresenciaRepositoryCustom, "sqlUpdateActivoByTipoDato",
        SQL_UPDATE_ACTIVO_BY_TIPO_DATO, true);
    FieldUtils.writeField(this.tareaLocalizacionPresenciaRepositoryCustom,
        "sqlRepartirPresenciasSindicalesLocalizacion", SQL_REPARTIR_PRESENCIAS_SINDICALES, true);
    FieldUtils.writeField(this.tareaLocalizacionPresenciaRepositoryCustom,
        "sqlRepartirPresenciasSindicalesLocalizacionSeccion", SQL_REPARTIR_PRESENCIAS_SINDICALES_SECCION, true);
    FieldUtils.writeField(this.tareaLocalizacionPresenciaRepositoryCustom, "sqlTotalizarEcommerceSeccion",
        SQL_TOTALIZAR_COMMERCE_SECCION, true);
    FieldUtils.writeField(this.tareaLocalizacionPresenciaRepositoryCustom,
        "sqlTotalizarPresenciasSindicalesLocalizacion",
        SQL_TOTALIZAR_PRESENCIAS_SINDICALES_SECCION, true);
    FieldUtils.writeField(this.tareaLocalizacionPresenciaRepositoryCustom,
        "sqlTotalizarEmpleadosPorVenta",
        SQL_TOTALIZAR_PRESENCIAS_EMPLEADOS_POR_VENTA, true);
    FieldUtils.writeField(this.tareaLocalizacionPresenciaRepositoryCustom,
        "sqlTotalizarIncluidoChallengePorcentaje",
        SQL_TOTALIZAR_INCLUIDO_CHALLENGE_PORCENTAJE, true);
    FieldUtils.writeField(this.tareaLocalizacionPresenciaRepositoryCustom,
        "sqlUpdateActivoVacio",
        SQL_UPDATE_ACTIVO_VACIO, true);
  }

  @Test
  void compensarLocalizacionManualTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(199L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.compensarLocalizacionManual(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_COMPENSAR_LOCALIZACION_MANUAL, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, nuevoIdSeccion, nuevoIdTipoDato,
    // excluidoDenominador, idTipoPolitica, tiposDato, activo
    assertEquals(5, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
    // nuevoIdSeccion
    assertTrue(params.hasValue(SQL_PARAM_ID_SECCION));
    assertEquals(AppConstants.SECCION_4, params.getValue(SQL_PARAM_ID_SECCION));
    // nuevoIdTipoDato
    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
    assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId(),
        params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
    // tiposDato
    assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_DATO));
    assertEquals(Arrays.asList(5018, 5002), params.getValue(SQL_PARAM_IDS_TIPOS_DATO));

  }

  @Test
  void updateActivoVacioTest() {
    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();
    this.tareaLocalizacionPresenciaRepositoryCustom.updateActivoVacio(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(),
        any(MapSqlParameterSource.class));
    assertEquals(SQL_UPDATE_ACTIVO_VACIO, this.sqlCaptor.getValue());
  }

  @Test
  void compensarQueryTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();
    this.tareaLocalizacionPresenciaRepositoryCustom.compensar(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(),
        any(MapSqlParameterSource.class));
    assertEquals(SQL_COMPENSAR, this.sqlCaptor.getValue());

  }

  @Test
  void compensarNumeroParametrosTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();
    this.tareaLocalizacionPresenciaRepositoryCustom.compensar(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    // Parámetros de la consulta: idSeccion, nuevoIdTipoDato, excluidoDenominador, repartidoProvincia,
    // idTipoPolitica, idTarea, idTipoGrupoDato, activo, horasOrigen, horasDestino,
    // idTipoDatoPresenciasSindicales
    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertEquals(11, parametros.getValues().size());
  }

  @Test
  void compensarParametroIdTareaTest() {

    final TareaDto tarea = new TareaDto();
    final Long idTarea = 1313L;
    tarea.setId(idTarea);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();
    this.tareaLocalizacionPresenciaRepositoryCustom.compensar(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, parametros.getValue(SQL_PARAM_ID_TAREA));

  }

  @Test
  void compensarParametroNuevoIdTipoDatoTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();
    this.tareaLocalizacionPresenciaRepositoryCustom.compensar(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
    assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId(),
        parametros.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));

  }

  @Test
  void compensarParametroIdSeccionTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();
    this.tareaLocalizacionPresenciaRepositoryCustom.compensar(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_ID_SECCION));
    assertEquals(AppConstants.SECCION_4, parametros.getValue(SQL_PARAM_ID_SECCION));

  }

  @Test
  void compensarParametroExcluidoDenominadorTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();
    this.tareaLocalizacionPresenciaRepositoryCustom.compensar(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_EXCLUIDO_DENOMINADOR));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, parametros.getValue(SQL_PARAM_EXCLUIDO_DENOMINADOR));

  }

  @Test
  void compensarParametroRepartidoProvinciaTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();
    this.tareaLocalizacionPresenciaRepositoryCustom.compensar(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_REPARTIDO_PROVINCIA));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, parametros.getValue(SQL_PARAM_REPARTIDO_PROVINCIA));

  }

  @Test
  void compensarParametroIdTipoPoliticaTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();
    this.tareaLocalizacionPresenciaRepositoryCustom.compensar(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_ID_TIPO_POLITICA));
    assertEquals(TipoPoliticaEnum.EXCLUIDO_DENOMINADOR.getId(), parametros.getValue(SQL_PARAM_ID_TIPO_POLITICA));

  }

  @Test
  void compensarParametroActivoTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();
    this.tareaLocalizacionPresenciaRepositoryCustom.compensar(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, parametros.getValue(SQL_PARAM_ACTIVO));

  }

  @Test
  void compensarParametroIdTipoGrupoDatoTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();
    this.tareaLocalizacionPresenciaRepositoryCustom.compensar(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_ID_TIPO_GRUPO_DATO));
    assertEquals(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
        parametros.getValue(SQL_PARAM_ID_TIPO_GRUPO_DATO));

  }

  @Test
  void compensarParametroHorasOrigenTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();
    this.tareaLocalizacionPresenciaRepositoryCustom.compensar(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_HORAS_ORIGEN));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, parametros.getValue(SQL_PARAM_HORAS_ORIGEN));

  }

  @Test
  void compensarParametroHorasDestinoTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();
    this.tareaLocalizacionPresenciaRepositoryCustom.compensar(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_HORAS_DESTINO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, parametros.getValue(SQL_PARAM_HORAS_DESTINO));

  }

  @Test
  void compensarParametroIdTipoDatoPresenciasSindicalesTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();
    this.tareaLocalizacionPresenciaRepositoryCustom.compensar(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_ID_TIPO_DATO_PRESENCIAS_SINDICALES));
    assertEquals(TipoDatoEnum.REPARTO_HORAS_SINDICALES_LOCALIZACION.getId(),
        parametros.getValue(SQL_PARAM_ID_TIPO_DATO_PRESENCIAS_SINDICALES));

  }

  @Test
  void totalizarQueryTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();
    this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(),
        any(MapSqlParameterSource.class));
    assertEquals(SQL_TOTALIZAR, this.sqlCaptor.getValue());

  }

  @Test
  void totalizarNumeroParametrosTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();
    this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    // Parámetros de la consulta: nuevoIdTipoDato, excluidoDenominador, repartidoProvincia,
    // idTipoPolitica, idTarea, idTipoGrupoDato, activo, horasOrigen, horasDestino,
    // idTipoDatoPresenciasSindicales, idTipoDatoManual
    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertEquals(11, parametros.getValues().size());
  }

  @Test
  void totalizarParametroIdTareaTest() {

    final TareaDto tarea = new TareaDto();
    final Long idTarea = 1313L;
    tarea.setId(idTarea);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();
    this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, parametros.getValue(SQL_PARAM_ID_TAREA));

  }

  @Test
  void totalizarParametroNuevoIdTipoDatoTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();
    this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
    assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDODENOMINADOR.getId(),
        parametros.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));

  }

  @Test
  void totalizarParametroExcluidoDenominadorTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();
    this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_EXCLUIDO_DENOMINADOR));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE, parametros.getValue(SQL_PARAM_EXCLUIDO_DENOMINADOR));

  }

  @Test
  void totalizarParametroRepartidoProvinciaTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();
    this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_REPARTIDO_PROVINCIA));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE, parametros.getValue(SQL_PARAM_REPARTIDO_PROVINCIA));

  }

  @Test
  void totalizarParametroIdTipoPoliticaTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();
    this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_ID_TIPO_POLITICA));
    assertEquals(TipoPoliticaEnum.EXCLUIDO_DENOMINADOR.getId(), parametros.getValue(SQL_PARAM_ID_TIPO_POLITICA));

  }

  @Test
  void totalizarParametroIdTipoGrupoDatoTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();
    this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_ID_TIPO_GRUPO_DATO));
    assertEquals(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
        parametros.getValue(SQL_PARAM_ID_TIPO_GRUPO_DATO));

  }

  @Test
  void totalizarParametroActivoTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();
    this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, parametros.getValue(SQL_PARAM_ACTIVO));

  }

  @Test
  void totalizarParametroHorasOrigenTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();
    this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_HORAS_ORIGEN));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, parametros.getValue(SQL_PARAM_HORAS_ORIGEN));

  }

  @Test
  void totalizarParametroHorasDestinoTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();
    this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_HORAS_DESTINO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, parametros.getValue(SQL_PARAM_HORAS_DESTINO));

  }

  @Test
  void totalizarParametroIdTipoDatoPresenciasSindicalesTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();
    this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_ID_TIPO_DATO_PRESENCIAS_SINDICALES));
    assertEquals(TipoDatoEnum.REPARTO_HORAS_SINDICALES_LOCALIZACION_SECCION.getId(),
        parametros.getValue(SQL_PARAM_ID_TIPO_DATO_PRESENCIAS_SINDICALES));

  }

  @Test
  void totalizarParametroIdTipoDatoManualTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();
    this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_ID_TIPO_DATO_LOCALIZACION_PRESENCIA_MANUAL));
    assertEquals(TipoDatoEnum.PRESENCIA_MANUAL_LOCALIZACION_SECCION_INCLUIDODENOMINADOR.getId(),
        parametros.getValue(SQL_PARAM_ID_TIPO_DATO_LOCALIZACION_PRESENCIA_MANUAL));

  }

  @Test
  void repartirPresenciasSindicalesLocalizacionQueryTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacion(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(),
        any(MapSqlParameterSource.class));

    assertEquals(SQL_REPARTIR_PRESENCIAS_SINDICALES, this.sqlCaptor.getValue());

  }

  @Test
  void repartirPresenciasSindicalesLocalizacionNumeroParametrosTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacion(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    // Parámetros de la consulta: idTarea, idTipoPresencia, idTipoDatoPresenciasSindicales,
    // nuevoidTipoDato, activo, idSeccion, abierto
    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertEquals(7, parametros.getValues().size());

  }

  @Test
  void repartirPresenciasSindicalesLocalizacionParametroIdTareaTest() {

    final Long idTarea = 8989L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacion(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, parametros.getValue(SQL_PARAM_ID_TAREA));

  }

  @Test
  void repartirPresenciasSindicalesLocalizacionParametroAbiertoTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacion(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_ABIERTO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, parametros.getValue(SQL_PARAM_ABIERTO));

  }

  @Test
  void repartirPresenciasSindicalesLocalizacionParametroIdTipoPresenciaTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacion(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_ID_TIPO_MINUTOS));
    assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDOECOMMERCE.getId(),
        parametros.getValue(SQL_PARAM_ID_TIPO_MINUTOS));

  }

  @Test
  void repartirPresenciasSindicalesLocalizacionParametroNuevoIdTipoDatoTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacion(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
    assertEquals(TipoDatoEnum.REPARTO_HORAS_SINDICALES_LOCALIZACION.getId(),
        parametros.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));

  }

  @Test
  void repartirPresenciasSindicalesLocalizacionParametroIdTipoDatoPresenciasSindicalesTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacion(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_ID_TIPO_DATO_PRESENCIAS_SINDICALES));
    assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_HORAS_SINDICALES.getId(),
        parametros.getValue(SQL_PARAM_ID_TIPO_DATO_PRESENCIAS_SINDICALES));

  }

  @Test
  void repartirPresenciasSindicalesLocalizacionParametroActivoTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacion(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, parametros.getValue(SQL_PARAM_ACTIVO));

  }

  @Test
  void repartirPresenciasSindicalesLocalizacionParametroIdSeccionTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacion(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_ID_SECCION));
    assertEquals(AppConstants.SECCION_4, parametros.getValue(SQL_PARAM_ID_SECCION));

  }

  @Test
  void totalizarEcommerceSeccionQueryTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.totalizarEcommerceSeccion(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(),
        any(MapSqlParameterSource.class));
    assertEquals(SQL_TOTALIZAR_COMMERCE_SECCION, this.sqlCaptor.getValue());

  }

  @Test
  void totalizarEcommerceSeccionNumeroParametrosTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.totalizarEcommerceSeccion(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    // Parámetros de la consulta: nuevoIdTipoDato, incluidoEcommerce, idTipoPolitica, idTarea,
    // idTipoGrupoDato, activo, horasOrigen, horasDestino
    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertEquals(8, parametros.getValues().size());

  }

  @Test
  void totalizarEcommerceSeccionParametroIdTareaTest() {

    final Long idTarea = 1432020L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.totalizarEcommerceSeccion(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, parametros.getValue(SQL_PARAM_ID_TAREA));

  }

  @Test
  void totalizarEcommerceSeccionParametroNuevoIdTipoDatoTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.totalizarEcommerceSeccion(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
    assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDOECOMMERCE.getId(),
        parametros.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));

  }

  @Test
  void totalizarEcommerceSeccionParametroIncluidoEcommerceTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.totalizarEcommerceSeccion(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_INCLUIDO_ECOMMERCE));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, parametros.getValue(SQL_PARAM_INCLUIDO_ECOMMERCE));

  }

  @Test
  void totalizarEcommerceSeccionParametroIdTipoPoliticaTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.totalizarEcommerceSeccion(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_ID_TIPO_POLITICA));
    assertEquals(TipoPoliticaEnum.EXCLUIDO_DENOMINADOR.getId(), parametros.getValue(SQL_PARAM_ID_TIPO_POLITICA));

  }

  @Test
  void totalizarEcommerceSeccionParametroIdTipoGrupoDatoTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.totalizarEcommerceSeccion(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_ID_TIPO_GRUPO_DATO));
    assertEquals(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA_INCLUIDOECOMMERCE.getId(),
        parametros.getValue(SQL_PARAM_ID_TIPO_GRUPO_DATO));

  }

  @Test
  void totalizarEcommerceSeccionParametroActivoTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.totalizarEcommerceSeccion(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, parametros.getValue(SQL_PARAM_ACTIVO));

  }

  @Test
  void totalizarEcommerceSeccionParametroHorasOrigenTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.totalizarEcommerceSeccion(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_HORAS_ORIGEN));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, parametros.getValue(SQL_PARAM_HORAS_ORIGEN));

  }

  @Test
  void totalizarEcommerceSeccionParametroHorasDestinoTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(1222L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.totalizarEcommerceSeccion(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_HORAS_DESTINO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, parametros.getValue(SQL_PARAM_HORAS_DESTINO));

  }

  @Test
  void totalizarPresenciasSindicalesLocalizacionQueryTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(123L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.totalizarPresenciasSindicalesLocalizacion(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(),
        any(MapSqlParameterSource.class));

    assertEquals(SQL_TOTALIZAR_PRESENCIAS_SINDICALES_SECCION, this.sqlCaptor.getValue());
  }

  @Test
  void totalizarPresenciasSindicalesLocalizacionNumeroParametrosTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(123L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.totalizarPresenciasSindicalesLocalizacion(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    // Parámetros de la consulta: idSeccion, nuevoIdTipoDato, repartidoProvincia, idTarea,
    // idTipoGrupoDato, activo
    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertEquals(6, parametros.getValues().size());
  }

  @Test
  void totalizarPresenciasSindicalesLocalizacionParametroIdTareaTest() {

    final Long idTarea = 9090L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.totalizarPresenciasSindicalesLocalizacion(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, parametros.getValue(SQL_PARAM_ID_TAREA));
  }

  @Test
  void totalizarPresenciasSindicalesLocalizacionParametroIdSeccionTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(8989L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.totalizarPresenciasSindicalesLocalizacion(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_ID_SECCION));
    assertEquals(AppConstants.SECCION_4, parametros.getValue(SQL_PARAM_ID_SECCION));
  }

  @Test
  void totalizarPresenciasSindicalesLocalizacionParametroNuevoIdTipoDatoTest() {

    final Long idTarea = 9090L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.totalizarPresenciasSindicalesLocalizacion(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
    assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_HORAS_SINDICALES.getId(),
        parametros.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
  }

  @Test
  void totalizarPresenciasSindicalesLocalizacionParametroRepartidoProvinciaTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(8989L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.totalizarPresenciasSindicalesLocalizacion(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_REPARTIDO_PROVINCIA));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, parametros.getValue(SQL_PARAM_REPARTIDO_PROVINCIA));
  }

  @Test
  void totalizarPresenciasSindicalesLocalizacionParametroIdTipoGrupoDatoTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(786L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.totalizarPresenciasSindicalesLocalizacion(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_ID_TIPO_GRUPO_DATO));
    assertEquals(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA_REPARTIDOPROVINCIA.getId(),
        parametros.getValue(SQL_PARAM_ID_TIPO_GRUPO_DATO));
  }

  @Test
  void totalizarPresenciasSindicalesLocalizacionParametroActivoTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(486L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.totalizarPresenciasSindicalesLocalizacion(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertTrue(parametros.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, parametros.getValue(SQL_PARAM_ACTIVO));
  }

  @Test
  void repartirPresenciasSindicalesLocalizacionSeccionQueryTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(8989L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacionSeccion(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(),
        any(MapSqlParameterSource.class));

    assertEquals(SQL_REPARTIR_PRESENCIAS_SINDICALES_SECCION, this.sqlCaptor.getValue());
  }

  @Test
  void repartirPresenciasSindicalesLocalizacionSeccionNumeroParametrosTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(8989L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacionSeccion(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    // Parámetros de la query: idTarea, activo, idTipoPresencia, idTipoDatoPresenciasSindicales,
    // nuevoIdTipoDato
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(5, params.getValues().size());

  }

  @Test
  void repartirPresenciasSindicalesLocalizacionSeccionParametroIdTareaTest() {

    final Long idTarea = 231L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacionSeccion(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();

    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, params.getValue(SQL_PARAM_ID_TAREA));

  }

  @Test
  void repartirPresenciasSindicalesLocalizacionSeccionParametroActivoTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(8989L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacionSeccion(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();

    assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));

  }

  @Test
  void repartirPresenciasSindicalesLocalizacionSeccionParametroIdTipoPresenciaTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(8989L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacionSeccion(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();

    assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_MINUTOS));
    assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDOECOMMERCE.getId(),
        params.getValue(SQL_PARAM_ID_TIPO_MINUTOS));

  }

  @Test
  void repartirPresenciasSindicalesLocalizacionSeccionParametroIdTipoDatoPresenciaSindicalesTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(8989L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacionSeccion(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();

    assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_DATO_PRESENCIAS_SINDICALES));
    assertEquals(TipoDatoEnum.REPARTO_HORAS_SINDICALES_LOCALIZACION.getId(),
        params.getValue(SQL_PARAM_ID_TIPO_DATO_PRESENCIAS_SINDICALES));

  }

  @Test
  void repartirPresenciasSindicalesLocalizacionSeccionParametroNuevoIdTipoDatoTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(8989L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacionSeccion(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();

    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
    assertEquals(TipoDatoEnum.REPARTO_HORAS_SINDICALES_LOCALIZACION_SECCION.getId(),
        params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));

  }

  @ParameterizedTest
  @InstancioSource
  void totalizarEmpleadosPorVentaTest(final RunTareaDto tarea) {

    this.tareaLocalizacionPresenciaRepositoryCustom.totalizarEmpleadosPorVenta(tarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_TOTALIZAR_PRESENCIAS_EMPLEADOS_POR_VENTA), this.paramsCaptor.capture());

    final Map<String, Object> params = this.paramsCaptor.getValue().getValues();

    final Map<String, Object> expected = new HashMap<>();
    expected.put(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA, TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA.getId());
    expected.put(SQL_PARAM_ID_TIPO_CALCULO, TipoCalculoEnum.POR_VENTA.getId());
    expected.put(SQL_PARAM_INCLUIDO_VENTA, SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SQL_PARAM_ID_TAREA, tarea.getTarea().getId());
    expected.put(SQL_PARAM_NUEVO_ID_SECCION, AppConstants.SECCION_4);
    expected.put(SQL_PARAM_NUEVO_ID_TIPO_DATO, TipoDatoEnum.PRESENCIA_LOCALIZACION_EMPLEADOS_POR_VENTA.getId());
    expected.put(SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
    expected.put(SQL_PARAM_HORAS_DESTINO, SQL_VALUE_BOOLEAN_FALSE);
    expected.put(SQL_PARAM_HORAS_ORIGEN, SQL_VALUE_BOOLEAN_TRUE);

    assertEquals(expected, params);

  }

  @Test
  public void totalizarIncluidoChallengePorcentajeTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(199L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.totalizarIncluidoChallengePorcentaje(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_TOTALIZAR_INCLUIDO_CHALLENGE_PORCENTAJE, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, nuevoIdSeccion, nuevoIdTipoDato,
    // excluidoDenominador, idTipoPolitica, tiposDato, activo
    assertEquals(10, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
    // nuevoIdSeccion
    assertTrue(params.hasValue(SQL_PARAM_ID_SECCION));
    assertEquals(AppConstants.SECCION_4, params.getValue(SQL_PARAM_ID_SECCION));
    // nuevoIdTipoDato
    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
    assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDOCHALLENGEPORCENTAJE.getId(),
        params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));

  }

  @Test
  public void compensarLocalizacionManualIncluidoChallengePorcentajeTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(199L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).build();

    this.tareaLocalizacionPresenciaRepositoryCustom.compensarLocalizacionManualIncluidoChallengePorcentaje(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_COMPENSAR_LOCALIZACION_MANUAL, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, nuevoIdSeccion, nuevoIdTipoDato,
    // excluidoDenominador, idTipoPolitica, tiposDato, activo
    assertEquals(5, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
    // nuevoIdSeccion
    assertTrue(params.hasValue(SQL_PARAM_ID_SECCION));
    assertEquals(AppConstants.SECCION_4, params.getValue(SQL_PARAM_ID_SECCION));
    // nuevoIdTipoDato
    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
    assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDOCHALLENGEPORCENTAJE.getId(),
        params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
    // tiposDato
    assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_DATO));
    assertEquals(Arrays.asList(5018, 5025), params.getValue(SQL_PARAM_IDS_TIPOS_DATO));

  }

}
