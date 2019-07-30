package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoLocalizacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionAmbitoLocalizacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Service
@Validated
public class ProgramacionAmbitoLocalizacionServiceImpl implements ProgramacionAmbitoLocalizacionService {

    @Autowired
    private ProgramacionAmbitoLocalizacionRepository programacionAmbitoLocalizacionRepository;

    @Autowired
    private ProgramacionAmbitoLocalizacionMapper programacionAmbitoLocalizacionMapper;

    @Override
    public List<ProgramacionAmbitoLocalizacionDto> create(
            @Valid @NotNull @NotEmpty final List<ProgramacionAmbitoLocalizacionDto> programacionAmbitoLocalizacion,
            @NotNull final ProgramacionAmbitoDto programacionAmbito) {
        return programacionAmbitoLocalizacionMapper.programacionAmbitoLocalizacionToProgramacionAmbitoLocalizacionDto(
                programacionAmbitoLocalizacionRepository.saveAll(programacionAmbitoLocalizacionMapper
                        .mergeProgramacionAmbitoLocalizacionDtoAndProgramacionDtoToProgramacionAmbitoLocalizacion(
                                programacionAmbitoLocalizacion, programacionAmbito)));
    }

    @Override
    public List<ProgramacionAmbitoLocalizacionDto> findByProgramacionAmbito(
            @NotNull final ProgramacionAmbitoDto programacionAmbito) {
        return programacionAmbitoLocalizacionMapper.programacionAmbitoLocalizacionToProgramacionAmbitoLocalizacionDto(
                programacionAmbitoLocalizacionRepository.findByProgramacionAmbitoId(programacionAmbito.getId()));
    }

}
