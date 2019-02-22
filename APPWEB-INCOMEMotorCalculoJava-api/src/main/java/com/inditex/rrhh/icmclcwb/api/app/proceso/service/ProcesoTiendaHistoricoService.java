package com.inditex.rrhh.icmclcwb.api.app.proceso.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaHistoricoDto;

public interface ProcesoTiendaHistoricoService {

	List<ProcesoTiendaHistoricoDto> save(List<ProcesoTiendaHistoricoDto> procesoTiendaHistorico,
			@Valid ProcesoDto proceso);

}
