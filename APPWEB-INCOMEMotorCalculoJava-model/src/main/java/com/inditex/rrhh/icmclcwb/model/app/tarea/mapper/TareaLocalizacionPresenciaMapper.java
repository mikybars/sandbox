package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.PtrSeccionPresenciasGenericType;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionPresenciaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresencia;

@Mapper
@DecoratedWith(value= TareaLocalizacionPresenciaDecorator.class)
public abstract class TareaLocalizacionPresenciaMapper {

    public abstract TareaLocalizacionPresencia tareaLocalizacionPresenciaDtoToTareaLocalizacionPresencia(
        TareaLocalizacionPresenciaDto src);

    public abstract List<TareaLocalizacionPresencia> tareaLocalizacionPresenciaDtoToTareaLocalizacionPresencia(
        List<TareaLocalizacionPresenciaDto> src);

    public abstract TareaLocalizacionPresenciaDto tareaLocalizacionPresenciaToTareaLocalizacionPresenciaDto(
        TareaLocalizacionPresencia  src);

    public abstract List<TareaLocalizacionPresenciaDto> tareaLocalizacionPresenciaToTareaLocalizacionPresenciaDto(
        List<TareaLocalizacionPresencia> src);

    public List<TareaLocalizacionPresencia> presenciasTotalizadoResponseDtoToTareaLocalizacionPresencia(
        List<PtrPresenciaTotalizadoResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    public List<TareaLocalizacionPresencia> presenciasTotalizadoResponseDtoToTareaLocalizacionPresenciaEcommerce(
        List<PtrPresenciaTotalizadoResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    public List<TareaLocalizacionPresencia> presenciasTotalizadoResponseDtoToTareaLocalizacionPresencia(
        List<PtrSeccionPresenciasGenericType> listaSeccion,
        PtrPresenciaTotalizadoResultItemDto presenciaTotalizado, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    @Mapping(source = "src.cadena", target = "idCadena")
    @Mapping(target = "idSeccion", ignore = true)
    @Mapping(target = "minutos", ignore = true)
    @Mapping(target = "activo", defaultValue = "true")
    public abstract TareaLocalizacionPresencia presenciasTotalizadoResponseDtoToTareaLocalizacionPresencia(
        PtrPresenciaTotalizadoResultItemDto src, TareaDto tareaDto);

    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "src.cadena", target = "idCadena")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    @Mapping(source = "src.minutos", target = "minutos")
    @Mapping(target = "idSeccion", ignore = true)
    @Mapping(target = "activo", defaultValue = "true")
    public abstract TareaLocalizacionPresencia presenciasTotalizadoResponseDtoToTareaLocalizacionPresenciaEcommerce(
        PtrPresenciaTotalizadoResultItemDto src, TareaDto tareaDto);

    @AfterMapping
    public void presenciasTotalizadoResponseDtoToTareaLocalizacionPresencia(
        @MappingTarget TareaLocalizacionPresencia dest, PtrPresenciaTotalizadoResultItemDto src, TareaDto tareaDto) {
        dest.setActivo(Boolean.TRUE);
    }

    @AfterMapping
    public void presenciasTotalizadoResponseDtoToTareaLocalizacionPresenciaEcommerce(
        @MappingTarget TareaLocalizacionPresencia dest, PtrPresenciaTotalizadoResultItemDto src, TareaDto tareaDto) {
        presenciasTotalizadoResponseDtoToTareaLocalizacionPresencia(dest, src, tareaDto);
        dest.setTipoDato(new TipoDato());
        dest.getTipoDato().setId(TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_INCLUIDOECOMMERCE.getId());
        dest.setIdSeccion(AppConstants.SECCION_4.toString());
    }

}
