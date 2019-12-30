package com.inditex.rrhh.icmclcwb.api.app.calcular;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoUnidadTiempoEnum {

    ANOS(1L, "01"), MESES(2L, "02"), SEMANAS(3L, "03"),
    DIAS(4L, "04");
    
    private final Long id;

    private final String idMeta4;
    
}
