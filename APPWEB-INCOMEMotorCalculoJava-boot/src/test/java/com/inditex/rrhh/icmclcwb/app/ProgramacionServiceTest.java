package com.inditex.rrhh.icmclcwb.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalTime;
import java.util.List;

import org.apache.http.HttpStatus;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.inditex.rrhh.icmclcwb.Application;
import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionTrabajoDto;
import com.inditex.rrhh.icmclcwb.ws.controller.app.ProgramacionController.Clock;

@Ignore("Hay que implementar el mock jms para Bamboo")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Application.class })
@ActiveProfiles({ "standalone", "test" })
@EnableAutoConfiguration
public class ProgramacionServiceTest {

	@Autowired
	private Logger LOG;

	@Autowired
	private TestRestTemplate testRestTemplate;

	//@Test
	public void clock() {
		ResponseEntity<Clock> ret = testRestTemplate.withBasicAuth("username300", "username300p")
				.getForEntity("/programacion/clock/", Clock.class);
		LOG.info("Clock: {}", ret.getBody());
		assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
	}
	
	@Test
	public void insert() {
		ProgramacionDto programacion = new ProgramacionDto();
		programacion.setActiva(Boolean.TRUE);
		//programacion.setFechaCreacion(LocalDateTime.now());
		//programacion.setFechaSiguienteEjecucion(LocalDateTime.of(LocalDate.now(), LocalTime.of(12, 15)));
		programacion.setHora(LocalTime.of(11, 15));
		programacion.setIdPais("11");
		programacion.setIdCadena("1");
		programacion.setIdTienda("160");
		programacion.setIdUsuario("JUNIT");
		programacion.setPeriodo(0L);

		ResponseEntity<ProgramacionDto> ret = testRestTemplate.withBasicAuth("username300", "username300p")
						.postForEntity("/programacion/", programacion, ProgramacionDto.class);
		assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
		assertNotNull(ret.getBody());
		assertNotNull(ret.getBody().getId());
	}

	@Test
	public void run() {
		ResponseEntity<List<ProgramacionTrabajoDto>> ret = testRestTemplate.withBasicAuth("username300", "username300p")
						.exchange("/programacion/run/", HttpMethod.GET, HttpEntity.EMPTY,
										new ParameterizedTypeReference<List<ProgramacionTrabajoDto>>() {
										});
		LOG.info("ret: {}", ret);
		assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
	}

}