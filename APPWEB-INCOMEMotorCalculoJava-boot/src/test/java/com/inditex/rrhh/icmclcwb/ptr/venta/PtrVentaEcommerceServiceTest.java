package com.inditex.rrhh.icmclcwb.ptr.venta;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpStatus;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.xml.sax.SAXException;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.Application;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrTestConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupSellerTypeEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountryhour.dto.PtrVentaOrdersByCountryHourRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountryhour.dto.PtrVentaOrdersByCountryHourResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountryminute.dto.PtrVentaOrdersByCountryMinuteRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountryminute.dto.PtrVentaOrdersByCountryMinuteResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountrysectionproducthour.dto.PtrVentaOrdersByCountrySectionProductHourRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountrysectionproducthour.dto.PtrVentaOrdersByCountrySectionProductHourResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountrysectionproductminute.dto.PtrVentaOrdersByCountrySectionProductMinuteRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountrysectionproductminute.dto.PtrVentaOrdersByCountrySectionProductMinuteResponseDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Application.class })
@ActiveProfiles({ "standalone", "test" })
@EnableAutoConfiguration
public class PtrVentaEcommerceServiceTest {

    @Autowired
    @Qualifier("ptrVentaClient")
    private RestClient ptrVentaClient;

    @Autowired
    @Qualifier("ventaEcommerceProperties")
    protected Map<String, PtrPropertiesDto> ventaEcommerceProperties;
       
    @Autowired
    @Qualifier("ventaVersion")
    private String version;
    
