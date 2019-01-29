package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleadoHistorico;

@Repository
public class TrabajoEmpleadoHistoricoRepositoryCustomImpl 
    extends JdbcBatchRepository<TrabajoEmpleadoHistorico> implements TrabajoEmpleadoHistoricoRepositoryCustom {

    @Autowired
    @Qualifier("searchEmpleadosDto")
    private Meta4PropertiesDto searchEmpleadosDto;
    
    private static final String INSERT = "INSERT INTO DESARROLLO_RRHH.TRABAJO_EMPLEADO_HISTORICO ( "
            + "FECHA_FIN, FECHA_INICIO, ID_EMPLEADO, "
            + "ID_EMPLEADO_LOCAL, CCL_ID_COD_ORIGEN, "  
            + "STD_ID_WORK_LOCAT, OR_EMPLEADO, ID_TRABAJO)" 
            + "VALUES(?, ?, ?, ? , ?, ?, ? , ?)";
    
    @Override
    public List<TrabajoEmpleadoHistorico> save(final List<TrabajoEmpleadoHistorico> src) throws Exception{
        return saveJdbcBatchList(src, INSERT, searchEmpleadosDto.getFilter().getMaxBatchSize());
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TrabajoEmpleadoHistorico entity) throws SQLException {
        pstmt.setObject(1, entity.getFechaFin());
        pstmt.setObject(2, entity.getFechaInicio());
        pstmt.setString(3, entity.getIdEmpleado());
        pstmt.setString(4, entity.getIdEmpleadoLocal());
        pstmt.setString(5, entity.getIdTienda());
        pstmt.setString(6, entity.getIdTiendaMeta4());
        pstmt.setString(7, entity.getOrEmpleado());
        pstmt.setLong(8, entity.getTrabajo().getId());        
    }

}
