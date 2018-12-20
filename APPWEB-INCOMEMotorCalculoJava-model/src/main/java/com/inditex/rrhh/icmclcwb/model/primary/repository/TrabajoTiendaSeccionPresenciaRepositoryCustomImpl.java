package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaSeccionPresencia;


@Repository
public class TrabajoTiendaSeccionPresenciaRepositoryCustomImpl extends JdbcBatchRepository<TrabajoTiendaSeccionPresencia>
        implements TrabajoTiendaSeccionPresenciaRepositoryCustom {
    
    @Autowired
    @Qualifier("presenciasTotalTiendaSeccionDto")
    private PtrPropertiesDto presenciasTotalTiendaSeccionDto;
    
    private static final String INSERT = "INSERT INTO DESARROLLO_RRHH.INCOME_TRABAJO_TIENDA_SECCION_PRESENCIA (FECHA, ID_SECCION, ID_TIENDA, MINUTOS, ID_TRABAJO )" + 
            "VALUES(?, ?, ?, ? , ?)";
    
    @Override
    public List<TrabajoTiendaSeccionPresencia> save(final List<TrabajoTiendaSeccionPresencia> src) throws Exception{
        return saveJdbcBatchList(src, INSERT, presenciasTotalTiendaSeccionDto.getFilter().getMaxBatchSize());
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