    @Ignore
    @Test
    public void ventaOnlineIpod() {
        PtrVentaOnlineIpodRequestDto request = new PtrVentaOnlineIpodRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setTiendaOnline(PtrTestConstants.ID_TIENDA_LIST);
        request.setEmpresa(PtrTestConstants.ID_EMPRESA);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA);
        request.setAgruparSeccion(PtrTestConstants.AGRUPAR_SECCION_TRUE);
        ResponseEntity<PtrVentaOnlineIpodResponseDto> response = ptrVentaClient
                .postForEntity(ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_IPOD).getEndpoint(), request, PtrVentaOnlineIpodResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Ignore
    @Test
    public void ventaOnlineIpodTiendaSec() {
        PtrVentaOnlineIpodRequestDto request = new PtrVentaOnlineIpodRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setTiendaOnline(PtrTestConstants.ID_TIENDA_LIST);
        request.setEmpresa(PtrTestConstants.ID_EMPRESA);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
        request.setAgruparSeccion(PtrTestConstants.AGRUPAR_SECCION_TRUE);
        ResponseEntity<PtrVentaOnlineIpodResponseDto> response = ptrVentaClient
                .postForEntity(ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_IPOD).getEndpoint(), request, PtrVentaOnlineIpodResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Ignore
    @Test
    public void ventaOnlineIpodTempProd() {
        PtrVentaOnlineIpodRequestDto request = new PtrVentaOnlineIpodRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setTiendaOnline(PtrTestConstants.ID_TIENDA_LIST);
        request.setEmpresa(PtrTestConstants.ID_EMPRESA);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION_TEMPORADA_PRODUCTO);
        request.setAgruparSeccion(PtrTestConstants.AGRUPAR_SECCION_TRUE);
        ResponseEntity<PtrVentaOnlineIpodResponseDto> response = ptrVentaClient
                .postForEntity(ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_IPOD).getEndpoint(), request, PtrVentaOnlineIpodResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Test
    @Ignore("Devuelve un 500")
    public void ventaOnlineIpodIndividualDetalle() {
        PtrVentaOnlineIpodIndividualDetalleRequestDto request = new PtrVentaOnlineIpodIndividualDetalleRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setTiendaOnline(PtrTestConstants.ID_TIENDA_LIST);
        request.setAgrupacion(PtrGroupSellerTypeEnum.OPERACION_FECHA_VENDEDOR_TIENDA);
        ResponseEntity<PtrVentaOnlineIpodIndividualDetalleResponseDto> response = ptrVentaClient
                .postForEntity(ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_IPOD_INDIVIDUAL_DETALLE).getEndpoint(), request, PtrVentaOnlineIpodIndividualDetalleResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Ignore
    @Test
    public void ventaOnlineEntregaDomicilio() {
        PtrVentaOnlineEntregaDomicilioRequestDto request = new PtrVentaOnlineEntregaDomicilioRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA); 
        request.setTiendaOnline(PtrTestConstants.ID_TIENDA_ONLINE_LIST2);
        request.setEmpresa(PtrTestConstants.ID_EMPRESA_VENTA_ECOMMERCE);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA);
        ResponseEntity<PtrVentaOnlineEntregaDomicilioResponseDto> response = ptrVentaClient
                .postForEntity(ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_DOMICILIO).getEndpoint(), request, PtrVentaOnlineEntregaDomicilioResponseDto.class);

        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Ignore
    @Test
    public void ventaOnlineEntregaDomicilioFTS() {
        PtrVentaOnlineEntregaDomicilioRequestDto request = new PtrVentaOnlineEntregaDomicilioRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA); 
        request.setTiendaOnline(PtrTestConstants.ID_TIENDA_ONLINE_LIST2);
        request.setEmpresa(PtrTestConstants.ID_EMPRESA_VENTA_ECOMMERCE);
        request.setAgruparSeccion(PtrTestConstants.AGRUPAR_SECCION_TRUE);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
        ResponseEntity<PtrVentaOnlineEntregaDomicilioResponseDto> response = ptrVentaClient
                .postForEntity(ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_DOMICILIO).getEndpoint(), request, PtrVentaOnlineEntregaDomicilioResponseDto.class);

        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Ignore
    @Test
    public void ventaOnlineEntregaDomicilioFTSTP() {
        PtrVentaOnlineEntregaDomicilioRequestDto request = new PtrVentaOnlineEntregaDomicilioRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA); 
        request.setTiendaOnline(PtrTestConstants.ID_TIENDA_ONLINE_LIST2);
        request.setEmpresa(PtrTestConstants.ID_EMPRESA_VENTA_ECOMMERCE);
        request.setAgruparSeccion(PtrTestConstants.AGRUPAR_SECCION_TRUE);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION_TEMPORADA_PRODUCTO);
        
        ResponseEntity<PtrVentaOnlineEntregaDomicilioResponseDto> response = ptrVentaClient
                .postForEntity(ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_DOMICILIO).getEndpoint(), request, PtrVentaOnlineEntregaDomicilioResponseDto.class);

        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Ignore
    @Test
    public void ventaOnlineEntregaTiendaFTSTP() { 
        PtrVentaOnlineEntregaTiendaRequestDto request = new PtrVentaOnlineEntregaTiendaRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA); 
        request.setEmpresa(PtrTestConstants.ID_EMPRESA_VENTA_ECOMMERCE);
        request.setTiendaOnline(PtrTestConstants.ID_TIENDA_ONLINE_LIST2);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION_TEMPORADA_PRODUCTO);
        request.setAgruparSeccion(PtrTestConstants.AGRUPAR_SECCION_TRUE);
        ResponseEntity<PtrVentaOnlineEntregaTiendaResponseDto> response = ptrVentaClient
                .postForEntity(ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_TIENDA).getEndpoint(), request, PtrVentaOnlineEntregaTiendaResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Ignore("Se ignora por que tarda demasiado")
    @Test
    public void ventaOnlineEntregaTienda() { 
        PtrVentaOnlineEntregaTiendaRequestDto request = new PtrVentaOnlineEntregaTiendaRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA); 
        request.setEmpresa(PtrTestConstants.ID_EMPRESA_VENTA_ECOMMERCE);
        request.setTiendaOnline(PtrTestConstants.ID_TIENDA_ONLINE_LIST2);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA);
        request.setAgruparSeccion(0);
        ResponseEntity<PtrVentaOnlineEntregaTiendaResponseDto> response = ptrVentaClient
                .postForEntity(ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_TIENDA).getEndpoint(), request, PtrVentaOnlineEntregaTiendaResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Ignore
    @Test
    public void ventaOnlineEntregaTiendaFTS() { 
        PtrVentaOnlineEntregaTiendaRequestDto request = new PtrVentaOnlineEntregaTiendaRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA); 
        request.setEmpresa(PtrTestConstants.ID_EMPRESA_VENTA_ECOMMERCE);
        request.setTiendaOnline(PtrTestConstants.ID_TIENDA_ONLINE_LIST2);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
        request.setAgruparSeccion(PtrTestConstants.AGRUPAR_SECCION_TRUE);
        ResponseEntity<PtrVentaOnlineEntregaTiendaResponseDto> response = ptrVentaClient
                .postForEntity(ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_TIENDA).getEndpoint(), request, PtrVentaOnlineEntregaTiendaResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Ignore("Se ignora por que tarda demasiado")
    @Test
    public void ventaOnlinePicking() {
        PtrVentaOnlinePickingRequestDto request = new PtrVentaOnlinePickingRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setEmpresa(PtrTestConstants.ID_EMPRESA);
        request.setTiendaOnline(PtrTestConstants.ID_TIENDA_ONLINE_LIST);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA);

        ResponseEntity<PtrVentaOnlinePickingResponseDto> response = ptrVentaClient
                .postForEntity(ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_PICKING).getEndpoint(), request, PtrVentaOnlinePickingResponseDto.class);
        
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Ignore
    @Test
    public void ventaOnlinePickingTS() {
        PtrVentaOnlinePickingRequestDto request = new PtrVentaOnlinePickingRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setEmpresa(PtrTestConstants.ID_EMPRESA);
        request.setTiendaOnline(PtrTestConstants.ID_TIENDA_ONLINE_LIST);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);

        ResponseEntity<PtrVentaOnlinePickingResponseDto> response = ptrVentaClient
                .postForEntity(ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_PICKING).getEndpoint(), request, PtrVentaOnlinePickingResponseDto.class);
        
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Ignore
    @Test
    public void ventaOnlinePickingTSTP() {
        PtrVentaOnlinePickingRequestDto request = new PtrVentaOnlinePickingRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setEmpresa(PtrTestConstants.ID_EMPRESA);
        request.setTiendaOnline(PtrTestConstants.ID_TIENDA_ONLINE_LIST);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION_TEMPORADA_PRODUCTO);

        ResponseEntity<PtrVentaOnlinePickingResponseDto> response = ptrVentaClient
                .postForEntity(ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_PICKING).getEndpoint(), request, PtrVentaOnlinePickingResponseDto.class);
        
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Ignore
    @Test
    public void ventaOnlinePickingXml() throws SAXException, IOException, ParserConfigurationException {
        PtrVentaOnlinePickingRequestDto request = new PtrVentaOnlinePickingRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setTiendaOnline(PtrTestConstants.ID_TIENDA_ONLINE_LIST);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));

        HttpEntity<PtrVentaOnlinePickingRequestDto> request2 = new HttpEntity<PtrVentaOnlinePickingRequestDto>(request, headers);

        ResponseEntity<PtrVentaOnlinePickingResponseDto> response = ptrVentaClient
                .postForEntity(ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_PICKING).getEndpoint(), request2, PtrVentaOnlinePickingResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Ignore("Devuelve un 500")
    @Test
    public void ordersByCountrySectionProductHour() {
        PtrVentaOrdersByCountrySectionProductHourRequestDto request = new PtrVentaOrdersByCountrySectionProductHourRequestDto();
        request.setFechaHoraLocalDesde(PtrTestConstants.FECHA_HORA_DESDE);
        request.setFechaHoraLocalHasta(PtrTestConstants.FECHA_HORA_HASTA);
        request.setCadena(PtrTestConstants.CADENA_LIST);
        request.setPais(PtrTestConstants.PAIS_LIST);
        ResponseEntity<PtrVentaOrdersByCountrySectionProductHourResponseDto> response = ptrVentaClient
                .postForEntity(ventaEcommerceProperties.get(PtrPropertiesConstants.ORDERS_BY_COUNTRY_SECTION_PRODUCT_HOUR).getEndpoint(), request, PtrVentaOrdersByCountrySectionProductHourResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Ignore
    @Test
    public void ordersByCountrySectionProductMinute() {
        PtrVentaOrdersByCountrySectionProductMinuteRequestDto request = new PtrVentaOrdersByCountrySectionProductMinuteRequestDto();
        request.setFechaHoraMinutoLocalDesde(PtrTestConstants.FECHA_HORA_DESDE);
        request.setFechaHoraMinutoLocalHasta(PtrTestConstants.FECHA_HORA_HASTA);
        request.setCadena(PtrTestConstants.CADENA_LIST);
        request.setPais(PtrTestConstants.PAIS_LIST);
        ResponseEntity<PtrVentaOrdersByCountrySectionProductMinuteResponseDto> response = ptrVentaClient
                .postForEntity(ventaEcommerceProperties.get(PtrPropertiesConstants.ORDERS_BY_COUNTRY_SECTION_PRODUCT_MINUTE).getEndpoint(), request, PtrVentaOrdersByCountrySectionProductMinuteResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Ignore("Devuelve un 500")
    @Test
    public void ordersByCountryHour() {
        PtrVentaOrdersByCountryHourRequestDto request = new PtrVentaOrdersByCountryHourRequestDto();
        request.setFechaHoraLocalDesde(PtrTestConstants.FECHA_HORA_DESDE);
        request.setFechaHoraLocalHasta(PtrTestConstants.FECHA_HORA_HASTA);
        request.setCadena(PtrTestConstants.CADENA_LIST);
        request.setPais(PtrTestConstants.PAIS_LIST);
        ResponseEntity<PtrVentaOrdersByCountryHourResponseDto> response = ptrVentaClient
                .postForEntity(ventaEcommerceProperties.get(PtrPropertiesConstants.ORDERS_BY_COUNTRY_HOUR).getEndpoint(), request, PtrVentaOrdersByCountryHourResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Ignore
    @Test
    public void ordersByCountryMinute() {
        PtrVentaOrdersByCountryMinuteRequestDto request = new PtrVentaOrdersByCountryMinuteRequestDto();
        request.setFechaHoraMinutoLocalDesde(PtrTestConstants.FECHA_HORA_DESDE);
        request.setFechaHoraMinutoLocalHasta(PtrTestConstants.FECHA_HORA_HASTA);
        request.setCadena(PtrTestConstants.CADENA_LIST);
        request.setPais(PtrTestConstants.PAIS_LIST);
        ResponseEntity<PtrVentaOrdersByCountryMinuteResponseDto> response = ptrVentaClient
                .postForEntity(ventaEcommerceProperties.get(PtrPropertiesConstants.ORDERS_BY_COUNTRY_MINUTE).getEndpoint(), request, PtrVentaOrdersByCountryMinuteResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Ignore("No existe en los servicios publicados en Openshift, está pendiente que miren si los agregan")
    @Test
    public void test() { 
        ResponseEntity<Boolean> response = ptrVentaClient.getForEntity(
                ventaEcommerceProperties.get(PtrPropertiesConstants.TEST).getEndpoint(), Boolean.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
        assertEquals(Boolean.TRUE, response.getBody());
    }
    
    @Ignore("No existe en los servicios publicados en Openshift, está pendiente que miren si los agregan")
    @Test
    public void version() {
        ResponseEntity<String> response = ptrVentaClient.getForEntity(
                ventaEcommerceProperties.get(PtrPropertiesConstants.VERSION).getEndpoint(), String.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
        assertEquals(version, response.getBody());
        
    }
    
}
