package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrPresenciaPresupuestosService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaRecolectarPtrPresenciaPresupuestosServiceImplTest {
  @Mock
  private RunTareaAmbitoRecolectarPtrPresenciaPresupuestosService runTareaAmbitoRecolectarPtrPresenciaPresupuestosService;

  @InjectMocks
  private RunTareaRecolectarPtrPresenciaPresupuestosServiceImpl runTareaRecolectarPtrPresenciaPresupuestosService;

  @Test
  void presenciaEmpleadoTiendaByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(new TareaAmbitoDto());

    this.runTareaRecolectarPtrPresenciaPresupuestosService.presenciaEmpleadoTiendaByRunTarea(runTarea);
    verify(this.runTareaAmbitoRecolectarPtrPresenciaPresupuestosService)
        .presenciaEmpleadoTiendaByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(
            TareaAmbitoDto.class));
  }
}
