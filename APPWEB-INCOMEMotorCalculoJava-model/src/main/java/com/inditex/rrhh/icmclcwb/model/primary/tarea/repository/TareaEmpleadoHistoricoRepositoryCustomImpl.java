package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaEmpleadoHistorico;

@Repository
public class TareaEmpleadoHistoricoRepositoryCustomImpl 
    extends JdbcBatchPrimaryRepositoryAbstract<TareaEmpleadoHistorico> implements TareaEmpleadoHistoricoRepositoryCustom {

    @Autowired
    @Qualifier("meta4Properties")
    private Map<String, Meta4PropertiesDto> meta4Properties;
    
    @Value("#{primaryQuery['TareaEmpleadoHistoricoRepositoryCustom.save']}")
    private String sqlSave;
    
    @Override
    public List<TareaEmpleadoHistorico> save(final List<TareaEmpleadoHistorico> src) {
        return saveJdbcBatchList(src, sqlSave, meta4Properties.get(Meta4Constants.SEARCH_EMPLEADOS).getFilter().getMaxBatchSize());
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaEmpleadoHistorico entity) throws SQLException {
        pstmt.setObject(1, entity.getFechaFin());
        pstmt.setObject(2, entity.getFechaInicio());
        pstmt.setString(3, entity.getIdEmpleado());
        pstmt.setString(4, entity.getIdEmpleadoLocal());
        pstmt.setString(5, entity.getIdTienda());
        pstmt.setString(6, entity.getIdTiendaMeta4());
        pstmt.setString(7, entity.getOrEmpleado());
        pstmt.setLong(8, entity.getTarea().getId());        
    }

}
