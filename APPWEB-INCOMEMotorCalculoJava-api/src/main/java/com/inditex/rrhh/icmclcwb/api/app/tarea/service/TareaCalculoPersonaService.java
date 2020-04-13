package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaCalculoPersonaService {

    void mergePersonaCalculoByAmbito(@Valid @NotNull final RunTareaDto runTareaDto);

    List<TareaCalculoPersonaDto> findByTarea(@Valid @NotNull final TareaDto tarea);

    void updateWithEstadoAndidPersona(@Valid @NotNull @NotEmpty final List<TareaCalculoPersonaDto> personas, @Valid @NotNull final RunTareaDto runTareaDto, @Valid @NotNull final EstadoTareaPersonaDto estado);

    void updateWithEstado(@Valid @NotNull final RunTareaDto runTareaDto, @Valid @NotNull final EstadoTareaPersonaDto estadoActual,
            @Valid @NotNull final EstadoTareaPersonaDto estadoNuevo);

    void mergePersonaCalculoByAmbitoLocalizacion(@Valid @NotNull final RunTareaDto runTareaDto);

    void mergePersonaCalculoByAmbitoPersona(@Valid @NotNull final RunTareaDto runTareaDto);

    List<TareaCalculoPersonaDto> findByAlgoritmo(@Valid @NotNull final TareaDto tarea,
            @Valid @NotNull final AlgoritmoDto idAlgoritmo);

    List<TareaCalculoPersonaDto> findByTareaAndIdEstadoAndIdTipoPolitica(@Valid @NotNull final TareaDto tarea,
            @Valid @NotNull final String idTipoPolitica);

}
