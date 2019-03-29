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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaOperacionPersonaLocalizacionVenta;

@Repository
public class TareaOperacionPersonaLocalizacionVentaRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaOperacionPersonaLocalizacionVenta>
        implements TareaOperacionPersonaLocalizacionVentaRepositoryCustom {

    @Autowired
    @Qualifier("ventaGeneralProperties")
    protected Map<String, PtrPropertiesDto> ventaGeneralProperties;
    
    @Value("#{primaryQuery['TareaOperacionPersonaLocalizacionVentaRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaOperacionPersonaLocalizacionVenta> save(List<TareaOperacionPersonaLocalizacionVenta> src) {
        return saveJdbcBatchList(src, sqlSave, ventaGeneralProperties.get(PtrConstants.VENTA_TOTALIZADO).getFilter().getMaxBatchSize());
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaOperacionPersonaLocalizacionVenta entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getIdLocalizacion());
        pstmt.setString(3, entity.getIdOperacion());
        pstmt.setString(4, entity.getIdPersona());
        pstmt.setDouble(5, entity.getImporte());
        pstmt.setDouble(6, entity.getTipoImporteVenta().getId());
        pstmt.setLong(7, entity.getTarea().getId());
    }

}
