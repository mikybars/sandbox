package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresupuesto;

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
public class TareaLocalizacionPresupuestoRepositoryCustomImplTest {

  private final static String SQL_SAVE = "SQL SAVE";

  private final static String SQL_UPDATE_ACTIVO_BANDA_EXCEPCION = "SQL UPDATE ACTIVO BANDA EXCEPCION";

  private final static String SQL_UPDATE_ACTIVO_BANDAS_SIN_EXCEPCION = "SQL UPDATE ACTIVO BANDAS SIN EXCEPCION";

  private final static String SQL_FIND_PRESUPUESTOS = "SQL FIND PRESUPUESTOS";

  private final static String SQL_FIND_RANGO_FECHAS_PRESUPUESTOS = "SQL FIND RANGO FECHA PRESUPUESTOS";

  @Mock
  private JdbcTemplate template;

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private TareaLocalizacionPresupuestoRepositoryCustomImpl tareaPresupuestoRepositoryCustom;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaPresupuestoRepositoryCustom, "sqlSave", SQL_SAVE, true);
    FieldUtils.writeField(this.tareaPresupuestoRepositoryCustom, "sqlUpdateActivoBandaExcepcion",
        SQL_UPDATE_ACTIVO_BANDA_EXCEPCION, true);
    FieldUtils.writeField(this.tareaPresupuestoRepositoryCustom, "sqlUpdateActivoBandasSinExcepcion",
        SQL_UPDATE_ACTIVO_BANDAS_SIN_EXCEPCION, true);
    FieldUtils.writeField(this.tareaPresupuestoRepositoryCustom, "sqlFindPresupuestos", SQL_FIND_PRESUPUESTOS,
        true);
    FieldUtils.writeField(this.tareaPresupuestoRepositoryCustom, "sqlFindPeriodoPresupuestoYTrabajo",
        SQL_FIND_RANGO_FECHAS_PRESUPUESTOS, true);
    FieldUtils.writeField(this.tareaPresupuestoRepositoryCustom, "batchSize", 100, true);
  }

  @Test
  public void saveTest() {

    final List<TareaLocalizacionPresupuesto> items = Collections
        .singletonList(mock(TareaLocalizacionPresupuesto.class));

    this.tareaPresupuestoRepositoryCustom.save(items);
    verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(), any(SqlParameterSource[].class));

    assertEquals(SQL_SAVE, this.sqlCaptor.getValue());

  }

  @Test
  public void findPresupuestosTest() {

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(809L);

    this.tareaPresupuestoRepositoryCustom.findPresupuestos(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<TareaLocalizacionPresupuesto>>any());

    assertEquals(SQL_FIND_PRESUPUESTOS, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(1, params.getValues().size());
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

  }

  @Test
  public void findPeriodoPresupuestoYTrabajo() {

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(8989L);

    this.tareaPresupuestoRepositoryCustom.findPeriodoPresupuestoYTrabajo(tarea.getId());
    verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(this.sqlCaptor.capture(),
        this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<TareaLocalizacionPresupuesto>>any());

    assertEquals(SQL_FIND_RANGO_FECHAS_PRESUPUESTOS, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(1, params.getValues().size());
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

  }

  @Test
  public void updateActivoBandaExcepcionTest() {

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(48L);

    this.tareaPresupuestoRepositoryCustom.updateActivoBandaExcepcion(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_UPDATE_ACTIVO_BANDA_EXCEPCION, this.sqlCaptor.getValue());
    // Parametros de la consulta: idTarea, icmCkExcepcion, nuevoActivo
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(3, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    // icmCkExcepcion
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ICM_CK_EXCEPCION));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ICM_CK_EXCEPCION));
    // nuevoActivo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
        params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
  }

  @Test
  public void udpateActivoBandasSinExcepcion() {

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(2019426L);

    this.tareaPresupuestoRepositoryCustom.updateActivoBandasSinExcepcion(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_UPDATE_ACTIVO_BANDAS_SIN_EXCEPCION, this.sqlCaptor.getValue());

    // Parámetros de la consulta: idTipoGrupoDato, idTarea, icmCkExcepcion, activo, nuevoActivo
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(5, params.getValues().size());
    // idTipoGrupoDato
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO));
    assertEquals(TipoGrupoDatoEnum.VENTA_RANGO_REAL_Y_CONGELADA.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO));
    // idTarea
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    // icmCkException
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ICM_CK_EXCEPCION));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ICM_CK_EXCEPCION));
    // activo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    // nuevoActivo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
        params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));

  }

}
