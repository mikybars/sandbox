package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoEmpresaService;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoEmpresaDTO;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoEmpresaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionAmbitoEmpresaRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ProgramacionAmbitoEmpresaServiceImpl implements ProgramacionAmbitoEmpresaService {

  @Autowired
  private ProgramacionAmbitoEmpresaRepository programacionAmbitoEmpresaRepository;

  @Autowired
  private ProgramacionAmbitoEmpresaMapper programacionAmbitoEmpresaMapper;

  @Override
  public List<ProgramacionAmbitoEmpresaDTO> create(
      @Valid @NotNull @NotEmpty final List<ProgramacionAmbitoEmpresaDTO> programacionAmbitoEmpresa,
      @NotNull final ProgramacionAmbitoDTO programacionAmbito) {
    return this.programacionAmbitoEmpresaMapper.programacionAmbitoEmpresaToProgramacionAmbitoEmpresaDto(
        this.programacionAmbitoEmpresaRepository.saveAll(this.programacionAmbitoEmpresaMapper
            .mergeProgramacionAmbitoEmpresaDtoAndProgramacionDtoToProgramacionAmbitoEmpresa(
                programacionAmbitoEmpresa, programacionAmbito)));
  }

  @Override
  public List<ProgramacionAmbitoEmpresaDTO> findByProgramacionAmbito(
      @NotNull final ProgramacionAmbitoDTO programacionAmbito) {
    return this.programacionAmbitoEmpresaMapper.programacionAmbitoEmpresaToProgramacionAmbitoEmpresaDto(
        this.programacionAmbitoEmpresaRepository.findByProgramacionAmbitoId(programacionAmbito.getId()));
  }

}
