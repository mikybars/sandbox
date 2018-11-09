package com.inditex.rrhh.icmclcwb.model.ptr.presenciasmock.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.esotericsoftware.minlog.Log;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.TiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleComisionableResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.TiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.service.PtrPresenciasServiceMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaDetalleMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaTotalTiendaMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaTotalTiendaSeccionMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.TiposHorasMock;
import com.inditex.rrhh.icmclcwb.model.secondary.mapper.PresenciasMapper;
import com.inditex.rrhh.icmclcwb.model.secondary.repository.PtrPresenciasMockRepository;

import org.slf4j.Logger;
/**
 * Implementación del servicio de producto
 */
@Service
@Validated
public class PtrPresenciasMockServiceImpl implements PtrPresenciasServiceMock {
	
	@Autowired
    private Logger logger;
    
	
	//REPOSITORIO QUE USA JDBCTEMPLATE
    @Autowired
    private PtrPresenciasMockRepository presenciasRepository;
	
	
    @Autowired
    private PresenciasMapper presenciasMapper;
    
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");

    
	@Override
	public List<PresenciasDetalleResponseDto> PresenciasDetalle(PresenciasDetalleRequestDto presencias) {
		Log.info("PTR FindPresenciasDetalle()");
		List<PresenciaDetalleMock> p= this.presenciasRepository.findPresencias(presencias);
		Log.info("Fin consulta PTR FindPresenciasDetalle()");
		return this.presenciasMapper.asPresenciaDetalleDTOs(p);
	}


	@Override
	public List<PresenciasDetalleComisionableResponseDto> PresenciasDetalleComisionable(PresenciasDetalleComisionableRequestDto presencias) {
		return null;
	}

	
	@Override
	public List<PresenciasTotalTiendaResponseDto> PresenciasTotalTienda(PresenciasTotalTiendaRequestDto presencias) {
		Log.info("PTR FindPresenciasTotalTienda()");
		List<PresenciaTotalTiendaMock> p= this.presenciasRepository.findPresenciasTotalTienda(presencias);
		Log.info("Fin consulta PTR FindPresenciasTotalTienda()");
		return this.presenciasMapper.asPresenciasTotalTiendaDTOs(p);
	}

	
	
	

	@Override
	public List<PresenciasTotalTiendaSeccionResponseDto> PresenciasTotalTiendaSeccion(
			PresenciasTotalTiendaSeccionRequestDto presencias) {
		Log.info("PTR FindPresenciasTotalTiendaSeccion()");
		List<PresenciaTotalTiendaSeccionMock> p= this.presenciasRepository.findPresenciasTotalTiendaSeccion(presencias);
		Log.info("Fin consulta PTR FindPresenciasTotalTiendaSeccion()");
		return this.presenciasMapper.asPresenciasTotalTiendaSeccionDTOs(p);
	}

	
	@Override
	public List<TiposHorasResponseDto> TiposHoras(TiposHorasRequestDto tiposHoras) {
		Log.info("PTR FindTiposHoras()");
		List<TiposHorasMock> p= this.presenciasRepository.findTiposHoras(tiposHoras);
		Log.info("Fin consulta PTR FindTiposHoras()");
		return this.presenciasMapper.asTiposHorasDTOs(p);
	}

}
