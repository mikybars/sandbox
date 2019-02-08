package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaGeneralService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventadiaria.dto.PtrVentaDiariaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventadiaria.dto.PtrVentaDiariaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventamensual.dto.PtrVentaMensualRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventamensual.dto.PtrVentaMensualResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventapresupuestadamensual.dto.PtrVentaPresupuestadaMensualRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventapresupuestadamensual.dto.PtrVentaPresupuestadaMensualResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizadobymcc.dto.PtrVentaTotalizadoByMccRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizadobymcc.dto.PtrVentaTotalizadoByMccResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizadoxml.dto.PtrVentaTotalizadoXmlRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizadoxml.dto.PtrVentaTotalizadoXmlResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.util.RestUtils;

@Service
@Validated
public class PtrVentaGeneralServiceImpl extends PtrVentaServiceImpl implements PtrVentaGeneralService {

    @Override
    public PtrVentaTotalizadoResponseDto getVentaTotalizado(@Valid final PtrVentaTotalizadoRequestDto request)
            throws Exception {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(ptrProps.get(PtrConstants.VENTA_TOTALIZADO).getEndpoint(), request,
                        PtrVentaTotalizadoResponseDto.class),
                ptrVentaClient, ptrProps.get(PtrConstants.VENTA_TOTALIZADO).getEndpoint(), request);
    }
    
    @Override
    public PtrVentaMensualResponseDto getVentaMensual(@Valid final PtrVentaMensualRequestDto request)
            throws Exception {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(ptrProps.get(PtrConstants.VENTA_MENSUAL).getEndpoint(), request,
                        PtrVentaMensualResponseDto.class),
                ptrVentaClient, ptrProps.get(PtrConstants.VENTA_MENSUAL).getEndpoint(), request);
    }
    
    @Override
    public PtrVentaDiariaResponseDto getVentaDiaria(@Valid final PtrVentaDiariaRequestDto request)
            throws Exception {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(ptrProps.get(PtrConstants.VENTA_DIARIA).getEndpoint(), request,
                        PtrVentaDiariaResponseDto.class),
                ptrVentaClient, ptrProps.get(PtrConstants.VENTA_DIARIA).getEndpoint(), request);
    }
    
   //TODO: VER COMO SE GESTIONA LA RESPONSE EN XML
    @Override
    public PtrVentaTotalizadoXmlResponseDto getVentaTotalizadoXML(@Valid final PtrVentaTotalizadoXmlRequestDto request)
            throws Exception {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(ptrProps.get(PtrConstants.VENTA_TOTALIZADO_XML).getEndpoint(), request,
                        PtrVentaTotalizadoXmlResponseDto.class),
                ptrVentaClient, ptrProps.get(PtrConstants.VENTA_TOTALIZADO_XML).getEndpoint(), request);
    }
    
    @Override
    public PtrVentaTotalizadoByMccResponseDto getVentaTotalizadoByMcc(@Valid final PtrVentaTotalizadoByMccRequestDto request)
            throws Exception {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(ptrProps.get(PtrConstants.VENTA_TOTALIZADO_BY_MCC).getEndpoint(), request,
                        PtrVentaTotalizadoByMccResponseDto.class),
                ptrVentaClient, ptrProps.get(PtrConstants.VENTA_TOTALIZADO_BY_MCC).getEndpoint(), request);
    }
    
    @Override
    public PtrVentaPresupuestadaMensualResponseDto getVentaPresupuestadaMensual(@Valid final PtrVentaPresupuestadaMensualRequestDto request)
            throws Exception {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(ptrProps.get(PtrConstants.VENTA_PRESUPUESTADA_MENSUAL).getEndpoint(), request,
                        PtrVentaPresupuestadaMensualResponseDto.class),
                ptrVentaClient, ptrProps.get(PtrConstants.VENTA_PRESUPUESTADA_MENSUAL).getEndpoint(), request);
    }
    
    
}
