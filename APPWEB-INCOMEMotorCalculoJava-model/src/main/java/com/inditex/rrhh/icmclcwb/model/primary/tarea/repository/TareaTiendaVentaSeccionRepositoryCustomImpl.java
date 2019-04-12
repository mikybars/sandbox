package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaVentaSeccion;

@Deprecated
@Repository
public class TareaTiendaVentaSeccionRepositoryCustomImpl extends
        JdbcBatchPrimaryRepositoryAbstract<TareaTiendaVentaSeccion> implements TareaTiendaVentaSeccionRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-tienda-venta-seccion:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaTiendaVentaSeccionRepositoryCustom.save']}")
    private String sqlSave;

    @Auditoria
    @Override
    public void save(@NotNull final TareaDto tareaDto) {
    }

    @Override
    public List<TareaTiendaVentaSeccion> save(List<TareaTiendaVentaSeccion> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaTiendaVentaSeccion entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getIdTienda());
        pstmt.setDouble(3, entity.getImporte1() != null ? entity.getImporte1() : 0);
        pstmt.setDouble(4, entity.getImporte2() != null ? entity.getImporte2() : 0);
        pstmt.setDouble(5, entity.getImporte3() != null ? entity.getImporte3() : 0);
        pstmt.setDouble(6, entity.getTipoImporteVenta().getId());
        pstmt.setLong(7, entity.getTarea().getId());
    }

}
