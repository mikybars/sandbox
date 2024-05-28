package com.inditex.rrhh.icmclcwb.model.comis.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public abstract class JdbcBatchComisRepositoryAbstract<Z extends Object> {

  @Autowired
  @Qualifier("comisNamedParameterJdbcTemplate")
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Value("${app.envars.repository.batch-size.default}")
  private int defaultBatchSize;

  private static final Logger LOG = LoggerFactory.getLogger(JdbcBatchComisRepositoryAbstract.class);

  public <T> List<T> query(final String sql, final SqlParameterSource paramSource, final RowMapper<T> rowMapper) {
    try {
      return this.namedParameterJdbcTemplate.query(sql, paramSource, rowMapper);
    } catch (final DataAccessException e) {
      JdbcBatchComisRepositoryAbstract.LOG.error("JdbcBatchComisRepositoryAbstract :: update :: Error consultando lista :: Items: {}",
          paramSource,
          e);
      throw e;
    }
  }

  public <T> T queryForObject(final String sql, final SqlParameterSource paramSource, final RowMapper<T> rowMapper) {
    try {
      return this.namedParameterJdbcTemplate.queryForObject(sql, paramSource, rowMapper);
    } catch (final DataAccessException e) {
      JdbcBatchComisRepositoryAbstract.LOG.error("JdbcBatchComisRepositoryAbstract :: update :: Error consultando objeto :: Items: {}",
          paramSource,
          e);
      throw e;
    }
  }

}
