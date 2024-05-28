package com.inditex.rrhh.icmclcwb.model.primary.repository;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
public class JdbcBatchPrimaryRepositoryAbstractTest {

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Mock
  private JdbcBatchPrimaryRepositoryAbstract<Object> jdbcBatchPrimaryRepositoryAbstract;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void updateShouldNotThrowException() {
    final String sql = "UPDATE table SET column = :value WHERE id = :id";
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("value", "newValue");
    parameters.addValue("id", 1);
    assertDoesNotThrow(() -> this.jdbcBatchPrimaryRepositoryAbstract.update(sql, parameters));
  }

  @Test
  public void queryShouldReturnList() {
    final String sql = "SELECT * FROM table WHERE id = :id";
    final SqlParameterSource paramSource = new MapSqlParameterSource().addValue("id", 1);
    final RowMapper<Object> rowMapper = (rs, rowNum) -> new Object();
    when(this.namedParameterJdbcTemplate.query(anyString(), any(SqlParameterSource.class), any(RowMapper.class)))
        .thenReturn(new ArrayList<>());
    final List<Object> result = this.jdbcBatchPrimaryRepositoryAbstract.query(sql, paramSource, rowMapper);
    assertNotNull(result);
  }

}
