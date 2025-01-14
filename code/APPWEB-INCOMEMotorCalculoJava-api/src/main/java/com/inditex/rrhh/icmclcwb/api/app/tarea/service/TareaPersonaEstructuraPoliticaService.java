package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraPoliticaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResultItemDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface TareaPersonaEstructuraPoliticaService {

  List<TareaPersonaEstructuraPoliticaDto> save(
      @Valid @NonNull @NotEmpty final List<ComisionEmpleadoResultItemDto> tareaEmpleadoSeccionEstructuraPolitica,
      @Valid @NonNull final TareaDto tarea);

  List<TareaPersonaEstructuraPoliticaDto> saveEstructurasPolResultItemDto(
      @Valid @NonNull @NotEmpty final List<EstructurasPolResultItemDto> estructurasPolResultItemDto,
      @Valid @NonNull final TareaDto tarea);

  Boolean existePolitica(@Valid @NonNull final TareaDto tarea,
      @Valid @NonNull @NotEmpty final List<TipoPoliticaEnum> politicas);

}
