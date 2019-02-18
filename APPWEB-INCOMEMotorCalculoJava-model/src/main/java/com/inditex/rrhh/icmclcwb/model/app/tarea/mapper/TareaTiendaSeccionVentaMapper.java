package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaSeccionVentaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaTiendaSeccionVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaSeccionVenta;

@Mapper
@DecoratedWith(TareaTiendaSeccionVentaDecorator.class)
public abstract class TareaTiendaSeccionVentaMapper {

    public abstract TareaTiendaSeccionVenta tareaTiendaSeccionVentaDtoToTareaTiendaSeccionVenta(
            TareaTiendaSeccionVentaDto src);

    public abstract List<TareaTiendaSeccionVenta> tareaTiendaSeccionVentasDtoToTareaTiendaSeccionVentas(
            List<TareaTiendaSeccionVentaDto> src);

    public abstract TareaTiendaSeccionVentaDto tareaTiendaSeccionVentaToTareaTiendaSeccionVentaDto(
            TareaTiendaSeccionVenta src);

    public abstract List<TareaTiendaSeccionVentaDto> tareaTiendaSeccionVentasToTareaTiendaSeccionVentasDto(
            List<TareaTiendaSeccionVenta> src);

    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "src.seccion", target = "idSeccion")
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "tarea.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTiendaSeccionVenta getVentaTotalizadoResponseItemDtoToTareaTiendaSeccionVenta(
            PtrVentaTotalizadoResultItemDto src, TareaDto tarea);

    public List<TareaTiendaSeccionVenta> getVentaTotalizadoReponseItemsDtoToTareaTiendaSeccionVentas(
            List<PtrVentaTotalizadoResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
