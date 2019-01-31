package com.inditex.rrhh.icmclcwb.config.app.trabajo;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.inditex.rrhh.icmclcwb.model.app.trabajo.CalculoAlgoritmoFactory;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.GTAlgoritmo;

@Configuration
@ComponentScan(basePackages = { "com.inditex.rrhh.icmclcwb.model.app.calculo.fac" })
public class CalculoFactoryConfig {

	@SuppressWarnings("rawtypes")
	@Bean
	public FactoryBean serviceLocatorFactoryBean() {
		ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
		factoryBean.setServiceLocatorInterface(CalculoAlgoritmoFactory.class);
		return factoryBean;
	}

	//https://www.baeldung.com/spring-bean-scopes
	@Bean(name = "gTAlgoritmo")
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public GTAlgoritmo gTAlgoritmo() {
		return new GTAlgoritmo();
	}

}
