package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaPresenciaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResultItemDto;

public interface TareaTiendaPresenciaSeccionService {

    @Deprecated
    void pivot(@Valid final TareaDto tarea);

    List<TareaTiendaPresenciaSeccionDto> save(@Valid final List<PtrPresenciaTotalTiendaSeccionResultItemDto> dto, @Valid final TareaDto tarea);

}
