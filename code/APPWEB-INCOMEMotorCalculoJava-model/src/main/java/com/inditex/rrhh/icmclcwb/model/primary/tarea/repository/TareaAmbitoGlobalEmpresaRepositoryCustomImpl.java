package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalEmpresa;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TareaAmbitoGlobalEmpresaRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaAmbitoGlobalEmpresa>
    implements TareaAmbitoGlobalEmpresaRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-ambito-global-empresa:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaAmbitoGlobalEmpresaRepositoryCustom.save']}")
  private String sqlSave;

  @Value("#{primaryQuery['TareaAmbitoGlobalEmpresaRepositoryCustom.findIdEmpresaByIdTarea']}")
  private String sqlFindIdEmpresaByIdTarea;

  @Override
  public List<TareaAmbitoGlobalEmpresa> save(
      final List<TareaAmbitoGlobalEmpresa> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

  @Override
  public List<IdEmpresaDto> findIdEmpresaByIdTarea(@NotNull @Positive final Long idTarea) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    return this.query(this.sqlFindIdEmpresaByIdTarea, parameters, (rs, rowNum) -> {
      final IdEmpresaDto dto = new IdEmpresaDto();
      dto.setStdIdLegEnt(rs.getString(SqlPrimaryConstants.SQL_RESULT_EMPRESA));
      return dto;
    });
  }

}
