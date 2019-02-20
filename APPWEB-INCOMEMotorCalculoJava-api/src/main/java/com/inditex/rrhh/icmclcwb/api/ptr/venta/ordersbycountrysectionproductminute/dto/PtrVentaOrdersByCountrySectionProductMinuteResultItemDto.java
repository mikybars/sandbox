package com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountrysectionproductminute.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class PtrVentaOrdersByCountrySectionProductMinuteResultItemDto implements Serializable{
    
    private static final long serialVersionUID = 4601451569243147526L;

    private Integer pais;
    
    private Integer seccion;
    
    private Integer producto;
    
    private String fechaLocal;
    
    private Integer horaLocal;
    
    private Integer minuto;
    
    private Long unidades;
    
    private BigDecimal importeEuros;
}
