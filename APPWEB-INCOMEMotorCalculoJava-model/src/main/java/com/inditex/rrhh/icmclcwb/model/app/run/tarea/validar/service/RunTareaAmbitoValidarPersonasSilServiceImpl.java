package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.async.service.ComisAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarPersonasSilService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaAmbitoValidarPersonasSilServiceImpl extends AbstractRunTareaAmbitoValidarEmpleados
    implements RunTareaAmbitoValidarPersonasSilService {

  @Autowired
  private ComisAsyncService comisAsyncService;

  @Autowired
  private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  @Override
  protected List<IdPersonaLocalLocalizacionDto> obtenerEmpleadosComis(
      @Valid final RunTareaDto runTarea, @Valid final TareaAmbitoDto tareaAmbito) {

    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<IdPersonaLocalLocalizacionDto> personasComis = new ArrayList<>();

    // llamar a Meta4 para obtener las clases y/o estado SIL
    final ClaseRequestDto request = ClaseRequestDto.builder().cclIdOrigen(tareaAmbito.getCclIdOrigen()).build();
    final ClaseResponseDto clases = this.meta4IcmWsCalcIncomeService.getClases(request);

    // obtención de las personas desde Comis usando las clases y estaod SIL
    final List<CompletableFuture<List<IdPersonaLocalLocalizacionDto>>> cfsPersonas = new ArrayList<>();
    clases.getItems().forEach(clase -> {
      final CompletableFuture<List<IdPersonaLocalLocalizacionDto>> cfPersonas =
          this.comisAsyncService.findPersonasSil(runTarea, tareaAmbito, AppConstants.MIN_ID_PERSONA_EXTERNO_NO_ES, clase);
      AsyncUtils.exceptionally(cfPersonas, cf);
      cfsPersonas.add(cfPersonas);
    });

    AsyncUtils.waitAllOfIsOk(cf, cf);
    cfsPersonas.forEach(cfPersonas -> personasComis.addAll(AsyncUtils.get(cfPersonas)));

    return personasComis;

  }
}
