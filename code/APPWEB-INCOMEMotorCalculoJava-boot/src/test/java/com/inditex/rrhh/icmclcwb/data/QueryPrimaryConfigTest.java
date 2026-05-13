package com.inditex.rrhh.icmclcwb.data;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import com.inditex.rrhh.icmclcwb.config.app.data.query.QueryPrimaryConfig;
import com.inditex.rrhh.icmclcwb.config.app.data.query.QueryPrimaryEnvars;
import com.inditex.rrhh.icmclcwb.config.app.data.query.QueryPrimaryEnvars.CalculoEnvars;
import com.inditex.rrhh.icmclcwb.config.app.data.query.QueryPrimaryEnvars.ProcesoEnvars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class QueryPrimaryConfigTest {

  @Mock
  private ResourceLoader resourceLoader;

  private QueryPrimaryConfig queryPrimaryConfig;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    final QueryPrimaryEnvars envars = new QueryPrimaryEnvars(
        new CalculoEnvars(false, false, "", ""),
        new ProcesoEnvars(false, false, "", ""));
    queryPrimaryConfig = new QueryPrimaryConfig(envars);
  }

  @Test
  void testPrimaryQuery() throws IOException {
    final PropertiesFactoryBean bean = this.queryPrimaryConfig.primaryQuery(this.resourceLoader);
    assertNotNull(bean);
  }

  @Test
  void testCalculoPrimaryQuery() throws IOException {
    final PropertiesFactoryBean bean = this.queryPrimaryConfig.calculoPrimaryQuery(this.resourceLoader);
    assertNotNull(bean);
  }

  @Test
  void testLimpiezaPrimaryQuery() throws IOException {
    final PropertiesFactoryBean bean = this.queryPrimaryConfig.limpiezaPrimaryQuery(this.resourceLoader);
    assertNotNull(bean);
  }

  @Test
  void testComisPrimaryQuery() throws IOException {
    final PropertiesFactoryBean bean = this.queryPrimaryConfig.comisPrimaryQuery(this.resourceLoader);
    assertNotNull(bean);
  }

  @Test
  void testPipePrimaryQuery() throws IOException {
    final PropertiesFactoryBean bean = this.queryPrimaryConfig.pipePrimaryQuery(this.resourceLoader);
    assertNotNull(bean);
  }

  @Test
  void testPtrPrimaryQuery() throws IOException {
    final PropertiesFactoryBean bean = this.queryPrimaryConfig.ptrPrimaryQuery(this.resourceLoader);
    assertNotNull(bean);
  }

  @Test
  void testMeta4PrimaryQuery() throws IOException {
    final PropertiesFactoryBean bean = this.queryPrimaryConfig.meta4PrimaryQuery(this.resourceLoader);
    assertNotNull(bean);
  }

}
