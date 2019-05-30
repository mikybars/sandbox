package com.inditex.rrhh.icmclcwb.ptr.venta;

import static org.junit.Assert.assertEquals;

import java.util.Map;

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
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrTestConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.diaria.dto.PtrVentaDiariaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.diaria.dto.PtrVentaDiariaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.mensual.dto.PtrVentaMensualRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.mensual.dto.PtrVentaMensualResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.presupuestadamensual.dto.PtrVentaPresupuestadaMensualRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.presupuestadamensual.dto.PtrVentaPresupuestadaMensualResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizadobymcc.dto.PtrVentaTotalizadoByMccRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizadobymcc.dto.PtrVentaTotalizadoByMccResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizadoxml.dto.PtrVentaTotalizadoXmlRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizadoxml.dto.PtrVentaTotalizadoXmlResponseDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Application.class })
@ActiveProfiles({ "standalone", "test" })
@EnableAutoConfiguration
public class PtrVentaGeneralServiceTest  {

    @Autowired
    @Qualifier("ptrVentaClient")
    private RestClient ptrVentaClient;

    @Autowired
    @Qualifier("ventaGeneralProperties")
    protected Map<String, PtrPropertiesDto> ventaGeneralProperties;
       
    @Autowired
    @Qualifier("ventaVersion")
    private String version;
    
    @Ignore
    @Test
    public void ventaTotalizadoFechaTiendaSeccion() {
        PtrVentaTotalizadoRequestDto request = new PtrVentaTotalizadoRequestDto();
//        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
//        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setFechaDesde("2014-01-01");
        request.setFechaHasta("2016-12-31");
        request.setPais(70);
        request.setPais(PtrTestConstants.PAIS);
        request.setCadena(PtrTestConstants.CADENA);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION_TEMPORADA_PRODUCTO);
        ResponseEntity<PtrVentaTotalizadoResponseDto> response = ptrVentaClient
                .postForEntity(ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_TOTALIZADO).getEndpoint(), request, PtrVentaTotalizadoResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Ignore
    @Test
    public void ventaTotalizadoFechaTienda() {
        PtrVentaTotalizadoRequestDto request = new PtrVentaTotalizadoRequestDto();
//        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
//        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
      request.setFechaDesde("2014-01-01");
      request.setFechaHasta("2016-12-31");
      request.setPais(70);
//        request.setPais(PtrTestConstants.PAIS);
        request.setCadena(PtrTestConstants.CADENA);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA);
        ResponseEntity<PtrVentaTotalizadoResponseDto> response = ptrVentaClient
                .postForEntity(ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_TOTALIZADO).getEndpoint(), request, PtrVentaTotalizadoResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
   
    @Ignore
    @Test
    public void ventaDiaria() {
        PtrVentaDiariaRequestDto request = new PtrVentaDiariaRequestDto(); 
        request.setFechaFin(PtrTestConstants.FECHA_HASTA);
        request.setFechaInicio(PtrTestConstants.FECHA_DESDE);
        request.setIdTienda(PtrTestConstants.ID_TIENDA);
        request.setIdTipoSeccion(PtrTestConstants.ID_TIPO_SECCION);

        ResponseEntity<PtrVentaDiariaResponseDto> response = ptrVentaClient.postForEntity(
                ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_DIARIA).getEndpoint(), request, PtrVentaDiariaResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Ignore
    @Test
    public void ventaMensual() {
        PtrVentaMensualRequestDto request = new PtrVentaMensualRequestDto(); 
        request.setIdTienda(PtrTestConstants.ID_TIENDA);
        request.setIdTipoSeccion(PtrTestConstants.ID_TIPO_SECCION);
        request.setIdEjercicio(PtrTestConstants.ID_EJERCICIO);

        ResponseEntity<PtrVentaMensualResponseDto> response = ptrVentaClient.postForEntity(
                ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_MENSUAL).getEndpoint(), request, PtrVentaMensualResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }

    @Ignore("Devuelve un 500")
    @Test
    public void ventaPresupuestadaMensual(){
        PtrVentaPresupuestadaMensualRequestDto request = new PtrVentaPresupuestadaMensualRequestDto(); 
        request.setIdTienda(PtrTestConstants.ID_TIENDA);
        request.setIdTipoSeccion(PtrTestConstants.ID_TIPO_SECCION);
        request.setIdEjercicio(PtrTestConstants.ID_EJERCICIO);
        ResponseEntity<PtrVentaPresupuestadaMensualResponseDto> response = ptrVentaClient.postForEntity(
                ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_PRESUPUESTADA_MENSUAL).getEndpoint(), request, PtrVentaPresupuestadaMensualResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Ignore
    @Test
    public void ventaTotalizadoByMcc(){
        PtrVentaTotalizadoByMccRequestDto request = new PtrVentaTotalizadoByMccRequestDto(); 
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setPais(PtrTestConstants.PAIS);
        request.setCadena(PtrTestConstants.CADENA);
        ResponseEntity<PtrVentaTotalizadoByMccResponseDto> response = ptrVentaClient.postForEntity(
                ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_TOTALIZADO_BY_MCC).getEndpoint(), request, PtrVentaTotalizadoByMccResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Ignore("Ver como se gestiona el xml")
    @Test
    public void ventaTotalizadoXML(){
        PtrVentaTotalizadoXmlRequestDto request = new PtrVentaTotalizadoXmlRequestDto(); 
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setPais(PtrTestConstants.PAIS);
        request.setCadena(PtrTestConstants.CADENA);
        ResponseEntity<PtrVentaTotalizadoXmlResponseDto> response = ptrVentaClient.postForEntity(
                ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_TOTALIZADO_XML).getEndpoint(), request, PtrVentaTotalizadoXmlResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Ignore
    @Test
    public void test() { 
        ResponseEntity<Boolean> response = ptrVentaClient.getForEntity(
                ventaGeneralProperties.get(PtrPropertiesConstants.TEST).getEndpoint(), Boolean.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
        assertEquals(Boolean.TRUE, response.getBody());
    }
    
    @Ignore
    @Test
    public void version() {
        ResponseEntity<String> response = ptrVentaClient.getForEntity(
                ventaGeneralProperties.get(PtrPropertiesConstants.VERSION).getEndpoint(), String.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
        assertEquals(version, response.getBody());
        
    }
    
}
