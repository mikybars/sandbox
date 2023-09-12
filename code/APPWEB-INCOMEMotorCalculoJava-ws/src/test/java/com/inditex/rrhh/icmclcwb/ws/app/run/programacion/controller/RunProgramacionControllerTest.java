package com.inditex.rrhh.icmclcwb.ws.app.run.programacion.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.inditex.rrhh.icmclcwb.api.app.run.programacion.service.RunProgramacionService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
public class RunProgramacionControllerTest {

  private MockMvc mockMvc;

  @Mock
  private RunProgramacionService runProgramacionServiceMock;

  @InjectMocks
  private RunProgramacionController runProgramacionController;

  @BeforeEach
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    this.mockMvc = MockMvcBuilders.standaloneSetup(this.runProgramacionController)
        .build();
  }

  @Disabled
  @Test
  // TODO [COMUN] Generar nuevo test
  public void run() throws Exception {
    // when(runProgramacionServiceMock.run()).thenReturn(new ArrayList<RunProgramacionDto>());
    this.mockMvc.perform(get("/run/programacion")).andReturn();
    // verify(runProgramacionServiceMock, times(1)).run();
  }

}
