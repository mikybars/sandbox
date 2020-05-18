package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;

import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import org.slf4j.Logger;

public abstract class JdbcBatchPrimaryRepositoryAbstract<Z extends Object> {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private Logger log;

    public List<Z> saveNamedJdbcBatchList(final List<Z> src, final String sql, final int batchSize) {
        for (final List<Z> iter : StreamUtils.partition(src, batchSize)) {
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

}
