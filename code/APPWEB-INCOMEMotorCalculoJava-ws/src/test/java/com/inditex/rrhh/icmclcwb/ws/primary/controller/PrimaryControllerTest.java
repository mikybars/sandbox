package com.inditex.rrhh.icmclcwb.ws.primary.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.inditex.rrhh.icmclcwb.api.primary.service.PrimaryService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
public class PrimaryControllerTest {

  private MockMvc mockMvc;

  @Mock
  private PrimaryService primaryServiceMock;

  @InjectMocks
  private PrimaryController primaryController;

  @BeforeEach
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    this.mockMvc = MockMvcBuilders.standaloneSetup(this.primaryController)
        .build();
  }

  @Test
  public void loadDML() throws Exception {
    when(this.primaryServiceMock.loadDML("1")).thenReturn(Boolean.TRUE);
    this.mockMvc.perform(get("/primary/load/dml/{path}", "1")).andReturn();
    verify(this.primaryServiceMock, times(1)).loadDML(any(String.class));
  }

  @Test
  public void changelogDML() throws Exception {
    final String mockFile = "test";
    final InputStream is = new ByteArrayInputStream(mockFile.getBytes());
    final Resource resource = Mockito.mock(Resource.class);
    Mockito.when(resource.getInputStream()).thenReturn(is);

    when(this.primaryServiceMock.changelogDML()).thenReturn(resource);
    this.mockMvc.perform(get("/primary/changelog/dml")).andReturn();
    verify(this.primaryServiceMock, times(1)).changelogDML();
  }

  @Test
  public void changelogDDL() throws Exception {
    final String mockFile = "test";
    final InputStream is = new ByteArrayInputStream(mockFile.getBytes());
    final Resource resource = Mockito.mock(Resource.class);
    Mockito.when(resource.getInputStream()).thenReturn(is);

    when(this.primaryServiceMock.changelogDDL()).thenReturn(resource);
    this.mockMvc.perform(get("/primary/changelog/ddl")).andReturn();
    verify(this.primaryServiceMock, times(1)).changelogDDL();
  }

}
