package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.model.app.util.SqlParamsUtils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Slf4j
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

  protected Map<String, Object> getMapValues(final AlgoritmoDTO algoritmo) {
    return this.getMapValues(algoritmo, null, null);
  }

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

      final Instant start = Instant.now();
      try {
        this.namedParameterJdbcTemplate.batchUpdate(this.getSqlCalcular(),
            batchArgs.toArray(new MapSqlParameterSource[batchArgs.size()]));
      } catch (final Exception e) {
        throw (e);
      } finally {
        final Instant end = Instant.now();
        final Duration duration = Duration.between(start, end);

        if (duration.compareTo(Duration.ofSeconds(60)) > 0) {
          this.log.warn(
              "AbstractTareaCalculoAlgoritmoBaseRepositoryCustom :: Lento :: Lento60 :: Duration[{}] :: Algoritmo[{}] :: Personas[{}]",
              duration, algoritmo.getId(), personas.stream().map(e -> e.getIdPersonaLocal()).collect(
                  Collectors.toList()));
        } else if (duration.compareTo(Duration.ofSeconds(30)) > 0) {
          this.log.warn(
              "AbstractTareaCalculoAlgoritmoBaseRepositoryCustom :: Lento :: Lento30 :: Duration[{}] :: Algoritmo[{}] :: Personas[{}]",
              duration, algoritmo.getId(), personas.stream().map(e -> e.getIdPersonaLocal()).collect(
                  Collectors.toList()));
        }
      }

    }
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
