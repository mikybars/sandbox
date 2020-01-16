package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaCalculoAjusteBaseRepositoryCustom {

    List<TareaCalculoPersonaDto> ids(final TareaDto tarea);

    void postProcesar(final TareaDto tarea, final List<TareaCalculoPersonaDto> personas);
    
    String getSqlPostProcesar();

}
