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
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoLocalizacionPersonaPresenciaManualDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAmbitoLocalizacionPersonaPresenciaManualDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoLocalizacionPersonaPresenciaManual;

@Mapper
@DecoratedWith(TareaAmbitoLocalizacionPersonaPresenciaManualDecorator.class)
public abstract class TareaAmbitoLocalizacionPersonaPresenciaManualMapper {

    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaAmbitoLocalizacionPersonaPresenciaManualDto tareaLocalizacionPersonaPresenciaManualToTareaLocalizacionPersonaPresenciaManualDto(
            TareaAmbitoLocalizacionPersonaPresenciaManual src);

    @InheritInverseConfiguration
    public abstract TareaAmbitoLocalizacionPersonaPresenciaManual tareaLocalizacionPersonaPresenciaManualDtoToTareaLocalizacionPersonaPresenciaManual(
            TareaAmbitoLocalizacionPersonaPresenciaManualDto src);

    public abstract List<TareaAmbitoLocalizacionPersonaPresenciaManualDto> tareaLocalizacionPersonaPresenciaManualToTareaLocalizacionPersonaPresenciaManualDto(
            List<TareaAmbitoLocalizacionPersonaPresenciaManual> src);

    public abstract List<TareaAmbitoLocalizacionPersonaPresenciaManual> tareaLocalizacionPersonaPresenciaManualDtoToTareaLocalizacionPersonaPresenciaManual(
            List<TareaAmbitoLocalizacionPersonaPresenciaManualDto> src);
    
    @Mapping(source = "src.idOrigen", target = "idOrigen")
    @Mapping(source = "src.idLugarTrabajo", target = "idLocalizacion")
    @Mapping(source = "src.idEmpresa", target = "idEmpresa")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    @Mapping(source = "src.idEmpleadoLocal", target = "idPersona")
    @Mapping(target = "id", ignore = true)
    public abstract TareaAmbitoLocalizacionPersonaPresenciaManual genericEmpleadoResultItemDtoToTareaLocalizacionPersonaPresencia( 
            GenericEmpleadoResultItemDto src, TareaDto tareaDto);

    public List<TareaAmbitoLocalizacionPersonaPresenciaManual> genericEmpleadoResultItemDtoToTareaLocalizacionPersonaPresencia(
            List<GenericEmpleadoResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    
}
