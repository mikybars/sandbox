package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaPersonaHistoricoDto implements Serializable {

  private static final long serialVersionUID = 1168987218682802281L;

  @ApiModelProperty(value = "Identificador del empleado", required = false)
  private String id;

  @NotNull
  @ApiModelProperty(value = "Identificador del tarea", required = true)
  private Long idTarea;

  @NotBlank
  @ApiModelProperty(value = "Id de la persona", required = true)
  private String stdIdHr;

  @NotBlank
  private String stdOrHrPeriod;

  @NotBlank
  private String cclIdPerson;

  @NotBlank
  private String cclIdCodOrigen;

  @NotBlank
  private String stdIdWorkLocat;

  @NotBlank
  private String cclIdOrigen;

  @NotBlank
  private String cclIdSeccion;

  @NotNull
  private Date fechaInicio;

  @NotNull
  private Date fechaFin;

  @NotNull
  private Date fechaInicioSeccion;

  @NotNull
  private Date fechaFinSeccion;

  @NotNull
  private Date fechaInicioLocalizacion;

  @NotNull
  private Date fechaFinLocalizacion;

  @NotNull
  private Date fechaInicioPeriodo;

  private Date fechaAntiguedad;

  @NotNull
  @ApiModelProperty(value = "Identificador de la empresa", required = true)
  private Long stdIdLegEnt;

}
