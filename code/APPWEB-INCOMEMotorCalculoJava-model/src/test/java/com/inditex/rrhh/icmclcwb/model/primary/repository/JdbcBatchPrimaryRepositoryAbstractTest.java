package com.inditex.rrhh.icmclcwb.model.primary.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

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

  @Nested
  class BooleanToIntegerConversion {

    @Mock
    private NamedParameterJdbcTemplate mockJdbcTemplate;

    @Captor
    private ArgumentCaptor<SqlParameterSource[]> paramSourceCaptor;

    private TestRepository repository;

    @BeforeEach
    void setUp() {
      MockitoAnnotations.openMocks(this);
      repository = new TestRepository();
      ReflectionTestUtils.setField(repository, "namedParameterJdbcTemplate", mockJdbcTemplate);
      ReflectionTestUtils.setField(repository, "defaultBatchSize", 100);
    }

    @Test
    void when_boolean_true_expect_integer_one() {
      final TestEntity entity = new TestEntity("test", Boolean.TRUE, 10);
      when(mockJdbcTemplate.batchUpdate(anyString(), any(SqlParameterSource[].class)))
          .thenReturn(new int[]{1});

      repository.saveNamedJdbcBatchList(List.of(entity), "INSERT INTO T (name, activo, count) VALUES(:name, :activo, :count)", 0);

      verify(mockJdbcTemplate).batchUpdate(anyString(), paramSourceCaptor.capture());
      final SqlParameterSource[] captured = paramSourceCaptor.getValue();
      assertThat(captured[0].getValue("activo")).isEqualTo(1);
      assertThat(captured[0].getSqlType("activo")).isEqualTo(java.sql.Types.INTEGER);
    }

    @Test
    void when_boolean_false_expect_integer_zero() {
      final TestEntity entity = new TestEntity("test", Boolean.FALSE, 10);
      when(mockJdbcTemplate.batchUpdate(anyString(), any(SqlParameterSource[].class)))
          .thenReturn(new int[]{1});

      repository.saveNamedJdbcBatchList(List.of(entity), "INSERT INTO T (name, activo, count) VALUES(:name, :activo, :count)", 0);

      verify(mockJdbcTemplate).batchUpdate(anyString(), paramSourceCaptor.capture());
      final SqlParameterSource[] captured = paramSourceCaptor.getValue();
      assertThat(captured[0].getValue("activo")).isEqualTo(0);
    }

    @Test
    void when_non_boolean_field_expect_value_unchanged() {
      final TestEntity entity = new TestEntity("hello", Boolean.TRUE, 42);
      when(mockJdbcTemplate.batchUpdate(anyString(), any(SqlParameterSource[].class)))
          .thenReturn(new int[]{1});

      repository.saveNamedJdbcBatchList(List.of(entity), "INSERT INTO T (name, activo, count) VALUES(:name, :activo, :count)", 0);

      verify(mockJdbcTemplate).batchUpdate(anyString(), paramSourceCaptor.capture());
      final SqlParameterSource[] captured = paramSourceCaptor.getValue();
      assertThat(captured[0].getValue("name")).isEqualTo("hello");
      assertThat(captured[0].getValue("count")).isEqualTo(42);
    }

    @Test
    void when_null_boolean_field_expect_null_returned() {
      final TestEntity entity = new TestEntity("test", null, 5);
      when(mockJdbcTemplate.batchUpdate(anyString(), any(SqlParameterSource[].class)))
          .thenReturn(new int[]{1});

      repository.saveNamedJdbcBatchList(List.of(entity), "INSERT INTO T (name, activo, count) VALUES(:name, :activo, :count)", 0);

      verify(mockJdbcTemplate).batchUpdate(anyString(), paramSourceCaptor.capture());
      final SqlParameterSource[] captured = paramSourceCaptor.getValue();
      assertThat(captured[0].getValue("activo")).isNull();
    }

    @Test
    void when_has_value_expect_delegate_called() {
      final TestEntity entity = new TestEntity("test", Boolean.TRUE, 1);
      when(mockJdbcTemplate.batchUpdate(anyString(), any(SqlParameterSource[].class)))
          .thenReturn(new int[]{1});

      repository.saveNamedJdbcBatchList(List.of(entity), "INSERT INTO T (name) VALUES(:name)", 0);

      verify(mockJdbcTemplate).batchUpdate(anyString(), paramSourceCaptor.capture());
      final SqlParameterSource[] captured = paramSourceCaptor.getValue();
      assertThat(captured[0].hasValue("name")).isTrue();
      assertThat(captured[0].getTypeName("name")).isNull();
      assertThat(captured[0].getParameterNames()).isNotNull();
    }

    @Test
    void when_database_error_expect_exception_propagated() {
      final TestEntity entity = new TestEntity("test", Boolean.TRUE, 1);
      when(mockJdbcTemplate.batchUpdate(anyString(), any(SqlParameterSource[].class)))
          .thenThrow(new DataIntegrityViolationException("DB error"));

      assertThatThrownBy(() -> repository.saveNamedJdbcBatchList(
          List.of(entity), "INSERT INTO T (name) VALUES(:name)", 0))
              .isInstanceOf(DataAccessException.class);
    }

    @Test
    void when_non_boolean_sql_type_expect_delegate_type() {
      final TestEntity entity = new TestEntity("test", Boolean.TRUE, 42);
      when(mockJdbcTemplate.batchUpdate(anyString(), any(SqlParameterSource[].class)))
          .thenReturn(new int[]{1});

      repository.saveNamedJdbcBatchList(List.of(entity), "INSERT INTO T (name) VALUES(:name)", 0);

      verify(mockJdbcTemplate).batchUpdate(anyString(), paramSourceCaptor.capture());
      final SqlParameterSource[] captured = paramSourceCaptor.getValue();
      assertThat(captured[0].getSqlType("name")).isEqualTo(java.sql.Types.VARCHAR);
    }

    private static class TestRepository extends JdbcBatchPrimaryRepositoryAbstract<TestEntity> {
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class TestEntity {
      private String name;

      private Boolean activo;

      private Integer count;
    }
  }

}
