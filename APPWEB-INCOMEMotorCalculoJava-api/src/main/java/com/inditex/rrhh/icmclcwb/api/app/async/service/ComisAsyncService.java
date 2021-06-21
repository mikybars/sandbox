/**
 *
 */
package com.inditex.rrhh.icmclcwb.api.app.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.ComisClaseEmpleadoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdMotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalExternaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalFechaIncidenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

/**
 * @author mdelrio
 *
 */
@Async
public interface ComisAsyncService {

    /**
     * @param runTareaDto
     * @param tareaAmbito
     * @return
     */
    CompletableFuture<List<IdMotivoDesplazamientoDto>> findMotivoDesplazamiento(@Valid RunTareaDto runTareaDto,
            @Valid TareaAmbitoDto tareaAmbito);

    /**
     * @param runTareaDto
     * @param tareaAmbito
     * @return
     */
    CompletableFuture<PresenciaOrigenDto> findPresenciasOrigenAndFecha(@Valid RunTareaDto runTareaDto,
            @Valid TareaAmbitoDto tareaAmbito);

    /**
     * @param fechaDesde
     * @param tareaAmbito
     * @return
     */
    CompletableFuture<List<IdPersonaLocalFechaIncidenciaDto>> findFechasIncidencias(
            @Valid final RunTareaDto runTareaDto,
            @Valid TareaAmbitoDto tareaAmbito);

    /**
     * @param fechaDesde
     * @param tareaAmbito
     * @return
     */
    CompletableFuture<List<IdPersonaLocalFechaIncidenciaDto>> findFechasDesplazamientos(
            @Valid final RunTareaDto runTareaDto,
            @Valid TareaAmbitoDto tareaAmbito);

    /**
     * @param runTareaDto
     * @param tareaAmbito
     * @return
     */
    CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesHistorico(@Valid RunTareaDto runTareaDto,
            @Valid TareaAmbitoDto tareaAmbito);

    /**
     * @param runTareaDto
     * @param tareaAmbito
     * @return
     */
    CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesDesplazamiento(@Valid RunTareaDto runTareaDto,
            @Valid TareaAmbitoDto tareaAmbito);

    /**
     * @param runTareaDto
     * @param tareaAmbito
     * @return
     */
    CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesResalta(@Valid RunTareaDto runTareaDto,
            @Valid TareaAmbitoDto tareaAmbito);

    /**
     * @param runTareaDto
     * @param tareaAmbito
     * @return
     */
    CompletableFuture<List<IdPersonaLocalCondicionesDto>> findBajasIt(@Valid RunTareaDto runTareaDto,
            @Valid TareaAmbitoDto tareaAmbito);

    /**
     * @param runTareaDto
     * @param tareaAmbito
     * @return
     */
    CompletableFuture<List<IdPersonaLocalCarenciaDto>> findCarencia(@Valid RunTareaDto runTareaDto,
            @Valid TareaAmbitoDto tareaAmbito);

    /**
     * @param runTareaDto
     * @param tareaAmbito
     * @param clase
     * @return
     */
    CompletableFuture<List<IdPersonaLocalExternaDto>> findExternosByClase(@Valid RunTareaDto runTareaDto,
            @Valid TareaAmbitoDto tareaAmbito, ComisClaseEmpleadoEnum clase);

    /**
     * Obtiene los empleados externos en base a los que tengan un id superior al dado.
     * @param runTareaDto run tarea
     * @param tareaAmbito tarea ambito
     * @param minIdPersona el id de persona que debe ser superado para ser considerado externo.
     * @return future lista de externos
     */
    CompletableFuture<List<IdPersonaLocalExternaDto>> findExternosByMinIdPersona(@Valid RunTareaDto runTareaDto,
            @Valid TareaAmbitoDto tareaAmbito, final Long minIdPersona);

}
