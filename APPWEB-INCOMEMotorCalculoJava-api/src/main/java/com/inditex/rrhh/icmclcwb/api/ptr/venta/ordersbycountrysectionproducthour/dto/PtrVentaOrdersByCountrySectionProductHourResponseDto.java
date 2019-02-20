package com.inditex.rrhh.icmclcwb.api.ptr.venta.ordersbycountrysectionproducthour.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PtrVentaOrdersByCountrySectionProductHourResponseDto implements Serializable {
    
    private static final long serialVersionUID = -37667061994292070L;
   
    private List<PtrVentaOrdersByCountrySectionProductHourResultItemDto> ordersByCountrySectionProductHour;
    
}
