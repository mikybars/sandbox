package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoLocalizacionDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoLocalizacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoAmbitoLocalizacionRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TrabajoAmbitoLocalizacionServiceImpl implements TrabajoAmbitoLocalizacionService {

  @Autowired
  private TrabajoAmbitoLocalizacionRepository trabajoAmbitoLocalizacionRepository;

  @Autowired
  private TrabajoAmbitoLocalizacionMapper trabajoAmbitoLocalizacionMapper;

  @Override
  public List<TrabajoAmbitoLocalizacionDTO> create(
      @Valid @NonNull @NotEmpty final List<TrabajoAmbitoLocalizacionDTO> trabajoAmbitoLocalizacion,
      @NonNull final TrabajoDTO trabajo) {
    return this.trabajoAmbitoLocalizacionMapper.trabajoAmbitoLocalizacionToTrabajoAmbitoLocalizacionDto(
        this.trabajoAmbitoLocalizacionRepository.saveAll(this.trabajoAmbitoLocalizacionMapper
            .mergeTrabajoAmbitoLocalizacionDtoAndTrabajoDtoToTrabajoAmbitoLocalizacion(
                trabajoAmbitoLocalizacion, trabajo)));
  }

  @Override
  public List<TrabajoAmbitoLocalizacionDTO> findByTrabajo(@Valid @NonNull final TrabajoDTO trabajo) {
    return this.trabajoAmbitoLocalizacionMapper.trabajoAmbitoLocalizacionToTrabajoAmbitoLocalizacionDto(
        this.trabajoAmbitoLocalizacionRepository.findByTrabajoId(trabajo.getId()));
  }

}
