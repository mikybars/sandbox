package com.inditex.rrhh.icmclcwb.ptr.presenciasmock;

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
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.TiendaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.TiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.PresenciasDetalleComisionableResponseListDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.PresenciasDetalleResponseListDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.PresenciasTotalTiendaResponseListDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.PresenciasTotalTiendaSeccionResponseListDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.TiposHorasResponseListDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = { Application.class })
@ActiveProfiles({ "standalone", "test" })
@EnableAutoConfiguration


public class PtrPresenciasMockServiceTest {
	@Autowired
	@Qualifier("ptrClientPresenciaMock")
	private RestClient restClient;

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

		PresenciasDetalleRequestDto req = new PresenciasDetalleRequestDto();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1645);
		req.setCadena(1);
		req.setTipo(1);
		req.setSeccion(1);
		req.setTienda(160);
		req.setFechaDesde(fechaDesde);
		req.setFechaHasta(fechaHasta);
		req.setOrigen(11);
		req.setPersonas(list);
		ResponseEntity<PresenciasDetalleResponseListDto> ret = this.restClient.postForEntity(
				"/presenciasServiceMock/presenciasDetalle/", req, PresenciasDetalleResponseListDto.class);
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

		PresenciasDetalleComisionableRequestDto req = new PresenciasDetalleComisionableRequestDto();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1645);
		req.setCadena(1);
		req.setTipo(1);
		req.setSeccion(1);
		req.setTienda(160);
		req.setFechaDesde(fechaDesde);
		req.setFechaHasta(fechaHasta);
		req.setOrigen(11);
		req.setPersonas(list);
		ResponseEntity<PresenciasDetalleComisionableResponseListDto> ret = this.restClient.postForEntity(
				"/presenciasServiceMock/presenciasDetalleComisionable/", req,
				PresenciasDetalleComisionableResponseListDto.class);
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
		PresenciasTotalTiendaRequestDto req = new PresenciasTotalTiendaRequestDto();

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
		req.setCadena(4);
		ResponseEntity<PresenciasTotalTiendaResponseListDto> ret = this.restClient.postForEntity(
				"/presenciasServiceMock/presenciasTotalTienda/", req, PresenciasTotalTiendaResponseListDto.class);
		assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
		assertEquals(720, ret.getBody().getList().get(0).getMinutos().intValue());
		assertEquals(3, ret.getBody().getList().size());
		assertEquals("Sat Jun 30 00:00:00 UTC 2018", ret.getBody().getList().get(0).getFecha().toString());
		assertEquals(8102, ret.getBody().getList().get(0).getTienda().intValue());
	}

	@Test
	public void presenciasTotalTiendaSeccion() {
		PresenciasTotalTiendaSeccionRequestDto req = new PresenciasTotalTiendaSeccionRequestDto();
		// Declaro atributos para el campo TiendaSecciones
		List<TiendaSeccionDto> tiendasecciones = new ArrayList<TiendaSeccionDto>();
		TiendaSeccionDto ts2 = new TiendaSeccionDto();
		ts2.setSeccion(2);
		ts2.setTienda(52);
		tiendasecciones.add(ts2);
		TiendaSeccionDto ts3 = new TiendaSeccionDto();
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
		req.setCadena(1);
		ResponseEntity<PresenciasTotalTiendaSeccionResponseListDto> ret = this.restClient.postForEntity(
				"/presenciasServiceMock/presenciasTotalTiendaSeccion/", req,
				PresenciasTotalTiendaSeccionResponseListDto.class);
		assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
		assertEquals(30, ret.getBody().getList().size());
		assertEquals(3270, ret.getBody().getList().get(0).getMinutos().intValue());
		assertEquals(52, ret.getBody().getList().get(0).getTienda().intValue());
		assertEquals(2, ret.getBody().getList().get(0).getSeccion().intValue());
		assertEquals("Sat Jan 02 00:00:00 UTC 2016", ret.getBody().getList().get(0).getFecha().toString());

	}

	@Test
	public void tiposHoras() {
		// Especificando origen
		TiposHorasRequestDto req2 = new TiposHorasRequestDto();
		req2.setOrigen(11);
		ResponseEntity<TiposHorasResponseListDto> ret2 = this.restClient
				.postForEntity("/presenciasServiceMock/tiposHoras/", req2, TiposHorasResponseListDto.class);
		assertEquals(HttpStatus.SC_OK, ret2.getStatusCodeValue());
		assertEquals(74, ret2.getBody().getList().size());
		assertEquals(925, ret2.getBody().getList().get(0).getTipoHora().intValue());
		assertEquals(Boolean.FALSE, ret2.getBody().getList().get(0).getExcluidoCalculo());
		assertEquals(Boolean.TRUE, ret2.getBody().getList().get(0).getExcluidoDenom());
	}

}