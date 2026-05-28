package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.sql.Types;
import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;

public abstract class JdbcBatchPrimaryRepositoryAbstract<Z extends Object> {

  private static final Logger LOG = LoggerFactory.getLogger(JdbcBatchPrimaryRepositoryAbstract.class);

  @Autowired
  @Qualifier("primaryNamedParameterJdbcTemplate")
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Value("${app.envars.repository.batch-size.default}")
  private int defaultBatchSize;

  public List<Z> saveNamedJdbcBatchList(final List<Z> src, final String sql, final int batchSize) {
    for (final List<Z> iter : StreamUtils.partition(src, (batchSize != 0 ? batchSize : this.defaultBatchSize))) {
      try {
        final SqlParameterSource[] args = SqlParameterSourceUtils.createBatch(iter.toArray());
        this.namedParameterJdbcTemplate.batchUpdate(sql, Arrays.stream(args)
            .map(BooleanToIntegerParameterSource::new)
            .toArray(SqlParameterSource[]::new));
      } catch (final DataAccessException e) {
        JdbcBatchPrimaryRepositoryAbstract.LOG.error("JdbcBatchPrimaryRepositoryAbstract :: saveJdbcBatchList :: Error ", e);
        iter.stream()
            .forEach(a -> JdbcBatchPrimaryRepositoryAbstract.LOG.error(
                "JdbcBatchPrimaryRepositoryAbstract :: saveJdbcBatchList :: Error insertando items: {}", a,
                e));
        throw e;
      }
    }
    return src;
  }

  public void update(final String sql, final MapSqlParameterSource parameters) {
    try {
      this.namedParameterJdbcTemplate.update(sql, parameters);
    } catch (final DataAccessException e) {
      JdbcBatchPrimaryRepositoryAbstract.LOG.error("JdbcBatchPrimaryRepositoryAbstract :: update :: Error insertando :: Items: {}",
          parameters,
          e);
      throw e;
    }
  }

  public <T> List<T> query(final String sql, final SqlParameterSource paramSource, final RowMapper<T> rowMapper) {
    try {
      return this.namedParameterJdbcTemplate.query(sql, paramSource, rowMapper);
    } catch (final DataAccessException e) {
      JdbcBatchPrimaryRepositoryAbstract.LOG.error("JdbcBatchPrimaryRepositoryAbstract :: update :: Error consultando lista :: Items: {}",
          paramSource,
          e);
      throw e;
    }
  }

  public <T> T queryForObject(final String sql, final SqlParameterSource paramSource, final RowMapper<T> rowMapper) {
    try {
      return this.namedParameterJdbcTemplate.queryForObject(sql, paramSource, rowMapper);
    } catch (final DataAccessException e) {
      JdbcBatchPrimaryRepositoryAbstract.LOG.error("JdbcBatchPrimaryRepositoryAbstract :: update :: Error consultando objeto :: Items: {}",
          paramSource,
          e);
      throw e;
    }
  }

  public <T> T queryForObject(final String sql, final MapSqlParameterSource paramSource,
      final Class<T> requiredType) {
    try {
      return this.namedParameterJdbcTemplate.queryForObject(sql, paramSource, requiredType);
    } catch (final DataAccessException e) {
      JdbcBatchPrimaryRepositoryAbstract.LOG.error("JdbcBatchPrimaryRepositoryAbstract :: update :: Error consultando objeto :: Items: {}",
          paramSource,
          e);
      throw e;
    }
  }

  /**
   * Workaround temporal: intercepta valores Boolean y los convierte a Integer (1/0) para compatibilidad con PostgreSQL.
   *
   * <p>Esto es necesario porque las columnas booleanas (ES_ACTIVO, etc.) siguen definidas como NUMERIC(1,0) en el esquema actual, herencia
   * directa de la migración DB2 → PostgreSQL. DB2 realizaba la conversión implícita boolean↔numeric; PostgreSQL no.
   *
   * <p><b>Fix definitivo:</b> migrar todas esas columnas a tipo BOOLEAN nativo en PostgreSQL y eliminar este wrapper.
   *
   * @see <a href="https://jira.inditex.com/jira/browse/IOPINCOME-362">IOPINCOME-362</a>
   */
  private record BooleanToIntegerParameterSource(SqlParameterSource delegate) implements SqlParameterSource {

    @Override
    public boolean hasValue(final String paramName) {
      return this.delegate.hasValue(paramName);
    }

    @Override
    public Object getValue(final String paramName) throws IllegalArgumentException {
      final Object value = this.delegate.getValue(paramName);
      if (value instanceof Boolean) {
        return Boolean.TRUE.equals(value) ? 1 : 0;
      }
      return value;
    }

    @Override
    public int getSqlType(final String paramName) {
      final Object value = this.delegate.getValue(paramName);
      if (value instanceof Boolean) {
        return Types.INTEGER;
      }
      return this.delegate.getSqlType(paramName);
    }

    @Override
    public String getTypeName(final String paramName) {
      return this.delegate.getTypeName(paramName);
    }

    @Override
    public String[] getParameterNames() {
      return this.delegate.getParameterNames();
    }
  }

}
