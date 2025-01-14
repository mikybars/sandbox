package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.GenericAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;

public interface TareaCalculoPersonaRepositoryCustom {

  void mergePersonaCalculoByAmbito(@NonNull RunTareaDto tareaDto);

  void updateWithEstadoAndidPersona(List<String> cclIdPerson, RunTareaDto runTareaDto, EstadoTareaPersonaDto estado);

  void updateWithEstado(RunTareaDto runTareaDto, EstadoTareaPersonaDto estadoActual,
      EstadoTareaPersonaDto estadoNuevo);

  void mergePersonaCalculoByAmbitoLocalizacion(@NonNull RunTareaDto tareaDto);

  void mergePersonaCalculoByAmbitoPersona(@NonNull RunTareaDto tareaDto);

  List<IdPersonaLocalDto> findByAlgoritmo(@NonNull final TareaDto tarea, @NotBlank final AlgoritmoDTO algoritmo);

  List<IdPersonaLocalDto> findByTareaAndIdEstadoAndIdTipoPolitica(@NonNull final TareaDto tarea,
      @NonNull @Positive String idTipoPolitica);

  /**
   * Some javadoc.
   *
   * @param algoritmo Some javadoc.
   * @return Some javadoc.
   */
  List<GenericAlgoritmoPropertiesDto> findIdTipoCalculoAndIdTipoComisionByIdAlgoritmo(
      @NotBlank AlgoritmoDTO algoritmo);

}
