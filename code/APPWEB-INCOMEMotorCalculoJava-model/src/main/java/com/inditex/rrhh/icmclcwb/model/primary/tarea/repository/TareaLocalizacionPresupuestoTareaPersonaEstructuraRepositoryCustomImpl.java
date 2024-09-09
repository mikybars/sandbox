package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Arrays;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TareaLocalizacionPresupuestoTareaPersonaEstructuraRepositoryCustomImpl
    implements TareaLocalizacionPresupuestoTareaPersonaEstructuraRepositoryCustom {

  @Value("#{primaryQuery['TareaLocalizacionPresupuestoTareaPersonaEstructuraRepositoryCustom.relacionarEstructuraSinDesplazamiento']}")
  private String sqlRelacionarEstructuraSinDesplazamiento;

  @Autowired
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Override
  public void relacionarEstructuraSinDesplazamiento(final TareaDto tarea) {

    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_INCLUIDO_CHALLENGE, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    map.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO,
        Arrays.asList(TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId(),
            TipoCalculoEnum.CHALLENGE_PRECIO_HORA_SECCION.getId(),
            TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId(),
            TipoCalculoEnum.CHALLENGE_IMPORTE_SECCION.getId(),
            TipoCalculoEnum.CHALLENGE_PORCENTAJE.getId(),
            TipoCalculoEnum.CHALLENGE_JORNADA.getId()));
    map.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO_CHALLENGE_LOCALIZACION,
        Arrays.asList(TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId(),
            TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId(),
            TipoCalculoEnum.CHALLENGE_PORCENTAJE.getId(),
            TipoCalculoEnum.CHALLENGE_JORNADA.getId()));
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

    this.namedParameterJdbcTemplate.update(this.sqlRelacionarEstructuraSinDesplazamiento, map);

  }

}
