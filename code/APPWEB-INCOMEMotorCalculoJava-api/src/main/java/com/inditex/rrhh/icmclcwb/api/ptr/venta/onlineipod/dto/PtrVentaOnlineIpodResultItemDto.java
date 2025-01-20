package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrSeccionVentaOnlineGenericType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PtrVentaOnlineIpodResultItemDto implements Serializable {

  private static final long serialVersionUID = 1551558406985467960L;

  @NotBlank
  private String fecha;

  private Integer pais;

  private Integer cadena;

  private Integer tienda;

  private Integer empresa;

  private Integer seccion;

  private String ano;

  @NotNull
  private BigDecimal importeSinIVA;

  @NotNull
  private BigDecimal importeConIVA;

  private List<PtrSeccionVentaOnlineGenericType> listaSeccion;

}
