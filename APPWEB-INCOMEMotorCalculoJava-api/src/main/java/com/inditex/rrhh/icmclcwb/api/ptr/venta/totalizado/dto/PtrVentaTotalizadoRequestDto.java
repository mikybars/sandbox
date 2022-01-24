package com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PtrVentaTotalizadoRequestDto implements Serializable {

  private static final long serialVersionUID = -529195772706345954L;

  @ApiModelProperty(value = "Fecha inicio rango de busqueda", required = false, example = "2017-01-01")
  @NotNull
  private String fechaDesde;

  @ApiModelProperty(value = "Fecha fin rango de busqueda", required = false, example = "2017-12-31")
  @NotNull
  private String fechaHasta;

  @ApiModelProperty(value = "Id de pais", required = false, example = "11")
  @NotNull
  private Integer pais;

  @ApiModelProperty(value = "Id cadena", required = true, example = "1")
  private List<Integer> cadena;

  @ApiModelProperty(value = "Listado de ids de tiendas", required = false, example = "[57, 691]")
  private List<Integer> tienda = new ArrayList<>();

  @ApiModelProperty(value = "Listado de ids de seccion", required = false, example = "[1]")
  private List<Integer> seccion;

  @ApiModelProperty(value = "Id de temporada", required = false, example = "1")
  private Integer temporada;

  @ApiModelProperty(value = "Id de producto", required = false, example = "1")
  private List<Integer> producto;

  @ApiModelProperty(value = "Id empresa", required = false, example = "1")
  private List<Integer> empresa;

  @ApiModelProperty(value = "Agrupar seccion flag (pivotado)", required = false, example = "1")
  private Integer agruparSeccion;

  @ApiModelProperty(value = "Agrupación de datos", required = false, example = "FECHA_TIENDA")
  private PtrGroupTypeEnum agrupacion;

  @ApiModelProperty(value = "Operacion a consultar", required = false, example = "V")
  private String operacion;

}
