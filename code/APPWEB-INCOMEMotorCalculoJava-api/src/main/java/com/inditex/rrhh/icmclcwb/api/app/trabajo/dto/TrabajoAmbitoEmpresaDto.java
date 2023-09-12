package com.inditex.rrhh.icmclcwb.api.app.trabajo.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import javax.validation.constraints.NotBlank;
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

  @ApiModelProperty(value = "Identificador del ambito empresa del trabajo", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true)
  private Long id;

  @ApiModelProperty(value = "Identificador del ambito del trabajo", required = false,
      accessMode = AccessMode.READ_ONLY, hidden = true)
  private Long idTrabajo;

  @NotBlank
  @ApiModelProperty(value = "Id de la empresa", required = true, example = "8")
  private String stdIdLegEnt;

}
