package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaEstadoDto;

public interface TrabajoTiendaEstadoService {

	List<TrabajoTiendaEstadoDto> save(List<TrabajoTiendaEstadoDto> trabajoTiendaEstadoDto, @Valid TrabajoDto trabajo);

}
