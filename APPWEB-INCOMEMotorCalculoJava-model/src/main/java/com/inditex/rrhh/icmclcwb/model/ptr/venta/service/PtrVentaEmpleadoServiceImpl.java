package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individual.dto.PtrVentaIndividualRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individual.dto.PtrVentaIndividualResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetallemcc.dto.PtrVentaIndividualDetalleByMccRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetallemcc.dto.PtrVentaIndividualDetalleByMccResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualmcc.dto.PtrVentaIndividualByMccRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualmcc.dto.PtrVentaIndividualByMccResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaEmpleadoService;
import com.inditex.rrhh.icmclcwb.model.app.util.RestUtils;

@Service
@Validated
public class PtrVentaEmpleadoServiceImpl implements PtrVentaEmpleadoService {

    @Autowired
    @Qualifier("ptrVentaClient")
    private RestClient ptrVentaClient;

    @Autowired
    @Qualifier("ventaEmpleadoProperties")
    private Map<String, PtrPropertiesDto> ventaEmpleadoProperties;

    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrVentaIndividualDetalleResponseDto ventaIndividualDetalle(
            @Valid final PtrVentaIndividualDetalleRequestDto request) {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(
                        ventaEmpleadoProperties.get(PtrConstants.VENTA_INDIVIDUAL_DETALLE).getEndpoint(), request,
                        PtrVentaIndividualDetalleResponseDto.class),
                ptrVentaClient, ventaEmpleadoProperties.get(PtrConstants.VENTA_INDIVIDUAL_DETALLE).getEndpoint(),
                request);
    }
    
    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrVentaIndividualDetalleByMccResponseDto ventaIndividualDetalleByMcc(
            @Valid final PtrVentaIndividualDetalleByMccRequestDto request) {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(
                        ventaEmpleadoProperties.get(PtrConstants.VENTA_INDIVIDUAL_DETALLE_BY_MCC).getEndpoint(), request,
                        PtrVentaIndividualDetalleByMccResponseDto.class),
                ptrVentaClient, ventaEmpleadoProperties.get(PtrConstants.VENTA_INDIVIDUAL_DETALLE_BY_MCC).getEndpoint(),
                request);
    }
    
    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrVentaIndividualResponseDto ventaIndividual(
            @Valid final PtrVentaIndividualRequestDto request) {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(
                        ventaEmpleadoProperties.get(PtrConstants.VENTA_INDIVIDUAL).getEndpoint(), request,
                        PtrVentaIndividualResponseDto.class),
                ptrVentaClient, ventaEmpleadoProperties.get(PtrConstants.VENTA_INDIVIDUAL).getEndpoint(),
                request);
    }
    
    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrVentaIndividualByMccResponseDto ventaIndividualByMCC(
            @Valid final PtrVentaIndividualByMccRequestDto request) {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(
                        ventaEmpleadoProperties.get(PtrConstants.VENTA_INDIVIDUAL_BY_MCC).getEndpoint(), request,
                        PtrVentaIndividualByMccResponseDto.class),
                ptrVentaClient, ventaEmpleadoProperties.get(PtrConstants.VENTA_INDIVIDUAL_BY_MCC).getEndpoint(),
                request);
    }
    
    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public String test() {
        return RestUtils.checkResponse(
                ptrVentaClient.getForEntity(ventaEmpleadoProperties.get(PtrConstants.TEST).getEndpoint(),
                        String.class),
                ptrVentaClient, ventaEmpleadoProperties.get(PtrConstants.TEST).getEndpoint(), null);
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public String version() {
        return RestUtils.checkResponse(
                ptrVentaClient.getForEntity(
                        ventaEmpleadoProperties.get(PtrConstants.VERSION).getEndpoint(), String.class),
                ptrVentaClient, ventaEmpleadoProperties.get(PtrConstants.VERSION).getEndpoint(), null);
    }
}
