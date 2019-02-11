package com.inditex.rrhh.icmclcwb.config.app.trabajo;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.AlgoritmoFactory;

@Configuration
public class AlgoritmoFactoryConfig {

    @Bean
    public FactoryBean<?> serviceLocatorFactoryBean() {
        ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
        factoryBean.setServiceLocatorInterface(AlgoritmoFactory.class);
        return factoryBean;
    }

//    @Bean(name = "globalTiendaAlgoritmo")
//    public GlobalTiendaAlgoritmo globalTiendaAlgoritmo() {
//        return new GlobalTiendaAlgoritmo();
//    }

}
