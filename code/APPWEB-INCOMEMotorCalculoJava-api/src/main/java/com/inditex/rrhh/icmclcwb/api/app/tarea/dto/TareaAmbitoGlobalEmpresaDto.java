package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class TareaAmbitoGlobalEmpresaDto implements Serializable {

  private Long id;

  private Long idTarea;

  private String cclIdOrigen;

  private String stdIdLegEnt;

}
