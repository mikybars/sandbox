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
public class PtrVentaGeneralServiceImpl implements PtrVentaGeneralService {

    @Autowired
    @Qualifier("ptrVentaClient")
    private RestClient ptrVentaClient;
    
    @Autowired
    @Qualifier("ventaGeneralProperties")
    private Map<String, PtrPropertiesDto> ventaGeneralProperties;
    
    @Override
    public PtrVentaTotalizadoResponseDto getVentaTotalizado(@Valid final PtrVentaTotalizadoRequestDto request)
            throws Exception {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(ventaGeneralProperties.get(PtrConstants.VENTA_TOTALIZADO).getEndpoint(), request,
                        PtrVentaTotalizadoResponseDto.class),
                ptrVentaClient, ventaGeneralProperties.get(PtrConstants.VENTA_TOTALIZADO).getEndpoint(), request);
    }
    
    @Override
    public PtrVentaMensualResponseDto getVentaMensual(@Valid final PtrVentaMensualRequestDto request)
            throws Exception {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(ventaGeneralProperties.get(PtrConstants.VENTA_MENSUAL).getEndpoint(), request,
                        PtrVentaMensualResponseDto.class),
                ptrVentaClient, ventaGeneralProperties.get(PtrConstants.VENTA_MENSUAL).getEndpoint(), request);
    }
    
    @Override
    public PtrVentaDiariaResponseDto getVentaDiaria(@Valid final PtrVentaDiariaRequestDto request)
            throws Exception {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(ventaGeneralProperties.get(PtrConstants.VENTA_DIARIA).getEndpoint(), request,
                        PtrVentaDiariaResponseDto.class),
                ptrVentaClient, ventaGeneralProperties.get(PtrConstants.VENTA_DIARIA).getEndpoint(), request);
    }
    
   //TODO: VER COMO SE GESTIONA LA RESPONSE EN XML
    @Override
    public PtrVentaTotalizadoXmlResponseDto getVentaTotalizadoXML(@Valid final PtrVentaTotalizadoXmlRequestDto request)
            throws Exception {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(ventaGeneralProperties.get(PtrConstants.VENTA_TOTALIZADO_XML).getEndpoint(), request,
                        PtrVentaTotalizadoXmlResponseDto.class),
                ptrVentaClient, ventaGeneralProperties.get(PtrConstants.VENTA_TOTALIZADO_XML).getEndpoint(), request);
    }
    
    @Override
    public PtrVentaTotalizadoByMccResponseDto getVentaTotalizadoByMcc(@Valid final PtrVentaTotalizadoByMccRequestDto request)
            throws Exception {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(ventaGeneralProperties.get(PtrConstants.VENTA_TOTALIZADO_BY_MCC).getEndpoint(), request,
                        PtrVentaTotalizadoByMccResponseDto.class),
                ptrVentaClient, ventaGeneralProperties.get(PtrConstants.VENTA_TOTALIZADO_BY_MCC).getEndpoint(), request);
    }
    
    @Override
    public PtrVentaPresupuestadaMensualResponseDto getVentaPresupuestadaMensual(@Valid final PtrVentaPresupuestadaMensualRequestDto request)
            throws Exception {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(ventaGeneralProperties.get(PtrConstants.VENTA_PRESUPUESTADA_MENSUAL).getEndpoint(), request,
                        PtrVentaPresupuestadaMensualResponseDto.class),
                ptrVentaClient, ventaGeneralProperties.get(PtrConstants.VENTA_PRESUPUESTADA_MENSUAL).getEndpoint(), request);
    }
    
    @Override
    public String test()
            throws Exception {
        return RestUtils.checkResponse(
                ptrVentaClient.getForEntity(ventaGeneralProperties.get(PtrConstants.VENTA_GENERAL_TEST).getEndpoint(),
                        String.class),
                ptrVentaClient, ventaGeneralProperties.get(PtrConstants.VENTA_GENERAL_TEST).getEndpoint(), null);
    }
    
    @Override
    public String getVersion()
            throws Exception {
        return RestUtils.checkResponse(
                ptrVentaClient.getForEntity(ventaGeneralProperties.get(PtrConstants.VENTA_GENERAL_VERSION).getEndpoint(),
                        String.class),
                ptrVentaClient, ventaGeneralProperties.get(PtrConstants.VENTA_GENERAL_VERSION).getEndpoint(), null);
    }
    
}
