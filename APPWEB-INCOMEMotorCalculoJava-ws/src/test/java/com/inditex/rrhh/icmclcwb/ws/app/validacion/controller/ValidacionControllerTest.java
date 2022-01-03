package com.inditex.rrhh.icmclcwb.ws.app.validacion.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaValidarService;

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
public class ValidacionControllerTest {

  private MockMvc mockMvc;

  @Mock
  private TareaValidarService validacionServiceMock;

  @InjectMocks
  private ValidacionController validacionController;

  @BeforeEach
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    this.mockMvc = MockMvcBuilders.standaloneSetup(this.validacionController)
        .build();
  }

  @Test
  public void validateByIdTarea() throws Exception {
    when(this.validacionServiceMock.validateByIdTarea(1L)).thenReturn(new HashMap<>());
    this.mockMvc.perform(get("/validacion/tarea/{idTarea}", "1")).andReturn();
    verify(this.validacionServiceMock, times(1)).validateByIdTarea(any(Long.class));
  }

  @Test
  public void validateByIdTrabajo() throws Exception {
    when(this.validacionServiceMock.validateByIdTrabajo(1L)).thenReturn(new ArrayList<Map<String, Object>>());
    this.mockMvc.perform(get("/validacion/trabajo/{idTarea}", "1")).andReturn();
    verify(this.validacionServiceMock, times(1)).validateByIdTrabajo(any(Long.class));
  }

}
