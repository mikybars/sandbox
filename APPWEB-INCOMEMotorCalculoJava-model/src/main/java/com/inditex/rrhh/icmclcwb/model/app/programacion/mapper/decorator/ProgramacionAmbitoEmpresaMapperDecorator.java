package com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoEmpresaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoEmpresa;

public abstract class ProgramacionAmbitoEmpresaMapperDecorator extends ProgramacionAmbitoEmpresaMapper {

    @Autowired
    private ProgramacionAmbitoEmpresaMapper delegate;

    @Override
    public List<ProgramacionAmbitoEmpresa> mergeProgramacionAmbitoEmpresaDtoAndProgramacionDtoToProgramacionAmbitoEmpresa(
            List<ProgramacionAmbitoEmpresaDto> srcProgramacionAmbitoEmpresa,
            ProgramacionAmbitoDto srcProgramacionAmbito) {
        List<ProgramacionAmbitoEmpresa> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(srcProgramacionAmbitoEmpresa)) {
            srcProgramacionAmbitoEmpresa.forEach(item -> result
                .add(delegate.mergeProgramacionAmbitoEmpresaDtoAndProgramacionDtoToProgramacionAmbitoEmpresa(item,
                        srcProgramacionAmbito)));
        }
        return result;
    }

}
