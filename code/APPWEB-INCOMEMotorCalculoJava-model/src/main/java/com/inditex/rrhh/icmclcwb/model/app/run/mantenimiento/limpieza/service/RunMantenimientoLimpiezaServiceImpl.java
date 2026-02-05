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
    // Ejecutar findLimpieza() de forma ASYNC
    Mono.fromCallable(() -> this.tareaService.findLimpieza())
        .subscribeOn(reactor.core.scheduler.Schedulers.boundedElastic())
        .doFinally(signalType -> {
          // ...limpieza de recursos...
        })
        .subscribe(
            result -> {
              // Si result es null o está vacío, no hacer nada
              if (result == null || result.getIdTarea() == null || result.getIdTarea().isEmpty()) {
                return;
              }

              // Ejecutar limpieza en background
              CompletableFuture.runAsync(() -> {
                try {
                  final CompletableFuture<List<TareaLimpiezaDto>> future =
                      this.tareaLimpiezaAsyncService.save(result.getIdTarea());
                  Mono.fromFuture(future)
                      .subscribe(
                          tareas -> {
                            if (tareas != null && !tareas.isEmpty()) {
                              Flux.fromIterable(tareas)
                                  .parallel()
                                  .runOn(ItxSchedulers.single())
                                  .doOnNext(this.senderLimpieza::send)
                                  .sequential()
                                  .doOnError(error -> {
                                    if (LOG.isErrorEnabled()) {
                                      LOG.error("Error enviando tareas en limpieza", error);
                                    }
                                  })
                                  .subscribe(
                                      success -> {
                                      },
                                      err -> {
                                        if (LOG.isErrorEnabled()) {
                                          LOG.error("Error en Flux de limpieza", err);
                                        }
                                      });
                            }
                          },
                          error -> {
                            if (LOG.isErrorEnabled()) {
                              LOG.error("Error en limpieza", error);
                            }
                          });
                } catch (final Exception e) {
                  if (LOG.isErrorEnabled()) {
                    LOG.error("Excepción en limpieza", e);
                  }
                }
              });
            },
            error -> {
              if (LOG.isErrorEnabled()) {
                LOG.error("Error obteniendo tareas para limpieza", error);
              }
            });

    return new RunMantenimientoLimpiezaDTO();
  }

  @Override
  public RunMantenimientoLimpiezaDTO runIdTarea(@NotNull final Long id) {
    // Ejecutar findLimpiezaByIdTarea() de forma ASYNC
    Mono.fromCallable(() -> this.tareaService.findLimpiezaByIdTarea(id))
        .subscribeOn(reactor.core.scheduler.Schedulers.boundedElastic())
        .doFinally(signalType -> {
          // ...limpieza de recursos...
        })
        .subscribe(
            result -> {
              // Si result es null o está vacío, no hacer nada (silencioso)
              if (result == null || result.getIdTarea() == null || result.getIdTarea().isEmpty()) {
                return;
              }

              // Ejecutar limpieza en background
              CompletableFuture.runAsync(() -> {
                try {
                  final CompletableFuture<List<TareaLimpiezaDto>> future =
                      this.tareaLimpiezaAsyncService.save(result.getIdTarea());
                  Mono.fromFuture(future)
                      .subscribe(
                          tareas -> {
                            if (tareas != null && !tareas.isEmpty()) {
                              Flux.fromIterable(tareas)
                                  .parallel()
                                  .runOn(ItxSchedulers.single())
                                  .doOnNext(this.senderLimpieza::send)
                                  .sequential()
                                  .doOnError(error -> {
                                    if (LOG.isErrorEnabled()) {
                                      LOG.error("Error enviando tareas en limpieza por ID", error);
                                    }
                                  })
                                  .subscribe(
                                      success -> {
                                      },
                                      err -> {
                                        if (LOG.isErrorEnabled()) {
                                          LOG.error("Error en Flux de limpieza por ID", err);
                                        }
                                      });
                            }
                          },
                          error -> {
                            if (LOG.isErrorEnabled()) {
                              LOG.error("Error en limpieza por ID", error);
                            }
                          });
                } catch (final Exception e) {
                  if (LOG.isErrorEnabled()) {
                    LOG.error("Excepción en limpieza por ID", e);
                  }
                }
              });
            },
            error -> {
              if (LOG.isErrorEnabled()) {
                LOG.error("Error obteniendo tareas por ID para limpieza", error);
              }
            });

    return new RunMantenimientoLimpiezaDTO();
  }

}
