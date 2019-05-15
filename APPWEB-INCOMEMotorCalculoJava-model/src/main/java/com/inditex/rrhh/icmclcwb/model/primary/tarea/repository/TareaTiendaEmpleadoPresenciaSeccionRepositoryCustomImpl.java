package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaEmpleadoPresenciaSeccion;

@Repository
public class TareaTiendaEmpleadoPresenciaSeccionRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaTiendaEmpleadoPresenciaSeccion>
        implements TareaTiendaEmpleadoPresenciaSeccionRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-tienda-empleado-presencia-seccion:${app.envars.repository.batch-size.default}}")
    private int batchSize;
    
    @Value("#{primaryQuery['TareaTiendaEmpleadoPresenciaSeccionRepositoryCustom.save']}")
    private String sqlSave;
    
    @Override
    public List<TareaTiendaEmpleadoPresenciaSeccion> save(final List<TareaTiendaEmpleadoPresenciaSeccion> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }
    
    @Override
    public void setParameters(PreparedStatement pstmt, TareaTiendaEmpleadoPresenciaSeccion entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getIdEmpleado());
        pstmt.setString(3, entity.getIdTienda());
        pstmt.setString(4, entity.getIdTipoHora());
        pstmt.setLong(5, entity.getMinutos1() != null ? entity.getMinutos1() : NumberUtils.LONG_ZERO);
        pstmt.setLong(6, entity.getMinutos2() != null ? entity.getMinutos2() : NumberUtils.LONG_ZERO);
        pstmt.setLong(7, entity.getMinutos3() != null ? entity.getMinutos3() : NumberUtils.LONG_ZERO);
        pstmt.setLong(8, entity.getTipoMinutosPresencia().getId());
        pstmt.setBoolean(9, entity.getActivo());
        pstmt.setLong(10, entity.getTarea().getId());
    }

}
