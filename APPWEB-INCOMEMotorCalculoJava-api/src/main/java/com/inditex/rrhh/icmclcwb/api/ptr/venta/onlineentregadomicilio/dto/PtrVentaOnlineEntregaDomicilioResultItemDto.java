package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PtrVentaOnlineEntregaDomicilioResultItemDto implements Serializable {
    
    private static final long serialVersionUID = -3536933437981318182L;
    
    @NotBlank
    private String fecha;

    private Integer pais;

    private Integer cadena;

    private Integer empresa;

    private Integer seccion;
    
    private Integer temporada;

    private Integer producto;

    @NotNull
    private BigDecimal importeSinIVA;

    @NotNull
    private BigDecimal importeConIVA;

}
