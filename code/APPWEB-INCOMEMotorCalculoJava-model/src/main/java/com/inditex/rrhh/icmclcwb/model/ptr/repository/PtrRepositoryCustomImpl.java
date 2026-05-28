package com.inditex.rrhh.icmclcwb.model.ptr.repository;

import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlComisConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.annotation.AntiguoMotor;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@AntiguoMotor
public class PtrRepositoryCustomImpl
    extends JdbcBatchPtrRepositoryAbstract<Integer>
    implements PtrRepositoryCustom {

  @Value("#{ptrPrimaryQuery['PtrRepositoryCustom.findPresenciasOrigenAndFecha']}")
  private String sqlfindPresenciasOrigenAndFechaQuery;

  @Value("#{ptrPrimaryQuery['PtrRepositoryCustom.findPresenciasOrigenAndFechaEs']}")
  private String sqlfindPresenciasOrigenAndFechaEsQuery;

  @Override
  public PresenciaOrigenDto findPresenciasOrigenAndFecha(final TareaDto tarea, final TareaAmbitoDto ambito) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlPtrConstants.SQL_PARAM_FECHA_INICIO,
        TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    map.addValue(SqlPtrConstants.SQL_PARAM_FECHA_FIN,
        TimeUtils.toDate(tarea.getFechaFinPeriodo()));
    map.addValue(SqlPtrConstants.SQL_PARAM_CCL_ID_ORIGEN, ambito.getCclIdOrigen());

    return this.queryForObject(this.sqlfindPresenciasOrigenAndFechaQuery, map,
        (rs, rowNum) -> PresenciaOrigenDto
            .builder()
            .horasSeccion1(rs.getInt(SqlComisConstants.SQL_RESULT_HORAS_SECCION_1))
            .horasSeccion2(rs.getInt(SqlComisConstants.SQL_RESULT_HORAS_SECCION_2))
            .horasSeccion3(rs.getInt(SqlComisConstants.SQL_RESULT_HORAS_SECCION_3))
            .horasSeccion4(rs.getInt(SqlComisConstants.SQL_RESULT_HORAS_SECCION_4))
            .build());
  }

  @Override
  public PresenciaOrigenDto findPresenciasOrigenAndFechaEs(final TareaDto tarea, final TareaAmbitoDto ambito,
      final Integer idCatalogoAplicacion) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlPtrConstants.SQL_PARAM_FECHA_INICIO,
        TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    map.addValue(SqlPtrConstants.SQL_PARAM_FECHA_FIN,
        TimeUtils.toDate(tarea.getFechaFinPeriodo()));
    map.addValue(SqlPtrConstants.SQL_PARAM_CCL_ID_ORIGEN, ambito.getCclIdOrigen());
    map.addValue(SqlPtrConstants.SQL_PARAM_ID_CATALOGO_APLICACION, idCatalogoAplicacion);

    return this.queryForObject(this.sqlfindPresenciasOrigenAndFechaEsQuery, map,
        (rs, rowNum) -> PresenciaOrigenDto
            .builder()
            .horasSeccion1(rs.getInt(SqlComisConstants.SQL_RESULT_HORAS_SECCION_1))
            .horasSeccion2(rs.getInt(SqlComisConstants.SQL_RESULT_HORAS_SECCION_2))
            .horasSeccion3(rs.getInt(SqlComisConstants.SQL_RESULT_HORAS_SECCION_3))
            .horasSeccion4(rs.getInt(SqlComisConstants.SQL_RESULT_HORAS_SECCION_4))
            .build());
  }

}
