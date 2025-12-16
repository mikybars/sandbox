package com.inditex.rrhh.icmclcwb.model.app.run.tarea.migrar;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.migrar.RunTareaMigrarAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaMigrarComisionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaMigrarService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunTareaMigrarAsyncServiceImpl implements RunTareaMigrarAsyncService {

  @Autowired
  private TareaMigrarService tareaMigrarService;

  @Override
  public CompletableFuture<Void> migrarListCalculoComision(final RunTareaDto runTarea, final List<TareaMigrarComisionDto> deleteMigracion) {
    this.tareaMigrarService.migrarCalculoComision(runTarea, deleteMigracion);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> deleteCalculoComisionByTareaActual(@NotNull final RunTareaDto runTareaDto,
      @NotNull final TareaAmbitoDto tareaAmbitoDto) {
    this.tareaMigrarService.deleteCalculoComisionByTareaActual(runTareaDto, tareaAmbitoDto);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }
}
