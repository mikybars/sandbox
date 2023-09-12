package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrSeccionVentaOnlineGenericType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PtrVentaOnlinePickingResultItemDto implements Serializable {

  private static final long serialVersionUID = 6070689891574921909L;

  @NotBlank
  private String fecha;

  private Integer pais;

  private Integer cadena;

  private Integer empresa;

  private Integer seccion;

  private Integer tienda;

  @NotNull
  private BigDecimal importeSinIVA;

  @NotNull
  private BigDecimal importeConIVA;

  private String ano;

  private List<PtrSeccionVentaOnlineGenericType> listaSeccion;

}
