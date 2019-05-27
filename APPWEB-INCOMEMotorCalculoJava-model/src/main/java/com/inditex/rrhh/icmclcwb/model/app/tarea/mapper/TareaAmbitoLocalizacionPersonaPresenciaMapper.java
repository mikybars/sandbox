package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoLocalizacionPersonaPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAmbitoLocalizacionPersonaPresenciaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoLocalizacionPersonaPresencia;

@Mapper
@DecoratedWith(TareaAmbitoLocalizacionPersonaPresenciaDecorator.class)
public abstract class TareaAmbitoLocalizacionPersonaPresenciaMapper {

    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaAmbitoLocalizacionPersonaPresenciaDto tareaLocalizacionPersonaPresenciaToTareaLocalizacionPersonaPresenciaDto(
            TareaAmbitoLocalizacionPersonaPresencia src);

    @InheritInverseConfiguration
    public abstract TareaAmbitoLocalizacionPersonaPresencia tareaLocalizacionPersonaPresenciaDtoToTareaLocalizacionPersonaPresencia(
            TareaAmbitoLocalizacionPersonaPresenciaDto src);

    public abstract List<TareaAmbitoLocalizacionPersonaPresenciaDto> tareaLocalizacionPersonaPresenciaToTareaLocalizacionPersonaPresenciaDto(
            List<TareaAmbitoLocalizacionPersonaPresencia> src);

    public abstract List<TareaAmbitoLocalizacionPersonaPresencia> tareaLocalizacionPersonaPresenciaDtoToTareaLocalizacionPersonaPresencia(
            List<TareaAmbitoLocalizacionPersonaPresenciaDto> src);
    
    @Mapping(source = "src.origen", target = "idOrigen")
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "src.empresa", target = "idEmpresa")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    @Mapping(source = "personas", target = "idPersona")
    @Mapping(target = "id", ignore = true)
    public abstract TareaAmbitoLocalizacionPersonaPresencia presenciaEmpleadosTiendaResultItemDtoToTareaLocalizacionPersonaPresencia( 
            Integer personas, PtrPresenciaEmpleadosTiendaResultItemDto src, TareaDto tareaDto);

    public List<TareaAmbitoLocalizacionPersonaPresencia> presenciaEmpleadosTiendaResultItemDtoToTareaLocalizacionPersonaPresencia(
            List<PtrPresenciaEmpleadosTiendaResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
}
