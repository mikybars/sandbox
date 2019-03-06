package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotEmpty;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaEstado;

public interface TareaTiendaEstadoRepositoryCustom {

	List<Integer> customFindByIdTiendaNotExists(@NotEmpty Set<Integer> ids);

    List<TareaTiendaEstado> save(List<TareaTiendaEstado> src);

}
