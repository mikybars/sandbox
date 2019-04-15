package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoImporteVentaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaAgrupacionCadenaSeccionRepositoryCustom {
    
    void procesar(@NotNull final TareaDto tareaDto, @NotNull TipoImporteVentaEnum tipoImporteOrigen, @NotNull TipoImporteVentaEnum tipoImporteDestino);

}
