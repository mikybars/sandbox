package com.inditex.rrhh.icmclcwb.ptr.presencia.mock;

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
public class PtrPresenciasMockServiceTest {

	@Autowired
	@Qualifier("ptrPresenciaMockClient")
	private RestClient ptrPresenciaMockClient;

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
		req.setCadena(list2);
		req.setTipo(1);
		req.setSeccion(1);
		req.setTienda(160);
		req.setFechaDesde(fechaDesde);
		req.setFechaHasta(fechaHasta);
		req.setOrigen(11);
		req.setPersonas(list);
		ResponseEntity<PtrPresenciaDetalleResponseDto> ret = this.ptrPresenciaMockClient
				.postForEntity("/presenciasService/presenciasDetalle", req, PtrPresenciaDetalleResponseDto.class);
		assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
		assertEquals(7, ret.getBody().getList().size());
		assertEquals(240, ret.getBody().getList().get(0).getMinutos().intValue());
		assertEquals(1, ret.getBody().getList().get(0).getCadena().intValue());
		assertEquals(160, ret.getBody().getList().get(0).getTienda().intValue());
		assertEquals(1, ret.getBody().getList().get(0).getSeccion().intValue());
		assertEquals(1, ret.getBody().getList().get(0).getTipo().intValue());
		assertEquals(Boolean.FALSE, ret.getBody().getList().get(0).getModificado_income());
		//assertEquals(11,ret.getBody().getList().get(0).getOrigen().intValue());

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
		req.setCadena(list2);
		req.setTipo(1);
		req.setSeccion(1);
		req.setTienda(160);
		req.setFechaDesde(fechaDesde);
		req.setFechaHasta(fechaHasta);
		req.setOrigen(11);
		req.setPersonas(list);
		ResponseEntity<PtrPresenciaDetalleComisionableResponseDto> ret = this.ptrPresenciaMockClient.postForEntity(
				"/presenciasService/presenciasDetalleComisionable/", req, PtrPresenciaDetalleComisionableResponseDto.class);
		assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
		assertEquals(7, ret.getBody().getList().size());
		assertEquals(240, ret.getBody().getList().get(0).getMinutos().intValue());
		assertEquals(1, ret.getBody().getList().get(0).getCadena().intValue());
		assertEquals(160, ret.getBody().getList().get(0).getTienda().intValue());
		assertEquals(1, ret.getBody().getList().get(0).getSeccion().intValue());
		assertEquals(1, ret.getBody().getList().get(0).getTipo().intValue());
		assertEquals(Boolean.FALSE, ret.getBody().getList().get(0).getModificado_income());
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
		req.setTiendas(list);
		req.setOrigen(11);
		req.setFechaDesde(fechaDesde);
		req.setFechaHasta(fechaHasta);
		req.setTipo(1);
		;
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(4);
		list2.add(250);
		req.setCadena(list2);
		ResponseEntity<PtrPresenciaTotalTiendaResponseDto> ret = this.ptrPresenciaMockClient
				.postForEntity("/presenciasService/presenciasTotalTienda", req, PtrPresenciaTotalTiendaResponseDto.class);
		assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
		assertEquals(720, ret.getBody().getList().get(0).getMinutos().intValue());
		assertEquals(3, ret.getBody().getList().size());
		assertEquals("Sat Jun 30 00:00:00 UTC 2018", ret.getBody().getList().get(0).getFecha().toString());
		assertEquals(8102, ret.getBody().getList().get(0).getTienda().intValue());
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
		req.setFechaDesde(fechaDesde);
		req.setFechaHasta(fechaHasta);
		req.setTipo(1);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(1);
		list2.add(2);
		req.setCadena(list2);
		ResponseEntity<PtrPresenciaTotalTiendaSeccionResponseDto> ret = this.ptrPresenciaMockClient.postForEntity(
				"/presenciasService/presenciasTotalTiendaSeccion", req, PtrPresenciaTotalTiendaSeccionResponseDto.class);
		assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
		assertEquals(30, ret.getBody().getList().size());
		assertEquals(3270, ret.getBody().getList().get(0).getMinutos().intValue());
		assertEquals(52, ret.getBody().getList().get(0).getTienda().intValue());
		assertEquals(2, ret.getBody().getList().get(0).getSeccion().intValue());
		assertEquals("Sat Jan 02 00:00:00 UTC 2016", ret.getBody().getList().get(0).getFecha().toString());

	}

	@Test
	public void tiposHoras() {
		PtrPresenciaTiposHorasRequestDto req2 = new PtrPresenciaTiposHorasRequestDto();
		req2.setOrigen(720);
		ResponseEntity<PtrPresenciaTiposHorasResponseDto> ret2 = this.ptrPresenciaMockClient.postForEntity("/presenciasService/tiposHoras",
				req2, PtrPresenciaTiposHorasResponseDto.class);
		assertEquals(HttpStatus.SC_OK, ret2.getStatusCodeValue());
		assertEquals(2, ret2.getBody().getList().size());
		assertEquals(1, ret2.getBody().getList().get(0).getTipoHora().intValue());
		assertEquals(Boolean.FALSE, ret2.getBody().getList().get(0).getExcluidoCalculo());
		assertEquals(Boolean.TRUE, ret2.getBody().getList().get(0).getExcluidoDenom());
	}

}