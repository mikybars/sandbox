package com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupSellerTypeEnum;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PtrVentaIndividualDetalleRequestDto implements Serializable {

  private static final long serialVersionUID = -3408775260498412294L;

  @ApiModelProperty(value = "Fecha inicio rango de busqueda", required = true, example = "2017-01-01")
  @NotNull
  private String fechaDesde;

  @ApiModelProperty(value = "Fecha fin rango de busqueda", required = true, example = "2017-12-31")
  @NotNull
  private String fechaHasta;

  @ApiModelProperty(value = "Id de pais", required = true, example = "11")
  @NotNull
  private Integer pais;

  @ApiModelProperty(value = "Id cadena", required = false, example = "1")
  private Integer cadena;

  @ApiModelProperty(value = "Id empresa", required = false, example = "1")
  private List<Integer> empresa;

  @ApiModelProperty(value = "Listado de ids de tiendas", required = false, example = "[57, 691]")
  private List<Integer> tienda = new ArrayList<>();

  @ApiModelProperty(value = "Listado de ids de seccion", required = false, example = "[1]")
  private List<Integer> seccion;

  @ApiModelProperty(value = "Id temporada", required = false, example = "1")
  private Integer temporada;

  @ApiModelProperty(value = "Id producto", required = false, example = "1")
  private List<Integer> producto;

  @ApiModelProperty(value = "Listado de ids de vendedores", required = false, example = "[1, 2]")
  private List<Integer> vendedores = new ArrayList<>();

  @ApiModelProperty(value = "Fecha venta inicial", required = false, example = "2017-12-31")
  private String fechaVentaInicial;

  @ApiModelProperty(value = "Id de cajero", required = false, example = "1")
  private Integer cajero;

  @ApiModelProperty(value = "Id de operacion", required = false, example = "V")
  private String operacion;

  @ApiModelProperty(value = "Agrupación de datos", required = false, example = "FECHA_TIENDA")
  private PtrGroupSellerTypeEnum agrupacion;

  @ApiModelProperty(value = "Agrupar seccion flag (pivotado)", required = false, example = "1")
  private Integer agruparSeccion;

}
