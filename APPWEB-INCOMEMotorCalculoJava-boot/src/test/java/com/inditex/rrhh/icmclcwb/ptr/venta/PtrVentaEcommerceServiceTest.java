package com.inditex.rrhh.icmclcwb.ptr.venta;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Map;

import org.apache.http.HttpStatus;
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
    public void ventaOnlineIpodTiendaSeccion() {
        PtrVentaOnlineIpodRequestDto request = new PtrVentaOnlineIpodRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setTiendaOnline(PtrTestConstants.ID_TIENDA_LIST);
        request.setPais(PtrTestConstants.PAIS);
        request.setEmpresa(PtrTestConstants.ID_EMPRESA);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
        request.setAgruparSeccion(PtrTestConstants.AGRUPAR_SECCION_TRUE);
        ResponseEntity<PtrVentaOnlineIpodResponseDto> response = ptrVentaClient
            .postForEntity(ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_IPOD).getEndpoint(),
                    request, PtrVentaOnlineIpodResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }

    @Test
    public void ventaOnlineIpodIndividualDetalle() {
        PtrVentaOnlineIpodIndividualDetalleRequestDto request = new PtrVentaOnlineIpodIndividualDetalleRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setTiendaOnline(PtrTestConstants.ID_TIENDA_LIST);
        request.setEmpresa(PtrTestConstants.ID_EMPRESA);
        request.setPais(PtrTestConstants.PAIS);
        request.setAgrupacion(PtrGroupSellerTypeEnum.OPERACION_FECHA_VENDEDOR_TIENDA);
        request.setAgruparSeccion(PtrTestConstants.AGRUPAR_SECCION_FALSE);
        ResponseEntity<PtrVentaOnlineIpodIndividualDetalleResponseDto> response = ptrVentaClient
            .postForEntity(ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_IPOD_INDIVIDUAL_DETALLE)
                .getEndpoint(), request, PtrVentaOnlineIpodIndividualDetalleResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }


    @Test
    public void ventaOnlineEntregaDomicilio() {
        PtrVentaOnlineEntregaDomicilioRequestDto request = new PtrVentaOnlineEntregaDomicilioRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setTiendaOnline(PtrTestConstants.ID_TIENDA_ONLINE_LIST2);
        request.setPais(PtrTestConstants.PAIS);
        request.setEmpresa(PtrTestConstants.ID_EMPRESA_VENTA_ECOMMERCE);
        request.setCadena(PtrTestConstants.CADENA_LIST);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_CADENA);
        request.setPais(PtrTestConstants.PAIS);
        ResponseEntity<PtrVentaOnlineEntregaDomicilioResponseDto> response = ptrVentaClient
            .postForEntity(
                    ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_DOMICILIO).getEndpoint(),
                    request, PtrVentaOnlineEntregaDomicilioResponseDto.class);

        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }


    @Test
    public void ventaOnlineEntregaDomicilioFTS() {
        PtrVentaOnlineEntregaDomicilioRequestDto request = new PtrVentaOnlineEntregaDomicilioRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setTiendaOnline(PtrTestConstants.ID_TIENDA_ONLINE_LIST2);
        request.setPais(PtrTestConstants.PAIS);
        request.setEmpresa(PtrTestConstants.ID_EMPRESA_VENTA_ECOMMERCE);
        request.setAgruparSeccion(PtrTestConstants.AGRUPAR_SECCION_TRUE);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
        ResponseEntity<PtrVentaOnlineEntregaDomicilioResponseDto> response = ptrVentaClient
            .postForEntity(
                    ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_DOMICILIO).getEndpoint(),
                    request, PtrVentaOnlineEntregaDomicilioResponseDto.class);

        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }

    @Test
    public void ventaOnlineEntregaTienda() {
        PtrVentaOnlineEntregaTiendaRequestDto request = new PtrVentaOnlineEntregaTiendaRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setEmpresa(PtrTestConstants.ID_EMPRESA_VENTA_ECOMMERCE);
        request.setPais(PtrTestConstants.PAIS);
        request.setTiendaOnline(PtrTestConstants.ID_TIENDA_ONLINE_LIST2);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA);
        request.setAgruparSeccion(0);
        ResponseEntity<PtrVentaOnlineEntregaTiendaResponseDto> response = ptrVentaClient
            .postForEntity(
                    ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_TIENDA).getEndpoint(),
                    request, PtrVentaOnlineEntregaTiendaResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }


    @Test
    public void ventaOnlineEntregaTiendaFTS() {
        PtrVentaOnlineEntregaTiendaRequestDto request = new PtrVentaOnlineEntregaTiendaRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setEmpresa(PtrTestConstants.ID_EMPRESA_VENTA_ECOMMERCE);
        request.setPais(PtrTestConstants.PAIS);
        request.setTiendaOnline(PtrTestConstants.ID_TIENDA_ONLINE_LIST2);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
        request.setAgruparSeccion(PtrTestConstants.AGRUPAR_SECCION_TRUE);
        ResponseEntity<PtrVentaOnlineEntregaTiendaResponseDto> response = ptrVentaClient
            .postForEntity(
                    ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_TIENDA).getEndpoint(),
                    request, PtrVentaOnlineEntregaTiendaResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }

    @Test
    public void ventaOnlinePicking() {
        PtrVentaOnlinePickingRequestDto request = new PtrVentaOnlinePickingRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setEmpresa(PtrTestConstants.ID_EMPRESA);
        request.setPais(PtrTestConstants.PAIS);
        request.setTiendaOnline(PtrTestConstants.ID_TIENDA_ONLINE_LIST);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA);

        ResponseEntity<PtrVentaOnlinePickingResponseDto> response = ptrVentaClient
            .postForEntity(ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_PICKING).getEndpoint(),
                    request, PtrVentaOnlinePickingResponseDto.class);

        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }


    @Test
    public void ventaOnlinePickingTS() {
        PtrVentaOnlinePickingRequestDto request = new PtrVentaOnlinePickingRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setPais(PtrTestConstants.PAIS);
        request.setEmpresa(PtrTestConstants.ID_EMPRESA);
        request.setTiendaOnline(PtrTestConstants.ID_TIENDA_ONLINE_LIST);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);

        ResponseEntity<PtrVentaOnlinePickingResponseDto> response = ptrVentaClient
            .postForEntity(ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_PICKING).getEndpoint(),
                    request, PtrVentaOnlinePickingResponseDto.class);

        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }


    @Test
    public void ventaOnlinePickingXml() {
        PtrVentaOnlinePickingRequestDto request = new PtrVentaOnlinePickingRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setPais(PtrTestConstants.PAIS);
        request.setEmpresa(PtrTestConstants.ID_EMPRESA);
        request.setTiendaOnline(PtrTestConstants.ID_TIENDA_ONLINE_LIST);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));

        HttpEntity<PtrVentaOnlinePickingRequestDto> request2 = new HttpEntity<PtrVentaOnlinePickingRequestDto>(request,
                headers);

        ResponseEntity<PtrVentaOnlinePickingResponseDto> response = ptrVentaClient
            .postForEntity(ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_PICKING).getEndpoint(),
                    request2, PtrVentaOnlinePickingResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }

}
