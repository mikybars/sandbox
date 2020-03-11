package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoVentaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresupuestoVenta;

@Mapper
public abstract class TareaLocalizacionPresupuestoVentaMapper {

    public abstract TareaLocalizacionPresupuestoVenta tareaLocalizacionPresupuestoVentaDtoToTareaLocalizacionPresupuestoVenta(
            TareaLocalizacionPresupuestoVentaDto src);

    public abstract List<TareaLocalizacionPresupuestoVenta> tareaLocalizacionPresupuestoVentaDtoToTareaLocalizacionPresupuestoVenta(
            List<TareaLocalizacionPresupuestoVentaDto> src);

    public abstract TareaLocalizacionPresupuestoVentaDto tareaLocalizacionPresupuestoVentaToTareaLocalizacionPresupuestoVentaDto(
            TareaLocalizacionPresupuestoVenta src);

    public abstract List<TareaLocalizacionPresupuestoVentaDto> tareaLocalizacionPresupuestoVentaToTareaLocalizacionPresupuestoVentaDto(
            List<TareaLocalizacionPresupuestoVenta> src);
}
