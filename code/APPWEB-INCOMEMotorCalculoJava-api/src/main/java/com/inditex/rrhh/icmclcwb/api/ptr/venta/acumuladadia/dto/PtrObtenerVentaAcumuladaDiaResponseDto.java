package com.inditex.rrhh.icmclcwb.api.ptr.venta.acumuladadia.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PtrObtenerVentaAcumuladaDiaResponseDto implements Serializable {

  private static final long serialVersionUID = 6559946068310673307L;

  private List<PtrObtenerVentaAcumuladaDiaResultItemDto> datoVentaTienda;

}
