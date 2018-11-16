package com.inditex.rrhh.icmclcwb.model.ptr.presenciasmock.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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

@Service
@Validated
public class PtrPresenciasMockServiceImpl implements PtrPresenciasServiceMock {

	@Autowired
	private Logger LOG;

	@Autowired
	private PtrPresenciasMockRepository presenciasRepository;

	@Autowired
	private PresenciasMapper presenciasMapper;

	@Override
	public List<PresenciasDetalleResponseDto> presenciasDetalle(PresenciasDetalleRequestDto presencias) {
		LOG.info("Inicio PTR FindPresenciasDetalle()");
		List<PresenciaDetalleMock> p = this.presenciasRepository.findPresencias(presencias);
		LOG.info("Fin consulta PTR FindPresenciasDetalle()");
		return this.presenciasMapper.asPresenciaDetalleDTOs(p);
	}

	@Override
	public List<PresenciasDetalleComisionableResponseDto> presenciasDetalleComisionable(
			PresenciasDetalleComisionableRequestDto presencias) {
		return this.presenciasMapper.asPresenciaDetalleComisionableDTOs(this.presenciasRepository
				.findPresencias(presenciasMapper.asPresenciaComisionableToDetalle(presencias)));
	}

	@Override
	public List<PresenciasTotalTiendaResponseDto> presenciasTotalTienda(PresenciasTotalTiendaRequestDto presencias) {
		LOG.info("Inicio PTR FindPresenciasTotalTienda()");
		List<PresenciaTotalTiendaMock> p = this.presenciasRepository.findPresenciasTotalTienda(presencias);
		LOG.info("Fin consulta PTR FindPresenciasTotalTienda()");
		return this.presenciasMapper.asPresenciasTotalTiendaDTOs(p);
	}

	@Override
	public List<PresenciasTotalTiendaSeccionResponseDto> presenciasTotalTiendaSeccion(
			PresenciasTotalTiendaSeccionRequestDto presencias) {
		LOG.info("Inicio PTR FindPresenciasTotalTiendaSeccion()");
		List<PresenciaTotalTiendaSeccionMock> p = this.presenciasRepository
				.findPresenciasTotalTiendaSeccion(presencias);
		LOG.info("Fin consulta PTR FindPresenciasTotalTiendaSeccion()");
		return this.presenciasMapper.asPresenciasTotalTiendaSeccionDTOs(p);
	}

	@Override
	public List<TiposHorasResponseDto> tiposHoras(TiposHorasRequestDto tiposHoras) {
		LOG.info("Inicio PTR FindTiposHoras()");
		List<TiposHorasMock> p = this.presenciasRepository.findTiposHoras(tiposHoras);
		LOG.info("Fin consulta PTR FindTiposHoras()");
		return this.presenciasMapper.asTiposHorasDTOs(p);
	}

}
