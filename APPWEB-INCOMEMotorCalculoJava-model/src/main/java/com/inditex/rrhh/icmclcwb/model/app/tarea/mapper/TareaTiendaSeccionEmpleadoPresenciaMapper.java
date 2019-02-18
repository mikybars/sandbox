package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaSeccionEmpleadoPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaTiendaSeccionEmpleadoPresenciaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaSeccionEmpleadoPresencia;

@Mapper
@DecoratedWith(TareaTiendaSeccionEmpleadoPresenciaDecorator.class)
public abstract class TareaTiendaSeccionEmpleadoPresenciaMapper {

    public abstract TareaTiendaSeccionEmpleadoPresencia tareaTiendaSeccionEmpleadoPresenciaDtoToTareaTiendaSeccionEmpleadoPresencia(
            TareaTiendaSeccionEmpleadoPresenciaDto src);

    public abstract List<TareaTiendaSeccionEmpleadoPresencia> tareaTiendaSeccionEmpleadoPresenciasDtoToTareaTiendaSeccionEmpleadoPresencias(
            List<TareaTiendaSeccionEmpleadoPresenciaDto> src);

    public abstract TareaTiendaSeccionEmpleadoPresenciaDto tareaTiendaSeccionEmpleadoPresenciaToTareaTiendaSeccionEmpleadoPresenciaDto(
            TareaTiendaSeccionEmpleadoPresencia src);

    public abstract List<TareaTiendaSeccionEmpleadoPresenciaDto> tareaTiendaSeccionEmpleadoPresenciasToTareaTiendaSeccionEmpleadoPresenciasDto(
            List<TareaTiendaSeccionEmpleadoPresencia> src);

    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "src.seccion", target = "idSeccion")
    @Mapping(source = "src.tipo", target = "idTipoHora")
    @Mapping(source = "src.persona", target = "idEmpleado")
    @Mapping(source = "src.minutos", target = "minutos")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTiendaSeccionEmpleadoPresencia presenciasDetalleResponseDtoToTareaTiendaSeccionVenta(
            PtrPresenciaDetalleResultItemDto src, TareaDto tareaDto);

    public List<TareaTiendaSeccionEmpleadoPresencia> presenciasDetalleResponsesDtoToTareaTiendaSeccionVentas(
            List<PtrPresenciaDetalleResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException("Not implemented");
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "src.seccion", target = "idSeccion")
    @Mapping(source = "src.tipo", target = "idTipoHora")
    @Mapping(source = "src.persona", target = "idEmpleado")
    @Mapping(source = "src.minutos", target = "minutos")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTiendaSeccionEmpleadoPresencia presenciasDetalleComisionableResponseDtoToTareaTiendaSeccionVenta(
            PtrPresenciaDetalleComisionableResultItemDto src, TareaDto tareaDto);

    public List<TareaTiendaSeccionEmpleadoPresencia> presenciasDetalleComisionableResponsesDtoToTareaTiendaSeccionVentas(
            List<PtrPresenciaDetalleComisionableResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException("Not implemented");
    }

}
