package com.inditex.rrhh.icmclcwb.api.app.programacion.dto;

import java.io.Serializable;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProgramacionAmbitoDto implements Serializable {

  private static final long serialVersionUID = 1849277348253846970L;

  private Long id;

  private Long idProgramacion;

  @NotBlank
  private String idOrganization;

  private List<ProgramacionAmbitoOrigenDto> origen;

  private List<ProgramacionAmbitoEmpresaDto> empresa;

  private List<ProgramacionAmbitoPersonaDto> persona;

  private List<ProgramacionAmbitoLocalizacionDto> localizacion;

}
