package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoPersonaRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaAmbitoPersonaServiceImpl implements TareaAmbitoPersonaService {

  @Autowired
  private TareaAmbitoPersonaRepository tareaAmbitoPersonaRepository;

  @Autowired
  private TareaAmbitoPersonaMapper tareaAmbitoPersonaMapper;

  @Override
  public List<TareaAmbitoPersonaDto> create(
      @Valid @NotNull @NotEmpty final List<TareaAmbitoPersonaDto> tareaAmbitoPersona,
      @Valid @NotNull final TareaDto tarea) {
    return tareaAmbitoPersonaMapper
        .tareaAmbitoPersonaToTareaAmbitoPersonaDto(tareaAmbitoPersonaRepository.saveAll(tareaAmbitoPersonaMapper
            .mergeTareaAmbitoPersonaDtoAndTareaDtoToTareaAmbitoPersona(tareaAmbitoPersona, tarea)));
  }

  @Override
  public List<TareaAmbitoPersonaDto> findByTarea(@Valid @NotNull final TareaDto tarea) {
    return tareaAmbitoPersonaMapper
        .tareaAmbitoPersonaToTareaAmbitoPersonaDto(tareaAmbitoPersonaRepository.findByTareaId(tarea.getId()));
  }

}
