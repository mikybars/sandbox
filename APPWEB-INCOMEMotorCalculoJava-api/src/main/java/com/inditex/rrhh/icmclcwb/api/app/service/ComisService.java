package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdMotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalFechaIncidenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

public interface ComisService {

    /**
     * @param tarea
     * @return
     */
    PresenciaOrigenDto findPresenciasOrigenAndFecha(@Valid final RunTareaDto runTarea,
            @Valid final TareaAmbitoDto tareaAmbito);

    /**
     * @param runTareaDto
     * @param tareaAmbito
     * @return
     */
    List<IdMotivoDesplazamientoDto> findMotivoDesplazamiento(@Valid RunTareaDto runTareaDto,
            @Valid TareaAmbitoDto tareaAmbito);

    /**
     * @param runTareaDto
     * @param tareaAmbito
     * @return
     */
    List<IdPersonaLocalFechaIncidenciaDto> findFechasIncidencias(@Valid final RunTareaDto runTareaDto,
            @Valid TareaAmbitoDto tareaAmbito);

    /**
     * @param runTareaDto
     * @param tareaAmbito
     * @return
     */
    List<IdPersonaLocalFechaIncidenciaDto> findFechasDesplazamientos(@Valid final RunTareaDto runTareaDto,
            @Valid TareaAmbitoDto tareaAmbito);

    /**
     * @param runTareaDto
     * @param tareaAmbito
     * @return
     */
    List<IdPersonaLocalCondicionesDto> findCondicionesHistorico(@Valid RunTareaDto runTareaDto,
            @Valid TareaAmbitoDto tareaAmbito);

    /**
     * @param runTareaDto
     * @param tareaAmbito
     * @return
     */
    List<IdPersonaLocalCondicionesDto> findCondicionesDesplazamiento(@Valid RunTareaDto runTareaDto,
            @Valid TareaAmbitoDto tareaAmbito);

    /**
     * @param runTareaDto
     * @param tareaAmbito
     * @return
     */
    List<IdPersonaLocalCondicionesDto> findCondicionesResalta(@Valid RunTareaDto runTareaDto,
            @Valid TareaAmbitoDto tareaAmbito);

    /**
     * @param runTareaDto
     * @param tareaAmbito
     * @return
     */
    List<IdPersonaLocalCondicionesDto> findBajasIt(@Valid RunTareaDto runTareaDto, @Valid TareaAmbitoDto tareaAmbito);

    /**
     * @param runTareaDto
     * @param tareaAmbito
     * @return
     */
    List<IdPersonaLocalCarenciaDto> findCarencia(@Valid RunTareaDto runTareaDto, @Valid TareaAmbitoDto tareaAmbito);

}
