package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaHistoricoDto;

public interface TrabajoTiendaHistoricoService {

	List<TrabajoTiendaHistoricoDto> save(List<TrabajoTiendaHistoricoDto> trabajoTiendaHistorico,
			@Valid TrabajoDto trabajo) throws Exception;

}
