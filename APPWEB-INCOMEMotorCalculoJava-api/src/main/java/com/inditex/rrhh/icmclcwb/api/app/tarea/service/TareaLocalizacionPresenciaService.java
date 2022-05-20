package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocResultItemDto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface TareaLocalizacionPresenciaService {

  void compensar(@Valid @NotNull final RunTareaDto runTareaDto);

  void totalizar(@Valid @NotNull final RunTareaDto runTareaDto);

  void updateActivoVacio(@Valid @NotNull final RunTareaDto runTareaDto);

  void totalizarEcommerce(@Valid @NotNull final RunTareaDto runTareaDto);

  void totalizarEmpleadosPorVenta(@Valid @NotNull final RunTareaDto runTareaDto);

  void save(@Valid @NotNull @NotEmpty final List<PresenciaManualWlocResultItemDto> src,
      @Valid @NotNull final TareaDto tareaDto);

  void compensarLocalizacionManual(@Valid @NotNull final RunTareaDto runTareaDto);

  void repartirPresenciasSindicalesLocalizacion(@Valid @NotNull RunTareaDto runTareaDto);

  void repartirPresenciasSindicalesLocalizacionSeccion(@Valid @NotNull RunTareaDto runTareaDto);

  void totalizarEcommerceSeccion(@Valid @NotNull final RunTareaDto runTarea);

  void totalizarPresenciasSindicalesLocalizacion(@Valid @NotNull final RunTareaDto runTarea);

  void totalizarIncluidoChallengePorcentaje(@Valid @NotNull RunTareaDto runTareaDto);

  void compensarLocalizacionManualIncluidoChallengePorcentaje(@Valid @NotNull RunTareaDto runTareaDto);
}
