package com.inditex.rrhh.icmclcwb.model.app.periodo.service;

import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoLocalizacionPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.PeriodoLocalizacionPersonaRepositoryCustom;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class PeriodoLocalizacionPersonaServiceImpl implements PeriodoLocalizacionPersonaService {

  @Autowired
  private PeriodoLocalizacionPersonaRepositoryCustom periodoLocalizacionPersonaRepositoryCustom;

  @Override
  public void mergePeriodoLocalizacionPersona(@NotNull final RunTareaDto tareaDto) {
    this.periodoLocalizacionPersonaRepositoryCustom.mergePeriodoLocalizacionPersona(tareaDto);
  }

  @Override
  public void limpiezaPeriodoLocalizacionPersona(@NotNull final RunTareaDto tareaDto,
      @NotNull final TareaAmbitoDto tareaAmbitoDto) {
    this.periodoLocalizacionPersonaRepositoryCustom.limpiezaPeriodoLocalizacionPersona(tareaDto, tareaAmbitoDto);
  }

}
