package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResponseDto;

public interface TareaAmbitoGlobalLocalizacionPersonaPresenciaService {

    void save(@NotNull final PtrPresenciaEmpleadosTiendaResponseDto src, @NotNull TareaDto tareaDto);

}
