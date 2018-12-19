package com.inditex.rrhh.icmclcwb.app.service.calculo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.inditex.rrhh.icmclcwb.Application;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunCalcularService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles({ "standalone", "test" })
public class CalcularServicesTest {

	@Autowired
	private TrabajoRunCalcularService trabajoRunCalcularService;
	
  

	public static final Long GLOBAL_TIENDA = new Long(1L);

	private TrabajoRunDto trabajoRunDto;

	private List<Integer> empleados;

	@Before
	public void setUp() {

		for (int i = 1001; i < 1201; i++)
			empleados.add(i);
		for (int i = 2001; i < 2201; i++)
			empleados.add(i);
		for (int i = 3001; i < 3201; i++)
			empleados.add(i);
		for (int i = 4001; i < 4201; i++)
			empleados.add(i);

		TrabajoDto trabajoDto = new TrabajoDto();
		trabajoDto.setId(100L);
		trabajoRunDto.setTrabajoDto(trabajoDto);
		List<Long> tiposCalculo = new ArrayList<>(); 
		tiposCalculo.add(GLOBAL_TIENDA);
		trabajoRunDto.getTrabajoRunCalcular().setTiposCalculo(tiposCalculo);

	}

	@Test	
	public void factoryTest() throws Exception {
		trabajoRunCalcularService.run(trabajoRunDto);
	}
		
}
