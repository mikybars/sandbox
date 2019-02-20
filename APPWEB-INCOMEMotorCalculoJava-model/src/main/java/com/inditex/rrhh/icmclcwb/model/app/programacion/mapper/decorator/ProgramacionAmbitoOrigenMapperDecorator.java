package com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoOrigenDto;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoOrigenMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoOrigen;

public abstract class ProgramacionAmbitoOrigenMapperDecorator extends ProgramacionAmbitoOrigenMapper {

    @Autowired
    private ProgramacionAmbitoOrigenMapper delegate;

    @Override
    public List<ProgramacionAmbitoOrigen> mergeProgramacionAmbitoOrigenDtoAndProgramacionDtoToProgramacionAmbitoOrigen(
            List<ProgramacionAmbitoOrigenDto> srcProgramacionAmbitoOrigen,
            ProgramacionAmbitoDto srcProgramacionAmbito) {
        List<ProgramacionAmbitoOrigen> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(srcProgramacionAmbitoOrigen)) {
            srcProgramacionAmbitoOrigen.forEach(item -> result
                    .add(delegate.mergeProgramacionAmbitoOrigenDtoAndProgramacionDtoToProgramacionAmbitoOrigen(item,
                            srcProgramacionAmbito)));
        }
        return result;
    }

}
