package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class TareaAmbitoGlobalLocalizacionDto implements Serializable {

  private static final long serialVersionUID = 2149047890747327068L;

  private String id;

  private Long idTarea;

  private String stdIdWorkLocat;

  private String cclIdOrigen;

  private String stdIdLegEnt;

}
