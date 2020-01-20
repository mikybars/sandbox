package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionOperacionPersona;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TareaLocalizacionOperacionPersonaRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionOperacionPersona>
    implements TareaLocalizacionOperacionPersonaRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-localizacion-online-historico:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaLocalizacionOperacionPersonaRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaLocalizacionOperacionPersona> save(List<TareaLocalizacionOperacionPersona> operaciones) {
        return saveJdbcBatchList(operaciones, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionOperacionPersona entity) throws SQLException {
        pstmt.setObject(1, entity.getPk().getFechaInicioPeriodo());
        pstmt.setLong(2, entity.getTarea().getId());
        pstmt.setString(3, entity.getCclIdPerson());
        pstmt.setString(4, entity.getCclIdCodOrigen());
        pstmt.setString(5, entity.getCclIdCadena());
        pstmt.setString(6, entity.getCclIdSeccion());
        pstmt.setDouble(7, entity.getImporteSinImpuestos());
        pstmt.setDouble(8, entity.getImporteConImpuestos());
        pstmt.setBoolean(9, entity.getActivo());
        pstmt.setInt(10, entity.getTipoDato().getId());
        pstmt.setObject(11, entity.getFecha());
    }
}
