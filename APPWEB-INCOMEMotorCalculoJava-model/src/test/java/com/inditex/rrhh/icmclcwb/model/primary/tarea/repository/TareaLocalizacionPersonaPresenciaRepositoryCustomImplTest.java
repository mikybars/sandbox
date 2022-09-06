package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ABIERTO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ACTIVO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_CALCULA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_COMISIONABLE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_CALCULO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_DENOMINADOR;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TAREA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_CALCULO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_PRESENCIA_DESPLAZAMIENTO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO_VENTA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_INACTIVO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_INCLUIDO_CHALLENGE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_INCLUIDO_CHALLENGE_PORCENTAJE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_INCLUIDO_VENTA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_MINUTOS;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_SECCION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_MINUTOS_CERO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaPresencia;

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

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class TareaLocalizacionPersonaPresenciaRepositoryCustomImplTest {

  private final static String SQL_SAVE = "SAVE";

  private final static String SQL_UPDATE_ACTIVO = "UPDATE ACTIVO";

  private final static String SQL_UPDATE_ACTIVO_VACIO = "UPDATE ACTIVO VACIO";

  private final static String SQL_COMPENSAR = "COMPENSAR";

  private final static String SQL_COMPENSAR_CHALLENGE = "COMPENSAR CHALLENGE";

  private final static String SQL_INDICADOR_PRESENCIA = "INDICADOR PRESENCIA";

  private final static String SQL_PRESENCIA_DESPLAZAMIENTO = "PRESENCIA DESPLAZAMIENTO";

  private final static String SQL_PRESENCIA_DESPLAZAMIENTO_CHALLENGE_PORCENTAJE = "PRESENCIA DESPLAZAMIENTO CHALLENGE PORCENTAJE";

  private final static String SQL_INDICADOR_PRESENCIA_DESPLAZAMIENTO = "INDICADOR PRESENCIA DESPLAZAMIENTO";

  private final static String SQL_INDICADOR_PRESENCIA_DESPLAZAMIENTO_BASE = "INDICADOR PRESENCIA DESPLAZAMIENTO BASE";

  private final static String SQL_INDICADOR_PRESENCIA_DESPLAZAMIENTO_BASE_MISMA_LOCALIZACION =
      "INDICADOR PRESENCIA DESPLAZAMIENTO BASE MISMA LOCALIZACION";

  private final static String SQL_PRESENCIAS_HORAS_FIJAS = "PRESENCIAS HORAS FIJAS";

  private final static String SQL_PRESENCIAS_HORAS_FIJAS_DESPLAZAMIENTO = "PRESENCIAS HORAS FIJAS DESPLAZAMIENTO";

  private final static String SQL_INDICADOR_PERSONA_POR_VENTA = "SQL INDICADOR PERSONA POR VENTA";

  private final static String SQL_PRESENCIAS_INCLUIDO_VENTA = "PRESENCIAS INCLUIDO VENTA";

  private final static String SQL_INDICADOR_DESPLAZAMIENTO_DIRECTO_VENTA = "SQL INDICADOR DESPLAZAMIENTO DIRECTO VENTA";

  private final static String SQL_INDICADOR_DESPLAZAMIENTO_DIRECTO_VENTA_SIN_PRESENCIAS =
      "SQL INDICADOR DESPLAZAMIENTO DIRECTO VENTA SIN PRESENCIAS";

  private final static String SQL_INDICADOR_DESPLAZAMIENTO_BASE_DIRECTO_VENTA = "SQL INDICADOR DESPLAZAMIENTO BASE DIRECTO VENTA";

  private final static String SQL_INDICADOR_DESPLAZAMIENTO_BASE_DIRECTO_VENTA_OTRA_TIENDA =
      "SQL INDICADOR DESPLAZAMIENTO BASE DIRECTO VENTA OTRA TIENDA";

  private final static String SQL_INDICADOR_DESPLAZAMIENTO_BASE_DIRECTO_VENTA_SIN_DESPLAZAMIENTO =
      "SQL INDICADOR DESPLAZAMIENTO BASE DIRECTO VENTA OTRA TIENDA SIN DESPLAZAMIENTO";

  private final static String SQL_INDICADOR_DESPLAZAMIENTO_DIRECTO_VENTA_CAMBIO_FUNCION =
      "SQL INDICADOR DESPLAZAMIENTO DIRECTO VENTA CAMBIO FUNCION";

  private final static String SQL_INDICADOR_DESPLAZAMIENTO_CHALLENGE_IMPORTE_TIENDA =
      "SQL INDICADOR DESPLAZAMIENTO CHALLENGE IMPORTE TIENDA";

  private final static String SQL_UPDATE_ACTIVO_PERSONAS_EXTERNAS = "SQL UPDATE ACTIVO PERSONAS EXTERNAS";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Mock
  private TipoDatoService tipoDatoService;

  @Mock
  private JdbcTemplate jdbcTemplate;

  @InjectMocks
  private TareaLocalizacionPersonaPresenciaRepositoryCustomImpl tareaLocalizacionPersonaPresenciaRepositoryCustom;

  @Captor
  ArgumentCaptor<String> sqlCaptor;

  @Captor
  ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, "sqlSave", SQL_SAVE, true);
    FieldUtils.writeField(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, "sqlUpdateActivo",
        SQL_UPDATE_ACTIVO,
        true);
    FieldUtils.writeField(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, "sqlUpdateActivoVacio",
        SQL_UPDATE_ACTIVO_VACIO, true);
    FieldUtils.writeField(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, "sqlCompensar", SQL_COMPENSAR,
        true);
    FieldUtils.writeField(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, "sqlCompensarChallenge",
        SQL_COMPENSAR_CHALLENGE,
        true);
    FieldUtils.writeField(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, "sqlIndicadorPresencia",
        SQL_INDICADOR_PRESENCIA, true);
    FieldUtils.writeField(this.tareaLocalizacionPersonaPresenciaRepositoryCustom,
        "sqlIndicadorPresenciaDesplazamiento",
        SQL_INDICADOR_PRESENCIA_DESPLAZAMIENTO, true);
    FieldUtils.writeField(this.tareaLocalizacionPersonaPresenciaRepositoryCustom,
        "sqlIndicadorPresenciaDesplazamientoBase",
        SQL_INDICADOR_PRESENCIA_DESPLAZAMIENTO_BASE, true);
    FieldUtils.writeField(this.tareaLocalizacionPersonaPresenciaRepositoryCustom,
        "sqlIndicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion",
        SQL_INDICADOR_PRESENCIA_DESPLAZAMIENTO_BASE_MISMA_LOCALIZACION, true);
    FieldUtils.writeField(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, "sqlProcesarPresenciasHorasFijas",
        SQL_PRESENCIAS_HORAS_FIJAS, true);
    FieldUtils.writeField(this.tareaLocalizacionPersonaPresenciaRepositoryCustom,
        "sqlProcesarPresenciasHorasFijasDesplazamientos",
        SQL_PRESENCIAS_HORAS_FIJAS_DESPLAZAMIENTO, true);
    FieldUtils.writeField(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, "sqlIndicadorPersonaPorVenta",
        SQL_INDICADOR_PERSONA_POR_VENTA, true);
    FieldUtils.writeField(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, "sqlPresenciasIncluidoVenta",
        SQL_PRESENCIAS_INCLUIDO_VENTA, true);
    FieldUtils.writeField(this.tareaLocalizacionPersonaPresenciaRepositoryCustom,
        "sqlIndicadorDesplazamientoDirectoVenta",
        SQL_INDICADOR_DESPLAZAMIENTO_DIRECTO_VENTA, true);
    FieldUtils.writeField(this.tareaLocalizacionPersonaPresenciaRepositoryCustom,
        "sqlIndicadorDesplazamientoDirectoVentaSinPresencias",
        SQL_INDICADOR_DESPLAZAMIENTO_DIRECTO_VENTA_SIN_PRESENCIAS, true);
    FieldUtils.writeField(this.tareaLocalizacionPersonaPresenciaRepositoryCustom,
        "sqlIndicadorDesplazamientoBaseDirectoVenta",
        SQL_INDICADOR_DESPLAZAMIENTO_BASE_DIRECTO_VENTA, true);
    FieldUtils.writeField(this.tareaLocalizacionPersonaPresenciaRepositoryCustom,
        "sqlindicadorDesplazamientoBaseDirectoVentaOtraTienda",
        SQL_INDICADOR_DESPLAZAMIENTO_BASE_DIRECTO_VENTA_OTRA_TIENDA, true);
    FieldUtils.writeField(this.tareaLocalizacionPersonaPresenciaRepositoryCustom,
        "sqlIndicadorDesplazamientoDirectoVentaCambioFuncion",
        SQL_INDICADOR_DESPLAZAMIENTO_DIRECTO_VENTA_CAMBIO_FUNCION, true);
    FieldUtils.writeField(this.tareaLocalizacionPersonaPresenciaRepositoryCustom,
        "sqlIndicadorDesplazamientoChallengeImporteTienda",
        SQL_INDICADOR_DESPLAZAMIENTO_CHALLENGE_IMPORTE_TIENDA, true);
    FieldUtils.writeField(this.tareaLocalizacionPersonaPresenciaRepositoryCustom,
        "sqlUpdateActivoPersonasExternas",
        SQL_UPDATE_ACTIVO_PERSONAS_EXTERNAS, true);
    FieldUtils.writeField(this.tareaLocalizacionPersonaPresenciaRepositoryCustom,
        "sqlIndicadorDesplazamientoBaseDirectoVentaSinDesplazamiento",
        SQL_INDICADOR_DESPLAZAMIENTO_BASE_DIRECTO_VENTA_SIN_DESPLAZAMIENTO, true);
    FieldUtils.writeField(this.tareaLocalizacionPersonaPresenciaRepositoryCustom,
        "sqlPresenciaDesplazamiento",
        SQL_PRESENCIA_DESPLAZAMIENTO, true);
    FieldUtils.writeField(this.tareaLocalizacionPersonaPresenciaRepositoryCustom,
        "sqlPresenciaDesplazamientoChallengePorcentaje",
        SQL_PRESENCIA_DESPLAZAMIENTO_CHALLENGE_PORCENTAJE, true);

    FieldUtils.writeField(this.tareaLocalizacionPersonaPresenciaRepositoryCustom, "batchSize", 100, true);
  }

  @Test
  void indicadorPresenciaTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(199L);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorPresencia(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_INDICADOR_PRESENCIA, this.sqlCaptor.getValue());
    // Parámetros de la consulta: idTarea, activo, idTipoDatoIndicadorPresencia,
    // tiposCalculo, excluidoCalculo
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(6, params.getValues().size());
    // id tarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
    // activo
    assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    // idTipoDatoIndicadorPresencia
    assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA));
    assertEquals(TipoDatoEnum.INDICADOR_PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA.getId(),
        params.getValue(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA));
    // tiposCalculo
    assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_CALCULO));
    assertEquals(
        Arrays.asList(TipoCalculoEnum.DIRECTO_SOBRE_VENTA_CON_PRESENCIA.getId(),
            TipoCalculoEnum.DIRECTO_SOBRE_VENTA_CON_PRESENCIA_Y_REDUCCION_DE_JORNADA.getId()),
        params.getValue(SQL_PARAM_IDS_TIPOS_CALCULO));
    // excluidoCalculo
    assertTrue(params.hasValue(SQL_PARAM_EXCLUIDO_CALCULO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, params.getValue(SQL_PARAM_EXCLUIDO_CALCULO));
  }

  @Test
  void indicadorPresenciaDesplazamientoTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(199L);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorPresenciaDesplazamiento(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_INDICADOR_PRESENCIA_DESPLAZAMIENTO, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, activo, idTipoDatoIndicadorPresencia,
    // excluidoCalculo
    assertEquals(5, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
    // activo
    assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    // idTipoDatoIndicadorPresencia
    assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA));
    assertEquals(TipoDatoEnum.INDICADOR_PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO.getId(),
        params.getValue(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA));
    // excluidoCalculo
    assertTrue(params.hasValue(SQL_PARAM_EXCLUIDO_CALCULO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, params.getValue(SQL_PARAM_EXCLUIDO_CALCULO));
  }

  @Test
  void presenciaDesplazamientoTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(199L);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.presenciaDesplazamiento(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_PRESENCIA_DESPLAZAMIENTO, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, activo, idTipoDatoIndicadorPresencia,
    // excluidoCalculo
    assertEquals(7, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
    // activo
    assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    // idTipoDatoPresencia
    assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_DATO_PRESENCIA_DESPLAZAMIENTO));
    assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPO_HORA_DESPLAZAMIENTO.getId(),
        params.getValue(SQL_PARAM_ID_TIPO_DATO_PRESENCIA_DESPLAZAMIENTO));
    // excluidoCalculo
    assertTrue(params.hasValue(SQL_PARAM_EXCLUIDO_CALCULO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, params.getValue(SQL_PARAM_EXCLUIDO_CALCULO));
    // idsTiposDato
    assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_DATO));
    assertEquals(Arrays.asList(TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
        TipoDatoEnum.PRESENCIA_MANUAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
        TipoDatoEnum.PRESENCIA_HORAS_FIJAS_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()),
        params.getValue(SQL_PARAM_IDS_TIPOS_DATO));
    // comisionable
    assertTrue(params.hasValue(SQL_PARAM_COMISIONABLE));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_COMISIONABLE));
    // calcula
    assertTrue(params.hasValue(SQL_PARAM_CALCULA));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_CALCULA));
  }

  @Test
  void presenciaDesplazamientoChallengePorcentajeTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(199L);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.presenciaDesplazamientoChallengePorcentaje(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_PRESENCIA_DESPLAZAMIENTO_CHALLENGE_PORCENTAJE, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, activo, idTipoDatoIndicadorPresencia,
    // excluidoCalculo
    assertEquals(7, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
    // activo
    assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    // idTipoDatoPresencia
    assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_DATO_PRESENCIA_DESPLAZAMIENTO));
    assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDOCHALLENGEPORCENTAJE_DESPLAZAMIENTO.getId(),
        params.getValue(SQL_PARAM_ID_TIPO_DATO_PRESENCIA_DESPLAZAMIENTO));
    // excluidoCalculo
    assertTrue(params.hasValue(SQL_PARAM_INCLUIDO_CHALLENGE_PORCENTAJE));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_INCLUIDO_CHALLENGE_PORCENTAJE));
    // idsTiposDato
    assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_DATO));
    assertEquals(Arrays.asList(TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
        TipoDatoEnum.PRESENCIA_MANUAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
        TipoDatoEnum.PRESENCIA_HORAS_FIJAS_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()),
        params.getValue(SQL_PARAM_IDS_TIPOS_DATO));
    // comisionable
    assertTrue(params.hasValue(SQL_PARAM_COMISIONABLE));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_COMISIONABLE));
    // calcula
    assertTrue(params.hasValue(SQL_PARAM_CALCULA));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_CALCULA));
  }

  @Test
  void indicadorPresenciaDesplazamientoBaseTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(199L);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorPresenciaDesplazamientoBase(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_INDICADOR_PRESENCIA_DESPLAZAMIENTO_BASE, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, activo, idTipoDatoIndicadorPresencia,
    // excluidoCalculo
    assertEquals(6, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
    // activo
    assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    // idTipoDatoIndicadorPresencia
    assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA));
    assertEquals(TipoDatoEnum.INDICADOR_PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO_BASE.getId(),
        params.getValue(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA));
    // excluidoCalculo
    assertTrue(params.hasValue(SQL_PARAM_EXCLUIDO_CALCULO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, params.getValue(SQL_PARAM_EXCLUIDO_CALCULO));
  }

  @Test
  void indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacionTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(199L);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaLocalizacionPersonaPresenciaRepositoryCustom
        .indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_INDICADOR_PRESENCIA_DESPLAZAMIENTO_BASE_MISMA_LOCALIZACION, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, activo, idTipoDatoIndicadorPresencia,
    // excluidoCalculo
    assertEquals(5, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
    // activo
    assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    // idTipoDatoIndicadorPresencia
    assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA));
    assertEquals(
        TipoDatoEnum.INDICADOR_PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO_BASE_DESPLAZAMIENTO_MISMA_LOCALIZACION
            .getId(),
        params.getValue(SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA));
    // excluidoCalculo
    assertTrue(params.hasValue(SQL_PARAM_EXCLUIDO_CALCULO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, params.getValue(SQL_PARAM_EXCLUIDO_CALCULO));
  }

  @Test
  void updateActivoVacioTest() {

    final LocalDate fechaInicioPeriodo = LocalDate.of(2020, 1, 1);
    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(199L);
    when(tarea.getFechaInicioPeriodo()).thenReturn(fechaInicioPeriodo);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.updateActivoVacio(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_UPDATE_ACTIVO_VACIO, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, activo, minutos, fechaInicioPeriodo
    assertEquals(5, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
    // activo
    assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, params.getValue(SQL_PARAM_ACTIVO));
    // minutos
    assertTrue(params.hasValue(SQL_PARAM_MINUTOS));
    assertEquals(SQL_VALUE_MINUTOS_CERO, params.getValue(SQL_PARAM_MINUTOS));
    // Grupo dato
    assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_GRUPO_DATO));
    assertEquals(TipoGrupoDatoEnum.PRESENCIA_PERSONA_TIPOHORA.getId(),
        params.getValue(SQL_PARAM_ID_TIPO_GRUPO_DATO));
    // Fecha inico periodo
    assertTrue(params.hasValue(SQL_PARAM_FECHA_INICIO_PERIODO));
    assertEquals(TimeUtils.toDate(fechaInicioPeriodo), params.getValue(SQL_PARAM_FECHA_INICIO_PERIODO));
  }

  @Test
  void updateActivoTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(199L);
    when(tarea.getFechaInicioPeriodo()).thenReturn(LocalDate.now());
    when(runTarea.getTarea()).thenReturn(tarea);

    when(this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(12), new IdTipoDatoDto(89)));

    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.updateActivo(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_UPDATE_ACTIVO, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, excluidoDenominador, tiposDato,
    // nuevoActivo
    assertEquals(5, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
    // idTiposDato
    assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_DATO));
    assertEquals(Arrays.asList(12, 89), params.getValue(SQL_PARAM_IDS_TIPOS_DATO));
    // excluidoDenominador
    assertTrue(params.hasValue(SQL_PARAM_EXCLUIDO_DENOMINADOR));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, params.getValue(SQL_PARAM_EXCLUIDO_DENOMINADOR));
    // nuevoActivo
    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));

  }

  @Test
  void compensarTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(199L);
    when(runTarea.getTarea()).thenReturn(tarea);

    when(this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(12), new IdTipoDatoDto(89)));
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.compensar(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_COMPENSAR, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, nuevoIdSeccion, nuevoIdTipoDato,
    // excluidoDenominador, idTipoPolitica, tiposDato, activo
    assertEquals(7, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
    // nuevoIdSeccion
    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_SECCION));
    assertEquals(AppConstants.SECCION_4, params.getValue(SQL_PARAM_NUEVO_ID_SECCION));
    // nuevoIdTipoDato
    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
    assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_INCLUIDODENOMINADOR.getId(),
        params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
    // excluidoDenominador
    assertTrue(params.hasValue(SQL_PARAM_EXCLUIDO_DENOMINADOR));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, params.getValue(SQL_PARAM_EXCLUIDO_DENOMINADOR));
    // idTipoPolitica
    assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_POLITICA));
    assertEquals(TipoPoliticaEnum.EXCLUIDO_DENOMINADOR.getId(), params.getValue(SQL_PARAM_ID_TIPO_POLITICA));
    // tiposDato
    assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_DATO));
    assertEquals(Arrays.asList(12, 89), params.getValue(SQL_PARAM_IDS_TIPOS_DATO));
    // activo
    assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
  }

  @Test
  void compensarChallengeTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(199L);
    when(runTarea.getTarea()).thenReturn(tarea);

    when(this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(12), new IdTipoDatoDto(89)));
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.compensarChallenge(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_COMPENSAR_CHALLENGE, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, nuevoIdSeccion, nuevoIdTipoDato,
    // excluidoDenominador, idTipoPolitica, tiposDato, activo
    assertEquals(6, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
    // nuevoIdSeccion
    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_SECCION));
    assertEquals(AppConstants.SECCION_4, params.getValue(SQL_PARAM_NUEVO_ID_SECCION));
    // nuevoIdTipoDato
    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
    assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_INCLUIDOCHALLENGE.getId(),
        params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
    // excluidoDenominador
    assertTrue(params.hasValue(SQL_PARAM_INCLUIDO_CHALLENGE));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_INCLUIDO_CHALLENGE));
    // tiposDato
    assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_DATO));
    assertEquals(Arrays.asList(12, 89), params.getValue(SQL_PARAM_IDS_TIPOS_DATO));
    // activo
    assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
  }

  @Test
  void presenciasIncluidoVentaTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(199L);
    when(runTarea.getTarea()).thenReturn(tarea);

    when(this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()))
            .thenReturn(Arrays.asList(new IdTipoDatoDto(12), new IdTipoDatoDto(89)));
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.presenciasIncluidoVenta(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_PRESENCIAS_INCLUIDO_VENTA, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, nuevoIdSeccion, nuevoIdTipoDato, incluidoVenta, tiposDato,
    // activo
    assertEquals(6, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
    // nuevoIdSeccion
    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_SECCION));
    assertEquals(AppConstants.SECCION_4, params.getValue(SQL_PARAM_NUEVO_ID_SECCION));
    // nuevoIdTipoDato
    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
    assertEquals(TipoDatoEnum.PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_INCLUIDOVENTA.getId(),
        params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
    // excluidoDenominador
    assertTrue(params.hasValue(SQL_PARAM_INCLUIDO_VENTA));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_INCLUIDO_VENTA));
    // tiposDato
    assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_DATO));
    assertEquals(Arrays.asList(12, 89), params.getValue(SQL_PARAM_IDS_TIPOS_DATO));
    // activo
    assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
  }

  @Test
  void presenciasHorasFijasTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(199L);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.presenciasHorasFijas(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_PRESENCIAS_HORAS_FIJAS, this.sqlCaptor.getValue());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: nuevoIdTipoDato, nuevoActivo, abierto, idTarea, idTipoPolitica
    assertEquals(5, params.getValues().size());
    // nuevoIdTipoDato
    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
    assertEquals(TipoDatoEnum.PRESENCIA_HORAS_FIJAS_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
        params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
    // nuevoActivo
    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));
    // abierto
    assertTrue(params.hasValue(SQL_PARAM_ABIERTO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ABIERTO));
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
    // idTipoPolitica
    assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_POLITICA));
    assertEquals(TipoPoliticaEnum.HORAS_FIJAS.getId(), params.getValue(SQL_PARAM_ID_TIPO_POLITICA));

  }

  @Test
  void presenciasHorasFijasDesplazamientoTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(199L);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.presenciasHorasFijasDesplazamiento(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_PRESENCIAS_HORAS_FIJAS_DESPLAZAMIENTO, this.sqlCaptor.getValue());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: nuevoIdTipoDato, nuevoActivo, abierto, idTarea, idTipoPolitica
    assertEquals(5, params.getValues().size());
    // nuevoIdTipoDato
    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
    assertEquals(TipoDatoEnum.PRESENCIA_HORAS_FIJAS_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
        params.getValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));
    // nuevoActivo
    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));
    // abierto
    assertTrue(params.hasValue(SQL_PARAM_ABIERTO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ABIERTO));
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
    // idTipoPolitica
    assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_POLITICA));
    assertEquals(TipoPoliticaEnum.HORAS_FIJAS.getId(), params.getValue(SQL_PARAM_ID_TIPO_POLITICA));

  }

  @Test
  void indicadorPersonaPorVentaTest(@Random final RunTareaDto runTarea) {

    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorPersonaPorVenta(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INDICADOR_PERSONA_POR_VENTA), this.paramsCaptor.capture());
    final Map<String, Object> params = this.paramsCaptor.getValue().getValues();
    // Parámetros de la consulta: nuevoIdTipoDato, nuevoActivo, nuevoIdSeccion, idTarea, idTipoCalculo,
    // activo, idTipoGrupoDato, idTipoGrupoDatoVenta, inactivo

    final Map<String, Object> expected = new HashMap<>();
    expected.put(SQL_PARAM_NUEVO_ID_TIPO_DATO, TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA.getId());
    expected.put(SQL_PARAM_ID_TAREA, runTarea.getTarea().getId());
    expected.put(SQL_PARAM_NUEVO_ACTIVO, SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SQL_PARAM_NUEVO_ID_SECCION, AppConstants.SECCION_4);
    expected.put(SQL_PARAM_ID_TIPO_CALCULO, TipoCalculoEnum.POR_VENTA.getId());
    expected.put(SQL_PARAM_ACTIVO, SQL_VALUE_BOOLEAN_TRUE);
    // TODO [javierev] REVISAR SI ESTO SE VA A UTILIZAR REALMENTE (INDICADOR_POR_VENTA_CON_O_SIN_VENTA_INDIVIDUAL)
    expected.put(SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
    expected.put(SQL_PARAM_ID_TIPO_GRUPO_DATO_VENTA, TipoGrupoDatoEnum.OPERACIONES_VENTA_INDIVIDUAL_LOCALIZACION_SECCION.getId());
    expected.put(SQL_PARAM_INACTIVO, SQL_VALUE_BOOLEAN_FALSE);

    assertEquals(expected, params);

  }

  @Test
  void saveTest() {

    final List<TareaLocalizacionPersonaPresencia> items = Arrays
        .asList(mock(TareaLocalizacionPersonaPresencia.class));
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.save(items);
    verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(), any(SqlParameterSource[].class));
    assertEquals(SQL_SAVE, this.sqlCaptor.getValue());

  }

  @Test
  void indicadorDesplazamientoDirectoVentaTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(199L);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorDesplazamientoDirectoVenta(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_INDICADOR_DESPLAZAMIENTO_DIRECTO_VENTA, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, activo, nuevoIdTipoDato, idseccion
    assertEquals(5, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
    // activo
    assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    // nuevoIdTipoDato
    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));

  }

  @Test
  void indicadorDesplazamientoDirectoVentaSinPresenciasTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(199L);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaLocalizacionPersonaPresenciaRepositoryCustom
        .indicadorDesplazamientoDirectoVentaSinPresencias(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_INDICADOR_DESPLAZAMIENTO_DIRECTO_VENTA_SIN_PRESENCIAS, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, activo, nuevoIdTipoDato, idseccion
    assertEquals(5, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
    // activo
    assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    // nuevoIdTipoDato
    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));

  }

  @Test
  void indicadorDesplazamientoBaseDirectoVentaTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(199L);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaLocalizacionPersonaPresenciaRepositoryCustom
        .indicadorDesplazamientoBaseDirectoVenta(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_INDICADOR_DESPLAZAMIENTO_BASE_DIRECTO_VENTA, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, activo, nuevoIdTipoDato, idseccion
    assertEquals(5, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
    // activo
    assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    // nuevoIdTipoDato
    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));

  }

  @Test
  void indicadorDesplazamientoBaseDirectoVentaOtraTiendaTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(199L);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaLocalizacionPersonaPresenciaRepositoryCustom
        .indicadorDesplazamientoBaseDirectoVentaOtraTienda(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_INDICADOR_DESPLAZAMIENTO_BASE_DIRECTO_VENTA_OTRA_TIENDA, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, activo, nuevoIdTipoDato, idseccion
    assertEquals(5, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
    // activo
    assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    // nuevoIdTipoDato
    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));

  }

  @Test
  void indicadorDesplazamientoBaseDirectoVentaSinDesplazamientoTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(199L);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaLocalizacionPersonaPresenciaRepositoryCustom
        .indicadorDesplazamientoBaseDirectoVentaSinDesplazamiento(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_INDICADOR_DESPLAZAMIENTO_BASE_DIRECTO_VENTA_SIN_DESPLAZAMIENTO, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, activo, nuevoIdTipoDato, idseccion
    assertEquals(6, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
    // activo
    assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    // inactivo
    assertTrue(params.hasValue(SQL_PARAM_INACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, params.getValue(SQL_PARAM_INACTIVO));
    // nuevoIdTipoDato
    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));

  }

  @Test
  void indicadorDesplazamientoBaseDirectoVentaCambioFuncionTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(199L);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaLocalizacionPersonaPresenciaRepositoryCustom
        .indicadorDesplazamientoDirectoVentaCambioFuncion(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_INDICADOR_DESPLAZAMIENTO_DIRECTO_VENTA_CAMBIO_FUNCION, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, activo, nuevoIdTipoDato, idseccion
    assertEquals(6, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
    // activo
    assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    // nuevoIdTipoDato
    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));

  }

  @Test
  void indicadorDesplazamientoChallengeImporteTiendaTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(199L);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaLocalizacionPersonaPresenciaRepositoryCustom
        .indicadorDesplazamientoChallengeImporteTienda(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_INDICADOR_DESPLAZAMIENTO_CHALLENGE_IMPORTE_TIENDA, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, activo, nuevoIdTipoDato, idseccion
    assertEquals(6, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SQL_PARAM_ID_TAREA));
    // activo
    assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
    // nuevoIdTipoDato
    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ID_TIPO_DATO));

  }

  @Test
  void updateActivoPersonasExternasQueryTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(199L);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.updateActivoPersonasExternas(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(),
        any(MapSqlParameterSource.class));
    assertEquals(SQL_UPDATE_ACTIVO_PERSONAS_EXTERNAS, this.sqlCaptor.getValue());
  }

  @Test
  void updateActivoPersonasExternasNumParametrosTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(199L);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.updateActivoPersonasExternas(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class),
        this.paramsCaptor.capture());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // parametros de la peticion: idTarea, activo, nuevoActivo, idTipoGrupoDato
    assertEquals(4, params.getValues().size());
  }

  @Test
  void updateActivoPersonasExternasParametroIdTareaTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    final Long idTarea = 199L;
    when(tarea.getId()).thenReturn(idTarea);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.updateActivoPersonasExternas(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class),
        this.paramsCaptor.capture());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();

    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, params.getValue(SQL_PARAM_ID_TAREA));
  }

  @Test
  void updateActivoPersonasExternasParametroActivoTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    final Long idTarea = 199L;
    when(tarea.getId()).thenReturn(idTarea);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.updateActivoPersonasExternas(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class),
        this.paramsCaptor.capture());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();

    assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, params.getValue(SQL_PARAM_ACTIVO));
  }

  @Test
  void updateActivoPersonasExternasParametroNuevoActivoTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    final Long idTarea = 199L;
    when(tarea.getId()).thenReturn(idTarea);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.updateActivoPersonasExternas(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class),
        this.paramsCaptor.capture());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();

    assertTrue(params.hasValue(SQL_PARAM_NUEVO_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_FALSE, params.getValue(SQL_PARAM_NUEVO_ACTIVO));
  }

  @Test
  void updateActivoPersonasExternasParametroIdTipoGrupoDatoTest() {
    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    final Long idTarea = 199L;
    when(tarea.getId()).thenReturn(idTarea);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.updateActivoPersonasExternas(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class),
        this.paramsCaptor.capture());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();

    assertTrue(params.hasValue(SQL_PARAM_ID_TIPO_GRUPO_DATO));
    assertEquals(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_DESACTIVAR_EXTERNOS.getId(),
        params.getValue(SQL_PARAM_ID_TIPO_GRUPO_DATO));
  }

}
