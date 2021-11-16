package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaTipoHoraDto implements Serializable {

  private static final long serialVersionUID = 1164433898866141136L;

  @ApiModelProperty(value = "Identificador de la entidad", required = false, accessMode = AccessMode.READ_ONLY)
  private Long id;

  @NotBlank
  @ApiModelProperty(value = "Id de tipo de hora", required = true)
  private Integer idTipoHora;

  @NotNull
  @ApiModelProperty(value = "Flag excluido calculo", required = true)
  private Boolean excluidoCalculo;

  @NotNull
  @ApiModelProperty(value = "Flag excluido denominador", required = true)
  private Boolean excluidoDenominador;

  @NotNull
  @ApiModelProperty(value = "Flag incluido venta", required = true)
  private Boolean incluidoVenta;

  @NotNull
  @ApiModelProperty(value = "Flag incluido challenge", required = true)
  private Boolean incluidoChallenge;

  @NotNull
  @ApiModelProperty(value = "Flag incluido ecommerce", required = true)
  private Boolean incluidoEcommerce;

  @ApiModelProperty(value = "Flag excluido denominador y reparto provincia")
  private Boolean excluidoDenominadorYRepartidoProvincia;

  @NotNull
  @ApiModelProperty(value = "Tarea", required = true)
  private Long idTarea;

}
