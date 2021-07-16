package com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbito;

public abstract class ProgramacionAmbitoMapperDecorator extends ProgramacionAmbitoMapper {

    @Autowired
    private ProgramacionAmbitoMapper delegate;

    @Override
    public List<ProgramacionAmbito> mergeProgramacionAmbitoDtoAndProgramacionDtoToProgramacionAmbito(
            List<ProgramacionAmbitoDto> srcProgramacionAmbito, ProgramacionDto srcProgramacion) {
        List<ProgramacionAmbito> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(srcProgramacionAmbito)) {
            srcProgramacionAmbito.forEach(item -> result.add(
                    delegate.mergeProgramacionAmbitoDtoAndProgramacionDtoToProgramacionAmbito(item, srcProgramacion)));
        }
        return result;
    }

}
