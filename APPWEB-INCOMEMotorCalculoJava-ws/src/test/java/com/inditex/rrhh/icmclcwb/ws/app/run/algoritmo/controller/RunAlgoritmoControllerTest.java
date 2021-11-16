package com.inditex.rrhh.icmclcwb.ws.app.run.algoritmo.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Arrays;

import com.inditex.rrhh.icmclcwb.api.app.run.calcular.service.RunAlgoritmoService;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.dto.RunAlgoritmoDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
public class RunAlgoritmoControllerTest {

  private MockMvc mockMvc;

  @Mock
  private RunAlgoritmoService runAlgoritmoServiceMock;

  @InjectMocks
  private RunAlgoritmoController runAlgoritmoController;

  @BeforeEach
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    this.mockMvc = MockMvcBuilders.standaloneSetup(this.runAlgoritmoController)
        .build();
  }

  @Test
  public void findById() throws Exception {
    final RunAlgoritmoDTO runAlgoritmo = new RunAlgoritmoDTO();
    final AlgoritmoDTO algoritmo = new AlgoritmoDTO();
    algoritmo.setId(1);
    algoritmo.setActivo(Boolean.TRUE);
    algoritmo.setDesplazamiento(Boolean.FALSE);
    algoritmo.setDesplazamientoBase(Boolean.FALSE);
    algoritmo.setNombre("test");
    runAlgoritmo.setAlgoritmo(algoritmo);
    runAlgoritmo.setSqlCalcular("SELECT * FROM TEST");

    when(this.runAlgoritmoServiceMock.findById(1)).thenReturn(runAlgoritmo);
    this.mockMvc.perform(get("/run/algoritmo/{id}", "1")).andReturn();
    verify(this.runAlgoritmoServiceMock, times(1)).findById(any(Integer.class));
  }

  @Test
  public void findAll() throws Exception {
    final RunAlgoritmoDTO runAlgoritmo = new RunAlgoritmoDTO();
    final AlgoritmoDTO algoritmo = new AlgoritmoDTO();
    algoritmo.setId(1);
    algoritmo.setActivo(Boolean.TRUE);
    algoritmo.setDesplazamiento(Boolean.FALSE);
    algoritmo.setDesplazamientoBase(Boolean.FALSE);
    algoritmo.setNombre("test");
    runAlgoritmo.setAlgoritmo(algoritmo);
    runAlgoritmo.setSqlCalcular("SELECT * FROM TEST");

    when(this.runAlgoritmoServiceMock.findAll()).thenReturn(Arrays.asList(runAlgoritmo));

    this.mockMvc.perform(get("/run/algoritmo")).andReturn();

    verify(this.runAlgoritmoServiceMock, times(1)).findAll();
  }

}
