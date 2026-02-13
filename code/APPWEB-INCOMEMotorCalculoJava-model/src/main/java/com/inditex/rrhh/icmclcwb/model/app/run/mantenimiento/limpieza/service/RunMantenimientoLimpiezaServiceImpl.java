package com.inditex.rrhh.icmclcwb.model.app.run.mantenimiento.limpieza.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.amigafwk.common.reactor.autoconfiguration.ItxSchedulers;
import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.limpieza.service.RunMantenimientoLimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLimpiezaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.dto.RunMantenimientoLimpiezaDTO;
import com.inditex.rrhh.icmclcwb.ms.app.limpieza.SenderLimpieza;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Validated
@RequiredArgsConstructor
public class RunMantenimientoLimpiezaServiceImpl implements RunMantenimientoLimpiezaService {

  private static final Logger LOG = LoggerFactory.getLogger(RunMantenimientoLimpiezaServiceImpl.class);

  private final TareaService tareaService;

  private final TareaLimpiezaAsyncService tareaLimpiezaAsyncService;

  private final SenderLimpieza senderLimpieza;

  @Override
  public RunMantenimientoLimpiezaDTO run() {
    this.procesarLimpieza(this.tareaService::findLimpieza, "limpieza");
    return new RunMantenimientoLimpiezaDTO();
  }

  @Override
  public RunMantenimientoLimpiezaDTO runIdTarea(@NotNull final Long id) {
    this.procesarLimpieza(() -> this.tareaService.findLimpiezaByIdTarea(id), "limpieza por ID");
    return new RunMantenimientoLimpiezaDTO();
  }

  /**
   * Procesa la limpieza de tareas de forma asincrónica.
   *
   * @param tareaSupplier proveedor de tareas (findLimpieza o findLimpiezaByIdTarea)
   * @param contexto contexto para los logs (ej: "limpieza" o "limpieza por ID")
   */
  private void procesarLimpieza(final java.util.function.Supplier<RunMantenimientoLimpiezaDTO> tareaSupplier,
      final String contexto) {
    Mono.fromCallable(tareaSupplier::get)
        .subscribeOn(reactor.core.scheduler.Schedulers.boundedElastic())
        .doFinally(signalType -> {
        })
        .subscribe(
            result -> this.procesarResultadoLimpieza(result, contexto),
            error -> this.manejarErrorLimpieza("Error obteniendo tareas para " + contexto, error));
  }

  /**
   * Procesa el resultado de la búsqueda de tareas.
   *
   * @param result resultado de la búsqueda
   * @param contexto contexto para los logs
   */
  @SuppressWarnings("unchecked")
  private void procesarResultadoLimpieza(final RunMantenimientoLimpiezaDTO result, final String contexto) {
    if (result == null || result.getIdTarea() == null || result.getIdTarea().isEmpty()) {
      return;
    }

    CompletableFuture.runAsync(() -> this.ejecutarGuardadoYEnvio((List<Object>) (List<?>) result.getIdTarea(), contexto));
  }

  /**
   * Ejecuta el guardado de tareas de limpieza y su envío a la cola.
   *
   * @param idTareas lista de IDs de tareas (viene de result.getIdTarea())
   * @param contexto contexto para los logs
   */
  @SuppressWarnings("unchecked")
  private void ejecutarGuardadoYEnvio(final List<Object> idTareas, final String contexto) {
    try {
      // Casting implícito ya que viene de result.getIdTarea()
      final CompletableFuture<List<TareaLimpiezaDto>> future =
          this.tareaLimpiezaAsyncService.save((List) idTareas);
      Mono.fromFuture(future)
          .subscribe(
              tareas -> this.procesarTareasGuardadas(tareas, contexto),
              error -> this.manejarErrorLimpieza("Error en " + contexto, error));
    } catch (final Exception e) {
      this.manejarErrorLimpieza("Excepción en " + contexto, e);
    }
  }

  /**
   * Procesa las tareas guardadas y las envía a la cola.
   *
   * @param tareas tareas guardadas
   * @param contexto contexto para los logs
   */
  private void procesarTareasGuardadas(final List<TareaLimpiezaDto> tareas, final String contexto) {
    if (tareas != null && !tareas.isEmpty()) {
      Flux.fromIterable(tareas)
          .parallel()
          .runOn(ItxSchedulers.single())
          .doOnNext(this.senderLimpieza::send)
          .sequential()
          .doOnError(error -> this.manejarErrorLimpieza("Error enviando tareas en " + contexto, error))
          .subscribe(
              success -> {
              },
              err -> this.manejarErrorLimpieza("Error en Flux de " + contexto, err));
    }
  }

  /**
   * Maneja los errores de limpieza.
   *
   * @param mensaje mensaje de error
   * @param error excepción ocurrida
   */
  private void manejarErrorLimpieza(final String mensaje, final Throwable error) {
    if (LOG.isErrorEnabled()) {
      LOG.error(mensaje, error);
    }
  }

}
