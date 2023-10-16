package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrSeccionVentaOnlineGenericType;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PtrVentaOnlineIpodIndividualDetalleResultItemDto implements Serializable {

  private static final long serialVersionUID = -2372872440652586406L;

  @NotBlank
  private String fecha;

  private Integer pais;

  private Integer cadena;

  private Integer empresa;

  private Integer tienda;

  private Integer seccion;

  private Integer vendedor;

  private String operacion;

  private BigDecimal importeSinIVA;

  private BigDecimal importeConIVA;

  private List<PtrSeccionVentaOnlineGenericType> listaSeccion;

}
