package com.inditex.rrhh.icmclcwb.api.ptr.venta;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PtrGroupTypeEnum {
    
    FECHA_TIENDA("FECHA_TIENDA"), FECHA_TIENDA_SECCION("FECHA_TIENDA_SECCION"), FECHA_TIENDA_SECCION_TEMPORADA_PRODUCTO("FECHA_TIENDA_SECCION_TEMPORADA_PRODUCTO"),
    PERSONA("PERSONA"), PERSONA_TIENDA("PERSONA_TIENDA"), TIENDA("TIENDA");
    
    private String value;

}
