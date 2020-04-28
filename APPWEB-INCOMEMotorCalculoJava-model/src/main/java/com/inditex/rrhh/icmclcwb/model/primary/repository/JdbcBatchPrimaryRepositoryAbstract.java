package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;

import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

public abstract class JdbcBatchPrimaryRepositoryAbstract<Z extends Object> {

    /** @deprecated Se debe usar NamedParameterJdbcTemplate */
    @Deprecated
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Autowired
    private Logger log;

    /** @deprecated Se debe usar saveNamedJdbcBatchList */
    @Deprecated
    public List<Z> saveJdbcBatchList(final List<Z> src, String sql, int batchSize) {
        for (List<Z> iter : StreamUtils.partition(src, batchSize)) {
            try {
                jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        setParameters(ps, iter.get(i));
                    }

                    @Override
                    public int getBatchSize() {
                        return iter.size();
                    }
                });
            } catch (DataAccessException e) {
                log.error("JdbcBatchPrimaryRepositoryAbstract :: saveJdbcBatchList :: Error ", e);
                iter.stream().forEach(a -> log.error("JdbcBatchPrimaryRepositoryAbstract :: saveJdbcBatchList :: Error insertando items: {}", a, e));
                throw e;
            }
        }
        return src;
    }
    
    /** @deprecated Se debe usar saveNamedJdbcBatchList */
    @Deprecated
    public abstract void setParameters(PreparedStatement pstmt, Z entity) throws SQLException;
    
    public List<Z> saveNamedJdbcBatchList(final List<Z> src, String sql, int batchSize) {
        for (List<Z> iter : StreamUtils.partition(src, batchSize)) {
            try {
                SqlParameterSource[] itemList = SqlParameterSourceUtils.createBatch(iter.toArray());
                namedParameterJdbcTemplate.batchUpdate(sql, itemList);
            } catch (DataAccessException e) {
                log.error("JdbcBatchPrimaryRepositoryAbstract :: saveJdbcBatchList :: Error ", e);
                iter.stream().forEach(a -> log.error("JdbcBatchPrimaryRepositoryAbstract :: saveJdbcBatchList :: Error insertando items: {}", a, e));
                throw e;
            }
        }
        return src;
    }
    
    public void update(String sql, final MapSqlParameterSource parameters) {
        try {
            namedParameterJdbcTemplate.update(sql, parameters);
        } catch (DataAccessException e) {
            log.error("JdbcBatchPrimaryRepositoryAbstract :: update :: Error insertando :: Items: {}", parameters, e);
            throw e;
        }
    }

}
