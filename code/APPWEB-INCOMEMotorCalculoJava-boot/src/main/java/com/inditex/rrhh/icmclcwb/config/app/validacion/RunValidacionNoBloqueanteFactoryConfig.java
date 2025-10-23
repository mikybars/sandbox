package com.inditex.rrhh.icmclcwb.config.app.validacion;

import com.inditex.rrhh.icmclcwb.model.app.calcular.RunValidacionNoBloqueanteFactory;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RunValidacionNoBloqueanteFactoryConfig {

  @Bean
  public ServiceLocatorFactoryBean runValidacionNoBloqueanteFactory() {
    final ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
    factoryBean.setServiceLocatorInterface(RunValidacionNoBloqueanteFactory.class);
    return factoryBean;
  }

}
