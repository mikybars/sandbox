package com.inditex.rrhh.icmclcwb.model.primary.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalComisionManualDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlComisConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.RunUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class PrimaryTemporaryTableRepositoryCustomTest {

  private final static String ID_TAREA_PARAM = "idTarea";

  private final static String INACTIVO_PARAM = "inactivo";

  private final static String IMPORTE_PARAM = "importe";

  private final static Integer SQL_ZERO_VALUE = 0;

  private final static String FECHA_INICIO_PERIODO_PARAM = "fechaInicioPeriodo";

  private final static String FECHA_HASTA_PARAM = "fechaHasta";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Mock
  private JdbcTemplate jdbcTemplate;

  @InjectMocks
  private PrimaryTemporaryTableRepositoryCustomImpl primaryTemporaryTableRepositoryCustom;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  // baja it

  private final static String SQL_CREATE_TEMP_COMIS_BAJA_IT = "SQL CREATE TEMP COMIS BAJA IT";

  private final static String SQL_INSERT_TEMP_COMIS_BAJA_IT = "SQL INSERT TEMP COMIS BAJA IT";

  private final static String SQL_VALIDATE_TEMP_COMIS_BAJA_IT = "SQL VALDIATE TEMP COMIS BAJA IT";

  private final static String SQL_DELETE_TEMP_COMIS_BAJA_IT = "SQL DELETE TEMP COMIS BAJA IT";

  // carencia

  private final static String SQL_CREATE_TEMP_COMIS_CARENCIA = "SQL CREATE TEMP COMIS CARENCIA";

  private final static String SQL_INSERT_TEMP_COMIS_CARENCIA = "SQL INSERT TEMP COMIS CARENCIA";

  private final static String SQL_VALIDATE_TEMP_COMIS_CARENCIA = "SQL VALDIATE TEMP COMIS CARENCIA";

  private final static String SQL_DELETE_TEMP_COMIS_CARENCIA = "SQL DELETE TEMP COMIS CARENCIA";

  // desplazamientos

  private final static String SQL_CREATE_TEMP_COMIS_DESPLAZAMIENTOS = "SQL CREATE TEMP COMIS DESPLAZAMIENTOS";

  private final static String SQL_INSERT_TEMP_COMIS_DESPLAZAMIENTOS = "SQL INSERT TEMP COMIS DESPLAZAMIENTOS";

  private final static String SQL_VALIDATE_TEMP_COMIS_DESPLAZAMIENTOS = "SQL VALDIATE TEMP COMIS DESPLAZAMIENTOS";

  private final static String SQL_DELETE_TEMP_COMIS_DESPLAZAMIENTOS = "SQL DELETE TEMP COMIS DESPLAZAMIENTOS";

  private final static String SQL_DESACTIVA_TEMP_COMIS_DESPLAZAMIENTOS = "SQL DESACTIVA TEMP COMIS DESPLAZAMIENTOS";

  private final static String SQL_REACTIVA_TEMP_COMIS_DESPLAZAMIENTOS = "SQL REACTIVA TEMP COMIS DESPLAZAMIENTOS";

  // historico

  private final static String SQL_CREATE_TEMP_COMIS_HISTORICO = "SQL CREATE TEMP COMIS HISTORICO";

  private final static String SQL_INSERT_TEMP_COMIS_HISTORICO = "SQL INSERT TEMP COMIS HISTORICO";

  private final static String SQL_VALIDATE_TEMP_COMIS_HISTORICO = "SQL VALDIATE TEMP COMIS HISTORICO";

  private final static String SQL_DELETE_TEMP_COMIS_HISTORICO = "SQL DELETE TEMP COMIS HISTORICO";

  private final static String SQL_MERGE_RANGE_TEMP_COMIS_HITORICO = "SQL MERGE RANGE TEMP COMIS HITORICO";

  private final static String SQL_MERGE_DATE_RANGES_SECCION_NOT_EQUALS_TEMP_COMIS_HITORICO =
      "SQL MERGE DATE RANGES SECCION NOT EQUALS TEMP COMIS HITORICO";

  // resalta

  private final static String SQL_CREATE_TEMP_COMIS_RESALTA = "SQL CREATE TEMP COMIS RESALTA";

  private final static String SQL_INSERT_TEMP_COMIS_RESALTA = "SQL INSERT TEMP COMIS RESALTA";

  private final static String SQL_VALIDATE_TEMP_COMIS_RESALTA = "SQL VALDIATE TEMP COMIS RESALTA";

  private final static String SQL_DELETE_TEMP_COMIS_RESALTA = "SQL DELETE TEMP COMIS RESALTA";

  // primas

  private final static String SQL_CREATE_TEMP_COMIS_PRIMAS = "SQL CREATE TEMP COMIS PRIMAS";

  private final static String SQL_INSERT_TEMP_COMIS_PRIMAS = "SQL INSERT TEMP COMIS PRIMAS";

  private final static String SQL_VALIDATE_TEMP_COMIS_PRIMAS = "SQL VALDIATE TEMP COMIS PRIMAS";

  private final static String SQL_DELETE_TEMP_COMIS_PRIMAS = "SQL DELETE TEMP COMIS PRIMAS";

  private final static String SQL_MERGE_DATE_RANGES_SECCION_NOT_EQUALS_TEMP_COMIS_PRIMAS =
      "SQL MERGE DATE RANGES SECCION NOT EQUALS TEMP COMIS PRIMAS";

  private final static String SQL_MERGE_DATE_RANGES_TEMP_COMIS_PRIMAS = "SQL MERGE DATE RANGES TEMP COMIS PRIMAS";

  // totalizacion tarea calculo

  private final static String SQL_CREATE_TEMP_CALCULO_POR_COMISION = "SQL CREATE TEMP CALCULO POR COMISION";

  private final static String SQL_MERGE_CALCULO_TEMP_CALCULO_POR_COMISION = "SQL MERGE TEMP CALCULO POR COMISION";

  private final static String SQL_MERGE_CALCULO_TEMP_CALCULO_SIN_COMISION = "SQL MERGE TEMP CALCULO SIN COMISION";

  private final static String SQL_DELETE_TEMP_CALCULO_POR_COMISION = "SQL DELETE TEMP CALCULO POR COMISION";

  // totalizacion tarea calculo ajuste

  private final static String SQL_CREATE_TEMP_CALCULO_AJUSTE_TOTALIZADO = "SQL CREATE TEMP CALCULO AJUSTE TOTALIZADO";

  private final static String SQL_MERGE_CALCULO_TEMP_CALCULO_AJUSTE_TOTALIZADO = "SQL MERGE TEMP CALCULO AJUSTE TOTALIZADO";

  private final static String SQL_DELETE_TEMP_CALCULO_AJUSTE_TOTALIZADO = "SQL DELETE TEMP CALCULO AJUSTE TOTALIZADO";

  // mejor opcion

  private final static String SQL_CREATE_TEMP_MEJOR_OPCION = "SQL CREATE TEMP MEJOR OPCION";

  private final static String SQL_INSERT_TEMP_MEJOR_OPCION = "SQL MERGE TEMP MEJOR OPCION";

  private final static String SQL_INDEX_TEMP_MEJOR_OPCION = "SQL INDEX TEMP MEJOR OPCION";

  private final static String SQL_DELETE_TEMP_MEJOR_OPCION = "SQL DELETE TEMP MEJOR OPCION";

  // mejor opcion sin fechas

  private final static String SQL_CREATE_TEMP_MEJOR_OPCION_SIN_FECHAS = "SQL CREATE TEMP MEJOR OPCION SIN FECHAS";

  private final static String SQL_INSERT_TEMP_MEJOR_OPCION_SIN_FECHAS = "SQL MERGE TEMP MEJOR OPCION SIN FECHAS";

  private final static String SQL_INDEX_TEMP_MEJOR_OPCION_SIN_FECHAS = "SQL INDEX TEMP MEJOR OPCION SIN FECHAS";

  private final static String SQL_DELETE_TEMP_MEJOR_OPCION_SIN_FECHAS = "SQL DELETE TEMP MEJOR OPCION SIN FECHAS";

  // mejor opcion sin fechas todo periodo

  private final static String SQL_CREATE_TEMP_MEJOR_OPCION_SIN_FECHAS_TODO_PERIODO = "SQL CREATE TEMP MEJOR OPCION SIN FECHAS TODO PERIODO";

  private final static String SQL_INSERT_TEMP_MEJOR_OPCION_SIN_FECHAS_TODO_PERIODO = "SQL MERGE TEMP MEJOR OPCION SIN FECHAS TODO PERIODO";

  private final static String SQL_INDEX_TEMP_MEJOR_OPCION_SIN_FECHAS_TODO_PERIODO = "SQL INDEX TEMP MEJOR OPCION SIN FECHAS TODO PERIODO";

  private final static String SQL_DELETE_TEMP_MEJOR_OPCION_SIN_FECHAS_TODO_PERIODO = "SQL DELETE TEMP MEJOR OPCION SIN FECHAS TODO PERIODO";

  // estructuras base challenge

  private final static String SQL_CREATE_TEMP_ESTRUCTURAS_BASE_CHALLENGE = "SQL CREATE TEMP ESTRUCTURAS BASE CHALLENGE";

  private final static String SQL_INSERT_TEMP_ESTRUCTURAS_BASE_CHALLENGE = "SQL MERGE TEMP ESTRUCTURAS BASE CHALLENGE";

  private final static String SQL_INDEX_TEMP_ESTRUCTURAS_BASE_CHALLENGE = "SQL INDEX TEMP ESTRUCTURAS BASE CHALLENGE";

  private final static String SQL_DELETE_TEMP_ESTRUCTURAS_BASE_CHALLENGE = "SQL DELETE TEMP ESTRUCTURAS BASE CHALLENGE";

  // estructuras desplazamiento no challenge

  private final static String SQL_CREATE_TEMP_ESTRUCTURAS_DESPLAZAMIENTO_NOCHALLENGE =
      "SQL CREATE TEMP ESTRUCTURAS DESPLAZAMIENTO NO CHALLENGE";

  private final static String SQL_INSERT_TEMP_ESTRUCTURAS_DESPLAZAMIENTO_NOCHALLENGE =
      "SQL MERGE TEMP ESTRUCTURAS DESPLAZAMIENTO NO CHALLENGE";

  private final static String SQL_INDEX_TEMP_ESTRUCTURAS_DESPLAZAMIENTO_NOCHALLENGE =
      "SQL INDEX TEMP ESTRUCTURAS DESPLAZAMIENTO NO CHALLENGE";

  private final static String SQL_DELETE_TEMP_ESTRUCTURAS_DESPLAZAMIENTO_NOCHALLENGE =
      "SQL DELETE TEMP ESTRUCTURAS DESPLAZAMIENTO NO CHALLENGE";

  private final static String SQL_CREATE_TEMP_BANDAS_ORIGEN_SIN_BANDA_DESPLAZAMIENTO =
      "SQL CREATE TEMP BANDAS ORIGEN SIN BANDA DESPLAZAMIENTO";

  private final static String SQL_INSERT_TEMP_BANDAS_ORIGEN_SIN_BANDA_DESPLAZAMIENTO =
      "SQL INSERT TEMP BANDAS ORIGEN SIN BANDA DESPLAZAMIENTO";

  private final static String SQL_DELETE_TEMP_BANDAS_ORIGEN_SIN_BANDA_DESPLAZAMIENTO =
      "SQL DELETE TEMP BANDAS ORIGEN SIN BANDA DESPLAZAMIENTO";

  // comision manual
  private final static String SQL_CREATE_TEMP_COMIS_COMISION_MANUAL = "SQL CREATE TEMP COMIS COMISION MANUAL";

  private final static String SQL_INDEX_TEMP_COMIS_COMISION_MANUAL = "SQL INDEX TEMP COMIS COMISION MANUAL";

  private final static String SQL_INSERT_TEMP_COMIS_COMISION_MANUAL = "SQL INSERT TEMP COMIS COMISION MANUAL";

  private final static String SQL_DELETE_TEMP_COMIS_COMISION_MANUAL = "SQL DELETE TEMP COMIS COMISION MANUAL";

  private final static String SQL_VALIDATE_TEMP_COMIS_COMISION_MANUAL = "SQL VALIDATE TEMP COMIS COMISION MANUAL";

  // personas
  private final static String SQL_CREATE_TEMP_COMIS_PERSONAS_LOCALIZACIONES = "SQL CREATE TEMP COMIS PERSONAS";

  private final static String SQL_INDEX_TEMP_COMIS_PERSONAS_LOCALIZACIONES = "SQL INDEX TEMP COMIS PERSONAS";

  private final static String SQL_DELETE_TEMP_COMIS_PERSONAS_LOCALIZACIONES = "SQL DELETE TEMP COMIS PERSONAS";

  private final static String SQL_INSERT_TEMP_COMIS_PERSONAS_LOCALIZACIONES = "SQL INSERT TEMP COMIS PERSONAS";

  private final static String SQL_VALIDATE_TEMP_COMIS_PERSONAS = "SQL VALIDATE TEMP COMIS PERSONAS";

  // estructura presupuesto
  private final static String SQL_INSERT_TAREA_LOCALIZACION_PRESUPUESTO_TAREA_PERSONA_ESTRUCTURA =
      "SQL INSERT TAREA LOCALIZACION PRESUPUESTO TAREA PERSONA ESTRUCTURA";

  // challenge porcentaje
  private final static String SQL_VALIDATE_TEMP_COMIS_CHALLENGE_PORCENTAJE = "SQL VALDIATE TEMP COMIS CHALLENGE PORCENTAJE";

  private final static String SQL_VALIDATE_TEMP_COMIS_DESPLAZAMIENTO_CHALLENGE_PORCENTAJE =
      "SQL VALDIATE TEMP COMIS DESPLAZAMIENTO CHALLENGE PORCENTAJE";

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom, "batchSize", 3, true);

    // baja it
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlCreateTempComisBajaIt", SQL_CREATE_TEMP_COMIS_BAJA_IT, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlInsertTempComisBajaIt", SQL_INSERT_TEMP_COMIS_BAJA_IT, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlValidateTempComisBajaIt", SQL_VALIDATE_TEMP_COMIS_BAJA_IT, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlDeleteTempComisBajaIt", SQL_DELETE_TEMP_COMIS_BAJA_IT, true);

    // carencia
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlCreateTempComisCarencia", SQL_CREATE_TEMP_COMIS_CARENCIA, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlInsertTempComisCarencia", SQL_INSERT_TEMP_COMIS_CARENCIA, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlValidateTempComisCarencia", SQL_VALIDATE_TEMP_COMIS_CARENCIA, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlDeleteTempComisCarencia", SQL_DELETE_TEMP_COMIS_CARENCIA, true);

    // desplazamientos
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlCreateTempComisDesplazamiento", SQL_CREATE_TEMP_COMIS_DESPLAZAMIENTOS, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlInsertTempComisDesplazamiento", SQL_INSERT_TEMP_COMIS_DESPLAZAMIENTOS, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlValidateTempComisDesplazamiento", SQL_VALIDATE_TEMP_COMIS_DESPLAZAMIENTOS, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlDeleteTempComisDesplazamiento", SQL_DELETE_TEMP_COMIS_DESPLAZAMIENTOS, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlDesactivaFechasSolapadas", SQL_DESACTIVA_TEMP_COMIS_DESPLAZAMIENTOS, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlReactivaFechasSolapadas", SQL_REACTIVA_TEMP_COMIS_DESPLAZAMIENTOS, true);

    // historico
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlCreateTempComisHistorico", SQL_CREATE_TEMP_COMIS_HISTORICO, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlInsertTempComisHistorico", SQL_INSERT_TEMP_COMIS_HISTORICO, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlValidateTempComisHistorico", SQL_VALIDATE_TEMP_COMIS_HISTORICO, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlDeleteTempComisHistorico", SQL_DELETE_TEMP_COMIS_HISTORICO, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlMergeDateRangesTempComisHistorico", SQL_MERGE_RANGE_TEMP_COMIS_HITORICO, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlMergeDateRangesSeccionNotEqualsTempComisHistorico", SQL_MERGE_DATE_RANGES_SECCION_NOT_EQUALS_TEMP_COMIS_HITORICO, true);

    // resalta
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlCreateTempComisResalta", SQL_CREATE_TEMP_COMIS_RESALTA, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlInsertTempComisResalta", SQL_INSERT_TEMP_COMIS_RESALTA, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlValidateTempComisResalta", SQL_VALIDATE_TEMP_COMIS_RESALTA, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlDeleteTempComisResalta", SQL_DELETE_TEMP_COMIS_RESALTA, true);

    // primas
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlCreateTempComisPrimas", SQL_CREATE_TEMP_COMIS_PRIMAS, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlInsertTempComisPrimas", SQL_INSERT_TEMP_COMIS_PRIMAS, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlValidateTempComisPrimas", SQL_VALIDATE_TEMP_COMIS_PRIMAS, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlDeleteTempComisPrimas", SQL_DELETE_TEMP_COMIS_PRIMAS, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlMergeDateRangesTempComisPrimas", SQL_MERGE_DATE_RANGES_TEMP_COMIS_PRIMAS, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlMergeDateRangesSeccionNotEqualsTempComisPrimas",
        SQL_MERGE_DATE_RANGES_SECCION_NOT_EQUALS_TEMP_COMIS_PRIMAS, true);

    // totalizacion calculo por comision
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlCreateTempCalculoPorComision", SQL_CREATE_TEMP_CALCULO_POR_COMISION, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlMergeCalculoTempCalculoPorComision", SQL_MERGE_CALCULO_TEMP_CALCULO_POR_COMISION, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlMergeCalculoTempCalculoSinComision", SQL_MERGE_CALCULO_TEMP_CALCULO_SIN_COMISION, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlDeleteTempCalculoPorComision", SQL_DELETE_TEMP_CALCULO_POR_COMISION, true);

    // totalizacion calculo ajuste
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlCreateTempCalculoAjusteTotalizado", SQL_CREATE_TEMP_CALCULO_AJUSTE_TOTALIZADO, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlMergeCalculoAjusteTotalizado", SQL_MERGE_CALCULO_TEMP_CALCULO_AJUSTE_TOTALIZADO, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlDeleteTempCalculoAjusteTotalizado", SQL_DELETE_TEMP_CALCULO_AJUSTE_TOTALIZADO, true);

    // mejor opcion
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlCreateTempMejorOpcion", SQL_CREATE_TEMP_MEJOR_OPCION, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlIndexTempMejorOpcion", SQL_INDEX_TEMP_MEJOR_OPCION, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlInsertTempMejorOpcion", SQL_INSERT_TEMP_MEJOR_OPCION, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlDeleteTempMejorOpcion", SQL_DELETE_TEMP_MEJOR_OPCION, true);

    // mejor opcion fechas
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlCreateTempMejorOpcionSinFechas", SQL_CREATE_TEMP_MEJOR_OPCION_SIN_FECHAS, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlIndexTempMejorOpcionSinFechas", SQL_INDEX_TEMP_MEJOR_OPCION_SIN_FECHAS, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlInsertTempMejorOpcionSinFechas", SQL_INSERT_TEMP_MEJOR_OPCION_SIN_FECHAS, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlDeleteTempMejorOpcionSinFechas", SQL_DELETE_TEMP_MEJOR_OPCION_SIN_FECHAS, true);

    // mejor opcion fechas periodo
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlCreateTempMejorOpcionSinFechasTodoPeriodo", SQL_CREATE_TEMP_MEJOR_OPCION_SIN_FECHAS_TODO_PERIODO,
        true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlIndexTempMejorOpcionSinFechasTodoPeriodo", SQL_INDEX_TEMP_MEJOR_OPCION_SIN_FECHAS_TODO_PERIODO,
        true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlInsertTempMejorOpcionSinFechasTodoPeriodo", SQL_INSERT_TEMP_MEJOR_OPCION_SIN_FECHAS_TODO_PERIODO,
        true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlDeleteTempMejorOpcionSinFechasTodoPeriodo", SQL_DELETE_TEMP_MEJOR_OPCION_SIN_FECHAS_TODO_PERIODO,
        true);

    // estructuras base challenge
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlCreateTempEstructurasBaseChallenge", SQL_CREATE_TEMP_ESTRUCTURAS_BASE_CHALLENGE,
        true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlIndexTempEstructurasBaseChallenge", SQL_INDEX_TEMP_ESTRUCTURAS_BASE_CHALLENGE,
        true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlInsertTempEstructurasBaseChallenge", SQL_INSERT_TEMP_ESTRUCTURAS_BASE_CHALLENGE,
        true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlDeleteTempEstructurasBaseChallenge", SQL_DELETE_TEMP_ESTRUCTURAS_BASE_CHALLENGE,
        true);

    // estructuras desplazamiento no challenge
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlCreateTempEstructurasDesplazamientoNoChallenge", SQL_CREATE_TEMP_ESTRUCTURAS_DESPLAZAMIENTO_NOCHALLENGE,
        true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlIndexTempEstructurasDesplazamientoNoChallenge", SQL_INDEX_TEMP_ESTRUCTURAS_DESPLAZAMIENTO_NOCHALLENGE,
        true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlInsertTempEstructurasDesplazamientoNoChallenge", SQL_INSERT_TEMP_ESTRUCTURAS_DESPLAZAMIENTO_NOCHALLENGE,
        true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlDeleteTempEstructurasDesplazamientoNoChallenge", SQL_DELETE_TEMP_ESTRUCTURAS_DESPLAZAMIENTO_NOCHALLENGE,
        true);

    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlCreateTempBandasOrigenSinBandaDesplazamiento", SQL_CREATE_TEMP_BANDAS_ORIGEN_SIN_BANDA_DESPLAZAMIENTO,
        true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlInsertBandasOrigenSinBandaDesplazamiento", SQL_INSERT_TEMP_BANDAS_ORIGEN_SIN_BANDA_DESPLAZAMIENTO,
        true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlDeleteTempBandasOrigenSinBandaDesplazamiento", SQL_DELETE_TEMP_BANDAS_ORIGEN_SIN_BANDA_DESPLAZAMIENTO,
        true);

    // comision manual
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlCreateTempComisComisionManual", SQL_CREATE_TEMP_COMIS_COMISION_MANUAL,
        true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlIndexTempComisComisionManual", SQL_INDEX_TEMP_COMIS_COMISION_MANUAL,
        true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlInsertTempComisComisionManual", SQL_INSERT_TEMP_COMIS_COMISION_MANUAL,
        true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlDeleteTempComisComisionManual", SQL_DELETE_TEMP_COMIS_COMISION_MANUAL,
        true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlValidateTempComisComisionManual", SQL_VALIDATE_TEMP_COMIS_COMISION_MANUAL,
        true);

    // Personas
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlCreateTempComisPersonasLocalizaciones", SQL_CREATE_TEMP_COMIS_PERSONAS_LOCALIZACIONES,
        true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlIndexTempComisPersonasLocalizaciones", SQL_INDEX_TEMP_COMIS_PERSONAS_LOCALIZACIONES,
        true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlDeleteTempComisPersonasLocalizaciones", SQL_DELETE_TEMP_COMIS_PERSONAS_LOCALIZACIONES,
        true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlInsertTempComisPersonasLocalizaciones", SQL_INSERT_TEMP_COMIS_PERSONAS_LOCALIZACIONES,
        true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlValidateTempComisPersonas", SQL_VALIDATE_TEMP_COMIS_PERSONAS,
        true);

    // relacion estructura presupuesto
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlInsertTareaLocalizacionPresupuestoTareaPersonaEstructura", SQL_INSERT_TAREA_LOCALIZACION_PRESUPUESTO_TAREA_PERSONA_ESTRUCTURA,
        true);

    // challenge porcentaje
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlValidateTempComisChallengePorcentaje", SQL_VALIDATE_TEMP_COMIS_CHALLENGE_PORCENTAJE,
        true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlValidateTempComisDesplazamientoChallengePorcentaje", SQL_VALIDATE_TEMP_COMIS_DESPLAZAMIENTO_CHALLENGE_PORCENTAJE,
        true);

  }

  // Inicio tests baja it

  @Test
  void createTempComisBajaItTest() {
    this.primaryTemporaryTableRepositoryCustom.createTempComisBajaIt();
    verify(this.jdbcTemplate).update(SQL_CREATE_TEMP_COMIS_BAJA_IT);
  }

  @Test
  void insertTempComisBajaItTest() {

    final List<IdPersonaLocalCondicionesDto> condiciones = new ArrayList<>();
    final IdPersonaLocalCondicionesDto persona = mock(IdPersonaLocalCondicionesDto.class);
    condiciones.add(persona);

    this.primaryTemporaryTableRepositoryCustom.insertTempComisBajaIt(condiciones);
    verify(this.jdbcTemplate).batchUpdate(eq(SQL_INSERT_TEMP_COMIS_BAJA_IT),
        any(BatchPreparedStatementSetter.class));

  }

  @Test
  void validateTempComisBajaItTest() {

    final TareaDto tarea = mock(TareaDto.class);
    final long idTarea = 1234L;
    when(tarea.getId()).thenReturn(idTarea);

    this.primaryTemporaryTableRepositoryCustom.validateTempComisBajaIt(tarea);
    verify(this.namedParameterJdbcTemplate).query(eq(SQL_VALIDATE_TEMP_COMIS_BAJA_IT), this.paramsCaptor.capture(),
        any(RowMapper.class));

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(1, params.getValues().size());
    assertTrue(params.hasValue(ID_TAREA_PARAM));
    assertEquals(idTarea, params.getValue(ID_TAREA_PARAM));

  }

  @Test
  void deleteTempComisBajaItTest() {
    this.primaryTemporaryTableRepositoryCustom.deleteTempComisBajaIt();
    verify(this.jdbcTemplate).update(SQL_DELETE_TEMP_COMIS_BAJA_IT);
  }

  // Fin tests baja it

  // Inicio tests carencias

  @Test
  void createTempComisCarenciaTest() {
    this.primaryTemporaryTableRepositoryCustom.createTempComisCarencia();
    verify(this.jdbcTemplate).update(SQL_CREATE_TEMP_COMIS_CARENCIA);
  }

  @Test
  void insertTempComisCarenciaTest() {

    final List<IdPersonaLocalCarenciaDto> condiciones = new ArrayList<>();
    final IdPersonaLocalCarenciaDto persona = mock(IdPersonaLocalCarenciaDto.class);
    condiciones.add(persona);

    this.primaryTemporaryTableRepositoryCustom.insertTempComisCarencia(condiciones);
    verify(this.jdbcTemplate).batchUpdate(eq(SQL_INSERT_TEMP_COMIS_CARENCIA),
        any(BatchPreparedStatementSetter.class));

  }

  @Test
  void validateTempComisCarenciaTest() {

    final TareaDto tarea = mock(TareaDto.class);
    final long idTarea = 1234L;
    when(tarea.getId()).thenReturn(idTarea);

    this.primaryTemporaryTableRepositoryCustom.validateTempComisCarencia(tarea);
    verify(this.namedParameterJdbcTemplate).query(eq(SQL_VALIDATE_TEMP_COMIS_CARENCIA), this.paramsCaptor.capture(),
        any(RowMapper.class));

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(1, params.getValues().size());
    assertTrue(params.hasValue(ID_TAREA_PARAM));
    assertEquals(idTarea, params.getValue(ID_TAREA_PARAM));

  }

  @Test
  void deleteTempComisCarenciaTest() {
    this.primaryTemporaryTableRepositoryCustom.deleteTempComisCarencia();
    verify(this.jdbcTemplate).update(SQL_DELETE_TEMP_COMIS_CARENCIA);
  }

  // Fin tests carencias

  // Inicio tests desplazamientos

  @Test
  void createTempComisDesplazamientoTest() {
    this.primaryTemporaryTableRepositoryCustom.createTempComisDesplazamiento();
    verify(this.jdbcTemplate).update(SQL_CREATE_TEMP_COMIS_DESPLAZAMIENTOS);
  }

  @Test
  void insertTempComisDesplazamientoTest() {

    final List<IdPersonaLocalCondicionesDto> condiciones = new ArrayList<>();
    final IdPersonaLocalCondicionesDto persona = mock(IdPersonaLocalCondicionesDto.class);
    condiciones.add(persona);

    this.primaryTemporaryTableRepositoryCustom.insertTempComisDesplazamiento(condiciones);
    verify(this.jdbcTemplate).batchUpdate(eq(SQL_INSERT_TEMP_COMIS_DESPLAZAMIENTOS),
        any(BatchPreparedStatementSetter.class));

  }

  @Test
  void validateTempComisDesplazamientoTest() {

    final TareaDto tarea = mock(TareaDto.class);
    final LocalDate fechaInicio = LocalDate.of(2020, 01, 01);
    final long idTarea = 1234L;
    when(tarea.getId()).thenReturn(idTarea);

    this.primaryTemporaryTableRepositoryCustom.validateTempComisDesplazamiento(tarea);
    verify(this.namedParameterJdbcTemplate).query(eq(SQL_VALIDATE_TEMP_COMIS_DESPLAZAMIENTOS),
        this.paramsCaptor.capture(),
        any(RowMapper.class));

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(1, params.getValues().size());
    assertTrue(params.hasValue(ID_TAREA_PARAM));
    assertEquals(idTarea, params.getValue(ID_TAREA_PARAM));

  }

  @Test
  void deleteTempComisDesplazamientoTest() {
    this.primaryTemporaryTableRepositoryCustom.deleteTempComisDesplazamiento();
    verify(this.jdbcTemplate).update(SQL_DELETE_TEMP_COMIS_DESPLAZAMIENTOS);
  }

  @Test
  void desactivaFechasSolapadasTest() {
    this.primaryTemporaryTableRepositoryCustom.desactivaFechasSolapadas();
    verify(this.jdbcTemplate).update(SQL_DESACTIVA_TEMP_COMIS_DESPLAZAMIENTOS);
  }

  @Test
  void reactivaFechasSolapadasTest() {
    final TareaDto tarea = new TareaDto();
    tarea.setFechaInicioPeriodo(LocalDate.of(2020, 1, 1));
    tarea.setFechaFinPeriodo(LocalDate.of(2020, 1, 1));
    this.primaryTemporaryTableRepositoryCustom.reactivaFechasSolapadas(tarea);
    verify(this.namedParameterJdbcTemplate).update(any(String.class),
        any(MapSqlParameterSource.class));
  }

  // Fin tests desplazamientos

  // Inicio tests historico

  @Test
  void createTempComisHistoricoTest() {
    this.primaryTemporaryTableRepositoryCustom.createTempComisHistorico();
    verify(this.jdbcTemplate).update(SQL_CREATE_TEMP_COMIS_HISTORICO);
  }

  @Test
  void insertTempComisHistoricoTest() {

    final List<IdPersonaLocalCondicionesDto> condiciones = new ArrayList<>();
    final IdPersonaLocalCondicionesDto persona = mock(IdPersonaLocalCondicionesDto.class);
    condiciones.add(persona);

    this.primaryTemporaryTableRepositoryCustom.insertTempComisHistorico(condiciones);
    verify(this.jdbcTemplate).batchUpdate(eq(SQL_INSERT_TEMP_COMIS_HISTORICO),
        any(BatchPreparedStatementSetter.class));

  }

  @Test
  void validateTempComisHistoricoTest() {

    final TareaDto tarea = mock(TareaDto.class);
    final long idTarea = 1234L;
    when(tarea.getId()).thenReturn(idTarea);

    this.primaryTemporaryTableRepositoryCustom.validateTempComisHistorico(tarea);
    verify(this.namedParameterJdbcTemplate).query(eq(SQL_VALIDATE_TEMP_COMIS_HISTORICO),
        this.paramsCaptor.capture(),
        any(RowMapper.class));

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(1, params.getValues().size());
    assertTrue(params.hasValue(ID_TAREA_PARAM));
    assertEquals(idTarea, params.getValue(ID_TAREA_PARAM));

  }

  @Test
  void deleteTempComisHistoricoTest() {
    this.primaryTemporaryTableRepositoryCustom.deleteTempComisHistorico();
    verify(this.jdbcTemplate).update(SQL_DELETE_TEMP_COMIS_HISTORICO);
  }

  @Test
  void mergeDateRangesTempComisHistoricoTest(@Random final TareaDto tarea) {
    this.primaryTemporaryTableRepositoryCustom.mergeDateRangesTempComisHistorico(tarea);
    final Map<String, Object> params = new HashMap<>();
    params.put(ID_TAREA_PARAM, tarea.getId());
    params.put(FECHA_HASTA_PARAM, TimeUtils.toDate(RunUtils.addDays(tarea.getFechaFinPeriodo(), 2)));
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_MERGE_RANGE_TEMP_COMIS_HITORICO), this.paramsCaptor.capture());
    assertEquals(params, this.paramsCaptor.getValue().getValues());
  }

  @Test
  void mergeDateRangesSeccionNotEqualsTempComisHistoricoTest(@Random final TareaDto tarea) {
    this.primaryTemporaryTableRepositoryCustom.mergeDateRangesSeccionNotEqualsTempComisHistorico(tarea);
    final Map<String, Object> params = new HashMap<>();
    params.put(ID_TAREA_PARAM, tarea.getId());
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_MERGE_DATE_RANGES_SECCION_NOT_EQUALS_TEMP_COMIS_HITORICO),
        this.paramsCaptor.capture());
    assertEquals(params, this.paramsCaptor.getValue().getValues());
  }

  // Fin tests historico

  // Inicio tests resalta

  @Test
  void createTempComisResaltaTest() {
    this.primaryTemporaryTableRepositoryCustom.createTempComisResalta();
    verify(this.jdbcTemplate).update(SQL_CREATE_TEMP_COMIS_RESALTA);
  }

  @Test
  void insertTempComisResaltaTest() {

    final List<IdPersonaLocalCondicionesDto> condiciones = new ArrayList<>();
    final IdPersonaLocalCondicionesDto persona = mock(IdPersonaLocalCondicionesDto.class);
    condiciones.add(persona);

    this.primaryTemporaryTableRepositoryCustom.insertTempComisResalta(condiciones);
    verify(this.jdbcTemplate).batchUpdate(eq(SQL_INSERT_TEMP_COMIS_RESALTA),
        any(BatchPreparedStatementSetter.class));

  }

  @Test
  void validateTempComisResaltaTest() {

    final TareaDto tarea = mock(TareaDto.class);
    final long idTarea = 1234L;
    when(tarea.getId()).thenReturn(idTarea);

    this.primaryTemporaryTableRepositoryCustom.validateTempComisResalta(tarea);
    verify(this.namedParameterJdbcTemplate).query(eq(SQL_VALIDATE_TEMP_COMIS_RESALTA),
        this.paramsCaptor.capture(),
        any(RowMapper.class));

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(1, params.getValues().size());
    assertTrue(params.hasValue(ID_TAREA_PARAM));
    assertEquals(idTarea, params.getValue(ID_TAREA_PARAM));

  }

  @Test
  void deleteTempComisResaltaTest() {
    this.primaryTemporaryTableRepositoryCustom.deleteTempComisResalta();
    verify(this.jdbcTemplate).update(SQL_DELETE_TEMP_COMIS_RESALTA);
  }

  // Fin tests resalta

  // Inicio tests prima

  @Test
  void createTempComisPrimasTest() {
    this.primaryTemporaryTableRepositoryCustom.createTempComisPrimas();
    verify(this.jdbcTemplate).update(SQL_CREATE_TEMP_COMIS_PRIMAS);
  }

  @Test
  void insertTempComisPrimasTest() {

    final List<IdPersonaLocalCondicionesDto> condiciones = new ArrayList<>();
    final IdPersonaLocalCondicionesDto persona = mock(IdPersonaLocalCondicionesDto.class);
    condiciones.add(persona);

    this.primaryTemporaryTableRepositoryCustom.insertTempComisPrimas(condiciones);
    verify(this.jdbcTemplate).batchUpdate(eq(SQL_INSERT_TEMP_COMIS_PRIMAS),
        any(BatchPreparedStatementSetter.class));

  }

  @Test
  void deleteTempComisPrimasTest() {
    this.primaryTemporaryTableRepositoryCustom.deleteTempComisPrimas();
    verify(this.jdbcTemplate).update(SQL_DELETE_TEMP_COMIS_PRIMAS);
  }

  @Test
  void mergeDateRangesSeccionNotEqualsTempComisPrimasTest() {
    final TareaDto tarea = new TareaDto();
    final long idTarea = 1919L;
    tarea.setId(idTarea);
    final LocalDate fechaFinPeriodo = LocalDate.of(2020, 8, 31);
    tarea.setFechaFinPeriodo(fechaFinPeriodo);
    this.primaryTemporaryTableRepositoryCustom.mergeDateRangesSeccionNotEqualsTempComisPrimas(tarea);
    verify(this.namedParameterJdbcTemplate).update(eq(SQL_MERGE_DATE_RANGES_SECCION_NOT_EQUALS_TEMP_COMIS_PRIMAS),
        this.paramsCaptor.capture());
    // parametros: id tarea, fechaHasta
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(2, params.getValues().size());
    // id tarea
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, params.getValue(SqlComisConstants.SQL_PARAM_ID_TAREA));
    // fecha hasta
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
    assertEquals(TimeUtils.toDate(fechaFinPeriodo), params.getValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
  }

  @Test
  void mergeDateRangesTempComisPrimasTest() {
    final TareaDto tarea = new TareaDto();
    final long idTarea = 1919L;
    tarea.setId(idTarea);
    final LocalDate fechaFinPeriodo = LocalDate.of(2020, 8, 31);
    tarea.setFechaFinPeriodo(fechaFinPeriodo);
    this.primaryTemporaryTableRepositoryCustom.mergeDateRangesTempComisPrimas(tarea);
    verify(this.namedParameterJdbcTemplate).update(eq(SQL_MERGE_DATE_RANGES_TEMP_COMIS_PRIMAS),
        this.paramsCaptor.capture());
    // parametros: id tarea, fechaHasta
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(2, params.getValues().size());
    // id tarea
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, params.getValue(SqlComisConstants.SQL_PARAM_ID_TAREA));
    // fecha hasta
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
    assertEquals(TimeUtils.toDate(fechaFinPeriodo), params.getValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
  }

  @Test
  void validateTempComisPrimasTest() {

    final TareaDto tarea = mock(TareaDto.class);
    final long idTarea = 1234L;
    when(tarea.getId()).thenReturn(idTarea);

    this.primaryTemporaryTableRepositoryCustom.validateTempComisPrimas(tarea);
    verify(this.namedParameterJdbcTemplate).query(eq(SQL_VALIDATE_TEMP_COMIS_PRIMAS),
        this.paramsCaptor.capture(),
        any(RowMapper.class));

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(1, params.getValues().size());
    assertTrue(params.hasValue(ID_TAREA_PARAM));
    assertEquals(idTarea, params.getValue(ID_TAREA_PARAM));

  }

  // Fin tests prima

  // Tests totalizacion tarea calculo

  @Test
  void createTempCalculoPorComisionTest() {
    final int result = 10;
    when(this.jdbcTemplate.update(any(String.class))).thenReturn(result);
    assertEquals(result, this.primaryTemporaryTableRepositoryCustom.createTempCalculoPorComision());
    verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_CALCULO_POR_COMISION);
  }

  @Test
  void mergeCalculoTempCalculoPorComisionNumParamsTest() {
    final long idTarea = 12L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);

    this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoPorComision(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_MERGE_CALCULO_TEMP_CALCULO_POR_COMISION),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(3, params.getValues().size());

  }

  @Test
  void mergeCalculoTempCalculoPorComisionIdTareaParamTest() {
    final long idTarea = 12L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);

    this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoPorComision(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_MERGE_CALCULO_TEMP_CALCULO_POR_COMISION),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(ID_TAREA_PARAM));
    assertEquals(idTarea, params.getValue(ID_TAREA_PARAM));

  }

  @Test
  void mergeCalculoTempCalculoPorComisionInactivoParamTest() {
    final long idTarea = 12L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);

    this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoPorComision(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_MERGE_CALCULO_TEMP_CALCULO_POR_COMISION),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(INACTIVO_PARAM));
    assertEquals(SQL_ZERO_VALUE, params.getValue(INACTIVO_PARAM));

  }

  @Test
  void mergeCalculoTempCalculoPorComisionImporteParamTest() {
    final long idTarea = 12L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);

    this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoPorComision(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_MERGE_CALCULO_TEMP_CALCULO_POR_COMISION),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(IMPORTE_PARAM));
    assertEquals(SQL_ZERO_VALUE, params.getValue(IMPORTE_PARAM));

  }

  @Test
  void mergeCalculoTempCalculoSinComisionNumParamsTest() {
    final long idTarea = 12L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);

    this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoSinComision(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_MERGE_CALCULO_TEMP_CALCULO_SIN_COMISION),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(3, params.getValues().size());
  }

  @Test
  void mergeCalculoTempCalculoSinComisionIdTareaParamTest() {
    final long idTarea = 12L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);

    this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoSinComision(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_MERGE_CALCULO_TEMP_CALCULO_SIN_COMISION),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(ID_TAREA_PARAM));
    assertEquals(idTarea, params.getValue(ID_TAREA_PARAM));

  }

  @Test
  void mergeCalculoTempCalculoSinComisionInactivoParamTest() {
    final long idTarea = 12L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);

    this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoSinComision(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_MERGE_CALCULO_TEMP_CALCULO_SIN_COMISION),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(INACTIVO_PARAM));
    assertEquals(SQL_ZERO_VALUE, params.getValue(INACTIVO_PARAM));

  }

  @Test
  void mergeCalculoTempCalculoSinComisionImporteParamTest() {
    final long idTarea = 12L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);

    this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoSinComision(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_MERGE_CALCULO_TEMP_CALCULO_SIN_COMISION),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(IMPORTE_PARAM));
    assertEquals(SQL_ZERO_VALUE, params.getValue(IMPORTE_PARAM));

  }

  @Test
  void deleteTempCalculoPorComisionTest() {
    final int result = 90;
    when(this.jdbcTemplate.update(any(String.class))).thenReturn(result);
    assertEquals(result, this.primaryTemporaryTableRepositoryCustom.deleteTempCalculoPorComision());
    verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_CALCULO_POR_COMISION);
  }

  // Fin tests totalizacion tarea calculo

  // Tests totalizacion tarea calculo ajuste

  @Test
  void createTempCalculoAjusteTotalizadoTest() {
    final int result = 10;
    when(this.jdbcTemplate.update(any(String.class))).thenReturn(result);
    assertEquals(result, this.primaryTemporaryTableRepositoryCustom.createTempCalculoAjusteTotalizado());
    verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_CALCULO_AJUSTE_TOTALIZADO);
  }

  @Test
  void deleteTempCalculoAjusteTotalizadoTest() {
    final int result = 90;
    when(this.jdbcTemplate.update(any(String.class))).thenReturn(result);
    assertEquals(result, this.primaryTemporaryTableRepositoryCustom.deleteTempCalculoAjusteTotalizado());
    verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_CALCULO_AJUSTE_TOTALIZADO);
  }

  @Test
  void mergeCalculoTempCalculoAjusteTotalizadoNumParamsTest() {
    final long idTarea = 12L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);

    this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoAjusteTotalizado(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_MERGE_CALCULO_TEMP_CALCULO_AJUSTE_TOTALIZADO),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(2, params.getValues().size());

  }

  @Test
  void mergeCalculoTempCalculoAjusteTotalizadoIdTareaParamTest() {
    final long idTarea = 12L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);

    this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoAjusteTotalizado(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_MERGE_CALCULO_TEMP_CALCULO_AJUSTE_TOTALIZADO),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(ID_TAREA_PARAM));
    assertEquals(idTarea, params.getValue(ID_TAREA_PARAM));

  }

  @Test
  void mergeCalculoTempCalculoAjusteTotalizadoImporteParamTest() {
    final TareaDto tarea = new TareaDto();
    tarea.setId(8989L);

    this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoAjusteTotalizado(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_MERGE_CALCULO_TEMP_CALCULO_AJUSTE_TOTALIZADO),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(IMPORTE_PARAM));
    assertEquals(SQL_ZERO_VALUE, params.getValue(IMPORTE_PARAM));

  }

  // Fin tests totalizacion tarea calculo ajuste

  // Inicio tests mejor opcion

  @Test
  void createTempMejorOpcionTest() {
    this.primaryTemporaryTableRepositoryCustom.createTempMejorOpcion();
    verify(this.jdbcTemplate).update(SQL_CREATE_TEMP_MEJOR_OPCION);
  }

  @Test
  void insertTempMejorOpcionTest() {

    final TareaDto tarea = new TareaDto();
    this.primaryTemporaryTableRepositoryCustom.insertTempMejorOpcion(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(
        eq(SQL_INSERT_TEMP_MEJOR_OPCION),
        this.paramsCaptor.capture());
  }

  @Test
  void deleteTempMejorOpcionTest() {

    this.primaryTemporaryTableRepositoryCustom.deleteTempMejorOpcion();
    verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_MEJOR_OPCION);
  }

  @Test
  void indexTempMejorOpcionTest() {
    this.primaryTemporaryTableRepositoryCustom.indexTempMejorOpcion();
    verify(this.jdbcTemplate).update(SQL_INDEX_TEMP_MEJOR_OPCION);
  }

  // Fin tests mejoropcion

  // Inicio tests mejor opcion sin fechas

  @Test
  void createTempMejorOpcionSinFechasTest() {
    this.primaryTemporaryTableRepositoryCustom.createTempMejorOpcionSinFechas();
    verify(this.jdbcTemplate).update(SQL_CREATE_TEMP_MEJOR_OPCION_SIN_FECHAS);
  }

  @Test
  void insertTempMejorOpcionSinFechasTest() {

    final TareaDto tarea = new TareaDto();
    this.primaryTemporaryTableRepositoryCustom.insertTempMejorOpcionSinFechas(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_MEJOR_OPCION_SIN_FECHAS),
        this.paramsCaptor.capture());
  }

  @Test
  void deleteTempMejorOpcionSinFechasTest() {

    this.primaryTemporaryTableRepositoryCustom.deleteTempMejorOpcionSinFechas();
    verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_MEJOR_OPCION_SIN_FECHAS);

  }

  @Test
  void indexTempMejorOpcionSinFechasTest() {
    this.primaryTemporaryTableRepositoryCustom.indexTempMejorOpcionSinFechas();
    verify(this.jdbcTemplate).update(SQL_INDEX_TEMP_MEJOR_OPCION_SIN_FECHAS);
  }

  // Fin tests mejoropcion

  // Inicio tests mejor opcion sin fechas

  @Test
  void createTempMejorOpcionSinFechasTodoPeriodoTest() {
    this.primaryTemporaryTableRepositoryCustom.createTempMejorOpcionSinFechasTodoPeriodo();
    verify(this.jdbcTemplate).update(SQL_CREATE_TEMP_MEJOR_OPCION_SIN_FECHAS_TODO_PERIODO);
  }

  @Test
  void insertTempMejorOpcionSinFechasTodoPeriodoTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setFechaInicioPeriodo(LocalDate.now());

    this.primaryTemporaryTableRepositoryCustom.insertTempMejorOpcionSinFechasTodoPeriodo(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(
        eq(SQL_INSERT_TEMP_MEJOR_OPCION_SIN_FECHAS_TODO_PERIODO),
        this.paramsCaptor.capture());
  }

  @Test
  void deleteTempMejorOpcionSinFechasTodoPeriodoTest() {

    this.primaryTemporaryTableRepositoryCustom.deleteTempMejorOpcionSinFechasTodoPeriodo();
    verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_MEJOR_OPCION_SIN_FECHAS_TODO_PERIODO);

    // verify(this.jdbcTemplate).update(eq(SQL_DELETE_TEMP_MEJOR_OPCION_SIN_FECHAS_TODO_PERIODO),
    // any(BatchPreparedStatementSetter.class));

  }

  @Test
  void indexTempMejorOpcionSinFechasTodoPeriodoTest() {
    this.primaryTemporaryTableRepositoryCustom.indexTempMejorOpcionSinFechasTodoPeriodo();
    verify(this.jdbcTemplate).update(SQL_INDEX_TEMP_MEJOR_OPCION_SIN_FECHAS_TODO_PERIODO);
  }

  // Fin tests mejoropcion

  // Tests compensación bandas origen que no hay en destino

  @Test
  void createTempBandasOrigenSinBandaDesplazamientoTest() {
    this.primaryTemporaryTableRepositoryCustom.createTempBandasOrigenSinBandaDesplazamiento();
    verify(this.jdbcTemplate).update(SQL_CREATE_TEMP_BANDAS_ORIGEN_SIN_BANDA_DESPLAZAMIENTO);
  }

  @Test
  void deleteTempBandasOrigenSinBandaDesplazamientoTest() {
    this.primaryTemporaryTableRepositoryCustom.deleteTempBandasOrigenSinBandaDesplazamiento();
    verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_BANDAS_ORIGEN_SIN_BANDA_DESPLAZAMIENTO);
  }

  @Test
  void insertBandasOrigenSinBandaDesplazamientoTest() {
    final TareaDto tarea = new TareaDto();
    final long idTarea = 8989L;
    tarea.setId(idTarea);
    this.primaryTemporaryTableRepositoryCustom.insertBandasOrigenSinBandaDesplazamiento(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_INSERT_TEMP_BANDAS_ORIGEN_SIN_BANDA_DESPLAZAMIENTO),
        this.paramsCaptor.capture());

    final Map<String, Object> expected = new HashMap<>() {
      private static final long serialVersionUID = 9034296128591281441L;

      {
        this.put(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        this.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        this.put(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        this.put(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION, AppConstants.getTIPOS_COMISION_CHALLENGE());
        this.put(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO, AppConstants.getTIPOS_CALCULO_CHALLENGE());
      }
    };

    assertEquals(expected, this.paramsCaptor.getValue().getValues());

  }

  // Fin test compesación bandas

  // Test estructuras base challenge

  @Test
  void createTempEstructurasBaseChallengeTest() {
    this.primaryTemporaryTableRepositoryCustom.createTempEstructurasBaseChallenge();
    verify(this.jdbcTemplate).update(SQL_CREATE_TEMP_ESTRUCTURAS_BASE_CHALLENGE);
  }

  @Test
  void insertTempEstructurasBaseChallengeTest(@Random final TareaDto tarea) {

    this.primaryTemporaryTableRepositoryCustom.insertTempEstructurasBaseChallenge(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(
        eq(SQL_INSERT_TEMP_ESTRUCTURAS_BASE_CHALLENGE),
        this.paramsCaptor.capture());

    final Map<String, Object> expected = new HashMap<>() {
      private static final long serialVersionUID = 267715629345937185L;

      {
        this.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        this.put(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        this.put(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION, AppConstants.getTIPOS_COMISION_CHALLENGE());
        this.put(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO, AppConstants.getTIPOS_CALCULO_CHALLENGE());
      }
    };

    assertEquals(expected, this.paramsCaptor.getValue().getValues());
  }

  @Test
  void deleteTempEstructurasBaseChallengeTest() {
    this.primaryTemporaryTableRepositoryCustom.deleteTempEstructurasBaseChallenge();
    verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_ESTRUCTURAS_BASE_CHALLENGE);
  }

  @Test
  void indexTempEstructurasBaseChallengeTest() {
    this.primaryTemporaryTableRepositoryCustom.indexTempEstructurasBaseChallenge();
    verify(this.jdbcTemplate).update(SQL_INDEX_TEMP_ESTRUCTURAS_BASE_CHALLENGE);
  }

  // Fin Test estructuras base challenge

  // Test estructuras base challenge

  @Test
  void createTempEstructurasDesplazamientoNoChallengeTest() {
    this.primaryTemporaryTableRepositoryCustom.createTempEstructurasDesplazamientoNoChallenge();
    verify(this.jdbcTemplate).update(SQL_CREATE_TEMP_ESTRUCTURAS_DESPLAZAMIENTO_NOCHALLENGE);
  }

  @Test
  void insertTempEstructurasDesplazamientoNoChallengeTest(@Random final TareaDto tarea) {

    this.primaryTemporaryTableRepositoryCustom.insertTempEstructurasDesplazamientoNoChallenge(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(
        eq(SQL_INSERT_TEMP_ESTRUCTURAS_DESPLAZAMIENTO_NOCHALLENGE),
        this.paramsCaptor.capture());

    final Map<String, Object> expected = new HashMap<>() {
      private static final long serialVersionUID = 2356126580568113922L;

      {
        this.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        this.put(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        this.put(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION, AppConstants.getTIPOS_COMISION_CHALLENGE());
        this.put(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO, AppConstants.getTIPOS_CALCULO_CHALLENGE());
        this.put(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
      }
    };

    assertEquals(expected, this.paramsCaptor.getValue().getValues());
  }

  @Test
  void deleteTempEstructurasDesplazamientoNoChallengeTest() {
    this.primaryTemporaryTableRepositoryCustom.deleteTempEstructurasDesplazamientoNoChallenge();
    verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_ESTRUCTURAS_DESPLAZAMIENTO_NOCHALLENGE);
  }

  @Test
  void indexTempEstructurasDesplazamientoNoChallengeTest() {
    this.primaryTemporaryTableRepositoryCustom.indexTempEstructurasDesplazamientoNoChallenge();
    verify(this.jdbcTemplate).update(SQL_INDEX_TEMP_ESTRUCTURAS_DESPLAZAMIENTO_NOCHALLENGE);
  }

  // Fin Test estructuras base challenge

  // Tests comision manual

  @Test
  void createTempComisComisionManualTest() {
    this.primaryTemporaryTableRepositoryCustom.createTempComisComisionManual();
    verify(this.jdbcTemplate).update(SQL_CREATE_TEMP_COMIS_COMISION_MANUAL);
  }

  @Test
  void insertTempComisComisionManualTest(@Random final IdPersonaLocalComisionManualDto comision1,
      @Random final IdPersonaLocalComisionManualDto comision2,
      @Random final IdPersonaLocalComisionManualDto comision3) {

    final List<IdPersonaLocalComisionManualDto> comisiones = Arrays.asList(comision1, comision2, comision3);
    this.primaryTemporaryTableRepositoryCustom.insertTempComisComisionManual(comisiones);
    verify(this.jdbcTemplate).batchUpdate(eq(SQL_INSERT_TEMP_COMIS_COMISION_MANUAL),
        any(BatchPreparedStatementSetter.class));
  }

  @Test
  void deleteTempComisComisionManualTest() {
    this.primaryTemporaryTableRepositoryCustom.deleteTempComisComisionManual();
    verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_COMIS_COMISION_MANUAL);
  }

  @Test
  void indexTempComisComisionManualTest() {
    this.primaryTemporaryTableRepositoryCustom.indexTempComisComisionManual();
    verify(this.jdbcTemplate).update(SQL_INDEX_TEMP_COMIS_COMISION_MANUAL);
  }

  @Test
  void validateTempComisComisionManualTest(@Random final TareaDto tarea, @Random final IdPersonaLocalDto persona1,
      @Random final IdPersonaLocalDto persona2) {

    persona1.setStdOrHrPeriod(null);
    persona2.setStdOrHrPeriod(null);
    when(this.namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
        ArgumentMatchers.<RowMapper<IdPersonaLocalDto>>any())).thenAnswer((invocation) -> {
          final RowMapper<IdPersonaLocalDto> rowMapper = invocation.getArgument(2);
          final ResultSet rs1 = mock(ResultSet.class);
          final ResultSet rs2 = mock(ResultSet.class);
          when(rs1.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON)).thenReturn(persona1.getIdPersonaLocal());
          when(rs2.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON)).thenReturn(persona2.getIdPersonaLocal());

          return Arrays.asList(rowMapper.mapRow(rs1, 0), rowMapper.mapRow(rs2, 1));
        });

    final List<IdPersonaLocalDto> result = this.primaryTemporaryTableRepositoryCustom.validateTempComisComisionManual(tarea);

    final Map<String, Object> expected = new HashMap<>();
    expected.put(SqlComisConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    verify(this.namedParameterJdbcTemplate, times(1)).query(eq(SQL_VALIDATE_TEMP_COMIS_COMISION_MANUAL), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalDto>>any());
    assertEquals(expected, this.paramsCaptor.getValue().getValues());

    assertEquals(Arrays.asList(persona1, persona2), result);
  }

  // Fin Tetss comision manual

  // Tests Personas

  @Test
  void createTempComisPersonasLocalizacionesTest() {
    this.primaryTemporaryTableRepositoryCustom.createTempComisPersonasLocalizaciones();
    verify(this.jdbcTemplate).update(SQL_CREATE_TEMP_COMIS_PERSONAS_LOCALIZACIONES);
  }

  @Test
  void indexTempComisPersonasLocalizacionesTest() {
    this.primaryTemporaryTableRepositoryCustom.indexTempComisPersonasLocalizaciones();
    verify(this.jdbcTemplate).update(SQL_INDEX_TEMP_COMIS_PERSONAS_LOCALIZACIONES);
  }

  @Test
  void deleteTempComisPersonasLocalizacionesTest() {
    this.primaryTemporaryTableRepositoryCustom.deleteTempComisPersonasLocalizaciones();
    verify(this.jdbcTemplate).update(SQL_DELETE_TEMP_COMIS_PERSONAS_LOCALIZACIONES);
  }

  @Test
  void insertTempComisPersonasLocalizacionesTest(@Random final IdPersonaLocalLocalizacionDto persona) {
    final List<IdPersonaLocalLocalizacionDto> personas = Collections.singletonList(persona);
    this.primaryTemporaryTableRepositoryCustom.insertTempComisPersonasLocalizaciones(personas);
    verify(this.jdbcTemplate).batchUpdate(eq(SQL_INSERT_TEMP_COMIS_PERSONAS_LOCALIZACIONES),
        any(BatchPreparedStatementSetter.class));
  }

  @Test
  void validateTempComisPersonas(@Random final TareaDto tarea, @Random final IdPersonaLocalDto persona1,
      @Random final IdPersonaLocalDto persona2) {

    persona1.setStdOrHrPeriod(null);
    persona2.setStdOrHrPeriod(null);
    when(this.namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
        ArgumentMatchers.<RowMapper<IdPersonaLocalDto>>any())).thenAnswer((invocation) -> {
          final RowMapper<IdPersonaLocalDto> rowMapper = invocation.getArgument(2);
          final ResultSet rs1 = mock(ResultSet.class);
          final ResultSet rs2 = mock(ResultSet.class);
          when(rs1.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON)).thenReturn(persona1.getIdPersonaLocal());
          when(rs2.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON)).thenReturn(persona2.getIdPersonaLocal());

          return Arrays.asList(rowMapper.mapRow(rs1, 0), rowMapper.mapRow(rs2, 1));
        });

    final List<IdPersonaLocalDto> result = this.primaryTemporaryTableRepositoryCustom.validateTempComisPersonas(tarea);

    final Map<String, Object> expected = new HashMap<>();
    expected.put(SqlComisConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    verify(this.namedParameterJdbcTemplate, times(1)).query(eq(SQL_VALIDATE_TEMP_COMIS_PERSONAS), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalDto>>any());
    assertEquals(expected, this.paramsCaptor.getValue().getValues());

    assertEquals(Arrays.asList(persona1, persona2), result);
  }

  // Fin tests personas

  @Test
  void insertTareaLocalizacionPresupuestoTareaPersonaEstructura(@Random final TareaDto tareaDto) {
    this.primaryTemporaryTableRepositoryCustom.insertTareaLocalizacionPresupuestoTareaPersonaEstructura(tareaDto);
    verify(this.namedParameterJdbcTemplate).update(eq(SQL_INSERT_TAREA_LOCALIZACION_PRESUPUESTO_TAREA_PERSONA_ESTRUCTURA),
        any(SqlParameterSource.class));
  }

  @Test
  void validateTempComisChallengePorcentajeTest() {

    final TareaDto tarea = mock(TareaDto.class);
    final long idTarea = 1234L;
    when(tarea.getId()).thenReturn(idTarea);

    this.primaryTemporaryTableRepositoryCustom.validateTempComisChallengePorcentaje(tarea);
    verify(this.namedParameterJdbcTemplate).query(eq(SQL_VALIDATE_TEMP_COMIS_CHALLENGE_PORCENTAJE),
        this.paramsCaptor.capture(),
        any(RowMapper.class));

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(1, params.getValues().size());
    assertTrue(params.hasValue(ID_TAREA_PARAM));
    assertEquals(idTarea, params.getValue(ID_TAREA_PARAM));

  }

  @Test
  void validateTempComisChallengeDesplazamientoPorcentajeTest() {

    final TareaDto tarea = mock(TareaDto.class);
    final long idTarea = 1234L;
    when(tarea.getId()).thenReturn(idTarea);

    this.primaryTemporaryTableRepositoryCustom.validateTempComisDesplazamientoChallengePorcentaje(tarea);
    verify(this.namedParameterJdbcTemplate).query(eq(SQL_VALIDATE_TEMP_COMIS_DESPLAZAMIENTO_CHALLENGE_PORCENTAJE),
        this.paramsCaptor.capture(),
        any(RowMapper.class));

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(1, params.getValues().size());
    assertTrue(params.hasValue(ID_TAREA_PARAM));
    assertEquals(idTarea, params.getValue(ID_TAREA_PARAM));

  }

}
