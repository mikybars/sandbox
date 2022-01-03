package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaLocalizacionComisionHistoricoDto implements Serializable {

  private static final long serialVersionUID = -3399439349202382151L;

  @ApiModelProperty(value = "Identificador de la tienda", required = false)
  private Long id;

  @NotNull
  @ApiModelProperty(value = "Identificador del tarea", required = true)
  private Long idTarea;

  @NotBlank
  @ApiModelProperty(value = "Id de la localizacion", required = true)
  private String cclIdCodOrigen;

  @NotBlank
  private String stdIdWorkLocat;

  @NotNull
  private LocalDateTime fechaInicio;

  @NotNull
  private LocalDateTime fechaFin;

  @NotNull
  private Boolean comisionable;

}
