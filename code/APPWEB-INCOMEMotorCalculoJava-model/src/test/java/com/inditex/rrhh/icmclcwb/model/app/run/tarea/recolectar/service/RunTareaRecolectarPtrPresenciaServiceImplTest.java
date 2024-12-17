package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaRecolectarPtrPresenciaServiceImplTest {
  @Mock
  private RunTareaAmbitoRecolectarPtrPresenciaService runTareaAmbitoRecolectarPtrPresenciaService;

  @InjectMocks
  private RunTareaRecolectarPtrPresenciaServiceImpl runTareaRecolectarPtrPresenciaService;

  @Test
  void presenciaDetalleComisionablePersonaByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    ambito.add(tareaAmbito);

    this.runTareaRecolectarPtrPresenciaService.presenciaDetalleComisionablePersonaByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarPtrPresenciaService).presenciaDetallePersonaByRunTareaAndTareaAmbito(any(RunTareaDto.class),
        any(TareaAmbitoDto.class));
  }

  @Test
  void presenciaEmpleadoTiendaByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    ambito.add(tareaAmbito);

    this.runTareaRecolectarPtrPresenciaService.presenciaEmpleadoTiendaByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarPtrPresenciaService).presenciaEmpleadoTiendaByRunTareaAndTareaAmbito(any(RunTareaDto.class),
        any(TareaAmbitoDto.class));
  }

  @Test
  void presenciaDetalleIncluidoCommercePersonaByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    ambito.add(tareaAmbito);

    this.runTareaRecolectarPtrPresenciaService.presenciaDetalleIncluidoCommercePersonaByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarPtrPresenciaService).presenciaDetallePersonaIncluidoEcommerceByRunTareaAndTareaAmbito(
        any(RunTareaDto.class),
        any(TareaAmbitoDto.class));
  }

  @Test
  void presenciaDetallePersonaHorasSindicalesByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    ambito.add(tareaAmbito);

    this.runTareaRecolectarPtrPresenciaService.presenciaDetallePersonaHorasSindicalesByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarPtrPresenciaService).presenciaDetallePersonaHorasSindicalesByRunTareaAndTareaAmbito(
        any(RunTareaDto.class),
        any(TareaAmbitoDto.class));
  }
}
