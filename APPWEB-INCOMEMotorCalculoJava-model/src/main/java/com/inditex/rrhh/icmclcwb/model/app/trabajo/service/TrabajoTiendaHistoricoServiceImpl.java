package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoTiendaHistoricoService;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoTiendaHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoTiendaHistoricoRepositoryCustom;

@Service
@Validated
public class TrabajoTiendaHistoricoServiceImpl implements TrabajoTiendaHistoricoService {

	@Autowired
	private TrabajoTiendaHistoricoRepositoryCustom trabajoTiendaHistoricoRepositoryCustom;

	@Autowired
	private TrabajoTiendaHistoricoMapper trabajoTiendaHistoricoMapper;


	@Override
	public List<TrabajoTiendaHistoricoDto> save(final List<TrabajoTiendaHistoricoDto> trabajoTiendaHistorico,
			@Valid TrabajoDto trabajo) {
		return trabajoTiendaHistoricoMapper.trabajoTiendaHistoricoToTrabajoTiendaHistoricoDto(
		        trabajoTiendaHistoricoRepositoryCustom.save(trabajoTiendaHistoricoMapper
						.mergeTrabajoTiendaHistoricoDtoAndTrabajoDtoToTrabajoTiendaHistorico(trabajoTiendaHistorico,
								trabajo)));
	}
}
