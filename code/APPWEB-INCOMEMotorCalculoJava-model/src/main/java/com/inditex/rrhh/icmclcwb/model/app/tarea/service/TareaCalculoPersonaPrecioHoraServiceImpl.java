package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaPrecioHoraService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoPersonaPrecioHoraRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class TareaCalculoPersonaPrecioHoraServiceImpl implements TareaCalculoPersonaPrecioHoraService {

  private final TareaCalculoPersonaPrecioHoraRepositoryCustom tareaCalculoPersonaPrecioHoraRepositoryCustom;

  @Override
  public List<IdPersonaLocalDto> getIdsPersonasCalculoPrecioHoraByTareaAndAmbito(@Valid @NotNull final RunTareaDto runTareaDto,
      @Valid @NotNull final TareaAmbitoDto ambitoDto) {

    final TareaDto tareaDto = runTareaDto.getTarea();

    return this.tareaCalculoPersonaPrecioHoraRepositoryCustom.ids(tareaDto.getId(), ambitoDto.getCclIdOrigen());
  }

  @Override
  public CompletableFuture<Void> calcularPrecioHora(@Valid @NotNull final RunTareaDto runTareaDto,
      @Valid @NotNull final TareaAmbitoDto ambitoDto,
      @Valid @NotNull final List<IdPersonaLocalDto> personas) {

    final TareaDto tarea = runTareaDto.getTarea();
    final TrabajoDTO trabajo = runTareaDto.getTrabajo();

    this.tareaCalculoPersonaPrecioHoraRepositoryCustom.insertPrecioHora(
        tarea.getId(),
        trabajo.getIcmIdPeriodo(),
        ambitoDto.getCclIdOrigen(),
        tarea.getStdIdLegEnt(),
        personas.stream().map(IdPersonaLocalDto::getIdPersonaLocal).toList());

    return CompletableFuture.completedFuture(AsyncConstants.NIL);

  }

}
