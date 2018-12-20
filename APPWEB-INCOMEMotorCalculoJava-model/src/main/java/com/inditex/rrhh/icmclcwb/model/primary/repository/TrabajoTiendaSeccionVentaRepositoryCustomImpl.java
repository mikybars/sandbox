package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaSeccionVenta;

@Repository
public class TrabajoTiendaSeccionVentaRepositoryCustomImpl extends JdbcBatchRepository<TrabajoTiendaSeccionVenta> implements TrabajoTiendaSeccionVentaRepositoryCustom {

    //TODO: Eliminar métodos de batch con jpa y jdbctemplate y quedarse con el genérico.
//    @Autowired
//    @Qualifier("primaryJdbcTemplate")
//    private JdbcTemplate jdbcTemplate;
//    
//    @Autowired
//    @Qualifier("primaryDataSource")
//    private DataSource dataSource;
//    
//    @PersistenceContext
//    private EntityManager entityManager;
    
    @Autowired
    @Qualifier("ventaTotalizadoDto")
    private PtrPropertiesDto ventaTotalizadoDto;
    
    private static final String INSERT = "INSERT INTO DESARROLLO_RRHH.INCOME_TRABAJO_TIENDA_SECCION_VENTA (FECHA, ID_SECCION, ID_TIENDA, IMPORTE, ID_TRABAJO )" + 
            "VALUES(?, ?, ?, ? , ?)";

    @Override
    public List<TrabajoTiendaSeccionVenta> save(List<TrabajoTiendaSeccionVenta> src) throws Exception{
        return saveJdbcBatchList(src, INSERT, ventaTotalizadoDto.getFilter().getMaxBatchSize());
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TrabajoTiendaSeccionVenta entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getIdSeccion());
        pstmt.setString(3, entity.getIdTienda());
        pstmt.setDouble(4, entity.getImporte());
        pstmt.setLong(5, entity.getTrabajo().getId());
    }
    
//    @Override
//    public List<TrabajoTiendaSeccionVenta> saveJpaBatch(List<TrabajoTiendaSeccionVenta> src) throws Exception{
//        
//        Iterator<TrabajoTiendaSeccionVenta> iterator = src.iterator();
//        int cont = 0;
//        while (iterator.hasNext()) {
//            entityManager.persist(iterator.next());
//            cont++;
//            if (cont % BATCH_SIZE == 0) {
//                entityManager.flush();
//                entityManager.clear();
//            }
//        }
//        
//        return src;
//        
//    }
    
    
//  @Override
//  public List<TrabajoTiendaSeccionVenta> saveJdbcTemplate(List<TrabajoTiendaSeccionVenta> src) throws Exception{
//      
//      final AtomicInteger counter = new AtomicInteger(0);
//      for (List<TrabajoTiendaSeccionVenta> iter : src.stream()
//              .collect(Collectors.groupingBy(
//                      item -> counter.getAndIncrement() / BATCH_SIZE))
//              .values()) {
//          
//          System.out.println("METODO SAVE - - - ");
//          jdbcTemplate.batchUpdate(INSERT, new BatchPreparedStatementSetter() {
//              
//              @Override
//              public void setValues(PreparedStatement ps, int i) throws SQLException {
//                  ps.setObject(1, iter.get(i).getFecha());
//                  ps.setString(2, iter.get(i).getIdSeccion());
//                  ps.setString(3, iter.get(i).getIdTienda());
//                  ps.setDouble(4, iter.get(i).getImporte());
//                  ps.setLong(5, iter.get(i).getTrabajo().getId());
//              }
//              
//              @Override
//              public int getBatchSize() {
//                  return iter.size();
//              }
//          });
//          
//      }
//      
//      return src;
//  }
//

}
