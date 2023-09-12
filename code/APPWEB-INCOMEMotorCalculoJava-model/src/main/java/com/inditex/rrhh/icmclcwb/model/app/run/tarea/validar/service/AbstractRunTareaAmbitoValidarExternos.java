package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalExternaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaExternaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaExternaRepositoryCustom;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractRunTareaAmbitoValidarExternos {

  @Autowired
  private ValidacionMapper validacionMapper;

  @Autowired
  private TareaPersonaExternaMapper tareaPersonaExternaMapper;

  @Autowired
  private TareaPersonaExternaRepositoryCustom tareaPersonaExternaRepositoryCustom;

  protected abstract CompletableFuture<List<IdPersonaLocalExternaDto>> findExternos(final RunTareaDto runTarea,
      TareaAmbitoDto tareaAmbito);

  public ValidacionDto execute(final RunTareaDto runTarea,
      final TareaAmbitoDto tareaAmbito,
      final TareaFaseAccionDto tareaFaseAccion) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final CompletableFuture<List<IdPersonaLocalExternaDto>> cfExternos = this.findExternos(runTarea, tareaAmbito);
    AsyncUtils.exceptionally(cfExternos, cf);

    AsyncUtils.waitAllOfIsOk(cf, cf);

    final List<IdPersonaLocalExternaDto> externos = AsyncUtils.get(cfExternos);
    this.tareaPersonaExternaRepositoryCustom
        .save(this.tareaPersonaExternaMapper.idPersonaLocalExternaToTareaPersonaExterna(externos,
            runTarea.getTarea()));

    return this.validacionMapper.booleanToValidacionDto(tareaAmbito, tareaFaseAccion, true);
  }

}
