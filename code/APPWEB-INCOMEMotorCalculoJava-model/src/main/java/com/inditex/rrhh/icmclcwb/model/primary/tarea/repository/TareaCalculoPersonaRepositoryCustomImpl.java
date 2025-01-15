package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.GenericAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCalculoPersona;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TareaCalculoPersonaRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaCalculoPersona>
    implements TareaCalculoPersonaRepositoryCustom {

  @Value("#{primaryQuery['TareaCalculoPersonaRepositoryCustom.mergePersonaCalculoByAmbito']}")
  private String sqlMergePersonaCalculoByAmbito;

  @Value("#{primaryQuery['TareaCalculoPersonaRepositoryCustom.mergePersonaCalculoByAmbitoLocalizacion']}")
  private String sqlMergePersonaCalculoByAmbitoLocalizacion;

  @Value("#{primaryQuery['TareaCalculoPersonaRepositoryCustom.mergePersonaCalculoByAmbitoPersona']}")
  private String sqlMergePersonaCalculoByAmbitoPersona;

  @Value("#{primaryQuery['TareaCalculoPersonaRepositoryCustom.updateWithEstado']}")
  private String sqlUpdateWithEstado;

  @Value("#{primaryQuery['TareaCalculoPersonaRepositoryCustom.findByAlgoritmo']}")
  private String sqlFindByAlgoritmo;

  @Value("#{primaryQuery['TareaCalculoPersonaRepositoryCustom.updateEstadoActualWithEstadoNuevo']}")
  private String sqlUpdateEstadoActualWithEstadoNuevo;

  @Value("#{primaryQuery['TareaCalculoPersonaRepositoryCustom.findByTareaAndIdEstado']}")
  private String sqlFindByTareaAndIdEstado;

  @Value("#{primaryQuery['TareaCalculoPersonaRepositoryCustom.findIdTipoCalculoAndIdTipoComisionByIdAlgoritmo']}")
  private String sqlFindIdTipoCalculoAndIdTipoComisionByIdAlgoritmo;

  @Override
  public List<IdPersonaLocalDto> findByTareaAndIdEstadoAndIdTipoPolitica(@NotNull final TareaDto tarea,
      @NotNull @Positive final String idTipoPolitica) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_TAREA_PERSONA_KO,
        EstadoTareaCalculoPersonaEnum.KO.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA, idTipoPolitica);
    return this.query(this.sqlFindByTareaAndIdEstado, parameters,
        new RowMapper<IdPersonaLocalDto>() {
          @Override
          public IdPersonaLocalDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            final IdPersonaLocalDto dto = new IdPersonaLocalDto();
            dto.setIdPersonaLocal(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA_LOCAL));
            dto.setStdOrHrPeriod(rs.getString(SqlPrimaryConstants.SQL_RESULT_OR_PERSONA));
            return dto;
          }
        });
  }

  @Override
  public List<IdPersonaLocalDto> findByAlgoritmo(@NotNull final TareaDto tarea,
      @NotBlank final AlgoritmoDTO algoritmo) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO, algoritmo.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO, algoritmo.getDesplazamiento());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO_BASE, algoritmo.getDesplazamientoBase());

    return this.query(this.sqlFindByAlgoritmo, parameters,
        new RowMapper<IdPersonaLocalDto>() {
          @Override
          public IdPersonaLocalDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            final IdPersonaLocalDto dto = new IdPersonaLocalDto();
            dto.setIdPersonaLocal(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA_LOCAL));
            dto.setStdOrHrPeriod(rs.getString(SqlPrimaryConstants.SQL_RESULT_OR_PERSONA));
            return dto;
          }
        });
  }

  @Override
  public void updateWithEstadoAndidPersona(final List<String> cclIdPerson, final RunTareaDto runTareaDto,
      final EstadoTareaPersonaDto estado) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO, estado.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON, cclIdPerson);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    this.update(this.sqlUpdateWithEstado, parameters);
  }

  @Override
  public void updateWithEstado(final RunTareaDto runTareaDto, final EstadoTareaPersonaDto estadoActual,
      final EstadoTareaPersonaDto estadoNuevo) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_ACTUAL, estadoActual.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_NUEVO, estadoNuevo.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    this.update(this.sqlUpdateEstadoActualWithEstadoNuevo, parameters);
  }

  @Override
  public void mergePersonaCalculoByAmbito(@NotNull final RunTareaDto tareaDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getTarea().getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT, tareaDto.getTarea().getStdIdLegEnt());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_TAREA_PERSONA,
        EstadoTareaCalculoPersonaEnum.PENDIENTE.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_TAREA_PERSONA_KO,
        EstadoTareaCalculoPersonaEnum.KO.getId());
    this.update(this.sqlMergePersonaCalculoByAmbito, params);
  }

  @Override
  public void mergePersonaCalculoByAmbitoLocalizacion(@NotNull final RunTareaDto tareaDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getTarea().getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT, tareaDto.getTarea().getStdIdLegEnt());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_TAREA_PERSONA,
        EstadoTareaCalculoPersonaEnum.PENDIENTE.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_TAREA_PERSONA_KO,
        EstadoTareaCalculoPersonaEnum.KO.getId());
    this.update(this.sqlMergePersonaCalculoByAmbitoLocalizacion, params);
  }

  @Override
  public void mergePersonaCalculoByAmbitoPersona(@NotNull final RunTareaDto tareaDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getTarea().getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT, tareaDto.getTarea().getStdIdLegEnt());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_TAREA_PERSONA,
        EstadoTareaCalculoPersonaEnum.PENDIENTE.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_TAREA_PERSONA_KO,
        EstadoTareaCalculoPersonaEnum.KO.getId());
    this.update(this.sqlMergePersonaCalculoByAmbitoPersona, params);
  }

  @Override
  public List<GenericAlgoritmoPropertiesDto> findIdTipoCalculoAndIdTipoComisionByIdAlgoritmo(
      @NotBlank final AlgoritmoDTO algoritmo) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO, algoritmo.getId());
    return this.query(this.sqlFindIdTipoCalculoAndIdTipoComisionByIdAlgoritmo, parameters,
        new RowMapper<GenericAlgoritmoPropertiesDto>() {
          @Override
          public GenericAlgoritmoPropertiesDto mapRow(final ResultSet rs, final int rowNum)
              throws SQLException {
            final GenericAlgoritmoPropertiesDto dto = new GenericAlgoritmoPropertiesDto();
            dto.setIdTipoCalculo(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_TIPO_CALCULO));
            dto.setIdTipoComision(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_TIPO_COMISION));
            return dto;
          }
        });
  }

}
