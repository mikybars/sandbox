package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.validar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaValidarDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.service.RunTareaRecolectarValidarLocalizacionVentaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaValidarAsyncService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVenta;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaRecolectarValidarLocalizacionVentaServiceImpl
    implements RunTareaRecolectarValidarLocalizacionVentaService {

  private final TareaValidarAsyncService tareaValidarAsyncService;

  @Override
  public List<RunTareaValidarDto> run(@NonNull @Valid final RunTareaDto runTarea) {
    final List<RunTareaValidarDto> result = new ArrayList<>();
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    try {
      final CompletableFuture<Integer> cfData = this.tareaValidarAsyncService
          .countLocalizacionVenta(runTarea.getTarea().getId());
      AsyncUtils.exceptionally(cfData, cf);
      AsyncUtils.waitAllOfIsOk(cf, cf);
      result.add(RunTareaValidarDto.builder()
          .type(TareaLocalizacionVenta.class.getSimpleName())
          .count(AsyncUtils.get(cfData))
          .build());
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
    return result;
  }

}
