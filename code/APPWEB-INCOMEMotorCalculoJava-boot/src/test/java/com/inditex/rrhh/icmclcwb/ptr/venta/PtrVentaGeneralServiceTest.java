package com.inditex.rrhh.icmclcwb.ptr.venta;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import com.inditex.amigafwk.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrTestConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

import org.apache.hc.core5.http.HttpStatus;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
@Disabled
public class PtrVentaGeneralServiceTest {

  @Autowired
  @Qualifier("ptrVentaClient")
  private RestClient ptrVentaClient;

  @Autowired
  @Qualifier("ventaGeneralProperties")
  protected Map<String, PtrPropertiesDto> ventaGeneralProperties;

  @Test
  public void ventaTotalizadoFechaTiendaSeccion() {
    final PtrVentaTotalizadoRequestDto request = new PtrVentaTotalizadoRequestDto();
    request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
    request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
    request.setPais(PtrTestConstants.PAIS);
    request.setCadena(PtrTestConstants.getCADENA_LIST());
    request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
    request.setAgruparSeccion(PtrTestConstants.AGRUPAR_SECCION_FALSE);
    final ResponseEntity<PtrVentaTotalizadoResponseDto> response = this.ptrVentaClient
        .postForEntity(this.ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_TOTALIZADO).getEndpoint(),
            request,
            PtrVentaTotalizadoResponseDto.class);
    assertEquals(HttpStatus.SC_OK, response.getStatusCode().value());
  }

  @Test
  public void ventaTotalizadoFechaTienda() {
    final PtrVentaTotalizadoRequestDto request = new PtrVentaTotalizadoRequestDto();
    request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
    request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
    request.setPais(PtrTestConstants.PAIS);
    request.setCadena(PtrTestConstants.getCADENA_LIST());
    request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA);
    final ResponseEntity<PtrVentaTotalizadoResponseDto> response = this.ptrVentaClient
        .postForEntity(this.ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_TOTALIZADO).getEndpoint(),
            request,
            PtrVentaTotalizadoResponseDto.class);
    assertEquals(HttpStatus.SC_OK, response.getStatusCode().value());
  }

  @Test
  public void ventaTotalizadoFechaCadena() {
    final PtrVentaTotalizadoRequestDto request = new PtrVentaTotalizadoRequestDto();
    request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
    request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
    request.setPais(PtrTestConstants.PAIS);
    request.setCadena(PtrTestConstants.getCADENA_LIST());
    request.setAgrupacion(PtrGroupTypeEnum.FECHA_CADENA);
    request.setAgruparSeccion(PtrTestConstants.AGRUPAR_SECCION_FALSE);
    final ResponseEntity<PtrVentaTotalizadoResponseDto> response = this.ptrVentaClient
        .postForEntity(this.ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_TOTALIZADO).getEndpoint(),
            request,
            PtrVentaTotalizadoResponseDto.class);
    assertEquals(HttpStatus.SC_OK, response.getStatusCode().value());
  }

}
