package com.inditex.rrhh.icmclcwb.model.app.periodo.service;

import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.PeriodoPersonaRepositoryCustom;

import org.jspecify.annotations.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class PeriodoPersonaServiceImpl implements PeriodoPersonaService {

  private final PeriodoPersonaRepositoryCustom periodoPersonaRepositoryCustom;

  @Override
  public void mergePeriodoPersona(@NonNull final RunTareaDto tareaDto) {
    this.periodoPersonaRepositoryCustom.mergePeriodoPersona(tareaDto);
  }

  @Override
  public void limpiezaPeriodoPersona(@NonNull final RunTareaDto tareaDto,
      @NonNull final TareaAmbitoDto tareaAmbitoDto) {
    this.periodoPersonaRepositoryCustom.limpiezaPeriodoPersona(tareaDto, tareaAmbitoDto);
  }

}
