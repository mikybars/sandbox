package com.inditex.rrhh.icmclcwb.model.app.periodo.service;

import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoLocalizacionPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.PeriodoLocalizacionPersonaRepositoryCustom;

import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class PeriodoLocalizacionPersonaServiceImpl implements PeriodoLocalizacionPersonaService {

  private final PeriodoLocalizacionPersonaRepositoryCustom periodoLocalizacionPersonaRepositoryCustom;

  @Override
  public void mergePeriodoLocalizacionPersona(@NonNull final RunTareaDto tareaDto) {
    this.periodoLocalizacionPersonaRepositoryCustom.mergePeriodoLocalizacionPersona(tareaDto);
  }

  @Override
  public void limpiezaPeriodoLocalizacionPersona(@NonNull final RunTareaDto tareaDto,
      @NonNull final TareaAmbitoDto tareaAmbitoDto) {
    this.periodoLocalizacionPersonaRepositoryCustom.limpiezaPeriodoLocalizacionPersona(tareaDto, tareaAmbitoDto);
  }

}
