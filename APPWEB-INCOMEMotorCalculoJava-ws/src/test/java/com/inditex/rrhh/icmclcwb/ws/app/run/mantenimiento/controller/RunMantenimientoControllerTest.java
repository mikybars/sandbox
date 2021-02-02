package com.inditex.rrhh.icmclcwb.ws.app.run.mantenimiento.controller;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.dto.RunMantenimientoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.service.RunMantenimientoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RunMantenimientoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private RunMantenimientoService runMantenimientoServiceMock;

    @InjectMocks
    private RunMantenimientoController runMantenimientoController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.runMantenimientoController)
            .build();
    }

    @Test
    public void run() throws Exception {
        when(this.runMantenimientoServiceMock.run()).thenReturn(new RunMantenimientoDto());
        this.mockMvc.perform(get("/run/mantenimiento/force")).andReturn();
        verify(this.runMantenimientoServiceMock, times(1)).run();
    }

}
