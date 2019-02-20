package com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountryhour.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PtrVentaOrdersByCountryHourResponseDto implements Serializable {
    
    private static final long serialVersionUID = 7153678230010926232L;

    private List<PtrVentaOrdersByCountryHourResultItemDto> ordersByCountryHour;
    
}
