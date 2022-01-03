package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaAmbitoGlobalLocalizacionPersonaDto implements Serializable {

  private static final long serialVersionUID = 448147217269076424L;

  @ApiModelProperty(value = "Identificador de la tabla localizacion persona", required = false)
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
