package com.inditex.rrhh.icmclcwb.ptr.venta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Map;

import com.inditex.amigafwk.common.rest.client.RestClient;
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

import org.apache.hc.core5.http.HttpStatus;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})

@Disabled
public class PtrVentaEcommerceServiceTest {

  @Mock
  private RestClient ptrVentaClient;

  @Mock
  protected Map<String, PtrPropertiesDto> ventaEcommerceProperties;

  @Test
  public void ventaOnlineIpodTiendaSeccion() {
    final PtrVentaOnlineIpodRequestDto request = new PtrVentaOnlineIpodRequestDto();
    request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
    request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
    request.setTiendaOnline(PtrTestConstants.getID_TIENDA_LIST());
    request.setPais(PtrTestConstants.PAIS);
    request.setEmpresa(List.of(PtrTestConstants.ID_EMPRESA));
    request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
    request.setAgruparSeccion(PtrTestConstants.AGRUPAR_SECCION_TRUE);
    // request.setVentaPAT(PtrTestConstants.INCLUIR_VENTA_PAT);
    final ResponseEntity<PtrVentaOnlineIpodResponseDto> response = this.ptrVentaClient
        .postForEntity(this.ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_IPOD).getEndpoint(),
            request, PtrVentaOnlineIpodResponseDto.class);
    assertEquals(HttpStatus.SC_OK, response.getStatusCode().value());
  }

  @Test
  public void ventaOnlineIpodIndividualDetalle() {
    final PtrVentaOnlineIpodIndividualDetalleRequestDto request = new PtrVentaOnlineIpodIndividualDetalleRequestDto();
    request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
    request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
    request.setTiendaOnline(PtrTestConstants.getID_TIENDA_LIST());
    request.setEmpresa(List.of(PtrTestConstants.ID_EMPRESA));
    request.setPais(PtrTestConstants.PAIS);
    request.setAgrupacion(PtrGroupSellerTypeEnum.OPERACION_FECHA_VENDEDOR_TIENDA);
    request.setAgruparSeccion(PtrTestConstants.AGRUPAR_SECCION_FALSE);
    final ResponseEntity<PtrVentaOnlineIpodIndividualDetalleResponseDto> response = this.ptrVentaClient
        .postForEntity(
            this.ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_IPOD_INDIVIDUAL_DETALLE)
                .getEndpoint(),
            request, PtrVentaOnlineIpodIndividualDetalleResponseDto.class);
    assertEquals(HttpStatus.SC_OK, response.getStatusCode().value());
  }

  @Test
  public void ventaOnlineEntregaDomicilio() {
    final PtrVentaOnlineEntregaDomicilioRequestDto request = new PtrVentaOnlineEntregaDomicilioRequestDto();
    request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
    request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
    request.setTiendaOnline(PtrTestConstants.getID_TIENDA_ONLINE_LIST2());
    request.setPais(PtrTestConstants.PAIS);
    request.setEmpresa(List.of(PtrTestConstants.ID_EMPRESA_VENTA_ECOMMERCE));
    request.setCadena(PtrTestConstants.getCADENA_LIST());
    request.setAgrupacion(PtrGroupTypeEnum.FECHA_CADENA);
    request.setPais(PtrTestConstants.PAIS);
    final ResponseEntity<PtrVentaOnlineEntregaDomicilioResponseDto> response = this.ptrVentaClient
        .postForEntity(
            this.ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_DOMICILIO)
                .getEndpoint(),
            request, PtrVentaOnlineEntregaDomicilioResponseDto.class);

    assertEquals(HttpStatus.SC_OK, response.getStatusCode().value());
  }

  @Test
  public void ventaOnlineEntregaDomicilioFTS() {
    final PtrVentaOnlineEntregaDomicilioRequestDto request = new PtrVentaOnlineEntregaDomicilioRequestDto();
    request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
    request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
    request.setTiendaOnline(PtrTestConstants.getID_TIENDA_ONLINE_LIST2());
    request.setPais(PtrTestConstants.PAIS);
    request.setEmpresa(List.of(PtrTestConstants.ID_EMPRESA_VENTA_ECOMMERCE));
    request.setAgruparSeccion(PtrTestConstants.AGRUPAR_SECCION_TRUE);
    request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
    final ResponseEntity<PtrVentaOnlineEntregaDomicilioResponseDto> response = this.ptrVentaClient
        .postForEntity(
            this.ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_DOMICILIO)
                .getEndpoint(),
            request, PtrVentaOnlineEntregaDomicilioResponseDto.class);

    assertEquals(HttpStatus.SC_OK, response.getStatusCode().value());
  }

  @Test
  public void ventaOnlineEntregaTienda() {
    final PtrVentaOnlineEntregaTiendaRequestDto request = new PtrVentaOnlineEntregaTiendaRequestDto();
    request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
    request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
    request.setEmpresa(List.of(PtrTestConstants.ID_EMPRESA_VENTA_ECOMMERCE));
    request.setPais(PtrTestConstants.PAIS);
    request.setTiendaOnline(PtrTestConstants.getID_TIENDA_ONLINE_LIST2());
    request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA);
    request.setAgruparSeccion(0);
    final ResponseEntity<PtrVentaOnlineEntregaTiendaResponseDto> response = this.ptrVentaClient
        .postForEntity(
            this.ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_TIENDA).getEndpoint(),
            request, PtrVentaOnlineEntregaTiendaResponseDto.class);
    assertEquals(HttpStatus.SC_OK, response.getStatusCode().value());
  }

  @Test
  public void ventaOnlineEntregaTiendaFTS() {
    final PtrVentaOnlineEntregaTiendaRequestDto request = new PtrVentaOnlineEntregaTiendaRequestDto();
    request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
    request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
    request.setEmpresa(List.of(PtrTestConstants.ID_EMPRESA_VENTA_ECOMMERCE));
    request.setPais(PtrTestConstants.PAIS);
    request.setTiendaOnline(PtrTestConstants.getID_TIENDA_ONLINE_LIST2());
    request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
    request.setAgruparSeccion(PtrTestConstants.AGRUPAR_SECCION_TRUE);
    final ResponseEntity<PtrVentaOnlineEntregaTiendaResponseDto> response = this.ptrVentaClient
        .postForEntity(
            this.ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_TIENDA).getEndpoint(),
            request, PtrVentaOnlineEntregaTiendaResponseDto.class);
    assertEquals(HttpStatus.SC_OK, response.getStatusCode().value());
  }

  @Test
  public void ventaOnlinePicking() {
    final PtrVentaOnlinePickingRequestDto request = new PtrVentaOnlinePickingRequestDto();
    request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
    request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
    request.setEmpresa(List.of(PtrTestConstants.ID_EMPRESA));
    request.setPais(PtrTestConstants.PAIS);
    request.setTiendaOnline(PtrTestConstants.getID_TIENDA_ONLINE_LIST());
    request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA);
    request.setVentaPAT(PtrTestConstants.INCLUIR_VENTA_PAT);
    request.setExcluirIpod(PtrTestConstants.EXCLUIDO_IPOD);

    verify(this.ptrVentaClient, timeout(1000).times(1)).postForEntity("getVentaOnlineIpodIndividualDetalle",
        request, PtrVentaOnlinePickingResponseDto.class);

    /*
     * final ResponseEntity<PtrVentaOnlinePickingResponseDto> response = this.ptrVentaClient
     * .postForEntity(this.ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_PICKING).getEndpoint(), request,
     * PtrVentaOnlinePickingResponseDto.class);
     */
    // assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
  }

  @Test
  public void ventaOnlinePickingTS() {
    final PtrVentaOnlinePickingRequestDto request = new PtrVentaOnlinePickingRequestDto();
    request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
    request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
    request.setPais(PtrTestConstants.PAIS);
    request.setEmpresa(List.of(PtrTestConstants.ID_EMPRESA));
    request.setTiendaOnline(PtrTestConstants.getID_TIENDA_ONLINE_LIST());
    request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
    request.setVentaPAT(PtrTestConstants.INCLUIR_VENTA_PAT);
    request.setExcluirIpod(PtrTestConstants.EXCLUIDO_IPOD);

    final ResponseEntity<PtrVentaOnlinePickingResponseDto> response = this.ptrVentaClient
        .postForEntity(this.ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_PICKING).getEndpoint(),
            request, PtrVentaOnlinePickingResponseDto.class);

    assertEquals(HttpStatus.SC_OK, response.getStatusCode().value());
  }

  @Test
  public void ventaOnlinePickingXml() {
    final PtrVentaOnlinePickingRequestDto request = new PtrVentaOnlinePickingRequestDto();
    request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
    request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
    request.setPais(PtrTestConstants.PAIS);
    request.setEmpresa(List.of(PtrTestConstants.ID_EMPRESA));
    request.setTiendaOnline(PtrTestConstants.getID_TIENDA_ONLINE_LIST());
    request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
    request.setVentaPAT(PtrTestConstants.INCLUIR_VENTA_PAT);
    request.setExcluirIpod(PtrTestConstants.EXCLUIDO_IPOD);

    final HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_XML);
    headers.setAccept(List.of(MediaType.APPLICATION_XML));

    final HttpEntity<PtrVentaOnlinePickingRequestDto> request2 = new HttpEntity<PtrVentaOnlinePickingRequestDto>(
        request,
        headers);

    final ResponseEntity<PtrVentaOnlinePickingResponseDto> response = this.ptrVentaClient
        .postForEntity(this.ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_PICKING).getEndpoint(),
            request2, PtrVentaOnlinePickingResponseDto.class);
    assertEquals(HttpStatus.SC_OK, response.getStatusCode().value());
  }

}
