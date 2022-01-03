package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraPolitica;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaPersonaEstructuraPoliticaRepositoryCustomImplTest {

  private static final String SQL_SAVE = "SQL_SAVE";

  private final static String SQL_EXISTENCIA = "SQL EXISTENCIA";

  private final static Long ID_TAREA = 9991L;

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @Captor
  private ArgumentCaptor<Map<String, ?>> paramsCaptor;

  @InjectMocks
  private TareaPersonaEstructuraPoliticaRepositoryCustomImpl tareaPersonaEstructuraPoliticaRepositoryCustom;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaPersonaEstructuraPoliticaRepositoryCustom,
        "sqlSave", SQL_SAVE, true);
    FieldUtils.writeField(this.tareaPersonaEstructuraPoliticaRepositoryCustom,
        "batchSize", 100, true);
    FieldUtils.writeField(this.tareaPersonaEstructuraPoliticaRepositoryCustom, "sqlExistencia",
        SQL_EXISTENCIA, true);
  }

  private TareaDto createTarea() {
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    return tarea;
  }

  private List<TipoPoliticaEnum> createPoliticaList() {
    return Arrays.asList(TipoPoliticaEnum.ANTIGUEDAD, TipoPoliticaEnum.BAJA_IT, TipoPoliticaEnum.VACACIONES);
  }

  @Test
  public void saveTest() {
    final List<TareaPersonaEstructuraPolitica> items = Arrays.asList(mock(TareaPersonaEstructuraPolitica.class));
    this.tareaPersonaEstructuraPoliticaRepositoryCustom.save(items);
    verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(), any(SqlParameterSource[].class));
    assertEquals(SQL_SAVE, this.sqlCaptor.getValue());
  }

  @Test
  void existenciaNumParamsTest() {
    this.tareaPersonaEstructuraPoliticaRepositoryCustom
        .existePolitica(this.createTarea(), this.createPoliticaList());
    verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(eq(SQL_EXISTENCIA),
        this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<Boolean>>any());
    assertEquals(2, this.paramsCaptor.getValue().size());
  }

  @Test
  void existenciaIdTareaParamTest() {
    this.tareaPersonaEstructuraPoliticaRepositoryCustom
        .existePolitica(this.createTarea(), this.createPoliticaList());
    verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(eq(SQL_EXISTENCIA),
        this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<Boolean>>any());
    final Map<String, ?> params = this.paramsCaptor.getValue();
    assertTrue(params.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(ID_TAREA, params.get(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
  }

  @Test
  void existenciaIdTipoPoliticaTest() {
    final List<TipoPoliticaEnum> politicas = this.createPoliticaList();
    this.tareaPersonaEstructuraPoliticaRepositoryCustom
        .existePolitica(this.createTarea(), this.createPoliticaList());
    verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(eq(SQL_EXISTENCIA),
        this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<Boolean>>any());
    final Map<String, ?> params = this.paramsCaptor.getValue();
    assertTrue(params.containsKey(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));
    assertEquals(Arrays.asList(TipoPoliticaEnum.ANTIGUEDAD.getId(), TipoPoliticaEnum.BAJA_IT
        .getId(), TipoPoliticaEnum.VACACIONES.getId()), params.get(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA));
  }

  @Test
  void existenciaCuenta0Test() {
    when(this.namedParameterJdbcTemplate.queryForObject(any(String.class), ArgumentMatchers.<Map<String, ?>>any(),
        ArgumentMatchers.<RowMapper<Boolean>>any())).thenAnswer((invocation) -> {

          final RowMapper<Boolean> rowMapper = invocation.getArgument(2);
          final ResultSet rs = mock(ResultSet.class);

          when(rs.getInt(SqlPrimaryConstants.SQL_RESULT_TOTAL)).thenReturn(0);

          return rowMapper.mapRow(rs, 0);

        });
    final Boolean result = this.tareaPersonaEstructuraPoliticaRepositoryCustom
        .existePolitica(this.createTarea(), this.createPoliticaList());
    assertFalse(result);
  }

  @Test
  void existenciaCuentaMayor0Test() {
    when(this.namedParameterJdbcTemplate.queryForObject(any(String.class), ArgumentMatchers.<Map<String, ?>>any(),
        ArgumentMatchers.<RowMapper<Boolean>>any())).thenAnswer((invocation) -> {

          final RowMapper<Boolean> rowMapper = invocation.getArgument(2);
          final ResultSet rs = mock(ResultSet.class);

          when(rs.getInt(SqlPrimaryConstants.SQL_RESULT_TOTAL)).thenReturn(100);

          return rowMapper.mapRow(rs, 0);

        });
    final Boolean result = this.tareaPersonaEstructuraPoliticaRepositoryCustom
        .existePolitica(this.createTarea(), this.createPoliticaList());
    assertTrue(result);
  }

}
