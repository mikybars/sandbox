package com.inditex.rrhh.icmclcwb.model.primary.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVenta;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
public class PrimaryTemporaryTableVentasMonacoRepositoryCustomImplTest {

  private static final Integer UPDATE_RESULT = 100;

  private static final String SQL_CREATE_TEMP_MONACO = "SQL CREATE TEMP MONACO";

  private static final String SQL_DELETE_TEMP_MONACO = "SQL DELETE TEMP MONACO";

  private static final String SQL_INSERT_TEMP_MONACO = "SQL INSERT TEMP MONACO";

  private static final String SQL_MERGE_TEMP_MONACO = "SQL MERGE TEMP MONACO";

  private static final int BATCH_SIZE = 1;

  @Mock
  private JdbcTemplate jdbcTemplate;

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private PrimaryTemporaryTableVentasMonacoRepositoryCustomImpl primaryTemporaryTableVentasMonacoRepositoryCustom;

  @BeforeEach
  void setup() throws IllegalAccessException {
    when(this.jdbcTemplate.update(any(String.class))).thenReturn(UPDATE_RESULT);
    FieldUtils.writeField(this.primaryTemporaryTableVentasMonacoRepositoryCustom,
        "sqlCreateTempVentasMonacoPtr", SQL_CREATE_TEMP_MONACO, true);
    FieldUtils.writeField(this.primaryTemporaryTableVentasMonacoRepositoryCustom,
        "sqlDeleteTempVentasMonacoPtr", SQL_DELETE_TEMP_MONACO, true);
    FieldUtils.writeField(this.primaryTemporaryTableVentasMonacoRepositoryCustom,
        "sqlInsertTempVentasMonacoPtr", SQL_INSERT_TEMP_MONACO, true);
    FieldUtils.writeField(this.primaryTemporaryTableVentasMonacoRepositoryCustom,
        "sqlMerge", SQL_MERGE_TEMP_MONACO, true);
    FieldUtils.writeField(this.primaryTemporaryTableVentasMonacoRepositoryCustom,
        "batchSize", BATCH_SIZE, true);
  }

  @Test
  void deleteTempMonacoPtrTest() {
    final int result = this.primaryTemporaryTableVentasMonacoRepositoryCustom.deleteTempMonacoPtr();
    verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_MONACO);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void createTempMonacoPtrTest() {
    final int result = this.primaryTemporaryTableVentasMonacoRepositoryCustom.createTempMonacoPtr();
    verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_MONACO);
    assertEquals(UPDATE_RESULT, result);
  }

  @Test
  void insertTempMonacoPtrTest(
      @Random(size = 1, type = TareaLocalizacionVenta.class) final List<TareaLocalizacionVenta> TareaLocVenta) {
    doReturn(null).when(this.namedParameterJdbcTemplate).batchUpdate(SQL_INSERT_TEMP_MONACO,
        SqlParameterSourceUtils.createBatch(TareaLocVenta.toArray()));

    final List<TareaLocalizacionVenta> result = this.primaryTemporaryTableVentasMonacoRepositoryCustom.insertTempMonacoPtr(TareaLocVenta);
    assertEquals(TareaLocVenta, result);
  }

  @Test
  void mergeIntoTareaLocalizacionVenta(@Random final TareaDto tarea) {

    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    doReturn(UPDATE_RESULT).when(this.namedParameterJdbcTemplate).update(SQL_MERGE_TEMP_MONACO,
        params);

    this.primaryTemporaryTableVentasMonacoRepositoryCustom.mergeIntoTareaLocalizacionVenta(tarea);
  }

}
