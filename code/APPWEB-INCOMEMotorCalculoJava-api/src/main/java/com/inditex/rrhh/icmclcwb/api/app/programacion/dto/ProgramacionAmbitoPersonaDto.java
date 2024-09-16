package com.inditex.rrhh.icmclcwb.api.app.programacion.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProgramacionAmbitoPersonaDto implements Serializable {

  private static final long serialVersionUID = 7782028838666356181L;

  private Long id;

  private Long idProgramacionAmbito;

  @NotBlank
  private String cclIdOrigen;

  @NotBlank
  private String stdIdLegEnt;

  @NotBlank
  private String cclIdPerson;

  @NotBlank
  private String stdOrHrPeriod;

}
