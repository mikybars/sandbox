package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionPresenciaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
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
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    public abstract TareaLocalizacionPresencia presenciasTotalizadoResponseDtoToTareaLocalizacionSeccion(
            PtrPresenciaTotalizadoResultItemDto src, TareaDto tareaDto);
    
    public List<TareaLocalizacionPresencia> presenciasTotalizadoResponseDtoToTareaLocalizacionSeccion(
            List<PtrPresenciaTotalizadoResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaLocalizacionPresencia tareaLocalizacionPresencia, PtrPresenciaTotalizadoResultItemDto src){
        tareaLocalizacionPresencia.setTipoDato(new TipoDato());
        tareaLocalizacionPresencia.getTipoDato().setId(TipoDatoEnum.MINUTOS_TOTALES.getId());
        tareaLocalizacionPresencia.setActivo(Boolean.TRUE);
    }
    
    
}
