package com.inditex.rrhh.icmclcwb.api.ptr.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PtrGroupTypeEnum {
    
    FECHA_TIENDA("FECHA_TIENDA"), FECHA_TIENDA_SECCION("FECHA_TIENDA_SECCION"), FECHA_TIENDA_SECCION_TEMPORADA_PRODUCTO("FECHA_TIENDA_SECCION_TEMPORADA_PRODUCTO");
    
    private String value;

}
