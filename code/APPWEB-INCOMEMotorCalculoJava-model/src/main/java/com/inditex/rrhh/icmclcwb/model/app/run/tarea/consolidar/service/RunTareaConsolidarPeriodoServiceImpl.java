package com.inditex.rrhh.icmclcwb.model.app.run.tarea.consolidar.service;

import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoLocalizacionPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.service.RunTareaConsolidarPeriodoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaConsolidarPeriodoServiceImpl implements RunTareaConsolidarPeriodoService {

  @Autowired
  private PeriodoCalculoPersonaService periodoCalculoPersonaService;

  @Autowired
  private PeriodoPersonaService periodoPersonaService;

  @Autowired
  private PeriodoLocalizacionService periodoLocalizacionService;

  @Autowired
  private PeriodoLocalizacionPersonaService periodoLocalizacionPersonaService;

  @Override
  public void mergePeriodoCalculoPersona(@NotNull final RunTareaDto tareaDto) {
    this.periodoCalculoPersonaService.mergePeriodoCalculoPersona(tareaDto);
  }

  @Override
  public void limpiezaPeriodoCalculoPersona(@NotNull final RunTareaDto tareaDto,
      @NotNull final TareaAmbitoDto tareaAmbitoDto) {
    this.periodoCalculoPersonaService.limpiezaPeriodoCalculoPersona(tareaDto, tareaAmbitoDto);
  }

  @Override
  public void mergePeriodoPersona(@NotNull final RunTareaDto tareaDto) {
    this.periodoPersonaService.mergePeriodoPersona(tareaDto);
  }

  @Override
  public void limpiezaPeriodoPersona(@NotNull final RunTareaDto tareaDto,
      @NotNull final TareaAmbitoDto tareaAmbitoDto) {
    this.periodoPersonaService.limpiezaPeriodoPersona(tareaDto, tareaAmbitoDto);
  }

  @Override
  public void mergePeriodoLocalizacion(@NotNull final RunTareaDto tareaDto) {
    this.periodoLocalizacionService.mergePeriodoLocalizacion(tareaDto);
  }

  @Override
  public void limpiezaPeriodoLocalizacion(@NotNull final RunTareaDto tareaDto,
      @NotNull final TareaAmbitoDto tareaAmbitoDto) {
    this.periodoLocalizacionService.limpiezaPeriodoLocalizacion(tareaDto, tareaAmbitoDto);
  }

  @Override
  public void mergePeriodoLocalizacionPersona(@NotNull final RunTareaDto tareaDto) {
    this.periodoLocalizacionPersonaService.mergePeriodoLocalizacionPersona(tareaDto);
  }

  @Override
  public void limpiezaPeriodoLocalizacionPersona(@NotNull final RunTareaDto tareaDto,
      @NotNull final TareaAmbitoDto tareaAmbitoDto) {
    this.periodoLocalizacionPersonaService.limpiezaPeriodoLocalizacionPersona(tareaDto, tareaAmbitoDto);
  }

}
