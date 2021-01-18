package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class TareaFaseMapper {

    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaFaseDto tareaFaseToTareaFaseDto(
            TareaFase src);

    @InheritInverseConfiguration
    public abstract TareaFase tareaFaseDtoToTareaFase(
            TareaFaseDto src);

    public abstract List<TareaFaseDto> tareaFaseToTareaFaseDto(
            List<TareaFase> src);

    public abstract List<TareaFase> tareaFaseDtoToTareaFase(
            List<TareaFaseDto> src);

}
