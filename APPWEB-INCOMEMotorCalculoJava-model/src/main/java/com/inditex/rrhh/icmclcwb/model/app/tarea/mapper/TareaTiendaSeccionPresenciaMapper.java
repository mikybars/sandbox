package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaSeccionPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.PtrSeccionPresenciasGenericType;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaTiendaSeccionPresenciaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaSeccionPresencia;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
@DecoratedWith(value= TareaTiendaSeccionPresenciaDecorator.class)
public abstract class TareaTiendaSeccionPresenciaMapper {

    public abstract TareaTiendaSeccionPresencia tareaTiendaSeccionPresenciaDtoToTareaTiendaSeccionPresencia(
        TareaTiendaSeccionPresenciaDto src);

    public abstract List<TareaTiendaSeccionPresencia> tareaTiendaSeccionPresenciaDtoToTareaTiendaSeccionPresencia(
        List<TareaTiendaSeccionPresenciaDto> src);

    public abstract TareaTiendaSeccionPresenciaDto tareaTiendaSeccionPresenciaToTareaTiendaSeccionPresenciaDto(
        TareaTiendaSeccionPresencia  src);

    public abstract List<TareaTiendaSeccionPresenciaDto> tareaTiendaSeccionPresenciaToTareaTiendaSeccionPresenciaDto(
        List<TareaTiendaSeccionPresencia> src);

    public List<TareaTiendaSeccionPresencia> presenciasTotalizadoResponseDtoToTareaTiendaSeccionPresencia(
        List<PtrPresenciaTotalizadoResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    public List<TareaTiendaSeccionPresencia> presenciasTotalizadoResponseDtoToTareaTiendaSeccionPresencia(
        List<PtrSeccionPresenciasGenericType> listaSeccion,
        PtrPresenciaTotalizadoResultItemDto presenciaTotalizado, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    @Mapping(target = "idSeccion", ignore = true)
    @Mapping(target = "minutos", ignore = true)
    @Mapping(target = "activo", defaultValue = "true")
    public abstract TareaTiendaSeccionPresencia presenciasTotalizadoResponseDtoToTareaTiendaSeccionPresencia(
        PtrPresenciaTotalizadoResultItemDto src, TareaDto tareaDto);

    @AfterMapping
    public void presenciasTotalizadoResponseDtoToTareaTiendaSeccionPresencia(
        @MappingTarget TareaTiendaSeccionPresencia dest, PtrPresenciaTotalizadoResultItemDto src, TareaDto tareaDto) {
        dest.setTipoDato(new TipoDato());
        dest.getTipoDato().setId(TipoDatoEnum.MINUTOS_TOTALES_SECCION.getId());
        dest.setActivo(Boolean.TRUE);
    }

}
