package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccion;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public abstract class TareaFaseAccionMapper {

    public abstract TareaFaseAccionDto tareaFaseAccionToTareaFaseAccionDto(
            TareaFaseAccion src);

    @InheritInverseConfiguration
    public abstract TareaFaseAccion tareaFaseAccionDtoToTareaFaseAccion(
            TareaFaseAccionDto src);

    public abstract List<TareaFaseAccionDto> tareaFaseAccionToTareaFaseAccionDto(
            List<TareaFaseAccion> src);

    public abstract List<TareaFaseAccion> tareaFaseAccionDtoToTareaFaseAccion(
            List<TareaFaseAccionDto> src);

}
