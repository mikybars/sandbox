package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaEmpleadoSeccionEstructura;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TareaEmpleadoSeccionEstructuraRepositoryCustomImpl extends
    JdbcBatchPrimaryRepositoryAbstract<TareaEmpleadoSeccionEstructura>
    implements TareaEmpleadoSeccionEstructuraRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-empleado-seccion-estructura:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaEmpleadoSeccionEstructuraRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaEmpleadoSeccionEstructura> save(List<TareaEmpleadoSeccionEstructura> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaEmpleadoSeccionEstructura entity) throws SQLException {
        pstmt.setObject(1, entity.getFechaFin());
        pstmt.setObject(2, entity.getFechaInicio());
        pstmt.setString(3, entity.getIdSeccionEfectiva());
        pstmt.setString(4, entity.getIdSeccionEstructura());
        pstmt.setString(5, entity.getIdEmpleado());
        pstmt.setString(6, entity.getIdEmpleadoLocal());
        pstmt.setString(7, entity.getIdEstructura());
        pstmt.setString(8, entity.getIdTipoCalculo());
        pstmt.setString(9, entity.getIdTipoComision());
        pstmt.setString(10, entity.getOrEmpleado());
        pstmt.setDouble(11, entity.getValor());
        pstmt.setLong(12, entity.getTarea().getId());
        pstmt.setString(13, entity.getIdOrigen());
    }
}
