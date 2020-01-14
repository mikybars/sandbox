package com.inditex.rrhh.icmclcwb.api.app.calcular;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoUnidadTiempoEnum {

    ANOS(1, "01"), MESES(2, "02"), SEMANAS(3, "03"),
    DIAS(4, "04"), HORAS(5, "05"), MINUTOS(6, "06"), NINGUNO(7, "07");
    
    private final Integer id;

    private final String idMeta4;
    
    public static TipoUnidadTiempoEnum fromIdMeta4(String idMeta4) {
        for (TipoUnidadTiempoEnum tipo : TipoUnidadTiempoEnum.values()) {
            if (tipo.idMeta4.equals(idMeta4)) {
                return tipo;
            }
        }
        return TipoUnidadTiempoEnum.NINGUNO;
    }

    public static TipoUnidadTiempoEnum fromId(Long id) {
        for (TipoUnidadTiempoEnum tipo : TipoUnidadTiempoEnum.values()) {
            if (tipo.id.equals(id)) {
                return tipo;
            }
        }
        return TipoUnidadTiempoEnum.NINGUNO;
    }
}
