package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaEmpleadoEstructura;

@Repository
public class TareaEmpleadoEstructuraRepositoryCustomImpl extends
        JdbcBatchPrimaryRepositoryAbstract<TareaEmpleadoEstructura> implements TareaEmpleadoEstructuraRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-empleado-estructura:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaEmpleadoEstructuraRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaEmpleadoEstructura> save(final List<TareaEmpleadoEstructura> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaEmpleadoEstructura entity) throws SQLException {
        pstmt.setObject(1, entity.getFechaFin());
        pstmt.setObject(2, entity.getFechaInicio());
        pstmt.setString(3, entity.getIdEmpleado());
        pstmt.setString(4, entity.getIdEmpleadoLocal());
        pstmt.setLong(5, entity.getIdEstructura());
        pstmt.setString(6, entity.getIdTipoCalculo());
        pstmt.setString(7, entity.getIdTipoComision());
        pstmt.setString(8, entity.getOrEmpleado());
        if (entity.getPorcentaje() != null) {
            pstmt.setDouble(9, entity.getPorcentaje());
        } else {
            pstmt.setNull(9, Types.DOUBLE);
        }
        if (entity.getPorcentaje1() != null) {
            pstmt.setDouble(10, entity.getPorcentaje1());
        } else {
            pstmt.setNull(10, Types.DOUBLE);
        }
        if (entity.getPorcentaje2() != null) {
            pstmt.setDouble(11, entity.getPorcentaje2());
        } else {
            pstmt.setNull(11, Types.DOUBLE);
        }
        if (entity.getPorcentaje3() != null) {
            pstmt.setDouble(12, entity.getPorcentaje3());
        } else {
            pstmt.setNull(12, Types.DOUBLE);
        }
        pstmt.setLong(13, entity.getTarea().getId());
        pstmt.setString(14, entity.getIdOrigen());
    }

}
