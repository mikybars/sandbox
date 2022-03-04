package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarComisionManualService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class RunTareaValidarComisionManualServiceImplTest {

  @Mock
  private TareaFaseAccionService tareaFaseAccionService;

  @Mock
  private RunTareaAmbitoValidarComisionManualService runTareaAmbitoValidarComisionManualService;

  @Mock
  private AccionService accionService;

  @InjectMocks
  private RunTareaValidarComisionManualServiceImpl runTareaValidarComisionManualService;

  @Test
  void executeTest(@Random final RunTareaDto runTarea, @Random final TareaFaseAccionDto tareaFaseAccion) {

    final TareaDto tarea = runTarea.getTarea();
    when(this.accionService.findByIdAccionAndIdOrigenAndStdIdLegEnt(
        ArgumentMatchers.any(Integer.class), ArgumentMatchers.any(String.class),
        ArgumentMatchers.any(String.class)))
            .thenReturn(Boolean.TRUE);

    final ValidacionDto validacion = new ValidacionDto();
    validacion.setResult(Boolean.FALSE);
    when(this.runTareaAmbitoValidarComisionManualService.execute(ArgumentMatchers.any(RunTareaDto.class),
        ArgumentMatchers.any(TareaAmbitoDto.class),
        ArgumentMatchers.any(TareaFaseAccionDto.class)))
            .thenReturn(validacion);

    this.runTareaValidarComisionManualService.execute(runTarea, tareaFaseAccion);

    verify(this.tareaFaseAccionService, timeout(1000).times(1)).updateFechaInicio(tareaFaseAccion);

    for (final TareaAmbitoDto ambito : tarea.getAmbito()) {
      verify(this.accionService, timeout(1000).times(1)).findByIdAccionAndIdOrigenAndStdIdLegEnt(tareaFaseAccion.getIdAccion(),
          ambito.getCclIdOrigen(), tarea.getStdIdLegEnt());
      verify(this.runTareaAmbitoValidarComisionManualService, timeout(1000).times(1)).execute(runTarea, ambito, tareaFaseAccion);
    }

  }

}
