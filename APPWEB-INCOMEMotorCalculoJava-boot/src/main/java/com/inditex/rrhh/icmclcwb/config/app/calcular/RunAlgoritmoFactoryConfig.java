package com.inditex.rrhh.icmclcwb.config.app.calcular;

import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmoFactory;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RunAlgoritmoFactoryConfig {

  @Bean
  public ServiceLocatorFactoryBean serviceLocatorFactoryBean() {
    final ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
    factoryBean.setServiceLocatorInterface(RunAlgoritmoFactory.class);
    return factoryBean;
  }

}
