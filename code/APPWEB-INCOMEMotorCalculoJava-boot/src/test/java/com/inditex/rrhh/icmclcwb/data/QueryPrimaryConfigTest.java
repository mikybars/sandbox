package com.inditex.rrhh.icmclcwb.data;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

import com.inditex.rrhh.icmclcwb.config.app.data.query.QueryPrimaryConfig;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
public class QueryPrimaryConfigTest {

  @Mock
  private ResourceLoader resourceLoader;

  @Mock
  private ResourcePatternResolver resourcePatternResolver;

  @Mock
  private Resource resource;

  @InjectMocks
  private QueryPrimaryConfig queryPrimaryConfig;

  @BeforeEach
  public void setUp() throws IOException {
    MockitoAnnotations.openMocks(this);
    when(resourceLoader.getResource(anyString())).thenReturn(resource);
    when(resourceLoader.getResource(anyString())).thenReturn(resource);
    when(resourcePatternResolver.getResources(anyString())).thenReturn(new Resource[]{resource});
  }

  @Test
  public void testPrimaryQuery() throws IOException {
    PropertiesFactoryBean bean = queryPrimaryConfig.primaryQuery(resourceLoader);
    assertNotNull(bean);
  }

  @Test
  public void testCalculoPrimaryQuery() throws IOException {
    PropertiesFactoryBean bean = queryPrimaryConfig.calculoPrimaryQuery(resourceLoader);
    assertNotNull(bean);
  }

  @Test
  public void testLimpiezaPrimaryQuery() throws IOException {
    PropertiesFactoryBean bean = queryPrimaryConfig.limpiezaPrimaryQuery(resourceLoader);
    assertNotNull(bean);
  }

  @Test
  public void testComisPrimaryQuery() throws IOException {
    PropertiesFactoryBean bean = queryPrimaryConfig.comisPrimaryQuery(resourceLoader);
    assertNotNull(bean);
  }

  @Test
  public void testPipePrimaryQuery() throws IOException {
    PropertiesFactoryBean bean = queryPrimaryConfig.pipePrimaryQuery(resourceLoader);
    assertNotNull(bean);
  }

  @Test
  public void testPtrPrimaryQuery() throws IOException {
    PropertiesFactoryBean bean = queryPrimaryConfig.ptrPrimaryQuery(resourceLoader);
    assertNotNull(bean);
  }

  @Test
  public void testMeta4PrimaryQuery() throws IOException {
    PropertiesFactoryBean bean = queryPrimaryConfig.meta4PrimaryQuery(resourceLoader);
    assertNotNull(bean);
  }

}
