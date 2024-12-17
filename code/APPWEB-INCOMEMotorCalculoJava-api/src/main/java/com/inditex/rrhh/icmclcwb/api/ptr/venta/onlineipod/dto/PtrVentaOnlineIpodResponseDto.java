package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PtrVentaOnlineIpodResponseDto implements Serializable {

  private static final long serialVersionUID = 6756901438066414276L;

  private List<PtrVentaOnlineIpodResultItemDto> ventaOnline;

}
