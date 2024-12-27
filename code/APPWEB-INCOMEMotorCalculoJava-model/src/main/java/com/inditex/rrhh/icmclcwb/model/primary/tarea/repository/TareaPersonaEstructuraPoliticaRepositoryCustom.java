package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraPolitica;

import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface TareaPersonaEstructuraPoliticaRepositoryCustom {

  List<TareaPersonaEstructuraPolitica> save(List<TareaPersonaEstructuraPolitica> src);

  void updateImporteEstructuraPoliticas(@NonNull TareaDto tarea, @NonNull TrabajoDTO trabajoDto);

  Boolean existePolitica(@NonNull TareaDto tarea,
      @NonNull @NotEmpty List<TipoPoliticaEnum> politicas);

}
