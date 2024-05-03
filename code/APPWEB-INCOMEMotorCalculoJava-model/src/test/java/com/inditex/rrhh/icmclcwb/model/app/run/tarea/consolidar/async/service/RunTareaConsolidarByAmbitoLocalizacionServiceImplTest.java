package com.inditex.rrhh.icmclcwb.model.app.run.tarea.consolidar.async.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.async.service.RunTareaConsolidarPeriodoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class RunTareaConsolidarByAmbitoLocalizacionServiceImplTest {
  @Mock
  private RunTareaConsolidarPeriodoAsyncService runTareaConsolidarPeriodoAsyncService;

  @InjectMocks
  private RunTareaConsolidarByAmbitoLocalizacionServiceImpl runTareaConsolidarByAmbitoLocalizacionService;

  @Test
  void runTest() {
    @NotNull
    @Valid final RunTareaDto runTarea = new RunTareaDto();
    this.runTareaConsolidarByAmbitoLocalizacionService.run(runTarea);
  }

}
