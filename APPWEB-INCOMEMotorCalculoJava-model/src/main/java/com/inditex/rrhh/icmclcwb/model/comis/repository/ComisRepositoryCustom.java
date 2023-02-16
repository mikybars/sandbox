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
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseResultItemDto;

public interface ComisRepositoryCustom {

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   * @return Some javadoc.
   */
  PresenciaOrigenDto findPresenciasOrigenAndFecha(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   * @return Some javadoc.
   */
  List<IdMotivoDesplazamientoDto> findMotivoDesplazamiento(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalFechaIncidenciaDto> findFechasIncidencias(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalFechaIncidenciaDto> findFechasDesplazamientos(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCondicionesDto> findCondicionesHistorico(TareaDto tarea, final PeriodoDto periodoAmpliado);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCondicionesDto> findCondicionesDesplazamiento(TareaDto tarea, final PeriodoDto periodoAmpliado);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCondicionesDto> findCondicionesResalta(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCondicionesDto> findCondicionesResaltaSinPrimas(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCondicionesDto> findBajasIt(TareaDto tarea, PeriodoDto periodoAmpliado);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCarenciaDto> findCarencia(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalExternaDto> findExternosByClase(TareaDto tarea, ComisClaseEmpleadoEnum clase);

  /**
   * Obtiene los empleados externos en base a los que tengan un id superior al dado.
   *
   * @param tarea tarea
   * @param minIdPersona el id de persona que debe ser superado para ser considerado externo.
   * @return lista de externos
   */
  List<IdPersonaLocalExternaDto> findExternosByMinIdPersona(final TareaDto tarea, final Long minIdPersona);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCondicionesDto> findBajasItEs(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCondicionesDto> findCondicionesHistoricoEs(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCondicionesDto> findCondicionesDesplazamientoEs(TareaDto tarea, PeriodoDto periodoAmpliado);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCondicionesDto> findCondicionesResaltaEs(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCondicionesDto> findCondicionesPrimas(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCondicionesDto> findCondicionesHistoricoSinChallenge(final TareaDto tarea, final PeriodoDto periodoAmpliado);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCondicionesDto> findCondicionesDesplazamientoSinChallenge(TareaDto tarea, PeriodoDto periodoAmpliado);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCondicionesDto> findCondicionesResaltaSinChallenge(TareaDto tarea);

  /**
   * Obtiene las comisiones manuales.
   *
   * @param tarea tarea
   * @return Lista de comisiones manuales.
   */
  List<IdPersonaLocalComisionManualDto> findComisionManual(TareaDto tarea);

  /**
   * Obtiene las personas con sus respectivas localizaciones.
   *
   * @param tarea tarea
   * @param maxIdPersona maximo id de persona a obtener para evitar empleados externos.
   * @return Lista de personas.
   */
  List<IdPersonaLocalLocalizacionDto> findPersonas(TareaDto tarea, Long maxIdPersona);

  /**
   * Obtiene las personas con sus respectivas localizaciones en orígenes SIL.
   *
   * @param tarea tarea
   * @param maxIdPersona máximo id de persona aobtener para evitar empleados externos.
   * @param clase clase a tener en cuenta.
   * @return Lista de personas.
   */
  List<IdPersonaLocalLocalizacionDto> findPersonasSilSinEstado(TareaDto tarea, Long maxIdPersona, ClaseResultItemDto clase);

  /**
   * Obtiene las personas con sus respectivas localizaciones en orígenes SIL.
   *
   * @param tarea tarea
   * @param maxIdPersona máximo id de persona aobtener para evitar empleados externos.
   * @param clase clase a tener en cuenta con su estado SIL correspondiente.
   * @return Lista de personas.
   */
  List<IdPersonaLocalLocalizacionDto> findPersonasSilConEstado(TareaDto tarea, Long maxIdPersona, ClaseResultItemDto clase);

  List<IdPersonaLocalCondicionesDto> findCondicionesHistoricoChallengeIncluidoPorcentaje(TareaDto tarea,
      PeriodoDto periodoAmpliado);

  List<IdPersonaLocalCondicionesDto> findCondicionesDesplazamientoChallengeIncluidoPorcentaje(TareaDto tarea,
      PeriodoDto periodoAmpliado);

  List<IdPersonaLocalDto> validateTempComisRecuperarFrancia(TareaDto tarea);
}
