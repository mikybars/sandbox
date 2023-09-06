package com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.CadenaVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrSeccionVentaOnlineGenericType;

import lombok.Data;

@Data
public class PtrVentaTotalizadoResultItemDto implements Serializable, CadenaVentaResultItemDto {

  private static final long serialVersionUID = -2758503405995399894L;

  private String fecha;

  private Integer pais;

  private Integer cadena;

  private Integer tienda;

  private Integer seccion;

  private Integer temporada;

  private Integer producto;

  private Integer empresa;

  private String operacion;

  private BigDecimal importeSinIVA;

  private BigDecimal importeConIVA;

  private List<PtrSeccionVentaOnlineGenericType> listaSeccion;

}
