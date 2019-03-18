package com.inditex.rrhh.icmclcwb.api.ptr.venta;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PtrSeccionVentaOnlineIpodIndividualDetalle {

    private Integer seccion;
    
    private BigDecimal importeSinIVA;

    private BigDecimal importeConIVA;
}
