package com.inditex.rrhh.icmclcwb.model.primary.proceso.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoEmpleadoEstructura;

@Repository
public class ProcesoEmpleadoEstructuraRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<ProcesoEmpleadoEstructura>
        implements ProcesoEmpleadoEstructuraRepositoryCustom {

    @Autowired
    @Qualifier("getComisionEmpleadoDto")
    private Meta4PropertiesDto getComisionEmpleadoDto;

    @Value("#{primaryQuery['ProcesoEmpleadoEstructuraRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<ProcesoEmpleadoEstructura> save(final List<ProcesoEmpleadoEstructura> src) {
        return saveJdbcBatchList(src, sqlSave, getComisionEmpleadoDto.getFilter().getMaxBatchSize());
    }

    @Override
    public void setParameters(PreparedStatement pstmt, ProcesoEmpleadoEstructura entity) throws SQLException {
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
        pstmt.setLong(13, entity.getProceso().getId());
    }

}
