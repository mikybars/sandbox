/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.ComisClaseEmpleadoEnum;
import com.inditex.rrhh.icmclcwb.api.app.async.service.ComisAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdMotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalExternaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalFechaIncidenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.ComisService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

/**
 * @author mdelrio
 *
 */
@Service
public class ComisAsyncServiceImpl implements ComisAsyncService {

    @Autowired
    private ComisService comisService;

    @Override
    public CompletableFuture<List<IdMotivoDesplazamientoDto>> findMotivoDesplazamiento(
            @Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito) {
        return CompletableFuture.completedFuture(this.comisService.findMotivoDesplazamiento(runTareaDto, tareaAmbito));
    }

    @Override
    public CompletableFuture<PresenciaOrigenDto> findPresenciasOrigenAndFecha(@Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito) {
        return CompletableFuture
            .completedFuture(this.comisService.findPresenciasOrigenAndFecha(runTareaDto, tareaAmbito));
    }

    @Override
    public CompletableFuture<List<IdPersonaLocalFechaIncidenciaDto>> findFechasIncidencias(
            @Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito) {
        return CompletableFuture
            .completedFuture(this.comisService.findFechasIncidencias(runTareaDto, tareaAmbito));
    }

    @Override
    public CompletableFuture<List<IdPersonaLocalFechaIncidenciaDto>> findFechasDesplazamientos(
            @Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito) {
        return CompletableFuture
            .completedFuture(this.comisService.findFechasDesplazamientos(runTareaDto, tareaAmbito));
    }

    @Override
    public CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesHistorico(
            @Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito) {
        return CompletableFuture
            .completedFuture(this.comisService.findCondicionesHistorico(runTareaDto, tareaAmbito));
    }

    @Override
    public CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesDesplazamiento(
            @Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito) {
        return CompletableFuture
            .completedFuture(this.comisService.findCondicionesDesplazamiento(runTareaDto, tareaAmbito));
    }

    @Override
    public CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesResalta(
            @Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito) {
        return CompletableFuture
            .completedFuture(this.comisService.findCondicionesResalta(runTareaDto, tareaAmbito));
    }

    @Override
    public CompletableFuture<List<IdPersonaLocalCondicionesDto>> findBajasIt(
            @Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito) {
        return CompletableFuture
            .completedFuture(this.comisService.findBajasIt(runTareaDto, tareaAmbito));
    }

    @Override
    public CompletableFuture<List<IdPersonaLocalCarenciaDto>> findCarencia(
            @Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito) {
        return CompletableFuture
            .completedFuture(this.comisService.findCarencia(runTareaDto, tareaAmbito));
    }

    @Override
    public CompletableFuture<List<IdPersonaLocalExternaDto>> findExternosByClase(
            @Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito,
            final ComisClaseEmpleadoEnum clase) {
        return CompletableFuture
            .completedFuture(this.comisService.findExternosByClase(runTareaDto, tareaAmbito, clase));
    }

    @Override
    public CompletableFuture<List<IdPersonaLocalExternaDto>> findExternosByMinIdPersona(
            @Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito, final Long minIdPersona) {
        return CompletableFuture
            .completedFuture(this.comisService.findExternosByMinIdPersona(runTareaDto, tareaAmbito, minIdPersona));
    }

}
