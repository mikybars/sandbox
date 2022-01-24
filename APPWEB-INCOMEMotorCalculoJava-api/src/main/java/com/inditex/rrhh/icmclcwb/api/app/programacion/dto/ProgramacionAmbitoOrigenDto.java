package com.inditex.rrhh.icmclcwb.api.app.programacion.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProgramacionAmbitoOrigenDto implements Serializable {

  private static final long serialVersionUID = -8984709221086991081L;

  @ApiModelProperty(value = "Identificador del ambito origen de la programación", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true)
  private Long id;

  @ApiModelProperty(value = "Identificador del ambito de la programación", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true)
  private Long idProgramacionAmbito;

  @NotBlank
  @ApiModelProperty(value = "Id de la sociedad", required = true, example = "11")
  private String cclIdOrigen;

}
