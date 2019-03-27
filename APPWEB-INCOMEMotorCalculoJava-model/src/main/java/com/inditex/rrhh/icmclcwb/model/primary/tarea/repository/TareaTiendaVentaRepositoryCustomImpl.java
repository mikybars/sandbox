package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaVenta;

@Repository
public class TareaTiendaVentaRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaTiendaVenta> implements TareaTiendaVentaRepositoryCustom {

    @Autowired
    @Qualifier("ventaGeneralProperties")
    protected Map<String, PtrPropertiesDto> ventaGeneralProperties;
    
    @Value("#{primaryQuery['TareaTiendaVentaRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaTiendaVenta> save(List<TareaTiendaVenta> src) {
        return saveJdbcBatchList(src, sqlSave, ventaGeneralProperties.get(PtrConstants.VENTA_TOTALIZADO).getFilter().getMaxBatchSize());
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaTiendaVenta entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getIdTienda());
        pstmt.setDouble(3, entity.getImporte());
        pstmt.setDouble(4, entity.getTipoImporteVenta().getId());
        pstmt.setLong(5, entity.getTarea().getId());
    }

}
