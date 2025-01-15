package com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupSellerTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PtrVentaIndividualDetalleRequestDto implements Serializable {

  private static final long serialVersionUID = -3408775260498412294L;

  @NotNull
  private String fechaDesde;

  @NotNull
  private String fechaHasta;

  @NotNull
  private Integer pais;

  private Integer cadena;

  private List<Integer> empresa;

  private List<Integer> tienda = new ArrayList<>();

  private List<Integer> seccion;

  private Integer temporada;

  private List<Integer> producto;

  private List<Integer> vendedores = new ArrayList<>();

  private String fechaVentaInicial;

  private Integer cajero;

  private String operacion;

  private PtrGroupSellerTypeEnum agrupacion;

  private Integer agruparSeccion;

}
