package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaSeccionPresencia;


@Repository
public class TareaTiendaSeccionPresenciaRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaTiendaSeccionPresencia>
        implements TareaTiendaSeccionPresenciaRepositoryCustom {
    
    @Autowired
    @Qualifier("presenciasProperties")
    private Map<String, PtrPropertiesDto> presenciasProperties;
    
    @Autowired
    @Qualifier("primaryQuery")
    private Properties query;
    
    @Override
    public List<TareaTiendaSeccionPresencia> save(final List<TareaTiendaSeccionPresencia> src) {
        return saveJdbcBatchList(src, query.getProperty("TareaTiendaSeccionPresenciaRepositoryCustom.save"), presenciasProperties.get(PtrConstants.PRESENCIA_TOTAL_TIENDA_SECCION).getFilter().getMaxBatchSize());
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaTiendaSeccionPresencia entity) throws SQLException {
      pstmt.setObject(1, entity.getFecha());
      pstmt.setString(2, entity.getIdSeccion());
      pstmt.setString(3, entity.getIdTienda());
      pstmt.setDouble(4, entity.getMinutos());
      pstmt.setLong(5, entity.getTarea().getId());
    }

}
