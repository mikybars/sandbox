package com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionTiendaDto;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionTiendaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionTienda;

public abstract class ProgramacionTiendaDecorator extends ProgramacionTiendaMapper {

    @Autowired
    private ProgramacionTiendaMapper delegate;

    @Override
    public List<ProgramacionTienda> mergeProgramacionTiendaDtoAndProgramacionDtoToProgramacionTienda(
            List<ProgramacionTiendaDto> srcProgramacionTiendaDto, ProgramacionDto srcProgramacionDto) {
        List<ProgramacionTienda> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(srcProgramacionTiendaDto)) {
            srcProgramacionTiendaDto.forEach(item -> result.add(delegate
                    .mergeProgramacionTiendaDtoAndProgramacionDtoToProgramacionTienda(item, srcProgramacionDto)));
        }
        return result;
    }

}