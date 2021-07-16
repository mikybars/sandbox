package com.inditex.rrhh.icmclcwb.ws.app.test.controller;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.inditex.rrhh.icmclcwb.api.app.test.dto.RelojDto;
import com.inditex.rrhh.icmclcwb.api.app.test.dto.SsoDto;
import com.inditex.rrhh.icmclcwb.api.app.test.service.TestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class TestControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TestService testServiceMock;

    @InjectMocks
    private TestController testController;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.testController)
            .build();
    }

    @Test
    public void reloj() throws Exception {
        when(this.testServiceMock.reloj()).thenReturn(new RelojDto());
        this.mockMvc.perform(get("/test/reloj/")).andReturn();
        verify(this.testServiceMock, times(1)).reloj();
    }

    @Test
    public void sso() throws Exception {
        when(this.testServiceMock.sso()).thenReturn(SsoDto.builder().result("test").build());
        this.mockMvc.perform(get("/test/sso/")).andReturn();
        verify(this.testServiceMock, times(1)).sso();
    }

    @Test
    public void errorSync() throws Exception {
        this.mockMvc.perform(get("/test/error/sync/")).andReturn();
        verify(this.testServiceMock, times(1)).errorSync();
    }

    @Test
    public void errorAsync() throws Exception {
        this.mockMvc.perform(get("/test/error/async/")).andReturn();
        verify(this.testServiceMock, times(1)).errorAsync();
    }

    @Test
    public void sesion() throws Exception {
        this.mockMvc.perform(get("/test/sesion/")).andReturn();
        verify(this.testServiceMock, times(1)).sesion();
    }

    @Test
    public void programacionBatch() throws Exception {
        this.mockMvc.perform(get("/test/programacion/batch/")).andReturn();
        verify(this.testServiceMock, times(1)).programacionBatch();
    }

    @Test
    public void testConcurrencia() throws Exception {
        this.mockMvc.perform(post("/test/trabajo/test/{limit}", 1)).andReturn();
        verify(this.testServiceMock, times(1)).testBloqueos(1L);
    }

    @Test
    public void testUrl() throws Exception {
        when(this.testServiceMock.testUrl(any(String.class))).thenReturn(Boolean.TRUE);
        this.mockMvc.perform(post("/test/test/url/").content("url")).andReturn();
        verify(this.testServiceMock, times(1)).testUrl(any(String.class));
    }

    @Test
    public void trabajoFase1a() throws Exception {
        this.mockMvc.perform(get("/test/trabajo/fase1a")).andReturn();
        verify(this.testServiceMock, times(1)).trabajoFase1a();
    }

    @Test
    public void sqlformatter() throws Exception {
        this.mockMvc.perform(post("/test/sql/formatter/").contentType(MediaType.TEXT_PLAIN).content("string"))
            .andReturn();
        verify(this.testServiceMock, times(1)).sqlFormatter("string");
    }

}
