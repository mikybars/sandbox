package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoMapper;

public abstract class TrabajoMapperDecorator extends TrabajoMapper {

    @Autowired
    private TrabajoMapper delegate;

    @Override
    public List<TrabajoDto> mergeProgramacionAmbitoDtoAndProgramacionDtoAndPeriodoDtoToTrabajoDto(
            List<ProgramacionAmbitoDto> srcProgramacionAmbito, ProgramacionDto srcProgramacion, PeriodoDto srcPeriodo) {
        List<TrabajoDto> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(srcProgramacionAmbito)) {
            srcProgramacionAmbito.forEach(
                    item -> result.add(delegate.mergeProgramacionAmbitoDtoAndProgramacionDtoAndPeriodoDtoToTrabajoDto(
                            item, srcProgramacion, srcPeriodo)));
        }
        return result;
    }

}
