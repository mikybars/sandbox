package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class TareaAmbitoGlobalLocalizacionPersonaPresenciaDto implements Serializable {

  private static final long serialVersionUID = 5072975705443047327L;

  private String id;

  private Long idTarea;

  private String cclIdCodOrigen;

  private String cclIdPerson;

  private String cclIdOrigen;

  private String stdIdLegEnt;

}
