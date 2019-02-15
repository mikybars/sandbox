package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoTipoHora;

@Repository
public class TrabajoTipoHoraRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TrabajoTipoHora>
        implements TrabajoTipoHoraRepositoryCustom {

    @Autowired
    @Qualifier("presenciasProperties")
    private Map<String, PtrPropertiesDto> presenciasProperties;

    @Value("#{primaryQuery['TrabajoTipoHoraRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TrabajoTipoHora> save(List<TrabajoTipoHora> src) {
        return saveJdbcBatchList(src, sqlSave, presenciasProperties.get(PtrConstants.PRESENCIA_TIPOS_HORAS).getFilter().getMaxBatchSize());
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TrabajoTipoHora entity) throws SQLException {
        pstmt.setObject(1, entity.getComisionable());
        pstmt.setString(2, entity.getIdTipoHora());
        pstmt.setLong(3, entity.getTrabajo().getId());
    }

}
