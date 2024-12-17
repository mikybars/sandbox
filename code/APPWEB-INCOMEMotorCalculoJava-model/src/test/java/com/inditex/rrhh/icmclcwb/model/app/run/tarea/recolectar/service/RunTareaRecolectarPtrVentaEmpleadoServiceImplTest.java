package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrVentaEmpleadoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaRecolectarPtrVentaEmpleadoServiceImplTest {
  @Mock
  private RunTareaAmbitoRecolectarPtrVentaEmpleadoService runTareaAmbitoRecolectarPtrVentaEmpleadoService;

  @InjectMocks
  private RunTareaRecolectarPtrVentaEmpleadoServiceImpl runTareaRecolectarPtrVentaEmpleadoService;

  @Test
  void ventaFisicaLocalizacionPersonaByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    runTarea.setTarea(tarea);
    ambito.add(new TareaAmbitoDto());

    this.runTareaRecolectarPtrVentaEmpleadoService.ventaFisicaLocalizacionPersonaByRunTarea(runTarea);
    verify(this.runTareaAmbitoRecolectarPtrVentaEmpleadoService)
        .ventaFisicaLocalizacionPersonaByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(
            TareaAmbitoDto.class));
  }
}
