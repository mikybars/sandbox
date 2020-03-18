package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoVentaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResultItemDto;

public interface TareaLocalizacionPresupuestoVentaService {

    List<TareaLocalizacionPresupuestoVentaDto> save(
            @Valid List<TareaLocalizacionPresupuestoVentaDto> tareaLocalizacionPresupuestoVenta);

    List<TareaLocalizacionPresupuestoVentaDto> save(@Valid List<VentaCongeladaResultItemDto> ventaCongelada,
            TareaDto tarea);

}
