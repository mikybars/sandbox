package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto;

import java.io.Serializable;
import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@XmlRootElement(name = "VentaOnlineTiendaResponse")
@Data
public class PtrVentaOnlinePickingResponseDto implements Serializable {

  private static final long serialVersionUID = 2127587419294640434L;

  private List<PtrVentaOnlinePickingResultItemDto> ventaOnline;

}
