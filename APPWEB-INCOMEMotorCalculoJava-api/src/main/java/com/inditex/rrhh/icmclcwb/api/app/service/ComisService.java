package com.inditex.rrhh.icmclcwb.api.app.service;

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
import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseResultItemDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public interface ComisService {

  /**
   * Some javadoc.
   *
   * @param runTarea Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  PresenciaOrigenDto findPresenciasOrigenAndFecha(@Valid final RunTareaDto runTarea,
      @Valid final TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  List<IdMotivoDesplazamientoDto> findMotivoDesplazamiento(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalFechaIncidenciaDto> findFechasIncidencias(@Valid final RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalFechaIncidenciaDto> findFechasDesplazamientos(@Valid final RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCondicionesDto> findCondicionesHistorico(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCondicionesDto> findCondicionesDesplazamiento(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCondicionesDto> findCondicionesResalta(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCondicionesDto> findCondicionesResaltaSinPrimas(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCondicionesDto> findBajasIt(@Valid RunTareaDto runTareaDto, @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCarenciaDto> findCarencia(@Valid RunTareaDto runTareaDto, @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @param clase Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalExternaDto> findExternosByClase(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito, ComisClaseEmpleadoEnum clase);

  /**
   * Obtiene los empleados externos en base a los que tengan un id superior al dado.
   *
   * @param runTareaDto runtarea
   * @param tareaAmbito tareaAmbito
   * @param minIdPersona el id de persona que debe ser superado para ser considerado externo.
   * @return lista de externos
   */
  List<IdPersonaLocalExternaDto> findExternosByMinIdPersona(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito, @NotNull @Positive Long minIdPersona);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCondicionesDto> findBajasItEs(@Valid RunTareaDto runTareaDto, @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCondicionesDto> findCondicionesDesplazamientoEs(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCondicionesDto> findCondicionesHistoricoEs(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCondicionesDto> findCondicionesResaltaEs(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCondicionesDto> findCondicionesPrimas(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCondicionesDto> findCondicionesHistoricoSinChallenge(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCondicionesDto> findCondicionesDesplazamientoSinChallenge(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  List<IdPersonaLocalCondicionesDto> findCondicionesResaltaSinChallenge(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Obtiene las comisiones manuales.
   *
   * @param runTareaDto tarea
   * @param tareaAmbito ambito
   * @return Listado de comisiones
   */
  List<IdPersonaLocalComisionManualDto> findComisionManual(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Obtiene las personas con sus respectivas localizaciones.
   *
   * @param runTareaDto tarea
   * @param tareaAmbito ambito
   * @param maxIdPersona maximo id de persona a obtener para evitar empleados externos.
   * @return Lista de personas.
   */
  List<IdPersonaLocalLocalizacionDto> findPersonas(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito, @NotNull Long maxIdPersona);

  /**
   * Obtiene las personas con sus respectivas localizaciones para orígenes SIL.
   *
   * @param runTareaDto tarea
   * @param tareaAmbito ambito
   * @param maxIdPersona maximo id de persona a obtener para evitar empleados externos.
   * @param clase clase a la que deben pertencer las personas.
   * @return Lista de personas.
   */
  List<IdPersonaLocalLocalizacionDto> findPersonasSil(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito, @NotNull Long maxIdPersona, @Valid ClaseResultItemDto clase);

  List<IdPersonaLocalCondicionesDto> findCondicionesHistoricoChallengeIncluidoPorcentaje(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  List<IdPersonaLocalCondicionesDto> findCondicionesDesplazamientoChallengeIncluidoPorcentaje(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  List<IdPersonaLocalDto> validateTempComisRecuperarFrancia(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);
}
