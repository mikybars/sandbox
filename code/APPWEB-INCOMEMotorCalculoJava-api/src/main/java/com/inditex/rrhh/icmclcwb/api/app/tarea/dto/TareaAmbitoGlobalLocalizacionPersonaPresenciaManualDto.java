package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class TareaAmbitoGlobalLocalizacionPersonaPresenciaManualDto implements Serializable {

  private static final long serialVersionUID = 1093226387328683471L;

  private String id;

  private Long idTarea;

  private String stdIdWorkLocat;

  private String cclIdPerson;

  private String cclIdOrigen;

  private String stdIdLegEnt;

}
