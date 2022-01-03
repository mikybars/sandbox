package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaPersonaEstructuraDesplazamientoRealDto implements Serializable {

  @ApiModelProperty(value = "Identificador de la persona estructura desplazamiento", required = false)
  private String id;

  @NotNull
  @ApiModelProperty(value = "Identificador del tarea", required = true)
  private Long idTarea;

  @NotNull
  @ApiModelProperty(value = "Fecha de inicio en la estructura", required = true)
  private LocalDateTime fechaInicio;

  @NotNull
  @ApiModelProperty(value = "Fecha de fin en la estructura", required = true)
  private LocalDateTime fechaFin;

  @NotBlank
  @ApiModelProperty(value = "Id origen", required = true)
  private String cclIdOrigen;

  @NotBlank
  @ApiModelProperty(value = "Id de la persona", required = true)
  private String stdIdHr;

  @NotBlank
  @ApiModelProperty(value = "Ordinal de la persona", required = true)
  private String stdOrHrPeriod;

  @NotBlank
  @ApiModelProperty(value = "Id estructura", required = true)
  private String icmIdEstrComision;

  @NotBlank
  @ApiModelProperty(value = "Id estructura padre", required = true)
  private String icmIdEstrComisionPadre;

  @NotBlank
  @ApiModelProperty(value = "Id estructura base", required = true)
  private String icmIdEstrComisionBase;

  @NotBlank
  @ApiModelProperty(value = "Id estructura del ambito", required = true)
  private String icmIdEstructuraAmbito;

  @NotNull
  @ApiModelProperty(value = "Fecha inicio periodo", required = true)
  private LocalDate fechaInicioPeriodo;

}
