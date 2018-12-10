package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotEmpty;

public interface TrabajoTiendaEstadoRepositoryCustom {

	List<Integer> customFindByIdTiendaNotExists(@NotEmpty Set<Integer> ids);
	
}
