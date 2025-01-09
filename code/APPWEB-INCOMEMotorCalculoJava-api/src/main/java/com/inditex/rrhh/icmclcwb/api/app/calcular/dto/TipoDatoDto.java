package com.inditex.rrhh.icmclcwb.api.app.calcular.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Data
public class TipoDatoDto implements Serializable {

  private static final long serialVersionUID = 4954299427450653405L;

  private String id;

  @NotBlank
  private String nombre;

  @NotBlank
  private String descripcion;

  @NonNull
  private Boolean procesado;

}
