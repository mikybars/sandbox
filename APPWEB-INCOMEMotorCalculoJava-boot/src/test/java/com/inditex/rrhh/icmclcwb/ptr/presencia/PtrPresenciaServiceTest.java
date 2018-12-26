package com.inditex.rrhh.icmclcwb.ptr.presencia;

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
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTiendaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTotalTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResponseDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Application.class })
@ActiveProfiles({ "standalone", "test" })
@EnableAutoConfiguration
public class PtrPresenciaServiceTest {

	@Autowired
	@Qualifier("ptrPresenciaClient")
	private RestClient ptrPresenciaClient;

	@Test
	public void presenciasDetalle() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date fechaDesde = cal.getTime();

		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		Date fechaHasta = cal.getTime();

		PtrPresenciaDetalleRequestDto req = new PtrPresenciaDetalleRequestDto();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1645);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(1);
		list2.add(2);
		req.setCadena(2);
		req.setTipo(1);
		req.setSeccion(1);
		req.setTienda(160);
		req.setFechaDesde("2017-01-01");
		req.setFechaHasta("2017-12-31");
		req.setOrigen(11);
		req.setPersona(list);
		ResponseEntity<PtrPresenciaDetalleResponseDto> ret = this.ptrPresenciaClient
				.postForEntity("/presenciasService/presenciasDetalle", req, PtrPresenciaDetalleResponseDto.class);
		assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
	}

	@Test
	public void presenciasDetalleComisionable() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date fechaDesde = cal.getTime();

		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		Date fechaHasta = cal.getTime();

		PtrPresenciaDetalleComisionableRequestDto req = new PtrPresenciaDetalleComisionableRequestDto();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1645);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(1);
		list2.add(2);
		req.setCadena(2);
		req.setTipo(1);
		req.setSeccion(1);
		req.setTienda(160);
		req.setFechaDesde("2017-01-01");
		req.setFechaHasta("2017-12-31");
		req.setOrigen(11);
		req.setPersona(list);
		ResponseEntity<PtrPresenciaDetalleComisionableResponseDto> ret = this.ptrPresenciaClient.postForEntity(
				"/presenciasService/presenciasDetalleComisionable/", req,
				PtrPresenciaDetalleComisionableResponseDto.class);
		assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
	}

	@Test
	public void presenciasTotalTienda() {
		PtrPresenciaTotalTiendaRequestDto req = new PtrPresenciaTotalTiendaRequestDto();

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2018);
		cal.set(Calendar.MONTH, Calendar.MAY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date fechaDesde = cal.getTime();

		cal.set(Calendar.YEAR, 2018);
		cal.set(Calendar.MONTH, Calendar.OCTOBER);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		Date fechaHasta = cal.getTime();

		List<Integer> list = new ArrayList<Integer>();
		list.add(8102);
		req.setTienda(list);
		req.setOrigen(11);
		req.setFechaDesde("2017-01-01");
		req.setFechaHasta("2017-12-31");
		req.setTipo(1);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(4);
		list2.add(250);
		req.setCadena(2);
		ResponseEntity<PtrPresenciaTotalTiendaResponseDto> ret = this.ptrPresenciaClient.postForEntity(
				"/presenciasService/presenciasTotalTienda", req, PtrPresenciaTotalTiendaResponseDto.class);
		assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
	}

	@Test
	public void presenciasTotalTiendaSeccion() {
		PtrPresenciaTotalTiendaSeccionRequestDto req = new PtrPresenciaTotalTiendaSeccionRequestDto();
		List<PtrPresenciaTiendaSeccionDto> tiendasecciones = new ArrayList<PtrPresenciaTiendaSeccionDto>();
		PtrPresenciaTiendaSeccionDto ts2 = new PtrPresenciaTiendaSeccionDto();
		ts2.setSeccion(2);
		ts2.setTienda(52);
		tiendasecciones.add(ts2);
		PtrPresenciaTiendaSeccionDto ts3 = new PtrPresenciaTiendaSeccionDto();
		ts3.setTienda(150);
		tiendasecciones.add(ts3);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2016);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date fechaDesde = cal.getTime();

		cal.set(Calendar.YEAR, 2016);
		cal.set(Calendar.MONTH, Calendar.FEBRUARY);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		Date fechaHasta = cal.getTime();

		req.setTiendaSeccion(tiendasecciones);
		req.setOrigen(11);
		req.setFechaDesde("2017-01-01");
		req.setFechaHasta("2017-12-31");
		req.setTipo(1);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(1);
		list2.add(2);
		req.setCadena(2);
		ResponseEntity<PtrPresenciaTotalTiendaSeccionResponseDto> ret = this.ptrPresenciaClient.postForEntity(
				"/presenciasService/presenciasTotalTiendaSeccion", req,
				PtrPresenciaTotalTiendaSeccionResponseDto.class);
		assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());

	}

	@Test
	public void tiposHoras() {
		PtrPresenciaTiposHorasRequestDto req2 = new PtrPresenciaTiposHorasRequestDto();
		req2.setOrigen(720);
		ResponseEntity<PtrPresenciaTiposHorasResponseDto> ret2 = this.ptrPresenciaClient
				.postForEntity("/presenciasService/tiposHoras", req2, PtrPresenciaTiposHorasResponseDto.class);
		assertEquals(HttpStatus.SC_OK, ret2.getStatusCodeValue());
	}

}