package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaAgrupacionCadenaRepositoryCustom {
    
    void procesar(@NotNull final TareaDto tareaDto, @NotNull TipoDatoEnum tipoImporteOrigen, @NotNull TipoDatoEnum tipoImporteDestino);

}
