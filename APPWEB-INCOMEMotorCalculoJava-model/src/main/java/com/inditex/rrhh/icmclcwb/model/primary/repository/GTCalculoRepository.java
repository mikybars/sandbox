package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaDto;

public interface GTCalculoRepository {
		
	public void calcular(TrabajoDto trabajo);
	
	public void calcularByEmpleadoBatch(List<TrabajoEmpleadoDto> trabajoEmpleados);
	
	public void calcularByTiendaBatch(List<TrabajoTiendaDto> trabajoTiendas);
}
