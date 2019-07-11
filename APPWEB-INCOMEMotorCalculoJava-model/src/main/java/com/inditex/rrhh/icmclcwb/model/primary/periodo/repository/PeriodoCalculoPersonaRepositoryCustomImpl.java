package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.entity.PeriodoCalculoPersona;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;

@Repository
public class PeriodoCalculoPersonaRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<PeriodoCalculoPersona>
        implements PeriodoCalculoPersonaRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("${app.envars.repository.batch-size.periodo-calculo-persona:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['PeriodoCalculoPersonaRepositoryCustom.save']}")
    private String sqlSave;

    @Value("#{primaryQuery['PeriodoCalculoPersonaRepositoryCustom.mergePeriodoCalculoPersona']}")
    private String sqlMergePeriodoCalculoPersona;

    @Override
    public List<PeriodoCalculoPersona> save(List<PeriodoCalculoPersona> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void mergePeriodoCalculoPersona(@NotNull RunTareaDto tareaDto) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getTarea().getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_PERIODO_PERSONA,
                /* TODO Cambiar por un flag o definir los estados posibles */2L);
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_TAREA_PERSONA,
                EstadoTareaCalculoPersonaEnum.OK.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA, TimeUtils.nowDate());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_BLOQUEADO, 0);
        namedParameterJdbcTemplate.update(sqlMergePeriodoCalculoPersona, params);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, PeriodoCalculoPersona entity) throws SQLException {
        pstmt.setLong(1, entity.getPk().getIdPeriodo());
        pstmt.setString(2, entity.getPk().getIdOrigen());
        pstmt.setString(3, entity.getPk().getIdEmpresa());
        pstmt.setString(4, entity.getPk().getIdPersona());
        pstmt.setString(5, entity.getPk().getOrPersona());
        pstmt.setLong(6, entity.getTareaActual().getId());
        pstmt.setLong(7, entity.getTareaUltima().getId());
        pstmt.setLong(8, entity.getEstado().getId());
        pstmt.setObject(9, entity.getFechaCreacion());
        pstmt.setObject(10, entity.getFechaActualizacion());
    }

}
