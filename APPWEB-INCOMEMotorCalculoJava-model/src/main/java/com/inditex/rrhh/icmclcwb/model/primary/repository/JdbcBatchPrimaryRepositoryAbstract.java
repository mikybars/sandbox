package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

public abstract class JdbcBatchPrimaryRepositoryAbstract<Z extends Object> {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public List<Z> saveJdbcBatchList(final List<Z> src, String sql, int batchSize) {
        for (List<Z> iter : StreamUtils.partition(src, batchSize)) {
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
        }
        return src;
    }

    public abstract void setParameters(PreparedStatement pstmt, Z entity) throws SQLException;

}
