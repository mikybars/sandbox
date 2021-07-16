package com.inditex.rrhh.icmclcwb.api.app;

import com.inditex.rrhh.icmclcwb.api.app.dto.TipoAmbitoDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoAmbitoEnum {

    SOCIEDAD(1L, "1", new TipoAmbitoDto(1L)), ORIGEN(2L, "2", new TipoAmbitoDto(2L)), EMPRESA(3L, "3",
            new TipoAmbitoDto(3L)), LOCALIZACION(4L, "4",
                    new TipoAmbitoDto(4L)), PERSONA(5L, "5", new TipoAmbitoDto(5L));

    private final Long id;

    private final String icmIdAmbitoEjec;

    private final TipoAmbitoDto dto;

    public static TipoAmbitoEnum fromId(Long id) {
        TipoAmbitoEnum result = null;
        for (TipoAmbitoEnum value : TipoAmbitoEnum.values()) {
            if (value.id.equals(id)) {
                result = value;
            }
        }
        return result;
    }

}
