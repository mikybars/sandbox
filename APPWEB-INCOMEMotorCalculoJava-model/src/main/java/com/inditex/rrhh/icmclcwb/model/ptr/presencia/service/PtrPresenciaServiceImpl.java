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
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.service.PtrPresenciasService;

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
    public PtrPresenciasMockTotalTiendaSeccionResponseDto getPresenciasTotalTiendaSeccionDto(
            @Valid final PtrPresenciasMockTotalTiendaSeccionRequestDto getPresenciasTotalTiendaSeccionRequestDto)
            throws Exception {
        PtrPresenciasMockTotalTiendaSeccionResponseDto result = null;
        ResponseEntity<PtrPresenciasMockTotalTiendaSeccionResponseDto> response = ptrPresenciaClient.postForEntity(
                presenciasTotalTiendaSeccionDto.getEndpoint(), getPresenciasTotalTiendaSeccionRequestDto,
                PtrPresenciasMockTotalTiendaSeccionResponseDto.class);
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
    public PtrPresenciasMockDetalleResponseDto getPresenciasDetalleDto(
            @Valid final PtrPresenciasMockDetalleRequestDto getPresenciasDetalleRequestDto) throws Exception {
        PtrPresenciasMockDetalleResponseDto result = null;
        ResponseEntity<PtrPresenciasMockDetalleResponseDto> response = ptrPresenciaClient.postForEntity(
                presenciasDetalleDto.getEndpoint(), getPresenciasDetalleRequestDto,
                PtrPresenciasMockDetalleResponseDto.class);
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
