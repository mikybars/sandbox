package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresupuestoVenta;

import org.jspecify.annotations.NonNull;

public interface TareaLocalizacionPresupuestoVentaRepositoryCustom {

  List<TareaLocalizacionPresupuestoVenta> save(List<TareaLocalizacionPresupuestoVenta> src);

  void updateActivoExcepcionada(@NonNull RunTareaDto runTareaDto);

  void updateActivoCongelada(@NonNull RunTareaDto runTareaDto);

  void totalizar(@NonNull RunTareaDto runTareaDto);

  void updateActivoCongeladaSeccion(@NonNull RunTareaDto runTareaDto);

}
