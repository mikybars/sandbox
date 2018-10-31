package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResultItemDto;

public interface TrabajoEmpleadoService {

	TrabajoEmpleadoDto save(@Valid TrabajoEmpleadoDto trabajo);

	CompletableFuture<Void> save(@Valid List<EmpleadosTiendaResultItemDto> result, TrabajoDto trabajoDto);

}
