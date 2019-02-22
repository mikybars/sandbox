package com.inditex.rrhh.icmclcwb.api.app.proceso;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AlgoritmoEnum {

    GLOBAL_TIENDA_VERSION_1(1L, "globalTiendaVersion1Algoritmo", Boolean.TRUE, Arrays.asList(1L));

    private final Long id;

    private final String type;

    private final Boolean status;

    private final List<Long> tipoCalculo;

    public static AlgoritmoEnum of(Long id) {
        return Arrays.stream(values())
                .filter(item -> Boolean.TRUE.equals(item.status) && item.getTipoCalculo().contains(id))
                .findAny().orElseGet(() -> null);
    }

}
