package com.inditex.rrhh.icmclcwb.model.primary.proceso.repository;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotEmpty;

import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoTiendaEstado;

public interface ProcesoTiendaEstadoRepositoryCustom {

	List<Integer> customFindByIdTiendaNotExists(@NotEmpty Set<Integer> ids);

    List<ProcesoTiendaEstado> save(List<ProcesoTiendaEstado> src);

}
