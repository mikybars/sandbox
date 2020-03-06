package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;

import javax.validation.Valid;
import java.util.List;

public interface TareaPresupuestoService {

    void save(@Valid final List<PresupuestosWlocResultItemDto> src, @Valid final TareaDto tarea);

}
