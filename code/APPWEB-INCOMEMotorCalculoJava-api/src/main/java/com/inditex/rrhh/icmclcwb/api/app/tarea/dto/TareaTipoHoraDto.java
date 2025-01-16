package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaTipoHoraDto implements Serializable {

  private static final long serialVersionUID = 1164433898866141136L;

  private Long id;

  @NotBlank
  private Integer idTipoHora;

  @NotNull
  private Boolean excluidoCalculo;

  @NotNull
  private Boolean excluidoDenominador;

  @NotNull
  private Boolean incluidoVenta;

  @NotNull
  private Boolean incluidoChallenge;

  @NotNull
  private Boolean incluidoEcommerce;

  private Boolean excluidoDenominadorYRepartidoProvincia;

  @NotNull
  private Long idTarea;

}
