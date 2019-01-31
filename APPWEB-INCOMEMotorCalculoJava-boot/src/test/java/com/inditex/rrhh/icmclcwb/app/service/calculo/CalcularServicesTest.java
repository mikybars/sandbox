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
import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.service.RunTrabajoCalcularService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants.EstadoTrabajoEnum;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.TipoCalculoEnum;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles({ "standalone", "test" })
public class CalcularServicesTest {

	@Autowired
	private RunTrabajoCalcularService runTrabajoCalcularService;
		
	private RunTrabajoDto trabajoRunDto = new RunTrabajoDto();

	private List<Integer> empleados  = new ArrayList<>();

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
		trabajoDto.setId(700L);
		trabajoRunDto.setTrabajoDto(trabajoDto);
		Set<Long> tiposCalculo = new HashSet<>();  
		tiposCalculo.add(TipoCalculoEnum.GLOBAL_TIENDA.getId());		
		EstadoTrabajoDto  estado = new EstadoTrabajoDto(EstadoTrabajoEnum.PENDIENTE_CALCULO.getId()); 				
		trabajoDto.setEstado(estado);
		
		trabajoRunDto.getRunTrabajoCalcular().setTiposCalculo(tiposCalculo);

	}

	@Test	
	@Ignore
	public void factoryTest() throws Exception {
		runTrabajoCalcularService.run(trabajoRunDto);
	}
		
}
