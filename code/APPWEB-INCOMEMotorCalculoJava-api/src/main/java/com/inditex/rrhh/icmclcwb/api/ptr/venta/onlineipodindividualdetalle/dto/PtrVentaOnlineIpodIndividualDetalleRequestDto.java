package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto;

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
public class PtrVentaOnlineIpodIndividualDetalleRequestDto implements Serializable {

  private static final long serialVersionUID = -7476782901000109281L;

  @NotNull
  private String fechaDesde;

  @NotNull
  private String fechaHasta;

  private Integer pais;

  private Integer cadena;

  private List<Integer> empresa;

  private List<Integer> tiendaOnline = new ArrayList<>();

  private List<Integer> tienda = new ArrayList<>();

  private List<Integer> seccion = new ArrayList<>();

  private List<Integer> vendedores = new ArrayList<>();

  private List<Integer> producto = new ArrayList<>();

  private String operacion;

  private PtrGroupSellerTypeEnum agrupacion;

  private Integer agruparSeccion;

}
