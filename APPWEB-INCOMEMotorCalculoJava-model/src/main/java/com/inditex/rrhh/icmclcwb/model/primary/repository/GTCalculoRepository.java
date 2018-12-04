package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

public interface GTCalculoRepository {
		
	public void calcular(Long IdTrabajo);
	
	public void calcularByEmpleadoBatch(Long idTrabajo, List<Long> idsEmpleados);
	
	public void calcularByTiendaBatch(Long idTrabajo, List<Long> idsTiendas);
	
	public void calcularByEmpleadoBatchSimpleInsert(Long idTrabajo, List<Long> idsEmpleados);
}
