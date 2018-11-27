package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import javax.validation.Valid;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;
import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.app.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.PtrVentaTotalizadoResponseDto;

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
    public PtrVentaTotalizadoResponseDto getVentaTotalizado(
            @Valid final PtrVentaTotalizadoRequestDto getVentaTotalizadoRequest) throws Exception {
        PtrVentaTotalizadoResponseDto result = null;
        ResponseEntity<PtrVentaTotalizadoResponseDto> response = ptrVentaClient.postForEntity(
                ventaTotalizadoDto.getEndpoint(), getVentaTotalizadoRequest, PtrVentaTotalizadoResponseDto.class);
        if (response.getStatusCode().value() == HttpStatus.SC_OK) {
            if (response.getBody() != null) {
                result = response.getBody();
            }
        } else {
            throw new ApplicationException(
                    new StringBuilder("La llamada al PTR de Venta ha fallado :: getVentaTotalizado() :: ")
                            .append(response.getStatusCode().value()).toString());
        }
        return result;
    }

    @Override
    public PtrVentaIndividualDetalleResponseDto getVentaIndividualDetalle(
            @Valid final PtrVentaIndividualDetalleRequestDto getVentaIndividualDetalleRequestDto) throws Exception {
        PtrVentaIndividualDetalleResponseDto result = null;
        ResponseEntity<PtrVentaIndividualDetalleResponseDto> response = ptrVentaClient.postForEntity(
                ventaIndividualDetalleDto.getEndpoint(), getVentaIndividualDetalleRequestDto,
                PtrVentaIndividualDetalleResponseDto.class);
        if (response.getStatusCode().value() == HttpStatus.SC_OK) {
            if (response.getBody() != null) {
                result = response.getBody();
            }
        } else {
            throw new ApplicationException(new StringBuilder(
                    "La llamada al PTR de Venta ha fallado :: getVentaIndividualDetalleRequestDto() :: ")
                            .append(response.getStatusCode().value()).toString());
        }
        return result;
    }

}