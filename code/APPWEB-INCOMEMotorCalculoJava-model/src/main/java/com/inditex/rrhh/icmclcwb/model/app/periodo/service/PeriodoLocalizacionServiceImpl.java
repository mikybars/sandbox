package com.inditex.rrhh.icmclcwb.model.app.periodo.service;

import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.PeriodoLocalizacionRepositoryCustom;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class PeriodoLocalizacionServiceImpl implements PeriodoLocalizacionService {

  private final PeriodoLocalizacionRepositoryCustom periodoLocalizacionRepositoryCustom;

  @Override
  public void mergePeriodoLocalizacion(@NotNull final RunTareaDto tareaDto) {
    this.periodoLocalizacionRepositoryCustom.mergePeriodoLocalizacion(tareaDto);
  }

  @Override
  public void limpiezaPeriodoLocalizacion(@NotNull final RunTareaDto tareaDto,
      @NotNull final TareaAmbitoDto tareaAmbitoDto) {
    this.periodoLocalizacionRepositoryCustom.limpiezaPeriodoLocalizacion(tareaDto, tareaAmbitoDto);
  }

}
