package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCadenaPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;

import javax.validation.Valid;
import java.util.List;

public interface TareaCadenaPresenciaService {

    List<TareaCadenaPresenciaDto> save(@Valid List<PtrPresenciaTotalizadoResultItemDto> dto, @Valid TareaDto tarea);

    void updateActivoCadenaByRunTarea(@Valid TareaDto tarea);
}
