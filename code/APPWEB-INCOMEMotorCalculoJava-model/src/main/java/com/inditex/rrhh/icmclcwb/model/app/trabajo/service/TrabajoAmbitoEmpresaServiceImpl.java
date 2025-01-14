package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoEmpresaService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoEmpresaDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoEmpresaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoAmbitoEmpresaRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TrabajoAmbitoEmpresaServiceImpl implements TrabajoAmbitoEmpresaService {

  @Autowired
  private TrabajoAmbitoEmpresaRepository trabajoAmbitoEmpresaRepository;

  @Autowired
  private TrabajoAmbitoEmpresaMapper trabajoAmbitoEmpresaMapper;

  @Override
  public List<TrabajoAmbitoEmpresaDTO> create(
      @Valid @NonNull @NotEmpty final List<TrabajoAmbitoEmpresaDTO> trabajoAmbitoEmpresa,
      @NonNull final TrabajoDTO trabajo) {
    return this.trabajoAmbitoEmpresaMapper.trabajoAmbitoEmpresaToTrabajoAmbitoEmpresaDto(
        this.trabajoAmbitoEmpresaRepository
            .saveAll(this.trabajoAmbitoEmpresaMapper
                .mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTrabajoAmbitoEmpresa(
                    trabajoAmbitoEmpresa, trabajo)));
  }

  @Override
  public List<TrabajoAmbitoEmpresaDTO> findByTrabajo(@Valid @NonNull final TrabajoDTO trabajo) {
    return this.trabajoAmbitoEmpresaMapper.trabajoAmbitoEmpresaToTrabajoAmbitoEmpresaDto(
        this.trabajoAmbitoEmpresaRepository.findByTrabajoId(trabajo.getId()));
  }

}
