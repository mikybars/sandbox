package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresupuestoVenta;

public interface TareaLocalizacionPresupuestoVentaRepositoryCustom {

    List<TareaLocalizacionPresupuestoVenta> save(List<TareaLocalizacionPresupuestoVenta> src);

    void updateActivo(@NotNull RunTareaDto runTareaDto);

}
