package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaCalculoAlgoritmoBaseRepositoryCustom {

    List<TareaCalculoPersonaDto> ids(final AlgoritmoDto algoritmo, final TareaDto tarea);

    void calcular(final AlgoritmoDto algoritmo, final TareaDto tarea, final List<TareaCalculoPersonaDto> personas);

    String getSqlCalcular(final AlgoritmoDto algoritmo);

}
