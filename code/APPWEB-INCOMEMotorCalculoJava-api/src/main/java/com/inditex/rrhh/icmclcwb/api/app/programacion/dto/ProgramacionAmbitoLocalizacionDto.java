package com.inditex.rrhh.icmclcwb.api.app.programacion.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProgramacionAmbitoLocalizacionDto implements Serializable {

  private static final long serialVersionUID = -563223233620448631L;

  private Long id;

  private Long idProgramacionAmbito;

  @NotBlank
  private String cclIdOrigen;

  @NotBlank
  private String stdIdLegEnt;

  @NotBlank
  private String stdIdWorkLocat;

}
