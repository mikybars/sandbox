package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PtrVentaOnlineEntregaTiendaResponseDto implements Serializable {

  private static final long serialVersionUID = -5623067063367409066L;

  private List<PtrVentaOnlineEntregaTiendaResultItemDto> ventaOnline;

}
