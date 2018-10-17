package com.inditex.rrhh.icmclcwb.model.secondary.service.ptr;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaDetalleMock;
import com.inditex.rrhh.icmclcwb.model.secondary.repository.ptr.PTRPresenciasRepositoryJPA;
import com.inditex.rrhh.icmclcwb.model.secondary.repository.ptr.PTRPresenciasRepositoryMock;

/**
 * Implementación del servicio de producto
 */
@Service
@Validated
public class PTRPresenciasServiceImplMock implements PTRPresenciasServiceMock {
	
	@Autowired
    private Logger logger;
    
	
	//REPOSITORIO QUE USA JDBCTEMPLATE
    @Autowired
    private PTRPresenciasRepositoryMock presenciasRepository;
	
	
	//REPOSITORIO JPA
	@Autowired
	PTRPresenciasRepositoryJPA presenciasRepositoryJPA;
	
    @Autowired
    private PresenciasMapper presenciasMapper;
    
    //Traduce el objecto, lo envia a la función y la salida la vuelve a traducir
	@Override
	public PresenciasDetalleResponseDTO PresenciasDetalle(PresenciasDetalleRequestDTO presencias) {
		List<PresenciaDetalleMock> listpresencias =this.presenciasRepositoryJPA.findPresencias();	
		return this.presenciasMapper.asPresenciaDetalleDTO(listpresencias.get(0));
		//return this.presenciasMapper.asPresenciaDetalleDTO(this.presenciasRepository.findPresencias(this.presenciasMapper.asPresenciaDetalle(presencias)));
	}

	@Override
	public PresenciasDetalleComisionableResponseDTO PresenciasDetalleComisionable(PresenciasDetalleComisionableRequestDTO presencias) {
		//return this.presenciasMapper.asPresenciaDetalleComisionableDTO(this.presenciasRepositoryJPA.findPresenciasComisionable(this.presenciasMapper.asPresenciaDetalleComisionable(presencias)));
		return null;
	}

	@Override
	public PresenciasTotalTiendaResponseDTO PresenciasTotalTienda(PresenciasTotalTiendaRequestDTO presencias) {
		//return this.presenciasMapper.asPresenciasTotalTiendaDTO(this.presenciasRepositoryJPA.findPresenciasTotalTienda(this.presenciasMapper.asPresenciasTotalTienda(presencias)));
		return null;
	}

	@Override
	public PresenciasTotalTiendaSeccionResponseDTO PresenciasTotalTiendaSeccion(
			PresenciasTotalTiendaSeccionRequestDTO presencias) {
		//return this.presenciasMapper.asPresenciasTotalTiendaSeccionDTO(this.presenciasRepositoryJPA.findPresenciasTotalTiendaSeccion(this.presenciasMapper.asPresenciasTotalTiendaSeccion(presencias)));
		return null;
	}

	@Override
	public TiposHorasResponseDTO TiposHoras(TiposHorasRequestDTO tiposHoras) {
		//return this.presenciasMapper.asTiposHorasDTO(this.presenciasRepositoryJPA.findTiposHoras(this.presenciasMapper.asTiposHoras(tiposHoras)));
		return null;
	}

}
