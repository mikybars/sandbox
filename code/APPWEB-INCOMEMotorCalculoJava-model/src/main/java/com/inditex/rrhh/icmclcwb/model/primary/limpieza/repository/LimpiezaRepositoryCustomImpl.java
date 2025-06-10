package com.inditex.rrhh.icmclcwb.model.primary.limpieza.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLimpiezaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionHistoricoRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LimpiezaRepositoryCustomImpl implements LimpiezaRepositoryCustom {

  @Autowired
  @Qualifier("primaryNamedParameterJdbcTemplate")
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Autowired
  private TareaLimpiezaRepositoryCustom tareaLimpiezaRepositoryCustom;

  @Autowired
  private TareaLocalizacionHistoricoRepositoryCustom tareaLocalizacionHistoricoRepositoryCustom;

  @Value("${app.envars.limpieza.days-number:-7}")
  private int daysNumber;

  // Consultas de obtencion de personas
  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaCalculo']}")
  private String sqlPersonasTareaCalculo;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaCalculoAjuste']}")
  private String sqlPersonasTareaCalculoAjuste;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaAmbitoGlobalLocalizacionPersona']}")
  private String sqlPersonasTareaAmbitoGlobalLocalizacionPersona;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaAmbitoGlobalLocalizacionPersonaDesplazamiento']}")
  private String sqlPersonasTareaAmbitoGlobalLocalizacionPersonaDesplazamiento;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaAmbitoGlobalLocalizacionPersonaPresencia']}")
  private String sqlPersonasTareaAmbitoGlobalLocalizacionPersonaPresencia;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaAmbitoGlobalLocalizacionPersonaPresenciaManual']}")
  private String sqlPersonasTareaAmbitoGlobalLocalizacionPersonaPresenciaManual;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaAmbitoGlobalPersona']}")
  private String sqlPersonasTareaAmbitoGlobalPersona;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaLocalizacionPersonaPresencia']}")
  private String sqlPersonasTareaLocalizacionPersonaPresencia;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaLocalizacionPersonaVenta']}")
  private String sqlPersonasTareaLocalizacionPersonaVenta;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaPersonaCoeficiente']}")
  private String sqlPersonasTareaPersonaCoeficiente;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaEstructura']}")
  private String sqlPersonasTareaEstructura;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaEstructuraPolitica']}")
  private String sqlPersonasTareaEstructuraPolitica;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaPersonaHistorico']}")
  private String sqlPersonasTareaPersonaHistorico;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaPersonaExterna']}")
  private String sqlPersonasTareaPersonaExterna;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.personas.tareaCalculoAjusteComision']}")
  private String sqlPersonasTareaCalculoAjusteComision;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.tareaFase']}")
  private String sqlTareaFase;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.tareaFaseAccion']}")
  private String sqlTareaFaseAccion;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.tareaFaseAccionDato']}")
  private String sqlTareaFaseAccionDato;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.trabajo']}")
  private String sqlLimpiezaTrabajo;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.tareaFaseAccionVentaIntegra']}")
  private String sqlTareaFaseAccionVentaIntegra;

  // Consultas de limpieza
  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaCalculo']}")
  private String sqlLimpiezaTareaCalculo;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaCalculoAjuste']}")
  private String sqlLimpiezaTareaCalculoAjuste;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAgrupacionCadena']}")
  private String sqlLimpiezaTareaAgrupacionCadena;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAgrupacionConfiguracion']}")
  private String sqlLimpiezaTareaAgrupacionConfiguracion;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAgrupacionPresencia']}")
  private String sqlLimpiezaTareaAgrupacionPresencia;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAgrupacionVenta']}")
  private String sqlLimpiezaTareaAgrupacionVenta;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAmbitoGlobalLocalizacion']}")
  private String sqlLimpiezaTareaAmbitoGlobalLocalizacion;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAmbitoGlobalLocalizacionPersona']}")
  private String sqlLimpiezaTareaAmbitoGlobalLocalizacionPersona;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAmbitoGlobalLozalizacionPersonaDesplazamiento']}")
  private String sqlLimpiezaTareaAmbitoGlobalLozalizacionPersonaDesplazamiento;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAmbitoGlobalLocalizacionPersonaPresencia']}")
  private String sqlLimpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAmbitoGlobalLocalizacionPersonaPresenciaManual']}")
  private String sqlLimpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAmbitoGlobalPersona']}")
  private String sqlLimpiezaTareaAmbitoGlobalPersona;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAmbitoGlobalFecha']}")
  private String sqlLimpiezaTareaAmbitoGlobalFecha;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionAbierta']}")
  private String sqlLimpiezaTareaLocalizacionAbierta;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionCalcular']}")
  private String sqlLimpiezaTareaLocalizacionCalcular;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionComisionHistorico']}")
  private String sqlLimpiezaTareaLocalizacionComisionHistorico;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionFestivo']}")
  private String sqlLimpiezaTareaLocalizacionFestivo;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionHistorico']}")
  private String sqlLimpiezaTareaLocalizacionHistorico;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionOnlineHistorico']}")
  private String sqlLimpiezaTareaLocalizacionOnlineHistorico;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionPersonaPresencia']}")
  private String sqlLimpiezaTareaLocalizacionPersonaPresencia;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionPersonaVenta']}")
  private String sqlLimpiezaTareaLocalizacionPersonaVenta;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionPresencia']}")
  private String sqlLimpiezaTareaLocalizacionPresencia;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionVenta']}")
  private String sqlLimpiezaTareaLocalizacionVenta;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaPersonaCoeficiente']}")
  private String sqlLimpiezaTareaPersonaCoeficiente;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaEstructura']}")
  private String sqlLimpiezaTareaEstructura;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaEstructuraDesplazamiento']}")
  private String sqlLimpiezaTareaEstructuraDesplazamiento;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaEstructuraPolitica']}")
  private String sqlLimpiezaTareaEstructuraPolitica;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaPersonaHistorico']}")
  private String sqlLimpiezaTareaPersonaHistorico;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaTipoHora']}")
  private String sqlLimpiezaTareaTipoHora;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaConfiguracion']}")
  private String sqlLimpiezaTareaConfiguracion;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionPresupuesto']}")
  private String sqlLimpiezaTareaLocalizacionPresupuesto;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionPresupuestoVenta']}")
  private String sqlLimpiezaTareaLocalizacionPresupuestoVenta;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaConfiguracionChallengeDiasMinimos']}")
  private String sqlLimpiezaTareaConfiguracionChallengeDiasMinimos;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaConfiguracionPrecioHora']}")
  private String sqlLimpiezaTareaConfiguracionPrecioHora;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaAgrupacionConfiguracionChallengeTipoVenta']}")
  private String sqlLimpiezaTareaAgrupacionConfiguracionChallengeTipoVenta;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaLocalizacionPresupuestoTareaPersonaEstructura']}")
  private String sqlTareaLocalizacionPresupuestoTareaPersonaEstructura;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaPersonaExterna']}")
  private String sqlLimpiezaTareaPersonaExterna;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaCalculoAjusteComision']}")
  private String sqlLimpiezaTareaCalculoAjusteComision;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaFase']}")
  private String sqlLimpiezaTareaFase;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaFaseAccion']}")
  private String sqlLimpiezaTareaFaseAccion;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaFaseAccionDato']}")
  private String sqlLimpiezaTareaFaseAccionDato;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.simulacion']}")
  private String sqlLimpiezaSimulacion;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.simulacionCondiciones']}")
  private String sqlLimpiezaSimulacionCondiciones;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.simulacionLocalizacionBandaExcepcion']}")
  private String sqlLimpiezaSimulacionLocalizacionBandaExcepcion;

  @Value("#{limpiezaPrimaryQuery['LimpiezaRepositoryCustom.limpieza.tareaFaseAccionVentaIntegra']}")
  private String sqlLimpiezaTareaFaseAccionVentaIntegra;

  @Value("${app.envars.limpieza.batch-size.default:1}")
  private int batchSize;

  @Override
  public void limpieza(@NotNull @Valid final TareaDto tarea, @NotNull @Valid final TareaAmbitoDto ambito,
      @NotNull @Valid final TrabajoDTO trabajo) {

    final List<MapSqlParameterSource> cclIdCodOrigenBatchArgs = this.getParametersLocal(tarea, ambito);
    final List<MapSqlParameterSource> stdIdWorkLocatBatchArgs = this.getParametersMeta4(tarea, ambito);
    final List<MapSqlParameterSource> idTareaBatchArgs = this.getParametersTarea(tarea);

    final List<MapSqlParameterSource> parametersPersonaTareaCalculo = this.getParametersPersonaLocalStdOrPeriod(
        tarea,
        this.sqlPersonasTareaCalculo);
    for (final List<MapSqlParameterSource> iter : StreamUtils.partition(parametersPersonaTareaCalculo,
        this.batchSize)) {
      this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaCalculo,
          iter.toArray(new MapSqlParameterSource[0]));
    }

    this.limpiezaTareaCalculoAjusteComision(tarea);

    if (trabajo.getIdSimulacion() != null) {
      this.updateTrabajo(tarea);
      this.deleteSimulacionCondiciones(trabajo.getIdSimulacion());
      this.deleteSimulacionLocalizacionBandaExcepcion(trabajo.getIdSimulacion());
      this.deleteSimulacion(trabajo.getIdSimulacion());
    }

    final List<MapSqlParameterSource> parametersPersonaTareaCalculoAjuste = this
        .getParametersPersonaLocalStdOrPeriod(tarea,
            this.sqlPersonasTareaCalculoAjuste);
    for (final List<MapSqlParameterSource> iter : StreamUtils.partition(parametersPersonaTareaCalculoAjuste,
        this.batchSize)) {
      this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaCalculoAjuste,
          iter.toArray(new MapSqlParameterSource[0]));
    }

    this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaAgrupacionCadena,
        idTareaBatchArgs.toArray(new MapSqlParameterSource[0]));

    this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaAgrupacionConfiguracion,
        idTareaBatchArgs.toArray(new MapSqlParameterSource[0]));

    this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaAgrupacionPresencia,
        idTareaBatchArgs.toArray(new MapSqlParameterSource[0]));

    this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaAgrupacionVenta,
        idTareaBatchArgs.toArray(new MapSqlParameterSource[0]));

    this.namedParameterJdbcTemplate.batchUpdate(this.sqlTareaLocalizacionPresupuestoTareaPersonaEstructura,
        idTareaBatchArgs.toArray(new MapSqlParameterSource[0]));

    this.limpiezaTareaAmbitoLocalizacion(stdIdWorkLocatBatchArgs);

    this.limpiezaTareaGlobalLocalizacionPersona(tarea);

    this.limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(tarea);

    this.limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(tarea);

    this.limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(tarea);

    this.limpiezaTareaAmbitoGlobalPersona(tarea);

    this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaAmbitoGlobalFecha,
        idTareaBatchArgs.toArray(new MapSqlParameterSource[0]));

    this.limpiezaTareaPersonaExterna(tarea);

    for (final List<MapSqlParameterSource> iter : StreamUtils.partition(cclIdCodOrigenBatchArgs, this.batchSize)) {
      this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaLocalizacionAbierta,
          iter.toArray(new MapSqlParameterSource[0]));
    }

    for (final List<MapSqlParameterSource> iter : StreamUtils.partition(stdIdWorkLocatBatchArgs, this.batchSize)) {
      this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaLocalizacionCalcular,
          iter.toArray(new MapSqlParameterSource[0]));
    }

    for (final List<MapSqlParameterSource> iter : StreamUtils.partition(stdIdWorkLocatBatchArgs, this.batchSize)) {
      this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaLocalizacionComisionHistorico,
          iter.toArray(new MapSqlParameterSource[0]));
    }

    for (final List<MapSqlParameterSource> iter : StreamUtils.partition(cclIdCodOrigenBatchArgs, this.batchSize)) {
      this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaLocalizacionFestivo,
          iter.toArray(new MapSqlParameterSource[0]));
    }

    this.limpiezaTareaLocalizacionHistorico(tarea);

    this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaLocalizacionOnlineHistorico,
        idTareaBatchArgs.toArray(new MapSqlParameterSource[0]));

    final List<MapSqlParameterSource> parametersPersonaTareaLocalizaconPersonaPresencia = this
        .getParametersPersonaLocal(tarea,
            this.sqlPersonasTareaLocalizacionPersonaPresencia);
    for (final List<MapSqlParameterSource> iter : StreamUtils.partition(
        parametersPersonaTareaLocalizaconPersonaPresencia,
        this.batchSize)) {
      this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaLocalizacionPersonaPresencia,
          iter.toArray(new MapSqlParameterSource[0]));
    }

    final List<MapSqlParameterSource> parametersPersonaTareaLocalizaconPersonaVenta = this
        .getParametersPersonaLocal(tarea,
            this.sqlPersonasTareaLocalizacionPersonaVenta);
    for (final List<MapSqlParameterSource> iter : StreamUtils.partition(
        parametersPersonaTareaLocalizaconPersonaVenta,
        this.batchSize)) {
      this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaLocalizacionPersonaVenta,
          iter.toArray(new MapSqlParameterSource[0]));
    }

    for (final List<MapSqlParameterSource> iter : StreamUtils.partition(cclIdCodOrigenBatchArgs, this.batchSize)) {
      this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaLocalizacionPresencia,
          iter.toArray(new MapSqlParameterSource[0]));
    }

    for (final List<MapSqlParameterSource> iter : StreamUtils.partition(cclIdCodOrigenBatchArgs, this.batchSize)) {
      this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaLocalizacionVenta,
          iter.toArray(new MapSqlParameterSource[0]));
    }

    final List<MapSqlParameterSource> parametersPersonaTareaPersonaCoeficiente = this
        .getParametersPersonaLocalStdOrPeriod(
            tarea, this.sqlPersonasTareaPersonaCoeficiente);
    for (final List<MapSqlParameterSource> iter : StreamUtils.partition(parametersPersonaTareaPersonaCoeficiente,
        this.batchSize)) {
      this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaPersonaCoeficiente,
          iter.toArray(new MapSqlParameterSource[0]));
    }

    final List<MapSqlParameterSource> parametersPersonaTareaEstructura = this.getParametersPersonaLocalStdOrPeriod(
        tarea,
        this.sqlPersonasTareaEstructura);
    for (final List<MapSqlParameterSource> iter : StreamUtils.partition(parametersPersonaTareaEstructura,
        this.batchSize)) {
      this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaEstructura,
          iter.toArray(new MapSqlParameterSource[0]));
    }

    this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaEstructuraDesplazamiento,
        idTareaBatchArgs.toArray(new MapSqlParameterSource[0]));

    final List<MapSqlParameterSource> parametersPersonaTareaEstructuraPolitica = this
        .getParametersPersonaLocalStdOrPeriod(
            tarea, this.sqlPersonasTareaEstructuraPolitica);
    for (final List<MapSqlParameterSource> iter : StreamUtils.partition(parametersPersonaTareaEstructuraPolitica,
        this.batchSize)) {
      this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaEstructuraPolitica,
          iter.toArray(new MapSqlParameterSource[0]));
    }

    this.limpiezaTareaPersonaHistorico(tarea);

    this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaTipoHora,
        idTareaBatchArgs.toArray(new MapSqlParameterSource[0]));

    this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaConfiguracion,
        idTareaBatchArgs.toArray(new MapSqlParameterSource[0]));

    this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaLocalizacionPresupuesto,
        idTareaBatchArgs.toArray(new MapSqlParameterSource[0]));

    for (final List<MapSqlParameterSource> iter : StreamUtils.partition(cclIdCodOrigenBatchArgs, this.batchSize)) {
      this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaLocalizacionPresupuestoVenta,
          iter.toArray(new MapSqlParameterSource[0]));
    }

    this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaConfiguracionChallengeDiasMinimos,
        idTareaBatchArgs.toArray(new MapSqlParameterSource[0]));

    this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaConfiguracionPrecioHora,
        idTareaBatchArgs.toArray(new MapSqlParameterSource[0]));

    this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaAgrupacionConfiguracionChallengeTipoVenta,
        idTareaBatchArgs.toArray(new MapSqlParameterSource[0]));

  }

  @Override
  public void limpiezaTareaProfunda(
      @NotNull @Valid final TareaDto tarea,
      @NotNull @Valid final TareaAmbitoDto ambito,
      @NotNull @Valid final TrabajoDTO trabajo) {

    this.limpieza(tarea, ambito, trabajo);

    final List<MapSqlParameterSource> idTareaBatchArgs = this.getParametersTarea(tarea);

    // Limpieza tabla TAREA_FASE_ACCION_VENTA_INTEGRA
    this.limpiezaTareaFaseAccionVentaIntegra(tarea);
    // Limpieza tabla TAREA_FASE_ACCION_DATO
    this.limpiezaTareaFaseAccionDato(tarea);
    // Limpieza tabla TAREA_FASE_ACCION
    this.limpiezaTareaFaseAccion(tarea);
    // Limpieza tabla TAREA_FASE
    this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaFase,
        idTareaBatchArgs.toArray(new MapSqlParameterSource[0]));
  }

  protected void limpiezaTareaCalculoAjusteComision(@NotNull @Valid final TareaDto tarea) {
    final List<MapSqlParameterSource> parametersPersonaTareaCalculoAjusteComision = this
        .getParametersPersonaLocalStdOrPeriod(tarea,
            this.sqlPersonasTareaCalculoAjusteComision);
    for (final List<MapSqlParameterSource> iter : StreamUtils.partition(parametersPersonaTareaCalculoAjusteComision,
        this.batchSize)) {
      this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaCalculoAjusteComision,
          iter.toArray(new MapSqlParameterSource[0]));
    }
  }

  protected void limpiezaTareaFaseAccionDato(@NotNull @Valid final TareaDto tarea) {
    final List<MapSqlParameterSource> parametersTareaFaseAccionDato = this
        .getParametersTareaFaseAccionDato(tarea,
            this.sqlTareaFaseAccionDato);
    for (final List<MapSqlParameterSource> iter : StreamUtils.partition(parametersTareaFaseAccionDato,
        this.batchSize)) {
      this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaFaseAccionDato,
          iter.toArray(new MapSqlParameterSource[0]));
    }
  }

  protected void limpiezaTareaFaseAccionVentaIntegra(@NotNull @Valid final TareaDto tarea) {
    final List<MapSqlParameterSource> parametersTareaFaseAccionVentaIntegra = this
        .getParametersTareaFaseAccionDato(tarea,
            this.sqlTareaFaseAccionVentaIntegra);
    for (final List<MapSqlParameterSource> iter : StreamUtils.partition(parametersTareaFaseAccionVentaIntegra,
        this.batchSize)) {
      this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaFaseAccionVentaIntegra,
          iter.toArray(new MapSqlParameterSource[0]));
    }
  }

  protected void limpiezaTareaFaseAccion(@NotNull @Valid final TareaDto tarea) {
    final List<MapSqlParameterSource> parametersTareaFaseAccion = this
        .getParametersTareaFaseAccion(tarea,
            this.sqlTareaFaseAccion);
    for (final List<MapSqlParameterSource> iter : StreamUtils.partition(parametersTareaFaseAccion,
        this.batchSize)) {
      this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaFaseAccion,
          iter.toArray(new MapSqlParameterSource[0]));
    }
  }

  protected void updateTrabajo(@NotNull final TareaDto tarea) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TRABAJO, tarea.getIdTrabajo());
    this.namedParameterJdbcTemplate.update(this.sqlLimpiezaTrabajo, params);
  }

  protected void deleteSimulacion(@NotNull final Long idSimulacion) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SIMULACION, idSimulacion);
    this.namedParameterJdbcTemplate.update(this.sqlLimpiezaSimulacion, params);
  }

  protected void deleteSimulacionCondiciones(@NotNull final Long idSimulacion) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SIMULACION, idSimulacion);
    this.namedParameterJdbcTemplate.update(this.sqlLimpiezaSimulacionCondiciones, params);
  }

  protected void deleteSimulacionLocalizacionBandaExcepcion(@NotNull final Long idSimulacion) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SIMULACION, idSimulacion);
    this.namedParameterJdbcTemplate.update(this.sqlLimpiezaSimulacionLocalizacionBandaExcepcion, params);
  }

  @Override
  public void limpiezaTareaPersonaHistorico(@NotNull @Valid final TareaDto tarea) {
    final List<MapSqlParameterSource> parametersPersonaTareaPersonaHistorico = this
        .getParametersPersonaLocalStdOrPeriod(tarea,
            this.sqlPersonasTareaPersonaHistorico);
    for (final List<MapSqlParameterSource> iter : StreamUtils.partition(parametersPersonaTareaPersonaHistorico,
        this.batchSize)) {
      this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaPersonaHistorico,
          iter.toArray(new MapSqlParameterSource[0]));
    }
  }

  @Override
  public void limpiezaTareaLocalizacionHistorico(@NotNull @Valid final TareaDto tarea) {
    final List<MapSqlParameterSource> idTareaBatchArgs = this.getParametersTarea(tarea);
    this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaLocalizacionHistorico,
        idTareaBatchArgs.toArray(new MapSqlParameterSource[0]));
  }

  @Override
  public void limpiezaTareaGlobalLocalizacionPersona(@NotNull @Valid final TareaDto tarea) {
    final List<MapSqlParameterSource> parametersPersonaTareaAmbitoGlobalLocalizacionPersona = this
        .getParametersPersonaLocal(
            tarea, this.sqlPersonasTareaAmbitoGlobalLocalizacionPersona);
    for (final List<MapSqlParameterSource> iter : StreamUtils
        .partition(parametersPersonaTareaAmbitoGlobalLocalizacionPersona, this.batchSize)) {
      this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaAmbitoGlobalLocalizacionPersona,
          iter.toArray(new MapSqlParameterSource[0]));
    }
  }

  @Override
  public void limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(@NotNull @Valid final TareaDto tarea) {
    final List<MapSqlParameterSource> parametersPersonaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento = this
        .getParametersPersonaLocal(
            tarea, this.sqlPersonasTareaAmbitoGlobalLocalizacionPersonaDesplazamiento);
    for (final List<MapSqlParameterSource> iter : StreamUtils
        .partition(parametersPersonaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento, this.batchSize)) {
      this.namedParameterJdbcTemplate.batchUpdate(
          this.sqlLimpiezaTareaAmbitoGlobalLozalizacionPersonaDesplazamiento,
          iter.toArray(new MapSqlParameterSource[0]));
    }
  }

  @Override
  public void limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(@NotNull @Valid final TareaDto tarea) {
    final List<MapSqlParameterSource> parametersPersonaTareaAmbitoGlobalLocalizacionPersonaPresencia = this
        .getParametersPersonaLocal(
            tarea, this.sqlPersonasTareaAmbitoGlobalLocalizacionPersonaPresencia);
    for (final List<MapSqlParameterSource> iter : StreamUtils
        .partition(parametersPersonaTareaAmbitoGlobalLocalizacionPersonaPresencia, this.batchSize)) {
      this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia,
          iter.toArray(new MapSqlParameterSource[0]));
    }
  }

  @Override
  public void limpiezaTareaAmbitoLocalizacion(@NotNull @Valid final TareaDto tarea,
      @NotNull @Valid final TareaAmbitoDto ambito) {
    final List<MapSqlParameterSource> stdIdWorkLocatBatchArgs = this.getParametersMeta4(tarea, ambito);
    this.limpiezaTareaAmbitoLocalizacion(stdIdWorkLocatBatchArgs);
  }

  private void limpiezaTareaAmbitoLocalizacion(final List<MapSqlParameterSource> stdIdWorkLocatBatchArgs) {
    for (final List<MapSqlParameterSource> iter : StreamUtils.partition(stdIdWorkLocatBatchArgs, this.batchSize)) {
      this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaAmbitoGlobalLocalizacion,
          iter.toArray(new MapSqlParameterSource[0]));
    }
  }

  @Override
  public void limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(@NotNull @Valid final TareaDto tarea) {
    final List<MapSqlParameterSource> parametersPersonaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual = this
        .getParametersPersonaLocal(
            tarea, this.sqlPersonasTareaAmbitoGlobalLocalizacionPersonaPresenciaManual);
    for (final List<MapSqlParameterSource> iter : StreamUtils
        .partition(parametersPersonaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual, this.batchSize)) {
      this.namedParameterJdbcTemplate.batchUpdate(
          this.sqlLimpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual,
          iter.toArray(new MapSqlParameterSource[0]));
    }
  }

  @Override
  public void limpiezaTareaAmbitoGlobalPersona(@NotNull @Valid final TareaDto tarea) {
    final List<MapSqlParameterSource> parametersPersonaTareaAmbitoGlobalPersona = this.getParametersPersonaLocal(
        tarea,
        this.sqlPersonasTareaAmbitoGlobalPersona);
    for (final List<MapSqlParameterSource> iter : StreamUtils.partition(parametersPersonaTareaAmbitoGlobalPersona,
        this.batchSize)) {
      this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaAmbitoGlobalPersona,
          iter.toArray(new MapSqlParameterSource[0]));
    }
  }

  @Override
  public void limpiezaTareaPersonaExterna(
      @NotNull @Valid final TareaDto tarea) {
    final List<MapSqlParameterSource> parametersPersonaTareaPersonaExterna = this.getParametersPersonaLocal(tarea,
        this.sqlPersonasTareaPersonaExterna);
    for (final List<MapSqlParameterSource> iter : StreamUtils.partition(parametersPersonaTareaPersonaExterna,
        this.batchSize)) {
      this.namedParameterJdbcTemplate.batchUpdate(this.sqlLimpiezaTareaPersonaExterna,
          iter.toArray(new MapSqlParameterSource[0]));
    }
  }

  @Override
  public void updateEstado(
      @NotNull @Positive final Long idTareaLimpieza,
      @NotNull @Valid final EstadoLimpiezaDto estado) {
    this.tareaLimpiezaRepositoryCustom.updateEstado(idTareaLimpieza, estado);
  }

  @Override
  public void updateFechaFinalizacion(
      @NotNull @Positive final Long idTareaLimpieza) {
    this.tareaLimpiezaRepositoryCustom.updateFechaFinalizacion(idTareaLimpieza);
  }

  @Override
  public void inicioLimpieza(
      @NotNull @Positive final Long idTareaLimpieza) {
    this.tareaLimpiezaRepositoryCustom.inicioLimpieza(idTareaLimpieza);
  }

  private List<MapSqlParameterSource> getParametersLocal(final TareaDto tarea, final TareaAmbitoDto ambito) {
    final List<String> tiendas = this.tareaLocalizacionHistoricoRepositoryCustom
        .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbitoLocalizacion(tarea.getId(),
            ambito.getCclIdOrigen())
        .stream()
        .map(IdLocalizacionLocalDto::getId)
        .collect(Collectors.toList());
    final List<MapSqlParameterSource> batchArgs = new ArrayList<>();

    tiendas.forEach(tienda -> {
      final Map<String, Object> map = new HashMap<>();
      map.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
      map.put(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO,
          TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
      map.put(SqlPrimaryConstants.SQL_PARAM_CCL_ID_COD_ORIGEN, tienda);
      final MapSqlParameterSource arg = new MapSqlParameterSource();
      map.forEach(arg::addValue);
      batchArgs.add(arg);
    });
    return batchArgs;
  }

  private List<MapSqlParameterSource> getParametersMeta4(final TareaDto tarea, final TareaAmbitoDto ambito) {
    final List<String> tiendas = this.tareaLocalizacionHistoricoRepositoryCustom
        .findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbitoLocalizacion(tarea.getId(),
            ambito.getCclIdOrigen())
        .stream()
        .map(IdLocalizacionDto::getId)
        .collect(Collectors.toList());
    final List<MapSqlParameterSource> batchArgs = new ArrayList<>();

    tiendas.forEach(tienda -> {
      final Map<String, Object> map = new HashMap<>();
      map.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
      map.put(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO,
          TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
      map.put(SqlPrimaryConstants.SQL_PARAM_STD_ID_WORK_LOCAT, tienda);
      final MapSqlParameterSource arg = new MapSqlParameterSource();
      map.forEach(arg::addValue);
      batchArgs.add(arg);
    });
    return batchArgs;
  }

  private List<MapSqlParameterSource> getParametersTarea(final TareaDto tarea) {
    final List<MapSqlParameterSource> batchArgs = new ArrayList<>();
    final Map<String, Object> map = new HashMap<>();
    if (tarea != null) {
      map.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
      map.put(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO,
          TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    }
    final MapSqlParameterSource arg = new MapSqlParameterSource();
    map.forEach(arg::addValue);
    batchArgs.add(arg);
    return batchArgs;
  }

  private List<MapSqlParameterSource> getParametersPersonaLocal(final TareaDto tarea, final String sql) {
    final List<MapSqlParameterSource> batchArgs = new ArrayList<>();
    final List<IdPersonaLocalDto> personas = this.findIdPersonaByIdTarea(tarea, sql);
    personas.forEach(persona -> {
      final Map<String, Object> map = new HashMap<>();
      map.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
      map.put(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON, persona.getIdPersonaLocal());
      map.put(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO,
          TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
      final MapSqlParameterSource arg = new MapSqlParameterSource();
      map.forEach(arg::addValue);
      batchArgs.add(arg);
    });
    return batchArgs;
  }

  private List<MapSqlParameterSource> getParametersPersonaLocalStdOrPeriod(final TareaDto tarea, final String sql) {
    final List<MapSqlParameterSource> batchArgs = new ArrayList<>();
    final List<IdPersonaLocalDto> personas = this.findIdPersonaStdOrPeriodByIdTarea(tarea, sql);
    personas.forEach(persona -> {
      final Map<String, Object> map = new HashMap<>();
      map.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
      map.put(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON, persona.getIdPersonaLocal());
      map.put(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD, persona.getStdOrHrPeriod());
      map.put(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO,
          TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
      final MapSqlParameterSource arg = new MapSqlParameterSource();
      map.forEach(arg::addValue);
      batchArgs.add(arg);
    });
    return batchArgs;
  }

  private List<MapSqlParameterSource> getParametersTareaFaseAccionDato(final TareaDto tarea, final String sql) {
    final List<MapSqlParameterSource> batchArgs = new ArrayList<>();
    final List<IdTareaFaseAccionDto> tareaFaseAccionDtos = this.findIdsTareaFaseAccion(tarea, sql);
    tareaFaseAccionDtos.forEach(tareaFaseAccionDto -> {
      final Map<String, Object> map = new HashMap<>();
      map.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE_ACCION, tareaFaseAccionDto.getIdTareaFaseAccion());
      final MapSqlParameterSource arg = new MapSqlParameterSource();
      map.forEach(arg::addValue);
      batchArgs.add(arg);
    });
    return batchArgs;
  }

  private List<MapSqlParameterSource> getParametersTareaFaseAccion(final TareaDto tarea, final String sql) {
    final List<org.springframework.jdbc.core.namedparam.MapSqlParameterSource> batchArgs = new ArrayList<>();
    final List<IdTareaFaseDto> tareaFaseDtos = this.findIdsTareaFase(tarea, sql);
    tareaFaseDtos.forEach(tareaFaseDto -> {
      final Map<String, Object> map = new HashMap<>();
      map.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE, tareaFaseDto.getIdTareaFase());
      final org.springframework.jdbc.core.namedparam.MapSqlParameterSource arg =
          new org.springframework.jdbc.core.namedparam.MapSqlParameterSource();
      map.forEach(arg::addValue);
      batchArgs.add(arg);
    });
    return batchArgs;
  }

  private List<IdPersonaLocalDto> findIdPersonaByIdTarea(final TareaDto tarea, final String sql) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO,
        TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    return this.namedParameterJdbcTemplate.query(sql, parameters, (rs, rowNum) -> IdPersonaLocalDto
        .builder()
        .idPersonaLocal(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA_LOCAL))
        .build());
  }

  private List<IdPersonaLocalDto> findIdPersonaStdOrPeriodByIdTarea(final TareaDto tarea, final String sql) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO,
        TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    return this.namedParameterJdbcTemplate.query(sql, parameters, (rs, rowNum) -> IdPersonaLocalDto
        .builder()
        .idPersonaLocal(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA_LOCAL))
        .stdOrHrPeriod(rs.getString(SqlPrimaryConstants.SQL_RESULT_OR_PERSONA))
        .build());
  }

  private List<IdTareaFaseAccionDto> findIdsTareaFaseAccion(final TareaDto tarea, final String sql) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    return this.namedParameterJdbcTemplate.query(sql, parameters,
        (rs, rowNum) -> IdTareaFaseAccionDto.builder().idTareaFaseAccion(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_TAREA_FASE_ACCION))
            .build());
  }

  private List<IdTareaFaseDto> findIdsTareaFase(final TareaDto tarea, final String sql) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    return this.namedParameterJdbcTemplate.query(sql, parameters, (rs, rowNum) -> IdTareaFaseDto.builder()
        .idTareaFase(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_TAREA_FASE))
        .build());
  }

}
