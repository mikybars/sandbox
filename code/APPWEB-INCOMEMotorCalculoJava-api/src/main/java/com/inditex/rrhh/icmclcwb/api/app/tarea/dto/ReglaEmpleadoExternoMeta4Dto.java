package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReglaEmpleadoExternoMeta4Dto {

  @NotBlank
  private String cclIdOrigen;

  @NotBlank
  private String stdIdLegEnt;

  @NotBlank
  private Integer puesto;

  @NotBlank
  private String idOrganization;

  @NotBlank
  private Boolean esActivo;

  @NotBlank
  private String stdIdHrType;

}
