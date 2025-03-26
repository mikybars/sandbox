package com.inditex.rrhh.icmclcwb.ws.app.test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;

import com.inditex.rrhh.icmclcwb.api.app.test.service.TestService;
import com.inditex.rrhh.icmclcwb.dto.AjusteComisionDTO;
import com.inditex.rrhh.icmclcwb.dto.RelojDTO;
import com.inditex.rrhh.icmclcwb.dto.SsoDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
class TestControllerTest {

  private MockMvc mockMvc;

  @Mock
  private TestService testServiceMock;

  @InjectMocks
  private TestController testController;

  @BeforeEach
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    this.mockMvc = MockMvcBuilders.standaloneSetup(this.testController)
        .build();
  }

  @Test
  void reloj() throws Exception {
    when(this.testServiceMock.reloj()).thenReturn(new RelojDTO());
    this.mockMvc.perform(get("/test/reloj")).andReturn();
    verify(this.testServiceMock, times(1)).reloj();
  }

  @Test
  void sso() throws Exception {
    when(this.testServiceMock.sso()).thenReturn(new SsoDTO());
    this.mockMvc.perform(get("/test/sso")).andReturn();
    verify(this.testServiceMock, times(1)).sso();
  }

  @Test
  void errorSync() throws Exception {
    this.mockMvc.perform(get("/test/error/sync")).andReturn();
    verify(this.testServiceMock, times(1)).errorSync();
  }

  @Test
  void errorAsync() throws Exception {
    this.mockMvc.perform(get("/test/error/async")).andReturn();
    verify(this.testServiceMock, times(1)).errorAsync();
  }

  @Test
  void sesion() throws Exception {
    this.mockMvc.perform(get("/test/sesion")).andReturn();
    verify(this.testServiceMock, times(1)).sesion();
  }

  @Test
  void programacionBatch() throws Exception {
    this.mockMvc.perform(get("/test/programacion/batch")).andReturn();
    verify(this.testServiceMock, times(1)).programacionBatch();
  }

  @Test
  void testConcurrencia() throws Exception {
    this.mockMvc.perform(post("/test/trabajo/{limit}", 1)).andReturn();
    verify(this.testServiceMock, times(1)).testBloqueos(1L);
  }

  // TODO:
  @Disabled("Revisar")
  @Test
  void testUrl() throws Exception {
    when(this.testServiceMock.testUrl(any(String.class))).thenReturn(Boolean.TRUE);
    this.mockMvc.perform(post("/test/url/").content("url")).andReturn();
    verify(this.testServiceMock, times(1)).testUrl(any(String.class));
  }

  @Test
  void trabajoFase1a() throws Exception {
    this.mockMvc.perform(get("/test/trabajo/fase1a")).andReturn();
    verify(this.testServiceMock, times(1)).trabajoFase1a();
  }

  // TODO:
  @Disabled("Revisar")
  @Test
  void sqlformatter() throws Exception {
    this.mockMvc.perform(post("/test/sql/formatter/").contentType(MediaType.TEXT_PLAIN).content("string"))
        .andReturn();
    verify(this.testServiceMock, times(1)).sqlFormatter("string");
  }

  // Comienzo de normalización de tareas consolidadas (para borrar)

  @Test
  void normalizarAjustecomisionTest() {
    final int limit = 10;

    final AjusteComisionDTO ajusteMock = new AjusteComisionDTO();
    ajusteMock.setTareasProcesadas(10);
    ajusteMock.setTareasPendientes(99);
    ajusteMock.setIdTarea(new ArrayList<>());
    when(this.testServiceMock.normalizarAjusteComision(any(Integer.class))).thenReturn(ajusteMock);

    final ResponseEntity<AjusteComisionDTO> response = this.testController
        .normalizarAjusteComision(limit);

    verify(this.testServiceMock, times(1)).normalizarAjusteComision(limit);

    assertEquals(ajusteMock, response.getBody());

  }

  // Fin de normalización de tareas consolidadas (para borrar)

}
