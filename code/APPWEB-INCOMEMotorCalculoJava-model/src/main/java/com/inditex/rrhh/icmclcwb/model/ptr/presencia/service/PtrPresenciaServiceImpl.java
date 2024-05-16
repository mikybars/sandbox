package com.inditex.rrhh.icmclcwb.model.ptr.presencia.service;

import java.util.Map;

import com.inditex.amigafwk.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.service.PtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto.PtrPresenciaTiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto.PtrPresenciaTiendasEmpleadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.RestUtils;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class PtrPresenciaServiceImpl implements PtrPresenciaService {

  @Autowired
  @Qualifier("ptrPresenciaClient")
  private RestClient ptrPresenciaClient;

  @Autowired
  @Qualifier("presenciasProperties")
  private Map<String, PtrPropertiesDto> presenciasProperties;

  @Retryable(maxAttemptsExpression = "${app.envars.ptr.config.max-attempts}")
  @Override
  public PtrPresenciaTotalizadoResponseDto presenciasTotalizado(
      @Valid final PtrPresenciaTotalizadoRequestDto request) {
    return RestUtils.checkResponse(
        this.ptrPresenciaClient.postForEntity(
            this.presenciasProperties.get(PtrPropertiesConstants.PRESENCIA_TOTALIZADO).getEndpoint(),
            request,
            PtrPresenciaTotalizadoResponseDto.class),
        this.ptrPresenciaClient,
        this.presenciasProperties.get(PtrPropertiesConstants.PRESENCIA_TOTALIZADO).getEndpoint(),
        request);
  }

  @Retryable(maxAttemptsExpression = "${app.envars.ptr.config.max-attempts}")
  @Override
  public PtrPresenciaDetalleResponseDto presenciasDetalle(@Valid final PtrPresenciaDetalleRequestDto request) {
    return RestUtils.checkResponse(
        this.ptrPresenciaClient.postForEntity(
            this.presenciasProperties.get(PtrPropertiesConstants.PRESENCIA_DETALLE).getEndpoint(), request,
            PtrPresenciaDetalleResponseDto.class),
        this.ptrPresenciaClient,
        this.presenciasProperties.get(PtrPropertiesConstants.PRESENCIA_DETALLE).getEndpoint(),
        request);
  }

  @Retryable(maxAttemptsExpression = "${app.envars.ptr.config.max-attempts}")
  @Override
  public PtrPresenciaTiposHorasResponseDto tiposHoras(@Valid final PtrPresenciaTiposHorasRequestDto request) {
    return RestUtils.checkResponse(
        this.ptrPresenciaClient.postForEntity(
            this.presenciasProperties.get(PtrPropertiesConstants.PRESENCIA_TIPOS_HORAS).getEndpoint(),
            request,
            PtrPresenciaTiposHorasResponseDto.class),
        this.ptrPresenciaClient,
        this.presenciasProperties.get(PtrPropertiesConstants.PRESENCIA_TIPOS_HORAS).getEndpoint(), request);
  }

  @Retryable(maxAttemptsExpression = "${app.envars.ptr.config.max-attempts}")
  @Override
  public PtrPresenciaTiendasEmpleadoResponseDto presenciasTiendasEmpleado(
      @Valid final PtrPresenciaTiendasEmpleadoRequestDto request) {
    return RestUtils.checkResponse(
        this.ptrPresenciaClient.postForEntity(
            this.presenciasProperties.get(PtrPropertiesConstants.PRESENCIA_TIENDAS_EMPLEADO).getEndpoint(),
            request, PtrPresenciaTiendasEmpleadoResponseDto.class),
        this.ptrPresenciaClient,
        this.presenciasProperties.get(PtrPropertiesConstants.PRESENCIA_TIENDAS_EMPLEADO).getEndpoint(),
        request);
  }

  @Retryable(maxAttemptsExpression = "${app.envars.ptr.config.max-attempts}")
  @Override
  public PtrPresenciaEmpleadosTiendaResponseDto presenciasEmpleadosTienda(
      @Valid final PtrPresenciaEmpleadosTiendaRequestDto request) {
    return RestUtils.checkResponse(
        this.ptrPresenciaClient.postForEntity(
            this.presenciasProperties.get(PtrPropertiesConstants.PRESENCIA_EMPLEADOS_TIENDA).getEndpoint(),
            request, PtrPresenciaEmpleadosTiendaResponseDto.class),
        this.ptrPresenciaClient,
        this.presenciasProperties.get(PtrPropertiesConstants.PRESENCIA_EMPLEADOS_TIENDA).getEndpoint(),
        request);
  }

}
