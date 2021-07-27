package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTipoHoraDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResultItemDto;

public interface TareaTipoHoraService {

    List<TareaTipoHoraDto> save(@Valid @NotNull @NotEmpty final List<PtrPresenciaTiposHorasResultItemDto> item,
            @Valid @NotNull final TareaDto tarea);

    List<TareaTipoHoraDto> save(@Valid @NotNull final TiposHoraResponseDto dto, @Valid @NotNull final TareaDto tarea);

}
