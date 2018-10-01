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
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasDetalleResonseDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasTotalTiendaResponseDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasTotalTiendaSeccionResponseDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.TiposHorasResponseDTO;
import com.inditex.rrhh.icmclcwb.api.service.ptr.PTRPresenciasService;
import com.inditex.rrhh.icmclcwb.model.mapper.ProductMapper;
import com.inditex.rrhh.icmclcwb.model.mapper.ptr.PresenciasMapper;
import com.inditex.rrhh.icmclcwb.model.repository.ProductRepository;
import com.inditex.rrhh.icmclcwb.model.secondary.repository.ptr.PTRPresenciasRepositoryImplMock;

/**
 * Implementación del servicio de producto
 */
@Service
@Validated
public class PTRPresenciasServiceImpl implements PTRPresenciasService {
	/**
	@Autowired
    private Logger logger;
    
    @Autowired
    private PTRPresenciasRepositoryImplMock presenciasRepository;
    
    @Autowired
    private PresenciasMapper presenciasMapper;
    **/
    
	@Override
	public PresenciasDetalleResonseDTO PresenciasDetalle(PresenciasDetalleRequestDTO presencias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PresenciasDetalleComisionableResponseDTO PresenciasDetalleComisionable(
			PresenciasDetalleComisionableRequestDTO presencias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PresenciasTotalTiendaResponseDTO PresenciasTotalTienda(PresenciasTotalTiendaRequestDTO presencias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PresenciasTotalTiendaSeccionResponseDTO PresenciasTotalTiendaSeccion(
			PresenciasTotalTiendaSeccionRequestDTO presencias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TiposHorasResponseDTO findTiposHoras(TiposHorasRequestDTO tiposHoras) {
		// TODO Auto-generated method stub
		return null;
	}


}
