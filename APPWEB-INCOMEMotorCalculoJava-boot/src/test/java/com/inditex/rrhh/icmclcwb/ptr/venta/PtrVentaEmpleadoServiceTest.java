package com.inditex.rrhh.icmclcwb.ptr.venta;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.apache.http.HttpStatus;
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
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.PtrVentaIndividualDetalleResponseDto;

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
    public void getVentaIndividualDetalle() {
        PtrVentaIndividualDetalleRequestDto request = new PtrVentaIndividualDetalleRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setPais(PtrTestConstants.PAIS);
        request.setCadena(PtrTestConstants.CADENA);
        ResponseEntity<PtrVentaIndividualDetalleResponseDto> response = ptrVentaClient.postForEntity(
                ventaEmpleadoProperties.get(PtrConstants.VENTA_INDIVIDUAL_DETALLE).getEndpoint(), request, PtrVentaIndividualDetalleResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }

    
}
