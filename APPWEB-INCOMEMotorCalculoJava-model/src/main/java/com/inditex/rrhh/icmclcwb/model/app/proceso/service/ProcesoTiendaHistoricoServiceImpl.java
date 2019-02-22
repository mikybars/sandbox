package com.inditex.rrhh.icmclcwb.model.app.proceso.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoTiendaHistoricoService;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoTiendaHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.ProcesoTiendaHistoricoRepositoryCustom;

@Service
@Validated
public class ProcesoTiendaHistoricoServiceImpl implements ProcesoTiendaHistoricoService {

	@Autowired
	private ProcesoTiendaHistoricoRepositoryCustom procesoTiendaHistoricoRepositoryCustom;

	@Autowired
	private ProcesoTiendaHistoricoMapper procesoTiendaHistoricoMapper;


	@Override
	public List<ProcesoTiendaHistoricoDto> save(final List<ProcesoTiendaHistoricoDto> procesoTiendaHistorico,
			@Valid ProcesoDto proceso) {
		return procesoTiendaHistoricoMapper.procesoTiendaHistoricoToProcesoTiendaHistoricoDto(
		        procesoTiendaHistoricoRepositoryCustom.save(procesoTiendaHistoricoMapper
						.mergeProcesoTiendaHistoricoDtoAndProcesoDtoToProcesoTiendaHistorico(procesoTiendaHistorico,
								proceso)));
	}
}
