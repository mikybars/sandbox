package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraPolitica;

import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TareaPersonaEstructuraPoliticaRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaPersonaEstructuraPolitica>
    implements TareaPersonaEstructuraPoliticaRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-persona-estructura-politica:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaPersonaEstructuraPoliticaRepositoryCustom.save']}")
  private String sqlSave;

  @Value("#{primaryQuery['TareaPersonaEstructuraPoliticaRepositoryCustom.updateImporteEstructuraPoliticas']}")
  private String sqlUpdateImporteEstructuraPoliticas;

  @Value("#{primaryQuery['TareaPersonaEstructuraPolitica.existencia']}")
  private String sqlExistencia;

  @Autowired
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Override
  public List<TareaPersonaEstructuraPolitica> save(final List<TareaPersonaEstructuraPolitica> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

  @Override
  public void updateImporteEstructuraPoliticas(@NonNull final TareaDto tarea, @NonNull final TrabajoDTO trabajoDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA,
        TipoPoliticaEnum.MINIMO_GARANTIZADO.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    this.update(this.sqlUpdateImporteEstructuraPoliticas, parameters);
  }

  @Override
  public Boolean existePolitica(@NonNull final TareaDto tarea,
      @NonNull @NotEmpty final List<TipoPoliticaEnum> politicas) {
    final Map<String, Object> parameters = new HashMap<>();
    parameters.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    parameters.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA,
        politicas.stream()
            .map(TipoPoliticaEnum::getId)
            .collect(
                Collectors.toList()));
    return this.namedParameterJdbcTemplate.queryForObject(this.sqlExistencia, parameters,
        (rs, rowNum) -> rs.getInt(SqlPrimaryConstants.SQL_RESULT_TOTAL) > 0);
  }

}
