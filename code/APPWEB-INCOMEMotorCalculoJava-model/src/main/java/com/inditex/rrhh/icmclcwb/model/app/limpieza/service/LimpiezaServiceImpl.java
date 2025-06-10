package com.inditex.rrhh.icmclcwb.model.app.limpieza.service;

import com.inditex.rrhh.icmclcwb.api.app.limpieza.service.LimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.run.limpieza.dto.RunLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoLimpiezaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.primary.limpieza.repository.LimpiezaRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class LimpiezaServiceImpl implements LimpiezaService {

  private final LimpiezaRepositoryCustom limpiezaRepositoryCustom;

  private final TrabajoService trabajoService;

  @Override
  public void runTarea(@NotNull @Valid final RunLimpiezaDto limpieza) {
    final TareaDto tarea = limpieza.getTarea();
    final TrabajoDTO trabajo = this.trabajoService.find(tarea.getIdTrabajo());
    try {
      this.limpiezaRepositoryCustom.inicioLimpieza(limpieza.getId());
      tarea.getAmbito().forEach(item -> this.limpiezaRepositoryCustom.limpiezaTareaProfunda(tarea, item, trabajo));
      this.limpiezaRepositoryCustom.updateEstado(limpieza.getId(), EstadoLimpiezaEnum.OK.getDto());
    } catch (final Exception e) {
      this.limpiezaRepositoryCustom.updateEstado(limpieza.getId(), EstadoLimpiezaEnum.KO.getDto());
      throw e;
    } finally {
      this.limpiezaRepositoryCustom.updateFechaFinalizacion(limpieza.getId());
    }
  }

  @Override
  public void limpiezaAmbito(@NotNull @Valid final TareaDto tarea) {
    final TrabajoDTO trabajo = this.trabajoService.find(tarea.getIdTrabajo());
    tarea.getAmbito().forEach(item -> this.limpiezaRepositoryCustom.limpieza(tarea, item, trabajo));
  }

  @Override
  public void limpiezaTareaPersonaHistorico(@NotNull @Valid final TareaDto tarea) {
    this.limpiezaRepositoryCustom.limpiezaTareaPersonaHistorico(tarea);
  }

  @Override
  public void limpiezaTareaLocalizacionHistorico(@NotNull @Valid final TareaDto tarea) {
    this.limpiezaRepositoryCustom.limpiezaTareaLocalizacionHistorico(tarea);
  }

  @Override
  public void limpiezaTareaGlobalLocalizacionPersona(@NotNull @Valid final TareaDto tarea) {
    this.limpiezaRepositoryCustom.limpiezaTareaGlobalLocalizacionPersona(tarea);
  }

  @Override
  public void limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(@NotNull @Valid final TareaDto tarea) {
    this.limpiezaRepositoryCustom.limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(tarea);
  }

  @Override
  public void limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(@NotNull @Valid final TareaDto tarea) {
    this.limpiezaRepositoryCustom.limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(tarea);
  }

  @Override
  public void limpiezaTareaAmbitoLocalizacion(@NotNull @Valid final TareaDto tarea) {
    tarea.getAmbito()
        .forEach(ambito -> this.limpiezaRepositoryCustom.limpiezaTareaAmbitoLocalizacion(tarea, ambito));
  }

  @Override
  public void limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(@NotNull @Valid final TareaDto tarea) {
    this.limpiezaRepositoryCustom.limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(tarea);
  }

  @Override
  public void limpiezaTareaAmbitoGlobalPersona(@NotNull @Valid final TareaDto tarea) {
    this.limpiezaRepositoryCustom.limpiezaTareaAmbitoGlobalPersona(tarea);
  }

}
