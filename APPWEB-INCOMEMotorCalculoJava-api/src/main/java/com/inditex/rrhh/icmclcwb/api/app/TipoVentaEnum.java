package com.inditex.rrhh.icmclcwb.api.app;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoVentaEnum {

    FISICO (1L, "00"), IPOD(2L, "01"), SINT(3L, "02"),
    ENTREGA_TIENDA(4L, "03"), ENTREGA_DOMICILIO_POR_VENTA(5L, "04"),
    ENTREGA_DOMICILIO_POR_PRESENCIAS(6L, "05");

    private final Long id;
    private final String idMeta4;

    public static TipoVentaEnum fromIdMeta4(String text) {
        for (TipoVentaEnum tipo : TipoVentaEnum.values()) {
            if (tipo.idMeta4.equals(text)) {
                return tipo;
            }
        }
        return null;
    }

    public static TipoVentaEnum fromId(Long id) {
        for (TipoVentaEnum tipo : TipoVentaEnum.values()) {
            if (tipo.id.equals(id)) {
                return tipo;
            }
        }
        return null;
    }

}
