package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoEmpresaService;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoEmpresaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionAmbitoEmpresaRepository;

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

    @Override
    public List<ProgramacionAmbitoEmpresaDto> findByProgramacionAmbito(
            @NotNull final ProgramacionAmbitoDto programacionAmbito) {
        return programacionAmbitoEmpresaMapper.programacionAmbitoEmpresaToProgramacionAmbitoEmpresaDto(
                programacionAmbitoEmpresaRepository.findByProgramacionAmbitoId(programacionAmbito.getId()));
    }

}
