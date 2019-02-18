package com.inditex.rrhh.icmclcwb.api.app.tarea;

import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TipoTareaTiendaDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoTareaTiendaEnum {

    INICIAL(1L, new TipoTareaTiendaDto(1L)), PARAMETRO(2L, new TipoTareaTiendaDto(2L)),
    HISTORICO(3L, new TipoTareaTiendaDto(3L)), PRESENCIA(4L, new TipoTareaTiendaDto(4L));

    private final Long id;

    private final TipoTareaTiendaDto dto;

    public static final List<TipoTareaTiendaDto> TIPO_PRESENCIA = Arrays.asList(PRESENCIA.getDto());

    public static final List<TipoTareaTiendaDto> TIPO_INICIAL_PARAM_HISTORICO = Arrays.asList(INICIAL.getDto(),
            PARAMETRO.getDto(), HISTORICO.getDto());

}
