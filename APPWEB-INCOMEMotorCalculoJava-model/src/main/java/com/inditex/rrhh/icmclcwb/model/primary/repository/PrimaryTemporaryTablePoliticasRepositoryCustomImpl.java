package com.inditex.rrhh.icmclcwb.model.primary.repository;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoAusenciaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoUnidadTiempoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PrimaryTemporaryTablePoliticasRepositoryCustomImpl
    implements PrimaryTemporaryTablePoliticasRepositoryCustom {

  @Autowired
  @Qualifier("primaryJdbcTemplate")
  private JdbcTemplate jdbcTemplate;

  @Autowired
  @Qualifier("primaryNamedParameterJdbcTemplate")
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  // Comun

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempPersonas']}")
  private String sqlCreateTempPersonas;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempPersonas']}")
  private String sqlDeleteTempPersonas;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempPersonas']}")
  private String sqlInsertTempPersonas;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempPersonasBajaIt']}")
  private String sqlInsertTempPersonasBajaIt;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempPersonas']}")
  private String sqlIndexTempPersonas;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempCalculoConAjuste']}")
  private String sqlCreateTempCalculoConAjuste;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempCalculoConAjuste']}")
  private String sqlDeleteTempCalculoConAjuste;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoConAjuste']}")
  private String sqlInsertTempCalculoConAjuste;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoConAjusteBajaIt']}")
  private String sqlInsertTempCalculoConAjusteBajaIt;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempCalculoConAjuste']}")
  private String sqlIndexTempCalculoConAjuste;

  // Baja it

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempFechasBajaIt']}")
  private String sqlCreateTempFechasBajaIt;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasBajaIt']}")
  private String sqlDeleteTempFechasBajaIt;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasBajaIt']}")
  private String sqlInsertTempFechasBajaIt;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempFechasBajaIt']}")
  private String sqlIndexTempFechasBajaIt;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAcumuladasBajaIt']}")
  private String sqlCreateTempFechasAcumuladasBajaIt;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAcumuladasBajaIt']}")
  private String sqlDeleteTempFechasAcumuladasBajaIt;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasBajaIt']}")
  private String sqlInsertTempFechasAcumuladasBajaIt;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempFechasAcumuladasBajaIt']}")
  private String sqlIndexTempFechasAcumuladasBajaIt;

  // Antiguedad

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAntiguedad']}")
  private String sqlCreateTempFechasAntiguedad;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAntiguedad']}")
  private String sqlDeleteTempFechasAntiguedad;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAntiguedad']}")
  private String sqlInsertTempFechasAntiguedad;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempFechasAntiguedad']}")
  private String sqlIndexTempFechasAntiguedad;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAcumuladasAntiguedad']}")
  private String sqlCreateTempFechasAcumuladasAntiguedad;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAcumuladasAntiguedad']}")
  private String sqlDeleteTempFechasAcumuladasAntiguedad;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasAntiguedad']}")
  private String sqlInsertTempFechasAcumuladasAntiguedad;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempFechasAcumuladasAntiguedad']}")
  private String sqlIndexTempFechasAcumuladasAntiguedad;

  // Vacaciones

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempFechasVacaciones']}")
  private String sqlCreateTempFechasVacaciones;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasVacaciones']}")
  private String sqlDeleteTempFechasVacaciones;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasVacaciones']}")
  private String sqlInsertTempFechasVacaciones;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempFechasVacaciones']}")
  private String sqlIndexTempFechasVacaciones;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAcumuladasVacaciones']}")
  private String sqlCreateTempFechasAcumuladasVacaciones;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAcumuladasVacaciones']}")
  private String sqlDeleteTempFechasAcumuladasVacaciones;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasVacaciones']}")
  private String sqlInsertTempFechasAcumuladasVacaciones;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempFechasAcumuladasVacaciones']}")
  private String sqlIndexTempFechasAcumuladasVacaciones;

  // Máixmo/Mínimo garantizado

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempAusenciasDateMaximoMinimoGarantizado']}")
  private String sqlCreateTempAusenciasDateMaximoMinimoGarantizado;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempAusenciasDateMaximoMinimoGarantizado']}")
  private String sqlDeleteTempAusenciasDateMaximoMinimoGarantizado;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempAusenciasDateMaximoMinimoGarantizado']}")
  private String sqlInsertTempAusenciasDateMaximoMinimoGarantizado;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempAusenciasDateMaximoMinimoGarantizado']}")
  private String sqlIndexTempAusenciasDateMaximoMinimoGarantizado;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempDatosMaximoMinimoGarantizado']}")
  private String sqlCreateTempDatosMaximoMinimoGarantizado;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempDatosMaximoMinimoGarantizado']}")
  private String sqlDeleteTempDatosMaximoMinimoGarantizado;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempDatosMaximoMinimoGarantizado']}")
  private String sqlIndexTempDatosMaximoMinimoGarantizado;

  // Máximo garantizado

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempDatosMaximoGarantizado']}")
  private String sqlInsertTempDatosMaximoGarantizado;

  // Mínimo garantizado

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempDatosMinimoGarantizado']}")
  private String sqlInsertTempDatosMinimoGarantizado;

  // Carencia

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempFechasCarencia']}")
  private String sqlCreateTempFechasCarencia;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasCarencia']}")
  private String sqlDeleteTempFechasCarencia;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasCarencia']}")
  private String sqlInsertTempFechasCarencia;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempFechasCarencia']}")
  private String sqlIndexTempFechasCarencia;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.createTempFechasAcumuladasCarencia']}")
  private String sqlCreateTempFechasAcumuladasCarencia;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.deleteTempFechasAcumuladasCarencia']}")
  private String sqlDeleteTempFechasAcumuladasCarencia;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempFechasAcumuladasCarencia']}")
  private String sqlInsertTempFechasAcumuladasCarencia;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.indexTempFechasAcumuladasCarencia']}")
  private String sqlIndexTempFechasAcumuladasCarencia;

  @Value("#{primaryQuery['PrimaryTemporaryTablePoliticasRepositoryCustom.insertTempCalculoTotalizadoCarencia']}")
  private String sqlInsertTempCalculoTotalizadoCarencia;

  @Override
  public int createTempPersonas() {
    return this.jdbcTemplate.update(this.sqlCreateTempPersonas);
  }

  @Override
  public int deleteTempPersonas() {
    return this.jdbcTemplate.update(this.sqlDeleteTempPersonas);
  }

  @Override
  public void insertTempPersonas(final TareaDto tarea,
      final List<IdPersonaLocalDto> personas,
      final TipoPoliticaEnum tipoPolitica) {
    final List<MapSqlParameterSource> batchArgs = new ArrayList<>();
    personas.forEach(persona -> {
      final MapSqlParameterSource arg = new MapSqlParameterSource();
      arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
      arg.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON, persona.getIdPersonaLocal());
      arg.addValue(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD, persona.getStdOrHrPeriod());
      arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA, tipoPolitica.getId());
      batchArgs.add(arg);
    });
    this.namedParameterJdbcTemplate.batchUpdate(this.sqlInsertTempPersonas,
        batchArgs.toArray(new MapSqlParameterSource[0]));
  }

  @Override
  public void insertTempPersonasBajaIt(final TareaDto tarea,
      final List<IdPersonaLocalDto> personas,
      final TipoPoliticaEnum tipoPolitica) {
    final List<MapSqlParameterSource> batchArgs = new ArrayList<>();
    personas.forEach(persona -> {
      final MapSqlParameterSource arg = new MapSqlParameterSource();
      arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
      arg.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON, persona.getIdPersonaLocal());
      arg.addValue(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD, persona.getStdOrHrPeriod());
      arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA, tipoPolitica.getId());
      batchArgs.add(arg);
    });
    this.namedParameterJdbcTemplate.batchUpdate(this.sqlInsertTempPersonasBajaIt,
        batchArgs.toArray(new MapSqlParameterSource[0]));
  }

  @Override
  public int createIndexTempPersonas() {
    return this.jdbcTemplate.update(this.sqlIndexTempPersonas);
  }

  @Override
  public int createTempFechasBajaIt() {
    return this.jdbcTemplate.update(this.sqlCreateTempFechasBajaIt);
  }

  @Override
  public int deleteTempFechasBajaIt() {
    return this.jdbcTemplate.update(this.sqlDeleteTempFechasBajaIt);
  }

  @Override
  public int createTempCalculoConAjuste() {
    return this.jdbcTemplate.update(this.sqlCreateTempCalculoConAjuste);
  }

  @Override
  public int deleteTempCalculoConAjuste() {
    return this.jdbcTemplate.update(this.sqlDeleteTempCalculoConAjuste);
  }

  @Override
  public void insertTempCalculoConAjuste(final List<TipoPoliticaEnum> politicas) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE,
        politicas.stream().map(TipoPoliticaEnum::getIdMeta4).collect(Collectors.toList()));
    this.namedParameterJdbcTemplate.update(this.sqlInsertTempCalculoConAjuste, params);
  }

  @Override
  public void insertTempCalculoConAjusteBajaIt(final List<TipoPoliticaEnum> politicas) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA_AJUSTE,
        politicas.stream().map(TipoPoliticaEnum::getIdMeta4).collect(Collectors.toList()));
    this.namedParameterJdbcTemplate.update(this.sqlInsertTempCalculoConAjusteBajaIt, params);
  }

  @Override
  public int createIndexTempCalculoConAjuste() {
    return this.jdbcTemplate.update(this.sqlIndexTempCalculoConAjuste);
  }

  @Override
  public int createIndexTempFechasBajaIt() {
    return this.jdbcTemplate.update(this.sqlIndexTempFechasBajaIt);
  }

  @Override
  public void insertTempFechasBajaIt(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS, TipoUnidadTiempoEnum.ANOS.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES, TipoUnidadTiempoEnum.MESES.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS, TipoUnidadTiempoEnum.SEMANAS.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS, TipoUnidadTiempoEnum.DIAS.getId());

    this.namedParameterJdbcTemplate.update(this.sqlInsertTempFechasBajaIt, map);
  }

  @Override
  public int createTempFechasAcumuladasBajaIt() {
    return this.jdbcTemplate.update(this.sqlCreateTempFechasAcumuladasBajaIt);
  }

  @Override
  public int deleteTempFechasAcumuladasBajaIt() {
    return this.jdbcTemplate.update(this.sqlDeleteTempFechasAcumuladasBajaIt);
  }

  @Override
  public void insertTempFechasAcumuladasBajaIt() {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS, TipoUnidadTiempoEnum.ANOS.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES, TipoUnidadTiempoEnum.MESES.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS, TipoUnidadTiempoEnum.SEMANAS.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS, TipoUnidadTiempoEnum.DIAS.getId());

    this.namedParameterJdbcTemplate.update(this.sqlInsertTempFechasAcumuladasBajaIt, map);
  }

  @Override
  public int createIndexTempFechasAcumuladasBajaIt() {
    return this.jdbcTemplate.update(this.sqlIndexTempFechasAcumuladasBajaIt);
  }

  @Override
  public int createTempFechasAntiguedad() {
    return this.jdbcTemplate.update(this.sqlCreateTempFechasAntiguedad);
  }

  @Override
  public int deleteTempFechasAntiguedad() {
    return this.jdbcTemplate.update(this.sqlDeleteTempFechasAntiguedad);
  }

  @Override
  public void insertTempFechasAntiguedad() {
    final MapSqlParameterSource map = new MapSqlParameterSource();

    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS, TipoUnidadTiempoEnum.ANOS.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES, TipoUnidadTiempoEnum.MESES.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS, TipoUnidadTiempoEnum.SEMANAS.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS, TipoUnidadTiempoEnum.DIAS.getId());

    this.namedParameterJdbcTemplate.update(this.sqlInsertTempFechasAntiguedad, map);
  }

  @Override
  public int createIndexTempFechasAntiguedad() {
    return this.jdbcTemplate.update(this.sqlIndexTempFechasAntiguedad);
  }

  @Override
  public int createTempFechasAcumuladasAntiguedad() {
    return this.jdbcTemplate.update(this.sqlCreateTempFechasAcumuladasAntiguedad);
  }

  @Override
  public int deleteTempFechasAcumuladasAntiguedad() {
    return this.jdbcTemplate.update(this.sqlDeleteTempFechasAcumuladasAntiguedad);
  }

  @Override
  public void insertTempFechasAcumuladasAntiguedad() {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS, TipoUnidadTiempoEnum.ANOS.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES, TipoUnidadTiempoEnum.MESES.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS, TipoUnidadTiempoEnum.SEMANAS.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS, TipoUnidadTiempoEnum.DIAS.getId());

    this.namedParameterJdbcTemplate.update(this.sqlInsertTempFechasAcumuladasAntiguedad, map);
  }

  @Override
  public int createIndexTempFechasAcumuladasAntiguedad() {
    return this.jdbcTemplate.update(this.sqlIndexTempFechasAcumuladasAntiguedad);
  }

  @Override
  public int createTempFechasVacaciones() {
    return this.jdbcTemplate.update(this.sqlCreateTempFechasVacaciones);
  }

  @Override
  public int deleteTempFechasVacaciones() {
    return this.jdbcTemplate.update(this.sqlDeleteTempFechasVacaciones);
  }

  @Override
  public void insertTempFechasVacaciones() {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS, TipoUnidadTiempoEnum.ANOS.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES, TipoUnidadTiempoEnum.MESES.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS, TipoUnidadTiempoEnum.SEMANAS.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS, TipoUnidadTiempoEnum.DIAS.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_AUSENCIA, TipoAusenciaEnum.VACACIONES.getId());

    this.namedParameterJdbcTemplate.update(this.sqlInsertTempFechasVacaciones, map);
  }

  @Override
  public int createIndexTempFechasVacaciones() {
    return this.jdbcTemplate.update(this.sqlIndexTempFechasVacaciones);
  }

  @Override
  public int createTempFechasAcumuladasVacaciones() {
    return this.jdbcTemplate.update(this.sqlCreateTempFechasAcumuladasVacaciones);
  }

  @Override
  public int deleteTempFechasAcumuladasVacaciones() {
    return this.jdbcTemplate.update(this.sqlDeleteTempFechasAcumuladasVacaciones);
  }

  @Override
  public void insertTempFechasAcumuladasVacaciones() {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS, TipoUnidadTiempoEnum.ANOS.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES, TipoUnidadTiempoEnum.MESES.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS, TipoUnidadTiempoEnum.SEMANAS.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS, TipoUnidadTiempoEnum.DIAS.getId());

    this.namedParameterJdbcTemplate.update(this.sqlInsertTempFechasAcumuladasVacaciones, map);
  }

  @Override
  public int createIndexTempFechasAcumuladasVacaciones() {
    return this.jdbcTemplate.update(this.sqlIndexTempFechasAcumuladasVacaciones);
  }

  @Override
  public int createTempAusenciasDateMaximoMinimoGarantizado() {
    return this.jdbcTemplate.update(this.sqlCreateTempAusenciasDateMaximoMinimoGarantizado);
  }

  @Override
  public int deleteTempAusenciasDateMaximoMinimoGarantizado() {
    return this.jdbcTemplate.update(this.sqlDeleteTempAusenciasDateMaximoMinimoGarantizado);
  }

  @Override
  public int createIndexTempAusenciasDateMaximoMinimoGarantizado() {
    return this.jdbcTemplate.update(this.sqlIndexTempAusenciasDateMaximoMinimoGarantizado);
  }

  @Override
  public void insertTempAusenciasDateMaximoMinimoGarantizado() {
    this.jdbcTemplate.update(this.sqlInsertTempAusenciasDateMaximoMinimoGarantizado);
  }

  @Override
  public int createTempDatosMaximoMinimoGarantizado() {
    return this.jdbcTemplate.update(this.sqlCreateTempDatosMaximoMinimoGarantizado);
  }

  @Override
  public int deleteTempDatosMaximoMinimoGarantizado() {
    return this.jdbcTemplate.update(this.sqlDeleteTempDatosMaximoMinimoGarantizado);
  }

  @Override
  public int createIndexTempDatosMaximoMinimoGarantizado() {
    return this.jdbcTemplate.update(this.sqlIndexTempDatosMaximoMinimoGarantizado);
  }

  @Override
  public void insertTempDatosMaximoGarantizado() {
    this.jdbcTemplate.update(this.sqlInsertTempDatosMaximoGarantizado);
  }

  @Override
  public void insertTempDatosMininimoGarantizado() {
    this.jdbcTemplate.update(this.sqlInsertTempDatosMinimoGarantizado);
  }

  @Override
  public int createTempFechasCarencia() {
    return this.jdbcTemplate.update(this.sqlCreateTempFechasCarencia);
  }

  @Override
  public int deleteTempFechasCarencia() {
    return this.jdbcTemplate.update(this.sqlDeleteTempFechasCarencia);
  }

  @Override
  public void insertTempFechasCarencia() {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS, TipoUnidadTiempoEnum.ANOS.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES, TipoUnidadTiempoEnum.MESES.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS, TipoUnidadTiempoEnum.SEMANAS.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS, TipoUnidadTiempoEnum.DIAS.getId());
    this.namedParameterJdbcTemplate.update(this.sqlInsertTempFechasCarencia, map);
  }

  @Override
  public int createIndexTempFechasCarencia() {
    return this.jdbcTemplate.update(this.sqlIndexTempFechasCarencia);
  }

  @Override
  public int createTempFechasAcumuladasCarencia() {
    return this.jdbcTemplate.update(this.sqlCreateTempFechasAcumuladasCarencia);
  }

  @Override
  public int deleteTempFechasAcumuladasCarencia() {
    return this.jdbcTemplate.update(this.sqlDeleteTempFechasAcumuladasCarencia);
  }

  @Override
  public void insertTempFechasAcumuladasCarencia() {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_ANOS, TipoUnidadTiempoEnum.ANOS.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_MESES, TipoUnidadTiempoEnum.MESES.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_SEMANAS, TipoUnidadTiempoEnum.SEMANAS.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_UNIDAD_TIEMPO_DIAS, TipoUnidadTiempoEnum.DIAS.getId());
    this.namedParameterJdbcTemplate.update(this.sqlInsertTempFechasAcumuladasCarencia, map);
  }

  @Override
  public int createIndexTempFechasAcumuladasCarencia() {
    return this.jdbcTemplate.update(this.sqlIndexTempFechasAcumuladasCarencia);
  }

  @Override
  public void insertTempCalculoConAjusteCarencia() {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    this.namedParameterJdbcTemplate.update(this.sqlInsertTempCalculoTotalizadoCarencia, map);
  }

}
