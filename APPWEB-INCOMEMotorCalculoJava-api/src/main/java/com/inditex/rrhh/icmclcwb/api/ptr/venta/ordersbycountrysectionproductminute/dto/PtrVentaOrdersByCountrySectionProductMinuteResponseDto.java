package com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountrysectionproductminute.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PtrVentaOrdersByCountrySectionProductMinuteResponseDto implements Serializable {
    
    private static final long serialVersionUID = 2093912150935050293L;
    
    private List<PtrVentaOrdersByCountrySectionProductMinuteResultItemDto> ordersByCountrySectionProductMinute;
    
}
