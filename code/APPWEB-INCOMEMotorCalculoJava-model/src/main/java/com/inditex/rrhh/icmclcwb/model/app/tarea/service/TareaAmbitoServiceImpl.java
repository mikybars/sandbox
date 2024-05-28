package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaAmbitoServiceImpl implements TareaAmbitoService {

  @Autowired
  private TareaAmbitoRepository tareaAmbitoRepository;

  @Autowired
  private TareaAmbitoMapper tareaAmbitoMapper;

  @Override
  public List<TareaAmbitoDto> create(@Valid @NotNull @NotEmpty final List<TareaAmbitoDto> tareaAmbito,
      @Valid @NotNull final TareaDto tarea) {
    return this.tareaAmbitoMapper.tareaAmbitoToTareaAmbitoDto(this.tareaAmbitoRepository
        .saveAll(this.tareaAmbitoMapper.mergeTareaAmbitoDtoAndTareaDtoToTareaAmbito(tareaAmbito, tarea)));
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.tarea_ambito_dto_by_tarea", key = "{#tarea.id}")
  public List<TareaAmbitoDto> findByTarea(@Valid @NotNull final TareaDto tarea) {
    return this.tareaAmbitoMapper
        .tareaAmbitoToTareaAmbitoDto(this.tareaAmbitoRepository.findByTareaId(tarea.getId()));
  }

}
