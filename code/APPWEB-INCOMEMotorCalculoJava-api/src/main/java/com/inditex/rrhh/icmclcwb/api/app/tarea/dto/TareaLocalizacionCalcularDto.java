package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaLocalizacionCalcularDto implements Serializable {

  private static final long serialVersionUID = -4214642811887214050L;

  @ApiModelProperty(value = "Identificador de la tabla tarea localizacion calcular", required = false)
  private String id;

  @NotNull
  @ApiModelProperty(value = "Identificador del tarea", required = true)
  private Long idTarea;

  @NotNull
  @ApiModelProperty(value = "Identificador de la localizacion", required = true)
  private Long cclIdCodOrigen;

  @NotNull
  @ApiModelProperty(value = "Identificador de la localizacion meta4", required = true)
  private Long stdIdWorkLocat;

  @NotNull
  private Date fechaInicio;

  @NotNull
  private Date fechaFin;

  @NotNull
  @ApiModelProperty(value = "Flag calcula", required = true)
  private Boolean calcula;

}
