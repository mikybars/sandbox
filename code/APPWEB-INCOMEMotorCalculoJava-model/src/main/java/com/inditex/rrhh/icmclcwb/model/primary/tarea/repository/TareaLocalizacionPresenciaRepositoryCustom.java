package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresencia;

import org.jspecify.annotations.NonNull;

public interface TareaLocalizacionPresenciaRepositoryCustom {

  List<TareaLocalizacionPresencia> save(List<TareaLocalizacionPresencia> src);

  void compensar(@NonNull RunTareaDto runTareaDto);

  void totalizar(@NonNull RunTareaDto runTareaDto);

  void updateActivoVacio(@NonNull RunTareaDto runTareaDto);

  void totalizarEcommerce(@NonNull RunTareaDto runTareaDto);

  void totalizarEmpleadosPorVenta(@NonNull RunTareaDto runTareaDto);

  void compensarLocalizacionManual(@NonNull RunTareaDto runTareaDto);

  void repartirPresenciasSindicalesLocalizacion(@NonNull RunTareaDto runTareaDto);

  void repartirPresenciasSindicalesLocalizacionSeccion(@NonNull RunTareaDto runTareaDto);

  void totalizarEcommerceSeccion(@NonNull RunTareaDto runTareaDto);

  void totalizarPresenciasSindicalesLocalizacion(@NonNull RunTareaDto runTareaDto);

  void totalizarIncluidoChallengePorcentaje(@NonNull RunTareaDto runTareaDto);

  void compensarLocalizacionManualIncluidoChallengePorcentaje(@NonNull RunTareaDto runTareaDto);
}
