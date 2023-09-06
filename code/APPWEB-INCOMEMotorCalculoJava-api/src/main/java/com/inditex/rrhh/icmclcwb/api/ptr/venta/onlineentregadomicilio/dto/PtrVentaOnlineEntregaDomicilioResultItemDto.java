package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.CadenaVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrSeccionVentaOnlineGenericType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PtrVentaOnlineEntregaDomicilioResultItemDto implements Serializable, CadenaVentaResultItemDto {

  private static final long serialVersionUID = -3536933437981318182L;

  @NotBlank
  private String fecha;

  private Integer pais;

  private Integer cadena;

  private Integer empresa;

  private Integer seccion;

  private Integer tienda;

  private String ano;

  @NotNull
  private BigDecimal importeSinIVA;

  @NotNull
  private BigDecimal importeConIVA;

  private List<PtrSeccionVentaOnlineGenericType> listaSeccion;

}
