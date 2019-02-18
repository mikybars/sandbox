package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaSeccionPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaTiendaSeccionPresenciaDecorator;
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

    public List<TareaTiendaSeccionPresencia> presenciasTotalTiendaSeccionResponseDtosDtoToTareaTiendaSeccionPresencias(
            List<PtrPresenciaTotalTiendaSeccionResultItemDto> src, TareaDto tareaDto){
        throw new UnsupportedOperationException("Not implemented");
    }

}
