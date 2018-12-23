package com.inditex.rrhh.icmclcwb.ptr.venta;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
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

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date fechaDesde = cal.getTime();
		venta.setFechaDesde(fechaDesde.toString());

		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		Date fechaHasta = cal.getTime();
		venta.setFechaHasta(fechaHasta.toString());

		venta.setPais("123");
		List<String> lista = new ArrayList<String>();
		lista.add("1");
		// venta.setCadena(lista);
		// venta.setAgrupacion("FECHA_TIENDA");

		ResponseEntity<PtrVentaTotalizadoResponseDto> ret = this.ptrVentaClient
				.postForEntity("/ventaGeneral/getVentaTotalizado", venta, PtrVentaTotalizadoResponseDto.class);
		assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());

	}

	@Test
	public void getVentaIndividualDetalle() {
		PtrVentaIndividualDetalleRequestDto venta = new PtrVentaIndividualDetalleRequestDto();

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date fechaDesde = cal.getTime();
		venta.setFechaDesde(fechaDesde.toString());

		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		Date fechaHasta = cal.getTime();
		venta.setFechaHasta(fechaHasta.toString());

		venta.setPais("123");
		List<String> lista = new ArrayList<String>();
		lista.add("1");
		// venta.setCadena(lista);
		// venta.setAgrupacion("FECHA_TIENDA");
		// venta.setTemporada("1");
		List<Integer> lista2 = new ArrayList<Integer>();
		lista2.add(new Integer(1));
		// venta.setVendedores(lista2);

		ResponseEntity<PtrVentaIndividualDetalleResponseDto> ret = this.ptrVentaClient.postForEntity(
				"/ventaEmpleado/getVentaIndividualDetalle", venta, PtrVentaIndividualDetalleResponseDto.class);
		assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
	}

}
