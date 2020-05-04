package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;

@Repository
public class TareaPersonaEstructuraRepositoryCustomImpl extends
        JdbcBatchPrimaryRepositoryAbstract<TareaPersonaEstructura> implements TareaPersonaEstructuraRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-persona-estructura:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaPersonaEstructuraRepositoryCustom.save']}")
    private String sqlSave;

    @Value("#{primaryQuery['TareaPersonaEstructuraRepositoryCustom.updateActivoTopes']}")
    private String sqlUpdateActivoTopes;

    @Value("#{primaryQuery['TareaPersonaEstructura.findPersonasChallenge']}")
    private String sqlFindPersonasChallenge;

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

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
        pstmt.setInt(19, entity.getTope());
        pstmt.setBoolean(20, entity.getDiaD());
        pstmt.setBoolean(21, entity.getDiaJ());
        pstmt.setBoolean(22, entity.getDiaL());
        pstmt.setBoolean(23, entity.getDiaM());
        pstmt.setBoolean(24, entity.getDiaS());
        pstmt.setBoolean(25, entity.getDiaV());
        pstmt.setBoolean(26, entity.getDiaX());
        pstmt.setString(27, entity.getIcmIdTpEstructura());
        pstmt.setString(28, entity.getIcmIdEstrComisionPadre());
        pstmt.setObject(29, entity.getPk().getFechaInicioPeriodo());
    }

    @Override
    public void updateActivoTopes(TareaDto tarea) {

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO,
                TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ICM_ORD_TOPE, AppConstants.TOPE_DEFAULT);
        namedParameterJdbcTemplate.update(sqlUpdateActivoTopes, map);

    }

    @Override
    public List<IdPersonaLocalDto> findPersonasChallenge(TareaDto tarea) {

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO,
                TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
        map.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO, Arrays.asList(
                TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId(),
                TipoCalculoEnum.CHALLENGE_PRECIO_HORA_SECCION.getId(),
                TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId(), TipoCalculoEnum.CHALLENGE_IMPORTE_SECCION.getId()));

        return namedParameterJdbcTemplate.query(sqlFindPersonasChallenge, map, (rs, rowNum) -> IdPersonaLocalDto
            .builder()
            .idPersonaLocal(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA_LOCAL))
            .stdOrHrPeriod(rs.getString(SqlPrimaryConstants.SQL_RESULT_OR_PERSONA))
            .build());
    }

}
