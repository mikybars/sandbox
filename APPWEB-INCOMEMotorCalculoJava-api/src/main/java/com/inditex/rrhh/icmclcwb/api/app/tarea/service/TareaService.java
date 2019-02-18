package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaService {

    TareaDto findTarea(@NotNull @Positive final Long id);
    
    List<TareaDto> findAllTarea();
    
	TareaDto createTarea(@Valid final TareaDto tarea);

	TareaDto modifyTarea(@Valid final TareaDto tarea);

	TareaDto modifyEstadoTarea(@Valid final TareaDto tarea, @Valid final EstadoTareaDto estado);
	
	TareaDto modifyEstadoTareaInicial(@Valid final TareaDto tarea, @Valid final EstadoTareaDto estado);
	
	TareaDto modifyEstadoTareaFinal(@Valid final TareaDto tarea, @Valid final EstadoTareaDto estado);

}