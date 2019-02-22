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
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoEmpleadoEstado;

@Repository
public class ProcesoEmpleadoEstadoRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<ProcesoEmpleadoEstado>
        implements ProcesoEmpleadoEstadoRepositoryCustom {

    @Autowired
    @Qualifier("searchEmpleadosDto")
    private Meta4PropertiesDto searchEmpleadosDto;

    @Value("#{primaryQuery['ProcesoEmpleadoEstadoRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<ProcesoEmpleadoEstado> save(final List<ProcesoEmpleadoEstado> src) {
        return saveJdbcBatchList(src, sqlSave, searchEmpleadosDto.getFilter().getMaxBatchSize());
    }

    @Override
    public void setParameters(PreparedStatement pstmt, ProcesoEmpleadoEstado entity) throws SQLException {
        pstmt.setString(1, entity.getIdEmpleado());
        pstmt.setString(2, entity.getIdEmpleadoLocal());
        pstmt.setString(3, entity.getOrEmpleado());
        pstmt.setLong(4, entity.getEstado().getId());
        pstmt.setLong(5, entity.getProceso().getId());
    }

}
