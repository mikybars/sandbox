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
        pstmt.setString(8, entity.getCclIdPuestoDestino());
        pstmt.setString(9, entity.getCclIdSeccionDestino());
        pstmt.setString(10, entity.getCclIdCodOrigenDestino());
        pstmt.setString(11, entity.getStdIdWorkLocatDestino());
        pstmt.setBoolean(12, entity.getHorasOrigen());
        pstmt.setBoolean(13, entity.getHorasDestino());
        pstmt.setString(14, entity.getIcmIdTpReqCom());
        pstmt.setBoolean(15, entity.getActivo());
        pstmt.setString(16, entity.getCclIdOrigen());
        pstmt.setString(17, entity.getCclIdPerson());
        pstmt.setString(18, entity.getIcmIdEstrComisionPadre());
        pstmt.setString(19, entity.getIcmIdEstrComisionBase());
        pstmt.setString(20, entity.getStdIdHr());
        pstmt.setString(21, entity.getStdOrHrPeriod());
        pstmt.setString(22, entity.getIcmIdEstructuraAmbito());
    }
}
