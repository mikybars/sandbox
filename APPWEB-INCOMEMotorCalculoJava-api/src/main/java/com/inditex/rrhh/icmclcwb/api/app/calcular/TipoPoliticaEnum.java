package com.inditex.rrhh.icmclcwb.api.app.calcular;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoPoliticaEnum {

    HORAS_FIJAS(1L, "001"), EXCLUIDO_DENOMINADOR(2L, "002"), CARENCIA(3L, "003"),
    ANTIGUEDAD(4L, "004"), BAJA_IT(5L, "005"), VACACIONES(6L, "006"),
    MINIMO_GARANTIZADO(7L, "007"), MAXIMO_GARANTIZADO(8L, "008");

    private final Long id;

    private final String idMeta4;

    public static TipoPoliticaEnum fromIdMeta4(String idMeta4) {
        for (TipoPoliticaEnum tipo : TipoPoliticaEnum.values()) {
            if (tipo.idMeta4.equals(idMeta4)) {
                return tipo;
            }
        }
        return null;
    }

    public static TipoPoliticaEnum fromId(Long id) {
        for (TipoPoliticaEnum tipo : TipoPoliticaEnum.values()) {
            if (tipo.id == id) {
                return tipo;
            }
        }
        return null;
    }

}
