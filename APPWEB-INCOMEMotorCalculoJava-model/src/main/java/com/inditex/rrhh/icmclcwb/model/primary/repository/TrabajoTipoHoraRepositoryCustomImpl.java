package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTipoHora;

@Repository
public class TrabajoTipoHoraRepositoryCustomImpl extends JdbcBatchRepository<TrabajoTipoHora>
        implements TrabajoTipoHoraRepositoryCustom {

    @Autowired
    @Qualifier("tiposHorasDto")
    private PtrPropertiesDto tiposHorasDto;

    @Value("#{primaryQuery['TrabajoTipoHoraRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TrabajoTipoHora> save(List<TrabajoTipoHora> src) throws Exception {
        return saveJdbcBatchList(src, sqlSave, tiposHorasDto.getFilter().getMaxBatchSize());
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TrabajoTipoHora entity) throws SQLException {
        pstmt.setObject(1, entity.getComisionable());
        pstmt.setString(2, entity.getIdTipoHora());
        pstmt.setLong(3, entity.getTrabajo().getId());
    }

}
