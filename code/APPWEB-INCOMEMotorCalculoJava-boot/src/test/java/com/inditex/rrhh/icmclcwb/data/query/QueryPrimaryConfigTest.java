package com.inditex.rrhh.icmclcwb.data.query;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.config.app.data.query.QueryPrimaryConfig;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
public class QueryPrimaryConfigTest {
  @InjectMocks
  private QueryPrimaryConfig queryPrimaryConfig;

  @Mock
  private ResourceLoader resourceLoader;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void primaryQueryShouldLoadProperties() throws Exception {
    final PropertiesFactoryBean propertiesFactoryBean = this.queryPrimaryConfig.primaryQuery(this.resourceLoader);
    verify(this.resourceLoader, times(1)).getClassLoader();
  }

  @Test
  public void calculoPrimaryQueryShouldLoadProperties() throws Exception {
    final PropertiesFactoryBean propertiesFactoryBean = this.queryPrimaryConfig.calculoPrimaryQuery(this.resourceLoader);
    verify(this.resourceLoader, times(1)).getClassLoader();
  }

  @Test
  public void limpiezaPrimaryQueryShouldLoadProperties() throws Exception {
    final PropertiesFactoryBean propertiesFactoryBean = this.queryPrimaryConfig.limpiezaPrimaryQuery(this.resourceLoader);
    verify(this.resourceLoader, times(1)).getClassLoader();
  }

  @Test
  public void comisPrimaryQueryShouldLoadProperties() throws Exception {
    final PropertiesFactoryBean propertiesFactoryBean = this.queryPrimaryConfig.comisPrimaryQuery(this.resourceLoader);
    verify(this.resourceLoader, times(1)).getClassLoader();
  }

  @Test
  public void ptrPrimaryQueryShouldLoadProperties() throws Exception {
    final PropertiesFactoryBean propertiesFactoryBean = this.queryPrimaryConfig.ptrPrimaryQuery(this.resourceLoader);
    verify(this.resourceLoader, times(1)).getClassLoader();
  }

  @Test
  public void meta4PrimaryQueryShouldLoadProperties() throws Exception {
    final PropertiesFactoryBean propertiesFactoryBean = this.queryPrimaryConfig.meta4PrimaryQuery(this.resourceLoader);
    verify(this.resourceLoader, times(1)).getClassLoader();
  }

  @Test
  public void simulacionPrimaryQueryShouldLoadProperties() throws Exception {
    final PropertiesFactoryBean propertiesFactoryBean = this.queryPrimaryConfig.simulacionPrimaryQuery(this.resourceLoader);
    verify(this.resourceLoader, times(1)).getClassLoader();
  }
}
