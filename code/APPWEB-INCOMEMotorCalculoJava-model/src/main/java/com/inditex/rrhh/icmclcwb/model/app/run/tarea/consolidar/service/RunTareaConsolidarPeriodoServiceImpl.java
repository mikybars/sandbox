package com.inditex.rrhh.icmclcwb.model.app.run.tarea.consolidar.service;

import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoLocalizacionPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.service.RunTareaConsolidarPeriodoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import org.jspecify.annotations.NonNull;
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
  public void mergePeriodoCalculoPersona(@NonNull final RunTareaDto tareaDto) {
    this.periodoCalculoPersonaService.mergePeriodoCalculoPersona(tareaDto);
  }

  @Override
  public void limpiezaPeriodoCalculoPersona(@NonNull final RunTareaDto tareaDto,
      @NonNull final TareaAmbitoDto tareaAmbitoDto) {
    this.periodoCalculoPersonaService.limpiezaPeriodoCalculoPersona(tareaDto, tareaAmbitoDto);
  }

  @Override
  public void mergePeriodoPersona(@NonNull final RunTareaDto tareaDto) {
    this.periodoPersonaService.mergePeriodoPersona(tareaDto);
  }

  @Override
  public void limpiezaPeriodoPersona(@NonNull final RunTareaDto tareaDto,
      @NonNull final TareaAmbitoDto tareaAmbitoDto) {
    this.periodoPersonaService.limpiezaPeriodoPersona(tareaDto, tareaAmbitoDto);
  }

  @Override
  public void mergePeriodoLocalizacion(@NonNull final RunTareaDto tareaDto) {
    this.periodoLocalizacionService.mergePeriodoLocalizacion(tareaDto);
  }

  @Override
  public void limpiezaPeriodoLocalizacion(@NonNull final RunTareaDto tareaDto,
      @NonNull final TareaAmbitoDto tareaAmbitoDto) {
    this.periodoLocalizacionService.limpiezaPeriodoLocalizacion(tareaDto, tareaAmbitoDto);
  }

  @Override
  public void mergePeriodoLocalizacionPersona(@NonNull final RunTareaDto tareaDto) {
    this.periodoLocalizacionPersonaService.mergePeriodoLocalizacionPersona(tareaDto);
  }

  @Override
  public void limpiezaPeriodoLocalizacionPersona(@NonNull final RunTareaDto tareaDto,
      @NonNull final TareaAmbitoDto tareaAmbitoDto) {
    this.periodoLocalizacionPersonaService.limpiezaPeriodoLocalizacionPersona(tareaDto, tareaAmbitoDto);
  }

}
