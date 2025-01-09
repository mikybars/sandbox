package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResponseDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface TareaAmbitoGlobalLocalizacionPersonaPresenciaService {

  void save(@Valid @NonNull final PtrPresenciaEmpleadosTiendaResponseDto src, @Valid @NonNull TareaDto tareaDto);

}
