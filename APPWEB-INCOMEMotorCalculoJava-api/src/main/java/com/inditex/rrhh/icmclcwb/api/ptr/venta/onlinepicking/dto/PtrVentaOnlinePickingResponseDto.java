package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PtrVentaOnlinePickingResponseDto implements Serializable {
    
    private static final long serialVersionUID = 2127587419294640434L;
    
    private List<PtrVentaOnlinePickingResultItemDto> ventaOnline;


}
