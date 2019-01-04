package com.inditex.rrhh.icmclcwb.model.app.calculo;

import java.util.Arrays;

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;
import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoDto;

import lombok.Getter;

@Getter
public enum TipoCalculoEnum {

    GLOBAL_TIENDA(1L) {
        @Override
        public TipoCalculoAlgoritmo crear() {
            return new GTAlgoritmo();
        }
    };

    private Long tipoCalculo;

    private TipoCalculoEnum(Long tipoCalculo) {
        this.tipoCalculo = tipoCalculo;
    }

    private Long idTipoCalculo() {
        return tipoCalculo;
    }

    public static TipoCalculoEnum of(Long tipoCalculo) {
        return Arrays.stream(values()).filter(value -> value.idTipoCalculo().equals(tipoCalculo)).findAny().orElseThrow(
                () -> new ApplicationException(String.format("No existe el tipo de calculo  %s", tipoCalculo)));
    }

    public abstract TipoCalculoAlgoritmo crear();

}
