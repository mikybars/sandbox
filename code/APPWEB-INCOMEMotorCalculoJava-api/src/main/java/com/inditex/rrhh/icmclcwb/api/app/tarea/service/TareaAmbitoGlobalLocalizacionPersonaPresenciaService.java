package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResponseDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface TareaAmbitoGlobalLocalizacionPersonaPresenciaService {

  void save(@Valid @NotNull final PtrPresenciaEmpleadosTiendaResponseDto src, @Valid @NotNull TareaDto tareaDto);

}
