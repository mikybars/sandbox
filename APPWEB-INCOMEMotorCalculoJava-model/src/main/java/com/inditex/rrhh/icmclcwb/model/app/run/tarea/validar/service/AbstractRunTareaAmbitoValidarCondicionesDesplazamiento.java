package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

/*
 * Copyright (c) 2022. Inditex
 */
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;

import org.springframework.beans.factory.annotation.Autowired;

public class AbstractRunTareaAmbitoValidarCondicionesDesplazamiento {

  @Autowired
  private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

  List<IdPersonaLocalDto> getIdPersonaLocalDtos(final RunTareaDto runTareaDto, final TareaDto tareaDto,
      final CompletableFuture<List<IdPersonaLocalCondicionesDto>> cfCondicionesDesplazamiento) {
    final List<IdPersonaLocalDto> desplazamientoValidationResult;
    final List<IdPersonaLocalCondicionesDto> condicionesDesplazamiento = AsyncUtils
        .get(cfCondicionesDesplazamiento);

    this.primaryTemporaryTableRepositoryCustom.createTempComisDesplazamiento();
    this.primaryTemporaryTableRepositoryCustom.insertTempComisDesplazamiento(condicionesDesplazamiento);

    this.primaryTemporaryTableRepositoryCustom.desactivaFechasSolapadas();
    this.primaryTemporaryTableRepositoryCustom.reactivaFechasSolapadas(tareaDto);

    desplazamientoValidationResult = this.primaryTemporaryTableRepositoryCustom
        .validateTempComisDesplazamiento(runTareaDto.getTarea());

    this.primaryTemporaryTableRepositoryCustom.deleteTempComisDesplazamiento();
    return desplazamientoValidationResult;
  }
}
