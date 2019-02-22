package com.inditex.rrhh.icmclcwb.model.app.proceso.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoTiendaEstadoService;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoTiendaEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.ProcesoTiendaEstadoRepositoryCustom;

@Service
@Validated
public class ProcesoTiendaEstadoServiceImpl implements ProcesoTiendaEstadoService {
	
	@Autowired
	private ProcesoTiendaEstadoRepositoryCustom procesoTiendaEstadoRepositoryCustom;

	@Autowired
	private ProcesoTiendaEstadoMapper procesoTiendaEstadoMapper;

	@Override
	public List<ProcesoTiendaEstadoDto> save(final List<ProcesoTiendaEstadoDto> procesoTiendaEstadoDto,
			@Valid ProcesoDto proceso) {
		return procesoTiendaEstadoMapper.procesoTiendaEstadoToProcesoTiendaEstadoDto(procesoTiendaEstadoRepositoryCustom
				.save(procesoTiendaEstadoMapper.mergeProcesoTiendaEstadoDtoAndProcesoDtoToProcesoTiendaEstado(
						procesoTiendaEstadoDto, proceso)));
	}
	
}
