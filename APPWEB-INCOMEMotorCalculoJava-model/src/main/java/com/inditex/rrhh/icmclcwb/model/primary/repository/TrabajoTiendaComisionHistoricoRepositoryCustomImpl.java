package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaComisionHistorico;

@Repository
public class TrabajoTiendaComisionHistoricoRepositoryCustomImpl extends
        JdbcBatchRepository<TrabajoTiendaComisionHistorico> implements TrabajoTiendaComisionHistoricoRepositoryCustom {

    @Autowired
    @Qualifier("getTiendasDto")
    private Meta4PropertiesDto getTiendasDto;
    
    private static final String INSERT = "INSERT INTO DESARROLLO_RRHH.TRABAJO_TIENDA_COMISION_HISTORICO ( "
            + "FECHA_FIN, FECHA_INICIO, COMISIONABLE, "
            + "CCL_ID_COD_ORIGEN, STD_ID_WORK_LOCAT, ID_TRABAJO)" 
            + "VALUES(?, ?, ?, ?, ?, ?)";
    
    @Override
    public List<TrabajoTiendaComisionHistorico> save(final List<TrabajoTiendaComisionHistorico> src) throws Exception{
        return saveJdbcBatchList(src, INSERT, getTiendasDto.getFilter().getMaxBatchSize());
    }
    
    @Override
    public void setParameters(PreparedStatement pstmt, TrabajoTiendaComisionHistorico entity) throws SQLException {
        pstmt.setObject(1, entity.getFechaFin());
        pstmt.setObject(2, entity.getFechaInicio());
        pstmt.setBoolean(3, entity.getComisionable());
        pstmt.setString(4, entity.getIdTienda());
        pstmt.setString(5, entity.getIdTiendaMeta4());
        pstmt.setLong(6, entity.getTrabajo().getId());
    }

}
