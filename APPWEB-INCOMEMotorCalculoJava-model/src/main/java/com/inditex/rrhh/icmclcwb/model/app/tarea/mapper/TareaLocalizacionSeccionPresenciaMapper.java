package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionSeccionPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.PtrSeccionPresenciasGenericType;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionSeccionPresenciaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionSeccionPresencia;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
@DecoratedWith(value= TareaLocalizacionSeccionPresenciaDecorator.class)
public abstract class TareaLocalizacionSeccionPresenciaMapper {

    public abstract TareaLocalizacionSeccionPresencia tareaLocalizacionSeccionPresenciaDtoToTareaLocalizacionSeccionPresencia(
        TareaLocalizacionSeccionPresenciaDto src);

    public abstract List<TareaLocalizacionSeccionPresencia> tareaLocalizacionSeccionPresenciaDtoToTareaLocalizacionSeccionPresencia(
        List<TareaLocalizacionSeccionPresenciaDto> src);

    public abstract TareaLocalizacionSeccionPresenciaDto tareaLocalizacionSeccionPresenciaToTareaLocalizacionSeccionPresenciaDto(
        TareaLocalizacionSeccionPresencia  src);

    public abstract List<TareaLocalizacionSeccionPresenciaDto> tareaLocalizacionSeccionPresenciaToTareaLocalizacionSeccionPresenciaDto(
        List<TareaLocalizacionSeccionPresencia> src);

    public List<TareaLocalizacionSeccionPresencia> presenciasTotalizadoResponseDtoToTareaLocalizacionSeccionPresencia(
        List<PtrPresenciaTotalizadoResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    public List<TareaLocalizacionSeccionPresencia> presenciasTotalizadoResponseDtoToTareaLocalizacionSeccionPresencia(
        List<PtrSeccionPresenciasGenericType> listaSeccion,
        PtrPresenciaTotalizadoResultItemDto presenciaTotalizado, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    @Mapping(target = "idSeccion", ignore = true)
    @Mapping(target = "minutos", ignore = true)
    @Mapping(target = "activo", defaultValue = "true")
    public abstract TareaLocalizacionSeccionPresencia presenciasTotalizadoResponseDtoToTareaLocalizacionSeccionPresencia(
        PtrPresenciaTotalizadoResultItemDto src, TareaDto tareaDto);

    @AfterMapping
    public void presenciasTotalizadoResponseDtoToTareaLocalizacionSeccionPresencia(
        @MappingTarget TareaLocalizacionSeccionPresencia dest, PtrPresenciaTotalizadoResultItemDto src, TareaDto tareaDto) {
        dest.setTipoDato(new TipoDato());
        dest.getTipoDato().setId(TipoDatoEnum.MINUTOS_TOTALES_SECCION.getId());
        dest.setActivo(Boolean.TRUE);
    }

}
