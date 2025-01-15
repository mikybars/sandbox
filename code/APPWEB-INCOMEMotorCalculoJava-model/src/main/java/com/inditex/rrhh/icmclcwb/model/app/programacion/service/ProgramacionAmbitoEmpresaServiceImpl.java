package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoEmpresaService;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoEmpresaDTO;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoEmpresaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionAmbitoEmpresaRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class ProgramacionAmbitoEmpresaServiceImpl implements ProgramacionAmbitoEmpresaService {

  private final ProgramacionAmbitoEmpresaRepository programacionAmbitoEmpresaRepository;

  private final ProgramacionAmbitoEmpresaMapper programacionAmbitoEmpresaMapper;

  @Override
  public List<ProgramacionAmbitoEmpresaDTO> create(
      @Valid @NonNull @NotEmpty final List<ProgramacionAmbitoEmpresaDTO> programacionAmbitoEmpresa,
      @NonNull final ProgramacionAmbitoDTO programacionAmbito) {
    return this.programacionAmbitoEmpresaMapper.programacionAmbitoEmpresaToProgramacionAmbitoEmpresaDto(
        this.programacionAmbitoEmpresaRepository.saveAll(this.programacionAmbitoEmpresaMapper
            .mergeProgramacionAmbitoEmpresaDtoAndProgramacionDtoToProgramacionAmbitoEmpresa(
                programacionAmbitoEmpresa, programacionAmbito)));
  }

  @Override
  public List<ProgramacionAmbitoEmpresaDTO> findByProgramacionAmbito(
      @NonNull final ProgramacionAmbitoDTO programacionAmbito) {
    return this.programacionAmbitoEmpresaMapper.programacionAmbitoEmpresaToProgramacionAmbitoEmpresaDto(
        this.programacionAmbitoEmpresaRepository.findByProgramacionAmbitoId(programacionAmbito.getId()));
  }

}
