package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;

public interface TrabajoTiendaEstadoRepositoryCustom {

	List<Integer> customFindByIdTiendaNotExists(@NotNull Set<Integer> ids);
	
}
