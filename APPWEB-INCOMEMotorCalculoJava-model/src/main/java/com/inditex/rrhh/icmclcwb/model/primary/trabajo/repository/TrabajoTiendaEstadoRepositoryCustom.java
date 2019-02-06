package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotEmpty;

import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoTiendaEstado;

public interface TrabajoTiendaEstadoRepositoryCustom {

	List<Integer> customFindByIdTiendaNotExists(@NotEmpty Set<Integer> ids);

    List<TrabajoTiendaEstado> save(List<TrabajoTiendaEstado> src) throws Exception;

}
