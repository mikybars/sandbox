package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaPersonaHistoricoDto implements Serializable {

  private static final long serialVersionUID = 1168987218682802281L;

  private String id;

  @NotNull
  private Long idTarea;

  @NotBlank
  private String stdIdHr;

  private String stdOrHrPeriod;

  private String cclIdPerson;

  private String cclIdCodOrigen;

  private String stdIdWorkLocat;

  private String cclIdOrigen;

  private String cclIdSeccion;

  private Date fechaInicio;

  private Date fechaFin;

  private Date fechaInicioSeccion;

  private Date fechaFinSeccion;

  private Date fechaInicioLocalizacion;

  private Date fechaFinLocalizacion;

  private Date fechaInicioPeriodo;

  private Date fechaAntiguedad;

  @NotNull
  private Long stdIdLegEnt;

}
