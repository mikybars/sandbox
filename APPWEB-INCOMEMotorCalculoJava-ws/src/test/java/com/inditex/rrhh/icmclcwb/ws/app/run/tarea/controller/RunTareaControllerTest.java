package com.inditex.rrhh.icmclcwb.ws.app.run.tarea.controller;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.inditex.rrhh.icmclcwb.api.app.run.service.RunService;
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

@RunWith(MockitoJUnitRunner.class)
public class RunTareaControllerTest {

    private MockMvc mockMvc;

    @Mock
    private RunService runService;

    @InjectMocks
    private RunTareaController runTareaController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.runTareaController)
            .build();
    }

    @Test
    public void runTareaPreValidar() throws Exception {
        final Long id = 1L;
        this.mockMvc.perform(get("/run/tarea/prevalidar/{id}", id)).andReturn();
        verify(this.runService, times(1)).runTareaPreValidar(id);
        this.runService.runTareaPreValidar(id);
    }

}
