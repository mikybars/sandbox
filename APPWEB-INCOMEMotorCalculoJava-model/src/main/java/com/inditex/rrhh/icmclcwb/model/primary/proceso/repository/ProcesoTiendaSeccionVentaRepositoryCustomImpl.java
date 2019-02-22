package com.inditex.rrhh.icmclcwb.model.primary.proceso.repository;

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
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoTiendaSeccionVenta;

@Repository
public class ProcesoTiendaSeccionVentaRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<ProcesoTiendaSeccionVenta>
        implements ProcesoTiendaSeccionVentaRepositoryCustom {

    @Autowired
    @Qualifier("ventaGeneralProperties")
    protected Map<String, PtrPropertiesDto> ventaGeneralProperties;
    
    @Value("#{primaryQuery['ProcesoTiendaSeccionVentaRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<ProcesoTiendaSeccionVenta> save(List<ProcesoTiendaSeccionVenta> src) {
        return saveJdbcBatchList(src, sqlSave, ventaGeneralProperties.get(PtrConstants.VENTA_TOTALIZADO).getFilter().getMaxBatchSize());
    }

    @Override
    public void setParameters(PreparedStatement pstmt, ProcesoTiendaSeccionVenta entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getIdSeccion());
        pstmt.setString(3, entity.getIdTienda());
        pstmt.setDouble(4, entity.getImporte());
        pstmt.setLong(5, entity.getProceso().getId());
    }

}
