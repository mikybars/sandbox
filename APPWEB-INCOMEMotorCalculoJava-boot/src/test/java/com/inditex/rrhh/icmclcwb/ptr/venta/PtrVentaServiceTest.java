package com.inditex.rrhh.icmclcwb.ptr.venta;

import static org.junit.Assert.assertEquals;

import org.apache.http.HttpStatus;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.Application;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.PtrVentaTotalizadoResponseDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Application.class })
@ActiveProfiles({ "standalone", "test" })
@EnableAutoConfiguration
@Ignore
public class PtrVentaServiceTest {

	@Autowired
	@Qualifier("ptrVentaClient")
	private RestClient ptrVentaClient;

	@Test
	public void getVentaTotalizado() {
		PtrVentaTotalizadoRequestDto venta = new PtrVentaTotalizadoRequestDto();

		venta.setFechaDesde("2017-12-13");
		venta.setFechaHasta( "2017-12-13");
		venta.setPais(11);
		venta.setCadena(11);
		

		ResponseEntity<PtrVentaTotalizadoResponseDto> ret = this.ptrVentaClient
				.postForEntity("/ventaGeneral/getVentaTotalizado", venta, PtrVentaTotalizadoResponseDto.class);
		assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());

	}

	@Test
	public void getVentaIndividualDetalle() {
		PtrVentaIndividualDetalleRequestDto venta = new PtrVentaIndividualDetalleRequestDto();

		venta.setFechaDesde("2016-11-25");
		venta.setFechaHasta("2016-11-25");
		venta.setPais(1);
		venta.setCadena(1);

		ResponseEntity<PtrVentaIndividualDetalleResponseDto> ret = this.ptrVentaClient.postForEntity(
				"/ventaEmpleado/getVentaIndividualDetalle", venta, PtrVentaIndividualDetalleResponseDto.class);
		assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
	}

}
