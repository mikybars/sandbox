package com.inditex.rrhh.icmclcwb.model.app.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.ComisClaseEmpleadoEnum;
import com.inditex.rrhh.icmclcwb.api.app.async.service.ComisAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdMotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalComisionManualDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalExternaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalFechaIncidenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.ComisService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseResultItemDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ComisAsyncServiceImpl implements ComisAsyncService {

  private final ComisService comisService;

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
  public CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesHistoricoEs(
      @Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    return CompletableFuture
        .completedFuture(this.comisService.findCondicionesHistoricoEs(runTareaDto, tareaAmbito));
  }

  @Override
  public CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesDesplazamiento(
      @Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    return CompletableFuture
        .completedFuture(this.comisService.findCondicionesDesplazamiento(runTareaDto, tareaAmbito));
  }

  @Override
  public CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesDesplazamientoEs(
      @Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    return CompletableFuture
        .completedFuture(this.comisService.findCondicionesDesplazamientoEs(runTareaDto, tareaAmbito));
  }

  @Override
  public CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesResalta(
      @Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    return CompletableFuture
        .completedFuture(this.comisService.findCondicionesResalta(runTareaDto, tareaAmbito));
  }

  @Override
  public CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesResaltaSinPrimas(
      @Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    return CompletableFuture
        .completedFuture(this.comisService.findCondicionesResaltaSinPrimas(runTareaDto, tareaAmbito));
  }

  @Override
  public CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesResaltaEs(
      @Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    return CompletableFuture
        .completedFuture(this.comisService.findCondicionesResaltaEs(runTareaDto, tareaAmbito));
  }

  @Override
  public CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesPrimas(
      @Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    return CompletableFuture
        .completedFuture(this.comisService.findCondicionesPrimas(runTareaDto, tareaAmbito));
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

  @Override
  public CompletableFuture<List<IdPersonaLocalCondicionesDto>> findBajasItEs(
      @Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    return CompletableFuture
        .completedFuture(this.comisService.findBajasItEs(runTareaDto, tareaAmbito));
  }

  @Override
  public CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesHistoricoSinChallenge(
      @Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    return CompletableFuture
        .completedFuture(this.comisService.findCondicionesHistoricoSinChallenge(runTareaDto, tareaAmbito));
  }

  @Override
  public CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesDesplazamientoSinChallenge(
      @Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    return CompletableFuture
        .completedFuture(this.comisService.findCondicionesDesplazamientoSinChallenge(runTareaDto, tareaAmbito));
  }

  @Override
  public CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesResaltaSinChallenge(
      @Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    return CompletableFuture
        .completedFuture(this.comisService.findCondicionesResaltaSinChallenge(runTareaDto, tareaAmbito));
  }

  @Override
  public CompletableFuture<List<IdPersonaLocalComisionManualDto>> findComisionManual(
      @Valid final RunTareaDto runTareaDto, @Valid final TareaAmbitoDto tareaAmbito) {
    return CompletableFuture.completedFuture(this.comisService.findComisionManual(runTareaDto, tareaAmbito));
  }

  @Override
  public CompletableFuture<List<IdPersonaLocalLocalizacionDto>> findPersonas(
      @Valid final RunTareaDto runTareaDto, @Valid final TareaAmbitoDto tareaAmbito, @NotNull final Long maxIdPersona) {
    return CompletableFuture.completedFuture(this.comisService.findPersonas(runTareaDto, tareaAmbito, maxIdPersona));
  }

  @Override
  public CompletableFuture<List<IdPersonaLocalLocalizacionDto>> findPersonasSil(
      @Valid final RunTareaDto runTareaDto, @Valid final TareaAmbitoDto tareaAmbito, @NotNull final Long maxIdPersona,
      @Valid final ClaseResultItemDto clase) {
    return CompletableFuture.completedFuture(this.comisService.findPersonasSil(runTareaDto, tareaAmbito, maxIdPersona, clase));
  }

  @Override
  public CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesHistoricoChallengeIncluidoPorcentaje(
      @Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    return CompletableFuture
        .completedFuture(this.comisService.findCondicionesHistoricoChallengeIncluidoPorcentaje(runTareaDto, tareaAmbito));
  }

  @Override
  public CompletableFuture<List<IdPersonaLocalCondicionesDto>> findCondicionesDesplazamientoChallengeIncluidoPorcentaje(
      @Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    return CompletableFuture
        .completedFuture(this.comisService.findCondicionesDesplazamientoChallengeIncluidoPorcentaje(runTareaDto, tareaAmbito));
  }
}
