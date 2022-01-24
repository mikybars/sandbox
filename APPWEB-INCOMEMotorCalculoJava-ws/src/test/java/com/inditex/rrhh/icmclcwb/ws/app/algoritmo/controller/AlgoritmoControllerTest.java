package com.inditex.rrhh.icmclcwb.ws.app.algoritmo.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Arrays;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.AlgoritmoService;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;

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
public class AlgoritmoControllerTest {

  private MockMvc mockMvc;

  @Mock
  private AlgoritmoService algoritmoServiceMock;

  @InjectMocks
  private AlgoritmoController algoritmoController;

  @BeforeEach
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    this.mockMvc = MockMvcBuilders.standaloneSetup(this.algoritmoController)
        .build();
  }

  @Test
  public void findAll() throws Exception {
    final AlgoritmoDTO algoritmo = new AlgoritmoDTO();
    algoritmo.setId(1);
    algoritmo.setActivo(Boolean.TRUE);
    algoritmo.setDesplazamiento(Boolean.FALSE);
    algoritmo.setDesplazamientoBase(Boolean.FALSE);
    algoritmo.setNombre("test");
    when(this.algoritmoServiceMock.findAll()).thenReturn(Arrays.asList(algoritmo));

    this.mockMvc.perform(get("/algoritmo")).andReturn();

    verify(this.algoritmoServiceMock, times(1)).findAll();
  }

  @Test
  public void checkDuplicatedActives() throws Exception {
    when(this.algoritmoServiceMock.checkDuplicatedActives()).thenReturn(Boolean.TRUE);
    this.mockMvc.perform(get("/algoritmo/checkDuplicatedActives")).andReturn();
    verify(this.algoritmoServiceMock, times(1)).checkDuplicatedActives();
  }

  @Test
  public void findById() throws Exception {
    final AlgoritmoDTO algoritmo = new AlgoritmoDTO();
    algoritmo.setId(1);
    algoritmo.setActivo(Boolean.TRUE);
    algoritmo.setDesplazamiento(Boolean.FALSE);
    algoritmo.setDesplazamientoBase(Boolean.FALSE);
    algoritmo.setNombre("test");
    when(this.algoritmoServiceMock.findById(1)).thenReturn(algoritmo);
    this.mockMvc.perform(get("/algoritmo/{id}", "1")).andReturn();
    verify(this.algoritmoServiceMock, times(1)).findById(any(Integer.class));
  }

}
