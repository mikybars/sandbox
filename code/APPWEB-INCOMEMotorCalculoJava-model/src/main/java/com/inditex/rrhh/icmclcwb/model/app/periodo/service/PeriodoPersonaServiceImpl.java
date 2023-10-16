package com.inditex.rrhh.icmclcwb.model.app.periodo.service;

import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.PeriodoPersonaRepositoryCustom;

import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class PeriodoPersonaServiceImpl implements PeriodoPersonaService {

  @Autowired
  private PeriodoPersonaRepositoryCustom periodoPersonaRepositoryCustom;

  @Override
  public void mergePeriodoPersona(@NotNull final RunTareaDto tareaDto) {
    this.periodoPersonaRepositoryCustom.mergePeriodoPersona(tareaDto);
  }

  @Override
  public void limpiezaPeriodoPersona(@NotNull final RunTareaDto tareaDto,
      @NotNull final TareaAmbitoDto tareaAmbitoDto) {
    this.periodoPersonaRepositoryCustom.limpiezaPeriodoPersona(tareaDto, tareaAmbitoDto);
  }

}
