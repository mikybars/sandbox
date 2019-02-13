package com.inditex.rrhh.icmclcwb.model.ptr.presencia.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.service.PtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.util.RestUtils;

@Service
@Validated
public class PtrPresenciaServiceImpl implements PtrPresenciaService {

    @Autowired
    @Qualifier("ptrPresenciaClient")
    private RestClient ptrPresenciaClient;

    @Autowired
    @Qualifier("presenciasTotalTiendaSeccionDto")
    private PtrPropertiesDto presenciasTotalTiendaSeccionDto;

    @Autowired
    @Qualifier("presenciasDetalleDto")
    private PtrPropertiesDto presenciasDetalleDto;

    @Autowired
    @Qualifier("presenciasDetalleComisionableDto")
    private PtrPropertiesDto presenciasDetalleComisionableDto;

    @Autowired
    @Qualifier("tiposHorasDto")
    private PtrPropertiesDto presenciasTiposHorasDto;

    @Override
    public PtrPresenciaTotalTiendaSeccionResponseDto getPresenciasTotalTiendaSeccionDto(
            @Valid final PtrPresenciaTotalTiendaSeccionRequestDto request) {
        return RestUtils.checkResponse(
                ptrPresenciaClient.postForEntity(presenciasTotalTiendaSeccionDto.getEndpoint(), request,
                        PtrPresenciaTotalTiendaSeccionResponseDto.class),
                ptrPresenciaClient, presenciasTotalTiendaSeccionDto.getEndpoint(), request);
    }

    @Override
    public PtrPresenciaDetalleResponseDto getPresenciasDetalleDto(@Valid final PtrPresenciaDetalleRequestDto request) {
        return RestUtils.checkResponse(
                ptrPresenciaClient.postForEntity(presenciasDetalleDto.getEndpoint(), request,
                        PtrPresenciaDetalleResponseDto.class),
                ptrPresenciaClient, presenciasDetalleDto.getEndpoint(), request);
    }

    @Override
    public PtrPresenciaDetalleComisionableResponseDto getPresenciasDetalleComisionableDto(
            @Valid final PtrPresenciaDetalleComisionableRequestDto request) {
        return RestUtils.checkResponse(
                ptrPresenciaClient.postForEntity(presenciasDetalleComisionableDto.getEndpoint(), request,
                        PtrPresenciaDetalleComisionableResponseDto.class),
                ptrPresenciaClient, presenciasDetalleComisionableDto.getEndpoint(), request);
    }

    @Override
    public PtrPresenciaTiposHorasResponseDto getTiposHorasDto(@Valid PtrPresenciaTiposHorasRequestDto request) {
        return RestUtils.checkResponse(
                ptrPresenciaClient.postForEntity(presenciasTiposHorasDto.getEndpoint(), request,
                        PtrPresenciaTiposHorasResponseDto.class),
                ptrPresenciaClient, presenciasTiposHorasDto.getEndpoint(), request);
    }

}
