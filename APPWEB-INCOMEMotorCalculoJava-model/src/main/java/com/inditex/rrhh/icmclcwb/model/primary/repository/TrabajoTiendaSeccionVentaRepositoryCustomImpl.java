package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaSeccionVenta;

@Repository
public class TrabajoTiendaSeccionVentaRepositoryCustomImpl implements TrabajoTiendaSeccionVentaRepositoryCustom {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    @Qualifier("primaryDataSource")
    private DataSource dataSource;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    
    private static final int BATCH_SIZE = 100;
    private static final String INSERT = "INSERT INTO DESARROLLO_RRHH.INCOME_TRABAJO_TIENDA_SECCION_VENTA (FECHA, ID_SECCION, ID_TIENDA, IMPORTE, ID_TRABAJO )" + 
            "VALUES(?, ?, ?, ? , ?)";

    @Override
    public List<TrabajoTiendaSeccionVenta> saveJdbcTemplate(List<TrabajoTiendaSeccionVenta> src) {
        
        jdbcTemplate.batchUpdate(INSERT, new BatchPreparedStatementSetter() {
            
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setObject(1, src.get(i).getFecha());
                ps.setString(2, src.get(i).getIdSeccion());
                ps.setString(3, src.get(i).getIdTienda());
                ps.setDouble(4, src.get(i).getImporte());
                ps.setLong(5, src.get(i).getTrabajo().getId());
            }
            
            @Override
            public int getBatchSize() {
                return src.size();
            }
        });
        
        return src;
    }
        
    @Override
    public List<TrabajoTiendaSeccionVenta> saveBatch(List<TrabajoTiendaSeccionVenta> src) {
       
        try(Connection connection = dataSource.getConnection()){
            connection.setAutoCommit(false);
            try (PreparedStatement pstmt = connection.prepareStatement(INSERT)) {
                int cont = 0;
                Iterator<TrabajoTiendaSeccionVenta> iterator = src.iterator();
                while (iterator.hasNext()) {
                    TrabajoTiendaSeccionVenta entity = iterator.next();
                    pstmt.setObject(1, entity.getFecha());
                    pstmt.setString(2, entity.getIdSeccion());
                    pstmt.setString(3, entity.getIdTienda());
                    pstmt.setDouble(4, entity.getImporte());
                    pstmt.setLong(5, entity.getTrabajo().getId());
                    pstmt.addBatch();
                    cont++;
                    if (cont % src.size() == 0) {
                        pstmt.executeBatch();
                        connection.commit();
                    }
                }
                connection.commit();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
       
        return src;

    }
    
    @Override
    public List<TrabajoTiendaSeccionVenta> saveBatchJpa(List<TrabajoTiendaSeccionVenta> src) {
        
        EntityTransaction tx = entityManager.getTransaction();
        Iterator<TrabajoTiendaSeccionVenta> iterator = src.iterator();
        tx.begin();
        int cont = 0;
        while (iterator.hasNext()) {
            entityManager.persist(iterator.next());
            cont++;
            if (cont % BATCH_SIZE == 0) {
                entityManager.flush();
                entityManager.clear();
                tx.commit();
                tx.begin();
            }
        }
        tx.commit();
        
        return src;
        
    }

        
}
