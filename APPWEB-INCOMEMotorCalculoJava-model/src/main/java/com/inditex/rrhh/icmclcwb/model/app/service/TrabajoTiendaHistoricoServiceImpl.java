package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaHistoricoService;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaHistoricoRepository;

@Service
@Validated
public class TrabajoTiendaHistoricoServiceImpl implements TrabajoTiendaHistoricoService {

	@Autowired
	private TrabajoTiendaHistoricoRepository trabajoTiendaHistoricoRepository;

	@Autowired
	private TrabajoTiendaHistoricoMapper trabajoTiendaHistoricoMapper;

	@Override
	public List<TrabajoTiendaHistoricoDto> save(final List<TrabajoTiendaHistoricoDto> trabajoTiendaHistorico,
			@Valid TrabajoDto trabajo) {
		return trabajoTiendaHistoricoMapper.trabajoTiendaHistoricoToTrabajoTiendaHistoricoDto(
				trabajoTiendaHistoricoRepository.save(trabajoTiendaHistoricoMapper
						.mergeTrabajoTiendaHistoricoDtoAndTrabajoDtoToTrabajoTiendaHistorico(trabajoTiendaHistorico,
								trabajo)));
	}
}
