package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraDesplazamiento;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TareaPersonaEstructuraDesplazamientoRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaPersonaEstructuraDesplazamiento>
    implements TareaPersonaEstructuraDesplazamientoRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-persona-estructura-desplazamiento:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaPersonaEstructuraDesplazamientoRepositoryCustom.save']}")
  private String sqlSave;

  @Value("#{primaryQuery['TareaPersonaEstructuraDesplazamientoRepositoryCustom.crearEstructurasDestinoIgualarBandas']}")
  private String sqlCrearChallengeOpcionOrigenIgualarBandas;

  @Override
  public List<TareaPersonaEstructuraDesplazamiento> save(final List<TareaPersonaEstructuraDesplazamiento> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

  @Override
  public void crearEstructurasDestinoIgualarBandas() {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    this.update(this.sqlCrearChallengeOpcionOrigenIgualarBandas, map);
  }

}
