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
        pstmt.setString(8, entity.getIcmIdEstrComisionBase());
        pstmt.setString(9, entity.getIcmIdTpCalculo());
        pstmt.setString(10, entity.getIcmIdTpComision());
        pstmt.setString(11, entity.getStdOrHrPeriod());
        pstmt.setBigDecimal(12, entity.getValor());
        pstmt.setLong(13, entity.getTarea().getId());
        pstmt.setBoolean(14, entity.getActivo());
        pstmt.setString(15, entity.getCclIdOrigen());
        pstmt.setBoolean(16, entity.getDesplazamiento());
        pstmt.setBoolean(17, entity.getDesplazamientoBase());
        if (entity.getOrdinalEstructura() != null) {
            pstmt.setInt(18, entity.getOrdinalEstructura());
        } else {
            pstmt.setNull(18, Types.INTEGER);
        }
        pstmt.setString(19, entity.getIdTipoVenta());
        pstmt.setInt(20, entity.getTope());
        pstmt.setBoolean(21, entity.getDiaD());
        pstmt.setBoolean(22, entity.getDiaJ());
        pstmt.setBoolean(23, entity.getDiaL());
        pstmt.setBoolean(24, entity.getDiaM());
        pstmt.setBoolean(25, entity.getDiaS());
        pstmt.setBoolean(26, entity.getDiaV());
        pstmt.setBoolean(27, entity.getDiaX());
        pstmt.setString(28, entity.getIcmIdTpEstructura());
        pstmt.setString(29, entity.getIcmIdEstrComisionPadre());
        pstmt.setObject(30, entity.getPk().getFechaInicioPeriodo());
    }

}
