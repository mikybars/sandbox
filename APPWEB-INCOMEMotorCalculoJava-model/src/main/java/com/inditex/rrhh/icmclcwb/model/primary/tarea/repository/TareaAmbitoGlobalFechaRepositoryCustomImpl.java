package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalFecha;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TareaAmbitoGlobalFechaRepositoryCustomImpl extends
    JdbcBatchPrimaryRepositoryAbstract<TareaAmbitoGlobalFecha> implements TareaAmbitoGlobalFechaRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-ambito-global-fecha:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaAmbitoGlobalFechaRepositoryCustom.save']}")
  private String sqlSave;

  @Value("#{primaryQuery['TareaAmbitoGlobalFechaRepositoryCustom.findFechaAmbitoDtoByIdTareaAndIdTipoDato']}")
  private String sqlFindFechaAmbitoDtoByIdTareaAndIdTipoDato;

  @Override
  public List<TareaAmbitoGlobalFecha> save(
      final List<TareaAmbitoGlobalFecha> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

  @Override
  public PeriodoDto findFechaAmbitoDtoByIdTareaAndIdTipoDato(@NotNull @Positive final Long idTarea,
      @NotNull final Integer idTipoDato) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO, idTipoDato);

    return this.queryForObject(this.sqlFindFechaAmbitoDtoByIdTareaAndIdTipoDato, parameters,
        (rs, rowNum) -> {
          final PeriodoDto dto = new PeriodoDto();
          dto.setFechaInicioPeriodo(
              rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_INICIO).toLocalDate());
          dto.setFechaFinPeriodo(
              rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_FIN).toLocalDate());
          return dto;
        });
  }

}
