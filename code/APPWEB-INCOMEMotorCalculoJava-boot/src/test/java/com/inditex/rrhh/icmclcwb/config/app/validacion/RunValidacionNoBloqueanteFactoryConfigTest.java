package com.inditex.rrhh.icmclcwb.config.app.validacion;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunValidacionNoBloqueanteFactoryConfigTest {

  @InjectMocks
  private RunValidacionNoBloqueanteFactoryConfig config;

  @Test
  void runValidacionNoBloqueanteFactoryShouldReturnServiceLocatorFactoryBean() {
    final ServiceLocatorFactoryBean result = this.config.runValidacionNoBloqueanteFactory();

    assertNotNull(result);
  }

  @Test
  void runValidacionNoBloqueanteFactoryShouldReturnNewInstanceEachTime() {
    final ServiceLocatorFactoryBean result1 = this.config.runValidacionNoBloqueanteFactory();
    final ServiceLocatorFactoryBean result2 = this.config.runValidacionNoBloqueanteFactory();

    assertNotNull(result1);
    assertNotNull(result2);
  }
}
