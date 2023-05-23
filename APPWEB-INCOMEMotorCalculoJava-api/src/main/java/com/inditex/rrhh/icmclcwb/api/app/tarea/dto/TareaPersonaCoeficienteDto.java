package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaPersonaCoeficienteDto implements Serializable {

  private static final long serialVersionUID = 2150494287535837812L;

  @ApiModelProperty(value = "Identificador de la entidad", required = false)
  private String id;

  @NotNull
  @ApiModelProperty(value = "Identificador del tarea", required = true)
  private Long idTarea;

  @NotBlank
  @ApiModelProperty(value = "Identificador de la persona local", required = true)
  private String cclIdPerson;

  @NotBlank
  @ApiModelProperty(value = "Identificador de la persona", required = true)
  private String stdIdHr;

  @NotBlank
  @ApiModelProperty(value = "Ordinal de la persona", required = true)
  private String stdOrHrPeriod;

  @NotNull
  private Date fechaInicioPar;

  @NotNull
  private Date fechaFinPar;

  @NotNull
  private Date fechaInicioCom;

  @NotNull
  private Date fechaFinCom;

  @NotNull
  @ApiModelProperty(value = "Coeficiente jornada", required = true)
  private BigDecimal coeficiente;

}
