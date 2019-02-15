package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoTiendaSeccionEmpleadoPresencia;

@Repository
public class TrabajoTiendaSeccionEmpleadoPresenciaRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TrabajoTiendaSeccionEmpleadoPresencia>
        implements TrabajoTiendaSeccionEmpleadoPresenciaRepositoryCustom {

    @Autowired
    @Qualifier("presenciasProperties")
    private Map<String, PtrPropertiesDto> presenciasProperties;

    @Value("#{primaryQuery['TrabajoTiendaSeccionEmpleadoPresenciaRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TrabajoTiendaSeccionEmpleadoPresencia> save(final List<TrabajoTiendaSeccionEmpleadoPresencia> src) {
        return saveJdbcBatchList(src, sqlSave, presenciasProperties.get(PtrConstants.PRESENCIA_DETALLE).getFilter().getMaxBatchSize());
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
