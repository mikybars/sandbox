package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraDesplazamiento;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TareaPersonaEstructuraDesplazamientoRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaPersonaEstructuraDesplazamiento>
    implements TareaPersonaEstructuraDesplazamientoRepositoryCustom{

    @Value("${app.envars.repository.batch-size.tarea-persona-estructura-desplazamiento:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaPersonaEstructuraDesplazamientoRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaPersonaEstructuraDesplazamiento> save(List<TareaPersonaEstructuraDesplazamiento> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaPersonaEstructuraDesplazamiento entity) throws SQLException {
        pstmt.setLong(1, entity.getTarea().getId());
        pstmt.setString(2, entity.getIcmIdEstrComision());
        pstmt.setInt(3, entity.getOrdinalEstructura());
        pstmt.setObject(4, entity.getFechaInicio());
        pstmt.setObject(5, entity.getFechaFin());
        pstmt.setInt(6, entity.getTipoOpcionCalculoEstructura().getId());
        pstmt.setInt(7, entity.getTipoOpcionCalculoEfectiva().getId());
        pstmt.setString(8, entity.getIcmIdTpCalculo());
        pstmt.setString(9, entity.getCclIdPuestoDestino());
        pstmt.setString(10, entity.getCclIdSeccionDestino());
        pstmt.setString(11, entity.getCclIdCodOrigenDestino());
        pstmt.setBigDecimal(12, entity.getValor());
        pstmt.setString(13, entity.getCclIdSeccionEfectiva());
        pstmt.setString(14, entity.getCclIdSeccionEstructura());
        pstmt.setString(15, entity.getStdIdWorkLocatDestino());
    }
}
