package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class JdbcBatchRepository <Z extends Object> {
    
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    
    public List<Z> saveJdbcBatchList(final List<Z> src, String sql, int batchSize) throws Exception{
      
      final AtomicInteger counter = new AtomicInteger(0);
      for (List<Z> iter : src.stream()
              .collect(Collectors.groupingBy(
                      item -> counter.getAndIncrement() / batchSize))
              .values()) {
          
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
