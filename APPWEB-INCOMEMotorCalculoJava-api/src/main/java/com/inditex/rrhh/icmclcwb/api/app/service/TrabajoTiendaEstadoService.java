package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaEstadoDto;

public interface TrabajoTiendaEstadoService {

	TrabajoTiendaEstadoDto save(@Valid TrabajoTiendaEstadoDto trabajoTiendaEstadoDto);

	List<TrabajoTiendaEstadoDto> save(@Valid List<TrabajoTiendaEstadoDto> trabajoTiendaEstadoDto);

	List<TrabajoTiendaEstadoDto> save(@Valid List<TrabajoTiendaEstadoDto> trabajoTiendaEstadoDto,
			@Valid TrabajoDto trabajo);

}
