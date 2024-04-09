package com.inditex.rrhh.icmclcwb.ptr.presencia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import com.inditex.amigafwk.common.rest.client.RestClient;
import com.inditex.amigafwk.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto.PtrPresenciaTiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto.PtrPresenciaTiendasEmpleadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrTestConstants;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
@Disabled
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
    final PtrPresenciaDetalleRequestDto req = new PtrPresenciaDetalleRequestDto();
    req.setFechaDesde(PtrTestConstants.FECHA_DESDE);
    req.setFechaHasta(PtrTestConstants.FECHA_HASTA);
    req.setCadena(PtrTestConstants.getCADENA_LIST());
    req.setTienda(PtrTestConstants.getID_TIENDA_LIST());
    req.setOrigen(PtrTestConstants.PAIS);
    req.setPersona(PtrTestConstants.getPERSONA_LIST());
    req.setAgrupacion(PtrTestConstants.AGRUPACION_FECHA_TIENDA);
    req.setAgruparSeccion(PtrTestConstants.AGRUPAR_SECCION_FALSE);
    req.setExcluidoCalculo(Boolean.FALSE);
    final ResponseEntity<PtrPresenciaDetalleResponseDto> response = this.ptrPresenciaClient
        .postForEntity(this.presenciasProperties.get(PtrPropertiesConstants.PRESENCIA_DETALLE).getEndpoint(), req,
            PtrPresenciaDetalleResponseDto.class);
    assertEquals(HttpStatus.SC_OK, response.getStatusCodeValue());
  }

  @Test
  public void presenciasTotalizado() {
    final PtrPresenciaTotalizadoRequestDto req = new PtrPresenciaTotalizadoRequestDto();
    req.setTienda(PtrTestConstants.getID_TIENDA_LIST());
    req.setOrigen(PtrTestConstants.PAIS);
    req.setFechaDesde(PtrTestConstants.FECHA_DESDE);
    req.setFechaHasta(PtrTestConstants.FECHA_HASTA);
    // req.setCadena(PtrTestConstants.getCADENA_LIST());
    req.setEmpresa(PtrTestConstants.getEMPRESA_LIST());
    req.setAgrupacion(PtrTestConstants.AGRUPACION_FECHA_TIENDA);
    req.setAgruparSeccion(PtrTestConstants.AGRUPAR_SECCION_FALSE);
    final ResponseEntity<PtrPresenciaTotalizadoResponseDto> ret = this.ptrPresenciaClient.postForEntity(
        this.presenciasProperties.get(PtrPropertiesConstants.PRESENCIA_TOTALIZADO).getEndpoint(), req,
        PtrPresenciaTotalizadoResponseDto.class);
    assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
  }

  @Test
  public void presenciasTiendasEmpleado() {
    final PtrPresenciaTiendasEmpleadoRequestDto req = new PtrPresenciaTiendasEmpleadoRequestDto();
    req.setFechaDesde(PtrTestConstants.FECHA_DESDE);
    req.setFechaHasta(PtrTestConstants.FECHA_HASTA);
    req.setOrigen(PtrTestConstants.ORIGEN);
    req.setCadena(PtrTestConstants.getCADENA_LIST());
    req.setPersona(PtrTestConstants.getPERSONA_LIST());
    req.setTipo(PtrTestConstants.getTIPO_LIST());
    req.setAgrupacion(PtrTestConstants.AGRUPACION);
    req.setExcluidoCalculo(Boolean.FALSE);
    final ResponseEntity<PtrPresenciaTiendasEmpleadoResponseDto> ret = this.ptrPresenciaClient.postForEntity(
        this.presenciasProperties.get(PtrPropertiesConstants.PRESENCIA_TIENDAS_EMPLEADO).getEndpoint(), req,
        PtrPresenciaTiendasEmpleadoResponseDto.class);
    assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
  }

  @Test
  public void presenciasEmpleadoTienda() {
    final PtrPresenciaEmpleadosTiendaRequestDto req = new PtrPresenciaEmpleadosTiendaRequestDto();
    req.setFechaDesde(PtrTestConstants.FECHA_DESDE);
    req.setFechaHasta(PtrTestConstants.FECHA_HASTA);
    req.setOrigen(PtrTestConstants.ORIGEN);
    req.setCadena(PtrTestConstants.getCADENA_LIST());
    req.setTienda(PtrTestConstants.getID_TIENDA_LIST());
    req.setTipo(PtrTestConstants.getTIPO_LIST());
    req.setAgrupacion(PtrTestConstants.AGRUPACION);
    req.setExcluidoCalculo(Boolean.FALSE);
    final ResponseEntity<PtrPresenciaTiendasEmpleadoResponseDto> ret = this.ptrPresenciaClient.postForEntity(
        this.presenciasProperties.get(PtrPropertiesConstants.PRESENCIA_TIENDAS_EMPLEADO).getEndpoint(), req,
        PtrPresenciaTiendasEmpleadoResponseDto.class);
    assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
  }

  @Test
  public void tiposHoras() {
    final PtrPresenciaTiposHorasRequestDto req = new PtrPresenciaTiposHorasRequestDto();
    req.setOrigen(PtrTestConstants.PAIS);
    req.setExcluidoCalculo(Boolean.FALSE);
    final ResponseEntity<PtrPresenciaTiposHorasResponseDto> ret2 = this.ptrPresenciaClient
        .postForEntity(this.presenciasProperties.get(PtrPropertiesConstants.PRESENCIA_TIPOS_HORAS).getEndpoint(),
            req,
            PtrPresenciaTiposHorasResponseDto.class);
    assertEquals(HttpStatus.SC_OK, ret2.getStatusCodeValue());
  }

}
