package com.inditex.rrhh.icmclcwb.api.app.proceso;

import java.util.Objects;
import java.util.stream.Stream;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoProcesoEnum {
    CONFIRMACION(1, new TipoProcesoDTO(1, "CONFIRMACION")),
    EXPORTACION(2, new TipoProcesoDTO(2, "EXPORTACION")),
    ANULACION_CONFIRMACION(3, new TipoProcesoDTO(3, "ANULACION_CONFIRMACION")),
    ANULACION_EXPORTACION(4, new TipoProcesoDTO(4, "ANULACION_EXPORTACION")),
    UNDEFINED(null, null);

    private final Integer id;

    private final TipoProcesoDTO dto;

    public static TipoProcesoEnum of(final Integer id) {
        return Stream.of(values())
            .filter(obj -> Objects.equals(obj.getId(), id))
            .findAny()
            .orElse(UNDEFINED);
    }

    public static TipoProcesoEnum of(final TipoProcesoDTO dto) {
        return Stream.of(values())
            .filter(obj -> Objects.equals(obj.getDto(), dto))
            .findAny()
            .orElse(UNDEFINED);
    }

}
