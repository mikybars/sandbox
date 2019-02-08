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
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventadiaria.dto.PtrVentaDiariaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventadiaria.dto.PtrVentaDiariaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.PtrVentaIndividualDetalleResponseDto;
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

//@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Application.class })
@ActiveProfiles({ "standalone", "test" })
@EnableAutoConfiguration
public class PtrVentaServiceTest  {

    @Autowired
    @Qualifier("ptrVentaClient")
    private RestClient ptrVentaClient;

    @Autowired
    @Qualifier("ptrProps")
    protected Map<String, PtrPropertiesDto> ptrProps;
    
    @Test
    public void getVentaTotalizado() {
        PtrVentaTotalizadoRequestDto request = new PtrVentaTotalizadoRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setPais(PtrTestConstants.PAIS);
        request.setCadena(PtrTestConstants.CADENA);
        ResponseEntity<PtrVentaTotalizadoResponseDto> response = ptrVentaClient
                .postForEntity(ptrProps.get(PtrConstants.VENTA_TOTALIZADO).getEndpoint(), request, PtrVentaTotalizadoResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }

    @Test
    public void getVentaIndividualDetalle() {
        PtrVentaIndividualDetalleRequestDto request = new PtrVentaIndividualDetalleRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setPais(PtrTestConstants.PAIS);
        request.setCadena(PtrTestConstants.CADENA);
        ResponseEntity<PtrVentaIndividualDetalleResponseDto> response = ptrVentaClient.postForEntity(
                ptrProps.get(PtrConstants.VENTA_INDIVIDUAL_DETALLE).getEndpoint(), request, PtrVentaIndividualDetalleResponseDto.class);
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
                ptrProps.get(PtrConstants.VENTA_DIARIA).getEndpoint(), request, PtrVentaDiariaResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Test
    public void getVentaMensual() {
        PtrVentaMensualRequestDto request = new PtrVentaMensualRequestDto(); 
        request.setIdTienda(PtrTestConstants.ID_TIENDA);
        request.setIdTipoSeccion(PtrTestConstants.ID_TIPO_SECCION);
        request.setIdEjercicio(PtrTestConstants.ID_EJERCICIO);
        
        ResponseEntity<PtrVentaMensualResponseDto> response = ptrVentaClient.postForEntity(
                ptrProps.get(PtrConstants.VENTA_MENSUAL).getEndpoint(), request, PtrVentaMensualResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }

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
                ptrProps.get(PtrConstants.VENTA_PRESUPUESTADA_MENSUAL).getEndpoint(), request, PtrVentaPresupuestadaMensualResponseDto.class);
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
                ptrProps.get(PtrConstants.VENTA_TOTALIZADO_BY_MCC).getEndpoint(), request, PtrVentaTotalizadoByMccResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Test
    public void getVentaTotalizadoXML(){
        PtrVentaTotalizadoXmlRequestDto request = new PtrVentaTotalizadoXmlRequestDto(); 
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setPais(PtrTestConstants.PAIS);
        request.setCadena(PtrTestConstants.CADENA);
        ResponseEntity<PtrVentaTotalizadoXmlResponseDto> response = ptrVentaClient.postForEntity(
                ptrProps.get(PtrConstants.VENTA_TOTALIZADO_XML).getEndpoint(), request, PtrVentaTotalizadoXmlResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
}
