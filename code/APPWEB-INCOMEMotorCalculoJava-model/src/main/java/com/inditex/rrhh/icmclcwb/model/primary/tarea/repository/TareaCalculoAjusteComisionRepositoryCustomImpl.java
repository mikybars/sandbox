package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

/*
 * Copyright (c) 2021. Inditex
 */

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCalculoAjusteComision;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TareaCalculoAjusteComisionRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaCalculoAjusteComision>
    implements TareaCalculoAjusteComisionRepositoryCustom {

  @Value("#{primaryQuery['TareaCalculoAjusteComisionRepositoryCustom.normalizarAjusteComision']}")
  private String sqlNormalizarAjusteComision;

  @Override
  public void normalizarAjusteComision(@NotNull final TareaDto runTarea) {

    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTarea.getId());
    this.update(this.sqlNormalizarAjusteComision, params);

  }

}
