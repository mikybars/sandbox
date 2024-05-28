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
public class TrabajoAmbitoEmpresaDto implements Serializable {

  private static final long serialVersionUID = -6843692680409091524L;

  private Long id;

  private Long idTrabajo;

  @NotBlank
  private String stdIdLegEnt;

}
