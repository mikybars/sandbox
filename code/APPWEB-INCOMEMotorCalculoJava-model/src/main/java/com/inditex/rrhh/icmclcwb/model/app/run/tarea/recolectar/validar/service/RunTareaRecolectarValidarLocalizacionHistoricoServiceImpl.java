package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.validar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaValidarDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.service.RunTareaRecolectarValidarLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaValidarAsyncService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionHistorico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaRecolectarValidarLocalizacionHistoricoServiceImpl
    implements RunTareaRecolectarValidarLocalizacionHistoricoService {

  private final TareaValidarAsyncService tareaValidarAsyncService;

  @Override
  public List<RunTareaValidarDto> run(@NotNull @Valid final RunTareaDto runTarea) {
    List<RunTareaValidarDto> result = new ArrayList<>();
    List<CompletableFuture<?>> cf = new ArrayList<>();
    try {
      CompletableFuture<Integer> cfCountLocalizacionHistorico = tareaValidarAsyncService
          .countTiendasHistorico(runTarea.getTarea().getId());
      AsyncUtils.exceptionally(cfCountLocalizacionHistorico, cf);
      CompletableFuture<List<String>> cfDuplicatedLocalizacionHistorico = tareaValidarAsyncService
          .checkDuplicatedTiendasHistorico(runTarea.getTarea().getId());
      AsyncUtils.exceptionally(cfDuplicatedLocalizacionHistorico, cf);
      AsyncUtils.waitAllOfIsOk(cf, cf);
      result.add(RunTareaValidarDto.builder()
          .type(TareaLocalizacionHistorico.class.getSimpleName())
          .count(AsyncUtils.get(cfCountLocalizacionHistorico))
          .duplicated(AsyncUtils.get(cfDuplicatedLocalizacionHistorico).stream().collect(Collectors.toSet()))
          .build());
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
    return result;
  }

}
