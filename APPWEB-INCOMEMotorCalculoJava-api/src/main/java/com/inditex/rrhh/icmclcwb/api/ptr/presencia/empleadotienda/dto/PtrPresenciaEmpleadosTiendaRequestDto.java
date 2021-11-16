package com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@ApiModel
public class PtrPresenciaEmpleadosTiendaRequestDto {

  @ApiModelProperty(value = "Fecha inicio rango", required = false, example = "2018-01-01")
  private String fechaDesde;

  @ApiModelProperty(value = "Fecha fin rango", required = false, example = "2018-10-31")
  private String fechaHasta;

  @NotNull
  @ApiModelProperty(value = "Id origen", required = true, example = "11")
  private Integer origen;

  @ApiModelProperty(value = "Id empresa", required = false, example = "[1]")
  private List<Integer> empresa;

  @ApiModelProperty(value = "Id cadena", required = false, example = "[8]")
  private List<Integer> cadena;

  @ApiModelProperty(value = "Id tienda", required = false, example = "[1000]")
  private List<Integer> tienda;

  @ApiModelProperty(value = "Tipo", required = false, example = "[1]")
  private List<Integer> tipo;

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

}
