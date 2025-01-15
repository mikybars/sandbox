package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoLocalizacionDTO;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoLocalizacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionAmbitoLocalizacionRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ProgramacionAmbitoLocalizacionServiceImpl implements ProgramacionAmbitoLocalizacionService {

  @Autowired
  private ProgramacionAmbitoLocalizacionRepository programacionAmbitoLocalizacionRepository;

  @Autowired
  private ProgramacionAmbitoLocalizacionMapper programacionAmbitoLocalizacionMapper;

  @Override
  public List<ProgramacionAmbitoLocalizacionDTO> create(
      @Valid @NotNull @NotEmpty final List<ProgramacionAmbitoLocalizacionDTO> programacionAmbitoLocalizacion,
      @NotNull final ProgramacionAmbitoDTO programacionAmbito) {
    return this.programacionAmbitoLocalizacionMapper
        .programacionAmbitoLocalizacionToProgramacionAmbitoLocalizacionDto(
            this.programacionAmbitoLocalizacionRepository.saveAll(this.programacionAmbitoLocalizacionMapper
                .mergeProgramacionAmbitoLocalizacionDtoAndProgramacionDtoToProgramacionAmbitoLocalizacion(
                    programacionAmbitoLocalizacion, programacionAmbito)));
  }

  @Override
  public List<ProgramacionAmbitoLocalizacionDTO> findByProgramacionAmbito(
      @NotNull final ProgramacionAmbitoDTO programacionAmbito) {
    return this.programacionAmbitoLocalizacionMapper
        .programacionAmbitoLocalizacionToProgramacionAmbitoLocalizacionDto(
            this.programacionAmbitoLocalizacionRepository
                .findByProgramacionAmbitoId(programacionAmbito.getId()));
  }

}
