package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaEmpleadoService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.util.RestUtils;

@Service
@Validated
public class PtrVentaEmpleadoServiceImpl implements PtrVentaEmpleadoService{

    @Autowired
    @Qualifier("ptrVentaClient")
    private RestClient ptrVentaClient;
    
    @Autowired
    @Qualifier("ventaEmpleadoProperties")
    private Map<String, PtrPropertiesDto> ventaEmpleadoProperties;
    
    @Override
    public PtrVentaIndividualDetalleResponseDto getVentaIndividualDetalle(
            @Valid final PtrVentaIndividualDetalleRequestDto request) throws Exception {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(ventaEmpleadoProperties.get(PtrConstants.VENTA_INDIVIDUAL_DETALLE).getEndpoint(), request,
                        PtrVentaIndividualDetalleResponseDto.class),
                ptrVentaClient, ventaEmpleadoProperties.get(PtrConstants.VENTA_INDIVIDUAL_DETALLE).getEndpoint(), request);
    }
}
