package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class TareaAgrupacionCadenaDto implements Serializable {

  private static final long serialVersionUID = -8140438304912881020L;

  private String id;

  private Long idTarea;

  private String cclIdOrigen;

  private String icmIdAgrupacionOnline;

  private String cclIdCadena;

}
