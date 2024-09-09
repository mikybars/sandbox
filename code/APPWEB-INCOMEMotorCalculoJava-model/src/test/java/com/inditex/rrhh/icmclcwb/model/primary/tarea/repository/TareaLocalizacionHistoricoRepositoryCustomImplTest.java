package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ACTIVO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_CONCEPTO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TAREA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_INCLUSION;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_VALUE_PORCENTAJE_CERO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoComisionEnum;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionHistorico;

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
public class TareaLocalizacionHistoricoRepositoryCustomImplTest {

  private static final String SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA_ID_ORIGEN_IN_AMBITO =
      "SQL FIND ID LOCALIZACION BY ID TAREA ID ORIGEN IN AMBITO TEST";

  private static final String SQL_SAVE = "SAVE TEST";

  private static final String SQL_FIND_ID_LOCALIZACION_LOCAL_BY_ID_TAREA_ID_ORIGEN_IN_AMBITO =
      "SQL FIND ID LOCALIZACION LOCAL BY ID TAREA ID ORIGEN IN AMBITO TEST";

  private static final String SQL_CADENAS_FILTRO_TIPO_DATO = "SQL CADENAS FILTRO TIPO DATO TEST";

  private static final String SQL_CADENAS = "CADENAS TEST";

  private static final String SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA_AND_ID_TIPO_CALCULO =
      "SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA_AND_ID_TIPO_CALCULO";

  private static final String SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA_AND_ORIGEN_IN_AMBITO_LOCALIZACION =
      "SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA_AND_ORIGEN_IN_AMBITO_LOCALIZACION";

  private static final String SQL_FIND_ID_LOCALIZACION_LOCAL_BY_ID_TAREA_AND_ORIGEN_IN_AMBITO_LOCALIZACION =
      "SQL_FIND_ID_LOCALIZACION_LOCAL_BY_ID_TAREA_AND_ORIGEN_IN_AMBITO_LOCALIZACION";

  private static final String SQL_FIND_ID_LOCALIZACION_PRESUPUESTOS_BY_ID_TAREA = "SQL_FIND_ID_LOCALIZACION_PRESUPUESTOS_BY_ID_TAREA";

  private static final String SQL_FIND_ID_LOCALIZACION_PRESUPUESTOS_BY_STD_ID_LEG_ENT_AND_ID_TAREA =
      "SQL_FIND_ID_LOCALIZACION_PRESUPUESTOS_BY_STD_ID_LEG_ENT_AND_ID_TAREA";

  private static final String SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA =
      "SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Mock
  private JdbcTemplate jdbcTemplate;

  @InjectMocks
  private TareaLocalizacionHistoricoRepositoryCustomImpl tareaLocalizacionHistoricoRepositoryCustom;

