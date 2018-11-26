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
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.GetVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.GetVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoResponseDto;

@Service
@Validated
public class PtrVentaServiceImpl implements PtrVentaService {

    @Autowired
    @Qualifier("ptrClientVenta")
    private RestClient ptrClientVenta;

    @Autowired
    @Qualifier("ventaTotalizadoDto")
    private PtrPropertiesDto ventaTotalizadoDto;

    @Autowired
    @Qualifier("ventaIndividualDetalleDto")
    private PtrPropertiesDto ventaIndividualDetalleDto;

    @Override
    public GetVentaTotalizadoResponseDto getVentaTotalizado(
            @Valid final GetVentaTotalizadoRequestDto getVentaTotalizadoRequest) throws Exception {
        GetVentaTotalizadoResponseDto result = null;
        ResponseEntity<GetVentaTotalizadoResponseDto> response = ptrClientVenta.postForEntity(
                ventaTotalizadoDto.getEndpoint(), getVentaTotalizadoRequest, GetVentaTotalizadoResponseDto.class);
        if (response.getStatusCode().value() == HttpStatus.SC_OK) {
            if (response.getBody() != null) {
                result = response.getBody();
            }
        } else {
            throw new ApplicationException("La llamada al PTR de Venta ha fallado :: getVentaTotalizado()");
        }
        return result;
    }

    @Override
    public GetVentaIndividualDetalleResponseDto getVentaIndividualDetalle(
            @Valid final GetVentaIndividualDetalleRequestDto getVentaIndividualDetalleRequestDto) throws Exception {
        GetVentaIndividualDetalleResponseDto result = null;
        ResponseEntity<GetVentaIndividualDetalleResponseDto> response = ptrClientVenta.postForEntity(
                ventaIndividualDetalleDto.getEndpoint(), getVentaIndividualDetalleRequestDto,
                GetVentaIndividualDetalleResponseDto.class);
        if (response.getStatusCode().value() == HttpStatus.SC_OK) {
            if (response.getBody() != null) {
                result = response.getBody();
            }
        } else {
            throw new ApplicationException(
                    "La llamada al PTR de Venta ha fallado :: getVentaIndividualDetalleRequestDto()");
        }
        return result;
    }

}