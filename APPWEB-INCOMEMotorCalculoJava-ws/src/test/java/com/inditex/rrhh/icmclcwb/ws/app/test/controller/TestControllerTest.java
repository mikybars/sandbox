package com.inditex.rrhh.icmclcwb.ws.app.test.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.ArgumentMatchers.any;


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

import com.inditex.rrhh.icmclcwb.api.app.test.dto.RelojDto;
import com.inditex.rrhh.icmclcwb.api.app.test.dto.SsoDto;
import com.inditex.rrhh.icmclcwb.api.app.test.service.TestService;

@RunWith(MockitoJUnitRunner.class)
public class TestControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TestService testServiceMock;

    @InjectMocks
    private TestController testController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(testController)
            .build();
    }

    @Test
    public void reloj() throws Exception {
        when(testServiceMock.reloj()).thenReturn(new RelojDto());
        mockMvc.perform(get("/test/reloj/")).andReturn();
        verify(testServiceMock, times(1)).reloj();
    }

    @Test
    public void sso() throws Exception {
        when(testServiceMock.sso()).thenReturn(SsoDto.builder().result("test").build());
        mockMvc.perform(get("/test/sso/")).andReturn();
        verify(testServiceMock, times(1)).sso();
    }

    @Test
    public void errorSync() throws Exception {
        mockMvc.perform(get("/test/error/sync/")).andReturn();
        verify(testServiceMock, times(1)).errorSync();
    }

    @Test
    public void errorAsync() throws Exception {
        mockMvc.perform(get("/test/error/async/")).andReturn();
        verify(testServiceMock, times(1)).errorAsync();
    }

    @Test
    public void sesion() throws Exception {
        mockMvc.perform(get("/test/sesion/")).andReturn();
        verify(testServiceMock, times(1)).sesion();
    }

    @Test
    public void programacionBatch() throws Exception {
        mockMvc.perform(get("/test/programacion/batch/")).andReturn();
        verify(testServiceMock, times(1)).programacionBatch();
    }

    @Test
    public void testConcurrencia() throws Exception {
        mockMvc.perform(post("/test/trabajo/test/{limit}", 1)).andReturn();
        verify(testServiceMock, times(1)).testBloqueos(1L);
    }

    @Test
    public void testUrl() throws Exception {
        when(testServiceMock.testUrl(any(String.class))).thenReturn(Boolean.TRUE);
        mockMvc.perform(post("/test/test/url/").content("url")).andReturn();
        verify(testServiceMock, times(1)).testUrl(any(String.class));
    }

    @Test
    public void trabajoFase1a() throws Exception {
        mockMvc.perform(get("/test/trabajo/fase1a")).andReturn();
        verify(testServiceMock, times(1)).trabajoFase1a();
    }

    @Test
    public void sqlformatter() throws Exception {
        mockMvc.perform(post("/test/sql/formatter/").contentType(MediaType.TEXT_PLAIN).content("string")).andReturn();
        verify(testServiceMock, times(1)).sqlFormatter("string");
    }

}
