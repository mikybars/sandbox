package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PtrVentaOnlineEntregaDomicilioResponseDto implements Serializable {

  private static final long serialVersionUID = 6070103309607193015L;

  private List<PtrVentaOnlineEntregaDomicilioResultItemDto> ventaOnline;

}
