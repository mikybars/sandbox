package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.SqlParamsUtils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractTareaCalculoAjusteBaseRepositoryCustom
    implements TareaCalculoAjusteBaseRepositoryCustom {

  @Autowired
  @Qualifier("primaryNamedParameterJdbcTemplate")
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  protected abstract String getSqlAjustar();

  @Override
  public String getSqlAjustar(final AlgoritmoAjusteDto algoritmoAjuste) {
    String sql = this.getSqlAjustarBase();
    if (sql != null) {
      sql = SqlParamsUtils.replaceValues(sql, this.getMapValues(algoritmoAjuste, null, null));
    }
    return StringUtils.normalizeSpace(sql);
  }

  protected abstract String getSqlAjustarBase();

  protected abstract Map<String, Object> getMapValues(AlgoritmoAjusteDto algoritmoAjuste, TareaDto tarea,
      IdPersonaLocalDto persona);

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public CompletableFuture<Void> ajustar(final AlgoritmoAjusteDto algoritmoAjuste, final TareaDto tarea,
      final List<IdPersonaLocalDto> personas) {
    if (this.getSqlAjustar() != null) {
      final List<MapSqlParameterSource> batchArgs = new ArrayList<>();
      personas.forEach(persona -> {
        final Map<String, Object> values = this.getMapValues(algoritmoAjuste, tarea, persona);
        final MapSqlParameterSource arg = new MapSqlParameterSource();
        values.forEach((paramName, value) -> arg.addValue(paramName, value));
        batchArgs.add(arg);
      });
      this.namedParameterJdbcTemplate.batchUpdate(this.getSqlAjustar(),
          batchArgs.toArray(new MapSqlParameterSource[batchArgs.size()]));
    }
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
