package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarIopcomercialcalendarService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaRecolectarIopcomercialcalendarAsyncServiceImplTest {
  @Mock
  private RunTareaRecolectarIopcomercialcalendarService runTareaRecolectarIopcomercialcalendarService;

  @InjectMocks
  private RunTareaRecolectarIopcomercialcalendarAsyncServiceImpl runTareaRecolectarIopcomercialcalendarAsyncService;

  @Test
  void horarioComercialFestivoByRunTareaTest() {
    this.runTareaRecolectarIopcomercialcalendarAsyncService.horarioComercialFestivoByRunTarea(new RunTareaDto());
    verify(this.runTareaRecolectarIopcomercialcalendarService).horarioComercialFestivoByRunTarea(any(RunTareaDto.class));
  }

}
