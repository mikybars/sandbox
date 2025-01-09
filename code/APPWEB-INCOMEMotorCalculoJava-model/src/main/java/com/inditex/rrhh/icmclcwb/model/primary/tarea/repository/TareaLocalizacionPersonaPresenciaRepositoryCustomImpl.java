package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaPresencia;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TareaLocalizacionPersonaPresenciaRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionPersonaPresencia>
    implements TareaLocalizacionPersonaPresenciaRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-localizacion-persona-seccion-presencia:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.save']}")
  private String sqlSave;

  @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.updateActivo']}")
  private String sqlUpdateActivo;

  @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.updateActivoVacio']}")
  private String sqlUpdateActivoVacio;

  @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.compensar']}")
  private String sqlCompensar;

  @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.compensarChallenge']}")
  private String sqlCompensarChallenge;

  @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorPresencia']}")
  private String sqlIndicadorPresencia;

  @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorPresenciaDesplazamiento']}")
  private String sqlIndicadorPresenciaDesplazamiento;

  @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.presenciaDesplazamiento']}")
  private String sqlPresenciaDesplazamiento;

  @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.presenciaDesplazamientoChallengePorcentaje']}")
  private String sqlPresenciaDesplazamientoChallengePorcentaje;

  @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorPresenciaDesplazamientoBase']}")
  private String sqlIndicadorPresenciaDesplazamientoBase;

  @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom."
      + "indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion']}")
  private String sqlIndicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion;

  @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.procesarPresenciasHorasFijas']}")
  private String sqlProcesarPresenciasHorasFijas;

  @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.procesarPresenciasHorasFijasDesplazamientos']}")
  private String sqlProcesarPresenciasHorasFijasDesplazamientos;

  @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorPersonaPorVenta']}")
  private String sqlIndicadorPersonaPorVenta;

  @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.presenciasIncluidoVenta']}")
  private String sqlPresenciasIncluidoVenta;

  @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorDesplazamientoDirectoVenta']}")
  private String sqlIndicadorDesplazamientoDirectoVenta;

  @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorDesplazamientoDirectoVentaSinPresencias']}")
  private String sqlIndicadorDesplazamientoDirectoVentaSinPresencias;

  @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorDesplazamientoBaseDirectoVenta']}")
  private String sqlIndicadorDesplazamientoBaseDirectoVenta;

  @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorDesplazamientoBaseDirectoVentaOtraTienda']}")
  private String sqlindicadorDesplazamientoBaseDirectoVentaOtraTienda;

  @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorDesplazamientoDirectoVentaCambioFuncion']}")
  private String sqlIndicadorDesplazamientoDirectoVentaCambioFuncion;

  @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorDesplazamientoChallengeImporteTienda']}")
  private String sqlIndicadorDesplazamientoChallengeImporteTienda;

  @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.updateActivoPersonasExternas']}")
  private String sqlUpdateActivoPersonasExternas;

  @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorDesplazamientoBaseDirectoVentaSinDesplazamiento']}")
  private String sqlIndicadorDesplazamientoBaseDirectoVentaSinDesplazamiento;

  @Autowired
  private TipoDatoService tipoDatoService;

  @Override
  public void indicadorPresencia(@NonNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA,
        TipoDatoEnum.INDICADOR_PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_CALCULO,
        SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO,
        Arrays.asList(TipoCalculoEnum.DIRECTO_SOBRE_VENTA_CON_PRESENCIA.getId(),
            TipoCalculoEnum.DIRECTO_SOBRE_VENTA_CON_PRESENCIA_Y_REDUCCION_DE_JORNADA.getId()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
    this.update(this.sqlIndicadorPresencia, parameters);
  }

  @Override
  public void presenciaDesplazamiento(@NonNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_PRESENCIA_DESPLAZAMIENTO,
        TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPO_HORA_DESPLAZAMIENTO.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA_DESPLAZAMIENTO,
        TipoDatoEnum.INDICADOR_PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO.getId());

    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_CALCULO,
        SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
        Arrays.asList(TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
            TipoDatoEnum.PRESENCIA_MANUAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
            TipoDatoEnum.PRESENCIA_HORAS_FIJAS_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_COMISIONABLE, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CALCULA, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    this.update(this.sqlPresenciaDesplazamiento, parameters);
  }

  @Override
  public void presenciaDesplazamientoChallengePorcentaje(@NonNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_PRESENCIA_DESPLAZAMIENTO,
        TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDOCHALLENGEPORCENTAJE_DESPLAZAMIENTO.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_INCLUIDO_CHALLENGE_PORCENTAJE,
        SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
        Arrays.asList(TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
            TipoDatoEnum.PRESENCIA_MANUAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
            TipoDatoEnum.PRESENCIA_HORAS_FIJAS_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_COMISIONABLE, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CALCULA, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    this.update(this.sqlPresenciaDesplazamientoChallengePorcentaje, parameters);
  }

  @Override
  public void indicadorPresenciaDesplazamiento(@NonNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA,
        TipoDatoEnum.INDICADOR_PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_CALCULO,
        SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
        Arrays.asList(TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
            TipoDatoEnum.PRESENCIA_MANUAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId(),
            TipoDatoEnum.PRESENCIA_HORAS_FIJAS_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()));
    this.update(this.sqlIndicadorPresenciaDesplazamiento, parameters);
  }

  @Override
  public void indicadorPresenciaDesplazamientoBase(@NonNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA,
        TipoDatoEnum.INDICADOR_PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO_BASE.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_CALCULO,
        SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO,
        Arrays.asList(TipoCalculoEnum.DIRECTO_SOBRE_VENTA.getId(),
            TipoCalculoEnum.DIRECTO_SOBRE_VENTA_CON_PRESENCIA.getId(),
            TipoCalculoEnum.DIRECTO_SOBRE_VENTA_CON_REDUCCION_DE_JORNADA.getId(),
            TipoCalculoEnum.DIRECTO_SOBRE_VENTA_CON_PRESENCIA_Y_REDUCCION_DE_JORNADA.getId()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
    this.update(this.sqlIndicadorPresenciaDesplazamientoBase, parameters);
  }

  @Override
  public void indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(
      @NonNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA,
        TipoDatoEnum.INDICADOR_PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO_BASE_DESPLAZAMIENTO_MISMA_LOCALIZACION
            .getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_CALCULO,
        SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
    this.update(this.sqlIndicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion, parameters);
  }

  @Override
  public void updateActivoVacio(@NonNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_MINUTOS, SqlPrimaryConstants.SQL_VALUE_MINUTOS_CERO);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.PRESENCIA_PERSONA_TIPOHORA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO,
        TimeUtils.toDate(runTareaDto.getTarea().getFechaInicioPeriodo()));
    this.update(this.sqlUpdateActivoVacio, parameters);
  }

  @Override
  public void updateActivo(@NonNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO,
        TimeUtils.toDate(runTareaDto.getTarea().getFechaInicioPeriodo()));
    final List<IdTipoDatoDto> tiposDatoPresencia = this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
        tiposDatoPresencia.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    this.update(this.sqlUpdateActivo, parameters);
  }

  @Override
  public void compensar(@NonNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_EXCLUIDO_DENOMINADOR,
        SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    final List<IdTipoDatoDto> tiposDatoPresencia = this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
        tiposDatoPresencia.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_INCLUIDODENOMINADOR.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_SECCION, AppConstants.SECCION_4);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA,
        TipoPoliticaEnum.EXCLUIDO_DENOMINADOR.getId());

    this.update(this.sqlCompensar, parameters);
  }

  @Override
  public void compensarChallenge(@NonNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_INCLUIDO_CHALLENGE,
        SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    final List<IdTipoDatoDto> tiposDatoPresencia = this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
        tiposDatoPresencia.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_INCLUIDOCHALLENGE.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_SECCION, AppConstants.SECCION_4);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

    this.update(this.sqlCompensarChallenge, parameters);
  }

  @Override
  public void presenciasIncluidoVenta(@NonNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_INCLUIDO_VENTA, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    final List<IdTipoDatoDto> tiposDatoPresencia = this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO,
        tiposDatoPresencia.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.PRESENCIA_LOCALIZACION_PERSONA_TIPOHORA_INCLUIDOVENTA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_SECCION, AppConstants.SECCION_4);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

    this.update(this.sqlPresenciasIncluidoVenta, parameters);
  }

  @Override
  public void presenciasHorasFijas(@NonNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ABIERTO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA, TipoPoliticaEnum.HORAS_FIJAS.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.PRESENCIA_HORAS_FIJAS_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());

    this.update(this.sqlProcesarPresenciasHorasFijas, parameters);
  }

  @Override
  public void presenciasHorasFijasDesplazamiento(@NonNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ABIERTO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA, TipoPoliticaEnum.HORAS_FIJAS.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.PRESENCIA_HORAS_FIJAS_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());

    this.update(this.sqlProcesarPresenciasHorasFijasDesplazamientos, parameters);
  }

  @Override
  public void indicadorPersonaPorVenta(@NonNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_CALCULO, TipoCalculoEnum.POR_VENTA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_SECCION, AppConstants.SECCION_4);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.INDICADOR_PRESENCIA_EMPLEADOS_POR_VENTA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO_VENTA,
        TipoGrupoDatoEnum.OPERACIONES_VENTA_INDIVIDUAL_LOCALIZACION_SECCION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

    this.update(this.sqlIndicadorPersonaPorVenta, parameters);
  }

  @Override
  public void indicadorDesplazamientoDirectoVenta(@NonNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_CALCULO,
        Arrays.asList(TipoCalculoEnum.DIRECTO_SOBRE_VENTA.getId(),
            TipoCalculoEnum.DIRECTO_SOBRE_VENTA_CON_REDUCCION_DE_JORNADA.getId()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.INDICADOR_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());

    this.update(this.sqlIndicadorDesplazamientoDirectoVenta, parameters);
  }

  @Override
  public void indicadorDesplazamientoDirectoVentaSinPresencias(@NonNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_CALCULO,
        Arrays.asList(TipoCalculoEnum.DIRECTO_SOBRE_VENTA.getId(),
            TipoCalculoEnum.DIRECTO_SOBRE_VENTA_CON_REDUCCION_DE_JORNADA.getId()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.INDICADOR_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());

    this.update(this.sqlIndicadorDesplazamientoDirectoVentaSinPresencias, parameters);
  }

  @Override
  public void indicadorDesplazamientoBaseDirectoVenta(@NonNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_CALCULO,
        Arrays.asList(TipoCalculoEnum.DIRECTO_SOBRE_VENTA.getId(),
            TipoCalculoEnum.DIRECTO_SOBRE_VENTA_CON_REDUCCION_DE_JORNADA.getId()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.INDICADOR_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO_BASE.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());

    this.update(this.sqlIndicadorDesplazamientoBaseDirectoVenta, parameters);
  }

  @Override
  public void indicadorDesplazamientoBaseDirectoVentaOtraTienda(@NonNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_CALCULO,
        Arrays.asList(TipoCalculoEnum.DIRECTO_SOBRE_VENTA.getId(),
            TipoCalculoEnum.DIRECTO_SOBRE_VENTA_CON_REDUCCION_DE_JORNADA.getId()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.INDICADOR_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO_BASE.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());

    this.update(this.sqlindicadorDesplazamientoBaseDirectoVentaOtraTienda, parameters);
  }

  @Override
  public void indicadorDesplazamientoBaseDirectoVentaSinDesplazamiento(@NonNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_CALCULO,
        Arrays.asList(TipoCalculoEnum.DIRECTO_SOBRE_VENTA.getId(),
            TipoCalculoEnum.DIRECTO_SOBRE_VENTA_CON_REDUCCION_DE_JORNADA.getId()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.INDICADOR_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO_BASE.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());

    this.update(this.sqlIndicadorDesplazamientoBaseDirectoVentaSinDesplazamiento, parameters);
  }

  @Override
  public void indicadorDesplazamientoDirectoVentaCambioFuncion(@NonNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_CALCULO,
        Arrays.asList(TipoCalculoEnum.DIRECTO_SOBRE_VENTA.getId(),
            TipoCalculoEnum.DIRECTO_SOBRE_VENTA_CON_REDUCCION_DE_JORNADA.getId()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.INDICADOR_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());

    this.update(this.sqlIndicadorDesplazamientoDirectoVentaCambioFuncion, parameters);
  }

  @Override
  public void indicadorDesplazamientoChallengeImporteTienda(@NonNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_CALCULO,
        Arrays.asList(TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId(),
            TipoCalculoEnum.CHALLENGE_IMPORTE_SECCION.getId()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.INDICADOR_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO_CHALLENGE_IMPORTE.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());

    this.update(this.sqlIndicadorDesplazamientoChallengeImporteTienda, parameters);
  }

  @Override
  public List<TareaLocalizacionPersonaPresencia> save(final List<TareaLocalizacionPersonaPresencia> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

  @Override
  public void updateActivoPersonasExternas(
      @NonNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_PERSONA_DESACTIVAR_EXTERNOS.getId());
    this.update(this.sqlUpdateActivoPersonasExternas, parameters);
  }

}
