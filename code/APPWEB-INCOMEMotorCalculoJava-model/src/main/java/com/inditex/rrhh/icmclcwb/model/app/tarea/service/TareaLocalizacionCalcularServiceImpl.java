package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionCalcularService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionCalcularMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionCalcularRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaLocalizacionCalcularServiceImpl implements TareaLocalizacionCalcularService {

  @Autowired
  private TareaLocalizacionCalcularRepositoryCustom tareaLocalizacionCalcularRepositoryCustom;

  @Autowired
  private TareaLocalizacionCalcularMapper tareaLocalizacionCalcularMapper;

  @Override
  public void save(@Valid @NotNull @NotEmpty final List<GenericTiendaResultItemDto> src,
      @Valid @NotNull final TareaDto tareaDto) {
    tareaLocalizacionCalcularRepositoryCustom.save(tareaLocalizacionCalcularMapper
        .genericTiendaResultItemDtoToTareaLocalizacionCalcular(src, tareaDto));
  }

}
