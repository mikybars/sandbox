package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoLocalizacionDTO;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionAmbitoLocalizacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionAmbitoLocalizacionRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class ProgramacionAmbitoLocalizacionServiceImpl implements ProgramacionAmbitoLocalizacionService {

  private final ProgramacionAmbitoLocalizacionRepository programacionAmbitoLocalizacionRepository;

  private final ProgramacionAmbitoLocalizacionMapper programacionAmbitoLocalizacionMapper;

  @Override
  public List<ProgramacionAmbitoLocalizacionDTO> create(
      @Valid @NonNull @NotEmpty final List<ProgramacionAmbitoLocalizacionDTO> programacionAmbitoLocalizacion,
      @NonNull final ProgramacionAmbitoDTO programacionAmbito) {
    return this.programacionAmbitoLocalizacionMapper
        .programacionAmbitoLocalizacionToProgramacionAmbitoLocalizacionDto(
            this.programacionAmbitoLocalizacionRepository.saveAll(this.programacionAmbitoLocalizacionMapper
                .mergeProgramacionAmbitoLocalizacionDtoAndProgramacionDtoToProgramacionAmbitoLocalizacion(
                    programacionAmbitoLocalizacion, programacionAmbito)));
  }

  @Override
  public List<ProgramacionAmbitoLocalizacionDTO> findByProgramacionAmbito(
      @NonNull final ProgramacionAmbitoDTO programacionAmbito) {
    return this.programacionAmbitoLocalizacionMapper
        .programacionAmbitoLocalizacionToProgramacionAmbitoLocalizacionDto(
            this.programacionAmbitoLocalizacionRepository
                .findByProgramacionAmbitoId(programacionAmbito.getId()));
  }

}
