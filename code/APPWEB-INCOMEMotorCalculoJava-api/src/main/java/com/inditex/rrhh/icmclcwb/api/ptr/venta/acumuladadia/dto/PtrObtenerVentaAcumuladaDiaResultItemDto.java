package com.inditex.rrhh.icmclcwb.api.ptr.venta.acumuladadia.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class PtrObtenerVentaAcumuladaDiaResultItemDto implements Serializable {

  private static final long serialVersionUID = 6619507851644640967L;

  private Integer pais;

  private Integer cadena;

  private Integer tienda;

  private BigDecimal importeVenta;

  private BigDecimal importeDevolucion;

}
