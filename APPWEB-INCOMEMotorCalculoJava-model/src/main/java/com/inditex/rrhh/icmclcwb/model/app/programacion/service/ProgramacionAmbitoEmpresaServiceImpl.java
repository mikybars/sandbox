package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoEmpresaService;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoEmpresaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionAmbitoEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Service
@Validated
public class ProgramacionAmbitoEmpresaServiceImpl implements ProgramacionAmbitoEmpresaService {

    @Autowired
    private ProgramacionAmbitoEmpresaRepository programacionAmbitoEmpresaRepository;

    @Autowired
    private ProgramacionAmbitoEmpresaMapper programacionAmbitoEmpresaMapper;

    @Override
    public List<ProgramacionAmbitoEmpresaDto> create(
            @Valid @NotNull @NotEmpty final List<ProgramacionAmbitoEmpresaDto> programacionAmbitoEmpresa,
            @NotNull final ProgramacionAmbitoDto programacionAmbito) {
        return programacionAmbitoEmpresaMapper.programacionAmbitoEmpresaToProgramacionAmbitoEmpresaDto(
                programacionAmbitoEmpresaRepository.saveAll(programacionAmbitoEmpresaMapper
                        .mergeProgramacionAmbitoEmpresaDtoAndProgramacionDtoToProgramacionAmbitoEmpresa(
                                programacionAmbitoEmpresa, programacionAmbito)));
    }

}
