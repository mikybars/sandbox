package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionConfiguracionChallengeTipoVenta;

@Repository
public class TareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaAgrupacionConfiguracionChallengeTipoVenta>
        implements TareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-agrupacion-configuracion-challenge-tipo-venta:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaAgrupacionConfiguracionChallengeTipoVenta> save(
            List<TareaAgrupacionConfiguracionChallengeTipoVenta> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaAgrupacionConfiguracionChallengeTipoVenta entity)
            throws SQLException {
        pstmt.setLong(1, entity.getTarea().getId());
        pstmt.setLong(2, entity.getIcmIdAgrupacionOnline());
        pstmt.setLong(3, entity.getTipoVentaConceptoChallenge().getId());
        pstmt.setObject(4, entity.getFechaInicio());
        pstmt.setObject(5, entity.getFechaFin());
        pstmt.setString(6, entity.getCclIdOrigen());
    }

}
