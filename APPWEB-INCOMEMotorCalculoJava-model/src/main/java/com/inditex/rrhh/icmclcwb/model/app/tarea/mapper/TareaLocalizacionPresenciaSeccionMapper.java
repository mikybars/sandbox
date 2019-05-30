package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresenciaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.PtrSeccionPresenciasGenericType;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionPresenciaSeccionDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresenciaSeccion;

@Mapper
@DecoratedWith(value= TareaLocalizacionPresenciaSeccionDecorator.class)
public abstract class TareaLocalizacionPresenciaSeccionMapper {

    private static final Integer SECCION_1 = 1;
    private static final Integer SECCION_2 = 2;
    private static final Integer SECCION_3 = 3;
    
    public abstract TareaLocalizacionPresenciaSeccion tareaLocalizacionPresenciaSeccionDtoToTareaLocalizacionPresenciaSeccion(
            TareaLocalizacionPresenciaSeccionDto src);

    public abstract List<TareaLocalizacionPresenciaSeccion> tareaLocalizacionPresenciaSeccionDtoToTareaLocalizacionPresenciaSeccion(
            List<TareaLocalizacionPresenciaSeccionDto> src);

    public abstract TareaLocalizacionPresenciaSeccionDto tareaLocalizacionPresenciaSeccionToTareaLocalizacionPresenciaSeccionDto(
            TareaLocalizacionPresenciaSeccion  src);

    public abstract List<TareaLocalizacionPresenciaSeccionDto> tareaLocalizacionPresenciaSeccionToTareaLocalizacionPresenciaSeccionDto(
            List<TareaLocalizacionPresenciaSeccion> src);
    
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    public abstract TareaLocalizacionPresenciaSeccion presenciasTotalLocalizacionSeccionResponseDtoToTareaLocalizacionPresenciaSeccion(
            PtrPresenciaTotalTiendaSeccionResultItemDto src, TareaDto tareaDto);

    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    public abstract TareaLocalizacionPresenciaSeccion presenciasTotalizadoResponseDtoToTareaLocalizacionPresenciaSeccion(
            PtrPresenciaTotalizadoResultItemDto src, TareaDto tareaDto);
    
    public List<TareaLocalizacionPresenciaSeccion> presenciasTotalLocalizacionSeccionResponseDtoToTareaLocalizacionPresenciaSeccion(
            List<PtrPresenciaTotalTiendaSeccionResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    public List<TareaLocalizacionPresenciaSeccion> presenciasTotalizadoResponseDtoToTareaLocalizacionPresenciaSeccion(
        List<PtrPresenciaTotalizadoResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaLocalizacionPresenciaSeccion tareaLocalizacion, PtrPresenciaTotalTiendaSeccionResultItemDto src){
        for(PtrSeccionPresenciasGenericType item : src.getListaSeccion()) {
            if(item.getSeccion().equals(SECCION_1)){
                tareaLocalizacion.setMinutos1(item.getMinutos());
            }else if(item.getSeccion().equals(SECCION_2)) {
                tareaLocalizacion.setMinutos2(item.getMinutos());
            }else if(item.getSeccion().equals(SECCION_3)) {
                tareaLocalizacion.setMinutos3(item.getMinutos());
            }
        }
        tareaLocalizacion.setTipoDato(new TipoDato());
        tareaLocalizacion.getTipoDato().setId(TipoDatoEnum.MINUTOS_TOTALES_SECCION.getId());
        tareaLocalizacion.setActivo(Boolean.TRUE);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaLocalizacionPresenciaSeccion tareaLocalizacion, PtrPresenciaTotalizadoResultItemDto src){
        for(PtrSeccionPresenciasGenericType item : src.getListaSeccion()) {
            if(item.getSeccion().equals(SECCION_1)){
                tareaLocalizacion.setMinutos1(item.getMinutos());
            }else if(item.getSeccion().equals(SECCION_2)) {
                tareaLocalizacion.setMinutos2(item.getMinutos());
            }else if(item.getSeccion().equals(SECCION_3)) {
                tareaLocalizacion.setMinutos3(item.getMinutos());
            }
        }
        tareaLocalizacion.setTipoDato(new TipoDato());
        tareaLocalizacion.getTipoDato().setId(TipoDatoEnum.MINUTOS_TOTALES_SECCION.getId());
        tareaLocalizacion.setActivo(Boolean.TRUE);
    }
    
}
