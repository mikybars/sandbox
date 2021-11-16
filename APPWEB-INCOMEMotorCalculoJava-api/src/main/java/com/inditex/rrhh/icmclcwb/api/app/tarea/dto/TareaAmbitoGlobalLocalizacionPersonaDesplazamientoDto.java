package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaAmbitoGlobalLocalizacionPersonaDesplazamientoDto implements Serializable {

  private static final long serialVersionUID = 8643089032888418145L;

  @ApiModelProperty(value = "Identificador de la tabla tienda abierta", required = false)
  private String id;

  @NotNull
  @ApiModelProperty(value = "Identificador del tarea", required = true)
  private Long idTarea;

  @NotBlank
  @ApiModelProperty(value = "Identificador de la tienda", required = true)
  private String stdIdWorkLocat;

  @NotBlank
  @ApiModelProperty(value = "Identificador de la persona", required = true)
  private String cclIdPerson;

  @NotBlank
  @ApiModelProperty(value = "Identificador del origen", required = true)
  private String cclIdOrigen;

  @NotBlank
  @ApiModelProperty(value = "Identificador de la empresa", required = true)
  private String stdIdLegEnt;

}
