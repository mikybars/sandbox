package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCalculoPersona;

public interface TareaCalculoPersonaRepositoryCustom {

    void mergePersonaCalculoByAmbito(@NotNull RunTareaDto tareaDto);

    void updateWithEstadoAndidPersona(List<String> cclIdPerson, RunTareaDto runTareaDto, EstadoTareaPersonaDto estado);

    void updateWithEstado(RunTareaDto runTareaDto, EstadoTareaPersonaDto estadoActual,
            EstadoTareaPersonaDto estadoNuevo);

    void mergePersonaCalculoByAmbitoLocalizacion(@NotNull RunTareaDto tareaDto);

    void mergePersonaCalculoByAmbitoPersona(@NotNull RunTareaDto tareaDto);

    List<TareaCalculoPersona> findByAlgoritmo(@NotNull final TareaDto tarea, @NotBlank final AlgoritmoDto algoritmo);

    List<TareaCalculoPersona> findByTareaAndIdEstadoAndIdTipoPolitica(@NotNull final TareaDto tarea,
            @NotNull @Positive String idTipoPolitica);

}
