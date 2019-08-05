package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructura;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Repository
public class TareaPersonaEstructuraRepositoryCustomImpl extends
        JdbcBatchPrimaryRepositoryAbstract<TareaPersonaEstructura> implements TareaPersonaEstructuraRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-persona-estructura:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaPersonaEstructuraRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaPersonaEstructura> save(List<TareaPersonaEstructura> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaPersonaEstructura entity) throws SQLException {
        pstmt.setObject(1, entity.getFechaFin());
        pstmt.setObject(2, entity.getFechaInicio());
        pstmt.setString(3, entity.getCclIdSeccionEfectiva());
        pstmt.setString(4, entity.getCclIdSeccionEstructura());
        pstmt.setString(5, entity.getStdIdHr());
        pstmt.setString(6, entity.getCclIdPerson());
        pstmt.setString(7, entity.getIcmIdEstrComision());
        pstmt.setString(8, entity.getIcmIdTpCalculo());
        pstmt.setString(9, entity.getIcmIdTpComision());
        pstmt.setString(10, entity.getStdOrHrPeriod());
        pstmt.setBigDecimal(11, entity.getValor());
        pstmt.setLong(12, entity.getTarea().getId());
        pstmt.setString(13, entity.getCclIdOrigen());
        //TODO COMENTARIO_DESPLAZAMIENTO descomentar para continuar el desarrollo de desplazamientos
//        pstmt.setBoolean(14, entity.getDesplazamiento());
//        if (entity.getOrdinalEstructura() != null) {
//            pstmt.setInt(15, entity.getOrdinalEstructura());
//        } else {
//            pstmt.setNull(15, Types.INTEGER);
//        }
    }

}
