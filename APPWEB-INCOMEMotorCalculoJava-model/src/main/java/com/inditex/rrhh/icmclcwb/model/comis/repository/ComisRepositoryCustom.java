package com.inditex.rrhh.icmclcwb.model.comis.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.ComisClaseEmpleadoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdMotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalExternaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalFechaIncidenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

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
  List<IdPersonaLocalCondicionesDto> findCondicionesHistorico(TareaDto tarea);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCondicionesDto> findCondicionesDesplazamiento(TareaDto tarea);

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
  List<IdPersonaLocalCondicionesDto> findCondicionesDesplazamientoEs(TareaDto tarea);

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

}
