package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ACTIVO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_CONCEPTO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TAREA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_INCLUSION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_PORCENTAJE_CERO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoComisionEnum;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaHistorico;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaPersonaHistoricoRepositoryCustomImplTest {

  private final static String SQL_SAVE = "SQL SAVE";

  private final static String SQL_FIND_ID_PERSONA_HISTORICO_BY_ID_TAREA_AND_ID_ORIGEN_AND_TIPO_DATO_IN_AMBITO =
      "SQL FIND ID PERSONA HISTORICO BY ID TAREA AND ID ORIGEN AND TIPO DATO IN AMBITO";

  private final static String SQL_FIND_ID_PERSONA_HISTORICO_BY_ID_TAREA_AND_ID_ORIGEN =
      "SQL FIND ID PERSONA HISTORICO BY ID TAREA AND ID ORIGEN";

  private final static String SQL_FIND_ID_PERSONA_BY_ID_TAREA_AND_ID_ORIGEN_IN_PERIODO_CALCULO_PERSONA =
      "SQL FIND ID PERSONA BY ID TAREA AND ID ORIGEN IN PERIODO CALCULO PERSONA";

  private final static String SQL_FIND_ID_PERSONA_HISTORICO_GRUPO_FECHAS_BY_ID_TAREA =
      "SQL FIND ID PERSONA HISTORICO GRUPO FECHAS BY ID TAREA";

  private final static String SQL_FIND_ID_PERSONA_HISTORICO_COMPENSACION_CHALLENGE_BY_ID_TAREA =
      "SQL FIND ID PERSONA HISTORICO COMPENSACION CHALLENGE BY ID TAREA";

  private final static String SQL_FIND_ID_PERSONA_HISTORICO_AND_LOCALIZACION_BY_ID_TAREA_AND_ID_ORIGEN_AND_TIPO_DATO_IN_AMBITO =
      "SQL FIND ID PERSONA HISTORICO AND LOCALIZACION BY ID TAREA AND ID ORIGEN AND TIPO DATO IN AMBITO";

  @Mock
  private JdbcTemplate jdbcTemplate;

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private TareaPersonaHistoricoRepositoryCustomImpl tareaPersonaHistoricoRepositoryCustom;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaPersonaHistoricoRepositoryCustom,
        "sqlSave", SQL_SAVE, true);
    FieldUtils.writeField(this.tareaPersonaHistoricoRepositoryCustom,
        "sqlFindIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito",
        SQL_FIND_ID_PERSONA_HISTORICO_BY_ID_TAREA_AND_ID_ORIGEN_AND_TIPO_DATO_IN_AMBITO, true);
    FieldUtils.writeField(this.tareaPersonaHistoricoRepositoryCustom,
        "sqlFindIdPersonaHistoricoByIdTareaAndIdOrigen",
        SQL_FIND_ID_PERSONA_HISTORICO_BY_ID_TAREA_AND_ID_ORIGEN,
        true);
    FieldUtils.writeField(this.tareaPersonaHistoricoRepositoryCustom,
        "sqlFindIdPersonaLocalByIdTareaAndIdOrigenInPeriodoCalculoPersona",
        SQL_FIND_ID_PERSONA_BY_ID_TAREA_AND_ID_ORIGEN_IN_PERIODO_CALCULO_PERSONA,
        true);
    FieldUtils.writeField(this.tareaPersonaHistoricoRepositoryCustom,
        "sqlFindPeriodoDtoByIdTarea", SQL_FIND_ID_PERSONA_HISTORICO_BY_ID_TAREA_AND_ID_ORIGEN,
        true);
    FieldUtils.writeField(this.tareaPersonaHistoricoRepositoryCustom,
        "sqlFindIdPersonaHistoricoDtoGrupoFechasByIdTarea",
        SQL_FIND_ID_PERSONA_HISTORICO_GRUPO_FECHAS_BY_ID_TAREA,
        true);
    FieldUtils.writeField(this.tareaPersonaHistoricoRepositoryCustom,
        "sqlFindIdPersonaLocalCompensacionChallengeByIdTarea",
        SQL_FIND_ID_PERSONA_HISTORICO_COMPENSACION_CHALLENGE_BY_ID_TAREA,
        true);
    FieldUtils.writeField(this.tareaPersonaHistoricoRepositoryCustom,
        "sqlFindIdPersonaHistoricoLocalizacionByIdTareaAndIdOrigenInPeriodoCalculoPersona",
        SQL_FIND_ID_PERSONA_HISTORICO_AND_LOCALIZACION_BY_ID_TAREA_AND_ID_ORIGEN_AND_TIPO_DATO_IN_AMBITO,
        true);
    FieldUtils.writeField(this.tareaPersonaHistoricoRepositoryCustom,
        "batchSize", 100, true);
  }

  @Test
  public void saveTest() {
    final List<TareaPersonaHistorico> items = Collections.singletonList(mock(TareaPersonaHistorico.class));
    this.tareaPersonaHistoricoRepositoryCustom.save(items);
    verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(), any(SqlParameterSource[].class));
    assertEquals(SQL_SAVE, this.sqlCaptor.getValue());
  }

  @Test
  public void findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbitoTest() {
    final long idTarea = 900L;
    final String idOrigen = "CCL_ID_ORIGEN";
    final List<Integer> tiposDato = Arrays.asList(12, 39, 211);
    this.tareaPersonaHistoricoRepositoryCustom.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(
        idTarea,
        idOrigen, tiposDato);

    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<TareaPersonaHistorico>>any());
    assertEquals(SQL_FIND_ID_PERSONA_HISTORICO_BY_ID_TAREA_AND_ID_ORIGEN_AND_TIPO_DATO_IN_AMBITO,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, cclIdOrigen, tiposDato
    assertEquals(2, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, params.getValue(SQL_PARAM_ID_TAREA));
    // cclIdOrigen
    assertTrue(params.hasValue(SQL_PARAM_CCL_ID_ORIGEN));
    assertEquals(idOrigen, params.getValue(SQL_PARAM_CCL_ID_ORIGEN));
  }

  @Test
  public void findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbitoTest() {
    final String idOrigen = "CCL_ID_ORIGEN";
    final long idTarea = 10L;
    this.tareaPersonaHistoricoRepositoryCustom.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(idTarea,
        idOrigen);

    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<TareaPersonaHistorico>>any());
    assertEquals(SQL_FIND_ID_PERSONA_HISTORICO_BY_ID_TAREA_AND_ID_ORIGEN, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, cclIdOrigen
    assertEquals(2, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, params.getValue(SQL_PARAM_ID_TAREA));
    // cclIdOrigen
    assertTrue(params.hasValue(SQL_PARAM_CCL_ID_ORIGEN));
    assertEquals(idOrigen, params.getValue(SQL_PARAM_CCL_ID_ORIGEN));
  }

  @Test
  public void findPeriodoDtoByIdTareaTest() {
    final long idTarea = 10L;
    this.tareaPersonaHistoricoRepositoryCustom.findPeriodoDtoByIdTarea(idTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(this.sqlCaptor.capture(),
        this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<TareaPersonaHistorico>>any());
    assertEquals(SQL_FIND_ID_PERSONA_HISTORICO_BY_ID_TAREA_AND_ID_ORIGEN, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, cclIdOrigen
    assertEquals(1, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, params.getValue(SQL_PARAM_ID_TAREA));
  }

  @Test
  public void findIdPersonaHistoricoDtoGrupoFechasByIdTareaTest() {
    final long idTarea = 10L;
    final Integer activo = SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE;
    this.tareaPersonaHistoricoRepositoryCustom.findIdPersonaHistoricoDtoGrupoFechasByIdTarea(idTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<TareaPersonaHistorico>>any());
    assertEquals(SQL_FIND_ID_PERSONA_HISTORICO_GRUPO_FECHAS_BY_ID_TAREA, this.sqlCaptor.getValue());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, cclIdOrigen
    assertEquals(2, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, params.getValue(SQL_PARAM_ID_TAREA));
    // activo
    assertTrue(params.hasValue(SQL_PARAM_ACTIVO));
    assertEquals(activo, params.getValue(SQL_PARAM_ACTIVO));
  }

  @Test
  public void findIdPersonaLocalCompensacionChallengeByIdTareaTest() {
    final long idTarea = 10L;
    final List<String> tiposCalculo = Arrays.asList(TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId(),
        TipoCalculoEnum.CHALLENGE_IMPORTE_SECCION.getId());
    final List<String> tiposComision = Arrays.asList(TipoComisionEnum.CHALLENGE_PRINCIPAL.getId(),
        TipoComisionEnum.CHALLENGE_SECUNDARIO.getId());

    this.tareaPersonaHistoricoRepositoryCustom.findIdPersonaLocalCompensacionChallengeByIdTarea(idTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<TareaPersonaHistorico>>any());
    assertEquals(SQL_FIND_ID_PERSONA_HISTORICO_COMPENSACION_CHALLENGE_BY_ID_TAREA, this.sqlCaptor.getValue());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, tiposCalculo, tiposComision
    assertEquals(3, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, params.getValue(SQL_PARAM_ID_TAREA));
    // tiposCalculo
    assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_CALCULO));
    assertEquals(tiposCalculo, params.getValue(SQL_PARAM_IDS_TIPOS_CALCULO));
    // tiposComision
    assertTrue(params.hasValue(SQL_PARAM_IDS_TIPOS_COMISION));
    assertEquals(tiposComision, params.getValue(SQL_PARAM_IDS_TIPOS_COMISION));
  }

  @Test
  public void findIdPersonaHistoricoDtoByIdTareaAndConfiguracionVentaOnlineEntregaDomicilioTest() {

    final Long idTarea = 1L;
    final String cclIdOrigen = "11";
    final TipoVentaConceptoEnum tipoVentaConcepto = TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_VENTA;

    this.tareaPersonaHistoricoRepositoryCustom
        .findIdPersonaHistoricoDtoByIdTareaAndConfiguracionVentaOnlineEntregaDomicilio(idTarea, cclIdOrigen,
            tipoVentaConcepto);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<TareaPersonaHistorico>>any());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, cclIdOrigen, porcentajeInclusion, idConcepto
    assertEquals(4, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, params.getValue(SQL_PARAM_ID_TAREA));
    // cclIdOrigen
    assertTrue(params.hasValue(SQL_PARAM_CCL_ID_ORIGEN));
    assertEquals(cclIdOrigen, params.getValue(SQL_PARAM_CCL_ID_ORIGEN));
    // porcentajeInclusion
    assertTrue(params.hasValue(SQL_PARAM_PORCENTAJE_INCLUSION));
    assertEquals(SQL_VALUE_PORCENTAJE_CERO, params.getValue(SQL_PARAM_PORCENTAJE_INCLUSION));
    // idConcepto
    assertTrue(params.hasValue(SQL_PARAM_ID_CONCEPTO));
    assertEquals(TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_VENTA.getId(), params.getValue(SQL_PARAM_ID_CONCEPTO));
  }

  @Test
  public void findIdPersonaHistoricoLocalizacionDtoByIdTareaAndIdOrigenInAmbito() {
    final long idTarea = 900L;
    final String idOrigen = "CCL_ID_ORIGEN";
    this.tareaPersonaHistoricoRepositoryCustom.findIdPersonaHistoricoLocalizacionDtoByIdTareaAndIdOrigenInAmbito(
        idTarea,
        idOrigen);

    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<TareaPersonaHistorico>>any());
    assertEquals(SQL_FIND_ID_PERSONA_HISTORICO_AND_LOCALIZACION_BY_ID_TAREA_AND_ID_ORIGEN_AND_TIPO_DATO_IN_AMBITO,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, cclIdOrigen
    assertEquals(2, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, params.getValue(SQL_PARAM_ID_TAREA));
    // cclIdOrigen
    assertTrue(params.hasValue(SQL_PARAM_CCL_ID_ORIGEN));
    assertEquals(idOrigen, params.getValue(SQL_PARAM_CCL_ID_ORIGEN));
  }
}
