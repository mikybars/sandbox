package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoVentaDto;

public interface TareaLocalizacionPresupuestoVentaService {

    List<TareaLocalizacionPresupuestoVentaDto> save(
            @Valid List<TareaLocalizacionPresupuestoVentaDto> tareaLocalizacionPresupuestoVenta);

}
