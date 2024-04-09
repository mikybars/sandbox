package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaLocalizacionCalcularDto implements Serializable {

  private static final long serialVersionUID = -4214642811887214050L;

  private String id;

  @NotNull
  private Long idTarea;

  @NotNull
  private Long cclIdCodOrigen;

  @NotNull
  private Long stdIdWorkLocat;

  @NotNull
  private Date fechaInicio;

  @NotNull
  private Date fechaFin;

  @NotNull
  private Boolean calcula;

}
