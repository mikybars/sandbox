package com.inditex.rrhh.icmclcwb.model.primary.repository;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TAREA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoAusenciaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoUnidadTiempoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

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
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class PrimaryTemporaryTablePoliticasRepositoryCustomTest {

  private static final Integer UPDATE_RESULT = 100;

  private static final long ID_TAREA = 123L;

  private static final String SISTEMA_DESTINO = "SISTEMA DESTINO";

  // comun

  private static final String SQL_CREATE_TEMP_PERSONAS = "SQL CREATE TEMP PERSONAS";

  private static final String SQL_DELETE_TEMP_PERSONAS = "SQL DELETE TEMP PERSONAS";

  private static final String SQL_INSERT_TEMP_PERSONAS = "SQL INSERT TEMP PERSONAS";

  private static final String SQL_INSERT_TEMP_PERSONAS_BAJA_IT = "SQL INSERT TEMP PERSONAS";

  private static final String SQL_INDEX_TEMP_PERSONAS = "SQL INDEX TEMP PERSONAS";

  private static final String SQL_CREATE_TEMP_CALULO_CON_AJUSTE = "SQL CREATE TEMP CALCULO CON AJUSTE";

  private static final String SQL_DELETE_TEMP_CALCULO_CON_AJUSTE = "SQL DELETE TEMP CALCULO CON AJUSTE";

  private static final String SQL_INSERT_TEMP_CALCULO_CON_AJUSTE = "SQL INSERT TEMP CALCULO CON AJUSTE";

  private static final String SQL_INDEX_TEMP_CALCULO_CON_AJUSTE = "SQL INDEX TEMP CALCULO CON AJUSTE";

  private static final String SQL_INSERT_TEMP_CALCULO_CON_AJUSTE_BAJA_IT = "SQL INSERT TEMP CALCULO CON AJUSTE";

  // baja it

  private static final String SQL_CREATE_TEMP_FECHAS_BAJA_IT = "SQL CREATE TEMP FECHAS BAJA IT";

  private static final String SQL_DELETE_TEMP_FECHAS_BAJA_IT = "SQL DELETE TEMP FECHAS BAJA IT";

  private static final String SQL_INSERT_TEMP_FECHAS_BAJA_IT = "SQL INSERT TEMP FECHAS BAJA IT";

  private static final String SQL_INDEX_TEMP_FECHAS_BAJA_IT = "SQL INDEX TEMP FECHAS BAJA IT";

  private static final String SQL_CREATE_TEMP_FECHAS_ACUMULADAS_BAJA_IT = "SQL CREATE TEMP FECHAS ACUMULADAS BAJA IT";

  private static final String SQL_DELETE_TEMP_FECHAS_ACUMULADAS_BAJA_IT = "SQL DELETE TEMP FECHAS ACUMULADAS BAJA IT";

  private static final String SQL_INSERT_TEMP_FECHAS_ACUMULADAS_BAJA_IT = "SQL INSERT TEMP FECHAS ACUMULADAS BAJA IT";

  private static final String SQL_INDEX_TEMP_FECHAS_ACUMULADAS_BAJA_IT = "SQL INDEX TEMP FECHAS ACUMULADAS BAJA IT";

  // Antiguedad

  private static final String SQL_CREATE_TEMP_FECHAS_ANTIGUEDAD = "SQL CREATE TEMP FECHAS ANTIGUEDAD";

  private static final String SQL_DELETE_TEMP_FECHAS_ANTIGUEDAD = "SQL DELETE TEMP FECHAS ANTIGUEDAD";

  private static final String SQL_INSERT_TEMP_FECHAS_ANTIGUEDAD = "SQL INSERT TEMP FECHAS ANTIGUEDAD";

  private static final String SQL_INDEX_TEMP_FECHAS_ANTIGUEDAD = "SQL INDEX TEMP FECHAS ANTIGUEDAD";

  private static final String SQL_CREATE_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD = "SQL CREATE TEMP FECHAS ACUMULADAS ANTIGUEDAD";

  private static final String SQL_DELETE_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD = "SQL DELETE TEMP FECHAS ACUMULADAS ANTIGUEDAD";

  private static final String SQL_INSERT_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD = "SQL INSERT TEMP FECHAS ACUMULADAS ANTIGUEDAD";

  private static final String SQL_INDEX_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD = "SQL INDEX TEMP FECHAS ACUMULADAS ANTIGUEDAD";

  // Vacaciones

  private static final String SQL_CREATE_TEMP_FECHAS_VACACIONES = "SQL CREATE TEMP FECHAS VACACIONES";

  private static final String SQL_DELETE_TEMP_FECHAS_VACACIONES = "SQL DELETE TEMP FECHAS VACACIONES";

  private static final String SQL_INSERT_TEMP_FECHAS_VACACIONES = "SQL INSERT TEMP FECHAS VACACIONES";

  private static final String SQL_INDEX_TEMP_FECHAS_VACACIONES = "SQL INDEX TEMP FECHAS VACACIONES";

  private static final String SQL_CREATE_TEMP_FECHAS_ACUMULADAS_VACACIONES = "SQL CREATE TEMP FECHAS ACUMULADAS VACACIONES";

  private static final String SQL_DELETE_TEMP_FECHAS_ACUMULADAS_VACACIONES = "SQL DELETE TEMP FECHAS ACUMULADAS VACACIONES";

  private static final String SQL_INSERT_TEMP_FECHAS_ACUMULADAS_VACACIONES = "SQL INSERT TEMP FECHAS ACUMULADAS VACACIONES";

  private static final String SQL_INDEX_TEMP_FECHAS_ACUMULADAS_VACACIONES = "SQL INDEX TEMP FECHAS ACUMULADAS VACACIONES";

  // Máximo / Mínimo garantizado (común)

  private static final String SQL_CREATE_TEMP_AUSENCIAS_DATE_MAXIMO_MINIMO_GARANTIZADO =
      "SQL CREATE TEMP AUSENCIAS DATE MAXIMO / MINIMO GARANTIZADO";

  private static final String SQL_DELETE_TEMP_AUSENCIAS_DATE_MAXIMO_MINIMO_GARANTIZADO =
      "SQL DELETE TEMP AUSENCIAS DATE MAXIMO / MINIMO GARANTIZADO";

  private static final String SQL_INSERT_TEMP_AUSENCIAS_DATE_MAXIMO_MINIMO_GARANTIZADO =
      "SQL INSERT TEMP AUSENCIAS DATE MAXIMO / MINIMO GARANTIZADO";

  private static final String SQL_INDEX_TEMP_AUSENCIAS_DATE_MAXIMO_MINIMO_GARANTIZADO =
      "SQL INDEX TEMP AUSENCIAS DATE MAXIMO / MINIMO GARANTIZADO";

  private static final String SQL_CREATE_TEMP_DATOS_MAXIMO_MINIMO_GARANTIZADO = "SQL CREATE TEMP DATOS MAXIMO / MINIMO GARANTIZADO";

  private static final String SQL_DELETE_TEMP_DATOS_MAXIMO_MINIMO_GARANTIZADO = "SQL DELETE TEMP DATOS MAXIMO / MINIMO GARANTIZADO";

  private static final String SQL_INDEX_TEMP_DATOS_MAXIMO_MINIMO_GARANTIZADO = "SQL INDEX TEMP DATOS MAXIMO / MINIMO GARANTIZADO";

  // Máximo garantizado

  private static final String SQL_INSERT_TEMP_DATOS_MAXIMO_GARANTIZADO = "SQL INSERT TEMP DATOS MAXIMO GARANTIZADO";

  // Mínimo garantizado

  private static final String SQL_INSERT_TEMP_DATOS_MINIMO_GARANTIZADO = "SQL INSERT TEMP DATOS MINIMO GARANTIZADO";

  // carencia

  private static final String SQL_CREATE_TEMP_FECHAS_CARENCIA = "SQL CREATE TEMP FECHAS CARENCIA";

  private static final String SQL_DELETE_TEMP_FECHAS_CARENCIA = "SQL DELETE TEMP FECHAS CARENCIA";

  private static final String SQL_INSERT_TEMP_FECHAS_CARENCIA = "SQL INSERT TEMP FECHAS CARENCIA";

  private static final String SQL_INDEX_TEMP_FECHAS_CARENCIA = "SQL INDEX TEMP FECHAS CARENCIA";

  private static final String SQL_CREATE_TEMP_FECHAS_ACUMULADAS_CARENCIA = "SQL CREATE TEMP FECHAS ACUMULADAS CARENCIA";

  private static final String SQL_DELETE_TEMP_FECHAS_ACUMULADAS_CARENCIA = "SQL DELETE TEMP FECHAS ACUMULADAS CARENCIA";

  private static final String SQL_INSERT_TEMP_FECHAS_ACUMULADAS_CARENCIA = "SQL INSERT TEMP FECHAS ACUMULADAS CARENCIA";

  private static final String SQL_INDEX_TEMP_FECHAS_ACUMULADAS_CARENCIA = "SQL INDEX TEMP FECHAS ACUMULADAS CARENCIA";

  private static final String SQL_INSERT_TEMP_CALCULO_CAON_AJUSTE_CARENCIA = "SQL INSERT TEMP CALCULO CON AJUSTE CARENCIA";

  @Mock
  private JdbcTemplate jdbcTemplate;

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource[]> batchParamsCaptor;

  @InjectMocks
  private PrimaryTemporaryTablePoliticasRepositoryCustomImpl primaryTemporaryTablePoliticasRepositoryCustom;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    when(this.jdbcTemplate.update(any(String.class))).thenReturn(UPDATE_RESULT);
    // comun
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlCreateTempPersonas", SQL_CREATE_TEMP_PERSONAS, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlDeleteTempPersonas", SQL_DELETE_TEMP_PERSONAS, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlInsertTempPersonas", SQL_INSERT_TEMP_PERSONAS, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlInsertTempPersonasBajaIt", SQL_INSERT_TEMP_PERSONAS_BAJA_IT, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlIndexTempPersonas", SQL_INDEX_TEMP_PERSONAS, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlCreateTempCalculoConAjuste", SQL_CREATE_TEMP_CALULO_CON_AJUSTE, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlDeleteTempCalculoConAjuste", SQL_DELETE_TEMP_CALCULO_CON_AJUSTE, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlInsertTempCalculoConAjuste", SQL_INSERT_TEMP_CALCULO_CON_AJUSTE, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlInsertTempCalculoConAjusteBajaIt", SQL_INSERT_TEMP_CALCULO_CON_AJUSTE_BAJA_IT, true);

    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlIndexTempCalculoConAjuste", SQL_INDEX_TEMP_CALCULO_CON_AJUSTE, true);
    // baja it
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlCreateTempFechasBajaIt", SQL_CREATE_TEMP_FECHAS_BAJA_IT, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlDeleteTempFechasBajaIt", SQL_DELETE_TEMP_FECHAS_BAJA_IT, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlInsertTempFechasBajaIt", SQL_INSERT_TEMP_FECHAS_BAJA_IT, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlIndexTempFechasBajaIt", SQL_INDEX_TEMP_FECHAS_BAJA_IT, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlCreateTempFechasAcumuladasBajaIt", SQL_CREATE_TEMP_FECHAS_ACUMULADAS_BAJA_IT, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlDeleteTempFechasAcumuladasBajaIt", SQL_DELETE_TEMP_FECHAS_ACUMULADAS_BAJA_IT, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlInsertTempFechasAcumuladasBajaIt", SQL_INSERT_TEMP_FECHAS_ACUMULADAS_BAJA_IT, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlIndexTempFechasAcumuladasBajaIt", SQL_INDEX_TEMP_FECHAS_ACUMULADAS_BAJA_IT, true);
    // Antiguedad
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlCreateTempFechasAntiguedad", SQL_CREATE_TEMP_FECHAS_ANTIGUEDAD, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlDeleteTempFechasAntiguedad", SQL_DELETE_TEMP_FECHAS_ANTIGUEDAD, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlInsertTempFechasAntiguedad", SQL_INSERT_TEMP_FECHAS_ANTIGUEDAD, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlIndexTempFechasAntiguedad", SQL_INDEX_TEMP_FECHAS_ANTIGUEDAD, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlCreateTempFechasAcumuladasAntiguedad", SQL_CREATE_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlDeleteTempFechasAcumuladasAntiguedad", SQL_DELETE_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlInsertTempFechasAcumuladasAntiguedad", SQL_INSERT_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlIndexTempFechasAcumuladasAntiguedad", SQL_INDEX_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD, true);
    // Vacaciones
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlCreateTempFechasVacaciones", SQL_CREATE_TEMP_FECHAS_VACACIONES, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlDeleteTempFechasVacaciones", SQL_DELETE_TEMP_FECHAS_VACACIONES, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlInsertTempFechasVacaciones", SQL_INSERT_TEMP_FECHAS_VACACIONES, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlIndexTempFechasVacaciones", SQL_INDEX_TEMP_FECHAS_VACACIONES, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlCreateTempFechasAcumuladasVacaciones", SQL_CREATE_TEMP_FECHAS_ACUMULADAS_VACACIONES, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlDeleteTempFechasAcumuladasVacaciones", SQL_DELETE_TEMP_FECHAS_ACUMULADAS_VACACIONES, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlInsertTempFechasAcumuladasVacaciones", SQL_INSERT_TEMP_FECHAS_ACUMULADAS_VACACIONES, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlIndexTempFechasAcumuladasVacaciones", SQL_INDEX_TEMP_FECHAS_ACUMULADAS_VACACIONES, true);
    // Máximo / mínimo garantizado
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlCreateTempAusenciasDateMaximoMinimoGarantizado",
        SQL_CREATE_TEMP_AUSENCIAS_DATE_MAXIMO_MINIMO_GARANTIZADO,
        true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlDeleteTempAusenciasDateMaximoMinimoGarantizado",
        SQL_DELETE_TEMP_AUSENCIAS_DATE_MAXIMO_MINIMO_GARANTIZADO,
        true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlInsertTempAusenciasDateMaximoMinimoGarantizado",
        SQL_INSERT_TEMP_AUSENCIAS_DATE_MAXIMO_MINIMO_GARANTIZADO,
        true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlIndexTempAusenciasDateMaximoMinimoGarantizado",
        SQL_INDEX_TEMP_AUSENCIAS_DATE_MAXIMO_MINIMO_GARANTIZADO, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlCreateTempDatosMaximoMinimoGarantizado", SQL_CREATE_TEMP_DATOS_MAXIMO_MINIMO_GARANTIZADO, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlDeleteTempDatosMaximoMinimoGarantizado", SQL_DELETE_TEMP_DATOS_MAXIMO_MINIMO_GARANTIZADO, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlIndexTempDatosMaximoMinimoGarantizado", SQL_INDEX_TEMP_DATOS_MAXIMO_MINIMO_GARANTIZADO, true);
    // Máximo garantizado
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlInsertTempDatosMaximoGarantizado", SQL_INSERT_TEMP_DATOS_MAXIMO_GARANTIZADO, true);
    // Mínimo garantizado
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlInsertTempDatosMinimoGarantizado", SQL_INSERT_TEMP_DATOS_MINIMO_GARANTIZADO, true);
    // Carencia
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlCreateTempFechasCarencia", SQL_CREATE_TEMP_FECHAS_CARENCIA, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlDeleteTempFechasCarencia", SQL_DELETE_TEMP_FECHAS_CARENCIA, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlInsertTempFechasCarencia", SQL_INSERT_TEMP_FECHAS_CARENCIA, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlIndexTempFechasCarencia", SQL_INDEX_TEMP_FECHAS_CARENCIA, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlCreateTempFechasAcumuladasCarencia", SQL_CREATE_TEMP_FECHAS_ACUMULADAS_CARENCIA, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlDeleteTempFechasAcumuladasCarencia", SQL_DELETE_TEMP_FECHAS_ACUMULADAS_CARENCIA, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlInsertTempFechasAcumuladasCarencia", SQL_INSERT_TEMP_FECHAS_ACUMULADAS_CARENCIA, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlIndexTempFechasAcumuladasCarencia", SQL_INDEX_TEMP_FECHAS_ACUMULADAS_CARENCIA, true);
    FieldUtils.writeField(this.primaryTemporaryTablePoliticasRepositoryCustom,
        "sqlInsertTempCalculoTotalizadoCarencia", SQL_INSERT_TEMP_CALCULO_CAON_AJUSTE_CARENCIA, true);
  }

  private TareaDto createTarea() {
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    return tarea;
  }

  // Inicio tests baja it

  @Test
  void createTempPersonasTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.createTempPersonas();
    verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_PERSONAS);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void deleteTempPersonasTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempPersonas();
    verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_PERSONAS);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void createIndexTempPersonasTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
        .createIndexTempPersonas();
    verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_PERSONAS);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void insertTempPersonasTest() {
    final IdPersonaLocalDto persona1 = mock(IdPersonaLocalDto.class);
    when(persona1.getIdPersonaLocal()).thenReturn("AT1001");
    when(persona1.getStdOrHrPeriod()).thenReturn("01");
    final IdPersonaLocalDto persona2 = mock(IdPersonaLocalDto.class);
    when(persona2.getIdPersonaLocal()).thenReturn("AT1002");
    when(persona2.getStdOrHrPeriod()).thenReturn("02");
    final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempPersonas(this.createTarea(), personas,
        TipoPoliticaEnum.MAXIMO_GARANTIZADO);

    verify(this.namedParameterJdbcTemplate).batchUpdate(eq(SQL_INSERT_TEMP_PERSONAS),
        this.batchParamsCaptor.capture());

    // parametros de la consulta: idTarea, cclIdPerson, stdOrHrPeriod, idTipoPolitica
    final MapSqlParameterSource[] values = this.batchParamsCaptor.getValue();
    assertEquals(2, values.length);
    for (int i = 0; i < values.length; i++) {
      final MapSqlParameterSource value = values[i];
      // idTarea
      assertTrue(value.hasValue(SQL_PARAM_ID_TAREA));
      assertEquals(ID_TAREA, value.getValue(SQL_PARAM_ID_TAREA));
      // idTipoPolitica
      assertTrue(value.hasValue(SQL_PARAM_ID_TIPO_POLITICA));
      assertEquals(TipoPoliticaEnum.MAXIMO_GARANTIZADO.getId(), value.getValue(SQL_PARAM_ID_TIPO_POLITICA));
      // cclIdPerson, stdOrHrPeriod - existencia del parámetro
      assertTrue(value.hasValue(SQL_PARAM_CCL_ID_PERSON));
      assertTrue(value.hasValue(SQL_PARAM_STD_OR_HR_PERIOD));
    }

    // cclIdPerson, stdOrHrPeriod - valores del parámetro
    assertEquals(1,
        Arrays.stream(values)
            .filter(value -> persona1.getIdPersonaLocal().equals(value.getValue(SQL_PARAM_CCL_ID_PERSON))
                && persona1.getStdOrHrPeriod().equals(value.getValue(SQL_PARAM_STD_OR_HR_PERIOD)))
            .toArray().length);
    assertEquals(1,
        Arrays.stream(values)
            .filter(value -> persona2.getIdPersonaLocal().equals(value.getValue(SQL_PARAM_CCL_ID_PERSON))
                && persona2.getStdOrHrPeriod().equals(value.getValue(SQL_PARAM_STD_OR_HR_PERIOD)))

            .toArray().length);
  }

  @Test
  void insertTempPersonasBajaItTest() {
    final IdPersonaLocalDto persona1 = mock(IdPersonaLocalDto.class);
    when(persona1.getIdPersonaLocal()).thenReturn("AT1001");
    when(persona1.getStdOrHrPeriod()).thenReturn("01");
    final IdPersonaLocalDto persona2 = mock(IdPersonaLocalDto.class);
    when(persona2.getIdPersonaLocal()).thenReturn("AT1002");
    when(persona2.getStdOrHrPeriod()).thenReturn("02");
    final List<IdPersonaLocalDto> personas = Arrays.asList(persona1, persona2);
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempPersonasBajaIt(this.createTarea(), personas,
        TipoPoliticaEnum.MAXIMO_GARANTIZADO);

    verify(this.namedParameterJdbcTemplate).batchUpdate(eq(SQL_INSERT_TEMP_PERSONAS_BAJA_IT),
        this.batchParamsCaptor.capture());

    // parametros de la consulta: idTarea, cclIdPerson, stdOrHrPeriod, idTipoPolitica
    final MapSqlParameterSource[] values = this.batchParamsCaptor.getValue();
    assertEquals(2, values.length);
    for (int i = 0; i < values.length; i++) {
      final MapSqlParameterSource value = values[i];
      // idTarea
      assertTrue(value.hasValue(SQL_PARAM_ID_TAREA));
      assertEquals(ID_TAREA, value.getValue(SQL_PARAM_ID_TAREA));
      // idTipoPolitica
      assertTrue(value.hasValue(SQL_PARAM_ID_TIPO_POLITICA));
      assertEquals(TipoPoliticaEnum.MAXIMO_GARANTIZADO.getId(), value.getValue(SQL_PARAM_ID_TIPO_POLITICA));
      // cclIdPerson, stdOrHrPeriod - existencia del parámetro
      assertTrue(value.hasValue(SQL_PARAM_CCL_ID_PERSON));
      assertTrue(value.hasValue(SQL_PARAM_STD_OR_HR_PERIOD));
    }

    // cclIdPerson, stdOrHrPeriod - valores del parámetro
    assertEquals(1,
        Arrays.stream(values)
            .filter(value -> persona1.getIdPersonaLocal().equals(value.getValue(SQL_PARAM_CCL_ID_PERSON))
                && persona1.getStdOrHrPeriod().equals(value.getValue(SQL_PARAM_STD_OR_HR_PERIOD)))
            .toArray().length);
    assertEquals(1,
        Arrays.stream(values)
            .filter(value -> persona2.getIdPersonaLocal().equals(value.getValue(SQL_PARAM_CCL_ID_PERSON))
                && persona2.getStdOrHrPeriod().equals(value.getValue(SQL_PARAM_STD_OR_HR_PERIOD)))

            .toArray().length);
  }

  @Test
  void createTempFechasBajaItTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasBajaIt();
    verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_FECHAS_BAJA_IT);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void deleteTempFechasBajaItTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasBajaIt();
    verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_FECHAS_BAJA_IT);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void createIndexTempFechasBajaItTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
        .createIndexTempFechasBajaIt();
    verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_FECHAS_BAJA_IT);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void insertTempFechasBajaItNumArgumentosTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasBajaIt(this.createTarea());
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_BAJA_IT),
        this.paramsCaptor.capture());
    assertEquals(4, this.paramsCaptor.getValue().getValues().size());
  }

  @Test
  void insertTempFechasBajaItUnidadTiempoAnosTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasBajaIt(this.createTarea());
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_BAJA_IT),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));
    assertEquals(TipoUnidadTiempoEnum.ANOS.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));

  }

  @Test
  void insertTempFechasBajaItUnidadTiempoMesesTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasBajaIt(this.createTarea());
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_BAJA_IT),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));
    assertEquals(TipoUnidadTiempoEnum.MESES.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));

  }

  @Test
  void insertTempFechasBajaItUnidadTiempoSemanasTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasBajaIt(this.createTarea());
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_BAJA_IT),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));
    assertEquals(TipoUnidadTiempoEnum.SEMANAS.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));

  }

  @Test
  void insertTempFechasBajaItUnidadTiempoDiasTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasBajaIt(this.createTarea());
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_BAJA_IT),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));
    assertEquals(TipoUnidadTiempoEnum.DIAS.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));

  }

  @Test
  void createTempFechasAcumuladasBajaItTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAcumuladasBajaIt();
    verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_FECHAS_ACUMULADAS_BAJA_IT);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void deleteTempFechasAcumuladasBajaItTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAcumuladasBajaIt();
    verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_FECHAS_ACUMULADAS_BAJA_IT);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void createIndexTempFechasAcumuladasBajaItTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
        .createIndexTempFechasAcumuladasBajaIt();
    verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_FECHAS_ACUMULADAS_BAJA_IT);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void insertTempFechasAcumuladasBajaItNumArgumentosTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasBajaIt();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_BAJA_IT),
        this.paramsCaptor.capture());
    assertEquals(4, this.paramsCaptor.getValue().getValues().size());
  }

  @Test
  void insertTempFechasAcumuladasBajaItUnidadTiempoAnosTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasBajaIt();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_BAJA_IT),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));
    assertEquals(TipoUnidadTiempoEnum.ANOS.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));

  }

  @Test
  void insertTempFechasAcumuladasBajaItUnidadTiempoMesesTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasBajaIt();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_BAJA_IT),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));
    assertEquals(TipoUnidadTiempoEnum.MESES.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));

  }

  @Test
  void insertTempFechasAcumuladasBajaItUnidadTiempoSemanasTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasBajaIt();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_BAJA_IT),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));
    assertEquals(TipoUnidadTiempoEnum.SEMANAS.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));

  }

  @Test
  void insertTempFechasAcumuladasBajaItUnidadTiempoDiasTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasBajaIt();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_BAJA_IT),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));
    assertEquals(TipoUnidadTiempoEnum.DIAS.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));

  }

  @Test
  void createTempCalculoTotalizadoBajaItTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.createTempCalculoConAjuste();
    verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_CALULO_CON_AJUSTE);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void deleteTempCalculoTotalizadoBajaItTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempCalculoConAjuste();
    verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_CALCULO_CON_AJUSTE);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void createIndexTempCalculoTotalizadoBajaItTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
        .createIndexTempCalculoConAjuste();
    verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_CALCULO_CON_AJUSTE);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void insertTempCalculoTotalizadoBajaItNumArgumentosTareaNotNullTest() {
    final List<TipoPoliticaEnum> politicas = Arrays.asList(TipoPoliticaEnum.ANTIGUEDAD, TipoPoliticaEnum.VACACIONES,
        TipoPoliticaEnum.BAJA_IT);
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoConAjusteBajaIt(politicas);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_CALCULO_CON_AJUSTE_BAJA_IT),
        this.paramsCaptor.capture());
    assertEquals(2, this.paramsCaptor.getValue().getValues().size());
  }

  @Test
  void insertTempCalculoTotalizadoBajaItInactivoTest() {
    final List<TipoPoliticaEnum> politicas = Arrays.asList(TipoPoliticaEnum.ANTIGUEDAD, TipoPoliticaEnum.VACACIONES,
        TipoPoliticaEnum.BAJA_IT);
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoConAjusteBajaIt(politicas);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_CALCULO_CON_AJUSTE_BAJA_IT),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
        params.getValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));

  }

  @Test
  void insertTempCalculoTotalizadoBajaItIdTipoPoliticaAjusteTest() {
    final List<TipoPoliticaEnum> politicas = Arrays.asList(TipoPoliticaEnum.ANTIGUEDAD, TipoPoliticaEnum.VACACIONES,
        TipoPoliticaEnum.BAJA_IT);
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoConAjusteBajaIt(politicas);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_CALCULO_CON_AJUSTE_BAJA_IT),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE));
    assertNotNull(params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE));
    assertTrue(params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE) instanceof List);
    final List<?> param = (List<?>) params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE);
    if (param != null) {
      assertEquals(3, param.size());
      assertTrue(param.contains(TipoPoliticaEnum.ANTIGUEDAD.getIdMeta4()));
      assertTrue(param.contains(TipoPoliticaEnum.VACACIONES.getIdMeta4()));
      assertTrue(param.contains(TipoPoliticaEnum.BAJA_IT.getIdMeta4()));
    }

  }

  // Fin tests baja it

  // Inicio tests antiguedad

  @Test
  void createTempFechasAntiguedadTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAntiguedad();
    verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_FECHAS_ANTIGUEDAD);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void deleteTempFechasAntiguedadTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAntiguedad();
    verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_FECHAS_ANTIGUEDAD);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void createIndexTempFechasAntiguedadTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
        .createIndexTempFechasAntiguedad();
    verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_FECHAS_ANTIGUEDAD);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void insertTempFechasAntiguedadNumArgumentosTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAntiguedad();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ANTIGUEDAD),
        this.paramsCaptor.capture());
    assertEquals(4, this.paramsCaptor.getValue().getValues().size());
  }

  @Test
  void insertTempFechasAntiguedadUnidadTiempoAnosTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAntiguedad();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ANTIGUEDAD),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));
    assertEquals(TipoUnidadTiempoEnum.ANOS.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));

  }

  @Test
  void insertTempFechasAntiguedadUnidadTiempoMesesTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAntiguedad();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ANTIGUEDAD),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));
    assertEquals(TipoUnidadTiempoEnum.MESES.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));

  }

  @Test
  void insertTempFechasAntiguedadUnidadTiempoSemanasTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAntiguedad();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ANTIGUEDAD),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));
    assertEquals(TipoUnidadTiempoEnum.SEMANAS.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));

  }

  @Test
  void insertTempFechasAntiguedadUnidadTiempoDiasTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAntiguedad();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ANTIGUEDAD),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));
    assertEquals(TipoUnidadTiempoEnum.DIAS.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));

  }

  @Test
  void createTempFechasAcumuladasAntiguedadTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAcumuladasAntiguedad();
    verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void deleteTempFechasAcumuladasAntiguedadTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAcumuladasAntiguedad();
    verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void createIndexTempFechasAcumuladasAntiguedadTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
        .createIndexTempFechasAcumuladasAntiguedad();
    verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void insertTempFechasAcumuladasAntiguedadNumArgumentosTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasAntiguedad();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD),
        this.paramsCaptor.capture());
    assertEquals(4, this.paramsCaptor.getValue().getValues().size());
  }

  @Test
  void insertTempFechasAcumuladasAntiguedadUnidadTiempoAnosTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasAntiguedad();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));
    assertEquals(TipoUnidadTiempoEnum.ANOS.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));

  }

  @Test
  void insertTempFechasAcumuladasAntiguedadUnidadTiempoMesesTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasAntiguedad();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));
    assertEquals(TipoUnidadTiempoEnum.MESES.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));

  }

  @Test
  void insertTempFechasAcumuladasAntiguedadUnidadTiempoSemanasTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasAntiguedad();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));
    assertEquals(TipoUnidadTiempoEnum.SEMANAS.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));

  }

  @Test
  void insertTempFechasAcumuladasAntiguedadUnidadTiempoDiasTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasAntiguedad();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_ANTIGUEDAD),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));
    assertEquals(TipoUnidadTiempoEnum.DIAS.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));

  }

  // Fin tests antiguedad

  // Inicio tests vacaciones

  @Test
  void createTempFechasVacacionesTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasVacaciones();
    verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_FECHAS_VACACIONES);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void deleteTempFechasVacacionesTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasVacaciones();
    verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_FECHAS_VACACIONES);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void createIndexTempFechasVacacionesTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
        .createIndexTempFechasVacaciones();
    verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_FECHAS_VACACIONES);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void insertTempFechasVacacionesNumArgumentosTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasVacaciones();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_VACACIONES),
        this.paramsCaptor.capture());
    assertEquals(5, this.paramsCaptor.getValue().getValues().size());
  }

  @Test
  void insertTempFechasVacacionesUnidadTiempoAnosTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasVacaciones();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_VACACIONES),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));
    assertEquals(TipoUnidadTiempoEnum.ANOS.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));

  }

  @Test
  void insertTempFechasVacacionesUnidadTiempoMesesTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasVacaciones();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_VACACIONES),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));
    assertEquals(TipoUnidadTiempoEnum.MESES.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));

  }

  @Test
  void insertTempFechasVacacionesUnidadTiempoSemanasTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasVacaciones();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_VACACIONES),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));
    assertEquals(TipoUnidadTiempoEnum.SEMANAS.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));

  }

  @Test
  void insertTempFechasVacacionesUnidadTiempoDiasTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasVacaciones();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_VACACIONES),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));
    assertEquals(TipoUnidadTiempoEnum.DIAS.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));

  }

  @Test
  void insertTempFechasVacacionesIdTipoAusenciaTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasVacaciones();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_VACACIONES),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_AUSENCIA));
    assertEquals(TipoAusenciaEnum.VACACIONES.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_AUSENCIA));

  }

  @Test
  void createTempFechasAcumuladasVacacionesTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAcumuladasVacaciones();
    verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_FECHAS_ACUMULADAS_VACACIONES);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void deleteTempFechasAcumuladasVacacionesTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAcumuladasVacaciones();
    verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_FECHAS_ACUMULADAS_VACACIONES);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void createIndexTempFechasAcumuladasVacacionesTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
        .createIndexTempFechasAcumuladasVacaciones();
    verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_FECHAS_ACUMULADAS_VACACIONES);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void insertTempFechasAcumuladasVacacionesNumArgumentosTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasVacaciones();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_VACACIONES),
        this.paramsCaptor.capture());
    assertEquals(4, this.paramsCaptor.getValue().getValues().size());
  }

  @Test
  void insertTempFechasAcumuladasVacacionesUnidadTiempoAnosTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasVacaciones();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_VACACIONES),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));
    assertEquals(TipoUnidadTiempoEnum.ANOS.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));

  }

  @Test
  void insertTempFechasAcumuladasVacacionesUnidadTiempoMesesTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasVacaciones();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_VACACIONES),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));
    assertEquals(TipoUnidadTiempoEnum.MESES.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));

  }

  @Test
  void insertTempFechasAcumuladasVacacionesUnidadTiempoSemanasTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasVacaciones();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_VACACIONES),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));
    assertEquals(TipoUnidadTiempoEnum.SEMANAS.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));

  }

  @Test
  void insertTempFechasAcumuladasVacacionesUnidadTiempoDiasTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasVacaciones();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_VACACIONES),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));
    assertEquals(TipoUnidadTiempoEnum.DIAS.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));

  }

  // Fin tests vacaciones

  // Inicio tests máximo / mínimo garantizado (común)

  @Test
  void createTempAusenciasDateMaximoMinimoGarantizadoTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
        .createTempAusenciasDateMaximoMinimoGarantizado();
    verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_AUSENCIAS_DATE_MAXIMO_MINIMO_GARANTIZADO);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void deleteTempAusenciasDateMaximoMinimoGarantizadoTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
        .deleteTempAusenciasDateMaximoMinimoGarantizado();
    verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_AUSENCIAS_DATE_MAXIMO_MINIMO_GARANTIZADO);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void createIndexTempAusenciasDateMaximoMinimoGarantizadoTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
        .createIndexTempAusenciasDateMaximoMinimoGarantizado();
    verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_AUSENCIAS_DATE_MAXIMO_MINIMO_GARANTIZADO);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void insertTempAusenciasDateMaximoMinimoGarantizadoTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom
        .insertTempAusenciasDateMaximoMinimoGarantizado();
    verify(this.jdbcTemplate, times(1)).update(SQL_INSERT_TEMP_AUSENCIAS_DATE_MAXIMO_MINIMO_GARANTIZADO);

  }

  @Test
  void createTempDatosMaximoGarantizadoTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.createTempDatosMaximoMinimoGarantizado();
    verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_DATOS_MAXIMO_MINIMO_GARANTIZADO);
    assertEquals(UPDATE_RESULT, result);
  }

  // Fin tests máximo / mínimo garantizado (común)

  // Inicio tests máximo garantizado

  @Test
  void deleteTempDatosMaximoGarantizadoTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempDatosMaximoMinimoGarantizado();
    verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_DATOS_MAXIMO_MINIMO_GARANTIZADO);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void createIndexTempDatosMaximoGarantizadoTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
        .createIndexTempDatosMaximoMinimoGarantizado();
    verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_DATOS_MAXIMO_MINIMO_GARANTIZADO);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void insertTempDatosMaximoGarantizadoNumArgumentosTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom
        .insertTempDatosMaximoGarantizado();
    verify(this.jdbcTemplate, times(1)).update(SQL_INSERT_TEMP_DATOS_MAXIMO_GARANTIZADO);
  }

  // Fin tests máximo garantizado

  // Inicio tests mínimo garantizado

  @Test
  void insertTempDatosMinimoGarantizadoTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempDatosMininimoGarantizado();
    verify(this.jdbcTemplate, times(1)).update(SQL_INSERT_TEMP_DATOS_MINIMO_GARANTIZADO);
  }

  // Fin tests mínimo garantizado

  // Inicio tests baja it

  @Test
  void createTempFechasCarenciaTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasCarencia();
    verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_FECHAS_CARENCIA);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void deleteTempFechasCarenciaTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasCarencia();
    verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_FECHAS_CARENCIA);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void createIndexTempFechasCarenciaTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
        .createIndexTempFechasCarencia();
    verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_FECHAS_CARENCIA);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void insertTempFechasCarenciaNumArgumentosNullTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasCarencia();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_CARENCIA),
        this.paramsCaptor.capture());
    assertEquals(4, this.paramsCaptor.getValue().getValues().size());
  }

  @Test
  void insertTempFechasCarenciaUnidadTiempoAnosTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasCarencia();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_CARENCIA),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));
    assertEquals(TipoUnidadTiempoEnum.ANOS.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));

  }

  @Test
  void insertTempFechasCarenciaUnidadTiempoMesesTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasCarencia();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_CARENCIA),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));
    assertEquals(TipoUnidadTiempoEnum.MESES.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));

  }

  @Test
  void insertTempFechasCarenciaUnidadTiempoSemanasTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasCarencia();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_CARENCIA),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));
    assertEquals(TipoUnidadTiempoEnum.SEMANAS.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));

  }

  @Test
  void insertTempFechasCarenciaUnidadTiempoDiasTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasCarencia();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_CARENCIA),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));
    assertEquals(TipoUnidadTiempoEnum.DIAS.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));

  }

  @Test
  void createTempFechasAcumuladasCarenciaTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAcumuladasCarencia();
    verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_FECHAS_ACUMULADAS_CARENCIA);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void deleteTempFechasAcumuladasCarenciaTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAcumuladasCarencia();
    verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_FECHAS_ACUMULADAS_CARENCIA);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void createIndexTempFechasAcumuladasCarenciaTest() {
    final int result = this.primaryTemporaryTablePoliticasRepositoryCustom
        .createIndexTempFechasAcumuladasCarencia();
    verify(this.jdbcTemplate, times(1)).update(SQL_INDEX_TEMP_FECHAS_ACUMULADAS_CARENCIA);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void insertTempFechasAcumuladasCarenciaNumArgumentosTareaTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasCarencia();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_CARENCIA),
        this.paramsCaptor.capture());
    assertEquals(4, this.paramsCaptor.getValue().getValues().size());
  }

  @Test
  void insertTempFechasAcumuladasCarenciaUnidadTiempoAnosTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasCarencia();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_CARENCIA),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));
    assertEquals(TipoUnidadTiempoEnum.ANOS.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS));

  }

  @Test
  void insertTempFechasAcumuladasCarenciaUnidadTiempoMesesTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasCarencia();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_CARENCIA),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));
    assertEquals(TipoUnidadTiempoEnum.MESES.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES));

  }

  @Test
  void insertTempFechasAcumuladasCarenciaUnidadTiempoSemanasTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasCarencia();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_CARENCIA),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));
    assertEquals(TipoUnidadTiempoEnum.SEMANAS.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS));

  }

  @Test
  void insertTempFechasAcumuladasCarenciaUnidadTiempoDiasTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasCarencia();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_FECHAS_ACUMULADAS_CARENCIA),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));
    assertEquals(TipoUnidadTiempoEnum.DIAS.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS));

  }

  @Test
  void insertTempCalculoTotalizadoCarenciaNumArgumentosTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoConAjusteCarencia();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_CALCULO_CAON_AJUSTE_CARENCIA),
        this.paramsCaptor.capture());
    assertEquals(1, this.paramsCaptor.getValue().getValues().size());
  }

  @Test
  void insertTempCalculoTotalizadoCarenciaInactivoTest() {
    this.primaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoConAjusteCarencia();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_CALCULO_CAON_AJUSTE_CARENCIA),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
        params.getValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));

  }

  // Fin tests carencia

}
