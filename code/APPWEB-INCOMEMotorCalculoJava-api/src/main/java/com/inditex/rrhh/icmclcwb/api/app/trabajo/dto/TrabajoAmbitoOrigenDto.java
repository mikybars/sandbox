package com.inditex.rrhh.icmclcwb.api.app.trabajo.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrabajoAmbitoOrigenDto implements Serializable {

  private static final long serialVersionUID = -2883395513238054874L;

  private Long id;

  private Long idTrabajo;

  @NotBlank
  private String cclIdOrigen;

}
