package com.inditex.rrhh.icmclcwb.model.app.run.mantenimiento.limpieza.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.aqsw.framework.common.reactor.autoconfiguration.ItxSchedulers;
import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.limpieza.service.RunMantenimientoLimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLimpiezaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.dto.RunMantenimientoLimpiezaDTO;
import com.inditex.rrhh.icmclcwb.ms.app.limpieza.SenderLimpieza;

import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Validated
public class RunMantenimientoLimpiezaServiceImpl implements RunMantenimientoLimpiezaService {

  @Autowired
  private TareaService tareaService;

  @Autowired
  private TareaLimpiezaAsyncService tareaLimpiezaAsyncService;

  @Autowired
  private SenderLimpieza senderLimpieza;

  @Override
  public RunMantenimientoLimpiezaDTO run() {
    final RunMantenimientoLimpiezaDTO result = this.tareaService.findLimpieza();
    final CompletableFuture<List<TareaLimpiezaDto>> future = this.tareaLimpiezaAsyncService
        .save(result.getIdTarea());
    Mono.fromFuture(future)
        .subscribe(tareas -> Flux.fromIterable(tareas)
            .parallel()
            .runOn(ItxSchedulers.single())
            .subscribe(this.senderLimpieza::send));
    return result;
  }

  @Override
  public RunMantenimientoLimpiezaDTO runIdTarea(@NotNull final Long id) {
    final RunMantenimientoLimpiezaDTO result = this.tareaService.findLimpiezaByIdTarea(id);
    final CompletableFuture<List<TareaLimpiezaDto>> future = this.tareaLimpiezaAsyncService
        .save(result.getIdTarea());
    Mono.fromFuture(future)
        .subscribe(tareas -> Flux.fromIterable(tareas)
            .parallel()
            .runOn(ItxSchedulers.single())
            .subscribe(this.senderLimpieza::send));
    return result;
  }

}
