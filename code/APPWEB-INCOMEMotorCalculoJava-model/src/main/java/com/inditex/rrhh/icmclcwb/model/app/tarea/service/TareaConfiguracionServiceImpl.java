package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaConfiguracionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaConfiguracionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaConfiguracion;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaConfiguracionRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class TareaConfiguracionServiceImpl implements TareaConfiguracionService {

  @Autowired
  private TareaConfiguracionMapper tareaConfiguracionMapper;

  @Autowired
  private TareaConfiguracionRepositoryCustom tareaConfiguracionRepositoryCustom;

  @Override
  public void save(@Valid @NotNull @NotEmpty final List<ConfiguracionItemDto> src,
      @Valid @NotNull final TareaDto tarea) {
    final List<TareaConfiguracion> configuraciones = this.tareaConfiguracionMapper
        .getConfiguracionItemDtoToTareaConfiguracion(src, tarea);
    this.tareaConfiguracionRepositoryCustom.save(configuraciones);
  }

}
