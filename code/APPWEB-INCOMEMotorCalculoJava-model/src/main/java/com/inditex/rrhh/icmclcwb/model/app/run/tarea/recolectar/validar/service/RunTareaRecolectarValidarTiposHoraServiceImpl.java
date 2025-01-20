package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.validar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaValidarDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.service.RunTareaRecolectarValidarTiposHoraService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaValidarAsyncService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTipoHora;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaRecolectarValidarTiposHoraServiceImpl implements RunTareaRecolectarValidarTiposHoraService {

  private final TareaValidarAsyncService tareaValidarAsyncService;

  @Override
  public List<RunTareaValidarDto> run(@NotNull @Valid final RunTareaDto runTarea) {
    final List<RunTareaValidarDto> result = new ArrayList<>();
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    try {
      final CompletableFuture<List<String>> cfDuplicatedLocalizacionHistorico = this.tareaValidarAsyncService
          .checkDuplicatedTiposHora(runTarea.getTarea().getId());
      AsyncUtils.exceptionally(cfDuplicatedLocalizacionHistorico, cf);
      AsyncUtils.waitAllOfIsOk(cf, cf);
      result.add(RunTareaValidarDto.builder()
          .type(TareaTipoHora.class.getSimpleName())
          .duplicated(AsyncUtils.get(cfDuplicatedLocalizacionHistorico).stream().collect(Collectors.toSet()))
          .build());
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
    return result;
  }

}
