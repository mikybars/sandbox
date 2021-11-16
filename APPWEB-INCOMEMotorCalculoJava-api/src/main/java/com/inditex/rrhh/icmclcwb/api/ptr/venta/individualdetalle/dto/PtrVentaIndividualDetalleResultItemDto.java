package com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrSeccionVentaOnlineGenericType;

import lombok.Data;

@Data
public class PtrVentaIndividualDetalleResultItemDto implements Serializable {

  private static final long serialVersionUID = -801740758955645983L;

  private String fecha;

  private Integer pais;

  private Integer cadena;

  private Integer empresa;

  private Integer tienda;

  private Integer seccion;

  private Integer temporada;

  private Integer producto;

  private BigDecimal importeSinIVA;

  private BigDecimal importeConIVA;

  private Integer vendedor;

  private String fechaVentaInicial;

  private Integer cajero;

  private String operacion;

  private List<PtrSeccionVentaOnlineGenericType> listaSeccion;

}
