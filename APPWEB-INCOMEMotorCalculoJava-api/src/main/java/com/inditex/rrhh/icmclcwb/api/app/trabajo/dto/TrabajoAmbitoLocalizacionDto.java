package com.inditex.rrhh.icmclcwb.api.app.trabajo.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrabajoAmbitoLocalizacionDto implements Serializable {

  private static final long serialVersionUID = -3060137115571011963L;

  @ApiModelProperty(value = "Identificador del ambito localizacion del trabajo", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true)
  private Long id;

  @ApiModelProperty(value = "Identificador del ambito del trabajo", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true)
  private Long idTrabajo;

  @NotBlank
  @ApiModelProperty(value = "Id de la sociedad", required = true, example = "11")
  private String cclIdOrigen;

  @NotBlank
  @ApiModelProperty(value = "Id de la empresa", required = true, example = "8")
  private String stdIdLegEnt;

  @NotBlank
  @ApiModelProperty(value = "Id de la localizacion", required = true, example = "T57")
  private String stdIdWorkLocat;

}
