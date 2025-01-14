package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarSlrhorcomsService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaRecolectarSlrhorcomsAsyncServiceImplTest {
  @Mock
  private RunTareaRecolectarSlrhorcomsService runTareaRecolectarSlrhorcomsService;

  @InjectMocks
  private RunTareaRecolectarSlrhorcomsAsyncServiceImpl runTareaRecolectarSlrhorcomsAsyncService;

  @Test
  void horarioComercialFestivoByRunTareaTest() {
    this.runTareaRecolectarSlrhorcomsAsyncService.horarioComercialFestivoByRunTarea(new RunTareaDto());
    verify(this.runTareaRecolectarSlrhorcomsService).horarioComercialFestivoByRunTarea(any(RunTareaDto.class));
  }

}
