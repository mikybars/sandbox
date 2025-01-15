package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaConfiguracionPrecioHoraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaConfiguracionPrecioHoraService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaConfiguracionPrecioHoraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaConfiguracionPrecioHoraRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class TareaConfiguracionPrecioHoraServiceImpl implements TareaConfiguracionPrecioHoraService {

  @Autowired
  private TareaConfiguracionPrecioHoraMapper tareaConfiguracionPrecioHoraMapper;

  @Autowired
  private TareaConfiguracionPrecioHoraRepositoryCustom tareaConfiguracionPrecioHoraRepositoryCustom;

  @Override
  public void save(@Valid @NotNull @NotEmpty final List<TareaConfiguracionPrecioHoraDto> src,
      @Valid @NotNull final TareaDto tarea) {
    tareaConfiguracionPrecioHoraRepositoryCustom.save(
        tareaConfiguracionPrecioHoraMapper.tareaConfiguracionPrecioHoraDtoToTareaConfiguracionPrecioHora(src));
  }

  @Override
  public void saveConfPrecioHoraResultItemDto(@Valid @NotNull @NotEmpty final List<ConfPrecioHoraResultItemDto> src,
      @Valid @NotNull final TareaDto tarea) {
    tareaConfiguracionPrecioHoraRepositoryCustom.save(
        tareaConfiguracionPrecioHoraMapper.confPrecioHoraResultItemDtoToTareaConfiguracionPrecioHora(src,
            tarea));
  }

}
