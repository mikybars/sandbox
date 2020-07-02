package com.inditex.rrhh.icmclcwb.ws.primary.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.io.Resource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.inditex.rrhh.icmclcwb.api.primary.service.PrimaryService;

@RunWith(MockitoJUnitRunner.class)
public class PrimaryControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PrimaryService primaryServiceMock;

    @InjectMocks
    private PrimaryController primaryController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(primaryController)
            .build();
    }

    @Test
    public void loadDML() throws Exception {
        when(primaryServiceMock.loadDML("1")).thenReturn(Boolean.TRUE);
        mockMvc.perform(get("/primary/load/dml/{path}", "1")).andReturn();
        verify(primaryServiceMock, times(1)).loadDML(any(String.class));
    }

    @Test
    public void changelogDML() throws Exception {
        String mockFile = "test";
        InputStream is = new ByteArrayInputStream(mockFile.getBytes());
        Resource resource = Mockito.mock(Resource.class);
        Mockito.when(resource.getInputStream()).thenReturn(is);

        when(primaryServiceMock.changelogDML()).thenReturn(resource);
        mockMvc.perform(get("/primary/changelog/dml")).andReturn();
        verify(primaryServiceMock, times(1)).changelogDML();
    }

    @Test
    public void changelogDDL() throws Exception {
        String mockFile = "test";
        InputStream is = new ByteArrayInputStream(mockFile.getBytes());
        Resource resource = Mockito.mock(Resource.class);
        Mockito.when(resource.getInputStream()).thenReturn(is);

        when(primaryServiceMock.changelogDDL()).thenReturn(resource);
        mockMvc.perform(get("/primary/changelog/ddl")).andReturn();
        verify(primaryServiceMock, times(1)).changelogDDL();
    }

}
