package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;

import javax.validation.Valid;
import java.util.List;

public interface TareaAgrupacionPresenciaService {

    void save(@Valid List<PtrPresenciaTotalizadoResultItemDto> dto, @Valid TareaDto tarea,
            List<TareaAgrupacionCadenasDto> agrupaciones);

    void updateActivo(@Valid TareaDto tarea);

}
