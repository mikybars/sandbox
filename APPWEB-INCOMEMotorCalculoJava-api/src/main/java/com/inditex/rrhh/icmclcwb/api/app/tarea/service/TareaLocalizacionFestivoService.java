package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface TareaLocalizacionFestivoService {

  void save(@Valid @NotNull @NotEmpty final List<HorarioComercialFestivoDocDto> src,
      @Valid @NotNull final TareaDto tareaDto);

}
