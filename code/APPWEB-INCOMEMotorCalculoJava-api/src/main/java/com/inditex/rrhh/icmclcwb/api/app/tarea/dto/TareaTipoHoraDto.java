package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Data
public class TareaTipoHoraDto implements Serializable {

  private static final long serialVersionUID = 1164433898866141136L;

  private Long id;

  @NotBlank
  private Integer idTipoHora;

  @NonNull
  private Boolean excluidoCalculo;

  @NonNull
  private Boolean excluidoDenominador;

  @NonNull
  private Boolean incluidoVenta;

  @NonNull
  private Boolean incluidoChallenge;

  @NonNull
  private Boolean incluidoEcommerce;

  private Boolean excluidoDenominadorYRepartidoProvincia;

  @NonNull
  private Long idTarea;

}
