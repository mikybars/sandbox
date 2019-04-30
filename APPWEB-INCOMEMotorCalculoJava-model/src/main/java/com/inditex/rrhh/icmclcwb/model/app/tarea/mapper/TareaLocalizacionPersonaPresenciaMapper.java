package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPersonaPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionPersonaPresenciaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaPresencia;

@Mapper
@DecoratedWith(TareaLocalizacionPersonaPresenciaDecorator.class)
public abstract class TareaLocalizacionPersonaPresenciaMapper {

    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaLocalizacionPersonaPresenciaDto tareaLocalizacionPersonaPresenciaToTareaLocalizacionPersonaPresenciaDto(
            TareaLocalizacionPersonaPresencia src);

    @InheritInverseConfiguration
    public abstract TareaLocalizacionPersonaPresencia tareaLocalizacionPersonaPresenciaDtoToTareaLocalizacionPersonaPresencia(
            TareaLocalizacionPersonaPresenciaDto src);

    public abstract List<TareaLocalizacionPersonaPresenciaDto> tareaLocalizacionPersonaPresenciaToTareaLocalizacionPersonaPresenciaDto(
            List<TareaLocalizacionPersonaPresencia> src);

    public abstract List<TareaLocalizacionPersonaPresencia> tareaLocalizacionPersonaPresenciaDtoToTareaLocalizacionPersonaPresencia(
            List<TareaLocalizacionPersonaPresenciaDto> src);
    
    @Mapping(source = "src.origen", target = "idOrigen")
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "src.empresa", target = "idEmpresa")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    @Mapping(source = "personas", target = "idPersona")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionPersonaPresencia presenciaEmpleadosTiendaResultItemDtoToTareaLocalizacionPersonaPresencia( 
            Integer personas, PtrPresenciaEmpleadosTiendaResultItemDto src, TareaDto tareaDto);

    public List<TareaLocalizacionPersonaPresencia> presenciaEmpleadosTiendaResultItemDtoToTareaLocalizacionPersonaPresencia(
            List<PtrPresenciaEmpleadosTiendaResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
}
