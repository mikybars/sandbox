package com.inditex.rrhh.icmclcwb.model.primary.simulacion.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.simulacion.entity.Simulacion;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class SimulacionRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<Simulacion>
    implements SimulacionRepositoryCustom {

  @Value("#{simulacionPrimaryQuery['SimulacionRepositoryCustom.mergeEmpleadoSimulacion']}")
  private String sqlMergeEmpleadoSimulacion;

  @Value("#{simulacionPrimaryQuery['SimulacionRepositoryCustom.mergeEstructurasEmpleadoSimulacion']}")
  private String sqlMergeEstructurasEmpleadoSimulacion;

  @Value("#{simulacionPrimaryQuery['SimulacionRepositoryCustom.mergePresenciasEmpleadoSimulacion']}")
  private String sqlMergePresenciasEmpleadoSimulacion;

  @Value("#{simulacionPrimaryQuery['SimulacionRepositoryCustom.findEstructurasEmpleadoSimulacion']}")
  private String sqlFindEstructurasEmpleadoSimulacion;

  @Value("#{simulacionPrimaryQuery['SimulacionRepositoryCustom.mergeVentaUltimoCalculo']}")
  private String sqlMergeVentaUltimoCalculo;

  @Value("#{simulacionPrimaryQuery['SimulacionRepositoryCustom.mergePresenciaTiendaUltimoCalculo']}")
  private String sqlMergePresenciaTiendaUltimoCalculo;

  @Value("#{simulacionPrimaryQuery['SimulacionRepositoryCustom.mergePresenciaEmpleadoUltimoCalculo']}")
  private String sqlMergePresenciaEmpleadoUltimoCalculo;

  @Value("#{simulacionPrimaryQuery['SimulacionRepositoryCustom.updateBandaExcepcionada']}")
  private String sqlUpdateBandaExcepcionada;

  @Value("#{simulacionPrimaryQuery['SimulacionRepositoryCustom.updateTiendaPersonaPresencia']}")
  private String sqlUpdateTiendaPersonaPresencia;

  @Value("#{simulacionPrimaryQuery['SimulacionRepositoryCustom.mergePresenciaTiendaSimulada']}")
  private String sqlMergePresenciaTiendaSimulada;

  @Override
  public void mergeEmpleadoSimulacion(@NotNull final TareaDto tarea) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    this.update(this.sqlMergeEmpleadoSimulacion, params);
  }

  @Override
  public void mergeEstructurasEmpleadoSimulacion(@NotNull final TareaDto tarea) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    this.update(this.sqlMergeEstructurasEmpleadoSimulacion, params);
  }

  @Override
  public void mergePresenciasEmpleadoSimulacion(@NotNull final TareaDto tarea) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    this.update(this.sqlMergePresenciasEmpleadoSimulacion, params);
  }

  @Override
  public void mergeVentaUltimoCalculo(@NotNull final TareaDto tarea) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    this.update(this.sqlMergeVentaUltimoCalculo, params);
  }

  @Override
  public void mergePresenciaTiendaUltimoCalculo(@NotNull final TareaDto tarea) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    this.update(this.sqlMergePresenciaTiendaUltimoCalculo, params);
  }

  @Override
  public void mergePresenciaEmpleadoUltimoCalculo(@NotNull final TareaDto tarea) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    this.update(this.sqlMergePresenciaEmpleadoUltimoCalculo, params);
  }

  @Override
  public List<TareaPersonaEstructuraDto> findEstructurasEmpleadoSimulacion(@NotNull final TareaDto tarea) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    return this.query(this.sqlFindEstructurasEmpleadoSimulacion, parameters,
        new RowMapper<TareaPersonaEstructuraDto>() {
          @Override
          public TareaPersonaEstructuraDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            final TareaPersonaEstructuraDto dto = new TareaPersonaEstructuraDto();
            dto.setIdTarea(rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_TAREA));
            dto.setCclIdOrigen(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_ORIGEN));
            dto.setStdIdHr(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA_META4));
            dto.setCclIdPerson(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA_LOCAL));
            dto.setIcmIdTpCalculo(rs.getString(SqlPrimaryConstants.SQL_RESULT_ICM_ID_TP_CALCULO));
            dto.setIcmIdTpComision(rs.getString(SqlPrimaryConstants.SQL_RESULT_ICM_ID_TP_COMISION));
            dto.setStdOrHrPeriod(rs.getString(SqlPrimaryConstants.SQL_RESULT_OR_PERSONA));
            dto.setFechaInicio(rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_INICIO));
            dto.setFechaFin(rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_FIN));
            dto.setValor(rs.getString(SqlPrimaryConstants.SQL_RESULT_ICM_VALOR));
            dto.setTope(rs.getInt(SqlPrimaryConstants.SQL_RESULT_ICM_ORD_TOPE));
            dto.setIcmIdEstrComisionBase(rs.getString(SqlPrimaryConstants.SQL_RESULT_ICM_ID_ESTR_COMISION_BASE));
            dto.setIcmIdEstrComisionPadre(rs.getString(SqlPrimaryConstants.SQL_RESULT_ICM_ID_ESTR_COMISION_PADRE));
            dto.setIcmIdEstrComision(rs.getString(SqlPrimaryConstants.SQL_RESULT_ICM_ID_ESTR_COMISION));
            dto.setFechaInicioPeriodo(rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_INICIO_PERIODO).toLocalDate());
            dto.setIcmIdTpEstructura(rs.getString(SqlPrimaryConstants.SQL_RESULT_ICM_ID_TP_ESTRUCTURA));
            dto.setDesplazamiento(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_DESPLAZAMIENTO));
            dto.setDesplazamientoBase(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_DESPLAZAMIENTO_BASE));
            dto.setActivo(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_ACTIVO));
            dto.setDiaL(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_DIA_LUNES));
            dto.setDiaM(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_DIA_MARTES));
            dto.setDiaX(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_DIA_MIERCOLES));
            dto.setDiaJ(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_DIA_JUEVES));
            dto.setDiaV(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_DIA_VIERNES));
            dto.setDiaS(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_DIA_SABADO));
            dto.setDiaD(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_DIA_DOMINGO));
            dto.setFestivo(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_FESTIVO));
            dto.setCclIdSeccionEfectiva(rs.getString(SqlPrimaryConstants.SQL_RESULT_CCL_ID_SECCION_EFECTIVA));
            dto.setCclIdSeccionEstructura(rs.getString(SqlPrimaryConstants.SQL_RESULT_CCL_ID_SECCION_ESTRUCTURA));
            return dto;
          }
        });

  }

  @Override
  public void updateBandaExcepcionada(@NotNull final TareaDto tarea, @NotNull final Integer banda, @NotEmpty final String cclIdCodOrigen,
      @NotEmpty final String cclIdSeccion) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ICM_BANDA, banda);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_COD_ORIGEN, cclIdCodOrigen);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_SECCION, cclIdSeccion);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

    this.update(this.sqlUpdateBandaExcepcionada, parameters);
  }

  @Override
  public void updateTiendaPersonaPresencia(@NotNull TareaDto tarea, @NotEmpty String cclIdPerson, @NotEmpty String cclIdCodOrigen) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_COD_ORIGEN, cclIdCodOrigen);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON, cclIdPerson);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    this.update(this.sqlUpdateTiendaPersonaPresencia, parameters);
  }

  @Override
  public void mergePresenciaTiendaSimulada(@NotNull TareaDto tarea, @NotEmpty String cclIdPerson, @NotEmpty String cclIdCodOrigen) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_COD_ORIGEN, cclIdCodOrigen);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON, cclIdPerson);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    this.update(this.sqlMergePresenciaTiendaSimulada, parameters);
  }

}
