package com.inditex.rrhh.icmclcwb.api.app.trabajo;

import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TipoTrabajoTiendaDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoTrabajoTiendaEnum {

    INICIAL(1L, new TipoTrabajoTiendaDto(1L)), PARAMETRO(2L, new TipoTrabajoTiendaDto(2L)),
    HISTORICO(3L, new TipoTrabajoTiendaDto(3L)), PRESENCIA(4L, new TipoTrabajoTiendaDto(4L));

    private final Long id;

    private final TipoTrabajoTiendaDto dto;

    public static final List<TipoTrabajoTiendaDto> TIPO_PRESENCIA = Arrays.asList(PRESENCIA.getDto());

    public static final List<TipoTrabajoTiendaDto> TIPO_INICIAL_PARAM_HISTORICO = Arrays.asList(INICIAL.getDto(),
            PARAMETRO.getDto(), HISTORICO.getDto());

}
