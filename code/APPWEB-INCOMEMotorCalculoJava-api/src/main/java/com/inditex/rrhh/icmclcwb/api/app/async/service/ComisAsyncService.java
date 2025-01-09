package com.inditex.rrhh.icmclcwb.api.app.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.ComisClaseEmpleadoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdMotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalComisionManualDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalExternaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalFechaIncidenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseResultItemDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
import org.springframework.scheduling.annotation.Async;

@Async
public interface ComisAsyncService {

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  CompletableFuture<List<IdMotivoDesplazamientoDto>> findMotivoDesplazamiento(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  CompletableFuture<PresenciaOrigenDto> findPresenciasOrigenAndFecha(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  CompletableFuture<List<IdPersonaLocalFechaIncidenciaDto>> findFechasIncidencias(
      @Valid final RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  CompletableFuture<List<IdPersonaLocalFechaIncidenciaDto>> findFechasDesplazamientos(
      @Valid final RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesHistorico(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesDesplazamiento(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesResalta(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesResaltaSinPrimas(
      @Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  CompletableFuture<List<IdPersonaLocalCondicionesDto>> findBajasIt(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  CompletableFuture<List<IdPersonaLocalCarenciaDto>> findCarencia(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @param clase Some javadoc.
   * @return Some javadoc.
   */
  CompletableFuture<List<IdPersonaLocalExternaDto>> findExternosByClase(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito, ComisClaseEmpleadoEnum clase);

  /**
   * Obtiene los empleados externos en base a los que tengan un id superior al dado.
   *
   * @param runTareaDto run tarea
   * @param tareaAmbito tarea ambito
   * @param minIdPersona el id de persona que debe ser superado para ser considerado externo.
   * @return future lista de externos
   */
  CompletableFuture<List<IdPersonaLocalExternaDto>> findExternosByMinIdPersona(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito, final Long minIdPersona);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  CompletableFuture<List<IdPersonaLocalCondicionesDto>> findBajasItEs(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesDesplazamientoEs(
      @Valid RunTareaDto runTareaDto, @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesHistoricoEs(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesResaltaEs(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesPrimas(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesHistoricoSinChallenge(
      @Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesDesplazamientoSinChallenge(
      @Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesResaltaSinChallenge(
      @Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Obtiene las comisiones manuales.
   *
   * @param runTareaDto tarea.
   * @param tareaAmbito ambito.
   * @return Future con las comisiones manuales.
   */
  CompletableFuture<List<IdPersonaLocalComisionManualDto>> findComisionManual(
      @Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  /**
   * Obtiene las personas con sus respectivas localizaciones.
   *
   * @param runTareaDto tarea.
   * @param tareaAmbito ambito.
   * @param maxIdPersona maximo id de persona a obtener para evitar empleados externos.
   * @return Future con las personas.
   */
  CompletableFuture<List<IdPersonaLocalLocalizacionDto>> findPersonas(
      @Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito,
      @NonNull Long maxIdPersona);

  /**
   * Obtiene las personas con sus respectivas localizaciones.
   *
   * @param runTareaDto tarea.
   * @param tareaAmbito ambito.
   * @param maxIdPersona maximo id de persona a obtener para evitar empleados externos.
   * @param clase clase a la que deben pertencer las personas.
   * @return Future con las personas.
   */
  CompletableFuture<List<IdPersonaLocalLocalizacionDto>> findPersonasSil(
      @Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito,
      @NonNull Long maxIdPersona, @Valid ClaseResultItemDto clase);

  CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesHistoricoChallengeIncluidoPorcentaje(
      @Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);

  CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesDesplazamientoChallengeIncluidoPorcentaje(
      @Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito);
}
