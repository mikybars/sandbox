package com.inditex.rrhh.icmclcwb.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.inditex.rrhh.icmclcwb.Application;
import com.inditex.rrhh.icmclcwb.api.app.dto.ScheduleDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ScheduleJobDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Application.class })
@ActiveProfiles({ "standalone", "test" })
@EnableAutoConfiguration
public class ScheduleServiceTest {

	@Autowired
	private Logger LOG;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Mock
	private ScheduleDto s;

	@InjectMocks
	private ScheduleDto s1;

	@MockBean
	private ScheduleDto s2;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void insert() {
		final String NOMBRE = "Federico";
		ScheduleDto schedule = new ScheduleDto();
		schedule.setName(NOMBRE);
		ResponseEntity<ScheduleDto> ret = testRestTemplate.withBasicAuth("username200", "username200p")
						.postForEntity("/schedule/", schedule, ScheduleDto.class);
		assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
		assertNotNull(ret.getBody());
		assertNotNull(ret.getBody().getId());
		assertEquals(NOMBRE, ret.getBody().getName());
	}

	@Test
	public void run() {
		ResponseEntity<List<ScheduleJobDto>> ret = testRestTemplate.withBasicAuth("username200", "username200p")
						.exchange("/schedule/run/", HttpMethod.GET, HttpEntity.EMPTY,
										new ParameterizedTypeReference<List<ScheduleJobDto>>() {
										});
		LOG.info("ret: " + ret.toString());
		assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
	}

}