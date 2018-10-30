package com.inditex.rrhh.icmclcwb;


import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpStatus;
import org.assertj.core.api.StringAssert;
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

import com.esotericsoftware.minlog.Log;
import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.Application;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasDetalleComisionableRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasDetalleRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasTotalTiendaRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasTotalTiendaSeccionRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.TiendaSeccionDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.TiposHorasRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.*;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.list.PresenciasDetalleResponseListDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.list.PresenciasTotalTiendaResponseListDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.list.PresenciasTotalTiendaSeccionResponseListDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.list.TiposHorasResponseListDTO;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = {Application.class})
@ActiveProfiles({"standalone","test"})
@EnableAutoConfiguration
//@Ignore
public class MockPresenciasServiceTest {
	
	//Ciente ptr
	@Autowired
	@Qualifier("ptrClientPresenciaMock")
    private RestClient restClient;

    @Test
    @Ignore
    public void presenciasDetalle() {
    	Calendar cal = Calendar.getInstance();
    	cal.set(Calendar.YEAR, 1800);
    	cal.set(Calendar.MONTH, Calendar.AUGUST);
    	cal.set(Calendar.DAY_OF_MONTH, 1);
    	Date fechaDesde = cal.getTime();
    	
    	cal.set(Calendar.YEAR, 2018);
    	cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
    	cal.set(Calendar.DAY_OF_MONTH, 1);
    	Date fechaHasta = cal.getTime();
    
        PresenciasDetalleRequestDTO req = new PresenciasDetalleRequestDTO();
        List<Integer> list = new ArrayList<Integer>();
        list.add(160351);
        list.add(162891);
        req.setCadena(1);
        req.setTipo(1);
        req.setSeccion(1);
        req.setTienda(160);
        req.setFechaDesde(fechaDesde);
        req.setFechaHasta(fechaHasta);
        req.setOrigen(11);
        req.setPersonas(list);
        ResponseEntity<PresenciasDetalleResponseListDTO> ret = this.restClient.postForEntity("/presenciasServiceMock/presenciasDetalle/", req, PresenciasDetalleResponseListDTO.class);
        assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
        assertEquals(2007,ret.getBody().getList().size());
        assertEquals(480,ret.getBody().getList().get(0).getMinutos().intValue());

    }
    
    @Test
    @Ignore
    public void presenciasDetalleComisionable(){
    	PresenciasDetalleComisionableRequestDTO req = new PresenciasDetalleComisionableRequestDTO();
        req.setCadena(185); 
        ResponseEntity<PresenciasDetalleComisionableResponseDTO> ret = this.restClient.postForEntity("/presenciasServiceMock/presenciasDetalleComisionable/", req, PresenciasDetalleComisionableResponseDTO.class);
        assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
        assertEquals(ret.getBody().getCadena().intValue(), 185);   
    }

    @Test
    @Ignore
    public void presenciasTotalTienda(){
    	PresenciasTotalTiendaRequestDTO req = new PresenciasTotalTiendaRequestDTO();
    	
    	Calendar cal = Calendar.getInstance();
    	cal.set(Calendar.YEAR, 2016);
    	cal.set(Calendar.MONTH, Calendar.JANUARY);
    	cal.set(Calendar.DAY_OF_MONTH, 1);
    	Date fechaDesde = cal.getTime();
    	
    	cal.set(Calendar.YEAR, 2016);
    	cal.set(Calendar.MONTH, Calendar.MARCH);
    	cal.set(Calendar.DAY_OF_MONTH, 1);
    	Date fechaHasta = cal.getTime();
    	
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(150);
    	list.add(160);
    	req.setTiendas(list);
    	req.setOrigen(11);
    	req.setFechaDesde(fechaDesde);
    	req.setFechaHasta(fechaHasta);
    	req.setTipo(1);
    	req.setCadena(1);
        ResponseEntity<PresenciasTotalTiendaResponseListDTO> ret = this.restClient.postForEntity("/presenciasServiceMock/presenciasTotalTienda/", req, PresenciasTotalTiendaResponseListDTO.class);
        assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
        assertEquals(10620,ret.getBody().getList().get(0).getMinutos().intValue());
        assertEquals(31,ret.getBody().getList().size());
    }

