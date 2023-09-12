package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaPersonaAusenciaHistoricoDto implements Serializable {

  private static final long serialVersionUID = 573166701833849298L;

  @ApiModelProperty(value = "Identificador de la persona estructura politica", required = false)
  private Long id;

  @NotNull
  @ApiModelProperty(value = "Identificador del tarea", required = true)
  private Long idTarea;

  @NotBlank
  @ApiModelProperty(value = "Ordinal de la persona", required = true)
  private String stdOrHrPeriod;

  @NotBlank
  @ApiModelProperty(value = "Id local de la persona", required = true)
  private String cclIdPerson;

  @NotBlank
  @ApiModelProperty(value = "Identificador del origen", required = true)
  private String cclIdOrigen;

  @NotNull
  @ApiModelProperty(value = "Fecha de inicio de la ausencia", required = true)
  private Date fechaInicio;

  @NotNull
  @ApiModelProperty(value = "Fecha de fin de la ausencia", required = true)
  private Date fechaFin;

  @ApiModelProperty(value = "Id tipo ausencia", required = false)
  private Integer idTipoAusencia;

  @NotNull
  @ApiModelProperty(value = "Fecha inicio periodo", required = true)
  private LocalDate fechaInicioPeriodo;

}
