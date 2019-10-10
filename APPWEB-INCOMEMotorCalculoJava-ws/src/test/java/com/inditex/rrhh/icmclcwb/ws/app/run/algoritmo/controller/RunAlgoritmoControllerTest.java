package com.inditex.rrhh.icmclcwb.ws.app.run.algoritmo.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.calcular.dto.RunAlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.calcular.service.RunAlgoritmoService;

@RunWith(MockitoJUnitRunner.class)
public class RunAlgoritmoControllerTest {

    private MockMvc mockMvc;
    
    @Mock
    private RunAlgoritmoService runAlgoritmoServiceMock;
    
    @InjectMocks
    private RunAlgoritmoController runAlgoritmoController;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(runAlgoritmoController)
                .build();
    }
    
    @Test
    public void findById() throws Exception {
        RunAlgoritmoDto runAlgoritmo = new RunAlgoritmoDto();
        AlgoritmoDto algoritmo = new AlgoritmoDto();
        algoritmo.setId(1);
        algoritmo.setActivo(Boolean.TRUE);
        algoritmo.setDesplazamiento(Boolean.FALSE);
        algoritmo.setDesplazamientoBase(Boolean.FALSE);
        algoritmo.setNombre("test");
        runAlgoritmo.setAlgoritmo(algoritmo);
        runAlgoritmo.setSqlCalcular("SELECT * FROM TEST");
        
        when(runAlgoritmoServiceMock.findById(1)).thenReturn(runAlgoritmo);
        mockMvc.perform(get("/run/algoritmo/{id}", "1")).andReturn();
        verify(runAlgoritmoServiceMock, times(1)).findById(any(Integer.class));
    }

    @Test
    public void findAll() throws Exception {
        RunAlgoritmoDto runAlgoritmo = new RunAlgoritmoDto();
        AlgoritmoDto algoritmo = new AlgoritmoDto();
        algoritmo.setId(1);
        algoritmo.setActivo(Boolean.TRUE);
        algoritmo.setDesplazamiento(Boolean.FALSE);
        algoritmo.setDesplazamientoBase(Boolean.FALSE);
        algoritmo.setNombre("test");
        runAlgoritmo.setAlgoritmo(algoritmo);
        runAlgoritmo.setSqlCalcular("SELECT * FROM TEST");
        
        when(runAlgoritmoServiceMock.findAll()).thenReturn(Arrays.asList(runAlgoritmo));
        
        mockMvc.perform(get("/run/algoritmo")).andReturn();
        
        verify(runAlgoritmoServiceMock, times(1)).findAll();
    }
}
