package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionConfiguracionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionConfiguracionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAgrupacionConfiguracionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionConfiguracion;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAgrupacionConfiguracionRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaAgrupacionConfiguracionServiceImpl implements TareaAgrupacionConfiguracionService {

  @Autowired
  private TareaAgrupacionConfiguracionMapper tareaAgrupacionConfiguracionMapper;

  @Autowired
  private TareaAgrupacionConfiguracionRepositoryCustom tareaAgrupacionConfiguracionRepositoryCustom;

  @Override
  public List<TareaAgrupacionConfiguracionDto> saveConfiguracionVentaOnline(
      @Valid @NonNull @NotEmpty final List<ConfiguracionVentaOnlineResultItemDto> data,
      @Valid @NonNull final RunTareaDto tarea) {
    List<TareaAgrupacionConfiguracion> configuraciones = tareaAgrupacionConfiguracionMapper
        .getConfiguracionVentaOnlineResponseItemDtoToTareaAgrupacionConfiguracion(data, tarea.getTarea());
    return tareaAgrupacionConfiguracionMapper.getTareaAgrupacionConfiguracionToTareaAgrupacionConfiguracionDto(
        tareaAgrupacionConfiguracionRepositoryCustom.save(configuraciones));
  }

}
