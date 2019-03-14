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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaEmpleadoEstado;

@Repository
public class TareaEmpleadoEstadoRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaEmpleadoEstado>
        implements TareaEmpleadoEstadoRepositoryCustom {

    @Autowired
    @Qualifier("meta4Properties")
    private Map<String, Meta4PropertiesDto> meta4Properties;
    
    @Value("#{primaryQuery['TareaEmpleadoEstadoRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaEmpleadoEstado> save(final List<TareaEmpleadoEstado> src) {
        return saveJdbcBatchList(src, sqlSave, meta4Properties.get(Meta4Constants.SEARCH_EMPLEADOS).getFilter().getMaxBatchSize());
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaEmpleadoEstado entity) throws SQLException {
        pstmt.setString(1, entity.getIdEmpleado());
        pstmt.setString(2, entity.getIdEmpleadoLocal());
        pstmt.setString(3, entity.getOrEmpleado());
        pstmt.setLong(4, entity.getEstado().getId());
        pstmt.setLong(5, entity.getTarea().getId());
    }

}
