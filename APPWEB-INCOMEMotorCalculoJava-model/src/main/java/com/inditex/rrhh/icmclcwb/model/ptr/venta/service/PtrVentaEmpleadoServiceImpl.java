package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaEmpleadoService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.util.RestUtils;

@Service
@Validated
public class PtrVentaEmpleadoServiceImpl extends PtrVentaServiceImpl implements PtrVentaEmpleadoService{

    @Override
    public PtrVentaIndividualDetalleResponseDto getVentaIndividualDetalle(
            @Valid final PtrVentaIndividualDetalleRequestDto request) throws Exception {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(ptrProps.get(PtrConstants.VENTA_INDIVIDUAL_DETALLE).getEndpoint(), request,
                        PtrVentaIndividualDetalleResponseDto.class),
                ptrVentaClient, ptrProps.get(PtrConstants.VENTA_INDIVIDUAL_DETALLE).getEndpoint(), request);
    }
}
