package com.inditex.rrhh.icmclcwb.ptr.venta;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.Application;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrTestConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
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

import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Application.class })
@ActiveProfiles({ "standalone", "test" })
@EnableAutoConfiguration
public class PtrVentaGeneralServiceTest {

    @Autowired
    @Qualifier("ptrVentaClient")
    private RestClient ptrVentaClient;

    @Autowired
    @Qualifier("ventaGeneralProperties")
    protected Map<String, PtrPropertiesDto> ventaGeneralProperties;

    @Test
    public void ventaTotalizadoFechaTiendaSeccion() {
        PtrVentaTotalizadoRequestDto request = new PtrVentaTotalizadoRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setPais(PtrTestConstants.PAIS);
        request.setCadena(PtrTestConstants.CADENA_LIST);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
        request.setAgruparSeccion(PtrTestConstants.AGRUPAR_SECCION_FALSE);
        ResponseEntity<PtrVentaTotalizadoResponseDto> response = ptrVentaClient
            .postForEntity(ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_TOTALIZADO).getEndpoint(), request,
                    PtrVentaTotalizadoResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }

    @Test
    public void ventaTotalizadoFechaTienda() {
        PtrVentaTotalizadoRequestDto request = new PtrVentaTotalizadoRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setPais(PtrTestConstants.PAIS);
        request.setCadena(PtrTestConstants.CADENA_LIST);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA);
        ResponseEntity<PtrVentaTotalizadoResponseDto> response = ptrVentaClient
            .postForEntity(ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_TOTALIZADO).getEndpoint(), request,
                    PtrVentaTotalizadoResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }

    @Test
    public void ventaTotalizadoFechaCadena() {
        PtrVentaTotalizadoRequestDto request = new PtrVentaTotalizadoRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setPais(PtrTestConstants.PAIS);
        request.setCadena(PtrTestConstants.CADENA_LIST);
        request.setAgrupacion(PtrGroupTypeEnum.FECHA_CADENA);
        request.setAgruparSeccion(PtrTestConstants.AGRUPAR_SECCION_FALSE);
        ResponseEntity<PtrVentaTotalizadoResponseDto> response = ptrVentaClient
            .postForEntity(ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_TOTALIZADO).getEndpoint(), request,
                    PtrVentaTotalizadoResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }

}
