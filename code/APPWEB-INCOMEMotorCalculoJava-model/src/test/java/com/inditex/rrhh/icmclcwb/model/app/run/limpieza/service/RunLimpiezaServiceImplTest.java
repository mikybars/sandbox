package com.inditex.rrhh.icmclcwb.model.app.run.limpieza.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.limpieza.service.LimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.run.limpieza.dto.RunLimpiezaDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class RunLimpiezaServiceImplTest {
  @Mock
  private LimpiezaService limpiezaService;

  @InjectMocks
  private RunLimpiezaServiceImpl runLimpiezaServiceImpl;

  @Test
  void RunTest() {
    this.runLimpiezaServiceImpl.run(new RunLimpiezaDto());
    verify(this.limpiezaService, times(1)).runTarea(new RunLimpiezaDto());

  }
}
