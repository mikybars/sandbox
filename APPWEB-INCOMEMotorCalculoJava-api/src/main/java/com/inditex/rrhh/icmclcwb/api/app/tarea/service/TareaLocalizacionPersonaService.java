package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResponseDto;

public interface TareaLocalizacionPersonaService {

    void save(@NotNull PtrPresenciaEmpleadosTiendaResponseDto src, @NotNull TareaDto tareaDto);

    void mergePersonaLocalizacion(@NotNull RunTareaDto runTareaDto);

}
