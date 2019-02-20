package com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountryminute.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PtrVentaOrdersByCountryMinuteResponseDto implements Serializable {
    
    private static final long serialVersionUID = 7153678230010926232L;

    private List<PtrVentaOrdersByCountryMinuteResultItemDto> ordersByCountryMinute;
    
}
