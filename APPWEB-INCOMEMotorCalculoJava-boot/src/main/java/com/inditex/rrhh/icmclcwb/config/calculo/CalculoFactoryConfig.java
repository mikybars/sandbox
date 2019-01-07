package com.inditex.rrhh.icmclcwb.config.calculo;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.inditex.rrhh.icmclcwb.model.app.calculo.CalculoAlgoritmoFactory;
import com.inditex.rrhh.icmclcwb.model.app.calculo.GTAlgoritmo;

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

	@Bean(name = "gTAlgoritmo")
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public GTAlgoritmo gTAlgoritmo() {
		return new GTAlgoritmo();
	}

}
