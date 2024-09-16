package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresencia;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TareaLocalizacionPresenciaRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionPresencia>
    implements TareaLocalizacionPresenciaRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-localizacion-seccion-presencia:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.save']}")
  private String sqlSave;

  @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.updateActivoVacio']}")
  private String sqlUpdateActivoVacio;

  @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.compensar']}")
  private String sqlCompensar;

  @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.incluirPresenciasDesplazamientoOrigen']}")
  private String sqlIncluirPresenciasDesplazamientoOrigen;

  @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.incluirPresenciasDesplazamientoDestino']}")
  private String sqlIncluirPresenciasDesplazamientoDestino;

  @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.totalizar']}")
  private String sqlTotalizar;

  @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.totalizarEcommerce']}")
  private String sqlTotalizarEcommerce;

  @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.totalizarEmpleadosPorVenta']}")
  private String sqlTotalizarEmpleadosPorVenta;

  @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.incluirPresenciaDesplazamientoOrigenEcommerce']}")
  private String sqlIncluirMinutosEcommerceDesplazamientoOrigen;

  @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.incluirPresenciaDesplazamientoDestinoEcommerce']}")
  private String sqlIncluirMinutosEcommerceDesplazamientoDestino;

  @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.compensarLocalizacionManual']}")
  private String sqlCompensarLocalizacionManual;

  @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacion']}")
  private String sqlRepartirPresenciasSindicalesLocalizacion;

  @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacionSeccion']}")
  private String sqlRepartirPresenciasSindicalesLocalizacionSeccion;

  @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.updateActivoByTipoDato']}")
  private String sqlUpdateActivoByTipoDato;

  @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.totalizarEcommerceSeccion']}")
  private String sqlTotalizarEcommerceSeccion;

  @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.totalizarPresenciasSindicalesLocalizacion']}")
  private String sqlTotalizarPresenciasSindicalesLocalizacion;

  @Value("#{primaryQuery['TareaLocalizacionPresenciaRepositoryCustom.totalizarIncluidoChallengePorcentaje']}")
  private String sqlTotalizarIncluidoChallengePorcentaje;

  @Autowired
  private TipoDatoService tipoDatoService;

  @Override
  public List<TareaLocalizacionPresencia> save(final List<TareaLocalizacionPresencia> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

  @Override
  public void updateActivoVacio(@NotNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_MINUTOS, SqlPrimaryConstants.SQL_VALUE_MINUTOS_CERO);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
        Arrays.asList(TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId(),
            TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDODENOMINADOR.getId()));
    this.update(this.sqlUpdateActivoVacio, parameters);
  }

  @Override
  public void compensar(@NotNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_DENOMINADOR,
        SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA,
        TipoPoliticaEnum.EXCLUIDO_DENOMINADOR.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_ORIGEN, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_DESTINO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_REPARTIDO_PROVINCIA,
        SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_PRESENCIAS_SINDICALES,
        TipoDatoEnum.REPARTO_HORAS_SINDICALES_LOCALIZACION.getId());
    this.update(this.sqlCompensar, parameters);
  }

  @Override
  public void totalizar(@NotNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_DENOMINADOR,
        SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDODENOMINADOR.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA,
        TipoPoliticaEnum.EXCLUIDO_DENOMINADOR.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_LOCALIZACION_PRESENCIA_MANUAL,
        TipoDatoEnum.PRESENCIA_MANUAL_LOCALIZACION_SECCION_INCLUIDODENOMINADOR.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_ORIGEN, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_DESTINO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_REPARTIDO_PROVINCIA,
        SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_PRESENCIAS_SINDICALES,
        TipoDatoEnum.REPARTO_HORAS_SINDICALES_LOCALIZACION_SECCION.getId());

    this.update(this.sqlTotalizar, parameters);
  }

  @Override
  public void totalizarEcommerce(@NotNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA_INCLUIDOECOMMERCE.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_DENOMINADOR,
        SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA,
        TipoPoliticaEnum.EXCLUIDO_DENOMINADOR.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDOECOMMERCE.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_INCLUIDO_ECOMMERCE,
        SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_SECCION, AppConstants.SECCION_4);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_ORIGEN, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_DESTINO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    this.update(this.sqlTotalizarEcommerce, parameters);
  }

  @Override
  public void totalizarEmpleadosPorVenta(@NotNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_INCLUIDO_VENTA,
        SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA,
        TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_CALCULO, TipoCalculoEnum.POR_VENTA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_ORIGEN, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_DESTINO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.PRESENCIA_LOCALIZACION_EMPLEADOS_POR_VENTA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_SECCION, AppConstants.SECCION_4);
    this.update(this.sqlTotalizarEmpleadosPorVenta, parameters);
  }

  @Override
  public void compensarLocalizacionManual(@NotNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_MINUTOS, SqlPrimaryConstants.SQL_VALUE_MINUTOS_CERO);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDODENOMINADOR.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
        Arrays.asList(TipoDatoEnum.PRESENCIA_MANUAL_LOCALIZACION_SECCION_INCLUIDODENOMINADOR.getId(),
            TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDODENOMINADOR.getId()));

    this.update(this.sqlCompensarLocalizacionManual, parameters);
  }

  @Override
  public void repartirPresenciasSindicalesLocalizacion(
      @NotNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ABIERTO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.REPARTO_HORAS_SINDICALES_LOCALIZACION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_MINUTOS,
        TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDOECOMMERCE.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_PRESENCIAS_SINDICALES,
        TipoDatoEnum.PRESENCIA_LOCALIZACION_HORAS_SINDICALES.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
    this.update(this.sqlRepartirPresenciasSindicalesLocalizacion, parameters);
  }

  @Override
  public void repartirPresenciasSindicalesLocalizacionSeccion(
      @NotNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_MINUTOS,
        TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDOECOMMERCE.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_PRESENCIAS_SINDICALES,
        TipoDatoEnum.REPARTO_HORAS_SINDICALES_LOCALIZACION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.REPARTO_HORAS_SINDICALES_LOCALIZACION_SECCION.getId());
    this.update(this.sqlRepartirPresenciasSindicalesLocalizacionSeccion, parameters);
  }

  @Override
  public void totalizarEcommerceSeccion(
      @NotNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_INCLUIDO_ECOMMERCE, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA, TipoPoliticaEnum.EXCLUIDO_DENOMINADOR.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA_INCLUIDOECOMMERCE.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_ORIGEN, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_DESTINO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDOECOMMERCE.getId());
    this.update(this.sqlTotalizarEcommerceSeccion, params);
  }

  @Override
  public void totalizarPresenciasSindicalesLocalizacion(
      @NotNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.PRESENCIA_LOCALIZACION_HORAS_SINDICALES.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_REPARTIDO_PROVINCIA, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA_REPARTIDOPROVINCIA.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    this.update(this.sqlTotalizarPresenciasSindicalesLocalizacion, params);
  }

  @Override
  public void totalizarIncluidoChallengePorcentaje(@NotNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_INCLUIDO_CHALLENGE_PORCENTAJE,
        SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDOCHALLENGEPORCENTAJE.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA,
        TipoPoliticaEnum.EXCLUIDO_DENOMINADOR.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_ORIGEN, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_HORAS_DESTINO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_PRESENCIAS_SINDICALES,
        TipoDatoEnum.REPARTO_HORAS_SINDICALES_LOCALIZACION.getId());
    this.update(this.sqlTotalizarIncluidoChallengePorcentaje, parameters);
  }

  @Override
  public void compensarLocalizacionManualIncluidoChallengePorcentaje(@NotNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_MINUTOS, SqlPrimaryConstants.SQL_VALUE_MINUTOS_CERO);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDOCHALLENGEPORCENTAJE.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
        Arrays.asList(TipoDatoEnum.PRESENCIA_MANUAL_LOCALIZACION_SECCION_INCLUIDODENOMINADOR.getId(),
            TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDOCHALLENGEPORCENTAJE.getId()));

    this.update(this.sqlCompensarLocalizacionManual, parameters);
  }

}
