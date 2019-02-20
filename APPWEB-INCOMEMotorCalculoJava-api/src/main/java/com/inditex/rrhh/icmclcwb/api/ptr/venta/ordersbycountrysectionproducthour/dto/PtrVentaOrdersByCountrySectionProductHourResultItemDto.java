package com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountrysectionproducthour.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class PtrVentaOrdersByCountrySectionProductHourResultItemDto implements Serializable{
    
    private static final long serialVersionUID = -3254406245586037986L;

    private Integer pais;
    
    private Integer seccion;
    
    private Integer producto;
    
    private String fechaLocal;
    
    private Integer horaLocal;
    
    private Long unidades;
    
    private BigDecimal importeEuros;
}
