package com.inditex.rrhh.icmclcwb.model.secondary.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.esotericsoftware.minlog.Log;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleComisionableRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaSeccionRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.TiposHorasRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleComisionableResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaSeccionResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.TiposHorasResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.service.PTRPresenciasServiceMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaDetalleMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaTotalTiendaMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaTotalTiendaSeccionMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.TiposHorasMock;
import com.inditex.rrhh.icmclcwb.model.secondary.mapper.PresenciasMapper;
import com.inditex.rrhh.icmclcwb.model.secondary.repository.PTRPresenciasRepositoryMock;

import org.slf4j.Logger;
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
	
	
    @Autowired
    private PresenciasMapper presenciasMapper;
    
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

    
	@Override
	public List<PresenciasDetalleResponseDTO> PresenciasDetalle(PresenciasDetalleRequestDTO presencias) {
		Log.info("PTR FindPresenciasDetalle()");
		List<PresenciaDetalleMock> p= this.presenciasRepository.findPresencias(presencias);
		Log.info("Fin consulta PTR FindPresenciasDetalle()");
		return this.presenciasMapper.asPresenciaDetalleDTOs(p);
	}


	@Override
	public List<PresenciasDetalleComisionableResponseDTO> PresenciasDetalleComisionable(PresenciasDetalleComisionableRequestDTO presencias) {
		return null;
	}

	
	@Override
	public List<PresenciasTotalTiendaResponseDTO> PresenciasTotalTienda(PresenciasTotalTiendaRequestDTO presencias) {
		Log.info("PTR FindPresenciasTotalTienda()");
		List<PresenciaTotalTiendaMock> p= this.presenciasRepository.findPresenciasTotalTienda(presencias);
		Log.info("Fin consulta PTR FindPresenciasTotalTienda()");
		return this.presenciasMapper.asPresenciasTotalTiendaDTOs(p);
	}

	
	
	

	@Override
	public List<PresenciasTotalTiendaSeccionResponseDTO> PresenciasTotalTiendaSeccion(
			PresenciasTotalTiendaSeccionRequestDTO presencias) {
		Log.info("PTR FindPresenciasTotalTiendaSeccion()");
		List<PresenciaTotalTiendaSeccionMock> p= this.presenciasRepository.findPresenciasTotalTiendaSeccion(presencias);
		Log.info("Fin consulta PTR FindPresenciasTotalTiendaSeccion()");
		return this.presenciasMapper.asPresenciasTotalTiendaSeccionDTOs(p);
	}

	
	@Override
	public List<TiposHorasResponseDTO> TiposHoras(TiposHorasRequestDTO tiposHoras) {
		Log.info("PTR FindTiposHoras()");
		List<TiposHorasMock> p= this.presenciasRepository.findTiposHoras(tiposHoras);
		Log.info("Fin consulta PTR FindTiposHoras()");
		return this.presenciasMapper.asTiposHorasDTOs(p);
	}

}
