package com.inditex.rrhh.icmclcwb.api.app;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoConceptoVenta {

    IPOD("01"), SINT("02"), ENTREGA_TIENDA("03"),
    ENTREGA_DOMICILIO_POR_VENTA("04"),
    ENTREGA_DOMICILIO_POR_PRESENCIAS("05");

    private final String id;

    public static TipoConceptoVenta fromString(String text) {
        for (TipoConceptoVenta tipo : TipoConceptoVenta.values()) {
            if (tipo.id.equals(text)) {
                return tipo;
            }
        }
        return null;
    }

}
