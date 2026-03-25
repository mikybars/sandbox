package com.inditex.rrhh.icmclcwb.model.app.run.mantenimiento.limpieza.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.limpieza.service.RunMantenimientoLimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLimpiezaService;
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

  private final TareaLimpiezaService tareaLimpiezaService;

  private final SenderLimpieza senderLimpieza;

  @Override
  public RunMantenimientoLimpiezaDTO run() {
    final SecurityContext securityContext = SecurityContextHolder.getContext();

    CompletableFuture.runAsync(new DelegatingSecurityContextRunnable(() -> {
      try {
        final RunMantenimientoLimpiezaDTO result = this.tareaService.findLimpieza();
        this.procesarLimpieza(result, "limpieza");
      } catch (final Exception e) {
        this.manejarErrorLimpieza("Error en proceso de limpieza background", e);
      }
    }, securityContext)).exceptionally(error -> {
      this.manejarErrorLimpieza("Excepción no capturada en limpieza background", error);
      return null;
    });
    return new RunMantenimientoLimpiezaDTO();
  }

  @Override
  public RunMantenimientoLimpiezaDTO runIdTarea(@NotNull final Long id) {
    final SecurityContext securityContext = SecurityContextHolder.getContext();

    CompletableFuture.runAsync(new DelegatingSecurityContextRunnable(() -> {
      try {
        final RunMantenimientoLimpiezaDTO result = this.tareaService.findLimpiezaByIdTarea(id);
        this.procesarLimpieza(result, "limpieza por ID");
      } catch (final Exception e) {
        this.manejarErrorLimpieza("Error en proceso de limpieza por ID background", e);
      }
    }, securityContext)).exceptionally(error -> {
      this.manejarErrorLimpieza("Excepción no capturada en limpieza por ID background", error);
      return null;
    });
    return new RunMantenimientoLimpiezaDTO();
  }

  private void procesarLimpieza(final RunMantenimientoLimpiezaDTO result, final String contexto) {
    if (result == null || result.getIdTarea() == null || result.getIdTarea().isEmpty()) {
      return;
    }

    try {
      // Guardar tareas en BD (SÍNCRONO)
      final List<TareaLimpiezaDto> tareas = this.tareaLimpiezaService.save(result.getIdTarea());

      // Enviar tareas a cola JMS (SÍNCRONO)
      if (tareas != null && !tareas.isEmpty()) {
        tareas.forEach(this.senderLimpieza::send);
      }

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
