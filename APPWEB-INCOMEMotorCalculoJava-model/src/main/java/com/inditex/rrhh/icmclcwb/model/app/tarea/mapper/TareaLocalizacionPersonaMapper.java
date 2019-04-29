package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersona;

@Mapper
public abstract class TareaLocalizacionPersonaMapper {

    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaLocalizacionPersonaDto tareaLocalizacionPersonaToTareaLocalizacionPersonaDto(
            TareaLocalizacionPersona src);

    @InheritInverseConfiguration
    public abstract TareaLocalizacionPersona tareaLocalizacionPersonaDtoToTareaLocalizacionPersona(
            TareaLocalizacionPersonaDto src);

    public abstract List<TareaLocalizacionPersonaDto> tareaLocalizacionPersonaToTareaLocalizacionPersonaDto(
            List<TareaLocalizacionPersona> src);

    public abstract List<TareaLocalizacionPersona> tareaLocalizacionPersonaDtoToTareaLocalizacionPersona(
            List<TareaLocalizacionPersonaDto> src);
    
    @Mapping(source = "src.origen", target = "idOrigen")
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    @Mapping(source = "personas", target = "idPersona")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionPersona presenciaEmpleadosTiendaResultItemDtoToTareaLocalizacionPersona( 
            Integer personas, PtrPresenciaEmpleadosTiendaResultItemDto src, TareaDto tareaDto);

    public List<TareaLocalizacionPersona> presenciaEmpleadosTiendaResultItemDtoToTareaLocalizacionPersona(
            List<PtrPresenciaEmpleadosTiendaResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
}
