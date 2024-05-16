package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;

import jakarta.validation.constraints.NotNull;
import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaLocalizacionPersonaPresenciaAsyncService {

  CompletableFuture<Void> save(@NotNull List<GenericEmpleadoResultItemDto> src, @NotNull TareaDto tareaDto);

  CompletableFuture<Void> updateActivo(@NotNull RunTareaDto runTareaDto);

  CompletableFuture<Void> savePtrPresenciaDetalle(@NotNull List<PtrPresenciaDetalleResultItemDto> src,
      @NotNull TareaDto tareaDto, @NotNull Integer idTipoDato);

  CompletableFuture<Void> updateActivoPersonasExternas(@NotNull RunTareaDto runTareaDto);

}
