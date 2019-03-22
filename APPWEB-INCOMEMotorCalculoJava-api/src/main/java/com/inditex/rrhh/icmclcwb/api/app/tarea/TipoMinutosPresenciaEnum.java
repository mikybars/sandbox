package com.inditex.rrhh.icmclcwb.api.app.tarea;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoMinutosPresenciaEnum {

    MINUTOS_TOTALES(1L), MINUTOS_DE_VENDEDORES(2L);
    
    private final Long id;

}
