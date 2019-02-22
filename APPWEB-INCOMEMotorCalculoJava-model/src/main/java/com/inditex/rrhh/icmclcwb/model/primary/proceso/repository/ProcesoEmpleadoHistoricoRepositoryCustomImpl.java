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
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoEmpleadoHistorico;

@Repository
public class ProcesoEmpleadoHistoricoRepositoryCustomImpl 
    extends JdbcBatchPrimaryRepositoryAbstract<ProcesoEmpleadoHistorico> implements ProcesoEmpleadoHistoricoRepositoryCustom {

    @Autowired
    @Qualifier("searchEmpleadosDto")
    private Meta4PropertiesDto searchEmpleadosDto;
    
    @Value("#{primaryQuery['ProcesoEmpleadoHistoricoRepositoryCustom.save']}")
    private String sqlSave;
    
    @Override
    public List<ProcesoEmpleadoHistorico> save(final List<ProcesoEmpleadoHistorico> src) {
        return saveJdbcBatchList(src, sqlSave, searchEmpleadosDto.getFilter().getMaxBatchSize());
    }

    @Override
    public void setParameters(PreparedStatement pstmt, ProcesoEmpleadoHistorico entity) throws SQLException {
        pstmt.setObject(1, entity.getFechaFin());
        pstmt.setObject(2, entity.getFechaInicio());
        pstmt.setString(3, entity.getIdEmpleado());
        pstmt.setString(4, entity.getIdEmpleadoLocal());
        pstmt.setString(5, entity.getIdTienda());
        pstmt.setString(6, entity.getIdTiendaMeta4());
        pstmt.setString(7, entity.getOrEmpleado());
        pstmt.setLong(8, entity.getProceso().getId());        
    }

}
