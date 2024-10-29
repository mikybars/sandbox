package com.inditex.rrhh.icmclcwb.data;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

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
    when(this.resourceLoader.getResource(anyString())).thenReturn(this.resource);
    when(this.resourceLoader.getResource(anyString())).thenReturn(this.resource);
    when(this.resourcePatternResolver.getResources(anyString())).thenReturn(new Resource[]{this.resource});
  }

  @Test
  public void testPrimaryQuery() throws IOException {
    final PropertiesFactoryBean bean = this.queryPrimaryConfig.primaryQuery(this.resourceLoader);
    assertNotNull(bean);
  }

  @Test
  public void testCalculoPrimaryQuery() throws IOException {
    final PropertiesFactoryBean bean = this.queryPrimaryConfig.calculoPrimaryQuery(this.resourceLoader);
    assertNotNull(bean);
  }

  @Test
  public void testLimpiezaPrimaryQuery() throws IOException {
    final PropertiesFactoryBean bean = this.queryPrimaryConfig.limpiezaPrimaryQuery(this.resourceLoader);
    assertNotNull(bean);
  }

  @Test
  public void testComisPrimaryQuery() throws IOException {
    final PropertiesFactoryBean bean = this.queryPrimaryConfig.comisPrimaryQuery(this.resourceLoader);
    assertNotNull(bean);
  }

  @Test
  public void testPipePrimaryQuery() throws IOException {
    final PropertiesFactoryBean bean = this.queryPrimaryConfig.pipePrimaryQuery(this.resourceLoader);
    assertNotNull(bean);
  }

  @Test
  public void testPtrPrimaryQuery() throws IOException {
    final PropertiesFactoryBean bean = this.queryPrimaryConfig.ptrPrimaryQuery(this.resourceLoader);
    assertNotNull(bean);
  }

  @Test
  public void testMeta4PrimaryQuery() throws IOException {
    final PropertiesFactoryBean bean = this.queryPrimaryConfig.meta4PrimaryQuery(this.resourceLoader);
    assertNotNull(bean);
  }

}
