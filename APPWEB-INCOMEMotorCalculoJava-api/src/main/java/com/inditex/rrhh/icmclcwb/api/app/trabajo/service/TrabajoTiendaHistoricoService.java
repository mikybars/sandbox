package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaHistoricoDto;

public interface TrabajoTiendaHistoricoService {

	List<TrabajoTiendaHistoricoDto> save(List<TrabajoTiendaHistoricoDto> trabajoTiendaHistorico,
			@Valid TrabajoDto trabajo);

}
