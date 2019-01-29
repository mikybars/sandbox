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

    @Autowired
    @Qualifier("ventaTotalizadoDto")
    private PtrPropertiesDto ventaTotalizadoDto;
    
    private static final String INSERT = "INSERT INTO DESARROLLO_RRHH.TRABAJO_TIENDA_SECCION_VENTA (FECHA, ID_SECCION, ID_TIENDA, IMPORTE, ID_TRABAJO )" + 
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
    
}
