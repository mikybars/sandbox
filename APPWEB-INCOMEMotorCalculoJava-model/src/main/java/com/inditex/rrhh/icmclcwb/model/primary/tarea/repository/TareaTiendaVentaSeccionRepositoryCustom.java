package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaVentaSeccion;

public interface TareaTiendaVentaSeccionRepositoryCustom {

	void save(@NotNull final TareaDto tareaDto);

    List<TareaTiendaVentaSeccion> save(List<TareaTiendaVentaSeccion> src);

}
