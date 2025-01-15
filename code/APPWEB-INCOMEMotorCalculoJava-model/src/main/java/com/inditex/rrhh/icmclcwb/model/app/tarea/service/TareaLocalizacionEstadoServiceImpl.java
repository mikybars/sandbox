package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionEstadoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionEstadoRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaLocalizacionEstadoServiceImpl implements TareaLocalizacionEstadoService {

  @Autowired
  private TareaLocalizacionEstadoRepositoryCustom tareaLocalizacionEstadoRepositoryCustom;

  @Autowired
  private TareaLocalizacionEstadoMapper tareaLocalizacionEstadoMapper;

  @Override
  public List<TareaLocalizacionEstadoDto> save(
      @Valid @NotNull @NotEmpty final List<TareaLocalizacionEstadoDto> tareaLocalizacionEstadoDto) {
    return this.tareaLocalizacionEstadoMapper.tareaLocalizacionEstadoToTareaLocalizacionEstadoDto(
        this.tareaLocalizacionEstadoRepositoryCustom.save(this.tareaLocalizacionEstadoMapper
            .tareaLocalizacionEstadoDtoToTareaLocalizacionEstado(tareaLocalizacionEstadoDto)));
  }

  @Override
  public List<TareaLocalizacionEstadoDto> merge(
      @Valid @NotNull @NotEmpty final List<EstadoWlocResultItemDto> estadoWlocResultItemDto,
      @Valid @NotNull final TareaDto tarea) {
    return this.tareaLocalizacionEstadoMapper
        .estadoWlocResultItemDtoToTareaLocalizacionEstadoDto(estadoWlocResultItemDto, tarea);
  }

}
