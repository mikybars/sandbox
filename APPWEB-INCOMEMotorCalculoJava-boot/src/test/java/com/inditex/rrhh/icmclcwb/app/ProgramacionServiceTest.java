package com.inditex.rrhh.icmclcwb.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalTime;
import java.util.ArrayList;
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
import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
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

	// @Test
	public void clock() {
		ResponseEntity<Clock> ret = testRestTemplate.withBasicAuth("username300", "username300p")
				.getForEntity("/programacion/clock/", Clock.class);
		LOG.info("Clock: {}", ret.getBody());
		assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
	}

	@Test
	public void insert() {
		ProgramacionDto programacion = new ProgramacionDto();
		String idPais = "11";
		String idCadena = "1";
		programacion.setActiva(Boolean.TRUE);
		programacion.setHora(LocalTime.of(7, 11));
		programacion.setIdPais(idPais);
		programacion.setIdCadena(idCadena);
		List<ProgramacionTiendaDto> tiendas = new ArrayList<>();
		ProgramacionTiendaDto tienda57 = new ProgramacionTiendaDto();
		tienda57.setIdTienda("57");
		tiendas.add(tienda57);
		ProgramacionTiendaDto tienda6479 = new ProgramacionTiendaDto();
		tienda6479.setIdTienda("6479");
		tiendas.add(tienda6479);
		ProgramacionTiendaDto tienda64 = new ProgramacionTiendaDto();
		tienda64.setIdTienda("64");
		tiendas.add(tienda64);
		ProgramacionTiendaDto tienda11931 = new ProgramacionTiendaDto();
		tienda11931.setIdTienda("11931");
		tiendas.add(tienda11931);
		ProgramacionTiendaDto tienda11836 = new ProgramacionTiendaDto();
		tienda11836.setIdTienda("11836");
		tiendas.add(tienda11836);
		ProgramacionTiendaDto tienda691 = new ProgramacionTiendaDto();
		tienda691.setIdTienda("691");
		tiendas.add(tienda691);
		ProgramacionTiendaDto tienda6659 = new ProgramacionTiendaDto();
		tienda6659.setIdTienda("6659");
		tiendas.add(tienda6659);
		programacion.setTiendas(tiendas);
		programacion.setIdUsuario("JUNIT");

		ResponseEntity<ProgramacionDto> ret = testRestTemplate.withBasicAuth("username300", "username300p")
				.postForEntity("/programacion/", programacion, ProgramacionDto.class);
		assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
		assertNotNull(ret.getBody());
		assertNotNull(ret.getBody().getId());
	}

	@Test
	public void run() {
		ResponseEntity<List<TrabajoDto>> ret = testRestTemplate.withBasicAuth("username300", "username300p").exchange(
				"/programacion/run/", HttpMethod.GET, HttpEntity.EMPTY,
				new ParameterizedTypeReference<List<TrabajoDto>>() {
				});
		LOG.info("ret: {}", ret);
		assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
	}

}