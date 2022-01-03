package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoLocalizacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoLocalizacionRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaAmbitoLocalizacionServiceImpl implements TareaAmbitoLocalizacionService {

  @Autowired
  private TareaAmbitoLocalizacionRepository tareaAmbitoLocalizacionRepository;

  @Autowired
  private TareaAmbitoLocalizacionMapper tareaAmbitoLocalizacionMapper;

  @Override
  public List<TareaAmbitoLocalizacionDto> create(
      @Valid @NotNull @NotEmpty final List<TareaAmbitoLocalizacionDto> tareaAmbitoLocalizacion,
      @Valid @NotNull final TareaDto tarea) {
    return tareaAmbitoLocalizacionMapper.tareaAmbitoLocalizacionToTareaAmbitoLocalizacionDto(
        tareaAmbitoLocalizacionRepository.saveAll(tareaAmbitoLocalizacionMapper
            .mergeTareaAmbitoLocalizacionDtoAndTareaDtoToTareaAmbitoLocalizacion(tareaAmbitoLocalizacion,
                tarea)));
  }

  @Override
  public List<TareaAmbitoLocalizacionDto> findByTarea(@Valid @NotNull final TareaDto tarea) {
    return tareaAmbitoLocalizacionMapper.tareaAmbitoLocalizacionToTareaAmbitoLocalizacionDto(
        tareaAmbitoLocalizacionRepository.findByTareaId(tarea.getId()));
  }

}
