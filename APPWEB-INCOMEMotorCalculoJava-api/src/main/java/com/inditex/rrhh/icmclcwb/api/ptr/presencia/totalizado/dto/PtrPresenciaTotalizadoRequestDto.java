package com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PtrPresenciaTotalizadoRequestDto implements Serializable {

  private static final long serialVersionUID = 3550793312992226985L;

  @ApiModelProperty(value = "Id tienda", required = false, allowableValues = "8102")
  private List<Integer> tienda;

  @ApiModelProperty(value = "Fecha inico Rango", required = false, example = "2018-05-01")
  private String fechaDesde;

  @ApiModelProperty(value = "Fecha fin rango", required = false, example = "2018-10-31")
  private String fechaHasta;

  @ApiModelProperty(value = "Id tipo", required = false, example = "1")
  private Integer tipo;

  @ApiModelProperty(value = "Id cadena", required = false, example = "[8]")
  private List<Integer> cadena;

  @NotNull
  @ApiModelProperty(value = "Id origen", required = true, example = "11")
  private Integer origen;

  @ApiModelProperty(value = "Id empresa", required = false, example = "[1]")
  private List<Integer> empresa;

  @ApiModelProperty(value = "Flag incluido venta", required = false, example = "true")
  private Boolean incluidoVenta;

  @ApiModelProperty(value = "Flag incluido challenge", required = false, example = "true")
  private Boolean incluidoChallenge;

  @ApiModelProperty(value = "Flag incluido ecommerce", required = false, example = "true")
  private Boolean incluidoEcommerce;

  @ApiModelProperty(value = "Flag excluido calculo", required = false, example = "true")
  private Boolean excluidoCalculo;

  @ApiModelProperty(value = "Flag excluido denominador", required = false, example = "true")
  private Boolean excluidoDenom;

  @ApiModelProperty(value = "Agrupacion", required = false, allowableValues = "TIENDA, TIENDA_PERSONA")
  private String agrupacion;

  @ApiModelProperty(value = "Pivotado seccion (1/0)", required = true, example = "1")
  private Integer agruparSeccion;

}
