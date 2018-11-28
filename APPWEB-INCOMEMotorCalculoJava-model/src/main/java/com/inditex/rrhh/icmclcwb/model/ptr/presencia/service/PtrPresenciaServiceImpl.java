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
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.service.PtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResponseDto;

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
    @Qualifier("tiposHorasDto")
    private PtrPropertiesDto presenciasTiposHorasDto;

    @Override
    public PtrPresenciaTotalTiendaSeccionResponseDto getPresenciasTotalTiendaSeccionDto(
            @Valid final PtrPresenciaTotalTiendaSeccionRequestDto getPresenciasTotalTiendaSeccionRequestDto)
            throws Exception {
    	PtrPresenciaTotalTiendaSeccionResponseDto result = null;
        ResponseEntity<PtrPresenciaTotalTiendaSeccionResponseDto> response = ptrPresenciaClient.postForEntity(
                presenciasTotalTiendaSeccionDto.getEndpoint(), getPresenciasTotalTiendaSeccionRequestDto,
                PtrPresenciaTotalTiendaSeccionResponseDto.class);
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
    public PtrPresenciaDetalleResponseDto getPresenciasDetalleDto(
            @Valid final PtrPresenciaDetalleRequestDto getPresenciasDetalleRequestDto) throws Exception {
    	PtrPresenciaDetalleResponseDto result = null;
        ResponseEntity<PtrPresenciaDetalleResponseDto> response = ptrPresenciaClient.postForEntity(
                presenciasDetalleDto.getEndpoint(), getPresenciasDetalleRequestDto,
                PtrPresenciaDetalleResponseDto.class);
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

	@Override
	public PtrPresenciaTiposHorasResponseDto getTiposHorasDto(@Valid PtrPresenciaTiposHorasRequestDto request)
			throws Exception {
		PtrPresenciaTiposHorasResponseDto result = null;
        ResponseEntity<PtrPresenciaTiposHorasResponseDto> response = ptrPresenciaClient.postForEntity(
        		presenciasTiposHorasDto.getEndpoint(), request,
                PtrPresenciaTiposHorasResponseDto.class);
        if (response.getStatusCode().value() == HttpStatus.SC_OK) {
            if (response.getBody() != null) {
                result = response.getBody();
            }
        } else {
            throw new ApplicationException(
                    new StringBuilder("La llamada al PTR de Presencia ha fallado :: getTiposHorasDto() :: ")
                            .append(response.getStatusCode().value()).toString());
        }
        return result;
	}

}
