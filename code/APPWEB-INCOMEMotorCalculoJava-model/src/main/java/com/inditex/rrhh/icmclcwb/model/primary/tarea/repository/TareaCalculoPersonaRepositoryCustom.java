package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.GenericAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public interface TareaCalculoPersonaRepositoryCustom {

  void mergePersonaCalculoByAmbito(@NotNull RunTareaDto tareaDto);

  void updateWithEstadoAndidPersona(List<String> cclIdPerson, RunTareaDto runTareaDto, EstadoTareaPersonaDto estado);

  void updateWithEstado(RunTareaDto runTareaDto, EstadoTareaPersonaDto estadoActual,
      EstadoTareaPersonaDto estadoNuevo);

  void mergePersonaCalculoByAmbitoLocalizacion(@NotNull RunTareaDto tareaDto);

  void mergePersonaCalculoByAmbitoPersona(@NotNull RunTareaDto tareaDto);

  List<IdPersonaLocalDto> findByAlgoritmo(@NotNull final TareaDto tarea, @NotBlank final AlgoritmoDTO algoritmo);

  List<IdPersonaLocalDto> findByTareaAndIdEstadoAndIdTipoPolitica(@NotNull final TareaDto tarea,
      @NotNull @Positive String idTipoPolitica);

  /**
   * Some javadoc.
   *
   * @param algoritmo Some javadoc.
   * @return Some javadoc.
   */
  List<GenericAlgoritmoPropertiesDto> findIdTipoCalculoAndIdTipoComisionByIdAlgoritmo(
      @NotBlank AlgoritmoDTO algoritmo);

}
