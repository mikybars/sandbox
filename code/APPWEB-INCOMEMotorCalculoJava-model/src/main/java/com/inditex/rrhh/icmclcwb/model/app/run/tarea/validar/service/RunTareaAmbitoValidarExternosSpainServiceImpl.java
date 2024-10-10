package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/*
 * Copyright (c) 2021. Inditex
 */
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalExternaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarExternosSpainService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaAmbitoValidarExternosSpainServiceImpl extends AbstractRunTareaAmbitoValidarExternos
    implements RunTareaAmbitoValidarExternosSpainService {

  private static final Logger LOG = LoggerFactory.getLogger(RunTareaAmbitoValidarExternosSpainServiceImpl.class);

  @Override
  protected CompletableFuture<List<IdPersonaLocalExternaDto>> findExternos(
      final RunTareaDto runTarea,
      final TareaAmbitoDto tareaAmbito) {

    LOG.info("Tarea[{}] - RunTareaAmbitoValidarExternosSpainServiceImpl.execute(..)", runTarea.getTarea().getId());

    return CompletableFuture.completedFuture(new ArrayList<>());
  }

}
