package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaEmpleadoPresenciaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.SeccionPresenciasDetalleComisionableType;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaTiendaEmpleadoPresenciaSeccionDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaEmpleadoPresenciaSeccion;


@Mapper
@DecoratedWith(TareaTiendaEmpleadoPresenciaSeccionDecorator.class)
public abstract class TareaTiendaEmpleadoPresenciaSeccionMapper {
    
    public abstract TareaTiendaEmpleadoPresenciaSeccion tareaTiendaEmpleadoPresenciaSeccionDtoToTareaTiendaEmpleadoPresenciaSeccion(
            TareaTiendaEmpleadoPresenciaSeccionDto src);

    public abstract List<TareaTiendaEmpleadoPresenciaSeccion> tareaTiendaEmpleadoPresenciaSeccionDtoToTareaTiendaEmpleadoPresenciaSeccion(
            List<TareaTiendaEmpleadoPresenciaSeccionDto> src);

    public abstract TareaTiendaEmpleadoPresenciaSeccionDto tareaTiendaEmpleadoPresenciaSeccionToTareaTiendaEmpleadoPresenciaSeccionDto(
            TareaTiendaEmpleadoPresenciaSeccion src);

    public abstract List<TareaTiendaEmpleadoPresenciaSeccionDto> tareaTiendaEmpleadoPresenciaSeccionToTareaTiendaEmpleadoPresenciaSeccionDto(
            List<TareaTiendaEmpleadoPresenciaSeccion> src);
    
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "src.tipo", target = "idTipoHora")
    @Mapping(source = "src.persona", target = "idEmpleado")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTiendaEmpleadoPresenciaSeccion presenciasDetalleComisionableResponseDtoToTareaTiendaEmpleadoPresenciaSeccion( 
            PtrPresenciaDetalleComisionableResultItemDto src, TareaDto tareaDto);

    public List<TareaTiendaEmpleadoPresenciaSeccion> presenciasDetalleComisionableResponseDtoToTareaTiendaEmpleadoPresenciaSeccion(
            List<PtrPresenciaDetalleComisionableResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaTiendaEmpleadoPresenciaSeccion tareaTienda, PtrPresenciaDetalleComisionableResultItemDto src){
        for(SeccionPresenciasDetalleComisionableType item : src.getListaSeccion()) {
            if(item.getSeccion().equals(1)){
                tareaTienda.setMinutos1(item.getMinutos());
            }else if(item.getSeccion().equals(2)) {
                tareaTienda.setMinutos2(item.getMinutos());
            }else if(item.getSeccion().equals(3)) {
                tareaTienda.setMinutos3(item.getMinutos());
            }
        }
    }
}
