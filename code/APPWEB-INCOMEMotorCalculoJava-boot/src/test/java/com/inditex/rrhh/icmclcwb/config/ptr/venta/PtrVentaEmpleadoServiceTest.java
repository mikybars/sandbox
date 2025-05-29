package com.inditex.rrhh.icmclcwb.config.ptr.venta;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import com.inditex.amigafwk.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrTestConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupSellerTypeEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;

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
public class PtrVentaEmpleadoServiceTest {

  @Autowired
  @Qualifier("ptrVentaClient")
  private RestClient ptrVentaClient;

  @Autowired
  @Qualifier("ventaEmpleadoProperties")
  protected Map<String, PtrPropertiesDto> ventaEmpleadoProperties;

  @Autowired
  @Qualifier("ventaVersion")
  private String version;

  @Disabled("Tarda demasiado!")
  @Test
  public void ventaIndividualDetalle() {
    final PtrVentaIndividualDetalleRequestDto request = new PtrVentaIndividualDetalleRequestDto();
    request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
    request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
    request.setPais(PtrTestConstants.PAIS);
    request.setCadena(PtrTestConstants.CADENA);
    request.setEmpresa(List.of(PtrTestConstants.ID_EMPRESA_VENTA_EMPLEADO));
    request.setTienda(PtrTestConstants.getID_TIENDA_VENTA_EMPLEADO());
    request.setAgrupacion(PtrGroupSellerTypeEnum.FECHA_TIENDA);
    request.setAgruparSeccion(PtrTestConstants.AGRUPAR_SECCION_FALSE);
    final ResponseEntity<PtrVentaIndividualDetalleResponseDto> response = this.ptrVentaClient.postForEntity(
        this.ventaEmpleadoProperties.get(PtrPropertiesConstants.VENTA_INDIVIDUAL_DETALLE).getEndpoint(),
        request,
        PtrVentaIndividualDetalleResponseDto.class);
    assertEquals(HttpStatus.SC_OK, response.getStatusCode().value());
  }

}
