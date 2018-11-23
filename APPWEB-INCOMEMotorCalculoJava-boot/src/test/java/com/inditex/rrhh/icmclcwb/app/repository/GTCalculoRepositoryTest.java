package com.inditex.rrhh.icmclcwb.app.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.inditex.rrhh.icmclcwb.Application;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.GTCalculoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoCalculoRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles({ "standalone", "test" })
@Transactional
public class GTCalculoRepositoryTest {
	
	@Autowired
	private GTCalculoRepository gTCalculoRepository;
				
	@Autowired
	private TrabajoCalculoRepository trabajoCalculoRepository;

	@Test
	@Ignore
	public void calculoJdbcUpdateTest() {
						
		TrabajoDto trabajo = new TrabajoDto();		
		trabajo.setId(100L);		
		gTCalculoRepository.calcular(trabajo);							
		assertNotNull(trabajoCalculoRepository.findAllTrabajoCalculadoByIdTrabajo(trabajo.getId()));
		
										
	}
	
	
}
