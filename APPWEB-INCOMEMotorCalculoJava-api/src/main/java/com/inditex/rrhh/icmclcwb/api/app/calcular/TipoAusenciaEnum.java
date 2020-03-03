package com.inditex.rrhh.icmclcwb.api.app.calcular;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoAusenciaEnum {

    BAJA_IT(1, "1"), VACACIONES(2, "2");
    
    private final Integer id;

    private final String idMeta4;
    
    public static TipoAusenciaEnum fromIdMeta4(String idMeta4) {
        for (TipoAusenciaEnum tipo : TipoAusenciaEnum.values()) {
            if (tipo.idMeta4.equals(idMeta4)) {
                return tipo;
            }
        }
        return null;
    }

    public static TipoAusenciaEnum fromId(Integer id) {
        for (TipoAusenciaEnum tipo : TipoAusenciaEnum.values()) {
            if (tipo.id.equals(id)) {
                return tipo;
            }
        }
        return null;
    }
}
