package com.inditex.rrhh.icmclcwb.ws.app.validacion.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaValidarService;

@RunWith(MockitoJUnitRunner.class)
public class ValidacionControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TareaValidarService validacionServiceMock;

    @InjectMocks
    private ValidacionController validacionController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(validacionController)
            .build();
    }

    @Test
    public void validateByIdTarea() throws Exception {
        when(validacionServiceMock.validateByIdTarea(1L)).thenReturn(new HashMap<>());
        mockMvc.perform(get("/validacion/tarea/{idTarea}", "1")).andReturn();
        verify(validacionServiceMock, times(1)).validateByIdTarea(any(Long.class));
    }

    @Test
    public void validateByIdTrabajo() throws Exception {
        when(validacionServiceMock.validateByIdTrabajo(1L)).thenReturn(new ArrayList<Map<String, Object>>());
        mockMvc.perform(get("/validacion/trabajo/{idTarea}", "1")).andReturn();
        verify(validacionServiceMock, times(1)).validateByIdTrabajo(any(Long.class));
    }

}
