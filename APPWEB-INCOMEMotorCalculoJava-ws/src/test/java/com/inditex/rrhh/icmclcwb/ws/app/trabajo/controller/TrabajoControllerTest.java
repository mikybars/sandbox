package com.inditex.rrhh.icmclcwb.ws.app.trabajo.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.time.LocalDate;
import java.time.OffsetTime;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.Validator;

@ExtendWith(SpringExtension.class)
public class TrabajoControllerTest {

  private MockMvc mockMvc;

  @Mock
  private Validator validator;

  @Mock
  private TrabajoService trabajoServiceMock;

  @InjectMocks
  private TrabajoController trabajoController;

  @BeforeEach
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    this.mockMvc = MockMvcBuilders.standaloneSetup(this.trabajoController)
        .setValidator(this.validator)
        .build();
  }

  @Test
  public void create() throws Exception {
    final TrabajoDTO trabajo = new TrabajoDTO();
    trabajo.setTipoAmbito(TipoAmbitoEnum.EMPRESA.getDto());
    trabajo.setIcmIdPeriodo(1L);
    trabajo.setIdOrganization("AT");
    trabajo.setFechaInicioPeriodo(LocalDate.parse("2017-03-01").atTime(OffsetTime.now()));
    trabajo.setFechaFinPeriodo(LocalDate.parse("2017-03-31").atTime(OffsetTime.now()));

    final ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    mapper.setSerializationInclusion(Include.NON_NULL);
    final ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
    final String requestJson = ow.writeValueAsString(trabajo);

    when(this.trabajoServiceMock.create(any(TrabajoDTO.class))).thenReturn(new TrabajoDTO());
    this.mockMvc.perform(post("/trabajo").contentType(MediaType.APPLICATION_JSON).content(requestJson)).andReturn();
    verify(this.trabajoServiceMock, times(1)).create(any(TrabajoDTO.class));
  }

}
