package com.inditex.rrhh.icmclcwb.api.app;

import com.inditex.rrhh.icmclcwb.api.app.dto.TipoAmbitoDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoAmbitoEnum {

    SOCIEDAD(1L, new TipoAmbitoDto(1L)), ORIGEN(2L, new TipoAmbitoDto(2L)),
    EMPRESA(3L, new TipoAmbitoDto(3L)), LOCALIZACION(4L, new TipoAmbitoDto(4L)),
    PERSONA(5L, new TipoAmbitoDto(5L));

    private final Long id;

    private final TipoAmbitoDto dto;

}
