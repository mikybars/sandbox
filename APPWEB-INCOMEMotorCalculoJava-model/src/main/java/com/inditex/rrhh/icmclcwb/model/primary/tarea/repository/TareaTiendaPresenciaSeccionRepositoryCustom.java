package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaPresenciaSeccion;

public interface TareaTiendaPresenciaSeccionRepositoryCustom {

    @Deprecated
	void save(@NotNull final TareaDto tarea);

    List<TareaTiendaPresenciaSeccion> save(List<TareaTiendaPresenciaSeccion> src);

}
