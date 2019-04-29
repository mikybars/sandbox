package com.inditex.rrhh.icmclcwb.model.ptr.presencia.service;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.service.PtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto.PtrPresenciaTiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto.PtrPresenciaTiendasEmpleadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTotalTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.RestUtils;

@Service
@Validated
public class PtrPresenciaServiceImpl implements PtrPresenciaService {

    @Autowired
    @Qualifier("ptrPresenciaClient")
    private RestClient ptrPresenciaClient;
   
    @Autowired
    @Qualifier("presenciasProperties")
    private Map<String, PtrPropertiesDto> presenciasProperties;

    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrPresenciaTotalTiendaSeccionResponseDto presenciasTotalTiendaSeccion(
            @Valid final PtrPresenciaTotalTiendaSeccionRequestDto request) {
        return RestUtils.checkResponse(
                ptrPresenciaClient.postForEntity(presenciasProperties.get(PtrConstants.PRESENCIA_TOTAL_TIENDA_SECCION).getEndpoint(), request,
                        PtrPresenciaTotalTiendaSeccionResponseDto.class),
                ptrPresenciaClient, presenciasProperties.get(PtrConstants.PRESENCIA_TOTAL_TIENDA_SECCION).getEndpoint(), request);
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrPresenciaDetalleResponseDto presenciasDetalle(@Valid final PtrPresenciaDetalleRequestDto request) {
        return RestUtils.checkResponse(
                ptrPresenciaClient.postForEntity(presenciasProperties.get(PtrConstants.PRESENCIA_DETALLE).getEndpoint(), request,
                        PtrPresenciaDetalleResponseDto.class),
                ptrPresenciaClient, presenciasProperties.get(PtrConstants.PRESENCIA_DETALLE).getEndpoint(), request);
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrPresenciaDetalleComisionableResponseDto presenciasDetalleComisionable(
            @Valid final PtrPresenciaDetalleComisionableRequestDto request) {
        return RestUtils.checkResponse(
                ptrPresenciaClient.postForEntity(presenciasProperties.get(PtrConstants.PRESENCIA_DETALLE_COMISIONABLE).getEndpoint(), request,
                        PtrPresenciaDetalleComisionableResponseDto.class),
                ptrPresenciaClient, presenciasProperties.get(PtrConstants.PRESENCIA_DETALLE_COMISIONABLE).getEndpoint(), request);
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrPresenciaTiposHorasResponseDto tiposHoras(@Valid final PtrPresenciaTiposHorasRequestDto request) {
        return RestUtils.checkResponse(
                ptrPresenciaClient.postForEntity(presenciasProperties.get(PtrConstants.PRESENCIA_TIPOS_HORAS).getEndpoint(), request, 
                        PtrPresenciaTiposHorasResponseDto.class),
                ptrPresenciaClient, presenciasProperties.get(PtrConstants.PRESENCIA_TIPOS_HORAS).getEndpoint(), request);
    }
    
    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrPresenciaTotalTiendaResponseDto presenciasTotalTienda(
            @Valid final PtrPresenciaTotalTiendaRequestDto request) {
        return RestUtils.checkResponse(
                ptrPresenciaClient.postForEntity(presenciasProperties.get(PtrConstants.PRESENCIA_TOTAL_TIENDA).getEndpoint(), request,
                        PtrPresenciaTotalTiendaResponseDto.class),
                ptrPresenciaClient, presenciasProperties.get(PtrConstants.PRESENCIA_TOTAL_TIENDA).getEndpoint(), request);
    }
    
    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrPresenciaTiendasEmpleadoResponseDto presenciasTiendasEmpleado(
            @Valid final PtrPresenciaTiendasEmpleadoRequestDto request) {
        return RestUtils.checkResponse(
                ptrPresenciaClient.postForEntity(presenciasProperties.get(PtrConstants.PRESENCIA_TIENDAS_EMPLEADO).getEndpoint(), request,
                        PtrPresenciaTiendasEmpleadoResponseDto.class),
                ptrPresenciaClient, presenciasProperties.get(PtrConstants.PRESENCIA_TIENDAS_EMPLEADO).getEndpoint(), request);
    }
    
    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrPresenciaEmpleadosTiendaResponseDto presenciasEmpleadosTienda(
            @Valid final PtrPresenciaEmpleadosTiendaRequestDto request) {
        return RestUtils.checkResponse(
                ptrPresenciaClient.postForEntity(presenciasProperties.get(PtrConstants.PRESENCIA_EMPLEADOS_TIENDA).getEndpoint(), request,
                        PtrPresenciaEmpleadosTiendaResponseDto.class),
                ptrPresenciaClient, presenciasProperties.get(PtrConstants.PRESENCIA_EMPLEADOS_TIENDA).getEndpoint(), request);
    }
    
    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public String test() {
        return RestUtils.checkResponse(
                ptrPresenciaClient.getForEntity(presenciasProperties.get(PtrConstants.TEST).getEndpoint(),
                        String.class),
                ptrPresenciaClient, presenciasProperties.get(PtrConstants.TEST).getEndpoint(), null);
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public String version() {
        return RestUtils.checkResponse(
                ptrPresenciaClient.getForEntity(
                        presenciasProperties.get(PtrConstants.VERSION).getEndpoint(), String.class),
                ptrPresenciaClient, presenciasProperties.get(PtrConstants.VERSION).getEndpoint(), null);
    }

}
