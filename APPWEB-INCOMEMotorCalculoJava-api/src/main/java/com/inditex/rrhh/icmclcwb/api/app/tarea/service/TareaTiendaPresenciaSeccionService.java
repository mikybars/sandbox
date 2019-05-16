package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaPresenciaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;

public interface TareaTiendaPresenciaSeccionService {

    List<TareaTiendaPresenciaSeccionDto> save(@Valid final List<PtrPresenciaTotalizadoResultItemDto> dto,
            @Valid final TareaDto tarea);

    void compensar(@Valid final RunTareaDto runTarea);

}
