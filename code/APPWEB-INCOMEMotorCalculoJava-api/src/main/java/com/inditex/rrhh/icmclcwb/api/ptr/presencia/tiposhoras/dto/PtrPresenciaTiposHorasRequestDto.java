package com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto;

import java.io.Serializable;

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
public class PtrPresenciaTiposHorasRequestDto implements Serializable {

  private static final long serialVersionUID = 8473916136604243658L;

  @NotNull
  @ApiModelProperty(value = "Id origen", required = false, example = "11")
  private Integer origen;

  @ApiModelProperty(value = "Id tipo hora", required = false, example = "1")
  private Integer tipoHora;

  @ApiModelProperty(value = "Id catalogo", required = false, example = "1")
  private Integer idCatalogoAplicacion;

  @ApiModelProperty(value = "Flag incluido venta", required = false, example = "true")
  private Boolean incluidoVenta;

  @ApiModelProperty(value = "Flag incluido challenge", required = false, example = "true")
  private Boolean incluidoChallenge;

  @ApiModelProperty(value = "Flag incluido ecommerce", required = false, example = "true")
  private Boolean incluidoEcommerce;

  @ApiModelProperty(value = "Excluido denonimandor", required = false, example = "true")
  private Boolean excluidoDenom;

  @ApiModelProperty(value = "Excluido calculo", required = false, example = "false")
  private Boolean excluidoCalculo;

}
