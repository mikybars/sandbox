package com.inditex.rrhh.icmclcwb.config.app.prevalidar;

import com.inditex.rrhh.icmclcwb.model.app.calcular.RunPrevalidarFactory;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RunPrevalidarFactoryConfig {

  @Bean(name = "prevalidarServiceLocatorFactoryBean")
  public ServiceLocatorFactoryBean serviceLocatorFactoryBean() {
    final ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
    factoryBean.setServiceLocatorInterface(RunPrevalidarFactory.class);
    return factoryBean;
  }

}
