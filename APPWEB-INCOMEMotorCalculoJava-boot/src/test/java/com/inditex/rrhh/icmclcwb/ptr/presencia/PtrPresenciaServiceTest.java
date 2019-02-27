package com.inditex.rrhh.icmclcwb.ptr.presencia;

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
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.Application;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto.PtrPresenciaTiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto.PtrPresenciaTiendasEmpleadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTotalTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrTestConstants;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Application.class })
@ActiveProfiles({ "standalone", "test" })
@EnableAutoConfiguration
public class PtrPresenciaServiceTest {

    @Autowired
    @Qualifier("ptrPresenciaClient")
    private RestClient ptrPresenciaClient;
  
    @Autowired
    @Qualifier("presenciasProperties")
    private Map<String, PtrPropertiesDto> presenciasProperties;
    
    @Autowired
    @Qualifier("presenciasVersion")
    private String version;
    
    @Test
    public void presenciasDetalle() {
        PtrPresenciaDetalleRequestDto request = new PtrPresenciaDetalleRequestDto();
        request.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        request.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        request.setCadena(PtrTestConstants.CADENA);
        request.setTienda(PtrTestConstants.ID_TIENDA);
        request.setOrigen(PtrTestConstants.PAIS);
        request.setPersona(PtrTestConstants.PERSONA_LIST);
        ResponseEntity<PtrPresenciaDetalleResponseDto> response = ptrPresenciaClient
                .postForEntity(presenciasProperties.get(PtrConstants.PRESENCIA_DETALLE).getEndpoint(), request, PtrPresenciaDetalleResponseDto.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
    }

    @Test
    public void presenciasDetalleComisionable() {
        PtrPresenciaDetalleComisionableRequestDto req = new PtrPresenciaDetalleComisionableRequestDto();
        req.setCadena(PtrTestConstants.CADENA);
        req.setTipo(PtrTestConstants.TIPO);
        req.setSeccion(PtrTestConstants.SECCION);
        req.setTienda(PtrTestConstants.ID_TIENDA);
        req.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        req.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        req.setOrigen(PtrTestConstants.PAIS);
        req.setPersona(PtrTestConstants.PERSONA_LIST);
        ResponseEntity<PtrPresenciaDetalleComisionableResponseDto> ret = ptrPresenciaClient.postForEntity(
                presenciasProperties.get(PtrConstants.PRESENCIA_DETALLE_COMISIONABLE).getEndpoint(), req,
                PtrPresenciaDetalleComisionableResponseDto.class);
        assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
    }

    @Test
    public void presenciasTotalTienda() {
        PtrPresenciaTotalTiendaRequestDto req = new PtrPresenciaTotalTiendaRequestDto();
        req.setTienda(PtrTestConstants.ID_TIENDA_LIST);
        req.setOrigen(PtrTestConstants.PAIS);
        req.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        req.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        req.setTipo(PtrTestConstants.TIPO);
        req.setCadena(PtrTestConstants.CADENA);
        ResponseEntity<PtrPresenciaTotalTiendaResponseDto> ret = ptrPresenciaClient.postForEntity(
                presenciasProperties.get(PtrConstants.PRESENCIA_TOTAL_TIENDA).getEndpoint(), req, PtrPresenciaTotalTiendaResponseDto.class);
        assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
    }

    @Test
    public void presenciasTotalTiendaSeccion() {
        PtrPresenciaTotalTiendaSeccionRequestDto req = new PtrPresenciaTotalTiendaSeccionRequestDto();
        req.setTiendaSeccion(Arrays.asList(PtrTestConstants.TIENDA_SECCION_1, PtrTestConstants.TIENDA_SECCION_2));
        req.setOrigen(PtrTestConstants.PAIS);
        req.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        req.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        req.setTipo(PtrTestConstants.TIPO);
        req.setCadena(PtrTestConstants.CADENA);
        ResponseEntity<PtrPresenciaTotalTiendaSeccionResponseDto> ret = ptrPresenciaClient.postForEntity(
                presenciasProperties.get(PtrConstants.PRESENCIA_TOTAL_TIENDA_SECCION).getEndpoint(), req,
                PtrPresenciaTotalTiendaSeccionResponseDto.class);
        assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
    }
    
    @Test
    public void presenciasTiendasEmpleado(){
        PtrPresenciaTiendasEmpleadoRequestDto req = new PtrPresenciaTiendasEmpleadoRequestDto();
        req.setFechaDesde(PtrTestConstants.FECHA_DESDE);
        req.setFechaHasta(PtrTestConstants.FECHA_HASTA);
        req.setOrigen(PtrTestConstants.ORIGEN);
        req.setCadena(PtrTestConstants.CADENA_LIST);
        req.setPersona(PtrTestConstants.PERSONA_LIST);
        req.setTipo(PtrTestConstants.TIPO_LIST);
        ResponseEntity<PtrPresenciaTiendasEmpleadoResponseDto> ret = ptrPresenciaClient.postForEntity(
                presenciasProperties.get(PtrConstants.PRESENCIA_TIENDAS_EMPLEADO).getEndpoint(), req,
                PtrPresenciaTiendasEmpleadoResponseDto.class);
        assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
    }

    @Test
    public void tiposHoras() {
        PtrPresenciaTiposHorasRequestDto req2 = new PtrPresenciaTiposHorasRequestDto();
        req2.setOrigen(PtrTestConstants.PAIS);
        ResponseEntity<PtrPresenciaTiposHorasResponseDto> ret2 = ptrPresenciaClient
                .postForEntity(presenciasProperties.get(PtrConstants.PRESENCIA_TIPOS_HORAS).getEndpoint(), req2, PtrPresenciaTiposHorasResponseDto.class);
        assertEquals(HttpStatus.SC_OK, ret2.getStatusCodeValue());
    }
    
    @Test
    public void test() {
        ResponseEntity<Boolean> response = ptrPresenciaClient.getForEntity(
                presenciasProperties.get(PtrConstants.PRESENCIA_TEST).getEndpoint(), Boolean.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
        assertEquals(Boolean.TRUE, response.getBody());
    }
    
    @Test
    public void version() {
        ResponseEntity<String> response = ptrPresenciaClient.getForEntity(
                presenciasProperties.get(PtrConstants.PRESENCIA_VERSION).getEndpoint(), String.class);
        assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
        assertEquals(version, response.getBody());
        
    }

}
