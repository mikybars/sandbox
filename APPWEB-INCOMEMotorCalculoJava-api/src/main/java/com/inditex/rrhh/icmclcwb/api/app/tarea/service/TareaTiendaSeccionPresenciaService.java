package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaSeccionPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;

import javax.validation.Valid;
import java.util.List;

public interface TareaTiendaSeccionPresenciaService {

    List<TareaTiendaSeccionPresenciaDto> save(@Valid final List<PtrPresenciaTotalizadoResultItemDto> dto,
                                              @Valid final TareaDto tarea);

}
