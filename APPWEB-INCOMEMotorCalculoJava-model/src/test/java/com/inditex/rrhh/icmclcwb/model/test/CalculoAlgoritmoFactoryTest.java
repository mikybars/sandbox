package com.inditex.rrhh.icmclcwb.model.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.model.app.calculo.CalculoAlgoritmoFactory;
import com.inditex.rrhh.icmclcwb.model.app.calculo.TipoCalculoEnum;

@RunWith(SpringRunner.class)
public class CalculoAlgoritmoFactoryTest {

	@TestConfiguration
	static class CalculoAlgoritmoFactoryTestContextConfiguration {

		@Bean
		public CalculoAlgoritmoFactory calculoAlgoritmoFactory() {
			return new CalculoAlgoritmoFactory();
		}
	}

	@Autowired
	private CalculoAlgoritmoFactory calculoAlgoritmoFactory;
		
	@Test	
	@Ignore
	public void factoryTest() {				
		TrabajoDto trabajo = new TrabajoDto();		
		trabajo.setId(100L);								
		Assert.assertNotNull(calculoAlgoritmoFactory.crearAlgoritmo(TipoCalculoEnum.GLOBAL_TIENDA));		
	}

}
