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
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoTiendaHistorico;

@Repository
public class ProcesoTiendaHistoricoRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<ProcesoTiendaHistorico>
        implements ProcesoTiendaHistoricoRepositoryCustom {

    @Autowired
    @Qualifier("searchTiendasDto")
    private Meta4PropertiesDto searchTiendasDto;

    @Value("#{primaryQuery['ProcesoTiendaHistoricoRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<ProcesoTiendaHistorico> save(final List<ProcesoTiendaHistorico> src) {
        return saveJdbcBatchList(src, sqlSave, searchTiendasDto.getFilter().getMaxBatchSize());
    }

    @Override
    public void setParameters(PreparedStatement pstmt, ProcesoTiendaHistorico entity) throws SQLException {
        pstmt.setObject(1, entity.getFechaFin());
        pstmt.setObject(2, entity.getFechaInicio());
        pstmt.setBoolean(3, entity.getComisionable());
        pstmt.setString(4, entity.getIdCadena());
        pstmt.setString(5, entity.getIdEmpresa());
        pstmt.setString(6, entity.getIdPais());
        pstmt.setString(7, entity.getIdPaisOrigen());
        pstmt.setString(8, entity.getIdTienda());
        pstmt.setString(9, entity.getIdTiendaMeta4());
        pstmt.setLong(10, entity.getProceso().getId());
    }

}
