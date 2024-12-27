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
import org.jspecify.annotations.NonNull;

public interface TareaCalculoPersonaService {

  void mergePersonaCalculoByAmbito(@Valid @NonNull final RunTareaDto runTareaDto);

  List<TareaCalculoPersonaDto> findByTarea(@Valid @NonNull final TareaDto tarea);

  void updateWithEstadoAndidPersona(@Valid @NonNull @NotEmpty final List<IdPersonaLocalDto> personas,
      @Valid @NonNull final RunTareaDto runTareaDto, @Valid @NonNull final EstadoTareaPersonaDto estado);

  void updateWithEstado(@Valid @NonNull final RunTareaDto runTareaDto,
      @Valid @NonNull final EstadoTareaPersonaDto estadoActual,
      @Valid @NonNull final EstadoTareaPersonaDto estadoNuevo);

  void mergePersonaCalculoByAmbitoLocalizacion(@Valid @NonNull final RunTareaDto runTareaDto);

  void mergePersonaCalculoByAmbitoPersona(@Valid @NonNull final RunTareaDto runTareaDto);

  List<IdPersonaLocalDto> findByAlgoritmo(@Valid @NonNull final TareaDto tarea,
      @Valid @NonNull final AlgoritmoDTO idAlgoritmo);

  List<IdPersonaLocalDto> findByTareaAndIdEstadoAndIdTipoPolitica(@Valid @NonNull final TareaDto tarea,
      @Valid @NonNull final String idTipoPolitica);

}
