package com.inditex.rrhh.icmclcwb.api.ptr.venta.acumuladadia.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PtrObtenerVentaAcumuladaDiaRequestDto implements Serializable {

  private static final long serialVersionUID = 3377217196984804178L;

  private String fecha;

  private List<Integer> cadena;

  private List<Integer> pais;

  private Integer online;

  private Integer ventaComercial;

}