  @Captor
  private ArgumentCaptor<String> sql;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> params;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaLocalizacionHistoricoRepositoryCustom,
        "sqlSave", SQL_SAVE, true);
    FieldUtils.writeField(this.tareaLocalizacionHistoricoRepositoryCustom,
        "sqlFindIdLocalizacionDtoByIdTareaAndIdOrigenInAmbito",
        SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA_ID_ORIGEN_IN_AMBITO, true);
    FieldUtils.writeField(this.tareaLocalizacionHistoricoRepositoryCustom,
        "sqlFindIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbito",
        SQL_FIND_ID_LOCALIZACION_LOCAL_BY_ID_TAREA_ID_ORIGEN_IN_AMBITO, true);
    FieldUtils.writeField(this.tareaLocalizacionHistoricoRepositoryCustom,
        "sqlCadenasFiltroTipoDato", SQL_CADENAS_FILTRO_TIPO_DATO, true);
    FieldUtils.writeField(this.tareaLocalizacionHistoricoRepositoryCustom,
        "sqlCadenas", SQL_CADENAS, true);
    FieldUtils.writeField(this.tareaLocalizacionHistoricoRepositoryCustom,
        "sqlFindIdLocalizacionByIdTareaAndCclIdPersonInAmbito",
        SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA_AND_ID_TIPO_CALCULO, true);
    FieldUtils.writeField(this.tareaLocalizacionHistoricoRepositoryCustom,
        "sqlFindIdLocalizacionDtoByIdTareaAndIdOrigenInAmbitoLocalizacion",
        SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA_AND_ORIGEN_IN_AMBITO_LOCALIZACION, true);
    FieldUtils.writeField(this.tareaLocalizacionHistoricoRepositoryCustom,
        "sqlFindIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbitoLocalizacion",
        SQL_FIND_ID_LOCALIZACION_LOCAL_BY_ID_TAREA_AND_ORIGEN_IN_AMBITO_LOCALIZACION, true);
    FieldUtils.writeField(this.tareaLocalizacionHistoricoRepositoryCustom,
        "sqlFindIdLocalizacionPresupuestosByIdTarea", SQL_FIND_ID_LOCALIZACION_PRESUPUESTOS_BY_ID_TAREA, true);
    FieldUtils.writeField(this.tareaLocalizacionHistoricoRepositoryCustom,
        "sqlFindIdLocalizacionPresupuestosByStdIdLegEntAndIdTarea", SQL_FIND_ID_LOCALIZACION_PRESUPUESTOS_BY_STD_ID_LEG_ENT_AND_ID_TAREA,
        true);
    FieldUtils.writeField(this.tareaLocalizacionHistoricoRepositoryCustom,
        "sqlFindIdLocalizacionByIdTarea", SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA,
        true);
    FieldUtils.writeField(this.tareaLocalizacionHistoricoRepositoryCustom,
        "batchSize", 100, true);
  }

  @Test
  public void saveTest() {
    final List<TareaLocalizacionHistorico> items = Collections.singletonList(mock(TareaLocalizacionHistorico.class));
    this.tareaLocalizacionHistoricoRepositoryCustom.save(items);
    verify(this.namedParameterJdbcTemplate).batchUpdate(this.sql.capture(), any(SqlParameterSource[].class));
    assertEquals(SQL_SAVE, this.sql.getValue());
  }

  @Test
  public void findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbitoTest() {

    final Long idTarea = 89L;
    final String idOrigen = "O38";

    this.tareaLocalizacionHistoricoRepositoryCustom
        .findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(idTarea, idOrigen);
    verify(this.namedParameterJdbcTemplate, times(1))
        .query(this.sql.capture(), this.params.capture(),
            ArgumentMatchers.<RowMapper<TareaLocalizacionHistorico>>any());
    assertEquals(SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA_ID_ORIGEN_IN_AMBITO, this.sql.getValue());
    // parametros de la consulta: idTarea, cclIdOrigen
    assertEquals(2, this.params.getValue().getValues().size());
    // idTarea
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, this.params.getValue().getValue(SQL_PARAM_ID_TAREA));
    // cclIdOrigen
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_CCL_ID_ORIGEN));
    assertEquals(idOrigen, this.params.getValue().getValue(SQL_PARAM_CCL_ID_ORIGEN));

  }

  @Test
  public void findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbitoTest() {

    final Long idTarea = 89L;
    final String idOrigen = "O38";

    this.tareaLocalizacionHistoricoRepositoryCustom
        .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbito(idTarea, idOrigen);
    verify(this.namedParameterJdbcTemplate, times(1))
        .query(this.sql.capture(), this.params.capture(),
            ArgumentMatchers.<RowMapper<TareaLocalizacionHistorico>>any());
    assertEquals(SQL_FIND_ID_LOCALIZACION_LOCAL_BY_ID_TAREA_ID_ORIGEN_IN_AMBITO, this.sql.getValue());
    // parametros de la consulta: idTarea, cclIdOrigen
    assertEquals(2, this.params.getValue().getValues().size());
    // idTarea
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, this.params.getValue().getValue(SQL_PARAM_ID_TAREA));
    // cclIdOrigen
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_CCL_ID_ORIGEN));
    assertEquals(idOrigen, this.params.getValue().getValue(SQL_PARAM_CCL_ID_ORIGEN));

  }

  @Test
  public void getCadenasByTareaAndOrigenVentaConceptoTest() {

    final Long idTarea = 89L;
    final String idOrigen = "O38";
    final Long idVentaConcepto = 222L;

    this.tareaLocalizacionHistoricoRepositoryCustom
        .getCadenasByTareaAndOrigen(idTarea, idOrigen, Collections.singletonList(idVentaConcepto));
    verify(this.namedParameterJdbcTemplate, times(1))
        .query(this.sql.capture(), this.params.capture(),
            ArgumentMatchers.<RowMapper<TareaLocalizacionHistorico>>any());
    assertEquals(SQL_CADENAS_FILTRO_TIPO_DATO, this.sql.getValue());
    // parametros de la consulta: idTarea, cclIdOrigen, porcentajeInclusion, idConcepto
    assertEquals(4, this.params.getValue().getValues().size());
    // idTarea
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, this.params.getValue().getValue(SQL_PARAM_ID_TAREA));
    // cclIdOrigen
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_CCL_ID_ORIGEN));
    assertEquals(idOrigen, this.params.getValue().getValue(SQL_PARAM_CCL_ID_ORIGEN));
    // porcentajeInclusion
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_PORCENTAJE_INCLUSION));
    assertEquals(SQL_VALUE_PORCENTAJE_CERO, this.params.getValue().getValue(SQL_PARAM_PORCENTAJE_INCLUSION));
    // idConcepto
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_CONCEPTO));
    assertInstanceOf(List.class, this.params.getValue().getValue(SQL_PARAM_ID_CONCEPTO));
    assertEquals(1, ((List) this.params.getValue().getValue(SQL_PARAM_ID_CONCEPTO)).size());
    assertEquals(idVentaConcepto, ((List) this.params.getValue().getValue(SQL_PARAM_ID_CONCEPTO)).get(0));

  }

  @Test
  public void getCadenasByTareaAndOrigenTest() {

    final Long idTarea = 89L;
    final String idOrigen = "O38";

    this.tareaLocalizacionHistoricoRepositoryCustom
        .getCadenasByTareaAndOrigen(idTarea, idOrigen);
    verify(this.namedParameterJdbcTemplate, times(1))
        .query(this.sql.capture(), this.params.capture(),
            ArgumentMatchers.<RowMapper<TareaLocalizacionHistorico>>any());
    assertEquals(SQL_CADENAS, this.sql.getValue());
    // parametros de la consulta: idTarea, cclIdOrigen, tiposDato
    assertEquals(2, this.params.getValue().getValues().size());
    // idTarea
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, this.params.getValue().getValue(SQL_PARAM_ID_TAREA));
    // cclIdOrigen
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_CCL_ID_ORIGEN));
    assertEquals(idOrigen, this.params.getValue().getValue(SQL_PARAM_CCL_ID_ORIGEN));

  }

  @Test
  public void findIdLocalizacionLocalDtoByIdTareaAndCclIdsPersonaInAmbitoLocalizacion() {
    final Long idTarea = 23L;
    final String idTipoCalculo1 = "ID TIPO CALCULO";
    final String idTipoCalculo2 = "ID TIPO CALCULO 2";
    final String idOrigen = "ID ORIGEN";

    this.tareaLocalizacionHistoricoRepositoryCustom
        .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoCalculoInAmbitoLocalizacion(idTarea, idOrigen,
            Arrays.asList(idTipoCalculo1, idTipoCalculo2));
    verify(this.namedParameterJdbcTemplate, times(1))
        .query(this.sql.capture(), this.params.capture(),
            ArgumentMatchers.<RowMapper<TareaLocalizacionHistorico>>any());
    assertEquals(SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA_AND_ID_TIPO_CALCULO, this.sql.getValue());
    // parametros de la consulta: idTarea, cclIdOrigen, idTipoCalculo, activo
    assertEquals(4, this.params.getValue().getValues().size());
    // idTarea
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, this.params.getValue().getValue(SQL_PARAM_ID_TAREA));
    // cclIdOrigen
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_CCL_ID_ORIGEN));
    assertEquals(idOrigen, this.params.getValue().getValue(SQL_PARAM_CCL_ID_ORIGEN));
    // idTipoCalculo
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_IDS_TIPOS_CALCULO));
    assertEquals(Arrays.asList(idTipoCalculo1, idTipoCalculo2),
        this.params.getValue().getValue(SQL_PARAM_IDS_TIPOS_CALCULO));
    // cclIdOrigen
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, this.params.getValue().getValue(SQL_PARAM_ACTIVO));
  }

  @Test
  public void findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbitoLocalizacionTest() {
    final Long idTarea = 23L;
    final String idOrigen = "ID ORIGEN";
    this.tareaLocalizacionHistoricoRepositoryCustom
        .findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbitoLocalizacion(idTarea, idOrigen);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sql.capture(), this.params.capture(),
        ArgumentMatchers.<RowMapper<TareaLocalizacionHistorico>>any());
    assertEquals(SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA_AND_ORIGEN_IN_AMBITO_LOCALIZACION, this.sql.getValue());
    // parametros de la consulta: idTarea, cclIdOrigen, idTipoCalculo, activo
    assertEquals(2, this.params.getValue().getValues().size());
    // idTarea
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, this.params.getValue().getValue(SQL_PARAM_ID_TAREA));
    // cclIdOrigen
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_CCL_ID_ORIGEN));
    assertEquals(idOrigen, this.params.getValue().getValue(SQL_PARAM_CCL_ID_ORIGEN));
  }

  @Test
  public void findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbitoLocalizacionTest() {
    final Long idTarea = 23L;
    final String idOrigen = "ID ORIGEN";
    this.tareaLocalizacionHistoricoRepositoryCustom
        .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbitoLocalizacion(idTarea, idOrigen);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sql.capture(), this.params.capture(),
        ArgumentMatchers.<RowMapper<TareaLocalizacionHistorico>>any());
    assertEquals(SQL_FIND_ID_LOCALIZACION_LOCAL_BY_ID_TAREA_AND_ORIGEN_IN_AMBITO_LOCALIZACION, this.sql.getValue());
    // parametros de la consulta: idTarea, cclIdOrigen
    assertEquals(2, this.params.getValue().getValues().size());
    // idTarea
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, this.params.getValue().getValue(SQL_PARAM_ID_TAREA));
    // cclIdOrigen
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_CCL_ID_ORIGEN));
    assertEquals(idOrigen, this.params.getValue().getValue(SQL_PARAM_CCL_ID_ORIGEN));
  }

  @Test
  public void findIdLocalizacionLocalDtoPresupuestosByIdTareaTest() {
    final Long idTarea = 23L;
    this.tareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionLocalDtoPresupuestosByIdTarea(idTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sql.capture(), this.params.capture(),
        ArgumentMatchers.<RowMapper<TareaLocalizacionHistorico>>any());
    assertEquals(SQL_FIND_ID_LOCALIZACION_PRESUPUESTOS_BY_ID_TAREA, this.sql.getValue());
    // parametros de la consulta: idTarea
    assertEquals(3, this.params.getValue().getValues().size());
    // idTarea
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, this.params.getValue().getValue(SQL_PARAM_ID_TAREA));
    // activo
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, this.params.getValue().getValue(SQL_PARAM_ACTIVO));
    // tiposComision
    assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION));
    assertEquals(
        Arrays.asList(TipoComisionEnum.CHALLENGE_PRINCIPAL.getId(),
            TipoComisionEnum.CHALLENGE_SECUNDARIO.getId()),
        this.params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION));
  }

  @Test
  public void findIdLocalizacionPresupuestosByStdIdLegEntAndIdTareaTest() {
    final Long idTarea = 23L;
    final List<String> stdIdLegEnt = List.of("23");
    final List<Long> idTipoConceptoVentaChallenge = List.of(1L);
    this.tareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionPresupuestosByStdIdLegEntAndIdTarea(stdIdLegEnt, idTarea,
        idTipoConceptoVentaChallenge);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sql.capture(), this.params.capture(),
        ArgumentMatchers.<RowMapper<TareaLocalizacionHistorico>>any());
    assertEquals(SQL_FIND_ID_LOCALIZACION_PRESUPUESTOS_BY_STD_ID_LEG_ENT_AND_ID_TAREA, this.sql.getValue());
    // parametros de la consulta: idTarea
    assertEquals(5, this.params.getValue().getValues().size());
    // idTarea
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, this.params.getValue().getValue(SQL_PARAM_ID_TAREA));
    // activo
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ACTIVO));
    assertEquals(SQL_VALUE_BOOLEAN_TRUE, this.params.getValue().getValue(SQL_PARAM_ACTIVO));
    // empresa
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_STD_ID_LEG_ENT));
    assertEquals(stdIdLegEnt, this.params.getValue().getValue(SQL_PARAM_STD_ID_LEG_ENT));
    // tiposCalculo
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_IDS_TIPOS_CALCULO));
    assertEquals(
        Arrays
            .asList(TipoCalculoEnum.CHALLENGE_PORCENTAJE.getId(), TipoCalculoEnum.CHALLENGE_IMPORTE_SECCION.getId(),
                TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId(),
                TipoCalculoEnum.CHALLENGE_PRECIO_HORA_SECCION.getId(),
                TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId(),
                TipoCalculoEnum.CHALLENGE_JORNADA.getId()),
        this.params.getValue().getValue(SQL_PARAM_IDS_TIPOS_CALCULO));
  }

  @Test
  public void findIdLocalizacionByIdTareaTest() {
    final Long idTarea = 23L;
    this.tareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionByIdTarea(idTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sql.capture(), this.params.capture(),
        ArgumentMatchers.<RowMapper<TareaLocalizacionHistorico>>any());
    assertEquals(SQL_FIND_ID_LOCALIZACION_BY_ID_TAREA, this.sql.getValue());
    // parametros de la consulta: idTarea
    assertEquals(1, this.params.getValue().getValues().size());
    // idTarea
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, this.params.getValue().getValue(SQL_PARAM_ID_TAREA));
  }

}
