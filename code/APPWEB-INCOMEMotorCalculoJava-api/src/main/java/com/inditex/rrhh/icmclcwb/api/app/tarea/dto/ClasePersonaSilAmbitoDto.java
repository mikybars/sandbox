package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClasePersonaSilAmbitoDto implements Serializable {

  @NotBlank
  private String cclIdOrigen;

  @NotBlank
  private Integer clase;

  private Integer estado;

}
