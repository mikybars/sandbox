package com.inditex.rrhh.icmclcwb.model.app.periodo.service;

import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.PeriodoCalculoPersonaRepositoryCustom;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class PeriodoCalculoPersonaServiceImpl implements PeriodoCalculoPersonaService {

  private final PeriodoCalculoPersonaRepositoryCustom periodoCalculoPersonaRepositoryCustom;

  @Override
  public void mergePeriodoCalculoPersona(@NotNull final RunTareaDto tareaDto) {
    this.periodoCalculoPersonaRepositoryCustom.mergePeriodoCalculoPersona(tareaDto);
  }

  @Override
  public void limpiezaPeriodoCalculoPersona(@NotNull final RunTareaDto tareaDto,
      @NotNull final TareaAmbitoDto tareaAmbitoDto) {
    this.periodoCalculoPersonaRepositoryCustom.limpiezaPeriodoCalculoPersona(tareaDto, tareaAmbitoDto);
  }

}
