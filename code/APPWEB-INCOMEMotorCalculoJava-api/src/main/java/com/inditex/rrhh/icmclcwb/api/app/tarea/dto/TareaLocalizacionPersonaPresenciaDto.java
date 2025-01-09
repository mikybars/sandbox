package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import org.jspecify.annotations.NonNull;

@Data
public class TareaLocalizacionPersonaPresenciaDto implements Serializable {

  private static final long serialVersionUID = -5245069232542882963L;

  private String id;

  @NonNull
  private Long idTarea;

  @NonNull
  private Long cclIdCodOrigen;

  @NonNull
  private Long cclIdPerson;

  @NonNull
  private Long cclIdOrigen;

  @NonNull
  private Long stdIdLegEnt;

  @NonNull
  private Long cclIdSeccion;

  @NonNull
  private Date fecha;

  @NonNull
  private Long minutos;

  private Integer idTipoHora;

  private Boolean activo;

}
