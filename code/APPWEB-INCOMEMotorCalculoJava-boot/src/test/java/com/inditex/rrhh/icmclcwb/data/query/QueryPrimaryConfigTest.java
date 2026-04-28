package com.inditex.rrhh.icmclcwb.data.query;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.config.app.data.query.QueryPrimaryConfig;
import com.inditex.rrhh.icmclcwb.config.app.data.query.QueryPrimaryEnvars;
import com.inditex.rrhh.icmclcwb.config.app.data.query.QueryPrimaryEnvars.CalculoEnvars;
import com.inditex.rrhh.icmclcwb.config.app.data.query.QueryPrimaryEnvars.ProcesoEnvars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class QueryPrimaryConfigTest {

  private QueryPrimaryConfig queryPrimaryConfig;

  @Mock
  private ResourceLoader resourceLoader;

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
    final QueryPrimaryEnvars envars = new QueryPrimaryEnvars(
        new CalculoEnvars(false, false, "", ""),
        new ProcesoEnvars(false, false, "", ""));
    queryPrimaryConfig = new QueryPrimaryConfig(envars);
  }

  @Test
  void primaryQueryShouldLoadProperties() throws Exception {
    this.queryPrimaryConfig.primaryQuery(this.resourceLoader);
    verify(this.resourceLoader, times(1)).getClassLoader();
  }

  @Test
  void calculoPrimaryQueryShouldLoadProperties() throws Exception {
    this.queryPrimaryConfig.calculoPrimaryQuery(this.resourceLoader);
    verify(this.resourceLoader, times(1)).getClassLoader();
  }

  @Test
  void limpiezaPrimaryQueryShouldLoadProperties() throws Exception {
    this.queryPrimaryConfig.limpiezaPrimaryQuery(this.resourceLoader);
    verify(this.resourceLoader, times(1)).getClassLoader();
  }

  @Test
  void comisPrimaryQueryShouldLoadProperties() throws Exception {
    this.queryPrimaryConfig.comisPrimaryQuery(this.resourceLoader);
    verify(this.resourceLoader, times(1)).getClassLoader();
  }

  @Test
  void pipePrimaryQueryShouldLoadProperties() throws Exception {
    this.queryPrimaryConfig.pipePrimaryQuery(this.resourceLoader);
    verify(this.resourceLoader, times(1)).getClassLoader();
  }

  @Test
  void ptrPrimaryQueryShouldLoadProperties() throws Exception {
    this.queryPrimaryConfig.ptrPrimaryQuery(this.resourceLoader);
    verify(this.resourceLoader, times(1)).getClassLoader();
  }

  @Test
  void meta4PrimaryQueryShouldLoadProperties() throws Exception {
    this.queryPrimaryConfig.meta4PrimaryQuery(this.resourceLoader);
    verify(this.resourceLoader, times(1)).getClassLoader();
  }

  @Test
  void simulacionPrimaryQueryShouldLoadProperties() throws Exception {
    this.queryPrimaryConfig.simulacionPrimaryQuery(this.resourceLoader);
    verify(this.resourceLoader, times(1)).getClassLoader();
  }

}
