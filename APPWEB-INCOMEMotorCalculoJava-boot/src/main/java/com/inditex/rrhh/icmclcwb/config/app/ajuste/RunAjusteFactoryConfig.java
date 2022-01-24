package com.inditex.rrhh.icmclcwb.config.app.ajuste;

import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAjusteFactory;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RunAjusteFactoryConfig {

  @Bean(name = "ajusteServiceLocatorFactoryBean")
  public ServiceLocatorFactoryBean serviceLocatorFactoryBean() {
    ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
    factoryBean.setServiceLocatorInterface(RunAjusteFactory.class);
    return factoryBean;
  }

}
