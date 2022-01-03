package com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PtrPresenciaDetalleRequestDto implements Serializable {

  private static final long serialVersionUID = 2089515262512038387L;

  @ApiModelProperty(value = "Id tienda", required = false, example = "160")
  private List<Integer> tienda;

  @ApiModelProperty(value = "Id seccion", required = false, example = "1")
  private Integer seccion;

  @ApiModelProperty(value = "Id empleados", required = false, allowableValues = "1645")
  private List<Integer> persona;

  @ApiModelProperty(value = "Fecha inicio rango", required = false, example = "2017-01-01")
  private String fechaDesde;

  @ApiModelProperty(value = "Fecha final rango", required = false, example = "2017-12-31")
  private String fechaHasta;

  @ApiModelProperty(value = "Id tipo hora", required = false, example = "1")
  private List<Integer> tipo;

  @ApiModelProperty(value = "Id cadena", required = true, example = "[8]")
  private List<Integer> cadena;

  @ApiModelProperty(value = "Id empresa", required = true, example = "[1]")
  private List<Integer> empresa;

  @NotNull
  @ApiModelProperty(value = "Id Origen", required = false, example = "11")
  private Integer origen;

  @ApiModelProperty(value = "Flag incluido venta", required = false, example = "true")
  private Boolean incluidoVenta;

  @ApiModelProperty(value = "Flag incluido challenge", required = false, example = "true")
  private Boolean incluidoChallenge;

  @ApiModelProperty(value = "Flag incluido ecommerce", required = false, example = "true")
  private Boolean incluidoEcommerce;

  @ApiModelProperty(value = "Flag excluído denominador", required = false, example = "true")
  private Boolean excluidoDenom;

  @ApiModelProperty(value = "Flag excluído calculo", required = false, example = "true")
  private Boolean excluidoCalculo;

  @ApiModelProperty(value = "Agrupacion", required = false, example = "FECHA_TIENDA")
  private String agrupacion;

  @ApiModelProperty(value = "Pivotado seccion (1/0)", required = true, example = "1")
  private Integer agruparSeccion;

}
