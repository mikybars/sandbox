package com.inditex.rrhh.icmclcwb.api.app.programacion.dto;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProgramacionAmbitoDto implements Serializable {

  private static final long serialVersionUID = 1849277348253846970L;

  @ApiModelProperty(value = "Identificador del ambito de la programación", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true)
  private Long id;

  @ApiModelProperty(value = "Identificador de la programación", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Long idProgramacion;

  @NotBlank
  @ApiModelProperty(value = "Id de la sociedad", required = true, example = "0001")
  private String idOrganization;

  @ApiModelProperty(value = "Ambito origen de la programacion", required = false)
  private List<ProgramacionAmbitoOrigenDto> origen;

  @ApiModelProperty(value = "Ambito empresa de la programacion", required = false)
  private List<ProgramacionAmbitoEmpresaDto> empresa;

  @ApiModelProperty(value = "Ambito persona de la programacion", required = false)
  private List<ProgramacionAmbitoPersonaDto> persona;

  @ApiModelProperty(value = "Ambito localizacion de la programacion", required = false)
  private List<ProgramacionAmbitoLocalizacionDto> localizacion;

}
