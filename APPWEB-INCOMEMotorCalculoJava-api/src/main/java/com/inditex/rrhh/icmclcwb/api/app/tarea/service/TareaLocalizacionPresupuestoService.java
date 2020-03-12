package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;

import javax.validation.Valid;
import java.util.List;

public interface TareaLocalizacionPresupuestoService {

    void save(@Valid final List<PresupuestosWlocResultItemDto> src, @Valid final TareaDto tarea);

    List<TareaLocalizacionPresupuestoDto> findPresupuestos(@Valid final TareaDto tarea);

}
