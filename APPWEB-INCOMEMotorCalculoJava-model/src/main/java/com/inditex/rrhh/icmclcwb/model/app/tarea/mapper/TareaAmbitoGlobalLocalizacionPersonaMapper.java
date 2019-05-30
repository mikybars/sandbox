package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoGlobalLocalizacionPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalLocalizacionPersona;

@Mapper
public abstract class TareaAmbitoGlobalLocalizacionPersonaMapper {

    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaAmbitoGlobalLocalizacionPersonaDto tareaLocalizacionPersonaToTareaLocalizacionPersonaDto(
            TareaAmbitoGlobalLocalizacionPersona src);

    @InheritInverseConfiguration
    public abstract TareaAmbitoGlobalLocalizacionPersona tareaLocalizacionPersonaDtoToTareaLocalizacionPersona(
            TareaAmbitoGlobalLocalizacionPersonaDto src);

    public abstract List<TareaAmbitoGlobalLocalizacionPersonaDto> tareaLocalizacionPersonaToTareaLocalizacionPersonaDto(
            List<TareaAmbitoGlobalLocalizacionPersona> src);

    public abstract List<TareaAmbitoGlobalLocalizacionPersona> tareaLocalizacionPersonaDtoToTareaLocalizacionPersona(
            List<TareaAmbitoGlobalLocalizacionPersonaDto> src);
    
    @Mapping(source = "src.origen", target = "idOrigen")
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "src.empresa", target = "idEmpresa")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    @Mapping(source = "personas", target = "idPersona")
    @Mapping(target = "id", ignore = true)
    public abstract TareaAmbitoGlobalLocalizacionPersona presenciaEmpleadosTiendaResultItemDtoToTareaLocalizacionPersona( 
            Integer personas, PtrPresenciaEmpleadosTiendaResultItemDto src, TareaDto tareaDto);

    public List<TareaAmbitoGlobalLocalizacionPersona> presenciaEmpleadosTiendaResultItemDtoToTareaLocalizacionPersona(
            List<PtrPresenciaEmpleadosTiendaResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
}
