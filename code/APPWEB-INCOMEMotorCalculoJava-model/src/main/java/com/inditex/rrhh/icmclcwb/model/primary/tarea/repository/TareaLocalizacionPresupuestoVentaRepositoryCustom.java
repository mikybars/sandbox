package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresupuestoVenta;

import javax.validation.constraints.NotNull;

public interface TareaLocalizacionPresupuestoVentaRepositoryCustom {

  List<TareaLocalizacionPresupuestoVenta> save(List<TareaLocalizacionPresupuestoVenta> src);

  void updateActivoExcepcionada(@NotNull RunTareaDto runTareaDto);

  void updateActivoCongelada(@NotNull RunTareaDto runTareaDto);

  void totalizar(@NotNull RunTareaDto runTareaDto);

  void updateActivoCongeladaSeccion(@NotNull RunTareaDto runTareaDto);

}
