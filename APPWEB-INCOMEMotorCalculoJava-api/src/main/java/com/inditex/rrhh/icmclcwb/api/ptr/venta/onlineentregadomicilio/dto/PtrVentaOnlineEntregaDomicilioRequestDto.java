package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PtrVentaOnlineEntregaDomicilioRequestDto implements Serializable {

  private static final long serialVersionUID = 233324946532771844L;

  @ApiModelProperty(value = "Fecha inicio rango de busqueda", required = true, example = "2017-01-01")
  @NotNull
  private String fechaDesde;

  @ApiModelProperty(value = "Fecha fin rango de busqueda", required = true, example = "2017-12-31")
  @NotNull
  private String fechaHasta;

  @ApiModelProperty(value = "Id de pais", required = false, example = "11")
  private Integer pais;

  @ApiModelProperty(value = "Id cadena", required = false, example = "1")
  private List<Integer> cadena;

  @ApiModelProperty(value = "Id empresa", required = false, example = "1")
  private List<Integer> empresa;

  @ApiModelProperty(value = "Listado de ids de tiendas online", required = false, example = "['4091', '9724']")
  private List<Integer> tiendaOnline = new ArrayList<>();

  @ApiModelProperty(value = "Listado de ids de producto", required = false, example = "[1,2,3]")
  private List<Integer> producto = new ArrayList<>();

  @ApiModelProperty(value = "Id seccion", required = false, example = "1")
  private Integer seccion;

  @ApiModelProperty(value = "Agrupación de datos", required = false, example = "FECHA_TIENDA")
  private PtrGroupTypeEnum agrupacion;

  @ApiModelProperty(value = "Agrupar seccion flag (pivotado)", required = false, example = "1")
  private Integer agruparSeccion;

}
