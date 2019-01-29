package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

public interface GTCalculoRepository {
		
	public void calcular(Long idTrabajo);
	
	public void calcularByEmpleadoBatch(Long idTrabajo, List<Long> subGroups);
	
	public void calcularByTiendaBatch(Long idTrabajo, List<Long> idsTiendas);
	
}
