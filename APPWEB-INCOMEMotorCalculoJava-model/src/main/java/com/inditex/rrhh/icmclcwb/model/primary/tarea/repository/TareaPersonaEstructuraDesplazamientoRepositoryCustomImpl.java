package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraDesplazamiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TareaPersonaEstructuraDesplazamientoRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaPersonaEstructuraDesplazamiento>
    implements TareaPersonaEstructuraDesplazamientoRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-persona-estructura-desplazamiento:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaPersonaEstructuraDesplazamientoRepositoryCustom.save']}")
  private String sqlSave;

  @Value("#{primaryQuery['TareaPersonaEstructuraDesplazamientoRepositoryCustom.crearChallengeOpcionOrigenIgualarBandas']}")
  private String sqlCrearChallengeOpcionOrigenIgualarBandas;

  @Autowired
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Override
  public List<TareaPersonaEstructuraDesplazamiento> save(final List<TareaPersonaEstructuraDesplazamiento> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

  @Override
  public void crearChallengeOpcionOrigenIgualarBandas(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    map.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO, AppConstants.getTIPOS_CALCULO_CHALLENGE());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION,  AppConstants.getTIPOS_COMISION_CHALLENGE());
    this.namedParameterJdbcTemplate.update(this.sqlCrearChallengeOpcionOrigenIgualarBandas, map);
  }

}
