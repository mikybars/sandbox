package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.util.RestUtils;

@Service
@Validated
public class PtrVentaServiceImpl implements PtrVentaService {

    @Autowired
    @Qualifier("ptrVentaClient")
    private RestClient ptrVentaClient;

    @Autowired
    @Qualifier("ventaTotalizadoDto")
    private PtrPropertiesDto ventaTotalizadoDto;

    @Autowired
    @Qualifier("ventaIndividualDetalleDto")
    private PtrPropertiesDto ventaIndividualDetalleDto;

    @Override
    public PtrVentaTotalizadoResponseDto getVentaTotalizado(@Valid final PtrVentaTotalizadoRequestDto request)
            throws Exception {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(ventaTotalizadoDto.getEndpoint(), request,
                        PtrVentaTotalizadoResponseDto.class),
                ptrVentaClient, ventaTotalizadoDto.getEndpoint(), request);
    }

    @Override
    public PtrVentaIndividualDetalleResponseDto getVentaIndividualDetalle(
            @Valid final PtrVentaIndividualDetalleRequestDto request) throws Exception {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(ventaIndividualDetalleDto.getEndpoint(), request,
                        PtrVentaIndividualDetalleResponseDto.class),
                ptrVentaClient, ventaIndividualDetalleDto.getEndpoint(), request);
    }

}