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
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrTestConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventadiaria.dto.PtrVentaDiariaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventadiaria.dto.PtrVentaDiariaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventamensual.dto.PtrVentaMensualRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventamensual.dto.PtrVentaMensualResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventapresupuestadamensual.dto.PtrVentaPresupuestadaMensualRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventapresupuestadamensual.dto.PtrVentaPresupuestadaMensualResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizadobymcc.dto.PtrVentaTotalizadoByMccRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizadobymcc.dto.PtrVentaTotalizadoByMccResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizadoxml.dto.PtrVentaTotalizadoXmlRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizadoxml.dto.PtrVentaTotalizadoXmlResponseDto;

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
    
    @Test
    public void getVentaTotalizado() {
        PtrVentaTotalizadoRequestDto request = new PtrVentaTotalizadoRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setPais(PtrTestConstants.PAIS);
        request.setCadena(PtrTestConstants.CADENA);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
        ResponseEntity<PtrVentaTotalizadoResponseDto> response = ptrVentaClient
                .postForEntity(ventaGeneralProperties.get(PtrConstants.VENTA_TOTALIZADO).getEndpoint(), request, PtrVentaTotalizadoResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
   
    @Test
    public void getVentaDiaria() {
        PtrVentaDiariaRequestDto request = new PtrVentaDiariaRequestDto(); 
        request.setFechaFin(PtrTestConstants.FECHA_HASTA);
        request.setFechaInicio(PtrTestConstants.FECHA_DESDE);
        request.setIdTienda(PtrTestConstants.ID_TIENDA);
        request.setIdTipoSeccion(PtrTestConstants.ID_TIPO_SECCION);
        
        ResponseEntity<PtrVentaDiariaResponseDto> response = ptrVentaClient.postForEntity(
                ventaGeneralProperties.get(PtrConstants.VENTA_DIARIA).getEndpoint(), request, PtrVentaDiariaResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Test
    public void getVentaMensual() {
        PtrVentaMensualRequestDto request = new PtrVentaMensualRequestDto(); 
        request.setIdTienda(PtrTestConstants.ID_TIENDA);
        request.setIdTipoSeccion(PtrTestConstants.ID_TIPO_SECCION);
        request.setIdEjercicio(PtrTestConstants.ID_EJERCICIO);
        
        ResponseEntity<PtrVentaMensualResponseDto> response = ptrVentaClient.postForEntity(
                ventaGeneralProperties.get(PtrConstants.VENTA_MENSUAL).getEndpoint(), request, PtrVentaMensualResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }

    @Ignore
    @Test
    public void getVentaPresupuestadaMensual(){
        //TODO: Revisar
        /*
         * 
         *  {
                "clase": "com.inditex.ofda.appwsdacumuladoventaimporte.service.VentaGeneralService",
                "metodo": "getVentaPresupuestadaMensual",
                "codigoError": 0,
                "descripcionError": "Error interno del servicio. Avise al administrador del mismo",
                "mediaType": "application/json"
         *  }   
         * 
         * 
         * */
        PtrVentaPresupuestadaMensualRequestDto request = new PtrVentaPresupuestadaMensualRequestDto(); 
        request.setIdTienda(PtrTestConstants.ID_TIENDA);
        request.setIdTipoSeccion(PtrTestConstants.ID_TIPO_SECCION);
        request.setIdEjercicio(PtrTestConstants.ID_EJERCICIO);
        ResponseEntity<PtrVentaPresupuestadaMensualResponseDto> response = ptrVentaClient.postForEntity(
                ventaGeneralProperties.get(PtrConstants.VENTA_PRESUPUESTADA_MENSUAL).getEndpoint(), request, PtrVentaPresupuestadaMensualResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Test
    public void getVentaTotalizadoByMcc(){
        PtrVentaTotalizadoByMccRequestDto request = new PtrVentaTotalizadoByMccRequestDto(); 
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setPais(PtrTestConstants.PAIS);
        request.setCadena(PtrTestConstants.CADENA);
        ResponseEntity<PtrVentaTotalizadoByMccResponseDto> response = ptrVentaClient.postForEntity(
                ventaGeneralProperties.get(PtrConstants.VENTA_TOTALIZADO_BY_MCC).getEndpoint(), request, PtrVentaTotalizadoByMccResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Ignore
    @Test
    public void getVentaTotalizadoXML(){
        //TODO: Revisar
        PtrVentaTotalizadoXmlRequestDto request = new PtrVentaTotalizadoXmlRequestDto(); 
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setPais(PtrTestConstants.PAIS);
        request.setCadena(PtrTestConstants.CADENA);
        ResponseEntity<PtrVentaTotalizadoXmlResponseDto> response = ptrVentaClient.postForEntity(
                ventaGeneralProperties.get(PtrConstants.VENTA_TOTALIZADO_XML).getEndpoint(), request, PtrVentaTotalizadoXmlResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Test
    public void test() {
        ResponseEntity<Boolean> response = ptrVentaClient.getForEntity(
                ventaGeneralProperties.get(PtrConstants.VENTA_GENERAL_TEST).getEndpoint(), Boolean.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
        assertEquals(Boolean.TRUE, response.getBody());
    }
    
    @Test
    public void getVersion() {
        ResponseEntity<String> response = ptrVentaClient.getForEntity(
                ventaGeneralProperties.get(PtrConstants.VENTA_GENERAL_VERSION).getEndpoint(), String.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
        assertEquals(version, response.getBody());
        
    }
    
}
