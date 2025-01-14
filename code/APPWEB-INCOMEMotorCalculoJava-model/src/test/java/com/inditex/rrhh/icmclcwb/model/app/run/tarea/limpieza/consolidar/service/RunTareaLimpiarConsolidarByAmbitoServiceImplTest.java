package com.inditex.rrhh.icmclcwb.model.app.run.tarea.limpieza.consolidar.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.limpiar.consolidar.ambito.service.RunTareaAmbitoLimpiarConsolidarByAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.limpiar.consolidar.service.RunTareaLimpiarConsolidarByAmbitoServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaLimpiarConsolidarByAmbitoServiceImplTest {
  @Mock
  private RunTareaAmbitoLimpiarConsolidarByAmbitoService runTareaAmbitoLimpiarConsolidarByAmbitoService;

  @InjectMocks
  private RunTareaLimpiarConsolidarByAmbitoServiceImpl runTareaLimpiarConsolidarByAmbitoService;

  @Test
  void runTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    final TareaAmbitoDto t1 = new TareaAmbitoDto();
    ambito.add(t1);
    tarea.setAmbito(ambito);

    this.runTareaLimpiarConsolidarByAmbitoService.run(runTarea);

    verify(this.runTareaAmbitoLimpiarConsolidarByAmbitoService, times(1)).run(any(RunTareaDto.class), any(TareaAmbitoDto.class));

  }

}
