package com.inditex.rrhh.icmclcwb.model.app.run.mantenimiento.limpieza.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
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
    final RunMantenimientoLimpiezaDTO result = this.tareaService.findLimpieza();
    this.procesarLimpiezaAsync(result, "limpieza");
    return result;
  }

  @Override
  public RunMantenimientoLimpiezaDTO runIdTarea(@NotNull final Long id) {
    final RunMantenimientoLimpiezaDTO result = this.tareaService.findLimpiezaByIdTarea(id);
    this.procesarLimpiezaAsync(result, "limpieza por ID");
    return result;
  }

  @SuppressWarnings("unchecked")
  private void procesarLimpiezaAsync(final RunMantenimientoLimpiezaDTO result, final String contexto) {
    if (result == null || result.getIdTarea() == null || result.getIdTarea().isEmpty()) {
      return;
    }

    // Inicia la limpieza en UN THREAD SEPARADO pero con garantías
    CompletableFuture.supplyAsync(() -> {
      try {
        if (LOG.isDebugEnabled()) {
          LOG.debug("Iniciando limpieza en background para: {}", contexto);
        }

        // SÍNCRONO DENTRO DEL THREAD: Guardar tareas
        final List<TareaLimpiezaDto> tareas = this.tareaLimpiezaAsyncService
            .save(result.getIdTarea())
            .get();

        // SÍNCRONO DENTRO DEL THREAD: Enviar tareas a cola
        if (tareas != null && !tareas.isEmpty()) {
          tareas.forEach(this.senderLimpieza::send);
          if (LOG.isDebugEnabled()) {
            LOG.debug("Limpieza completada para: {} - {} tareas procesadas", contexto, tareas.size());
          }
        }

        return tareas;

      } catch (final InterruptedException e) {
        // Compliant: restaurar el estado interrumpido del thread y lanzar excepción específica
        this.manejarErrorLimpieza("Thread interrumpido durante limpieza: " + contexto, e);
        Thread.currentThread().interrupt();
        throw new IcmclcwbException("Error: Thread interrumpido durante " + contexto, e);
      } catch (final Exception e) {
        this.manejarErrorLimpieza("Error durante limpieza en background: " + contexto, e);
        throw new IcmclcwbException("Error: Fallo durante limpieza en background de " + contexto, e);
      }
    })
        .exceptionally(error -> {
          this.manejarErrorLimpieza(
              "Excepción no capturada en limpieza background: " + contexto,
              error.getCause() != null ? error.getCause() : error);
          return null;
        });
  }

  private void manejarErrorLimpieza(final String mensaje, final Throwable error) {
    if (LOG.isErrorEnabled()) {
      LOG.error(mensaje, error);
    }
  }

}
