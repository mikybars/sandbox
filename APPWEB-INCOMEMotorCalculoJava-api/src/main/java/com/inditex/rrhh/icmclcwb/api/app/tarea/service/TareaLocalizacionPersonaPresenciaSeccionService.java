package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;

public interface TareaLocalizacionPersonaPresenciaSeccionService {

    void save(@NotNull List<PtrPresenciaDetalleResultItemDto> src, @NotNull TareaDto tareaDto);

}
