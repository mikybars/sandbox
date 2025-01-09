package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocResultItemDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface TareaLocalizacionPresenciaService {

  void compensar(@Valid @NonNull final RunTareaDto runTareaDto);

  void totalizar(@Valid @NonNull final RunTareaDto runTareaDto);

  void updateActivoVacio(@Valid @NonNull final RunTareaDto runTareaDto);

  void totalizarEcommerce(@Valid @NonNull final RunTareaDto runTareaDto);

  void totalizarEmpleadosPorVenta(@Valid @NonNull final RunTareaDto runTareaDto);

  void save(@Valid @NonNull @NotEmpty final List<PresenciaManualWlocResultItemDto> src,
      @Valid @NonNull final TareaDto tareaDto);

  void compensarLocalizacionManual(@Valid @NonNull final RunTareaDto runTareaDto);

  void repartirPresenciasSindicalesLocalizacion(@Valid @NonNull RunTareaDto runTareaDto);

  void repartirPresenciasSindicalesLocalizacionSeccion(@Valid @NonNull RunTareaDto runTareaDto);

  void totalizarEcommerceSeccion(@Valid @NonNull final RunTareaDto runTarea);

  void totalizarPresenciasSindicalesLocalizacion(@Valid @NonNull final RunTareaDto runTarea);

  void totalizarIncluidoChallengePorcentaje(@Valid @NonNull RunTareaDto runTareaDto);

  void compensarLocalizacionManualIncluidoChallengePorcentaje(@Valid @NonNull RunTareaDto runTareaDto);
}
