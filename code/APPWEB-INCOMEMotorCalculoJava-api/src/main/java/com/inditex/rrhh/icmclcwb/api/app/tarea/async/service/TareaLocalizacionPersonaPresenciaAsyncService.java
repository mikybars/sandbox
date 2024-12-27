package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;

import org.jspecify.annotations.NonNull;
import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaLocalizacionPersonaPresenciaAsyncService {

  CompletableFuture<Void> save(@NonNull List<GenericEmpleadoResultItemDto> src, @NonNull TareaDto tareaDto);

  CompletableFuture<Void> updateActivo(@NonNull RunTareaDto runTareaDto);

  CompletableFuture<Void> savePtrPresenciaDetalle(@NonNull List<PtrPresenciaDetalleResultItemDto> src,
      @NonNull TareaDto tareaDto, @NonNull Integer idTipoDato);

  CompletableFuture<Void> updateActivoPersonasExternas(@NonNull RunTareaDto runTareaDto);

}
