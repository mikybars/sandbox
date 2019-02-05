package com.inditex.rrhh.icmclcwb.config.app.trabajo;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.CalculoAlgoritmoFactory;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.GTAlgoritmo;

@Configuration
public class CalculoFactoryConfig {

    @Bean
    public FactoryBean<?> serviceLocatorFactoryBean() {
        ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
        factoryBean.setServiceLocatorInterface(CalculoAlgoritmoFactory.class);
        return factoryBean;
    }

    @Bean(name = "gTAlgoritmo")
    public GTAlgoritmo gTAlgoritmo() {
        return new GTAlgoritmo();
    }

}
