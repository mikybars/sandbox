package com.inditex.rrhh.icmclcwb.model.app.run.tarea.mapper;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaPersonaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.mapper.decorator.RunTareaPersonaMapperDecorator;

@Mapper
@DecoratedWith(value = RunTareaPersonaMapperDecorator.class)
public abstract class RunTareaPersonaMapper {

    @NotBlank
    private String idOrigen;

    @NotBlank
    private String idEmpresa;
    
    @NotBlank
    private String idCadena;

    @NotBlank
    private String idPersona;
    
    @NotBlank
    private String orPersona;
    
    @NotBlank
    private String idPersonaLocal;
    
    @Mapping(target = "idOrigen", source = "src.idOrigen")
    @Mapping(target = "idEmpresa", source = "src.idEmpresa")
    @Mapping(target = "idCadena", source = "src.idCadena")
    @Mapping(target = "idPersona", source = "src.idEmpleado")
    @Mapping(target = "orPersona", source = "src.orEmpleado")
    @Mapping(target = "idPersonaLocal", source = "src.idEmpleadoLocal")
    public abstract RunTareaPersonaDto genericEmpleadoResultItemDtoToRunTareaPersonaDto(
            GenericEmpleadoResultItemDto src);

    public abstract List<RunTareaPersonaDto> genericEmpleadoResultItemDtoToRunTareaPersonaDto(
            List<GenericEmpleadoResultItemDto> src);

}
