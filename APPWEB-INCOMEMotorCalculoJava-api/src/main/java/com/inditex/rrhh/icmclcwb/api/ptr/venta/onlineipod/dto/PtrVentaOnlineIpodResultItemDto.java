package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PtrVentaOnlineIpodResultItemDto implements Serializable {

    private static final long serialVersionUID = 1551558406985467960L;

    @NotBlank
    private String fecha;

    private Integer pais;

    private Integer cadena;

    @NotBlank
    private Integer tienda;
    
    private Integer empresa;

    private Integer seccion;

    @NotNull
    private BigDecimal importeSinIVA;

    @NotNull
    private BigDecimal importeConIVA;
}
