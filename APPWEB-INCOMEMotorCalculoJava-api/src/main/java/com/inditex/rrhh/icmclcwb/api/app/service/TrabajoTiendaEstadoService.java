package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaEstadoDto;

public interface TrabajoTiendaEstadoService {

	List<TrabajoTiendaEstadoDto> save(List<TrabajoTiendaEstadoDto> trabajoTiendaEstadoDto, @Valid TrabajoDto trabajo);

}
