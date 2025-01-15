package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTipoHoraDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraResponseDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface TareaTipoHoraService {

  List<TareaTipoHoraDto> save(@Valid @NotNull final TiposHoraResponseDto dto, @Valid @NotNull final TareaDto tarea);

  List<TareaTipoHoraDto> findByIdTareaAndExcluidoDenominadorYRepartidoProvincia(@Valid @NotNull final TareaDto tarea);

}
