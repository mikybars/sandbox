package com.inditex.rrhh.icmclcwb.ws.app.run.mantenimiento.controller;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.service.RunMantenimientoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

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
        // when(runMantenimientoServiceMock.run()).thenReturn(new RunMantenimientoDto());
        // mockMvc.perform(get("/run/mantenimiento")).andReturn();
        // verify(runMantenimientoServiceMock, times(1)).run();
    }

}
