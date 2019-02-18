package com.inditex.rrhh.icmclcwb.config.app.tarea;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.inditex.rrhh.icmclcwb.model.app.tarea.AlgoritmoFactory;

@Configuration
public class AlgoritmoFactoryConfig {

    @Bean
    public ServiceLocatorFactoryBean serviceLocatorFactoryBean() {
        ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
        factoryBean.setServiceLocatorInterface(AlgoritmoFactory.class);
        return factoryBean;
    }

}
