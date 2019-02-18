package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaDto;

public interface TareaTiendaService {

    List<TareaTiendaDto> findByTarea(@Valid @NotNull final TareaDto tarea);

    List<TareaTiendaDto> createTareaTienda(@Valid @NotNull final TareaDto tarea,
            @NotNull final List<TareaTiendaDto> tareaTienda);

}
