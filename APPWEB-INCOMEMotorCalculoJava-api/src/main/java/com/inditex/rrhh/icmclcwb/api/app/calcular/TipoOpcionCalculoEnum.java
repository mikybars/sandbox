package com.inditex.rrhh.icmclcwb.api.app.calcular;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoOpcionCalculoEnum {

    ORIGEN(1, "01"), DESTINO(2, "02"), MEJOR_OPCION(3, "03"), SIN_COMISION_VARIABLE(4, "04");

    private final Integer id;

    private final String idMeta4;

    public static TipoOpcionCalculoEnum fromIdMeta4(String idMeta4) {
        for (TipoOpcionCalculoEnum tipo : TipoOpcionCalculoEnum.values()) {
            if (tipo.idMeta4.equals(idMeta4)) {
                return tipo;
            }
        }
        return null;
    }

    public static TipoOpcionCalculoEnum fromId(Integer id) {
        for (TipoOpcionCalculoEnum tipo : TipoOpcionCalculoEnum.values()) {
            if (tipo.id.equals(id)) {
                return tipo;
            }
        }
        return null;
    }

}
