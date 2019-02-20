package com.inditex.rrhh.icmclcwb.api.ptr.venta.acumulada.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class PtrObtenerVentaAcumuladaResultItemDto implements Serializable {
    
    private static final long serialVersionUID = -178370816092107798L;

    private Integer pais;
    
    private Integer cadena;
    
    private Integer tienda;
    
    private BigDecimal importeVenta;

    private BigDecimal importeDevolucion;
    
}
