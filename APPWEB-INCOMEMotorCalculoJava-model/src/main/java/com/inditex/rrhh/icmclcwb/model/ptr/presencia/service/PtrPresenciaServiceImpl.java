package com.inditex.rrhh.icmclcwb.model.ptr.presencia.service;

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
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciasDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.service.PtrPresenciasService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciasTotalTiendaSeccionResponseDto;

@Service
@Validated
public class PtrPresenciaServiceImpl implements PtrPresenciasService {

    @Autowired
    @Qualifier("ptrPresenciaClient")
    private RestClient ptrPresenciaClient;

    @Autowired
    @Qualifier("presenciasTotalTiendaSeccionDto")
    private PtrPropertiesDto presenciasTotalTiendaSeccionDto;

    @Autowired
    @Qualifier("presenciasDetalleDto")
    private PtrPropertiesDto presenciasDetalleDto;

    @Override
    public PtrPresenciasTotalTiendaSeccionResponseDto getPresenciasTotalTiendaSeccionDto(
            @Valid final PtrPresenciasTotalTiendaSeccionRequestDto getPresenciasTotalTiendaSeccionRequestDto)
            throws Exception {
    	PtrPresenciasTotalTiendaSeccionResponseDto result = null;
        ResponseEntity<PtrPresenciasTotalTiendaSeccionResponseDto> response = ptrPresenciaClient.postForEntity(
                presenciasTotalTiendaSeccionDto.getEndpoint(), getPresenciasTotalTiendaSeccionRequestDto,
                PtrPresenciasTotalTiendaSeccionResponseDto.class);
        if (response.getStatusCode().value() == HttpStatus.SC_OK) {
            if (response.getBody() != null) {
                result = response.getBody();
            }
        } else {
            throw new ApplicationException(new StringBuilder(
                    "La llamada al PTR de Presencia ha fallado :: getPresenciasTotalTiendaSeccionDto() :: ")
                            .append(response.getStatusCode().value()).toString());
        }
        return result;
    }

    @Override
    public PtrPresenciasDetalleResponseDto getPresenciasDetalleDto(
            @Valid final PtrPresenciasDetalleRequestDto getPresenciasDetalleRequestDto) throws Exception {
    	PtrPresenciasDetalleResponseDto result = null;
        ResponseEntity<PtrPresenciasDetalleResponseDto> response = ptrPresenciaClient.postForEntity(
                presenciasDetalleDto.getEndpoint(), getPresenciasDetalleRequestDto,
                PtrPresenciasDetalleResponseDto.class);
        if (response.getStatusCode().value() == HttpStatus.SC_OK) {
            if (response.getBody() != null) {
                result = response.getBody();
            }
        } else {
            throw new ApplicationException(
                    new StringBuilder("La llamada al PTR de Presencia ha fallado :: getPresenciasDetalleDto() :: ")
                            .append(response.getStatusCode().value()).toString());
        }
        return result;
    }

}
