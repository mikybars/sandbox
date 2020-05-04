package com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoLocalizacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoLocalizacion;

public abstract class ProgramacionAmbitoLocalizacionMapperDecorator extends ProgramacionAmbitoLocalizacionMapper {

    @Autowired
    private ProgramacionAmbitoLocalizacionMapper delegate;

    @Override
    public List<ProgramacionAmbitoLocalizacion> mergeProgramacionAmbitoLocalizacionDtoAndProgramacionDtoToProgramacionAmbitoLocalizacion(
            List<ProgramacionAmbitoLocalizacionDto> srcProgramacionAmbitoLocalizacion,
            ProgramacionAmbitoDto srcProgramacionAmbito) {
        List<ProgramacionAmbitoLocalizacion> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(srcProgramacionAmbitoLocalizacion)) {
            srcProgramacionAmbitoLocalizacion.forEach(item -> result
                .add(delegate.mergeProgramacionAmbitoLocalizacionDtoAndProgramacionDtoToProgramacionAmbitoLocalizacion(
                        item,
                        srcProgramacionAmbito)));
        }
        return result;
    }

}
