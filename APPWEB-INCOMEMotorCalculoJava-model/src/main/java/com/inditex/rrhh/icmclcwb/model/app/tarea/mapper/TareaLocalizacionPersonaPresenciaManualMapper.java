package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPersonaPresenciaManualDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionPersonaPresenciaManualDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaPresenciaManual;

@Mapper
@DecoratedWith(TareaLocalizacionPersonaPresenciaManualDecorator.class)
public abstract class TareaLocalizacionPersonaPresenciaManualMapper {

    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaLocalizacionPersonaPresenciaManualDto tareaLocalizacionPersonaPresenciaManualToTareaLocalizacionPersonaPresenciaManualDto(
            TareaLocalizacionPersonaPresenciaManual src);

    @InheritInverseConfiguration
    public abstract TareaLocalizacionPersonaPresenciaManual tareaLocalizacionPersonaPresenciaManualDtoToTareaLocalizacionPersonaPresenciaManual(
            TareaLocalizacionPersonaPresenciaManualDto src);

    public abstract List<TareaLocalizacionPersonaPresenciaManualDto> tareaLocalizacionPersonaPresenciaManualToTareaLocalizacionPersonaPresenciaManualDto(
            List<TareaLocalizacionPersonaPresenciaManual> src);

    public abstract List<TareaLocalizacionPersonaPresenciaManual> tareaLocalizacionPersonaPresenciaManualDtoToTareaLocalizacionPersonaPresenciaManual(
            List<TareaLocalizacionPersonaPresenciaManualDto> src);
    
    @Mapping(source = "src.idOrigen", target = "idOrigen")
    @Mapping(source = "src.idLugarTrabajo", target = "idLocalizacion")
    @Mapping(source = "src.idEmpresa", target = "idEmpresa")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    @Mapping(source = "src.idEmpleadoLocal", target = "idPersona")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionPersonaPresenciaManual genericEmpleadoResultItemDtoToTareaLocalizacionPersonaPresencia( 
            GenericEmpleadoResultItemDto src, TareaDto tareaDto);

    public List<TareaLocalizacionPersonaPresenciaManual> genericEmpleadoResultItemDtoToTareaLocalizacionPersonaPresencia(
            List<GenericEmpleadoResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
}
