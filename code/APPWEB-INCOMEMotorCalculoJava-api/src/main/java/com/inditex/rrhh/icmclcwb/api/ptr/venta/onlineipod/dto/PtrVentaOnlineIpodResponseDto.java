package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PtrVentaOnlineIpodResponseDto implements Serializable {

  private static final long serialVersionUID = 6756901438066414276L;

  private List<PtrVentaOnlineIpodResultItemDto> ventaOnline;

  private List<PtrVentaOnlineIpodResultItemDto> ventaOnlineiPod;

  private List<PtrVentaOnlineIpodResultItemDto> ventaOnlineiPodIndividualDetalle;
}
