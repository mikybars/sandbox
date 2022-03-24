package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.async.service.ComisAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarPersonasEsService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaAmbitoValidarPersonasEsServiceImpl extends AbstractRunTareaAmbitoValidarEmpleados
    implements RunTareaAmbitoValidarPersonasEsService {

  @Autowired
  private ComisAsyncService comisAsyncService;

  @Override
  protected List<IdPersonaLocalLocalizacionDto> obtenerEmpleadosComis(
      @Valid final RunTareaDto runTarea, @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final CompletableFuture<List<IdPersonaLocalLocalizacionDto>> cfPersonas = this.comisAsyncService
        .findPersonas(runTarea, tareaAmbito, AppConstants.MIN_ID_PERSONA_EXTERNO_ES);
    AsyncUtils.exceptionally(cfPersonas, cf);
    AsyncUtils.waitAllOfIsOk(cf, cf);
    return AsyncUtils.get(cfPersonas);
  }
}
