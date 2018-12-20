package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class JdbcBatchRepository <Z extends Object> {
    
    @Autowired
    @Qualifier("primaryDataSource")
    private DataSource dataSource;

    public List<Z> saveJdbcBatchList(final List<Z> src, String sql, int batchSize) throws Exception{
        
        try(Connection connection = dataSource.getConnection()){
            connection.setAutoCommit(false);
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                int cont = 0;
                Iterator<Z> iterator = src.iterator();
                while (iterator.hasNext()) {
                    Z entity = iterator.next();
                    setParameters(pstmt, entity);
                    pstmt.addBatch();
                    cont++;
                    if (cont % batchSize == 0) {
                        pstmt.executeBatch();
                        connection.commit();
                    }
                }
                connection.commit();
            }catch (SQLException e) {
                throw e;
            }
        } catch (SQLException e1) {
            throw e1;
        }
       
        return src;
    }
    
    public abstract void setParameters(PreparedStatement pstmt, Z entity) throws SQLException;
}
