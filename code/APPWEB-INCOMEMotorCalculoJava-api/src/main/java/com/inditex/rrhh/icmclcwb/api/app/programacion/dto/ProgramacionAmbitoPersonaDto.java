package com.inditex.rrhh.icmclcwb.api.app.programacion.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProgramacionAmbitoPersonaDto implements Serializable {

  private static final long serialVersionUID = 7782028838666356181L;

  @ApiModelProperty(value = "Identificador del ambito persona de la programación", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true)
  private Long id;

  @ApiModelProperty(value = "Identificador del ambito de la programación", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true)
  private Long idProgramacionAmbito;

  @NotBlank
  @ApiModelProperty(value = "Id de la sociedad", required = true, example = "11")
  private String cclIdOrigen;

  @NotBlank
  @ApiModelProperty(value = "Id de la empresa", required = true, example = "8")
  private String stdIdLegEnt;

  @NotBlank
  @ApiModelProperty(value = "Id de la empresa", required = true, example = "1000")
  private String cclIdPerson;

  @NotBlank
  @ApiModelProperty(value = "Ordinal de la persona", required = true, example = "1")
  private String stdOrHrPeriod;

}
