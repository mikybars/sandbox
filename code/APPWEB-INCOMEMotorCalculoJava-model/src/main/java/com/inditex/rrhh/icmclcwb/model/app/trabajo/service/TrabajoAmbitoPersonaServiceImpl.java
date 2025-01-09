package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoPersonaDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoAmbitoPersonaRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TrabajoAmbitoPersonaServiceImpl implements TrabajoAmbitoPersonaService {

  @Autowired
  private TrabajoAmbitoPersonaRepository trabajoAmbitoPersonaRepository;

  @Autowired
  private TrabajoAmbitoPersonaMapper trabajoAmbitoPersonaMapper;

  @Override
  public List<TrabajoAmbitoPersonaDTO> create(
      @Valid @NonNull @NotEmpty final List<TrabajoAmbitoPersonaDTO> trabajoAmbitoPersona,
      @NonNull final TrabajoDTO trabajo) {
    return this.trabajoAmbitoPersonaMapper.trabajoAmbitoPersonaToTrabajoAmbitoPersonaDto(
        this.trabajoAmbitoPersonaRepository
            .saveAll(this.trabajoAmbitoPersonaMapper
                .mergeTrabajoAmbitoPersonaDtoAndTrabajoDtoToTrabajoAmbitoPersona(
                    trabajoAmbitoPersona, trabajo)));
  }

  @Override
  public List<TrabajoAmbitoPersonaDTO> findByTrabajo(@Valid @NonNull final TrabajoDTO trabajo) {
    return this.trabajoAmbitoPersonaMapper.trabajoAmbitoPersonaToTrabajoAmbitoPersonaDto(
        this.trabajoAmbitoPersonaRepository.findByTrabajoId(trabajo.getId()));
  }

}
