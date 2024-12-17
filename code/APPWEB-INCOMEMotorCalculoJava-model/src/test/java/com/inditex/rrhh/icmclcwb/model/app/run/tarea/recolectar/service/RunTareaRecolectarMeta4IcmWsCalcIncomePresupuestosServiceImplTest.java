package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomePresupuestosService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaRecolectarMeta4IcmWsCalcIncomePresupuestosServiceImplTest {
  private final RunTareaDto runTarea = new RunTareaDto();

  private final TareaDto tarea = new TareaDto();

  private final List<TareaAmbitoDto> ambito = new ArrayList<>();

  private final TareaAmbitoDto am1 = new TareaAmbitoDto();

  private final TareaAmbitoDto am2 = new TareaAmbitoDto();

  @Mock
  private RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomePresupuestosService runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService;

  @InjectMocks
  private RunTareaRecolectarMeta4IcmWsCalcIncomePresupuestosServiceImpl runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosService;

  @Test
  void personaByRunTareaTest() {

    this.tarea.setAmbito(this.ambito);
    this.runTarea.setTarea(this.tarea);
    this.ambito.add(this.am1);
    this.ambito.add(this.am2);

    this.runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosService.personaByRunTarea(this.runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(2)).personaByRunTareaAndTareaAmbito(any(RunTareaDto.class),
        any(TareaAmbitoDto.class));
  }

  @Test
  void localizacionByRunTareaTest() {
    this.tarea.setAmbito(this.ambito);
    this.runTarea.setTarea(this.tarea);
    this.ambito.add(this.am1);
    this.ambito.add(this.am2);

    this.runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosService.localizacionByRunTarea(this.runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(2)).localizacionByRunTareaAndTareaAmbito(any(RunTareaDto.class),
        any(TareaAmbitoDto.class));
  }

  @Test
  void empleadosPresenciaByRunTareaTest() {
    this.tarea.setAmbito(this.ambito);
    this.runTarea.setTarea(this.tarea);
    this.ambito.add(this.am1);

    this.runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosService.empleadosPresenciaByRunTarea(this.runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1)).empleadosPresenciaByRunTareaAndTareaAmbito(
        any(RunTareaDto.class),
        any(TareaAmbitoDto.class));
  }

  @Test
  void empleadosDesplazamientoByRunTareaTest() {
    this.tarea.setAmbito(this.ambito);
    this.runTarea.setTarea(this.tarea);
    this.ambito.add(this.am1);

    this.runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosService.empleadosDesplazamientoByRunTarea(this.runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1)).empleadosDesplazamientoByRunTareaAndTareaAmbito(
        any(RunTareaDto.class),
        any(TareaAmbitoDto.class));
  }
}