    @Test
    @Ignore
    public void presenciasTotalTiendaSeccion(){
    	PresenciasTotalTiendaSeccionRequestDTO req = new PresenciasTotalTiendaSeccionRequestDTO();
    	//Declaro atributos para el campo TiendaSecciones
    	List<TiendaSeccionDTO> tiendasecciones = new ArrayList<TiendaSeccionDTO>();
    	TiendaSeccionDTO ts1= new TiendaSeccionDTO();
    	ts1.setSeccion(1);
    	ts1.setTienda(18);	
    	tiendasecciones.add(ts1);
    	TiendaSeccionDTO ts2= new TiendaSeccionDTO();
    	ts2.setSeccion(2);
    	ts2.setTienda(52);
    	tiendasecciones.add(ts2);
    	TiendaSeccionDTO ts3= new TiendaSeccionDTO();
    	ts3.setTienda(150);
    	tiendasecciones.add(ts3);
    	Calendar cal = Calendar.getInstance();
    	cal.set(Calendar.YEAR, 2016);
    	cal.set(Calendar.MONTH, Calendar.JANUARY);
    	cal.set(Calendar.DAY_OF_MONTH, 1);
    	Date fechaDesde = cal.getTime();
    	
    	cal.set(Calendar.YEAR, 2016);
    	cal.set(Calendar.MONTH, Calendar.MARCH);
    	cal.set(Calendar.DAY_OF_MONTH, 1);
    	Date fechaHasta = cal.getTime();
    	
    	req.setTiendaSeccion(tiendasecciones);
    	req.setOrigen(11);
    	req.setFechaDesde(fechaDesde);
    	req.setFechaHasta(fechaHasta);
    	req.setTipo(1);
    	req.setCadena(1);
        ResponseEntity<PresenciasTotalTiendaSeccionResponseListDTO> ret = this.restClient.postForEntity("/presenciasServiceMock/presenciasTotalTiendaSeccion/", req, PresenciasTotalTiendaSeccionResponseListDTO.class);
        assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
        assertEquals(44,ret.getBody().getList().size());
        assertEquals(5580,ret.getBody().getList().get(0).getMinutos().intValue());
    }

    @Test
    //@Ignore
    public void tiposHoras(){
    	//Sin parametros
    	TiposHorasRequestDTO req = new TiposHorasRequestDTO();
        ResponseEntity<TiposHorasResponseListDTO> ret = this.restClient.postForEntity("/presenciasServiceMock/tiposHoras/", req,TiposHorasResponseListDTO.class);
        assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
        assertEquals(ret.getBody().getLista().size(),10);
        assertEquals(ret.getBody().getLista().get(0).getTipoHora().intValue(),1);
        assertEquals(ret.getBody().getLista().get(0).getExcluidoCalculo(),Boolean.FALSE);
        
        
        //Especificando origen
        TiposHorasRequestDTO req2 = new TiposHorasRequestDTO();
        req2.setOrigen(11);
        ResponseEntity<TiposHorasResponseListDTO> ret2 = this.restClient.postForEntity("/presenciasServiceMock/tiposHoras/", req,TiposHorasResponseListDTO.class);
        assertEquals(HttpStatus.SC_OK, ret2.getStatusCodeValue());
        assertEquals(ret2.getBody().getLista().size(),10);
        assertEquals(ret2.getBody().getLista().get(0).getTipoHora().intValue(),1);
        assertEquals(ret2.getBody().getLista().get(0).getExcluidoCalculo(),Boolean.FALSE);
     }
    
}
