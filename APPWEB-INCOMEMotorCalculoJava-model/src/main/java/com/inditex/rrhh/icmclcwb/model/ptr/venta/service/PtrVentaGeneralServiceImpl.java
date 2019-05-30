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
import com.inditex.rrhh.icmclcwb.api.ptr.venta.diaria.dto.PtrVentaDiariaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.diaria.dto.PtrVentaDiariaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.mensual.dto.PtrVentaMensualRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.mensual.dto.PtrVentaMensualResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.presupuestadamensual.dto.PtrVentaPresupuestadaMensualRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.presupuestadamensual.dto.PtrVentaPresupuestadaMensualResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaGeneralService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizadobymcc.dto.PtrVentaTotalizadoByMccRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizadobymcc.dto.PtrVentaTotalizadoByMccResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizadoxml.dto.PtrVentaTotalizadoXmlRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizadoxml.dto.PtrVentaTotalizadoXmlResponseDto;
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

    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrVentaTotalizadoResponseDto ventaTotalizado(@Valid final PtrVentaTotalizadoRequestDto request) {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_TOTALIZADO).getEndpoint(),
                        request, PtrVentaTotalizadoResponseDto.class),
                ptrVentaClient, ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_TOTALIZADO).getEndpoint(), request);
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrVentaMensualResponseDto ventaMensual(@Valid final PtrVentaMensualRequestDto request) {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_MENSUAL).getEndpoint(),
                        request, PtrVentaMensualResponseDto.class),
                ptrVentaClient, ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_MENSUAL).getEndpoint(), request);
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrVentaDiariaResponseDto ventaDiaria(@Valid final PtrVentaDiariaRequestDto request) {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_DIARIA).getEndpoint(),
                        request, PtrVentaDiariaResponseDto.class),
                ptrVentaClient, ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_DIARIA).getEndpoint(), request);
    }

    // TODO Validar como gestiona la respuesta en xml
    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrVentaTotalizadoXmlResponseDto ventaTotalizadoXML(
            @Valid final PtrVentaTotalizadoXmlRequestDto request) {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(
                        ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_TOTALIZADO_XML).getEndpoint(), request,
                        PtrVentaTotalizadoXmlResponseDto.class),
                ptrVentaClient, ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_TOTALIZADO_XML).getEndpoint(), request);
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrVentaTotalizadoByMccResponseDto ventaTotalizadoByMcc(
            @Valid final PtrVentaTotalizadoByMccRequestDto request) {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(
                        ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_TOTALIZADO_BY_MCC).getEndpoint(), request,
                        PtrVentaTotalizadoByMccResponseDto.class),
                ptrVentaClient, ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_TOTALIZADO_BY_MCC).getEndpoint(),
                request);
    }
 
    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public PtrVentaPresupuestadaMensualResponseDto ventaPresupuestadaMensual(
            @Valid final PtrVentaPresupuestadaMensualRequestDto request) {
        return RestUtils.checkResponse(
                ptrVentaClient.postForEntity(
                        ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_PRESUPUESTADA_MENSUAL).getEndpoint(), request,
                        PtrVentaPresupuestadaMensualResponseDto.class),
                ptrVentaClient, ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_PRESUPUESTADA_MENSUAL).getEndpoint(),
                request);
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public String test() {
        return RestUtils.checkResponse(
                ptrVentaClient.getForEntity(ventaGeneralProperties.get(PtrPropertiesConstants.TEST).getEndpoint(),
                        String.class),
                ptrVentaClient, ventaGeneralProperties.get(PtrPropertiesConstants.TEST).getEndpoint(), null);
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    @Override
    public String version() {
        return RestUtils.checkResponse(
                ptrVentaClient.getForEntity(
                        ventaGeneralProperties.get(PtrPropertiesConstants.VERSION).getEndpoint(), String.class),
                ptrVentaClient, ventaGeneralProperties.get(PtrPropertiesConstants.VERSION).getEndpoint(), null);
    }

}
