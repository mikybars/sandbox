package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaLocalizacionPersonaPresenciaDto implements Serializable {

  private static final long serialVersionUID = -5245069232542882963L;

  private String id;

  @NotNull
  private Long idTarea;

  @NotNull
  private Long cclIdCodOrigen;

  @NotNull
  private Long cclIdPerson;

  @NotNull
  private Long cclIdOrigen;

  @NotNull
  private Long stdIdLegEnt;

  @NotNull
  private Long cclIdSeccion;

  @NotNull
  private Date fecha;

  @NotNull
  private Long minutos;

  private Integer idTipoHora;

  private Boolean activo;

}
