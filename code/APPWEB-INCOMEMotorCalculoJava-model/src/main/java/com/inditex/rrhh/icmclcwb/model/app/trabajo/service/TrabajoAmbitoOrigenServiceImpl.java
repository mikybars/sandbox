package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoOrigenService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoOrigenDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoOrigenMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoAmbitoOrigenRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TrabajoAmbitoOrigenServiceImpl implements TrabajoAmbitoOrigenService {

  @Autowired
  private TrabajoAmbitoOrigenRepository trabajoAmbitoOrigenRepository;

  @Autowired
  private TrabajoAmbitoOrigenMapper trabajoAmbitoOrigenMapper;

  @Override
  public List<TrabajoAmbitoOrigenDTO> create(
      @Valid @NotNull @NotEmpty final List<TrabajoAmbitoOrigenDTO> trabajoAmbitoOrigen,
      @NotNull final TrabajoDTO trabajo) {
    return this.trabajoAmbitoOrigenMapper.trabajoAmbitoOrigenToTrabajoAmbitoOrigenDto(
        this.trabajoAmbitoOrigenRepository.saveAll(this.trabajoAmbitoOrigenMapper
            .mergeTrabajoAmbitoOrigenDtoAndTrabajoDtoToTrabajoAmbitoOrigen(trabajoAmbitoOrigen, trabajo)));
  }

  @Override
  public List<TrabajoAmbitoOrigenDTO> findByTrabajo(@Valid @NotNull final TrabajoDTO trabajo) {
    return this.trabajoAmbitoOrigenMapper.trabajoAmbitoOrigenToTrabajoAmbitoOrigenDto(
        this.trabajoAmbitoOrigenRepository.findByTrabajoId(trabajo.getId()));
  }

}
