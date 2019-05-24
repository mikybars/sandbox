package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaEmpleadoSeccionPresencia;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TareaTiendaEmpleadoSeccionPresenciaRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaTiendaEmpleadoSeccionPresencia>
    implements TareaTiendaEmpleadoSeccionPresenciaRepositoryCustom{

    @Value("${app.envars.repository.batch-size.tarea-tienda-empleado-seccion-presencia:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaTiendaEmpleadoSeccionPresenciaRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaTiendaEmpleadoSeccionPresencia> save(List<TareaTiendaEmpleadoSeccionPresencia> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaTiendaEmpleadoSeccionPresencia entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getIdEmpleado());
        pstmt.setString(3, entity.getIdTienda());
        pstmt.setString(4, entity.getIdSeccion());
        pstmt.setString(5, entity.getIdTipoHora());
        pstmt.setDouble(6, entity.getMinutos());
        pstmt.setLong(7, entity.getTipoDato().getId());
        pstmt.setBoolean(8, entity.getActivo());
        pstmt.setLong(9, entity.getTarea().getId());
    }
}
