package com.inditex.rrhh.icmclcwb.api.app.run.tarea.migrar;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaMigrarComisionDto;

import jakarta.validation.constraints.NotNull;
import org.springframework.scheduling.annotation.Async;

@Async
public interface RunTareaMigrarAsyncService {

  CompletableFuture<Void> migrarListCalculoComision(RunTareaDto runTareaDto, List<TareaMigrarComisionDto> deleteMigracion);

  CompletableFuture<Void> deleteCalculoComisionByTareaActual(@NotNull final RunTareaDto runTareaDto,
      @NotNull final TareaAmbitoDto tareaAmbitoDto);
}
