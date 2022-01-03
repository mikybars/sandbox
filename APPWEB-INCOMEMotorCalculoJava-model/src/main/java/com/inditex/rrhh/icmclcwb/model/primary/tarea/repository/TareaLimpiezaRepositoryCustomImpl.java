package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoLimpiezaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TareaLimpiezaRepositoryCustomImpl implements TareaLimpiezaRepositoryCustom {

  @Autowired
  @Qualifier("primaryNamedParameterJdbcTemplate")
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Value("#{primaryQuery['TareaLimpiezaRepositoryCustom.updateFechaFinalizacion']}")
  private String sqlUpdateFechaFinalizacion;

  @Value("#{primaryQuery['TareaLimpiezaRepositoryCustom.updateEstado']}")
  private String sqlUpdateEstado;

  @Value("#{primaryQuery['TareaLimpiezaRepositoryCustom.inicioLimpieza']}")
  private String sqlInicioLimpieza;

  @Override
  public void updateFechaFinalizacion(
      @NotNull @Positive final Long idTareaLimpieza) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_HORA_FIN, TimeUtils.nowDate());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_LIMPIEZA, idTareaLimpieza);
    this.namedParameterJdbcTemplate.update(this.sqlUpdateFechaFinalizacion, params);
  }

  @Override
  public void inicioLimpieza(
      @NotNull @Positive final Long idTareaLimpieza) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_HORA_INICIO, TimeUtils.nowDate());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_LIMPIEZA, idTareaLimpieza);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_LIMPIEZA, EstadoLimpiezaEnum.EN_CURSO.getId());
    this.namedParameterJdbcTemplate.update(this.sqlInicioLimpieza, params);
  }

  @Override
  public void updateEstado(
      @NotNull @Positive final Long idTareaLimpieza,
      @NotNull @Valid final EstadoLimpiezaDto estado) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_LIMPIEZA, estado.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_LIMPIEZA, idTareaLimpieza);
    this.namedParameterJdbcTemplate.update(this.sqlUpdateEstado, params);
  }

}
