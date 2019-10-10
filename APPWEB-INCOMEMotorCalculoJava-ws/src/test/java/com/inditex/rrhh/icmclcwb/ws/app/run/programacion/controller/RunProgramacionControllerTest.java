package com.inditex.rrhh.icmclcwb.ws.app.run.programacion.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.inditex.rrhh.icmclcwb.api.app.run.programacion.dto.RunProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.service.RunProgramacionService;

@RunWith(MockitoJUnitRunner.class)
public class RunProgramacionControllerTest {

    private MockMvc mockMvc;
    
    @Mock
    private RunProgramacionService runProgramacionServiceMock;
    
    @InjectMocks
    private RunProgramacionController runProgramacionController;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(runProgramacionController)
                .build();
    }
    
    @Test
    public void run() throws Exception {
        when(runProgramacionServiceMock.run()).thenReturn(new ArrayList<RunProgramacionDto>());
        mockMvc.perform(get("/run/programacion")).andReturn();
        verify(runProgramacionServiceMock, times(1)).run();
    }

}