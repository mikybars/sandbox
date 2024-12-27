package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.validar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaValidarDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.service.RunTareaRecolectarValidarLocalizacionPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaValidarAsyncService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaPresencia;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaRecolectarValidarLocalizacionPersonaPresenciaServiceImpl
    implements RunTareaRecolectarValidarLocalizacionPersonaService {

  @Autowired
  private TareaValidarAsyncService tareaValidarAsyncService;

  @Override
  public List<RunTareaValidarDto> run(@NonNull @Valid final RunTareaDto runTarea) {
    List<RunTareaValidarDto> result = new ArrayList<>();
    List<CompletableFuture<?>> cf = new ArrayList<>();
    try {
      CompletableFuture<Integer> cfCountLocalizacionPersonaPresenciaSeccion = tareaValidarAsyncService
          .countLocalizacionPersonaPresencia(runTarea.getTarea().getId());
      AsyncUtils.exceptionally(cfCountLocalizacionPersonaPresenciaSeccion, cf);
      AsyncUtils.waitAllOfIsOk(cf, cf);
      result.add(RunTareaValidarDto.builder()
          .type(TareaLocalizacionPersonaPresencia.class.getSimpleName())
          .count(AsyncUtils.get(cfCountLocalizacionPersonaPresenciaSeccion))
          .build());
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
    return result;
  }

}
