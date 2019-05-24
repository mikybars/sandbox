package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaEmpleadoSeccionEstructura;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

import java.util.List;

public interface TareaEmpleadoSeccionEstructuraRepositoryCustom {

    List<TareaEmpleadoSeccionEstructura> save(List<TareaEmpleadoSeccionEstructura> src);

}
