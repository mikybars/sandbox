package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresupuesto;

import java.util.List;

public interface TareaLocalizacionPresupuestoRepositoryCustom {

    List<TareaLocalizacionPresupuesto> save(final List<TareaLocalizacionPresupuesto> src);

    List<TareaLocalizacionPresupuestoDto> findPresupuestos(TareaDto tarea);

    void updateActivoBandaExcepcion(TareaDto tarea);

    void updateActivoBandasSinExcepcion(TareaDto tarea);

}
