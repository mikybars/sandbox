package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

import org.slf4j.Logger;
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

  @Autowired
  @Qualifier("primaryNamedParameterJdbcTemplate")
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Value("${app.envars.repository.batch-size.default}")
  private int defaultBatchSize;

  @Autowired
  private Logger log;

  public List<Z> saveNamedJdbcBatchList(final List<Z> src, final String sql, final int batchSize) {
    for (final List<Z> iter : StreamUtils.partition(src, (batchSize != 0 ? batchSize : this.defaultBatchSize))) {
      try {
        final SqlParameterSource[] itemList = SqlParameterSourceUtils.createBatch(iter.toArray());
        this.namedParameterJdbcTemplate.batchUpdate(sql, itemList);
      } catch (final DataAccessException e) {
        this.log.error("JdbcBatchPrimaryRepositoryAbstract :: saveJdbcBatchList :: Error ", e);
        iter.stream()
            .forEach(a -> this.log.error(
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
      this.log.error("JdbcBatchPrimaryRepositoryAbstract :: update :: Error insertando :: Items: {}", parameters,
          e);
      throw e;
    }
  }

  public <T> List<T> query(final String sql, final SqlParameterSource paramSource, final RowMapper<T> rowMapper) {
    try {
      return this.namedParameterJdbcTemplate.query(sql, paramSource, rowMapper);
    } catch (final DataAccessException e) {
      this.log.error("JdbcBatchPrimaryRepositoryAbstract :: update :: Error consultando lista :: Items: {}",
          paramSource,
          e);
      throw e;
    }
  }

  public <T> T queryForObject(final String sql, final SqlParameterSource paramSource, final RowMapper<T> rowMapper) {
    try {
      return this.namedParameterJdbcTemplate.queryForObject(sql, paramSource, rowMapper);
    } catch (final DataAccessException e) {
      this.log.error("JdbcBatchPrimaryRepositoryAbstract :: update :: Error consultando objeto :: Items: {}",
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
      this.log.error("JdbcBatchPrimaryRepositoryAbstract :: update :: Error consultando objeto :: Items: {}",
          paramSource,
          e);
      throw e;
    }
  }

}
