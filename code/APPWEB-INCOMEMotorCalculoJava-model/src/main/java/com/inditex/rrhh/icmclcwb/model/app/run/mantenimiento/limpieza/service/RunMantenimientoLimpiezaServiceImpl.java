package com.inditex.rrhh.icmclcwb.model.app.run.mantenimiento.limpieza.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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
import org.springframework.security.concurrent.DelegatingSecurityContextRunnable;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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
    // Capturar el contexto de seguridad ANTES de lanzar el thread
    final SecurityContext securityContext = SecurityContextHolder.getContext();

    // Ejecutar TODO en background para evitar 504, propagando el contexto de seguridad
    CompletableFuture.runAsync(new DelegatingSecurityContextRunnable(() -> {
      try {
        if (LOG.isInfoEnabled()) {
          LOG.info("Iniciando proceso de limpieza en background");
        }
        final RunMantenimientoLimpiezaDTO result = this.tareaService.findLimpieza();
        this.procesarLimpieza(result, "limpieza");
        if (LOG.isInfoEnabled()) {
          LOG.info("Proceso de limpieza en background finalizado");
        }
      } catch (final Exception e) {
        this.manejarErrorLimpieza("Error en proceso de limpieza background", e);
      }
    }, securityContext)).exceptionally(error -> {
      this.manejarErrorLimpieza("Excepción no capturada en limpieza background", error);
      return null;
    });
    // Retornar inmediatamente respuesta vacía
    return new RunMantenimientoLimpiezaDTO();
  }

  @Override
  public RunMantenimientoLimpiezaDTO runIdTarea(@NotNull final Long id) {
    // Capturar el contexto de seguridad ANTES de lanzar el thread
    final SecurityContext securityContext = SecurityContextHolder.getContext();

    // Ejecutar TODO en background para evitar 504, propagando el contexto de seguridad
    CompletableFuture.runAsync(new DelegatingSecurityContextRunnable(() -> {
      try {
        if (LOG.isInfoEnabled()) {
          LOG.info("Iniciando proceso de limpieza por ID {} en background", id);
        }
        final RunMantenimientoLimpiezaDTO result = this.tareaService.findLimpiezaByIdTarea(id);
        this.procesarLimpieza(result, "limpieza por ID");
        if (LOG.isInfoEnabled()) {
          LOG.info("Proceso de limpieza por ID {} en background finalizado", id);
        }
      } catch (final Exception e) {
        this.manejarErrorLimpieza("Error en proceso de limpieza por ID background", e);
      }
    }, securityContext)).exceptionally(error -> {
      this.manejarErrorLimpieza("Excepción no capturada en limpieza por ID background", error);
      return null;
    });
    // Retornar inmediatamente respuesta vacía
    return new RunMantenimientoLimpiezaDTO();
  }

  /**
   * Procesa la limpieza de forma SÍNCRONA (ya estamos en un thread separado).
   *
   * @param result resultado de la búsqueda de tareas
   * @param contexto contexto para logs
   */
  private void procesarLimpieza(final RunMantenimientoLimpiezaDTO result, final String contexto) {
    if (result == null || result.getIdTarea() == null || result.getIdTarea().isEmpty()) {
      if (LOG.isInfoEnabled()) {
        LOG.info("No hay tareas para limpiar en: {}", contexto);
      }
      return;
    }

    try {
      if (LOG.isInfoEnabled()) {
        LOG.info("Procesando {} tareas para {}", result.getIdTarea().size(), contexto);
      }

      // Guardar tareas en BD (SÍNCRONO)
      final List<TareaLimpiezaDto> tareas = this.tareaLimpiezaAsyncService
          .save(result.getIdTarea())
          .get();

      // Enviar tareas a cola JMS (SÍNCRONO)
      if (tareas != null && !tareas.isEmpty()) {
        tareas.forEach(this.senderLimpieza::send);
        if (LOG.isInfoEnabled()) {
          LOG.info("Limpieza completada para: {} - {} tareas enviadas a cola", contexto, tareas.size());
        }
      }

    } catch (final InterruptedException e) {
      Thread.currentThread().interrupt();
      this.manejarErrorLimpieza("Thread interrumpido durante " + contexto, e);
    } catch (final Exception e) {
      this.manejarErrorLimpieza("Error durante " + contexto, e);
    }
  }

  private void manejarErrorLimpieza(final String mensaje, final Throwable error) {
    if (LOG.isErrorEnabled()) {
      LOG.error(mensaje, error);
    }
  }

}
