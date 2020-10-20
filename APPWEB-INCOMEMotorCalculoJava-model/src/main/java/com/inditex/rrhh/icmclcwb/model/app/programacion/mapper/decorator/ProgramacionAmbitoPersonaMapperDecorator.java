package com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoPersona;

public abstract class ProgramacionAmbitoPersonaMapperDecorator extends ProgramacionAmbitoPersonaMapper {

    @Autowired
    private ProgramacionAmbitoPersonaMapper delegate;

    @Override
    public List<ProgramacionAmbitoPersona> mergeProgramacionAmbitoPersonaDtoAndProgramacionDtoToProgramacionAmbitoPersona(
            List<ProgramacionAmbitoPersonaDto> srcProgramacionAmbitoPersona,
            ProgramacionAmbitoDto srcProgramacionAmbito) {
        List<ProgramacionAmbitoPersona> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(srcProgramacionAmbitoPersona)) {
            srcProgramacionAmbitoPersona.forEach(item -> result
                .add(delegate.mergeProgramacionAmbitoPersonaDtoAndProgramacionDtoToProgramacionAmbitoPersona(item,
                        srcProgramacionAmbito)));
        }
        return result;
    }

}
