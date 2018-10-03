package com.inditex.rrhh.icmclcwb.model.secondary.service.ptr;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasDetalleComisionableRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasDetalleRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasTotalTiendaRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasTotalTiendaSeccionRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.TiposHorasRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasDetalleComisionableResponseDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasDetalleResponseDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasTotalTiendaResponseDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasTotalTiendaSeccionResponseDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.TiposHorasResponseDTO;
import com.inditex.rrhh.icmclcwb.api.service.ptr.PTRPresenciasServiceMock;
import com.inditex.rrhh.icmclcwb.model.mapper.ptr.PresenciasMapper;
import com.inditex.rrhh.icmclcwb.model.secondary.repository.ptr.PTRPresenciasRepositoryMock;

/**
 * Implementación del servicio de producto
 */
@Service
@Validated
public class PTRPresenciasServiceImplMock implements PTRPresenciasServiceMock {
	
	@Autowired
    private Logger logger;
    
    @Autowired
    private PTRPresenciasRepositoryMock presenciasRepository;
    
    @Autowired
    private PresenciasMapper presenciasMapper;
    
    //Traduce el objecto, lo envia a la función y la salida la vuelve a traducir
	@Override
	public PresenciasDetalleResponseDTO PresenciasDetalle(PresenciasDetalleRequestDTO presencias) {
		return this.presenciasMapper.asPresenciaDetalleDTO(this.presenciasRepository.findPresencias(this.presenciasMapper.asPresenciaDetalle(presencias)));
	}

	@Override
	public PresenciasDetalleComisionableResponseDTO PresenciasDetalleComisionable(PresenciasDetalleComisionableRequestDTO presencias) {
		return this.presenciasMapper.asPresenciaDetalleComisionableDTO(this.presenciasRepository.findPresenciasComisionable(this.presenciasMapper.asPresenciaDetalleComisionable(presencias)));
	}

	@Override
	public PresenciasTotalTiendaResponseDTO PresenciasTotalTienda(PresenciasTotalTiendaRequestDTO presencias) {
		return this.presenciasMapper.asPresenciasTotalTiendaDTO(this.presenciasRepository.findPresenciasTotalTienda(this.presenciasMapper.asPresenciasTotalTienda(presencias)));
	}

	@Override
	public PresenciasTotalTiendaSeccionResponseDTO PresenciasTotalTiendaSeccion(
			PresenciasTotalTiendaSeccionRequestDTO presencias) {
		return this.presenciasMapper.asPresenciasTotalTiendaSeccionDTO(this.presenciasRepository.findPresenciasTotalTiendaSeccion(this.presenciasMapper.asPresenciasTotalTiendaSeccion(presencias)));
	}

	@Override
	public TiposHorasResponseDTO TiposHoras(TiposHorasRequestDTO tiposHoras) {
		return this.presenciasMapper.asTiposHorasDTO(this.presenciasRepository.findTiposHorass(this.presenciasMapper.asTiposHoras(tiposHoras)));
	}




}
