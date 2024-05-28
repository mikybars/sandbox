package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresencia;

import jakarta.validation.constraints.NotNull;

public interface TareaLocalizacionPresenciaRepositoryCustom {

  List<TareaLocalizacionPresencia> save(List<TareaLocalizacionPresencia> src);

  void compensar(@NotNull RunTareaDto runTareaDto);

  void totalizar(@NotNull RunTareaDto runTareaDto);

  void updateActivoVacio(@NotNull RunTareaDto runTareaDto);

  void totalizarEcommerce(@NotNull RunTareaDto runTareaDto);

  void totalizarEmpleadosPorVenta(@NotNull RunTareaDto runTareaDto);

  void compensarLocalizacionManual(@NotNull RunTareaDto runTareaDto);

  void repartirPresenciasSindicalesLocalizacion(@NotNull RunTareaDto runTareaDto);

  void repartirPresenciasSindicalesLocalizacionSeccion(@NotNull RunTareaDto runTareaDto);

  void totalizarEcommerceSeccion(@NotNull RunTareaDto runTareaDto);

  void totalizarPresenciasSindicalesLocalizacion(@NotNull RunTareaDto runTareaDto);

  void totalizarIncluidoChallengePorcentaje(@NotNull RunTareaDto runTareaDto);

  void compensarLocalizacionManualIncluidoChallengePorcentaje(@NotNull RunTareaDto runTareaDto);
}
