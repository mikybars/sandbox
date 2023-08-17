package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaLocalizacionEstadoDto implements Serializable {

  private static final long serialVersionUID = 5015061072450952695L;

  @ApiModelProperty(value = "Identificador del registro", required = false)
  private String id;

  @NotNull
  @ApiModelProperty(value = "Identificador del tarea", required = true)
  private Long idTarea;

  @NotBlank
  private String stdIdWorkLocat;

  @NotBlank
  private String cclIdOrigen;

  @NotBlank
  private String stdIdLegEnt;

  @NotBlank
  private String cclIdSeccion;

  @NotBlank
  private String icmIdEstado;

  @NotNull
  private LocalDateTime fechaInicio;

  @NotNull
  private LocalDateTime fechaFin;

}
