package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class TareaAmbitoGlobalLocalizacionPersonaDesplazamientoDto implements Serializable {

  private static final long serialVersionUID = 8643089032888418145L;

  private String id;

  private Long idTarea;

  private String stdIdWorkLocat;

  private String cclIdPerson;

  private String cclIdOrigen;

  private String stdIdLegEnt;

}
