package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaSeccionEmpleadoPresencia;

@Repository
public class TrabajoTiendaSeccionEmpleadoPresenciaRepositoryCustomImpl
        extends JdbcBatchRepository<TrabajoTiendaSeccionEmpleadoPresencia>
        implements TrabajoTiendaSeccionEmpleadoPresenciaRepositoryCustom {

    @Autowired
    @Qualifier("presenciasDetalleDto")
    private PtrPropertiesDto presenciasDetalleDto;
    
    private static final String INSERT = "INSERT INTO DESARROLLO_RRHH.TRABAJO_TIENDA_SECCION_EMPLEADO_PRESENCIA ( "
            + "FECHA, ID_EMPLEADO, ID_SECCION, ID_TIENDA, "
            + "ID_TIPO_HORA, MINUTOS, ID_TRABAJO)" 
            + "VALUES(?, ?, ?, ?, ?, ?, ?)";
    
    @Override
    public List<TrabajoTiendaSeccionEmpleadoPresencia> save(final List<TrabajoTiendaSeccionEmpleadoPresencia> src) throws Exception{
        return saveJdbcBatchList(src, INSERT, presenciasDetalleDto.getFilter().getMaxBatchSize());
    }
    
    @Override
    public void setParameters(PreparedStatement pstmt, TrabajoTiendaSeccionEmpleadoPresencia entity)
            throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getIdEmpleado());
        pstmt.setString(3, entity.getIdSeccion());
        pstmt.setString(4, entity.getIdTienda());
        pstmt.setString(5, entity.getIdTipoHora());
        pstmt.setLong(6, entity.getMinutos());
        pstmt.setLong(7, entity.getTrabajo().getId());
    }

}
