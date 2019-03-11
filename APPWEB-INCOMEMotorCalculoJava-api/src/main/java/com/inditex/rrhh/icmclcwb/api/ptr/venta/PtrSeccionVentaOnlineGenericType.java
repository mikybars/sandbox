package com.inditex.rrhh.icmclcwb.api.ptr.venta;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PtrSeccionVentaOnlineGenericType {

    private Integer seccion;
    
    @NotNull
    private BigDecimal importeSinIVA;

    @NotNull
    private BigDecimal importeConIVA;
}
