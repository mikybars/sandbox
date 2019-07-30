package com.inditex.rrhh.icmclcwb.ptr.venta;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.Application;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrTestConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupSellerTypeEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
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

import java.util.Map;

import static org.junit.Assert.assertEquals;

@Ignore("Se ignora por que tarda demasiado")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Application.class })
@ActiveProfiles({ "standalone", "test" })
@EnableAutoConfiguration
public class PtrVentaEmpleadoServiceTest  {

    @Autowired
    @Qualifier("ptrVentaClient")
    private RestClient ptrVentaClient;
    
    @Autowired
    @Qualifier("ventaEmpleadoProperties")
    protected Map<String, PtrPropertiesDto> ventaEmpleadoProperties;
    
    @Autowired
    @Qualifier("ventaVersion")
    private String version;

    @Test
    public void ventaIndividualDetalle() {
        PtrVentaIndividualDetalleRequestDto request = new PtrVentaIndividualDetalleRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setPais(PtrTestConstants.PAIS);
        request.setCadena(PtrTestConstants.CADENA);
        request.setEmpresa(PtrTestConstants.ID_EMPRESA_VENTA_EMPLEADO);
        request.setTienda(PtrTestConstants.ID_TIENDA_VENTA_EMPLEADO);
        request.setAgrupacion(PtrGroupSellerTypeEnum.FECHA_TIENDA);
        request.setAgruparSeccion(PtrTestConstants.AGRUPAR_SECCION_FALSE);
        ResponseEntity<PtrVentaIndividualDetalleResponseDto> response = ptrVentaClient.postForEntity(
                ventaEmpleadoProperties.get(PtrPropertiesConstants.VENTA_INDIVIDUAL_DETALLE).getEndpoint(), request, PtrVentaIndividualDetalleResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }
    
}
