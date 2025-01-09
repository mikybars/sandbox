package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoPersonaDTO;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionAmbitoPersonaRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ProgramacionAmbitoPersonaServiceImpl implements ProgramacionAmbitoPersonaService {

  @Autowired
  private ProgramacionAmbitoPersonaRepository programacionAmbitoPersonaRepository;

  @Autowired
  private ProgramacionAmbitoPersonaMapper programacionAmbitoPersonaMapper;

  @Override
  public List<ProgramacionAmbitoPersonaDTO> create(
      @Valid @NonNull @NotEmpty final List<ProgramacionAmbitoPersonaDTO> programacionAmbitoPersona,
      @NonNull final ProgramacionAmbitoDTO programacionAmbito) {
    return this.programacionAmbitoPersonaMapper.programacionAmbitoPersonaToProgramacionAmbitoPersonaDto(
        this.programacionAmbitoPersonaRepository.saveAll(this.programacionAmbitoPersonaMapper
            .mergeProgramacionAmbitoPersonaDtoAndProgramacionDtoToProgramacionAmbitoPersona(
                programacionAmbitoPersona, programacionAmbito)));
  }

  @Override
  public List<ProgramacionAmbitoPersonaDTO> findByProgramacionAmbito(
      @NonNull final ProgramacionAmbitoDTO programacionAmbito) {
    return this.programacionAmbitoPersonaMapper.programacionAmbitoPersonaToProgramacionAmbitoPersonaDto(
        this.programacionAmbitoPersonaRepository.findByProgramacionAmbitoId(programacionAmbito.getId()));
  }

}
