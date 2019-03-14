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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaComisionHistorico;

@Repository
public class TareaTiendaComisionHistoricoRepositoryCustomImpl extends
        JdbcBatchPrimaryRepositoryAbstract<TareaTiendaComisionHistorico> implements TareaTiendaComisionHistoricoRepositoryCustom {

    @Autowired
    @Qualifier("meta4Properties")
    private Map<String, Meta4PropertiesDto> meta4Properties;

    @Value("#{primaryQuery['TareaTiendaComisionHistoricoRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaTiendaComisionHistorico> save(final List<TareaTiendaComisionHistorico> src) {
        return saveJdbcBatchList(src, sqlSave, meta4Properties.get(Meta4Constants.TIENDAS).getFilter().getMaxBatchSize());
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaTiendaComisionHistorico entity) throws SQLException {
        pstmt.setObject(1, entity.getFechaFin());
        pstmt.setObject(2, entity.getFechaInicio());
        pstmt.setBoolean(3, entity.getComisionable());
        pstmt.setString(4, entity.getIdTienda());
        pstmt.setString(5, entity.getIdTiendaMeta4());
        pstmt.setLong(6, entity.getTarea().getId());
    }

}
