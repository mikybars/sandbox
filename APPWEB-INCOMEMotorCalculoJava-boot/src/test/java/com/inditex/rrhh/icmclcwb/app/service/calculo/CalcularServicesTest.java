package com.inditex.rrhh.icmclcwb.app.service.calculo;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.inditex.rrhh.icmclcwb.Application;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunCalcularService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles({ "standalone", "test" })
public class CalcularServicesTest {
	
	
	@Autowired
	private TrabajoRunCalcularService trabajoRunCalcularService;
	
	public static final Integer GLOBAL_TIENDA = new Integer(1);
	
	
	@Test	
	@Ignore
	public void factoryTest() throws Exception {
		TrabajoDto trabajoDto = new TrabajoDto();		
		TrabajoRunDto trabajoRunDto = new TrabajoRunDto();
		
		trabajoDto.setId(100L);
		trabajoRunDto.setTrabajoDto(trabajoDto);
		ArrayList<Integer> tiposCalculo = new ArrayList<Integer>();		
		tiposCalculo.add(GLOBAL_TIENDA);		
		trabajoRunDto.getTrabajoRunDatos().setTiposCalculo(tiposCalculo);
														
		trabajoRunCalcularService.run(trabajoRunDto);
							
		
	}
	

}
