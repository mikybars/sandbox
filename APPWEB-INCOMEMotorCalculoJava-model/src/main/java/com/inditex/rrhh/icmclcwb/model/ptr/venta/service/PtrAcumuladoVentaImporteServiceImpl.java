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
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.acumulada.dto.PtrObtenerVentaAcumuladaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.acumulada.dto.PtrObtenerVentaAcumuladaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.acumuladadia.dto.PtrObtenerVentaAcumuladaDiaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.acumuladadia.dto.PtrObtenerVentaAcumuladaDiaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrAcumuladoVentaImporteService;
import com.inditex.rrhh.icmclcwb.model.app.util.RestUtils;

@Service
@Validated
public class PtrAcumuladoVentaImporteServiceImpl implements PtrAcumuladoVentaImporteService {

    @Autowired
    @Qualifier("ptrVentaClient")
    private RestClient ptrVentaClient;
    
    @Autowired
    @Qualifier("acumuladoVentaImporteProperties")
    private Map<String, PtrPropertiesDto> acumuladoVentaImporteProperties;
    
    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrObtenerVentaAcumuladaResponseDto ventaAcumulada(
            @Valid final PtrObtenerVentaAcumuladaRequestDto request) {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(
                        acumuladoVentaImporteProperties.get(PtrPropertiesConstants.VENTA_ACUMULADA).getEndpoint(), request,
                        PtrObtenerVentaAcumuladaResponseDto.class),
                ptrVentaClient, acumuladoVentaImporteProperties.get(PtrPropertiesConstants.VENTA_ACUMULADA).getEndpoint(),
                request);
    }
    
    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrObtenerVentaAcumuladaDiaResponseDto ventaAcumuladaDia(
            @Valid final PtrObtenerVentaAcumuladaDiaRequestDto request) {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(
                        acumuladoVentaImporteProperties.get(PtrPropertiesConstants.VENTA_ACUMULADA_DIA).getEndpoint(), request,
                        PtrObtenerVentaAcumuladaDiaResponseDto.class),
                ptrVentaClient, acumuladoVentaImporteProperties.get(PtrPropertiesConstants.VENTA_ACUMULADA_DIA).getEndpoint(),
                request);
    }
    
    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public String test() {
        return RestUtils.checkResponse(
                ptrVentaClient.getForEntity(acumuladoVentaImporteProperties.get(PtrPropertiesConstants.TEST).getEndpoint(),
                        String.class),
                ptrVentaClient, acumuladoVentaImporteProperties.get(PtrPropertiesConstants.TEST).getEndpoint(), null);
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public String version() {
        return RestUtils.checkResponse(
                ptrVentaClient.getForEntity(
                        acumuladoVentaImporteProperties.get(PtrPropertiesConstants.VERSION).getEndpoint(), String.class),
                ptrVentaClient, acumuladoVentaImporteProperties.get(PtrPropertiesConstants.VERSION).getEndpoint(), null);
    }
}
