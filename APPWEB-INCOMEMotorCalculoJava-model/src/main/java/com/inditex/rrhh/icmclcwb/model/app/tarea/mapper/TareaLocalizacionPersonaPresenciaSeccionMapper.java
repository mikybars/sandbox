package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPersonaPresenciaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.PtrSeccionPresenciasGenericType;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionPersonaPresenciaSeccionDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaPresenciaSeccion;

@Mapper
@DecoratedWith(TareaLocalizacionPersonaPresenciaSeccionDecorator.class)
public abstract class TareaLocalizacionPersonaPresenciaSeccionMapper {

    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaLocalizacionPersonaPresenciaSeccionDto tareaLocalizacionPersonaPresenciaSeccionToTareaLocalizacionPersonaPresenciaSeccionDto(
            TareaLocalizacionPersonaPresenciaSeccion src);

    @InheritInverseConfiguration
    public abstract TareaLocalizacionPersonaPresenciaSeccion tareaLocalizacionPersonaPresenciaSeccionDtoToTareaLocalizacionPersonaPresenciaSeccion(
            TareaLocalizacionPersonaPresenciaSeccionDto src);

    public abstract List<TareaLocalizacionPersonaPresenciaSeccionDto> tareaLocalizacionPersonaPresenciaSeccionToTareaLocalizacionPersonaPresenciaSeccionDto(
            List<TareaLocalizacionPersonaPresenciaSeccion> src);

    public abstract List<TareaLocalizacionPersonaPresenciaSeccion> tareaLocalizacionPersonaPresenciaSeccionDtoToLocalizacionPersonaPresenciaSeccion(
            List<TareaLocalizacionPersonaPresenciaSeccionDto> src);
    
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "src.origen", target = "idOrigen")
    @Mapping(source = "src.persona", target = "idPersona")
    @Mapping(source = "src.empresa", target = "idEmpresa")
    @Mapping(source = "src.fecha", target = "fecha")
    @Mapping(source = "src.tipo", target = "idTipoHora")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionPersonaPresenciaSeccion presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresenciaSeccion( 
            PtrPresenciaDetalleResultItemDto src , TareaDto tareaDto);

    public List<TareaLocalizacionPersonaPresenciaSeccion> presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresenciaSeccion(
            List<PtrPresenciaDetalleResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaLocalizacionPersonaPresenciaSeccion tareaLocalizacionPersonaPresenciaSeccion,
            PtrPresenciaDetalleResultItemDto src) {
            for (PtrSeccionPresenciasGenericType item : src.getListaSeccion()) {
                if (AppConstants.SECCION_1.equals(item.getSeccion())) {
                    tareaLocalizacionPersonaPresenciaSeccion.setMinutos1(item.getMinutos());
                } else if (AppConstants.SECCION_2.equals(item.getSeccion())) {
                    tareaLocalizacionPersonaPresenciaSeccion.setMinutos2(item.getMinutos());
                } else if (AppConstants.SECCION_3.equals(item.getSeccion())) {
                    tareaLocalizacionPersonaPresenciaSeccion.setMinutos3(item.getMinutos());
                }
            }
        tareaLocalizacionPersonaPresenciaSeccion.setActivo(Boolean.TRUE);
        tareaLocalizacionPersonaPresenciaSeccion.setTipoDato(new TipoDato());
        tareaLocalizacionPersonaPresenciaSeccion.getTipoDato().setId(TipoDatoEnum.MINUTOS_INDIVIDUAL_MANUAL.getId());
    }    
    
}
