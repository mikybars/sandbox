package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaCalculoPersonaService {

    void mergePersonaCalculoByAmbito(RunTareaDto runTareaDto);

    List<TareaCalculoPersonaDto> findByTarea(@Valid @NotNull final TareaDto tarea);

    void updateWithEstadoAndidPersona(List<TareaCalculoPersonaDto> personas, RunTareaDto runTareaDto, final EstadoTareaPersonaDto estado);

    void updateWithEstado(RunTareaDto runTareaDto, final EstadoTareaPersonaDto estadoActual,
            final EstadoTareaPersonaDto estadoNuevo);

    void mergePersonaCalculoByAmbitoLocalizacion(final RunTareaDto runTareaDto);

    void mergePersonaCalculoByAmbitoPersona(final RunTareaDto runTareaDto);

    List<TareaCalculoPersonaDto> findByAlgoritmo(@Valid @NotNull final TareaDto tarea,
            @Valid @NotNull final AlgoritmoDto idAlgoritmo);

    List<TareaCalculoPersonaDto> findByTareaAndIdEstadoAndIdTipoPolitica(@Valid @NotNull final TareaDto tarea,
            @Valid @NotNull final String idTipoPolitica);

}
