package com.inditex.rrhh.icmclcwb.api.app.trabajo;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AlgoritmoEnum {

    GLOBAL_TIENDA(1L, "globalTiendaAlgoritmo", Boolean.TRUE, Arrays.asList(1L));

    private final Long id;

    private final String type;

    private final Boolean status;

    private final List<Long> tipoCalculo;

    public static AlgoritmoEnum of(Long idTipoCalculo) {
        return Arrays.stream(values())
                .filter(item -> item.status.equals(Boolean.TRUE) && item.getTipoCalculo().contains(idTipoCalculo))
                .findAny().orElseGet(() -> null);
    }

}
