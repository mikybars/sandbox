package com.inditex.rrhh.icmclcwb.api.app.trabajo.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrabajoAmbitoPersonaDto implements Serializable {

  private static final long serialVersionUID = 3468264496961245295L;

  private Long id;

  private Long idTrabajo;

  @NotBlank
  private String cclIdOrigen;

  @NotBlank
  private String stdIdLegEnt;

  @NotBlank
  private String cclIdPerson;

  @NotBlank
  private String stdOrHrPeriod;

}
