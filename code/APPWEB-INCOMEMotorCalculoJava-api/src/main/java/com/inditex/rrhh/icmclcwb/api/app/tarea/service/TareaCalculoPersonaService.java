package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public interface TareaCalculoPersonaService {

  void mergePersonaCalculoByAmbito(@Valid @NotNull final RunTareaDto runTareaDto);

  List<TareaCalculoPersonaDto> findByTarea(@Valid @NotNull final TareaDto tarea);

  void updateWithEstadoAndidPersona(@Valid @NotNull @NotEmpty final List<IdPersonaLocalDto> personas,
      @Valid @NotNull final RunTareaDto runTareaDto, @Valid @NotNull final EstadoTareaPersonaDto estado);

  void updateWithEstado(@Valid @NotNull final RunTareaDto runTareaDto,
      @Valid @NotNull final EstadoTareaPersonaDto estadoActual,
      @Valid @NotNull final EstadoTareaPersonaDto estadoNuevo);

  void mergePersonaCalculoByAmbitoLocalizacion(@Valid @NotNull final RunTareaDto runTareaDto);

  void mergePersonaCalculoByAmbitoPersona(@Valid @NotNull final RunTareaDto runTareaDto);

  List<IdPersonaLocalDto> findByAlgoritmo(@Valid @NotNull final TareaDto tarea,
      @Valid @NotNull final AlgoritmoDTO idAlgoritmo);

  List<IdPersonaLocalDto> findByTareaAndIdEstadoAndIdTipoPolitica(@Valid @NotNull final TareaDto tarea,
      @Valid @NotNull final String idTipoPolitica);

}
