package com.inditex.rrhh.icmclcwb.api.app.programacion.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProgramacionAmbitoEmpresaDto implements Serializable {

  private static final long serialVersionUID = -9010084229574837046L;

  @ApiModelProperty(value = "Identificador del ambito empresa de la programación", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true)
  private Long id;

  @ApiModelProperty(value = "Identificador del ambito de la programación", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true)
  private Long idProgramacionAmbito;

  @NotBlank
  @ApiModelProperty(value = "Id de la empresa", required = true, example = "8")
  private String stdIdLegEnt;

}
