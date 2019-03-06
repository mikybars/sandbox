package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaSeccionPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.SeccionPresenciasTotalTiendaSeccionType;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaTiendaSeccionPresenciaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaPresenciaSeccion;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaSeccionPresencia;

@Mapper
@DecoratedWith(value= TareaTiendaSeccionPresenciaDecorator.class)
public abstract class TareaTiendaSeccionPresenciaMapper {

    public abstract TareaTiendaSeccionPresencia tareaTiendaSeccionPresenciaDtoToTareaTiendaSeccionPresencia(
            TareaTiendaSeccionPresenciaDto src);

    public abstract List<TareaTiendaSeccionPresencia> tareaTiendaSeccionPresenciasDtoToTareaTiendaSeccionPresencias(
            List<TareaTiendaSeccionPresenciaDto> src);

    public abstract TareaTiendaSeccionPresenciaDto tareaTiendaSeccionPresenciaToTareaTiendaSeccionPresenciaDto(
            TareaTiendaSeccionPresencia src);

    public abstract List<TareaTiendaSeccionPresenciaDto> tareaTiendaSeccionPresenciasToTareaTiendaSeccionPresenciasDto(
            List<TareaTiendaSeccionPresencia> src);

    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "src.seccion", target = "idSeccion")
    @Mapping(source = "src.minutos", target = "minutos")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    public abstract TareaTiendaSeccionPresencia presenciasTotalTiendaSeccionResponseDtoToTareaTiendaSeccionPresencia(
            PtrPresenciaTotalTiendaSeccionResultItemDto src, TareaDto tareaDto);

    public List<TareaTiendaSeccionPresencia> presenciasTotalTiendaSeccionResponseDtoToTareaTiendaSeccionPresencias(
            List<PtrPresenciaTotalTiendaSeccionResultItemDto> src, TareaDto tareaDto){
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    public abstract TareaTiendaPresenciaSeccion presenciasTotalTiendaSeccionResponseDtoToTareaTiendaPresenciaSeccion(
            PtrPresenciaTotalTiendaSeccionResultItemDto src, TareaDto tareaDto);

    public List<TareaTiendaPresenciaSeccion> presenciasTotalTiendaSeccionResponseDtoToTareaTiendaPresenciaSeccion(
            List<PtrPresenciaTotalTiendaSeccionResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaTiendaPresenciaSeccion tareaTienda, PtrPresenciaTotalTiendaSeccionResultItemDto src){
        for(SeccionPresenciasTotalTiendaSeccionType item : src.getListaSeccion()) {
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
