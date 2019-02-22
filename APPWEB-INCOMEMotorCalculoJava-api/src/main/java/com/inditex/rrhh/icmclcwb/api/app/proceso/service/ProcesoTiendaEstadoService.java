package com.inditex.rrhh.icmclcwb.api.app.proceso.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaEstadoDto;

public interface ProcesoTiendaEstadoService {

	List<ProcesoTiendaEstadoDto> save(List<ProcesoTiendaEstadoDto> procesoTiendaEstadoDto, @Valid ProcesoDto proceso);

}
