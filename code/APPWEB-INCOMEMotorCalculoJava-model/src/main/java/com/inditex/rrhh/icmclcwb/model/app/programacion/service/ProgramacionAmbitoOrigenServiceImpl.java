package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoOrigenService;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoOrigenDTO;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoOrigenMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionAmbitoOrigenRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ProgramacionAmbitoOrigenServiceImpl implements ProgramacionAmbitoOrigenService {

  @Autowired
  private ProgramacionAmbitoOrigenRepository programacionAmbitoOrigenRepository;

  @Autowired
  private ProgramacionAmbitoOrigenMapper programacionAmbitoOrigenMapper;

  @Override
  public List<ProgramacionAmbitoOrigenDTO> create(
      @Valid @NonNull @NotEmpty final List<ProgramacionAmbitoOrigenDTO> programacionAmbitoOrigen,
      @NonNull final ProgramacionAmbitoDTO programacionAmbito) {
    return this.programacionAmbitoOrigenMapper.programacionAmbitoOrigenToProgramacionAmbitoOrigenDto(
        this.programacionAmbitoOrigenRepository.saveAll(this.programacionAmbitoOrigenMapper
            .mergeProgramacionAmbitoOrigenDtoAndProgramacionDtoToProgramacionAmbitoOrigen(
                programacionAmbitoOrigen, programacionAmbito)));
  }

  @Override
  public List<ProgramacionAmbitoOrigenDTO> findByProgramacionAmbito(
      @NonNull final ProgramacionAmbitoDTO programacionAmbito) {
    return this.programacionAmbitoOrigenMapper.programacionAmbitoOrigenToProgramacionAmbitoOrigenDto(
        this.programacionAmbitoOrigenRepository.findByProgramacionAmbitoId(programacionAmbito.getId()));
  }

}
