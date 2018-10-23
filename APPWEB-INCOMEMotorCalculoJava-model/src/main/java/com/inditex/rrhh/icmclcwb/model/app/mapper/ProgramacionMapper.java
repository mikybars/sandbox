package com.inditex.rrhh.icmclcwb.model.app.mapper;

import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Programacion;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface ProgramacionMapper {

    ProgramacionDto programacionToProgracionDto(Programacion src);

    Programacion programacionDtoToProgramacion(ProgramacionDto src);

    List<ProgramacionDto> programacionToProgramacionDto(List<Programacion> src);
}
