package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionAmbitoPersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Service
@Validated
public class ProgramacionAmbitoPersonaServiceImpl implements ProgramacionAmbitoPersonaService {

    @Autowired
    private ProgramacionAmbitoPersonaRepository programacionAmbitoPersonaRepository;

    @Autowired
    private ProgramacionAmbitoPersonaMapper programacionAmbitoPersonaMapper;

    @Override
    public List<ProgramacionAmbitoPersonaDto> create(
            @Valid @NotNull @NotEmpty final List<ProgramacionAmbitoPersonaDto> programacionAmbitoPersona,
            @NotNull final ProgramacionAmbitoDto programacionAmbito) {
        return programacionAmbitoPersonaMapper.programacionAmbitoPersonaToProgramacionAmbitoPersonaDto(
                programacionAmbitoPersonaRepository.saveAll(programacionAmbitoPersonaMapper
                        .mergeProgramacionAmbitoPersonaDtoAndProgramacionDtoToProgramacionAmbitoPersona(
                                programacionAmbitoPersona, programacionAmbito)));
    }

    @Override
    public List<ProgramacionAmbitoPersonaDto> findByProgramacionAmbito(
            @NotNull final ProgramacionAmbitoDto programacionAmbito) {
        return programacionAmbitoPersonaMapper.programacionAmbitoPersonaToProgramacionAmbitoPersonaDto(
                programacionAmbitoPersonaRepository.findByProgramacionAmbitoId(programacionAmbito.getId()));
    }

}
