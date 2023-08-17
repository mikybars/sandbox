package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionEstadoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocResultItemDto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface TareaLocalizacionEstadoService {

  List<TareaLocalizacionEstadoDto> save(
      @Valid @NotNull @NotEmpty List<TareaLocalizacionEstadoDto> tareaLocalizacionEstadoDto);

  List<TareaLocalizacionEstadoDto> merge(
      @Valid @NotNull @NotEmpty List<EstadoWlocResultItemDto> estadoWlocResultItemDto,
      @Valid @NotNull TareaDto tarea);
}
