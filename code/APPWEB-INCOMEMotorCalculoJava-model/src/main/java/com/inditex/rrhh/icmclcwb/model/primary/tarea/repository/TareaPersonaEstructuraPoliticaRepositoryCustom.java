package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraPolitica;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public interface TareaPersonaEstructuraPoliticaRepositoryCustom {

  List<TareaPersonaEstructuraPolitica> save(List<TareaPersonaEstructuraPolitica> src);

  void updateImporteEstructuraPoliticas(@NotNull TareaDto tarea, @NotNull TrabajoDTO trabajoDto);

  Boolean existePolitica(@NotNull TareaDto tarea,
      @NotNull @NotEmpty List<TipoPoliticaEnum> politicas);

}
