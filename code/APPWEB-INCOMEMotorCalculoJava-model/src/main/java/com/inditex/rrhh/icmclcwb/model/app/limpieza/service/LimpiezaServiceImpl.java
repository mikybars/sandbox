package com.inditex.rrhh.icmclcwb.model.app.limpieza.service;

import com.inditex.rrhh.icmclcwb.api.app.limpieza.service.LimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.run.limpieza.dto.RunLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoLimpiezaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.model.primary.limpieza.repository.LimpiezaRepositoryCustom;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class LimpiezaServiceImpl implements LimpiezaService {

  private final LimpiezaRepositoryCustom limpiezaRepositoryCustom;

  private final TrabajoService trabajoService;

  @Override
  public void runTarea(@NonNull @Valid final RunLimpiezaDto limpieza) {
    final TareaDto tarea = limpieza.getTarea();
    try {
      this.limpiezaRepositoryCustom.inicioLimpieza(limpieza.getId());
      tarea.getAmbito().forEach(item -> this.limpiezaRepositoryCustom.limpiezaTareaProfunda(tarea, item));
      this.limpiezaRepositoryCustom.updateEstado(limpieza.getId(), EstadoLimpiezaEnum.OK.getDto());
    } catch (final Exception e) {
      this.limpiezaRepositoryCustom.updateEstado(limpieza.getId(), EstadoLimpiezaEnum.KO.getDto());
      throw e;
    } finally {
      this.limpiezaRepositoryCustom.updateFechaFinalizacion(limpieza.getId());
    }
  }

  @Override
  public void limpiezaAmbito(@NonNull @Valid final TareaDto tarea) {
    tarea.getAmbito().forEach(item -> this.limpiezaRepositoryCustom.limpieza(tarea, item));
  }

  @Override
  public void limpiezaTareaPersonaHistorico(@NonNull @Valid final TareaDto tarea) {
    this.limpiezaRepositoryCustom.limpiezaTareaPersonaHistorico(tarea);
  }

  @Override
  public void limpiezaTareaLocalizacionHistorico(@NonNull @Valid final TareaDto tarea) {
    this.limpiezaRepositoryCustom.limpiezaTareaLocalizacionHistorico(tarea);
  }

  @Override
  public void limpiezaTareaGlobalLocalizacionPersona(@NonNull @Valid final TareaDto tarea) {
    this.limpiezaRepositoryCustom.limpiezaTareaGlobalLocalizacionPersona(tarea);
  }

  @Override
  public void limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(@NonNull @Valid final TareaDto tarea) {
    this.limpiezaRepositoryCustom.limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(tarea);
  }

  @Override
  public void limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(@NonNull @Valid final TareaDto tarea) {
    this.limpiezaRepositoryCustom.limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(tarea);
  }

  @Override
  public void limpiezaTareaAmbitoLocalizacion(@NonNull @Valid final TareaDto tarea) {
    tarea.getAmbito()
        .forEach(ambito -> this.limpiezaRepositoryCustom.limpiezaTareaAmbitoLocalizacion(tarea, ambito));
  }

  @Override
  public void limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(@NonNull @Valid final TareaDto tarea) {
    this.limpiezaRepositoryCustom.limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(tarea);
  }

  @Override
  public void limpiezaTareaAmbitoGlobalPersona(@NonNull @Valid final TareaDto tarea) {
    this.limpiezaRepositoryCustom.limpiezaTareaAmbitoGlobalPersona(tarea);
  }

}
