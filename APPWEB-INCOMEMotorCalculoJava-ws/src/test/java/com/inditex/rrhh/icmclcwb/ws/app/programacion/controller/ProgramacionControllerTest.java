package com.inditex.rrhh.icmclcwb.ws.app.programacion.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionService;

@RunWith(MockitoJUnitRunner.class)
public class ProgramacionControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProgramacionService programacionServiceMock;

    @InjectMocks
    private ProgramacionController programacionController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(programacionController)
            .build();
    }

    @Test
    public void create() throws Exception {
        ProgramacionDto programacion = new ProgramacionDto();
        programacion.setActivo(Boolean.TRUE);
        programacion.setHoraProgramacion(LocalTime.parse("10:00"));
        programacion.setTipoAmbito(TipoAmbitoEnum.EMPRESA.getDto());
        ProgramacionAmbitoDto ambito = new ProgramacionAmbitoDto();
        ambito.setIdOrgenization("AT");
        List<ProgramacionAmbitoDto> programacionAmbito = new ArrayList<ProgramacionAmbitoDto>();
        programacionAmbito.add(ambito);
        programacion.setAmbito(programacionAmbito);
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        mapper.setSerializationInclusion(Include.NON_NULL);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(programacion);

        when(programacionServiceMock.create(any(ProgramacionDto.class))).thenReturn(new ProgramacionDto());
        mockMvc.perform(post("/programacion").contentType(MediaType.APPLICATION_JSON).content(requestJson)).andReturn();
        verify(programacionServiceMock, times(1)).create(any(ProgramacionDto.class));
    }

    @Test
    public void reset() throws Exception {
        mockMvc.perform(get("/programacion/reset")).andReturn();
        verify(programacionServiceMock, times(1)).reset();
    }

    @Test
    public void activa() throws Exception {
        mockMvc.perform(get("/programacion/activa")).andReturn();
        verify(programacionServiceMock, times(1)).activa();
    }

    @Test
    public void activaId() throws Exception {
        mockMvc.perform(get("/programacion/activa/{id}", 1)).andReturn();
        verify(programacionServiceMock, times(1)).activa(1L);
    }

    @Test
    public void desactiva() throws Exception {
        mockMvc.perform(get("/programacion/desactiva")).andReturn();
        verify(programacionServiceMock, times(1)).desactiva();
    }

    @Test
    public void desactivaId() throws Exception {
        mockMvc.perform(get("/programacion/desactiva/{id}", 1)).andReturn();
        verify(programacionServiceMock, times(1)).desactiva(1L);
    }

}
