package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TareaAgrupacionCadena;

import java.util.List;

public interface TareaAgrupacionCadenaRepositoryCustom {
    
    List<TareaAgrupacionCadena> save(@NotNull final List<TareaAgrupacionCadena> agrupaciones);
}
