package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PtrVentaOnlineIpodIndividualDetalleResponseDto implements Serializable {

  private static final long serialVersionUID = 6756901438066414276L;

  private List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> ventaOnlineIpodIndividual;

}
