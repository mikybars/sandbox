package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.AccionMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.OptionalUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.AccionRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.AccionRepositoryCustom;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class AccionServiceImpl implements AccionService {

  @Autowired
  private AccionRepository accionRepository;

  @Autowired
  private AccionRepositoryCustom accionRepositoryCustom;

  @Autowired
  private AccionMapper accionMapper;

  @Override
  @Cacheable(value = "itx.icmlcwb.accion_dto_by_id", key = "{#id}")
  public AccionDto findAccionDtoById(@NotNull final Integer id) {
    return this.accionMapper.accionToAccionDto(OptionalUtils.get(this.accionRepository.findById(id)));
  }

  @Override
  public Boolean findByIdAccionAndIdOrigenAndStdIdLegEnt(@NotNull @Positive final Integer idAccion,
      @NotBlank final String cclIdOrigen, @NotBlank final String stdIdLegEnt) {
    return this.accionRepositoryCustom.findByIdAccionAndIdOrigenAndStdIdLegEnt(idAccion, cclIdOrigen, stdIdLegEnt);
  }

}
