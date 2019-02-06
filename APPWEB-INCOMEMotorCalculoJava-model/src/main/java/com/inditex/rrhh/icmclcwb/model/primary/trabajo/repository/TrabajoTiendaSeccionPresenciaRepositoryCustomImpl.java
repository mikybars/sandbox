package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoTiendaSeccionPresencia;


@Repository
public class TrabajoTiendaSeccionPresenciaRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TrabajoTiendaSeccionPresencia>
        implements TrabajoTiendaSeccionPresenciaRepositoryCustom {
    
    @Autowired
    @Qualifier("presenciasTotalTiendaSeccionDto")
    private PtrPropertiesDto presenciasTotalTiendaSeccionDto;
    
    @Autowired
    @Qualifier("primaryQuery")
    private Properties query;
    
    @Override
    public List<TrabajoTiendaSeccionPresencia> save(final List<TrabajoTiendaSeccionPresencia> src) throws Exception{
        return saveJdbcBatchList(src, query.getProperty("TrabajoTiendaSeccionPresenciaRepositoryCustom.save"), presenciasTotalTiendaSeccionDto.getFilter().getMaxBatchSize());
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TrabajoTiendaSeccionPresencia entity) throws SQLException {
      pstmt.setObject(1, entity.getFecha());
      pstmt.setString(2, entity.getIdSeccion());
      pstmt.setString(3, entity.getIdTienda());
      pstmt.setDouble(4, entity.getMinutos());
      pstmt.setLong(5, entity.getTrabajo().getId());
    }

}
