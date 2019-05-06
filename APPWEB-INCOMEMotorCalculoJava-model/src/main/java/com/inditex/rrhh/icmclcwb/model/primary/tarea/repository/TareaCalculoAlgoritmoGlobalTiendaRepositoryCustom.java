package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import reactor.core.publisher.Flux;

public interface TareaCalculoAlgoritmoGlobalTiendaRepositoryCustom {

    List<TareaCalculoPersonaDto> ids(final AlgoritmoDto algoritmo, final TareaDto tarea);

    Flux<Void> calcular(final AlgoritmoDto algoritmo, final TareaDto tarea, final List<TareaCalculoPersonaDto> persona);

}
