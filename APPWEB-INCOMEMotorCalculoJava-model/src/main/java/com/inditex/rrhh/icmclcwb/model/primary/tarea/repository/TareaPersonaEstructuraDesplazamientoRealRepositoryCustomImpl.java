package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.DesplazamientoRealDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraDesplazamientoReal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TareaPersonaEstructuraDesplazamientoRealRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaPersonaEstructuraDesplazamientoReal>
    implements TareaPersonaEstructuraDesplazamientoRealRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-persona-estructura-desplazamiento-real:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaPersonaEstructuraDesplazamientoRealRepositoryCustom.save']}")
  private String sqlSave;

  @Value("#{primaryQuery['TareaPersonaEstructuraDesplazamientoRealRepositoryCustom.findDesplazamientoReal']}")
  private String sqlFindDesplazamientoReal;

  @Override
  public List<TareaPersonaEstructuraDesplazamientoReal> save(
      final List<TareaPersonaEstructuraDesplazamientoReal> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

  @Override
  public List<DesplazamientoRealDto> findDesplazamientoReal(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO,
        TimeUtils.toDate(tarea.getFechaInicioPeriodo()));

    return this.query(this.sqlFindDesplazamientoReal, map,
        (rs, rowNum) -> DesplazamientoRealDto
            .builder()
            .stdIdHr(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA_META4))
            .stdOrHrPeriod(rs.getString(SqlPrimaryConstants.SQL_RESULT_OR_PERSONA))
            .cclIdOrigen(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_ORIGEN))
            .fechaInicio(rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_INICIO).toLocalDate())
            .fechaFin(rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_FIN).toLocalDate())
            .idEstructura(rs.getString(SqlPrimaryConstants.SQL_RESULT_ICM_ID_ESTR_COMISION))
            .idEstructuraBase(rs.getString(SqlPrimaryConstants.SQL_RESULT_ICM_ID_ESTR_COMISION_BASE))
            .idEstructuraPadre(rs.getString(SqlPrimaryConstants.SQL_RESULT_ICM_ID_ESTR_COMISION_PADRE))
            .idEstructuraAmbito(rs.getString(SqlPrimaryConstants.SQL_RESULT_ICM_ID_ESTRUCTURA_AMBITO))
            .build());
  }

}
