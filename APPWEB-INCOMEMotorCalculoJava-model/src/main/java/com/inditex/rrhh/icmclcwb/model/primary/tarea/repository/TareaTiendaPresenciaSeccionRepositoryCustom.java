package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaPresenciaSeccion;

public interface TareaTiendaPresenciaSeccionRepositoryCustom {

    List<TareaTiendaPresenciaSeccion> save(List<TareaTiendaPresenciaSeccion> src);

    void compensar(@NotNull final RunTareaDto tareaDto);

    void updateActivo(@NotNull final RunTareaDto runTarea);

}
