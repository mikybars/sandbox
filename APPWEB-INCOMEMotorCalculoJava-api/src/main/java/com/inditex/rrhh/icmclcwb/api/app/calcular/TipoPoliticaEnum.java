package com.inditex.rrhh.icmclcwb.api.app.calcular;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoPoliticaEnum {

    SIN_ASIGNAR(0, "000"), HORAS_FIJAS(1, "001"), EXCLUIDO_DENOMINADOR(2, "002"), CARENCIA(3, "003"),
    ANTIGUEDAD(4, "004"), BAJA_IT(5, "005"), VACACIONES(6, "006"),
    MINIMO_GARANTIZADO(7, "007"), MAXIMO_GARANTIZADO(8, "008");

    private final Integer id;

    private final String idMeta4;

    public static TipoPoliticaEnum fromIdMeta4(String idMeta4) {
        for (TipoPoliticaEnum tipo : TipoPoliticaEnum.values()) {
            if (tipo.idMeta4.equals(idMeta4)) {
                return tipo;
            }
        }
        return null;
    }

    public static TipoPoliticaEnum fromId(Integer id) {
        for (TipoPoliticaEnum tipo : TipoPoliticaEnum.values()) {
            if (tipo.id.equals(id)) {
                return tipo;
            }
        }
        return null;
    }

}
