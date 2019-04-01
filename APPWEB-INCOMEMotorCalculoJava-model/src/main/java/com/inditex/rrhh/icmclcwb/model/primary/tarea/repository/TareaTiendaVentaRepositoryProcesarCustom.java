package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaTiendaVentaRepositoryProcesarCustom {

    void procesar(@NotNull final TareaDto tareaDto, @NotNull final List<Long> tipoImportes);
    
}