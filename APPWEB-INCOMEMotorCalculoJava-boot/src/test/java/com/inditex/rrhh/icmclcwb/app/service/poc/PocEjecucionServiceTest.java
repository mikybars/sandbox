package com.inditex.rrhh.icmclcwb.app.service.poc;

import org.slf4j.Logger;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.http.HttpStatus;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import com.inditex.rrhh.icmclcwb.api.app.dto.poc.PocEjecucionDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Application.class })
@ActiveProfiles({ "standalone", "test" })
@EnableAutoConfiguration
@Ignore
public class PocEjecucionServiceTest {

	@Autowired
	private Logger LOG;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void findAll() {
		LOG.info("Inicio :: PocEjecucionServiceTest.findAll()");
		ResponseEntity<List<PocEjecucionDto>> responseEntity = testRestTemplate
				.withBasicAuth("username300", "username300p").exchange("/poc/ejecucion", HttpMethod.GET, HttpEntity.EMPTY,
						new ParameterizedTypeReference<List<PocEjecucionDto>>() {
						});
		LOG.info("PocEjecucionServiceTest.findAll() :: responseEntity :: {}", responseEntity);
		assertEquals(HttpStatus.SC_OK, responseEntity.getStatusCodeValue());
		LOG.info("Fin :: PocEjecucionServiceTest.findAll()");
	}

}