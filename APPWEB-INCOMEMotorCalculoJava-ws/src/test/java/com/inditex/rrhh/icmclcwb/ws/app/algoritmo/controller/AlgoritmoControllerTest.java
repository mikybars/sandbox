package com.inditex.rrhh.icmclcwb.ws.app.algoritmo.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

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
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.AlgoritmoService;


@RunWith(MockitoJUnitRunner.class)
public class AlgoritmoControllerTest {
    
    private MockMvc mockMvc;
    
    @Mock
    private AlgoritmoService algoritmoServiceMock;
    
    @InjectMocks
    private AlgoritmoController algoritmoController;

    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(algoritmoController)
                .build();
    }

    @Test
    public void findAll() throws Exception{
        AlgoritmoDto algoritmo = new AlgoritmoDto();
        algoritmo.setId(1);
        algoritmo.setActivo(Boolean.TRUE);
        algoritmo.setDesplazamiento(Boolean.FALSE);
        algoritmo.setDesplazamientoBase(Boolean.FALSE);
        algoritmo.setNombre("test");
        when(algoritmoServiceMock.findAll()).thenReturn(Arrays.asList(algoritmo));
        
        mockMvc.perform(get("/algoritmo")).andReturn();
        
        verify(algoritmoServiceMock, times(1)).findAll();
    }
    
    @Test
    public void checkDuplicatedActives() throws Exception{
        when(algoritmoServiceMock.checkDuplicatedActives()).thenReturn(Boolean.TRUE);
        mockMvc.perform(get("/algoritmo/checkDuplicatedActives")).andReturn();
        verify(algoritmoServiceMock, times(1)).checkDuplicatedActives();
    }
    
    @Test
    public void findById() throws Exception{
        AlgoritmoDto algoritmo = new AlgoritmoDto();
        algoritmo.setId(1);
        algoritmo.setActivo(Boolean.TRUE);
        algoritmo.setDesplazamiento(Boolean.FALSE);
        algoritmo.setDesplazamientoBase(Boolean.FALSE);
        algoritmo.setNombre("test");
        when(algoritmoServiceMock.findById(1)).thenReturn(algoritmo);
        mockMvc.perform(get("/algoritmo/{id}", "1")).andReturn();
        verify(algoritmoServiceMock, times(1)).findById(any(Integer.class));
    }
}
