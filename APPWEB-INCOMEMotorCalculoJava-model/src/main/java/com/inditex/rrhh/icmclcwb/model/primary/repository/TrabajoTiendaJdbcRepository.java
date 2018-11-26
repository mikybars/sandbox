package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;

public interface TrabajoTiendaJdbcRepository {

	List<Integer> findByIdTiendaNotExists(@NotNull Set<Integer> ids);

}
