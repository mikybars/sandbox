package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.model.app.util.SqlParamsUtils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public abstract class AbstractTareaCalculoAlgoritmoBaseRepositoryCustom
    implements TareaCalculoAlgoritmoBaseRepositoryCustom {

  @Autowired
  @Qualifier("primaryNamedParameterJdbcTemplate")
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  protected abstract String getSqlCalcular();

  @Override
  public String getSqlCalcular(final AlgoritmoDTO algoritmo) {
    String sql = this.getSqlCalcularBase();
    if (sql != null) {
      sql = SqlParamsUtils.replaceValues(sql, this.getMapValues(algoritmo));
    }
    return StringUtils.normalizeSpace(sql);
  }

  protected abstract String getSqlCalcularBase();

  protected abstract Map<String, Object> getMapValues(AlgoritmoDTO algoritmo, TareaDto tarea,
      IdPersonaLocalDto persona);

  protected final Map<String, Object> getMapValues(final AlgoritmoDTO algoritmo) {
    return this.getMapValues(algoritmo, null, null);
  }

  @Auditoria
  @Override
  public CompletableFuture<Void> calcular(final AlgoritmoDTO algoritmo, final TareaDto tarea,
      final List<IdPersonaLocalDto> personas) {
    if (this.getSqlCalcular() != null) {
      final List<MapSqlParameterSource> batchArgs = new ArrayList<>();
      personas.forEach(persona -> {
        final Map<String, Object> values = this.getMapValues(algoritmo, tarea, persona);
        final MapSqlParameterSource arg = new MapSqlParameterSource();
        values.forEach((paramName, value) -> arg.addValue(paramName, value));
        batchArgs.add(arg);
      });
      this.namedParameterJdbcTemplate.batchUpdate(this.getSqlCalcular(),
          batchArgs.toArray(new MapSqlParameterSource[batchArgs.size()]));
    }
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
