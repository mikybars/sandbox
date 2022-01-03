package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaAgrupacionCadenaDto implements Serializable {

  private static final long serialVersionUID = -8140438304912881020L;

  private String id;

  @NotNull
  @ApiModelProperty(value = "Identificador del tarea", required = true)
  private Long idTarea;

  @NotBlank
  @ApiModelProperty(value = "Id origen", required = true)
  private String cclIdOrigen;

  @NotBlank
  @ApiModelProperty(value = "Id de la agrupacion", required = true)
  private String icmIdAgrupacionOnline;

  @NotBlank
  @ApiModelProperty(value = "Id de la cadena", required = true)
  private String cclIdCadena;

}
