package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaHistorico;

@Repository
public class TrabajoTiendaHistoricoRepositoryCustomImpl extends JdbcBatchRepository<TrabajoTiendaHistorico>
        implements TrabajoTiendaHistoricoRepositoryCustom {

    @Autowired
    @Qualifier("searchTiendasDto")
    private Meta4PropertiesDto searchTiendasDto;

    @Value("#{primaryQuery['TrabajoTiendaHistoricoRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TrabajoTiendaHistorico> save(final List<TrabajoTiendaHistorico> src) throws Exception {
        return saveJdbcBatchList(src, sqlSave, searchTiendasDto.getFilter().getMaxBatchSize());
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TrabajoTiendaHistorico entity) throws SQLException {
        pstmt.setObject(1, entity.getFechaFin());
        pstmt.setObject(2, entity.getFechaInicio());
        pstmt.setBoolean(3, entity.getComisionable());
        pstmt.setString(4, entity.getIdCadena());
        pstmt.setString(5, entity.getIdEmpresa());
        pstmt.setString(6, entity.getIdPais());
        pstmt.setString(7, entity.getIdPaisOrigen());
        pstmt.setString(8, entity.getIdTienda());
        pstmt.setString(9, entity.getIdTiendaMeta4());
        pstmt.setLong(10, entity.getTrabajo().getId());
    }

}
