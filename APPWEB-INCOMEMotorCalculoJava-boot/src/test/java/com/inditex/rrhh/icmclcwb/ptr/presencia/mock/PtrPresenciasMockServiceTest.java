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
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTiendaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.PtrPresenciasMockDetalleComisionableResponseListDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.PtrPresenciasMockDetalleResponseListDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.PtrPresenciasMockTotalTiendaResponseListDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.PtrPresenciasMockTotalTiendaSeccionResponseListDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.PtrPresenciasMockTiposHorasResponseListDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Application.class })
@ActiveProfiles({ "standalone", "test" })
@EnableAutoConfiguration
@Ignore
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

        PtrPresenciasMockDetalleRequestDto req = new PtrPresenciasMockDetalleRequestDto();
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
        ResponseEntity<PtrPresenciasMockDetalleResponseListDto> ret = this.restClient.postForEntity(
                "/presenciasDetalle", req, PtrPresenciasMockDetalleResponseListDto.class);
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

        PtrPresenciasMockDetalleComisionableRequestDto req = new PtrPresenciasMockDetalleComisionableRequestDto();
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
        ResponseEntity<PtrPresenciasMockDetalleComisionableResponseListDto> ret = this.restClient.postForEntity(
                "/presenciasDetalleComisionable/", req,
                PtrPresenciasMockDetalleComisionableResponseListDto.class);
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
        PtrPresenciasMockTotalTiendaRequestDto req = new PtrPresenciasMockTotalTiendaRequestDto();

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
        req.setTipo(1);;
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(4);
        list2.add(250);
        req.setCadena(list2);
        ResponseEntity<PtrPresenciasMockTotalTiendaResponseListDto> ret = this.restClient.postForEntity(
                "/presenciasTotalTienda", req, PtrPresenciasMockTotalTiendaResponseListDto.class);
        assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
        assertEquals(720, ret.getBody().getList().get(0).getMinutos().intValue());
        assertEquals(3, ret.getBody().getList().size());
        assertEquals("Sat Jun 30 00:00:00 UTC 2018", ret.getBody().getList().get(0).getFecha().toString());
        assertEquals(8102, ret.getBody().getList().get(0).getTienda().intValue());
    }

    @Test
    public void presenciasTotalTiendaSeccion() {
        PtrPresenciasMockTotalTiendaSeccionRequestDto req = new PtrPresenciasMockTotalTiendaSeccionRequestDto();
        // Declaro atributos para el campo TiendaSecciones
        List<PtrPresenciasMockTiendaSeccionDto> tiendasecciones = new ArrayList<PtrPresenciasMockTiendaSeccionDto>();
        PtrPresenciasMockTiendaSeccionDto ts2 = new PtrPresenciasMockTiendaSeccionDto();
        ts2.setSeccion(2);
        ts2.setTienda(52);
        tiendasecciones.add(ts2);
        PtrPresenciasMockTiendaSeccionDto ts3 = new PtrPresenciasMockTiendaSeccionDto();
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
        ResponseEntity<PtrPresenciasMockTotalTiendaSeccionResponseListDto> ret = this.restClient.postForEntity(
                "/presenciasTotalTiendaSeccion", req,
                PtrPresenciasMockTotalTiendaSeccionResponseListDto.class);
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
        PtrPresenciasMockTiposHorasRequestDto req2 = new PtrPresenciasMockTiposHorasRequestDto();
        req2.setOrigen(720);
        ResponseEntity<PtrPresenciasMockTiposHorasResponseListDto> ret2 = this.restClient
                .postForEntity("/tiposHoras", req2, PtrPresenciasMockTiposHorasResponseListDto.class);
        assertEquals(HttpStatus.SC_OK, ret2.getStatusCodeValue());
        assertEquals(2, ret2.getBody().getList().size());
        assertEquals(1, ret2.getBody().getList().get(0).getTipoHora().intValue());
        assertEquals(Boolean.FALSE, ret2.getBody().getList().get(0).getExcluidoCalculo());
        assertEquals(Boolean.TRUE, ret2.getBody().getList().get(0).getExcluidoDenom());
    }

}