package com.inditex.rrhh.icmclcwb.ws.app.programacion.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionService;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionDTO;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
public class ProgramacionControllerTest {

  private MockMvc mockMvc;

  @Mock
  private ProgramacionService programacionServiceMock;

  @InjectMocks
  private ProgramacionController programacionController;

  @BeforeEach
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    this.mockMvc = MockMvcBuilders.standaloneSetup(this.programacionController)
        .build();
  }

  @Test
  public void create() throws Exception {
    final ProgramacionDTO programacion = new ProgramacionDTO();
    programacion.setActivo(Boolean.TRUE);
    programacion.setHoraProgramacion(LocalTime.parse("10:00").atOffset(ZoneOffset.UTC).atDate(LocalDate.now()));
    programacion.setTipoAmbito(TipoAmbitoEnum.EMPRESA.getDto());
    final ProgramacionAmbitoDTO ambito = new ProgramacionAmbitoDTO();
    ambito.setIdOrganization("AT");
    final List<ProgramacionAmbitoDTO> programacionAmbito = new ArrayList<ProgramacionAmbitoDTO>();
    programacionAmbito.add(ambito);
    programacion.setAmbito(programacionAmbito);
    final ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    mapper.setSerializationInclusion(Include.NON_NULL);
    final ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
    final String requestJson = ow.writeValueAsString(programacion);

    when(this.programacionServiceMock.create(any(ProgramacionDTO.class))).thenReturn(new ProgramacionDTO());
    this.mockMvc.perform(post("/programacion").contentType(MediaType.APPLICATION_JSON).content(requestJson))
        .andReturn();
    verify(this.programacionServiceMock, times(1)).create(any(ProgramacionDTO.class));
  }

  @Test
  public void reset() throws Exception {
    this.mockMvc.perform(get("/programacion/reset")).andReturn();
    verify(this.programacionServiceMock, times(1)).reset();
  }

  @Test
  public void activa() throws Exception {
    this.mockMvc.perform(get("/programacion/activa")).andReturn();
    verify(this.programacionServiceMock, times(1)).activa();
  }

  @Test
  public void activaId() throws Exception {
    this.mockMvc.perform(get("/programacion/activa/{id}", 1)).andReturn();
    verify(this.programacionServiceMock, times(1)).activa(1L);
  }

  @Test
  public void desactiva() throws Exception {
    this.mockMvc.perform(get("/programacion/desactiva")).andReturn();
    verify(this.programacionServiceMock, times(1)).desactiva();
  }

  @Test
  public void desactivaId() throws Exception {
    this.mockMvc.perform(get("/programacion/desactiva/{id}", 1)).andReturn();
    verify(this.programacionServiceMock, times(1)).desactiva(1L);
  }

}
