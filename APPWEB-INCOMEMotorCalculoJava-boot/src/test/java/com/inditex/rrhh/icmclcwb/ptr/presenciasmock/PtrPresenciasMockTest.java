package com.inditex.rrhh.icmclcwb.ptr.presenciasmock;

import static org.junit.Assert.*;
import org.apache.http.HttpStatus;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.esotericsoftware.minlog.Log;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.PresenciasDetalleResponseListDto;


@Ignore 
public class PtrPresenciasMockTest {

	@Autowired
	@Qualifier("ptrClientPresenciaMock")
	private TestRestTemplate testRestTemplate;

	@Test
	public void findAll() {
		ResponseEntity<PresenciasDetalleResponseListDto> responseEntity = testRestTemplate
				.withBasicAuth("username100", "username100p").exchange("/presenciasServiceMock/presenciasDetalle/",
						HttpMethod.POST, org.springframework.http.HttpEntity.EMPTY,
						new ParameterizedTypeReference<PresenciasDetalleResponseListDto>() {
						});
		Log.info("PtrPresenciasMock.findPresenciasDetalle(): :: responseEntity :: {}" + responseEntity.toString());
		assertEquals(HttpStatus.SC_OK, responseEntity.getStatusCodeValue());
		Log.info("Fin");
	}
}
