package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import org.jspecify.annotations.NonNull;

@Data
public class TareaLocalizacionCalcularDto implements Serializable {

  private static final long serialVersionUID = -4214642811887214050L;

  private String id;

  @NonNull
  private Long idTarea;

  @NonNull
  private Long cclIdCodOrigen;

  @NonNull
  private Long stdIdWorkLocat;

  @NonNull
  private Date fechaInicio;

  @NonNull
  private Date fechaFin;

  @NonNull
  private Boolean calcula;

}
