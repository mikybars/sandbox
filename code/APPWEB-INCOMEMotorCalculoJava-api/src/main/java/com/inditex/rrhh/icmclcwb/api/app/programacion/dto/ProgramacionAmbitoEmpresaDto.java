package com.inditex.rrhh.icmclcwb.api.app.programacion.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProgramacionAmbitoEmpresaDto implements Serializable {

  private static final long serialVersionUID = -9010084229574837046L;

  private Long id;

  private Long idProgramacionAmbito;

  @NotBlank
  private String stdIdLegEnt;

}
