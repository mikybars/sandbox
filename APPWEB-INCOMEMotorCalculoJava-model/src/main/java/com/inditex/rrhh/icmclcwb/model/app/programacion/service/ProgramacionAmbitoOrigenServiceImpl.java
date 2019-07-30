package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoOrigenService;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoOrigenMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionAmbitoOrigenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Service
@Validated
public class ProgramacionAmbitoOrigenServiceImpl implements ProgramacionAmbitoOrigenService {

    @Autowired
    private ProgramacionAmbitoOrigenRepository programacionAmbitoOrigenRepository;

    @Autowired
    private ProgramacionAmbitoOrigenMapper programacionAmbitoOrigenMapper;

    @Override
    public List<ProgramacionAmbitoOrigenDto> create(
            @Valid @NotNull @NotEmpty final List<ProgramacionAmbitoOrigenDto> programacionAmbitoOrigen,
            @NotNull final ProgramacionAmbitoDto programacionAmbito) {
        return programacionAmbitoOrigenMapper.programacionAmbitoOrigenToProgramacionAmbitoOrigenDto(
                programacionAmbitoOrigenRepository.saveAll(programacionAmbitoOrigenMapper
                        .mergeProgramacionAmbitoOrigenDtoAndProgramacionDtoToProgramacionAmbitoOrigen(
                                programacionAmbitoOrigen, programacionAmbito)));
    }

    @Override
    public List<ProgramacionAmbitoOrigenDto> findByProgramacionAmbito(
            @NotNull final ProgramacionAmbitoDto programacionAmbito) {
        return programacionAmbitoOrigenMapper.programacionAmbitoOrigenToProgramacionAmbitoOrigenDto(
                programacionAmbitoOrigenRepository.findByProgramacionAmbitoId(programacionAmbito.getId()));
    }

}
