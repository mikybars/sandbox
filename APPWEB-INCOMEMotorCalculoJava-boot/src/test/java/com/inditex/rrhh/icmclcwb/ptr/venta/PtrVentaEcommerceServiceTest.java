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
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
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
    
    @Test
    public void ventaOnlineIpod() {
        PtrVentaOnlineIpodRequestDto request = new PtrVentaOnlineIpodRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setTiendaOnline(PtrTestConstants.ID_TIENDA_LIST);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
        ResponseEntity<PtrVentaOnlineIpodResponseDto> response = ptrVentaClient
                .postForEntity(ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_IPOD).getEndpoint(), request, PtrVentaOnlineIpodResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Test
    public void ventaOnlineEntregaDomicilio() {
        PtrVentaOnlineEntregaDomicilioRequestDto request = new PtrVentaOnlineEntregaDomicilioRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA); 
        request.setPais(1);
        request.setCadena(2);
        request.setEmpresa(7);
        request.setSeccion(3);
        request.setTiendaOnline(PtrTestConstants.ID_TIENDA_LIST);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
        ResponseEntity<PtrVentaOnlineEntregaDomicilioResponseDto> response = ptrVentaClient
                .postForEntity(ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_ENTREGA_DOMICILIO).getEndpoint(), request, PtrVentaOnlineEntregaDomicilioResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Test
    public void ventaOnlineEntregaTienda() { 
        PtrVentaOnlineEntregaTiendaRequestDto request = new PtrVentaOnlineEntregaTiendaRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setTiendaOnline(PtrTestConstants.ID_TIENDA_LIST);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
        ResponseEntity<PtrVentaOnlineEntregaTiendaResponseDto> response = ptrVentaClient
                .postForEntity(ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_ENTREGA_TIENDA).getEndpoint(), request, PtrVentaOnlineEntregaTiendaResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Test
    public void ventaOnlinePicking() {
        PtrVentaOnlinePickingRequestDto request = new PtrVentaOnlinePickingRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setTiendaOnline(PtrTestConstants.ID_TIENDA_LIST);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);

        ResponseEntity<PtrVentaOnlinePickingResponseDto> response = ptrVentaClient
                .postForEntity(ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_PICKING).getEndpoint(), request, PtrVentaOnlinePickingResponseDto.class);
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
                .postForEntity(ventaEcommerceProperties.get(PtrConstants.ORDERS_BY_COUNTRY_SECTION_PRODUCT_HOUR).getEndpoint(), request, PtrVentaOrdersByCountrySectionProductHourResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Test
    public void ordersByCountrySectionProductMinute() {
        PtrVentaOrdersByCountrySectionProductMinuteRequestDto request = new PtrVentaOrdersByCountrySectionProductMinuteRequestDto();
        request.setFechaHoraMinutoLocalDesde(PtrTestConstants.FECHA_HORA_DESDE);
        request.setFechaHoraMinutoLocalHasta(PtrTestConstants.FECHA_HORA_HASTA);
        request.setCadena(PtrTestConstants.CADENA_LIST);
        request.setPais(PtrTestConstants.PAIS_LIST);
        ResponseEntity<PtrVentaOrdersByCountrySectionProductMinuteResponseDto> response = ptrVentaClient
                .postForEntity(ventaEcommerceProperties.get(PtrConstants.ORDERS_BY_COUNTRY_SECTION_PRODUCT_MINUTE).getEndpoint(), request, PtrVentaOrdersByCountrySectionProductMinuteResponseDto.class);
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
                .postForEntity(ventaEcommerceProperties.get(PtrConstants.ORDERS_BY_COUNTRY_HOUR).getEndpoint(), request, PtrVentaOrdersByCountryHourResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Test
    public void ordersByCountryMinute() {
        PtrVentaOrdersByCountryMinuteRequestDto request = new PtrVentaOrdersByCountryMinuteRequestDto();
        request.setFechaHoraMinutoLocalDesde(PtrTestConstants.FECHA_HORA_DESDE);
        request.setFechaHoraMinutoLocalHasta(PtrTestConstants.FECHA_HORA_HASTA);
        request.setCadena(PtrTestConstants.CADENA_LIST);
        request.setPais(PtrTestConstants.PAIS_LIST);
        ResponseEntity<PtrVentaOrdersByCountryMinuteResponseDto> response = ptrVentaClient
                .postForEntity(ventaEcommerceProperties.get(PtrConstants.ORDERS_BY_COUNTRY_MINUTE).getEndpoint(), request, PtrVentaOrdersByCountryMinuteResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
    @Test
    public void test() { 
        ResponseEntity<Boolean> response = ptrVentaClient.getForEntity(
                ventaEcommerceProperties.get(PtrConstants.VENTA_ECOMMERCE_TEST).getEndpoint(), Boolean.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
        assertEquals(Boolean.TRUE, response.getBody());
    }
    
    @Test
    public void version() {
        ResponseEntity<String> response = ptrVentaClient.getForEntity(
                ventaEcommerceProperties.get(PtrConstants.VENTA_ECOMMERCE_VERSION).getEndpoint(), String.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
        assertEquals(version, response.getBody());
        
    }
    
}
