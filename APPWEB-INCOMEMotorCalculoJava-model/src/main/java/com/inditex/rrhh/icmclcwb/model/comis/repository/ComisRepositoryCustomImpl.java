package com.inditex.rrhh.icmclcwb.model.comis.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.ComisClaseEmpleadoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdMotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalComisionManualDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalExternaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalFechaIncidenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlComisConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class ComisRepositoryCustomImpl
    extends JdbcBatchComisRepositoryAbstract<Integer>
    implements ComisRepositoryCustom {

  @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findPresenciasOrigenAndFecha']}")
  private String sqlFindPresenciasOrigenAndFechaQuery;

  @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findMotivosDesplazamiento']}")
  private String sqlFindMotivosDesplazamiento;

  @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findFechasIncidencias']}")
  private String sqlFindFechasIncidencias;

  @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findFechasDesplazamiento']}")
  private String sqlFindFechasDesplazamiento;

  @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findCondicionesHistorico']}")
  private String sqlFindCondicionesHistorico;

  @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findCondicionesHistoricoEs']}")
  private String sqlFindCondicionesHistoricoEs;

  @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findCondicionesDesplazamiento']}")
  private String sqlFindCondicionesDesplazamiento;

  @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findCondicionesDesplazamientoEs']}")
  private String sqlFindCondicionesDesplazamientoEs;

  @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findCondicionesResalta']}")
  private String sqlFindCondicionesResalta;

  @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findCondicionesResaltaSinPrimas']}")
  private String sqlFindCondicionesResaltaSinPrimas;

  @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findCondicionesResaltaEs']}")
  private String sqlFindCondicionesResaltaEs;

  @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findCondicionesPrimas']}")
  private String sqlFindCondicionesPrimas;

  @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findBajasIt']}")
  private String sqlFindBajasIt;

  @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findCarencia']}")
  private String sqlFindCarencia;

  @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findExternosByClase']}")
  private String sqlFindExternosByClase;

  @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findExternosByMinIdPersona']}")
  private String sqlFindExternosByMinIdPersona;

  @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findBajasItEs']}")
  private String sqlFindBajasItEs;

  @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findCondicionesHIstoricoSinChallenge']}")
  private String sqlFindCondicionesHistoricoSinChallenge;

  @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findCondicionesDesplazamientoSinChallenge']}")
  private String sqlFindCondicionesDesplazamientoSinChallenge;

  @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findCondicionesResaltaSinChallenge']}")
  private String sqlFindCondicionesResaltaSinChallenge;

  @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findComisionManual']}")
  private String sqlFindComisionManual;

  @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findPersonas']}")
  private String sqlFindPersonas;

  @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findPersonasSilConEstado']}")
  private String sqlFindPersonasSilConEstado;

  @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findPersonasSilSinEstado']}")
  private String sqlFindPersonasSilSinEstado;

  @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findCondicionesHIstoricoChallengeIncluidoPorcentaje']}")
  private String sqlFindCondicionesHIstoricoChallengeIncluidoPorcentaje;

  @Value("#{comisPrimaryQuery['ComisRepositoryCustom.findCondicionesDesplazamientoChallengeIncluidoPorcentaje']}")
  private String sqlFindCondicionesDesplazamientoChallengeIncluidoPorcentaje;

  @Value("#{comisPrimaryQuery['ComisRepositoryCustom.validateTempComisRecuperarFrancia']}")
  private String sqlValidateTempComisRecuperarFrancia;

  @Autowired
  @Qualifier("fechasProperties")
  private PrevalidarPropertiesDto fechasProperties;

  @Override
  public PresenciaOrigenDto findPresenciasOrigenAndFecha(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_INICIO,
        TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_FIN,
        TimeUtils.toDate(tarea.getFechaFinPeriodo()));

    return this.queryForObject(this.sqlFindPresenciasOrigenAndFechaQuery, map,
        (rs, rowNum) -> PresenciaOrigenDto
            .builder()
            .horasSeccion1(rs.getInt(SqlComisConstants.SQL_RESULT_HORAS_SECCION_1))
            .horasSeccion2(rs.getInt(SqlComisConstants.SQL_RESULT_HORAS_SECCION_2))
            .horasSeccion3(rs.getInt(SqlComisConstants.SQL_RESULT_HORAS_SECCION_3))
            .horasSeccion4(rs.getInt(SqlComisConstants.SQL_RESULT_HORAS_SECCION_4))
            .build());
  }

  @Override
  public List<IdMotivoDesplazamientoDto> findMotivoDesplazamiento(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_ID_ORGANIZATION,
        tarea.getIdOrganization());
    return this.query(this.sqlFindMotivosDesplazamiento, map,
        (rs, rowNum) -> IdMotivoDesplazamientoDto
            .builder()
            .idMotivoDesplazamiento(rs.getInt(SqlComisConstants.SQL_RESULT_ID_MOTIVO_DESPLAZAMIENTO))
            .build());
  }

  @Override
  public List<IdPersonaLocalFechaIncidenciaDto> findFechasIncidencias(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_INICIO, TimeUtils.toDate(tarea
        .getFechaInicioPeriodo()
        .minusMonths(this.fechasProperties.getMeses())));

    return this.query(this.sqlFindFechasIncidencias, map,
        (rs, rowNum) -> IdPersonaLocalFechaIncidenciaDto
            .builder()
            .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
            .fechaInicio(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_INICIO).toLocalDate())
            .fechaFin(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_FIN).toLocalDate())
            .build());
  }

  @Override
  public List<IdPersonaLocalFechaIncidenciaDto> findFechasDesplazamientos(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_INICIO, TimeUtils.toDate(tarea
        .getFechaInicioPeriodo()
        .minusMonths(this.fechasProperties.getMeses())));

    return this.query(this.sqlFindFechasDesplazamiento, map,
        (rs, rowNum) -> IdPersonaLocalFechaIncidenciaDto
            .builder()
            .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
            .fechaInicio(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_DESDE).toLocalDate())
            .fechaFin(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_HASTA).toLocalDate())
            .build());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesHistorico(final TareaDto tarea, final PeriodoDto periodoAmpliado) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE,
        TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA,
        TimeUtils.toDate(tarea.getFechaFinPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE_AMPLIADO,
        TimeUtils.toDate(periodoAmpliado.getFechaInicioPeriodo()));

    return this.query(this.sqlFindCondicionesHistorico, map,
        (rs, rowNum) -> IdPersonaLocalCondicionesDto
            .builder()
            .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
            .fechaDesde(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_DESDE).toLocalDate())
            .fechaHasta(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_HASTA).toLocalDate())
            .cclIdSeccion(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_SECCION))
            .idTipoCalculo(rs.getString(SqlComisConstants.SQL_RESULT_ID_TIPO_CALCULO))
            .porcentaje(rs.getString(SqlComisConstants.SQL_RESULT_PORCENTAJE))
            .banda(rs.getString(SqlComisConstants.SQL_RESULT_BANDA))
            .importe(rs.getString(SqlComisConstants.SQL_RESULT_IMPORTE))
            .puesto(rs.getString(SqlComisConstants.SQL_RESULT_PUESTO))
            .secciones(rs.getString(SqlComisConstants.SQL_RESULT_SECCIONES))
            .build());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesHistoricoEs(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE,
        TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA,
        TimeUtils.toDate(tarea.getFechaFinPeriodo()));

    return this.query(this.sqlFindCondicionesHistoricoEs, map,
        (rs, rowNum) -> IdPersonaLocalCondicionesDto
            .builder()
            .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
            .fechaDesde(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_DESDE).toLocalDate())
            .fechaHasta(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_HASTA).toLocalDate())
            .cclIdSeccion(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_SECCION))
            .idTipoCalculo(rs.getString(SqlComisConstants.SQL_RESULT_ID_TIPO_CALCULO))
            .porcentaje(rs.getString(SqlComisConstants.SQL_RESULT_PORCENTAJE))
            .banda(rs.getString(SqlComisConstants.SQL_RESULT_BANDA))
            .importe(rs.getString(SqlComisConstants.SQL_RESULT_IMPORTE))
            .puesto(rs.getString(SqlComisConstants.SQL_RESULT_PUESTO))
            .secciones(rs.getString(SqlComisConstants.SQL_RESULT_SECCIONES))
            .build());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesDesplazamiento(final TareaDto tarea, final PeriodoDto periodoAmpliado) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE,
        TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA,
        TimeUtils.toDate(tarea.getFechaFinPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE_AMPLIADO,
        TimeUtils.toDate(periodoAmpliado.getFechaInicioPeriodo()));

    return this.query(this.sqlFindCondicionesDesplazamiento, map,
        (rs, rowNum) -> IdPersonaLocalCondicionesDto
            .builder()
            .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
            .fechaDesde(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_DESDE).toLocalDate())
            .fechaHasta(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_HASTA).toLocalDate())
            .cclIdCodOrigenDestino(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_COD_ORIGEN_DESTINO))
            .idTipoCalculo(rs.getString(SqlComisConstants.SQL_RESULT_ID_TIPO_CALCULO))
            .idTipoOpcionCalculo(rs.getString(SqlComisConstants.SQL_RESULT_ID_TIPO_OPCION_CALCULO))
            .porcentaje(rs.getString(SqlComisConstants.SQL_RESULT_PORCENTAJE))
            .banda(rs.getString(SqlComisConstants.SQL_RESULT_BANDA))
            .importe(rs.getString(SqlComisConstants.SQL_RESULT_IMPORTE))
            .cclIdSeccionDestino(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_SECCION_DESTINO))
            .cclIdSeccion(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_SECCION))
            .esIncluirTotalCondiciones(
                SqlComisConstants.SQL_VALUE_BOOLEAN_TRUE.equals(rs.getString(SqlComisConstants.SQL_RESULT_ES_INCLUIR_TOTAL_COMISION)))
            .build());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesDesplazamientoEs(final TareaDto tarea, final PeriodoDto periodoAmpliado) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE,
        TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA,
        TimeUtils.toDate(tarea.getFechaFinPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE_AMPLIADO,
        TimeUtils.toDate(periodoAmpliado.getFechaInicioPeriodo()));

    return this.query(this.sqlFindCondicionesDesplazamientoEs, map,
        (rs, rowNum) -> IdPersonaLocalCondicionesDto
            .builder()
            .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
            .fechaDesde(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_DESDE).toLocalDate())
            .fechaHasta(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_HASTA).toLocalDate())
            .cclIdCodOrigenDestino(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_COD_ORIGEN_DESTINO))
            .idTipoCalculo(rs.getString(SqlComisConstants.SQL_RESULT_ID_TIPO_CALCULO))
            .idTipoOpcionCalculo(rs.getString(SqlComisConstants.SQL_RESULT_ID_TIPO_OPCION_CALCULO))
            .porcentaje(rs.getString(SqlComisConstants.SQL_RESULT_PORCENTAJE))
            .banda(rs.getString(SqlComisConstants.SQL_RESULT_BANDA))
            .importe(rs.getString(SqlComisConstants.SQL_RESULT_IMPORTE))
            .cclIdSeccionDestino(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_SECCION_DESTINO))
            .cclIdSeccion(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_SECCION))
            .esIncluirTotalCondiciones(
                SqlComisConstants.SQL_VALUE_BOOLEAN_TRUE.equals(rs.getString(SqlComisConstants.SQL_RESULT_ES_INCLUIR_TOTAL_COMISION)))
            .build());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesResalta(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE,
        TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA,
        TimeUtils.toDate(tarea.getFechaFinPeriodo()));

    return this.query(this.sqlFindCondicionesResalta, map,
        (rs, rowNum) -> IdPersonaLocalCondicionesDto
            .builder()
            .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
            .fechaDesde(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_DESDE).toLocalDate())
            .fechaHasta(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_HASTA).toLocalDate())
            .idTipoCalculo(rs.getString(SqlComisConstants.SQL_RESULT_ID_TIPO_CALCULO))
            .porcentaje(rs.getString(SqlComisConstants.SQL_RESULT_PORCENTAJE))
            .banda(rs.getString(SqlComisConstants.SQL_RESULT_BANDA))
            .importe(rs.getString(SqlComisConstants.SQL_RESULT_IMPORTE))
            .cclIdSeccion(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_SECCION))
            .build());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesResaltaSinPrimas(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE,
        TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA,
        TimeUtils.toDate(tarea.getFechaFinPeriodo()));

    return this.query(this.sqlFindCondicionesResaltaSinPrimas, map,
        (rs, rowNum) -> IdPersonaLocalCondicionesDto
            .builder()
            .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
            .fechaDesde(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_DESDE).toLocalDate())
            .fechaHasta(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_HASTA).toLocalDate())
            .idTipoCalculo(rs.getString(SqlComisConstants.SQL_RESULT_ID_TIPO_CALCULO))
            .porcentaje(rs.getString(SqlComisConstants.SQL_RESULT_PORCENTAJE))
            .banda(rs.getString(SqlComisConstants.SQL_RESULT_BANDA))
            .importe(rs.getString(SqlComisConstants.SQL_RESULT_IMPORTE))
            .cclIdSeccion(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_SECCION))
            .build());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesResaltaEs(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE,
        TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA,
        TimeUtils.toDate(tarea.getFechaFinPeriodo()));

    return this.query(this.sqlFindCondicionesResaltaEs, map,
        (rs, rowNum) -> IdPersonaLocalCondicionesDto
            .builder()
            .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
            .fechaDesde(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_DESDE).toLocalDate())
            .fechaHasta(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_HASTA).toLocalDate())
            .idTipoCalculo(rs.getString(SqlComisConstants.SQL_RESULT_ID_TIPO_CALCULO))
            .porcentaje(rs.getString(SqlComisConstants.SQL_RESULT_PORCENTAJE))
            .banda(rs.getString(SqlComisConstants.SQL_RESULT_BANDA))
            .importe(rs.getString(SqlComisConstants.SQL_RESULT_IMPORTE))
            .cclIdSeccion(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_SECCION))
            .build());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesPrimas(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE,
        TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA,
        TimeUtils.toDate(tarea.getFechaFinPeriodo()));

    return this.query(this.sqlFindCondicionesPrimas, map,
        (rs, rowNum) -> IdPersonaLocalCondicionesDto
            .builder()
            .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
            .fechaDesde(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_DESDE).toLocalDate())
            .fechaHasta(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_HASTA).toLocalDate())
            .idTipoCalculo(rs.getString(SqlComisConstants.SQL_RESULT_ID_TIPO_CALCULO))
            .porcentaje(rs.getString(SqlComisConstants.SQL_RESULT_PORCENTAJE))
            .banda(rs.getString(SqlComisConstants.SQL_RESULT_BANDA))
            .importe(rs.getString(SqlComisConstants.SQL_RESULT_IMPORTE))
            .cclIdSeccion(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_SECCION))
            .build());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findBajasIt(final TareaDto tarea, final PeriodoDto periodoAmpliado) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE,
        TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA,
        TimeUtils.toDate(tarea.getFechaFinPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE_AMPLIADO,
        TimeUtils.toDate(periodoAmpliado.getFechaInicioPeriodo()));

    return this.query(this.sqlFindBajasIt, map,
        (rs, rowNum) -> IdPersonaLocalCondicionesDto
            .builder()
            .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
            .fechaDesde(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_INICIO).toLocalDate())
            .fechaHasta(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_FIN).toLocalDate())
            .porcentaje(rs.getString(SqlComisConstants.SQL_RESULT_PORCENTAJE))
            .build());
  }

  @Override
  public List<IdPersonaLocalCarenciaDto> findCarencia(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE, tarea.getFechaInicioPeriodo());
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA, tarea.getFechaFinPeriodo());

    return this.query(this.sqlFindCarencia, map,
        (rs, rowNum) -> IdPersonaLocalCarenciaDto
            .builder()
            .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
            .fechaAlta(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_ALTA).toLocalDate())
            .fechaInicioCalculo(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_INICIO_CALCULO).toLocalDate())
            .cclIdCodOrigen(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_COD_ORIGEN))
            .build());
  }

  @Override
  public List<IdPersonaLocalExternaDto> findExternosByClase(
      final TareaDto tarea, final ComisClaseEmpleadoEnum clase) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE, TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA, TimeUtils.toDate(tarea.getFechaFinPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_CLASE, clase.getId());

    return this.query(this.sqlFindExternosByClase, map,
        (rs, rowNum) -> IdPersonaLocalExternaDto
            .builder()
            .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
            .fechaDesde(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_DESDE).toLocalDate())
            .fechaHasta(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_HASTA).toLocalDate())
            .build());
  }

  @Override
  public List<IdPersonaLocalExternaDto> findExternosByMinIdPersona(final TareaDto tarea, final Long minIdPersona) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE, TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA, TimeUtils.toDate(tarea.getFechaFinPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_MIN_ID_PERSONA, minIdPersona);

    return this.query(this.sqlFindExternosByMinIdPersona, map,
        (rs, rowNum) -> IdPersonaLocalExternaDto
            .builder()
            .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
            .fechaDesde(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_DESDE).toLocalDate())
            .fechaHasta(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_HASTA).toLocalDate())
            .build());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findBajasItEs(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE,
        TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA,
        TimeUtils.toDate(tarea.getFechaFinPeriodo()));

    return this.query(this.sqlFindBajasItEs, map,
        (rs, rowNum) -> IdPersonaLocalCondicionesDto
            .builder()
            .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
            .fechaDesde(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_INICIO).toLocalDate())
            .fechaHasta(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_FIN).toLocalDate())
            .porcentaje(rs.getString(SqlComisConstants.SQL_RESULT_PORCENTAJE))
            .build());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesHistoricoSinChallenge(final TareaDto tarea, final PeriodoDto periodoAmpliado) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE,
        TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA,
        TimeUtils.toDate(tarea.getFechaFinPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE_AMPLIADO,
        TimeUtils.toDate(periodoAmpliado.getFechaInicioPeriodo()));

    return this.query(this.sqlFindCondicionesHistoricoSinChallenge, map,
        (rs, rowNum) -> IdPersonaLocalCondicionesDto
            .builder()
            .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
            .fechaDesde(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_DESDE).toLocalDate())
            .fechaHasta(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_HASTA).toLocalDate())
            .cclIdSeccion(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_SECCION))
            .idTipoCalculo(rs.getString(SqlComisConstants.SQL_RESULT_ID_TIPO_CALCULO))
            .porcentaje(rs.getString(SqlComisConstants.SQL_RESULT_PORCENTAJE))
            .banda(rs.getString(SqlComisConstants.SQL_RESULT_BANDA))
            .importe(rs.getString(SqlComisConstants.SQL_RESULT_IMPORTE))
            .puesto(rs.getString(SqlComisConstants.SQL_RESULT_PUESTO))
            .secciones(rs.getString(SqlComisConstants.SQL_RESULT_SECCIONES))
            .build());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesDesplazamientoSinChallenge(final TareaDto tarea,
      final PeriodoDto periodoAmpliado) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE,
        TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA,
        TimeUtils.toDate(tarea.getFechaFinPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE_AMPLIADO,
        TimeUtils.toDate(periodoAmpliado.getFechaInicioPeriodo()));

    return this.query(this.sqlFindCondicionesDesplazamientoSinChallenge, map,
        (rs, rowNum) -> IdPersonaLocalCondicionesDto
            .builder()
            .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
            .fechaDesde(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_DESDE).toLocalDate())
            .fechaHasta(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_HASTA).toLocalDate())
            .cclIdCodOrigenDestino(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_COD_ORIGEN_DESTINO))
            .idTipoCalculo(rs.getString(SqlComisConstants.SQL_RESULT_ID_TIPO_CALCULO))
            .idTipoOpcionCalculo(rs.getString(SqlComisConstants.SQL_RESULT_ID_TIPO_OPCION_CALCULO))
            .porcentaje(rs.getString(SqlComisConstants.SQL_RESULT_PORCENTAJE))
            .banda(rs.getString(SqlComisConstants.SQL_RESULT_BANDA))
            .importe(rs.getString(SqlComisConstants.SQL_RESULT_IMPORTE))
            .cclIdSeccionDestino(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_SECCION_DESTINO))
            .cclIdSeccion(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_SECCION))
            .esIncluirTotalCondiciones(Boolean.FALSE)
            .build());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesResaltaSinChallenge(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE,
        TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA,
        TimeUtils.toDate(tarea.getFechaFinPeriodo()));

    return this.query(this.sqlFindCondicionesResaltaSinChallenge, map,
        (rs, rowNum) -> IdPersonaLocalCondicionesDto
            .builder()
            .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
            .fechaDesde(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_DESDE).toLocalDate())
            .fechaHasta(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_HASTA).toLocalDate())
            .idTipoCalculo(rs.getString(SqlComisConstants.SQL_RESULT_ID_TIPO_CALCULO))
            .porcentaje(rs.getString(SqlComisConstants.SQL_RESULT_PORCENTAJE))
            .banda(rs.getString(SqlComisConstants.SQL_RESULT_BANDA))
            .importe(rs.getString(SqlComisConstants.SQL_RESULT_IMPORTE))
            .cclIdSeccion(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_SECCION))
            .build());
  }

  @Override
  public List<IdPersonaLocalComisionManualDto> findComisionManual(
      final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA, TimeUtils.toDate(tarea.getFechaFinPeriodo()));

    return this.query(this.sqlFindComisionManual, map, (rs, rowNum) -> IdPersonaLocalComisionManualDto
        .builder()
        .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
        .tipoComision(rs.getString(SqlComisConstants.SQL_RESULT_ID_TIPO_COMISION))
        .grupoManual(rs.getString(SqlComisConstants.SQL_RESULT_ID_GRUPO_MANUAL))
        .importe(rs.getString(SqlComisConstants.SQL_RESULT_IMPORTE))
        .build());
  }

  @Override
  public List<IdPersonaLocalLocalizacionDto> findPersonas(
      final TareaDto tarea, final Long maxIdPersona) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE, TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA, TimeUtils.toDate(tarea.getFechaFinPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_MAX_ID_PERSONA, maxIdPersona);

    return this.query(this.sqlFindPersonas, map, (rs, rowNum) -> IdPersonaLocalLocalizacionDto
        .builder()
        .cclIdCodOrigen(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_COD_ORIGEN))
        .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
        .build());
  }

  @Override
  public List<IdPersonaLocalLocalizacionDto> findPersonasSilSinEstado(final TareaDto tarea, final Long maxIdPersona,
      final ClaseResultItemDto clase) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE, TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA, TimeUtils.toDate(tarea.getFechaFinPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_MAX_ID_PERSONA, maxIdPersona);
    map.addValue(SqlComisConstants.SQL_PARAM_CLASE, clase.getIdClase());

    return this.query(this.sqlFindPersonasSilSinEstado, map, (rs, rowNum) -> IdPersonaLocalLocalizacionDto
        .builder()
        .cclIdCodOrigen(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_COD_ORIGEN))
        .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
        .build());
  }

  @Override
  public List<IdPersonaLocalLocalizacionDto> findPersonasSilConEstado(final TareaDto tarea, final Long maxIdPersona,
      final ClaseResultItemDto clase) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE, TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA, TimeUtils.toDate(tarea.getFechaFinPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_MAX_ID_PERSONA, maxIdPersona);
    map.addValue(SqlComisConstants.SQL_PARAM_CLASE, clase.getIdClase());
    map.addValue(SqlComisConstants.SQL_PARAM_ESTADO_SIL, clase.getIdsEstadoSil());

    return this.query(this.sqlFindPersonasSilConEstado, map, (rs, rowNum) -> IdPersonaLocalLocalizacionDto
        .builder()
        .cclIdCodOrigen(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_COD_ORIGEN))
        .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
        .build());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesHistoricoChallengeIncluidoPorcentaje(final TareaDto tarea,
      final PeriodoDto periodoAmpliado) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE,
        TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA,
        TimeUtils.toDate(tarea.getFechaFinPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE_AMPLIADO,
        TimeUtils.toDate(periodoAmpliado.getFechaInicioPeriodo()));

    return this.query(this.sqlFindCondicionesHIstoricoChallengeIncluidoPorcentaje, map,
        (rs, rowNum) -> IdPersonaLocalCondicionesDto
            .builder()
            .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
            .fechaDesde(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_DESDE).toLocalDate())
            .fechaHasta(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_HASTA).toLocalDate())
            .cclIdSeccion(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_SECCION))
            .idTipoCalculo(rs.getString(SqlComisConstants.SQL_RESULT_ID_TIPO_CALCULO))
            .porcentaje(rs.getString(SqlComisConstants.SQL_RESULT_PORCENTAJE))
            .banda(rs.getString(SqlComisConstants.SQL_RESULT_BANDA))
            .importe(rs.getString(SqlComisConstants.SQL_RESULT_IMPORTE))
            .build());
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesDesplazamientoChallengeIncluidoPorcentaje(final TareaDto tarea,
      final PeriodoDto periodoAmpliado) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE,
        TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA,
        TimeUtils.toDate(tarea.getFechaFinPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE_AMPLIADO,
        TimeUtils.toDate(periodoAmpliado.getFechaInicioPeriodo()));

    return this.query(this.sqlFindCondicionesDesplazamientoChallengeIncluidoPorcentaje, map,
        (rs, rowNum) -> IdPersonaLocalCondicionesDto
            .builder()
            .idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON))
            .fechaDesde(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_DESDE).toLocalDate())
            .fechaHasta(rs.getDate(SqlComisConstants.SQL_RESULT_FECHA_HASTA).toLocalDate())
            .cclIdCodOrigenDestino(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_COD_ORIGEN_DESTINO))
            .idTipoCalculo(rs.getString(SqlComisConstants.SQL_RESULT_ID_TIPO_CALCULO))
            .idTipoOpcionCalculo(rs.getString(SqlComisConstants.SQL_RESULT_ID_TIPO_OPCION_CALCULO))
            .porcentaje(rs.getString(SqlComisConstants.SQL_RESULT_PORCENTAJE))
            .banda(rs.getString(SqlComisConstants.SQL_RESULT_BANDA))
            .importe(rs.getString(SqlComisConstants.SQL_RESULT_IMPORTE))
            .cclIdSeccionDestino(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_SECCION_DESTINO))
            .cclIdSeccion(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_SECCION))
            .build());
  }

  @Override
  public List<IdPersonaLocalDto> validateTempComisRecuperarFrancia(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_FIN_PERIODO, tarea.getFechaFinPeriodo());

    return this.query(this.sqlValidateTempComisRecuperarFrancia, map,
        (rs, rowNum) -> {
          final IdPersonaLocalDto idPersonaLocalCondicionesDto = new IdPersonaLocalDto();
          idPersonaLocalCondicionesDto
              .setIdPersonaLocal((rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON)));
          return idPersonaLocalCondicionesDto;
        });
  }
}
