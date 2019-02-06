package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoEmpleadoEstructura;

@Repository
public class TrabajoEmpleadoEstructuraRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TrabajoEmpleadoEstructura>
        implements TrabajoEmpleadoEstructuraRepositoryCustom {

    @Autowired
    @Qualifier("getComisionEmpleadoDto")
    private Meta4PropertiesDto getComisionEmpleadoDto;

    @Value("#{primaryQuery['TrabajoEmpleadoEstructuraRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TrabajoEmpleadoEstructura> save(final List<TrabajoEmpleadoEstructura> src) throws Exception {
        return saveJdbcBatchList(src, sqlSave, getComisionEmpleadoDto.getFilter().getMaxBatchSize());
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TrabajoEmpleadoEstructura entity) throws SQLException {
        pstmt.setObject(1, entity.getFechaFin());
        pstmt.setObject(2, entity.getFechaInicio());
        pstmt.setString(3, entity.getIdEmpleado());
        pstmt.setString(4, entity.getIdEmpleadoLocal());
        pstmt.setLong(5, entity.getIdEstructura());
        pstmt.setLong(6, entity.getIdTipoCalculo());
        pstmt.setLong(7, entity.getIdTipoComision());
        pstmt.setString(8, entity.getOrEmpleado());
        pstmt.setDouble(9, entity.getPorcentaje());
        pstmt.setDouble(10, entity.getPorcentaje1());
        pstmt.setDouble(11, entity.getPorcentaje2());
        pstmt.setDouble(12, entity.getPorcentaje3());
        pstmt.setLong(13, entity.getTrabajo().getId());
    }

}
