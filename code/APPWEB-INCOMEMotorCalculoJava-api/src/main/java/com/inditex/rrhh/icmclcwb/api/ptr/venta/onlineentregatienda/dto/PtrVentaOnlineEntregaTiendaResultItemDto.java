package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrSeccionVentaOnlineGenericType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PtrVentaOnlineEntregaTiendaResultItemDto implements Serializable {

  private static final long serialVersionUID = 6505538499356493218L;

  @NotBlank
  private String fecha;

  private Integer pais;

  private Integer cadena;

  private Integer tienda;

  private Integer seccion;

  private Integer empresa;

  private String ano;

  @NotNull
  private BigDecimal importeSinIVA;

  @NotNull
  private BigDecimal importeConIVA;

  private List<PtrSeccionVentaOnlineGenericType> listaSeccion;

}
