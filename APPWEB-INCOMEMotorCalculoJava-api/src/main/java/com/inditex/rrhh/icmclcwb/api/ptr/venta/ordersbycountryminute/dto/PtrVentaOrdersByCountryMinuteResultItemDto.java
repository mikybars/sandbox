package com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountryminute.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class PtrVentaOrdersByCountryMinuteResultItemDto implements Serializable{
    
    private static final long serialVersionUID = 3385389086722155727L;

    private Integer pais;
    
    private String fechaLocal;
    
    private Integer horaLocal;
    
    private Integer minuto;
    
    private Long numPedidos;
    
    private Long unidades;
    
    private BigDecimal importeEuros;
}
