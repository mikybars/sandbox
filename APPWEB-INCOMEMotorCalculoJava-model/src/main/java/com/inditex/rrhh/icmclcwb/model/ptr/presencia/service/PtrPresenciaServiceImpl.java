package com.inditex.rrhh.icmclcwb.model.ptr.presencia.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;
import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.app.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.service.PtrPresenciaService;

@Service
@Validated
public class PtrPresenciaServiceImpl implements PtrPresenciaService {
	
    @Autowired
    @Qualifier("ptrClientPresencia")
    private RestClient ptrClientPresencia;
    
    @Autowired
    @Qualifier("presenciasTotalTiendaSeccionDto")
    private PtrPropertiesDto presenciasTotalTiendaSeccionDto;
    
    @Autowired
    @Qualifier("presenciasDetalleDto")
    private PtrPropertiesDto presenciasDetalleDto;
    
    @Async
    @Override
    public CompletableFuture<PresenciasTotalTiendaSeccionResponseDto> getPresenciasTotalTiendaSeccionDto(
            @Valid final PresenciasTotalTiendaSeccionRequestDto getPresenciasTotalTiendaSeccionRequestDto) throws Exception {
    	PresenciasTotalTiendaSeccionResponseDto result = null;
        ResponseEntity<PresenciasTotalTiendaSeccionResponseDto> response = ptrClientPresencia.postForEntity(
        		presenciasTotalTiendaSeccionDto.getEndpoint(), getPresenciasTotalTiendaSeccionRequestDto, PresenciasTotalTiendaSeccionResponseDto.class);
        if (response.getStatusCode().value() == HttpStatus.SC_OK) {
            if (response.getBody() != null) {
                result = response.getBody();
            }
        } else {
            throw new ApplicationException("La llamada al PTR de Presencia ha fallado :: getPresenciasTotalTiendaSeccionDto()");
        }
        return CompletableFuture.completedFuture(result);
    }

    @Async
    @Override
    public CompletableFuture<PresenciasDetalleResponseDto> getPresenciasDetalleDto(
            @Valid final PresenciasDetalleRequestDto getPresenciasDetalleRequestDto) throws Exception {
    	PresenciasDetalleResponseDto result = null;
        ResponseEntity<PresenciasDetalleResponseDto> response = ptrClientPresencia.postForEntity(
        		presenciasDetalleDto.getEndpoint(), getPresenciasDetalleRequestDto, PresenciasDetalleResponseDto.class);
        if (response.getStatusCode().value() == HttpStatus.SC_OK) {
            if (response.getBody() != null) {
                result = response.getBody();
            }
        } else {
            throw new ApplicationException("La llamada al PTR de Presencia ha fallado :: getPresenciasDetalleDto()");
        }
        return CompletableFuture.completedFuture(result);
    }


}
