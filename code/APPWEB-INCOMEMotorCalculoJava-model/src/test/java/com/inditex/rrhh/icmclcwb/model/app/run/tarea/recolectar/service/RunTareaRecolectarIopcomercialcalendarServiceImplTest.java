package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarIopcomercialcalendarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaRecolectarIopcomercialcalendarServiceImplTest {
  @Mock
  private RunTareaAmbitoRecolectarIopcomercialcalendarService runTareaAmbitoRecolectarIopcomercialcalendarService;

  @InjectMocks
  private RunTareaRecolectarIopcomercialcalendarServiceImpl runTareaRecolectarIopcomercialcalendarService;

  @Test
  void horarioComercialFestivoByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tarea.setAmbito(ambito);
    ambito.add(tareaAmbito);
    runTarea.setTarea(tarea);

    this.runTareaRecolectarIopcomercialcalendarService.horarioComercialFestivoByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarIopcomercialcalendarService).horarioComercialFestivoByRunTareaAndTareaAmbito(any(RunTareaDto.class),
        any(
            TareaAmbitoDto.class));
  }
}
