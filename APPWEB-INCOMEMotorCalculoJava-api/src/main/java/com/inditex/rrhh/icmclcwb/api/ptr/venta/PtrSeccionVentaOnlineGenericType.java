package com.inditex.rrhh.icmclcwb.api.ptr.venta;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PtrSeccionVentaOnlineGenericType implements Serializable {

    private static final long serialVersionUID = 775015226321738779L;

    private Integer seccion;

    @NotNull
    private BigDecimal importeSinIVA;

    @NotNull
    private BigDecimal importeConIVA;

}
