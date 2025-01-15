package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.validar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaValidarDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.service.RunTareaRecolectarValidarTiendaPresenciaSeccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaValidarAsyncService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresencia;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaRecolectarValidarTiendaPresenciaSeccionServiceImpl
    implements RunTareaRecolectarValidarTiendaPresenciaSeccionService {

  private final TareaValidarAsyncService tareaValidarAsyncService;

  @Override
  public List<RunTareaValidarDto> run(@NonNull @Valid final RunTareaDto runTarea) {
    final List<RunTareaValidarDto> result = new ArrayList<>();
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    try {
      final CompletableFuture<Integer> cfCountPresenciaSeccion = this.tareaValidarAsyncService
          .countTiendaPresenciaSeccion(runTarea.getTarea().getId());
      AsyncUtils.exceptionally(cfCountPresenciaSeccion, cf);
      AsyncUtils.waitAllOfIsOk(cf, cf);
      result.add(RunTareaValidarDto.builder()
          .type(TareaLocalizacionPresencia.class.getSimpleName())
          .count(AsyncUtils.get(cfCountPresenciaSeccion))
          .build());
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
    return result;
  }

}
