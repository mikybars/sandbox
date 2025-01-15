package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaLocalizacionPersonaPresenciaAsyncServiceImpl
    implements TareaLocalizacionPersonaPresenciaAsyncService {

  @Autowired
  private TareaLocalizacionPersonaPresenciaService tareaLocalizacionPersonaPresenciaService;

  @Override
  public CompletableFuture<Void> save(@NotNull final List<GenericEmpleadoResultItemDto> src,
      @NotNull final TareaDto tareaDto) {
    this.tareaLocalizacionPersonaPresenciaService.save(src, tareaDto);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> savePtrPresenciaDetalle(@NotNull final List<PtrPresenciaDetalleResultItemDto> src,
      @NotNull final TareaDto tareaDto, @NotNull final Integer idTipoDato) {
    this.tareaLocalizacionPersonaPresenciaService.savePtrPresenciaDetalle(src, tareaDto, idTipoDato);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> updateActivo(@NotNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPersonaPresenciaService.updateActivo(runTareaDto);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> updateActivoPersonasExternas(
      @NotNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPersonaPresenciaService.updateActivoPersonasExternas(runTareaDto);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
