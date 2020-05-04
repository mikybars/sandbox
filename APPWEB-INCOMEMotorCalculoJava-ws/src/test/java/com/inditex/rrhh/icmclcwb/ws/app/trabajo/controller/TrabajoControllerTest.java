package com.inditex.rrhh.icmclcwb.ws.app.trabajo.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.Validator;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;

@RunWith(MockitoJUnitRunner.class)
public class TrabajoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private Validator validator;

    @Mock
    private TrabajoService trabajoServiceMock;

    @InjectMocks
    private TrabajoController trabajoController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(trabajoController)
            .setValidator(validator)
            .build();
    }

    @Test
    public void create() throws Exception {
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoEnum.EMPRESA.getDto());
        trabajo.setIcmIdPeriodo(1L);
        trabajo.setIdOrganization("AT");
        trabajo.setFechaInicioPeriodo(LocalDate.parse("2017-03-01"));
        trabajo.setFechaFinPeriodo(LocalDate.parse("2017-03-31"));

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        mapper.setSerializationInclusion(Include.NON_NULL);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(trabajo);

        when(trabajoServiceMock.create(any(TrabajoDto.class))).thenReturn(new TrabajoDto());
        mockMvc.perform(post("/trabajo").contentType(MediaType.APPLICATION_JSON).content(requestJson)).andReturn();
        verify(trabajoServiceMock, times(1)).create(any(TrabajoDto.class));
    }

}
