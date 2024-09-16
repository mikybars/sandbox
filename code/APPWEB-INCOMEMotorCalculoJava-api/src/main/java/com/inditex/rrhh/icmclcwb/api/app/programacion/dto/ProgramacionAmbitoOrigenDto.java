package com.inditex.rrhh.icmclcwb.api.app.programacion.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProgramacionAmbitoOrigenDto implements Serializable {

  private static final long serialVersionUID = -8984709221086991081L;

  private Long id;

  private Long idProgramacionAmbito;

  @NotBlank
  private String cclIdOrigen;

}
