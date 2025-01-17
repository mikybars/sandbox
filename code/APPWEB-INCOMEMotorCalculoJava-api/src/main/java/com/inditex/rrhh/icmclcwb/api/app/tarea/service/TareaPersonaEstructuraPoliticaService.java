package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraPoliticaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResultItemDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public interface TareaPersonaEstructuraPoliticaService {

  List<TareaPersonaEstructuraPoliticaDto> save(
      @Valid @NotNull @NotEmpty final List<ComisionEmpleadoResultItemDto> tareaEmpleadoSeccionEstructuraPolitica,
      @Valid @NotNull final TareaDto tarea);

  List<TareaPersonaEstructuraPoliticaDto> saveEstructurasPolResultItemDto(
      @Valid @NotNull @NotEmpty final List<EstructurasPolResultItemDto> estructurasPolResultItemDto,
      @Valid @NotNull final TareaDto tarea);

  Boolean existePolitica(@Valid @NotNull final TareaDto tarea,
      @Valid @NotNull @NotEmpty final List<TipoPoliticaEnum> politicas);

}
